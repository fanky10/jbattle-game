package com.doinfinite.training.javabasico.entidades;

public class Turret extends EarthUnit {

	public Turret(Integer health) {
		super(health);
	}
	
	public Turret(){
		this(100);
	}

	@Override
	public void defiende(int ataque) {
		health = health - ataque/3;
		
	}

	@Override
	public int ataca() {
		// TODO Auto-generated method stub
		return 20;
	}

}
