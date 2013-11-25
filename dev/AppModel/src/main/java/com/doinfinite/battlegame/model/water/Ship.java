package com.doinfinite.battlegame.model.water;

public class Ship extends WaterUnit {

	public Ship(Integer health) {
		super(health);
	}

	public Ship() {
		this(100);
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
