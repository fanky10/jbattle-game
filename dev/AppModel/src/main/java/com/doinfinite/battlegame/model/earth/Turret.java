package com.doinfinite.battlegame.model.earth;

public class Turret extends EarthUnit {

	public Turret(Integer health) {
		super(health);
		// TODO Auto-generated constructor stub
	}
	
	

	public Turret() {
		
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
		return 50;
	}



	@Override
	public void menu() {
		// TODO Auto-generated method stub
		
	}

}
