package com.doinfinite.battlegame.model.earth;

public class LightTank extends Tank {

	

	public LightTank(Integer health, Integer speed, Integer accuracy) {
		super(health, speed, accuracy);
		// TODO Auto-generated constructor stub
	}

	public LightTank() {
		this(100,50,10);
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
