package se.timberline.glitcher.mvc;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import se.timberline.glitcher.GlitcherService;
import se.timberline.glitcher.domain.Glitch;

@Controller
@RequestMapping("/rest/glitches")
public class GlitchController {
	private GlitcherService glitcherService;
	
	@Inject
	public GlitchController(GlitcherService glitcherService) {
		this.glitcherService = glitcherService;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public @ResponseBody String getGlitch(@PathVariable("id") long id) {
		System.err.println("Trying to get glitch with REST!");
		Glitch glitch = glitcherService.getGlitchById(id);
		System.err.println("Got glitch with id: " + glitch.getId());
		return glitch.getContent();
	}
}
