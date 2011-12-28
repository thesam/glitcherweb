package se.timberline.glitcher;

import java.util.List;

import se.timberline.glitcher.domain.Glitch;

public interface GlitcherService {

	List<Glitch> getRecentGlitches(int defaultGlitchesPerPage);

}
