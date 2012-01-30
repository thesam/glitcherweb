package se.timberline.glitcher.mvc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import se.timberline.glitcher.GlitcherService;
import se.timberline.glitcher.domain.Glitch;
import se.timberline.glitcher.domain.Glitcher;

@Controller
@RequestMapping("/glitchers")
public class GlitcherController implements ServletContextAware {
	public final static int GLITCHES_ON_SHOW_PAGE = 5;
	private final GlitcherService glitcherService;
	private ServletContext servletContext;

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

	@RequestMapping(method = RequestMethod.GET, params = "new")
	public String createGlitcherProfile(Model model) {
		model.addAttribute(new Glitcher());

		return "glitchers/edit";
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String showGlitcherProfile(@PathVariable String username, Model model) {
		Glitcher glitcher = glitcherService.getGlitcher(username);
		model.addAttribute(glitcher);
		model.addAttribute(
				"glitches",
				glitcher.getGlitches()
						.subList(
								0,
								GLITCHES_ON_SHOW_PAGE < glitcher.getGlitches()
										.size() ? GLITCHES_ON_SHOW_PAGE
										: glitcher.getGlitches().size()));
		return "glitchers/view";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addGlitcherFromForm(@Valid Glitcher glitcher,
			BindingResult bindingResult,
			@RequestParam(value = "image", required = false) MultipartFile image) {
		if (glitcherService.getGlitcher(glitcher.getUsername()) != null) {
			bindingResult.rejectValue("username", "Glitcher.duplicateUsername",
					"Username has already been taken");
		}
        if (glitcherService.getGlitcher(glitcher.getUsername()) != null)
            bindingResult.rejectValue("username", "Glitcher.duplicateUsername", "Username has already been taken");
		if (bindingResult.hasErrors()) {
			return "glitchers/edit";
		}

		glitcherService.createGlitcher(glitcher);

		try {
			if (image != null && !image.isEmpty()) {
				validateImage(image);
				saveImage(glitcher.getId() + ".jpg", image);
			}
		} catch (ImageUploadException e) {
			bindingResult.reject(e.getMessage());
			return "glitchers/edit";
		}

		return "redirect:/glitchers/" + glitcher.getUsername();
	}

	private void saveImage(String filename, MultipartFile image) {
		try {
			String webRootPath = servletContext.getRealPath("/resources/") + "/";
			File file = new File(webRootPath + filename);
			writeByteArrayToFile(file, image.getBytes());
		} catch (IOException e) {
			throw new ImageUploadException("Unable to save image", e);
		}
	}

	private void writeByteArrayToFile(File file, byte[] bytes)
			throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(bytes);
		fos.close();
	}

	private void validateImage(MultipartFile image) {
		if (!image.getContentType().equals("image/jpeg")) {
			throw new ImageUploadException("Only JPG images accepted");
		}
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
