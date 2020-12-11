package com.simulationcredit.metier;

public class TestCalculMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ICalculMensualite testMensualite;
		testMensualite = new CalculMensualiteImpl();
		double montantACrediter = 200000;
		int duree = 240;
		double taux = 4.5;
		
		
		double resultat = testMensualite.calculMensualite(taux, montantACrediter, duree);
		
		System.out.println("-------------"+resultat);

	}

}
