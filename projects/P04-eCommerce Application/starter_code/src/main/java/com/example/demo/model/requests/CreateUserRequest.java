package com.example.demo.model.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class CreateUserRequest {

	@JsonProperty
	private @Getter @Setter
	String username;

	@JsonProperty
	private @Getter @Setter String password;

	@JsonProperty
	private @Getter @Setter String confirmPassword;

}
