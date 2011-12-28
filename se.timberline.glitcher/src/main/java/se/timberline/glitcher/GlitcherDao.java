package se.timberline.glitcher;

import se.timberline.glitcher.domain.Glitcher;

public interface GlitcherDao {
	
	/**
	 * Add a new Glitcher to persistence.
	 * @param glitcher Glitcher to add.
	 */
	public void addGlitcher(Glitcher glitcher);
	
	/**
	 * Update already persisted Glitcher.
	 * @param glitcher Glitcher to update.
	 */
	public void saveGlitcher(Glitcher glitcher);
	
	/**
	 * Get a Glitcher by persistence ID.
	 * @param id ID.
	 * @return Glitcher with given ID, or <code>null</code> if
	 * none was found.
	 */
	public Glitcher getGlitcherById(long id);
}
