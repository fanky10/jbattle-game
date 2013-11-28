package com.doinfinite.battlegame.model.earth;

public class Troop extends EarthUnit {

	

	public Troop(Integer health, Integer speed, Integer accuracy) {
		super(health, speed, accuracy);
		// TODO Auto-generated constructor stub
	}

	public Troop() {
		this(100,50,10);
	}

	@Override
	public void defiende(int ataque) {
		health = health - ataque * 3;
	}

	@Override
	public int ataca() {
		return 10;
	}

}
