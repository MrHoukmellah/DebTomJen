package com.simulationcredit.metier;

import java.util.ArrayList;

import com.simulationcredit.model.Proprietes;

public class PropertiesListToString implements IPropertiesListToString {

	


	@Override
	public String[] propertiesListToStringArray(ArrayList<Proprietes> properties) {
		/*int i = 0;
		properties.forEach((item)->{
			
			double from = item.getFromTo()[0];
			double to = item.getFromTo()[1];
			String typefrais = item.getTypeFrais();
			double valeurFrais = item.getValeurFrais();
			
		});*/
		String propertiesToArray[] = properties.toArray(new String[] {});
		
		
		
		
		return propertiesToArray;
	};

	
	
}
