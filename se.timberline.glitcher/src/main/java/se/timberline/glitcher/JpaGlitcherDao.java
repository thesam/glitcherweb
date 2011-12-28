package se.timberline.glitcher;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import se.timberline.glitcher.domain.Glitcher;

@Repository("glitcherDao")
@Transactional
public class JpaGlitcherDao implements GlitcherDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void addGlitcher(Glitcher glitcher) {
		em.persist(glitcher);
	}

	
}
