package com.slambook.model;

import java.util.Date;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class UserDetails {
	private String firstName;
	private String middleName;
	private String surName;
	private Date dateOfBirth;
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	@Override
	public String toString() {
	    return ReflectionToStringBuilder.toString(this);
	}
	/*@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}
	 @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result
	                + ((importantField == null) ? 0 : importantField.hashCode());
	        return result;
	    }*/
	

}
