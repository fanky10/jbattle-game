package com.doinfinite.battlegame.model.earth;

public class Antiaircraft extends EarthUnit {

	

	public Antiaircraft(Integer health, Integer speed, Integer accuracy) {
		super(health, speed, accuracy);
		// TODO Auto-generated constructor stub
	}

	public Antiaircraft() {
		this(100,50,10);
	}

	@Override
	public void defiende(int ataque) {
		health = health - ataque;
	}

	@Override
	public int ataca() {
		return 70;
	}

}
