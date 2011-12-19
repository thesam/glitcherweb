package se.timberline.glitcher;

public class Greeter {
	private String yourName;

	public void setYourName(String name) {
		this.yourName = name;
	}
	
	public void greet() {
		System.out.println("Hello, " + yourName + "!");
	}
}
