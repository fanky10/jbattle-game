package com.doinfinite.training.javabasico.entidades;

public class HeavyTank extends Tank{
	
	public HeavyTank(Integer health) {
		super(health);
	}
	
	public HeavyTank(){
		this(100);
	}

	@Override
	public void defiende(int ataque) {
		health = health - ataque/2;
	}

	@Override
	public int ataca() {
		return 20;
	}

}
