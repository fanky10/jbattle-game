package com.doinfinite.battlegameapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.doinfinite.battlegame.mocked.MockedUnits;
import com.doinfinite.battlegame.model.Unit;
import com.doinfinite.battlegameapp.config.AppConfig;

public class Menu {
	public static enum BattleType {
		MAX_HEALTH, THREE_UNITS, FIVE_UNITS,THREE_UNITS_IA
	};

	private BattleType battleType;
	
	public void show() {
		boolean validOpc = false;
		while (!validOpc) {
			try {
				System.out.println("Select which type of game you wanna play");
				System.out
						.println("1) Fixed max health with variable number of units between teams");
				System.out.println("2) 3v3 Units");
				System.out.println("3) 5v5 Units");
				System.out.println("4) 3v3 Units - IAvsIA");
				System.out.println("0) Exit");
				int selectedOption = 0;
				BufferedReader bufferReader = new BufferedReader(
						new InputStreamReader(System.in));
				String input = bufferReader.readLine();
				selectedOption = Integer.parseInt(input);
				if (selectedOption == 1) {
					battleType = BattleType.MAX_HEALTH;
				} else if (selectedOption == 2) {
					battleType = BattleType.THREE_UNITS;
				} else if (selectedOption == 3) {
					battleType = BattleType.FIVE_UNITS;
				} else if (selectedOption == 4) {
					battleType = BattleType.THREE_UNITS_IA;
				} else if (selectedOption == 0) {
					System.out.println("Good Bye!");
					System.exit(0);
				}
				validOpc = (battleType!=null);

			} catch (NumberFormatException ex) {
				System.out.println("Exception object: " + ex);
				System.out.println("Have you tried with a valid number?");
			} catch (IOException e) {
				System.out.println("Exception object: " + e);
				System.out.println("Have you tried with a valid number?");
			}
		}
	}

	public List<Unit> getSelectedUnits() {
		if (battleType.equals(BattleType.MAX_HEALTH)) {
			return getSelectedUnitsByHealth();
		} else if (battleType.equals(BattleType.THREE_UNITS)) {
			return getSelectedUnitsByQuantity(3);
		} else if (battleType.equals(BattleType.FIVE_UNITS)) {
			return getSelectedUnitsByQuantity(5);
		} else if (battleType.equals(BattleType.THREE_UNITS_IA)) {
			return getMockedUnits(3);
		} 
		throw new IllegalArgumentException("invalid battle type!");
	}
	
	private List<Unit> getMockedUnits(int quantity){
		List<Unit> selectedUnits = new ArrayList<Unit>();
		for (int i = 0; i < quantity; i++) {
			selectedUnits.add(MockedUnits.getNavyTeam().get(i));
		}
		return selectedUnits;
	}

	private List<Unit> getSelectedUnitsByQuantity(int quantity) {
		int totalUnits = 0;
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
						+ quantity + " units, so choose wisely.");
		while (totalUnits < quantity) {
			int selectedOption = 0;
			String input = null;
			BufferedReader bufferReader = new BufferedReader(
					new InputStreamReader(System.in));

			try {
				input = bufferReader.readLine();
				selectedOption = Integer.parseInt(input);

				if (selectedOption < 1
						|| selectedOption > availableUnits.size()) {
					System.out
							.println("You have choosen an invalid unit number, please select again");
				} else {
					Unit selectedUnit = availableUnits.get(selectedOption - 1);
					// check if you can add the corresponding unit
					if (quantity <= totalUnits) {
						System.out.println("You cannot any more units!");
						break;
					} else {
						selectedUnits.add(selectedUnit);
						totalUnits++;
						System.out.println(selectedUnit.getName() + " Added!");
						if (quantity - totalUnits > 0) {
							System.out.println("Units left: "
									+ (quantity - totalUnits));
						}
					}
					if ((quantity - 1) == totalUnits) {
						System.out.println("Pick your LAST unit!");
					} else if (quantity != totalUnits) {
						System.out.println("Pick your next unit!");
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

	private List<Unit> getSelectedUnitsByHealth() {
		int maxHealth = AppConfig.getMaxHealth();
		int totalHealth = 0;
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

		while (totalHealth < maxHealth) {
			int selectedOption = 0;
			String input = null;
			BufferedReader bufferReader = new BufferedReader(
					new InputStreamReader(System.in));

			try {
				input = bufferReader.readLine();
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
		return MockedUnits.getAvailableUnits();
	}

	public BattleType getBattleType() {
		return battleType;
	}

	public void setBattleType(BattleType battleType) {
		this.battleType = battleType;
	}

}