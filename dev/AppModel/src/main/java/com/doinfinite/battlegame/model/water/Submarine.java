package com.doinfinite.battlegame.model.water;

public class Submarine extends WaterUnit {

	

	public Submarine(Integer health, Integer speed, Integer accuracy) {
		super(health, speed, accuracy);
		// TODO Auto-generated constructor stub
	}

	public Submarine() {
		this(100,50,10);
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
