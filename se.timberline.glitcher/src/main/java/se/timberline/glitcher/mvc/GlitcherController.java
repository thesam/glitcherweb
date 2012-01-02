package se.timberline.glitcher.mvc;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import se.timberline.glitcher.GlitcherService;
import se.timberline.glitcher.domain.Glitcher;

@Controller
@RequestMapping("/glitchers")
public class GlitcherController {
    private final GlitcherService glitcherService;
    
    @Inject
    public GlitcherController(GlitcherService glitcherService) {
        this.glitcherService = glitcherService;
    }
    
    @RequestMapping(value="/glitches", method=RequestMethod.GET)
    public String listGlitchesForGlitcher(
            @RequestParam("glitcher")
            String username,
            Model model) {
        
        Glitcher glitcher = glitcherService.getGlitcher(username);
        model.addAttribute(glitcher);
        model.addAttribute(glitcher.getGlitches());
        
        return "glitches/list";
    }
            
}
