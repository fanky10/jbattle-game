package com.doinfinite.battlegame.model.earth;

public class HeavyTank extends Tank {

	

	public HeavyTank(Integer health, Integer speed, Integer accuracy) {
		super(health, speed, accuracy);
		// TODO Auto-generated constructor stub
	}

	public HeavyTank() {
		this(100,50,10);
	}

	@Override
	public void defiende(int ataque) {
		health = health - ataque / 2;
	}

	@Override
	public int ataca() {
		return 20;
	}

}
