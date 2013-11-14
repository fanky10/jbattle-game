package com.doinfinite.battlegame.model.water;

public class Submarine extends WaterUnit {

	public Submarine(Integer health) {
		super(health);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void defiende(int ataque) {
		health = health - ataque;
		
	}

	@Override
	public int ataca() {
		// TODO Auto-generated method stub
		return 50;
	}

}
