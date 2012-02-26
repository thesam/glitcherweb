package se.timberline.glitcher.mvc;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import se.timberline.glitcher.GlitcherService;
import se.timberline.glitcher.domain.Glitchers;

@Controller
@RequestMapping(value="/rest/glitchers", headers={"Accept=application/xml"})
public class RestGlitcherController {
    private GlitcherService service;
    
    @Inject
    public RestGlitcherController(GlitcherService glitcherService) {
        this.service = glitcherService;
    }
    
    
    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody Glitchers getAllGlitchers() {
        return new Glitchers(service.getAllGlitchers());
    }
}
