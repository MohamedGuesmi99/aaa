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

import com.example.demo.entites.Admin;
import com.example.demo.services.ISAdmin;

@RestController
@CrossOrigin()
public class adminControlleur {
	@Autowired
	ISAdmin iAdminservice;
	@GetMapping("/admins")
	public List<Admin> getAll(){
		return iAdminservice.getadmin();
		
	}
	@PostMapping("/admins")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin){
		Admin a1=this.iAdminservice.addAdmin(admin);
		return new ResponseEntity<>(a1,HttpStatus.CREATED);
	}
	@GetMapping("/admins/{cin}")
	public Admin getOne(@PathVariable("cin") int cin) {
		return iAdminservice.chercherAdmin(cin);
	}
	@PutMapping("/admins/{cin}")
	public Admin updateAdmin(@RequestBody Admin admin,@PathVariable("cin") int cin) {
		return iAdminservice.updateAdmin(admin, cin);
	}
	@DeleteMapping("/admins/{cin}")
	public boolean deleteOne(@PathVariable("cin") int cin) {
		return iAdminservice.deleteAdmin(cin);
	}

}
