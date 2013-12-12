package com.doinfinite.battlegame.datafields;

import java.beans.PropertyEditorSupport;
import java.util.List;

import com.doinfinite.battlegame.model.Unit;
import com.doinfinite.battlegame.services.ServicesManager;

public class UnitPropertyEditor extends PropertyEditorSupport {
	private ServicesManager servicesManager;

	public UnitPropertyEditor(ServicesManager servicesManager) {
		this.servicesManager = servicesManager;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		List<Unit> aviableUnits = servicesManager.getUnits();
		if (!aviableUnits.isEmpty()) {
			for (Unit u : aviableUnits) {
				if (u.getName().equals(text)) {
					super.setValue(u);
					return;
				}
			}
		}
		super.setValue("name");
		throw new IllegalArgumentException("unit not found with given name: "
				+ text);
	}
}