package com.doinfinite.battlegameapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.doinfinite.battlegame.model.Unit;
import com.doinfinite.battlegame.model.air.Airplane;
import com.doinfinite.battlegame.model.air.Chopper;
import com.doinfinite.battlegame.model.earth.Antiaircraft;
import com.doinfinite.battlegame.model.earth.HeavyTank;
import com.doinfinite.battlegame.model.earth.LightTank;
import com.doinfinite.battlegame.model.earth.QuickTank;
import com.doinfinite.battlegame.model.earth.Troop;
import com.doinfinite.battlegame.model.earth.Turret;
import com.doinfinite.battlegame.model.water.Ship;
import com.doinfinite.battlegame.model.water.Submarine;
import com.doinfinite.battlegameapp.config.AppConfig;

public class Menu {
	private int maxHealth = AppConfig.getMaxHealth();

	public List<Unit> getSelectedUnitsByHealth() {

		List<Unit> selectedUnits = new ArrayList<Unit>();
		List<Unit> availableUnits = getAvailableUnits();
		int i = 1;
		for (Unit u : availableUnits) {
			System.out.println(i + ") " + u.getName() + " - health: "
					+ u.getHealth());
			i++;
		}

		System.out
				.println("Chose one of the units that are listed to add to your army you can pick a maximun of "
						+ maxHealth + " health in total, so choose wisely.");
		int totalHealth = 0;
		while (totalHealth < maxHealth) {
			int selectedOption = 0;
			String input = null;
			BufferedReader read1 = new BufferedReader(new InputStreamReader(
					System.in));

			try {
				input = read1.readLine();
				selectedOption = Integer.parseInt(input);

				if (selectedOption < 1
						|| selectedOption > availableUnits.size()) {
					System.out
							.println("You have choosen an invalid unit number, please select again");
				} else {
					Unit selectedUnit = availableUnits.get(selectedOption - 1);
					// check if you can add the corresponding unit
					if (maxHealth < (totalHealth + selectedUnit.getHealth())) {
						System.out
								.println("You cannot add such a big unit! try again with a different one!");
						System.out.println("Spaces left: "
								+ (maxHealth - totalHealth));
						continue;// next!
					} else {
						selectedUnits.add(selectedUnit);
						totalHealth += selectedUnit.getHealth();
						System.out.println(selectedUnit.getName() + " Added!");
						System.out.println("Spaces left: "
								+ (maxHealth - totalHealth));
					}

					if (totalHealth < maxHealth) {
						System.out.println("Pick your next unit!");
					} else {
						System.out.println("Selection is complete!");
					}

				}
			} catch (NumberFormatException ex) {
				System.out.println("Exception object: " + ex);
				System.out.println("Have you tried with a valid number?");
			} catch (IOException e) {
				System.out.println("Exception object: " + e);
				System.out.println("Have you tried with a valid number?");
			}
		}

		return selectedUnits;

	}

	private List<Unit> getAvailableUnits() {
		List<Unit> availableUnits = new ArrayList<Unit>();
		availableUnits.add(new Antiaircraft());
		availableUnits.add(new Airplane());
		availableUnits.add(new Chopper());
		availableUnits.add(new HeavyTank());
		availableUnits.add(new LightTank());
		availableUnits.add(new QuickTank());
		availableUnits.add(new Ship());
		availableUnits.add(new Submarine());
		availableUnits.add(new Troop());
		availableUnits.add(new Turret());
		
		return availableUnits;
	}

}