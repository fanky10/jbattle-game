package com.doinfinite.battlegame.model.air;

public class Airplane extends AirUnit {

	
	
	





	public Airplane(Integer health, Integer speed, Integer accuracy) {
		super(health, speed, accuracy);
		// TODO Auto-generated constructor stub
	}

	public Airplane() {
		
		this(100,50,10);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void defiende(int ataque) {
		health = health - ataque*3;
	}

	@Override
	public int ataca() {
		return 90;
	}
}
