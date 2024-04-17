package com.example.thecommerce.user.enums;

public enum UserSort {
	CREATED_ASC("createdAsc"),
	NAMEKOR_ASC("nameKorAsc");
	private final String value;
	UserSort(String value) {
		this.value=value;
	}
	public String getValue() { return value; }
}
