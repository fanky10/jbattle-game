package com.doinfinite.battlegame.web.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class UserForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull(message="{signup.error.username.required}")
	@NotBlank(message="{signup.error.username.required}")
	private String username;
	@NotNull(message="{signup.error.firstName.required}")
	@NotBlank(message="{signup.error.firstName.required}")
	private String firstName;
	@NotNull(message="{signup.error.lastName.required}")
	@NotBlank(message="{signup.error.lastName.required}")
	private String lastName;
	@NotNull(message="{signup.error.email.required}")
	@NotBlank(message="{signup.error.email.required}")
	@Email
	private String email;
	@NotNull(message="{signup.error.password.required}")
	@NotBlank(message="{signup.error.password.required}")
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
