package com.doinfinite.training.javabasico.entidades;

public class Airplane extends AirUnit {

	public Airplane(Integer health) {
		super(health);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void defiende(int ataque) {
	}

	@Override
	public int ataca() {
		return 0;
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

}
