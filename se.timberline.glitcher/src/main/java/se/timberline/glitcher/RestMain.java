package se.timberline.glitcher;

import org.springframework.web.client.RestTemplate;

import se.timberline.glitcher.domain.Glitch;

public class RestMain {
	public static void main(String[] args) {
		Glitch glitchWithId1 = getGlitchWithId1();
		System.out.println("Fetched Glitch with REST. Id: " + glitchWithId1.getId() + " Content: " + glitchWithId1.getContent());
	}

	private static Glitch getGlitchWithId1() {
		return new RestTemplate().getForObject("http://localhost:8080/se.timberline.glitcher/rest/glitches/1",Glitch.class);
	}
}
