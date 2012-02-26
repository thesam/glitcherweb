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
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void createGlitch(Glitch glitch, String username) {
	    Glitcher glitcher = this.getGlitcher(username);
	    glitch.setGlitcher(glitcher);
	    dao.addGlitch(glitch);
	}
	
	@Override
	public List<Glitch> getAllGlitches() {
	    return dao.getGlitchesByQuery(GlitcherDao.Query.RECENT_GLITCHES);
	}

    @Override
    public Glitcher getGlitcher(String username) {
        List<Glitcher> glitchers = dao.getGlitchersByQuery(GlitcherDao.Query.GLITCHER_BY_USERNAME, username);
        if (glitchers.size() == 0)
            return null;
        else
            return glitchers.get(0);
    }
    
    public Glitcher getGlitcher(String username, String password) {
        List<Glitcher> glitchers = dao.getGlitchersByQuery(GlitcherDao.Query.GLITCHER_BY_USERNAME, username);
        if (glitchers.size() == 0 || !glitchers.get(0).getPassword().equals(password)) {
            throw new GlitcherNotFoundException("Glitcher with the given password was not found");
        }
        return glitchers.get(0);
    }

	@Override
	public Glitch getGlitchById(long id) {
		return dao.getGlitchById(id);
	}

}
