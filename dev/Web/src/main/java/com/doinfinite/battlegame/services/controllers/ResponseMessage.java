package com.doinfinite.battlegame.services.controllers;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonIgnoreProperties({})
@JsonPropertyOrder(value = { "code", "message", "content", "extras" })
public class ResponseMessage {

	public static final String MESSG_OK = "OK";
	public static final String CODE_OK = "0";
	public static final String MESSG_NO_OBJECT_MODIFIED = "No object modified";
	public static final String CODE_IMPERMISSIBLE = "-443";
	public static final String MESSG_IMPERMISSIBLE = "Impermissible";

	private String code;
	private String message;
	private Object content;
	private Map<String, Object> extras;

	ResponseMessage() {
		super();
		code = "-1";
		message = "NOT_SET";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public Map<String, Object> getExtras() {
		return extras;
	}

	public void setExtras(Map<String, Object> extras) {
		this.extras = extras;
	}

}
