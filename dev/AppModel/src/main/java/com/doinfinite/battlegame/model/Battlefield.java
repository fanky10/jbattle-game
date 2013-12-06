package com.doinfinite.battlegame.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.doinfinite.battlegame.model.BattleEvent.EventStatus;

public class Battlefield {
	private List<Unit> localUnits;
	private List<Unit> enemyUnits;

	public Battlefield(List<Unit> localUnits, List<Unit> enemyUnits) {
		super();
		this.localUnits = localUnits;
		this.enemyUnits = enemyUnits;
	}

	public String toString() {
		return "Basic Battlefield!";
	}

	public List<BattleEvent> battle() {
		List<BattleEvent> battleEvents = new ArrayList<BattleEvent>();

		while (!isThereAWinner()) {
			List<BattleEvent> attackEvents = attack();
			battleEvents.addAll(attackEvents);
			List<BattleEvent> defendEvents = defend();
			battleEvents.addAll(defendEvents);
		}
		BattleEvent end = new BattleEvent();
		end.setStatus(localUnits.isEmpty() ? EventStatus.WIN : (enemyUnits
				.isEmpty() ? EventStatus.LOSE : EventStatus.LOSE));
		battleEvents.add(end);
		
		return battleEvents;
	}

	private boolean isThereAWinner() {
		return localUnits.isEmpty() || enemyUnits.isEmpty();
	}

	private List<BattleEvent> attack() {
		List<BattleEvent> events = new ArrayList<BattleEvent>();

		for (Unit attacker : localUnits) {
			Iterator<Unit> enemyIterator = enemyUnits.iterator();
			if (enemyIterator.hasNext()) {
				
				Unit defender = enemyIterator.next();
				int attack = attacker.attack();
				float dmg = defender.defend(attack);
				BattleEvent battleEvent = new BattleEvent();
				battleEvent.setLocalUnit(attacker);
				battleEvent.setEnemyUnit(defender);
				battleEvent.setDamage(dmg);
				battleEvent.setStatus(EventStatus.ATTACKING);
				events.add(battleEvent);
				
				// depending on health remove it
				if (defender.isDead()) {
					enemyIterator.remove();
				}
			}
		}
		return events;
	}

	private List<BattleEvent> defend() {
		List<BattleEvent> events = new ArrayList<BattleEvent>();

		for (Unit attacker : enemyUnits) {
			Iterator<Unit> enemyIterator = localUnits.iterator();
			if (enemyIterator.hasNext()) {

				Unit defender = enemyIterator.next();
				int attack = attacker.attack();
				float dmg = defender.defend(attack);
				BattleEvent battleEvent = new BattleEvent();
				battleEvent.setLocalUnit(attacker);
				battleEvent.setEnemyUnit(defender);
				battleEvent.setDamage(dmg);
				battleEvent.setStatus(EventStatus.UNDER_ATTACK);
				events.add(battleEvent);
				
				// depending on health remove it
				if (defender.isDead()) {
					enemyIterator.remove();
				}
			}
		}
		return events;
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

}
