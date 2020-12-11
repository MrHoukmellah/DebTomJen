package com.simulationcredit.metier;

public class CalculMensualiteImpl implements ICalculMensualite {
	

	@Override
	public double calculMensualite(double taux, double montantACrediter, int duree) {
		

		double mensualite = (montantACrediter*taux/1200)/(1-(Math.pow((1+(taux/1200)),-duree)));
		
		
		return mensualite;
	}
}
