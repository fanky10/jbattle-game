package com.doinfinite.battlegame.model.earth;

public class HeavyTank extends Tank{
	
	public HeavyTank(Integer health) {
		super(health);
		// TODO Auto-generated constructor stub
	}
	
	

	public HeavyTank() {
		this(100);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void defiende(int ataque) {
		health = health - ataque/2;
	}

	@Override
	public int ataca() {
		return 20;
	}



	@Override
	public void menu() {
		// TODO Auto-generated method stub
		
	}

}
