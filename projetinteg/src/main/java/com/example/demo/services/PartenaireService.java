package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entites.Partenaire;
import com.example.demo.repository.PartenaireRepository;

@Service
public class PartenaireService implements ISPartenaire{
@Autowired
PartenaireRepository partenaireRe;

@Override
public Partenaire addPartenaire(Partenaire p) {
	// TODO Auto-generated method stub
	return partenaireRe.save(p);
}

@Override
public boolean savePartenaire(Partenaire partenaire) {
	if (partenaireRe.save(partenaire)!=null)
		return true;
	else
	return false;
}

@Override
public List<Partenaire> getPartenaire() {
	// TODO Auto-generated method stub
	return partenaireRe.findAll();
}

@Override
public Partenaire chercherPartenaire(int cin) {
	Optional<Partenaire> partenaire=partenaireRe.findById(cin);
	if (partenaire.isPresent())
		return partenaire.get();
	else
			return null;
}

@Override
public boolean deletePartenaire(int cin) {
	partenaireRe.deleteById(cin);
	return !partenaireRe.existsById(cin);
}

@Override
public Partenaire updatePartenaire(Partenaire partenaire, int cin) {
	 partenaire.setCin(cin);
		return partenaireRe.save(partenaire);
}

}
