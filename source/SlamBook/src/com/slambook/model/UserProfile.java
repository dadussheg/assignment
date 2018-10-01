package com.slambook.model;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * @author aditya
 *
 */
public class UserProfile {
	private Long userProfileId;
	private String email;
	public String getEmail() {
		return email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserProfile other = (UserProfile) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String username;
	private String password;
	/**
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	public Long getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(Long userProfileId) {
		this.userProfileId = userProfileId;
	}
	
	

}
