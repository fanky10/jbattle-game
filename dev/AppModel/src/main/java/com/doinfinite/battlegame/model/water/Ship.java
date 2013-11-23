package com.doinfinite.battlegame.model.water;

public class Ship extends WaterUnit {

	public Ship(Integer health) {
		super(health);
		// TODO Auto-generated constructor stub
	}
	
	
	public Ship() {
		
		this(100);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void defiende(int ataque) {
		health = health - ataque/3;
		
	}

	@Override
	public int ataca() {
		// TODO Auto-generated method stub
		return 50;
	}

}
