package com.doinfinite.battlegame.model.air;

public class Chopper extends AirUnit {

	public Chopper(Integer health) {
		super(health);
		// TODO Auto-generated constructor stub
	}
	
	

	public Chopper() {
		
		this(100);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void defiende(int ataque) {
		health = health - ataque;
		
	}

	@Override
	public int ataca() {
		// TODO Auto-generated method stub
		return 20;
	}

}
