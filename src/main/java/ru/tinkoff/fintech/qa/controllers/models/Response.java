package ru.tinkoff.fintech.qa.controllers.models;

public class Response{
	private int code;
	private String type;
	private String message;

	public int getCode(){
		return code;
	}

	public String getType(){
		return type;
	}

	public String getMessage(){
		return message;
	}
}
