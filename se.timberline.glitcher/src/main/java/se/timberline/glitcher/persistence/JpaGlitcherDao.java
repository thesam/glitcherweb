package se.timberline.glitcher.persistence;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import se.timberline.glitcher.GlitcherDao;
import se.timberline.glitcher.domain.Glitch;
import se.timberline.glitcher.domain.Glitcher;

@Repository("glitcherDao")
public class JpaGlitcherDao implements GlitcherDao {
	private final static String RECENT_GLITCHES = "SELECT g FROM Glitch g ORDER BY updatedAt DESC";
	private final static String GLITCHER_BY_USERNAME =
	        "SELECT DISTINCT g FROM Glitcher g LEFT JOIN FETCH g.glitches glitch WHERE g.username = ?1 ORDER BY glitch.updatedAt DESC";
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addGlitcher(Glitcher glitcher) {
		em.persist(glitcher);
	}

	@Override
	public void saveGlitcher(Glitcher glitcher) {
		em.merge(glitcher);
	}
	
	@Override
	public void addGlitch(Glitch glitch) {
	    em.persist(glitch);
	}

	@Override
	public Glitcher getGlitcherById(long id) {
		return em.find(Glitcher.class, id);
	}

	@Override
	public List<Glitch> getGlitchesByQuery(Query q, Object... params) {
		return getByQuery(Glitch.class, q, -1, params);
	}

	@Override
	public List<Glitch> getLimitedGlitchesByQuery(Query q, int numberOfResults,
			Object... params) {
		return getByQuery(Glitch.class, q, numberOfResults, params);
	}
	
	@Override
    public List<Glitcher> getGlitchersByQuery(Query q, Object... params) {
        return getByQuery(Glitcher.class, q, -1, params);
    }

    @Override
    public List<Glitcher> getLimitedGlitchersByQuery(Query q,
            int numberOfResults, Object... params) {
        return getByQuery(Glitcher.class, q, numberOfResults, params);
    }
    
    // Get a list of Glitchers/Glitches by a named query and limit the number of results.
    private <T> List<T> getByQuery(Class<T> c, Query q, int numberOfResults, Object[] params) {
        TypedQuery<T> query = em.createQuery(getNamedQuery(q), c);
        if (numberOfResults > 0)
            query.setMaxResults(numberOfResults);
        for (int i = 0; i < params.length; ++i)
            query.setParameter(i+1, params[i]);
        
        return query.getResultList();
    }

	// Get the JPA Query string corresponding to the given query name.
	private String getNamedQuery(Query q) {
		String result = null;
		switch (q) {
		case RECENT_GLITCHES:
			result = RECENT_GLITCHES;
			break;
		case GLITCHER_BY_USERNAME:
		    result = GLITCHER_BY_USERNAME;
		    break;
		}
		if (result == null)
			throw new IllegalArgumentException("Given query does not exist");
		
		return result;
	}

	@Override
	public Glitch getGlitchById(long id) {
		return em.find(Glitch.class, id);
	}
}
