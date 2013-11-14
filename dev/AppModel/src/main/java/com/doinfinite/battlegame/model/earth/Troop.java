package com.doinfinite.battlegame.model.earth;

public class Troop extends EarthUnit {

	public Troop(Integer health) {
		super(health);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void defiende(int ataque) {
		health = health - ataque*3;

	}

	@Override
	public int ataca() {
		// TODO Auto-generated method stub
		return 10;
	}

}
