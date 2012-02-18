package se.timberline.glitcher;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import se.timberline.glitcher.domain.Glitch;

// added comment

public class Main {

	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext(
				"META-INF/spring/app-context.xml");
		
//		GlitcherService service = factory.getBean("glitcherService", GlitcherService.class);
//		List<Glitch> glitches = service.getRecentGlitches(2);
//		listGlitches(glitches);
//		
//		Glitcher glitcher = service.getGlitcher("someone");
//		System.out.println("Glitcher fullname: " + glitcher.getFullname());
//		listGlitches(glitcher.getGlitches());
		List<GlitcherService> remoteServices = new ArrayList<GlitcherService>();
		remoteServices.add(factory.getBean("RemoteGlitcherService", GlitcherService.class));
		remoteServices.add(factory.getBean("RemoteHttpInvokerGlitcherService", GlitcherService.class));
		
		// FIXME: These do not work right now, but they should work like the ones above.
//		remoteServices.add(factory.getBean("RemoteHessianGlitcherService", GlitcherService.class));
//		remoteServices.add(factory.getBean("RemoteBurlapGlitcherService", GlitcherService.class));
		
		for (GlitcherService service : remoteServices) {
			listGlitches(service.getRecentGlitches(10));
		}
	}
	
	private static void listGlitches(List<Glitch> glitches) {
	    for (Glitch g : glitches) {
            System.out.println("Glitcher: " + g.getGlitcher().getFullname());
            System.out.println("Content: " + g.getContent());
        }
	}
}
