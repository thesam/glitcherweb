package se.timberline.glitcher;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import se.timberline.glitcher.mvc.HomeController;
import se.timberline.glitcher.service.GlitcherServiceImpl;

import static org.mockito.Mockito.*;

public class HomeControllerTest {
	@Test
	public void shouldDisplayRecentGlitches() throws Exception {
		List<Glitch> expectedGlitches = Arrays.asList(new Glitch(), new Glitch(),
				new Glitch());
		
		GlitcherService glitcherService = mock(GlitcherServiceImpl.class);
		
		when(glitcherService.getRecentGlitches(HomeController.DEFAULT_GLITCHES_PER_PAGE)).thenReturn(expectedGlitches);
		
		HomeController controller = new HomeController(glitcherService);
		
		HashMap<String, Object> model = new HashMap<String, Object>();
		String viewName = controller.showHomePage(model);
		
		assertEquals("home",viewName);
		
		assertSame(expectedGlitches,model.get("glitches"));
		verify(glitcherService).getRecentGlitches(HomeController.DEFAULT_GLITCHES_PER_PAGE);

	}
}
