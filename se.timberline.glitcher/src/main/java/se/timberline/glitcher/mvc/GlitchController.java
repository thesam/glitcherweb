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

@Controller
@RequestMapping("/rest/glitches")
public class GlitchController {
	private GlitcherService glitcherService;
	
	@Inject
	public GlitchController(GlitcherService glitcherService) {
		this.glitcherService = glitcherService;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody Glitch getGlitch(@PathVariable("id") long id, @RequestHeader("Accept") String acceptHeader) {
		System.err.println("Trying to get glitch with REST! Accept header: " + acceptHeader);
		Glitch glitch = glitcherService.getGlitchById(id);
		System.err.println("Got glitch with id: " + glitch.getId());
		//TODO: Do this in a nicer way. This is done to avoid an endless recursion since Glitch has a Glitcher which has Glitches which have Glitchers..
		glitch.setGlitcher(null);
		return glitch;
	}
	
	/**
	 * Returns glitch content as plain text. Fallback for GET requests that are not covered by the methods above.
	 * 
	 * @param id
	 * @param acceptHeader
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public @ResponseBody String getGlitchContent(@PathVariable("id") long id, @RequestHeader("Accept") String acceptHeader) {
		System.err.println("Trying to get glitch with REST! Accept header: " + acceptHeader);
		Glitch glitch = glitcherService.getGlitchById(id);
		System.err.println("Got glitch with id: " + glitch.getId());
		return glitch.getContent();
	}
}
