package se.timberline.glitcher.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Glitches implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private List<Glitch> glitches;
    
    public Glitches() {}
    
    public Glitches(List<Glitch> glitches) {
        this.glitches = glitches;
    }
    
    @XmlElements({
        @XmlElement(name="glitch", type=Glitch.class)
    })
    public List<Glitch> getGlitches() {
        return glitches;
    }

    public void setGlitches(List<Glitch> glitches) {
        this.glitches = glitches;
    }
}
