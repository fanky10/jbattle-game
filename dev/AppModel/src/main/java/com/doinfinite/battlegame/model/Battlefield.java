package com.doinfinite.battlegame.model;

import java.util.ArrayList;
import java.util.List;

import com.doinfinite.battlegame.model.BattleEvent.EventStatus;

public class Battlefield {
	private List<Unit> localUnits;
	private List<Unit> enemyUnits;
	private List<BattleEvent> battleEvents = new ArrayList<BattleEvent>();

	public Battlefield(List<Unit> localUnits, List<Unit> enemyUnits) {
		super();
		this.localUnits = localUnits;
		this.enemyUnits = enemyUnits;
	}

	public String toString() {
		return "Basic Battlefield!";
	}

	public List<BattleEvent> battle() {
		while (!isThereAWinner()) {
			attack();
			defend();
		}

		BattleEvent end = new BattleEvent();
		end.setStatus(enemyUnits.isEmpty() ? EventStatus.WIN : (localUnits
				.isEmpty() ? EventStatus.LOSE : EventStatus.LOSE));
		this.battleEvents.add(end);

		return battleEvents;
	}

	private boolean isThereAWinner() {
		return localUnits.isEmpty() || enemyUnits.isEmpty();
	}

	private void attack() {
		battleTurn(localUnits, enemyUnits, EventStatus.ATTACKING);
	}

	private void defend() {
		battleTurn(enemyUnits, localUnits, EventStatus.UNDER_ATTACK);
	}

	private void battleTurn(List<Unit> attackers, List<Unit> defenders,
			EventStatus action) {
		for (Unit attacker : attackers) {
			if (!defenders.isEmpty()) {
				Unit defender = defenders.get(0);
				int attack = attacker.attack();
				float dmg = defender.defend(attack);
				BattleEvent battleEvent = new BattleEvent();
				battleEvent.setAtackerName(attacker.getName());
				battleEvent.setDefenderHealth(defender.getHealth());
				battleEvent.setDefenderDefense(defender.getDefense());
				battleEvent.setDefenderName(defender.getName());
				battleEvent.setDamage(dmg);
				battleEvent.setStatus(action);
				battleEvents.add(battleEvent);

				// did it die?
				if (defender.isDead()) {
					defenders.remove(0);
				}

			}
		}
	}

	public List<Unit> getLocalUnits() {
		return localUnits;
	}

	public void setLocalUnits(List<Unit> localUnits) {
		this.localUnits = localUnits;
	}

	public List<Unit> getEnemyUnits() {
		return enemyUnits;
	}

	public void setEnemyUnits(List<Unit> enemyUnits) {
		this.enemyUnits = enemyUnits;
	}

	public List<BattleEvent> getBattleEvents() {
		return battleEvents;
	}

	public void setBattleEvents(List<BattleEvent> battleEvents) {
		this.battleEvents = battleEvents;
	}

}
