package com.doinfinite.training.javabasico;

import com.doinfinite.training.javabasico.entidades.Avion;
import com.doinfinite.training.javabasico.entidades.HeavyTank;
import com.doinfinite.training.javabasico.entidades.ObjetoAtacable;
import com.doinfinite.training.javabasico.entidades.QuickTank;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		ObjetoAtacable[] atacables = new ObjetoAtacable[3];
		atacables[0] = new QuickTank(100);
		atacables[1] = new HeavyTank(50);
		atacables[2] = new Avion();

		for (ObjetoAtacable atacable : atacables) {
			atacable.ataca();
			atacable.defiende(100);
			
		}
	}
}
