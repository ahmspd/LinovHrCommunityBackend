package com.lawencon.linovhrcommunity.dto.role;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class InsertRoleDtoReq {
	@NotEmpty(message = "Error: Role Code is Empty! Please fill Role Code.")
	@Size(min = 5, max = 10, message = "Error: Role Code max 10 character!")
	private String code;

	@NotEmpty(message = "Error: Role Name is Empty! Please fill Role Name.")
	@Size(min = 5, max = 30, message = "Error: Role Name max 30 character!")
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
