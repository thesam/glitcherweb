package se.timberline.glitcher;

import java.util.List;

import se.timberline.glitcher.domain.Glitch;
import se.timberline.glitcher.domain.Glitcher;

public interface GlitcherService {

	/**
	 * Create a new glitcher in persistence.
	 * @param glitcher Glitcher to create.
	 */
	void createGlitcher(Glitcher glitcher);
	
	/**
	 * Save an existing Glitcher in persistence.
	 * @param glitcher Glitcher to save.
	 */
	void saveGlitcher(Glitcher glitcher);
	
	/**
	 * Get recently updated glitches.
	 * @param defaultGlitchesPerPage Number of glitches to get.
	 * @return A list of recent glitches.
	 */
	List<Glitch> getRecentGlitches(int defaultGlitchesPerPage);

}
