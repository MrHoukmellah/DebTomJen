package com.simulationcredit.model;

import java.util.ArrayList;

public class Banque {
	
	private String nom;
	private ArrayList<TypesCredits> typesCredits;
	
	public Banque(String nom, ArrayList<TypesCredits> typesCredits) {
		super();
		this.nom = nom;
		this.typesCredits = typesCredits;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<TypesCredits> getTypesCredits() {
		return typesCredits;
	}

	public void setTypesCredits(ArrayList<TypesCredits> typesCredits) {
		this.typesCredits = typesCredits;
	}


	
	
}
