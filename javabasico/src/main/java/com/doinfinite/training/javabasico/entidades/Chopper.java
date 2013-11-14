package com.doinfinite.training.javabasico.entidades;

public class Chopper extends AirUnit {

	public Chopper(Integer health) {
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
		return 20;
	}

}
