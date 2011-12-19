package se.timberline.glitcher;

import java.util.List;

public interface GlitcherService {

	List<Glitch> getRecentGlitches(int defaultGlitchesPerPage);

}
