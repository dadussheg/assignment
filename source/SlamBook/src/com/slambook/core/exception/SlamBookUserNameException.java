package com.slambook.core.exception;

public class SlamBookUserNameException extends RuntimeException{
	public SlamBookUserNameException(String usernameErrorMessage) {
		super(usernameErrorMessage);
	}

}
