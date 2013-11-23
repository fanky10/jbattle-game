package com.doinfinite.battlegame.model.earth;

public class QuickTank extends Tank {
	public QuickTank(Integer health) {
		super(health);
	}
	
	
	

	public QuickTank() {
		
		this(100);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void defiende(int ataque) {
		health = health - ataque * 2;
	}

	@Override
	public int ataca() {
		return 40;
	}

	public void avanza() {

	}
}
