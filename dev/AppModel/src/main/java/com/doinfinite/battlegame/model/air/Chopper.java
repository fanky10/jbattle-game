package com.doinfinite.battlegame.model.air;

public class Chopper extends AirUnit {

	

	public Chopper(Integer health, Integer speed, Integer accuracy) {
		super(health, speed, accuracy);
		// TODO Auto-generated constructor stub
	}

	public Chopper() {
		this(100,50,10);
	}

	@Override
	public void defiende(int ataque) {
		health = health - ataque;

	}

	@Override
	public int ataca() {
		return 20;
	}

}
