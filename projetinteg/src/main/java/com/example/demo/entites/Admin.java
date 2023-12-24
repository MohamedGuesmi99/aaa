package com.example.demo.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {
	@Id
	private int cin;
	private String email;
	private String nom;
	private String prenom;
	private int pwd;
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
	public Admin(int cin, String email, String nom, String prenom, int pwd) {
		super();
		this.cin = cin;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.pwd = pwd;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Admin [cin=" + cin + ", email=" + email + ", nom=" + nom + ", prenom=" + prenom + ", pwd=" + pwd + "]";
	}
	

}
