package com.simulationcredit.model;

import java.util.Arrays;

public class Proprietes {
	
	public double[] fromTo;

	private String typeFrais;
	private double valeurFrais;
	
	public Proprietes(double[] fromTo, String typeFrais, double valeurFrais) {
		super();
		this.fromTo = fromTo;
		this.typeFrais = typeFrais;
		this.valeurFrais = valeurFrais;
	}

	public double[] getFromTo() {
		return fromTo;
	}

	public void setFromTo(double[] fromTo) {
		this.fromTo = fromTo;
	}

	public String getTypeFrais() {
		return typeFrais;
	}

	public void setTypeFrais(String typeFrais) {
		this.typeFrais = typeFrais;
	}

	public double getValeurFrais() {
		return valeurFrais;
	}

	public void setValeurFrais(double valeurFrais) {
		this.valeurFrais = valeurFrais;
	}
	@Override
	public String toString() {
		return "Proprietes [fromTo=" + Arrays.toString(fromTo) + ", typeFrais=" + typeFrais + ", valeurFrais="
				+ valeurFrais + "]";
	}
}
