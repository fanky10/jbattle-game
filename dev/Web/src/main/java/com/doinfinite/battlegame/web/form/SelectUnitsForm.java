package com.doinfinite.battlegame.web.form;

import java.util.List;

import com.doinfinite.battlegame.model.Unit;

public class SelectUnitsForm implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3500287696904796815L;
	private List<Unit> selectedUnits;

	public List<Unit> getSelectedUnits() {
		return selectedUnits;
	}

	public void setSelectedUnits(List<Unit> selectedUnits) {
		this.selectedUnits = selectedUnits;
	}
}
