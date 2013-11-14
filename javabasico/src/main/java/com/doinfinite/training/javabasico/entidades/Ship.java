package com.doinfinite.training.javabasico.entidades;

public class Ship extends WaterUnit {

	public Ship(Integer health) {
		super(health);
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
