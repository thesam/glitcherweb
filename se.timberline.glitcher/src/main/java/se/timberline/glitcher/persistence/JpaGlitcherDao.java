package se.timberline.glitcher.persistence;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import se.timberline.glitcher.GlitcherDao;
import se.timberline.glitcher.domain.Glitcher;

@Repository("glitcherDao")
public class JpaGlitcherDao implements GlitcherDao {
	
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

	
}
