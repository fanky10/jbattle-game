package com.doinfinite.battlegame.datafields;

import java.beans.PropertyEditorSupport;
import java.util.List;

import com.doinfinite.battlegame.mocked.MockedUnits;
import com.doinfinite.battlegame.model.Unit;

public class UnitPropertyEditor extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		List<Unit> aviableUnits = MockedUnits.getAvailableUnits();
		if(!aviableUnits.isEmpty()){
			for(Unit u: aviableUnits){
				if(u.getName().equals(text)){
					super.setValue(u);
					return ;
				}
			}
		}
		super.setValue("name");
		throw new IllegalArgumentException("unit not found with given name: "+text);
	}
}