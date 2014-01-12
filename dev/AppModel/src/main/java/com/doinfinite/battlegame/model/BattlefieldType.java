package com.doinfinite.battlegame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "battlefield")
public class BattlefieldType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "battlefield_id", nullable = false)
	private Integer battlefieldId;

	@Column(name = "battlefield_name", nullable = false)
	private String battlefieldName;

	public Integer getBattlefieldId() {
		return battlefieldId;
	}

	public void setBattlefieldId(Integer battlefieldId) {
		this.battlefieldId = battlefieldId;
	}

	public String getBattlefieldName() {
		return battlefieldName;
	}

	public void setBattlefieldName(String battlefieldName) {
		this.battlefieldName = battlefieldName;
	}

}
