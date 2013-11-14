package com.doinfinite.training.javabasico.entidades;

public class Airplane extends AirUnit {

	public Airplane(Integer health) {
		super(health);
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
