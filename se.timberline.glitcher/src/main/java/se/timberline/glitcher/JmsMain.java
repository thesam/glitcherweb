package se.timberline.glitcher;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import se.timberline.glitcher.alerts.AlertService;
import se.timberline.glitcher.alerts.AlertServiceImpl;
import se.timberline.glitcher.domain.Glitch;

public class JmsMain {
	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext(
				"META-INF/spring/app-context.xml");
		Object bean = factory.getBean("alertService");
		AlertService alertService = (AlertService) bean;
		
		Glitch glitch = new Glitch();
		glitch.setContent("Test content");
		
		System.out.println("Sending glitch with content: " + glitch.getContent());
		alertService.sendGlitchAlert(glitch);

		Glitch alert = alertService.getAlert();
		System.out.println("Received glitch with content: " + alert.getContent());
		
		System.out.println("Exiting...");
	}
}
