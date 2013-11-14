package com.doinfinite.battlegame.model.earth;

public class LightTank extends Tank {

	public LightTank(Integer health) {
		super(health);
	}

	@Override
	public void defiende(int ataque) {
		health = health - ataque;
	}

	@Override
	public int ataca() {
		return 10;
	}

}
