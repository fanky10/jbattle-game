package com.doinfinite.battlegame.model.earth;

public class Troop extends EarthUnit {

	public Troop(Integer health) {
		super(health);
		// TODO Auto-generated constructor stub
	}
	
	

	public Troop() {
		this(100);
		
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



	@Override
	public void menu() {
		// TODO Auto-generated method stub
		
	}

}
