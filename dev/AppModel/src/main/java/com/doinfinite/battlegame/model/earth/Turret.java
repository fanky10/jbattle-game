package com.doinfinite.battlegame.model.earth;

public class Turret extends EarthUnit {

	public Turret(Integer health) {
		super(health);
	}

	public Turret() {
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
