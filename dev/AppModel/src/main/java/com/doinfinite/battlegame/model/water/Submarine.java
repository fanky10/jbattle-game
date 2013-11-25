package com.doinfinite.battlegame.model.water;

public class Submarine extends WaterUnit {

	public Submarine(Integer health) {
		super(health);
	}

	public Submarine() {
		this(100);
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
