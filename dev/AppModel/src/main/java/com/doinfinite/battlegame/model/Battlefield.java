package com.doinfinite.battlegame.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.doinfinite.battlegame.model.air.Airplane;
import com.doinfinite.battlegame.model.air.Chopper;
import com.doinfinite.battlegame.model.earth.HeavyTank;
import com.doinfinite.battlegame.model.earth.LightTank;
import com.doinfinite.battlegame.model.earth.QuickTank;
import com.doinfinite.battlegame.model.earth.Turret;
import com.doinfinite.battlegame.model.water.Ship;

public class Battlefield {
	private List<Unit> redTeam;
	private List<Unit> blueTeam;

	public Battlefield(List<Unit> redTeam, List<Unit> blueTeam) {
		super();
		this.redTeam = redTeam;
		this.blueTeam = blueTeam;
	}

	public void battle() {

		while (!isThereAWinner()) {
			Unit redUnit = redTeam.get(0);
			attack(redUnit, blueTeam);

			if (!blueTeam.isEmpty()) {
				Unit blueUnit = blueTeam.get(0);
				attack(blueUnit, redTeam);
			}

			System.out.println("-------------------------");
			System.out.println("red team:" + redTeam);
			System.out.println("blue team:" + blueTeam);
			System.out.println("=========================");

		}

		String winnerMessage = (redTeam.isEmpty() ? "Blue team wins!"
				: (blueTeam.isEmpty() ? "Red team wins!"
						: "There was an issue clearly"));
		System.out.println("Who has won? " + winnerMessage);
	}

	private boolean isThereAWinner() {
		return redTeam.isEmpty() || blueTeam.isEmpty();
	}

	private void attack(Unit attacker, List<Unit> defenders) {
		System.out.println(attacker.getClass().getSimpleName()
				+ " is attacking!!");
		Iterator<Unit> unit = defenders.iterator();
		if (unit.hasNext()) {
			Unit defender = unit.next();
			if (!attacker.canAttack(defender)) {
				System.out.println(attacker.getClass().getSimpleName()
						+ " cannot attack "
						+ defender.getClass().getSimpleName());
				return;// cannot attack :(
			}
			int attack = attacker.ataca();
			defender.defiende(attack);
			System.out.println(defender.getClass().getSimpleName()
					+ " gets damage and is left with: " + defender.getHealth());
			// depending on health remove it
			if (defender.isDead()) {
				System.out.println("Unit down!!!");
				unit.remove();
			}
		}
	}

	public static void main(String args[]) {
		List<Unit> blueTeam = new ArrayList<Unit>();
		blueTeam.add(new Ship(100,50,10));

		List<Unit> redTeam = new ArrayList<Unit>();
		redTeam.add(new Turret(100,50,10));
		redTeam.add(new Airplane(100,50,10));
		redTeam.add(new Chopper(100,50,10));
		redTeam.add(new QuickTank(100,50,10));
		redTeam.add(new LightTank(100,50,10));
		redTeam.add(new HeavyTank(100,50,10));

		new Battlefield(redTeam, blueTeam).battle();

	}

	public List<Unit> getRedTeam() {
		return redTeam;
	}

	public void setRedTeam(List<Unit> redTeam) {
		this.redTeam = redTeam;
	}

	public List<Unit> getBlueTeam() {
		return blueTeam;
	}

	public void setBlueTeam(List<Unit> blueTeam) {
		this.blueTeam = blueTeam;
	}

}
