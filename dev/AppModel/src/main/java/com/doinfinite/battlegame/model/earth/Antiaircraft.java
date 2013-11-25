package com.doinfinite.battlegame.model.earth;

public class Antiaircraft extends EarthUnit {

	public Antiaircraft(Integer health) {
		super(health);
	}

	public Antiaircraft() {
		this(100);
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
