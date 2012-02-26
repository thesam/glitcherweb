package se.timberline.glitcher.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Glitchers implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Glitcher> glitchers;
    
    public Glitchers() {}
    
    public Glitchers(List<Glitcher> glitchers) {
        this.glitchers = glitchers;
    }
    
    
    @XmlElements({
        @XmlElement(name="glitcher", type=Glitcher.class)
    })
    public List<Glitcher> getGlitchers() {
        return glitchers;
    }
    public void setGlitchers(List<Glitcher> glitchers) {
        this.glitchers = glitchers;
    }
}
