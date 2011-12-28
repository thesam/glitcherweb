package se.timberline.glitcher;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import se.timberline.glitcher.domain.Glitch;

// added comment

public class Main {

	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext(
				"META-INF/spring/app-context.xml");
		
		GlitcherService service = factory.getBean("glitcherService", GlitcherService.class);
		List<Glitch> glitches = service.getRecentGlitches(2);
		for (Glitch g : glitches) {
			System.out.println("Glitcher: " + g.getGlitcher().getFullname());
			System.out.println("Content: " + g.getContent());
		}
	}
}
