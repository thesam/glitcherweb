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

@Entity
public class Glitch implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String content;
	private Glitcher glitcher;
	private Date createdAt;
	private Date updatedAt;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	@Column(nullable=false, length=4000)
	public String getContent() {
		return content;
	}
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="glitcher_id")
	public Glitcher getGlitcher() {
		return glitcher;
	}
	@Column(updatable=false, insertable=false, name="created_at")
	public Date getCreatedAt() {
		return createdAt;
	}
	@Column(updatable=false, insertable=false, name="updated_at")
	public Date getUpdatedAt() {
		return updatedAt;
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
