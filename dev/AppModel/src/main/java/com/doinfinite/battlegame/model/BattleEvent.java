package com.doinfinite.battlegame.model;

public class BattleEvent {
	private String message;
	
	public BattleEvent(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
