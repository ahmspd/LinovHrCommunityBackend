package com.lawencon.linovhrcommunity.dto.user;

public class InsertUserDtoRes {
	private String message;
	private InsertUserDtoDataRes data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public InsertUserDtoDataRes getData() {
		return data;
	}
	public void setData(InsertUserDtoDataRes data) {
		this.data = data;
	}
}
