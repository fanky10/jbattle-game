package com.doinfinite.battlegame.model.earth;

public class Troop extends EarthUnit {

	public Troop(Integer health) {
		super(health);
	}

	public Troop() {
		this(100);
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
