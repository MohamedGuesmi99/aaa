package com.example.demo.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.Partenaire;
import com.example.demo.services.ISPartenaire;

@RestController
@CrossOrigin()
public class PartenaireControlleur {
@Autowired
ISPartenaire PartenaireS;
@GetMapping("/partenaires")
public List<Partenaire> getAll(){
	return PartenaireS.getPartenaire();
	
}
@PostMapping("/partenaires")
public ResponseEntity<Partenaire> addPartenaire(@RequestBody Partenaire partenaire){
	Partenaire p1=this.PartenaireS.addPartenaire(partenaire);
	return new ResponseEntity<>(p1,HttpStatus.CREATED);
}
@GetMapping("/partenaires/{cin}")
public Partenaire getOne(@PathVariable("cin") int cin) {
	return PartenaireS.chercherPartenaire(cin);
}
@PutMapping("/partenaires/{cin}")
public Partenaire updatePartenaire(@RequestBody Partenaire partenaire,@PathVariable("cin") int cin) {
	return PartenaireS.updatePartenaire(partenaire, cin);
}
@DeleteMapping("/partenaires/{cin}")
public boolean deleteOne(@PathVariable("cin") int cin) {
	return PartenaireS.deletePartenaire(cin);
}
}
