package com.simulationcredit.model;



public class Model {
	
	private Banque banque;
	private double montantCredit;
	private double mensualite;
	
	public Model(Banque banque, double montantCredit, double mensualite) {
		super();
		this.banque = banque;
		this.montantCredit = montantCredit;
		this.mensualite = mensualite;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public double getMontantCredit() {
		return montantCredit;
	}

	public void setMontantCredit(double montantCredit) {
		this.montantCredit = montantCredit;
	}

	public double getMensualite() {
		return mensualite;
	}

	public void setMensualite(double mensualite) {
		this.mensualite = mensualite;
	}
	
	
}
