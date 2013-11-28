package com.doinfinite.battlegame.model.water;

public class Ship extends WaterUnit {

	

	public Ship(Integer health, Integer speed, Integer accuracy) {
		super(health, speed, accuracy);
		// TODO Auto-generated constructor stub
	}

	public Ship() {
		this(100,50,10);
	}

	@Override
	public void defiende(int ataque) {
		health = health - ataque / 3;
	}

	@Override
	public int ataca() {
		return 50;
	}
}
