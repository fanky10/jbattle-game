package com.doinfinite.battlegame.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Battlefield {
	private List<Unit> redTeam;
	private List<Unit> blueTeam;
	private static final boolean DEBUG = false;

	public Battlefield(List<Unit> redTeam, List<Unit> blueTeam) {
		super();
		this.redTeam = redTeam;
		this.blueTeam = blueTeam;
	}
	
	public String toString(){
		return "Basic Battlefield!";
	}

	public List<BattleEvent> battle() {
		List<BattleEvent> battleEvents = new ArrayList<BattleEvent>();
		while (!isThereAWinner()) {
			Unit redUnit = redTeam.get(0);
			String attackMessage = attack(redUnit, blueTeam);
			battleEvents.add(new BattleEvent(attackMessage));
			if (!blueTeam.isEmpty()) {
				Unit blueUnit = blueTeam.get(0);
				attackMessage = attack(blueUnit, redTeam);
				battleEvents.add(new BattleEvent(attackMessage));
			}

			debug("-------------------------");
			debug("red team:" + redTeam);
			debug("blue team:" + blueTeam);
			debug("=========================");

		}

		String winnerMessage = (redTeam.isEmpty() ? "Blue team wins!"
				: (blueTeam.isEmpty() ? "Red team wins!"
						: "There was an issue clearly"));
		debug("Who has won? " + winnerMessage);
		battleEvents.add(new BattleEvent(winnerMessage));
		return battleEvents;
	}

	private boolean isThereAWinner() {
		return redTeam.isEmpty() || blueTeam.isEmpty();
	}

	private String attack(Unit attacker, List<Unit> defenders) {
		String message = "";
		debug(attacker.getClass().getSimpleName()
				+ " is attacking!!");
		Iterator<Unit> unit = defenders.iterator();
		if (unit.hasNext()) {
			Unit defender = unit.next();
			int attack = attacker.ataca();
			defender.defiende(attack);
			message = defender.getClass().getSimpleName()
					+ " gets damage and is left with: " + defender.getHealth();
			debug(message);
			// depending on health remove it
			if (defender.isDead()) {
				debug("Unit down!!!");
				unit.remove();
			}
		}
		return message;
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
	
	private static void debug(String message){
		if(DEBUG){//TODO: add log library
			System.out.println("DEBUG - "+message);
		}
	}

}
