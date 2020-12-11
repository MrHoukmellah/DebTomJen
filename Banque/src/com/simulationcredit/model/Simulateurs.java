package com.simulationcredit.model;

import java.util.List;

public class Simulateurs {

	private List<Banque> banques;

	public Simulateurs(List<Banque> banques) {
		super();
		this.banques = banques;
	}

	public List<Banque> getBanques() {
		return banques;
	}
	
}
