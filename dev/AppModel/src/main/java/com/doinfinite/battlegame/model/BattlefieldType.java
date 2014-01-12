package com.doinfinite.battlegame.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BattlefieldType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "battlefield_name", nullable = false)
	private Integer battlefieldName;
	public Integer getBattlefieldName() {
		return battlefieldName;
	}
	public void setBattlefieldName(Integer battlefieldName) {
		this.battlefieldName = battlefieldName;
	}
	public String getBattlefieldId() {
		return battlefieldId;
	}
	public void setBattlefieldId(String battlefieldId) {
		this.battlefieldId = battlefieldId;
	}
	@Column(name = "battlefield_id", nullable = false)
	private String battlefieldId;

}
