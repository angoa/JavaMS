package com.demo.model;

public class JsonObject {

	private Integer integer;
	private Boolean bool;
	private String string;

	public JsonObject() {
	}

	public Integer getInteger() {
		return integer;
	}

	public void setInteger(Integer integer) {
		this.integer = integer;
	}

	public Boolean getBool() {
		return bool;
	}

	public void setBool(Boolean bool) {
		this.bool = bool;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return "JsonObject [integer=" + integer + ", bool=" + bool + ", string=" + string + "]";
	}

}
