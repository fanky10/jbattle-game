package com.doinfinite.battlegame.model.earth;

public class Turret extends EarthUnit {

	

	public Turret(Integer health, Integer speed, Integer accuracy) {
		super(health, speed, accuracy);
		// TODO Auto-generated constructor stub
	}

	public Turret() {
		this(100,50,10);
	}

	@Override
	public void defiende(int ataque) {
		health = health - ataque;
	}

	@Override
	public int ataca() {
		return 50;
	}

}
