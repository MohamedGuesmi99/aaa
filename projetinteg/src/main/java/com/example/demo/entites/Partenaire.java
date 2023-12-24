package com.example.demo.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Partenaire {
	@Id
	private int cin;
	private String email;
	private String nom;
	private String prenom;
	private int pwd;
	private String poste;
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getPwd() {
		return pwd;
	}
	public void setPwd(int pwd) {
		this.pwd = pwd;
	}
	public Partenaire(int cin, String email, String nom, String prenom, int pwd, String poste) {
		super();
		this.cin = cin;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.pwd = pwd;
		this.poste = poste;
	}
	public Partenaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Partenaire [cin=" + cin + ", email=" + email + ", nom=" + nom + ", prenom=" + prenom + ", pwd=" + pwd
				+ ", poste=" + poste + "]";
	}
	
}
