package com.example.demo.services;

import java.util.List;


import com.example.demo.entites.Partenaire;

public interface ISPartenaire {
	public Partenaire addPartenaire(Partenaire p);
	public boolean savePartenaire(Partenaire partenaire);
	public List<Partenaire> getPartenaire();
	public Partenaire chercherPartenaire(int cin);
	public boolean deletePartenaire(int cin);
	public Partenaire updatePartenaire(Partenaire partenaire,int cin);

}
