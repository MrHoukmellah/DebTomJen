package com.simulationcredit.metier;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class TestCalculMensualite {
	
	private ICalculMensualite testMensualite;

	@Test
	void test() {
		
		testMensualite = new CalculMensualiteImpl();
		double montantACrediter = 200000;
		int duree = 240;
		double taux = 4.5;
		double mensualite = 1265.2987;
		
		double resultat = testMensualite.calculMensualite(taux, montantACrediter, duree);
		
		assertEquals(mensualite, resultat, 0.0001);
	}

}
