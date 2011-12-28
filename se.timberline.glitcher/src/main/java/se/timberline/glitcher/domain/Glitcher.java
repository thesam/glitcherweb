package se.timberline.glitcher.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Glitcher implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String username;
	private String password;
	private String fullname;
	private Date createdAt;
	private Date updatedAt;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	@Column(nullable=false, unique=true, length=127)
	public String getUsername() {
		return username;
	}
	@Column(nullable=false, length=127)
	public String getPassword() {
		return password;
	}
	@Column(length=255)
	public String getFullname() {
		return fullname;
	}
	@Column(insertable=false, updatable=false, name="created_at")
	public Date getCreatedAt() {
		return createdAt;
	}
	@Column(insertable=false, updatable=false, name="updated_at")
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	
	public void setId(long id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Glitcher))
			return false;
		Glitcher other = (Glitcher) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}
