package com.app.custom_excs;

public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException(String mesg) {
		super(mesg);
	}
}
