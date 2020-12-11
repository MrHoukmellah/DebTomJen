package com.simulationcredit.model;

import java.util.ArrayList;
import java.util.List;

public class TypesCredits {

	private String nomCredit;
	private double taux;
	private ArrayList<Proprietes> proprietes;
	private double[] limiteMois;
	private double[] limiteCredit; 
	
	public double[] getLimiteCredit() {
		return limiteCredit;
	}
	public void setLimiteCredit(double[] limiteCredit) {
		this.limiteCredit = limiteCredit;
	}
	public double[] getLimiteMois() {
		return limiteMois;
	}
	public void setLimiteMois(double[] limiteMois) {
		this.limiteMois = limiteMois;
	}
	public TypesCredits(String nomCredit, double taux, ArrayList<Proprietes> proprietes, double[] limiteMois ,double[] limiteCredit) {
		super();
		this.nomCredit = nomCredit;
		this.taux = taux;
		this.proprietes = proprietes;
		this.limiteMois = limiteMois;
		this.limiteCredit = limiteCredit;
	}
	public String getNomCredit() {
		return nomCredit;
	}
	public void setNomCredit(String nomCredit) {
		this.nomCredit = nomCredit;
	}
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	public ArrayList<Proprietes> getProprietes() {
		return proprietes;
	}
	public ArrayList<String> getPropertiesString(){
		ArrayList<String> arrayOfProperties = new ArrayList<String>();
		proprietes.forEach((item)->{
			arrayOfProperties.add(item.toString());
		});
		
		System.out.println(arrayOfProperties.get(0));
		
		
		return arrayOfProperties;
	}
	public void setProprietes(ArrayList<Proprietes> proprietes) {
		this.proprietes = proprietes;
	}
	


	
	
	
}
