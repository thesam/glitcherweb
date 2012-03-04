package se.timberline.glitcher.alerts;

import se.timberline.glitcher.domain.Glitch;

public interface AlertService {
	public void sendGlitchAlert(Glitch glitch);
	
	public Glitch getAlert();
}
