package se.timberline.glitcher.mvc;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import se.timberline.glitcher.GlitcherService;
import se.timberline.glitcher.domain.Glitch;
import se.timberline.glitcher.domain.Glitcher;

@Controller
@RequestMapping("/glitchers")
public class GlitcherController {
    public final static int GLITCHES_ON_SHOW_PAGE = 5;
    private final GlitcherService glitcherService;
    
    @Inject
    public GlitcherController(GlitcherService glitcherService) {
        this.glitcherService = glitcherService;
    }
    
    @RequestMapping(value="/{username}/glitches", method=RequestMethod.GET)
    public String listGlitchesForGlitcher(
            @PathVariable
            String username,
            Model model) {
        
        Glitcher glitcher = glitcherService.getGlitcher(username);
        model.addAttribute(glitcher);
        model.addAttribute(glitcher.getGlitches());
        
        return "glitches/list";
    }
    
    @RequestMapping(value="/{username}/glitches", method=RequestMethod.GET, params="new")
    public String createGlitch(@PathVariable String username, Model model) {
        model.addAttribute(glitcherService.getGlitcher(username));
        model.addAttribute(new Glitch());
        
        return "glitches/edit";
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/{username}/glitches")
    public String addGlitchFromForm(@Valid Glitch glitch, BindingResult bindingResult, @PathVariable String username) {
        if (bindingResult.hasErrors()) {
            return "glitches/edit";
        }
        
        glitcherService.createGlitch(glitch, username);
        return "redirect:/glitchers/" + username;
    }
    
    @RequestMapping(method=RequestMethod.GET, params="new")
    public String createGlitcherProfile(Model model) {
        model.addAttribute(new Glitcher());
        
        return "glitchers/edit";
    }
    
    @RequestMapping(value="/{username}", method=RequestMethod.GET)
    public String showGlitcherProfile(@PathVariable String username, Model model) {
        Glitcher glitcher = glitcherService.getGlitcher(username);
        model.addAttribute(glitcher);
        model.addAttribute("glitches", glitcher.getGlitches().subList(0,
                GLITCHES_ON_SHOW_PAGE < glitcher.getGlitches().size() ? GLITCHES_ON_SHOW_PAGE : glitcher.getGlitches().size()));
        return "glitchers/view";
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String addGlitcherFromForm(@Valid Glitcher glitcher, BindingResult bindingResult) {
        if (glitcherService.getGlitcher(glitcher.getUsername()) != null)
            bindingResult.rejectValue("username", "Glitcher.duplicateUsername", "Username has already been taken");
        if (bindingResult.hasErrors()) {
            return "glitchers/edit";
        }
        
        glitcherService.createGlitcher(glitcher);
        
        return "redirect:/glitchers/" + glitcher.getUsername();
    }
}
