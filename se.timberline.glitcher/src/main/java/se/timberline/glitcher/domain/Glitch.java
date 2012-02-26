package se.timberline.glitcher.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement(name="glitch")
public class Glitch implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String content;
	private Glitcher glitcher;
	
	private Date createdAt;
	
	private Date updatedAt;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@XmlTransient
	public long getId() {
		return id;
	}
	@Column(nullable=false, length=4000)
	public String getContent() {
		return content;
	}
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="glitcher_id")
	@XmlIDREF
	public Glitcher getGlitcher() {
		return glitcher;
	}
	@Column(updatable=false, insertable=false, name="created_at")
	@XmlAttribute
	public Date getCreatedAt() {
		return createdAt;
	}
	@Column(updatable=false, insertable=false, name="updated_at")
	@XmlAttribute
	public Date getUpdatedAt() {
		return updatedAt;
	}
	@XmlID
	@Transient
	@XmlAttribute(name="id")
	public String getXmlId() {
	    return "/rest/glitches/" + String.valueOf(getId());
	}
	
	
	public void setId(long id) {
		this.id = id;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setGlitcher(Glitcher glitcher) {
		this.glitcher = glitcher;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
