package se.timberline.glitcher.mvc;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import se.timberline.glitcher.GlitcherService;
import se.timberline.glitcher.service.GlitcherServiceImpl;
import javax.inject.Inject;

@Controller
public class HomeController {
	public static final int DEFAULT_GLITCHES_PER_PAGE = 25;
	
	private GlitcherService glitcherService;
	
	@Inject
	public HomeController(GlitcherService glitcherService) {
		this.glitcherService = glitcherService;
	}
	
	@RequestMapping({"/","/home"})
	public String showHomePage(Map<String,Object> model) {
		model.put("glitches",glitcherService.getRecentGlitches(DEFAULT_GLITCHES_PER_PAGE));
		return "home";
	}
}
