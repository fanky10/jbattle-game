package com.doinfinite.battlegame.web.form;

import com.doinfinite.battlegame.model.Unit;

public class SelectUnitsForm implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3500287696904796815L;
	private Unit[] selectedUnits;

	public Unit[] getSelectedUnits() {
		return selectedUnits;
	}

	public void setSelectedUnits(Unit[] selectedUnits) {
		this.selectedUnits = selectedUnits;
	}
}
