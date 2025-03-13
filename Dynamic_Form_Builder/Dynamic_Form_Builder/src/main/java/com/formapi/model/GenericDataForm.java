package com.formapi.model;

public class GenericDataForm<T> {
	
	T formdata;

	public T getFormdata() {
		return formdata;
	}

	public void setFormdata(T formdata) {
		this.formdata = formdata;
	}
	
	

}
