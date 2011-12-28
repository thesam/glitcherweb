package se.timberline.glitcher.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import se.timberline.glitcher.GlitcherDao;
import se.timberline.glitcher.GlitcherService;
import se.timberline.glitcher.domain.Glitch;
import se.timberline.glitcher.domain.Glitcher;

@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class GlitcherServiceImpl implements GlitcherService {
	private GlitcherDao dao;
	
	public GlitcherServiceImpl() {}
	
	public void setGlitcherDao(GlitcherDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Glitch> getRecentGlitches(int defaultGlitchesPerPage) {
		return dao.getLimitedGlitchesByQuery(GlitcherDao.Query.RECENT_GLITCHES,
				defaultGlitchesPerPage);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void createGlitcher(Glitcher glitcher) {
		dao.addGlitcher(glitcher);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void saveGlitcher(Glitcher glitcher) {
		dao.saveGlitcher(glitcher);
	}

}
