package se.timberline.glitcher.mvc;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import se.timberline.glitcher.GlitcherService;
import se.timberline.glitcher.domain.Glitch;
import se.timberline.glitcher.domain.Glitches;

@Controller
@RequestMapping(value="/rest/glitches", headers={"Accept=application/xml"})
public class GlitchController {
	private GlitcherService glitcherService;
	
	@Inject
	public GlitchController(GlitcherService glitcherService) {
		this.glitcherService = glitcherService;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public @ResponseBody Glitch getGlitch(@PathVariable("id") long id, @RequestHeader("Accept") String acceptHeader) {
		System.err.println("Trying to get glitch with REST! Accept header: " + acceptHeader);
		Glitch glitch = glitcherService.getGlitchById(id);
		System.err.println("Got glitch with id: " + glitch.getId());
		//TODO: Return a proper Glitch.
		return glitch;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Glitches getGlitches( @RequestHeader("Accept") String acceptHeader) {
	    return new Glitches(glitcherService.getAllGlitches());
	}
	
	/**
	 * Returns glitch content as plain text. Fallback for GET requests that are not covered by the methods above.
	 * 
	 * @param id
	 * @param acceptHeader
	 * @return
	 */
//	@RequestMapping(value="/{id}",method=RequestMethod.GET)
//	public @ResponseBody String getGlitchContent(@PathVariable("id") long id, @RequestHeader("Accept") String acceptHeader) {
//		System.err.println("Trying to get glitch with REST! Accept header: " + acceptHeader);
//		Glitch glitch = glitcherService.getGlitchById(id);
//		System.err.println("Got glitch with id: " + glitch.getId());
//		return glitch.getContent();
//	}
}
