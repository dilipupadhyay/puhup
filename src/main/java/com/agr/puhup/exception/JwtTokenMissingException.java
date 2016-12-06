package com.agr.puhup.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Thrown when token cannot be found in the request header
 * 
 * @author Dilip Upadhyay
 */
public class JwtTokenMissingException extends AuthenticationException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 66348555901569541L;

	public JwtTokenMissingException(String msg) {
		super(msg);
	}
}
