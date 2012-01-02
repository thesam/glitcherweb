package se.timberline.glitcher;

import java.util.List;

import se.timberline.glitcher.domain.Glitch;
import se.timberline.glitcher.domain.Glitcher;

public interface GlitcherDao {
	enum Query {
		/**
		 * Find most recent glitches.
		 */
		RECENT_GLITCHES,
		
		/**
		 * Find a Glitcher by its username. Parameters:
		 * <ol>
		 *    <li>Glitchers username</li>
		 * </ol>
		 */
		GLITCHER_BY_USERNAME;
	}
	
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
	
	/**
	 * Get all glitchers using a named query.
	 * @param q The Query to use.
	 * @param params Parameters used in the query, if any.
	 * @return All glitchers.
	 */
	public List<Glitcher> getGlitchersByQuery(Query q, Object... params);
	
	/**
	 * Get a limited number of glitchers using the named query.
	 * @param q Query to use.
	 * @param numberOfResults Maximum number of results.
	 * @param params Parameters used in the query, if any.
	 * @return Found glitchers
	 */
	public List<Glitcher> getLimitedGlitchersByQuery(Query q, int numberOfResults, Object... params);
	
	/**
	 * Get all glitches using a named query. 
	 * @param q The Query to use.
	 * @param params Parameters used in the query, if any.
	 * @return All glitches.
	 */
	public List<Glitch> getGlitchesByQuery(Query q, Object... params);
	
	/**
	 * Get a limited number of glitches using the named Query.
	 * @param q Query to use.
	 * @param numberOfResults Maximum number of results to return.
	 * @param params Parameters to query.
	 * @return Found glitches.
	 */
	public List<Glitch> getLimitedGlitchesByQuery(Query q, int numberOfResults, Object... params);
}
