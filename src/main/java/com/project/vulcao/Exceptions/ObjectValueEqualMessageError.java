package com.project.vulcao.Exceptions;

public class ObjectValueEqualMessageError extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ObjectValueEqualMessageError(String msg) {
		super(String.format(msg));
	}
}
