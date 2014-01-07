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
	@Column(name = "battlefield_id", nullable = false)
	private String battlefieldId;

}
