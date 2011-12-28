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
	public Glitcher getGlitcherById(long id) {
		return em.find(Glitcher.class, id);
	}

	@Override
	public List<Glitch> getGlitchesByQuery(Query q, Object... params) {
		return getLimitedGlitchesByQuery(q, -1, params);
	}

	@Override
	public List<Glitch> getLimitedGlitchesByQuery(Query q, int numberOfResults,
			Object... params) {
		
		TypedQuery<Glitch> query = em.createQuery(getNamedQuery(q), Glitch.class);
		if (numberOfResults > 0)
			query.setMaxResults(numberOfResults);
		for (int i = 0; i < params.length; ++i) {
			query.setParameter(i+1, params[i]);
		}
		
		return query.getResultList();
	}

	// Get the JPA Query string corresponding to the given query name.
	private String getNamedQuery(Query q) {
		String result = null;
		switch (q) {
		case RECENT_GLITCHES:
			result = RECENT_GLITCHES;
			break;
		}
		if (result == null)
			throw new IllegalArgumentException("Given query does not exist");
		
		return result;
	}
}
