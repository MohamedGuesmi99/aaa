package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Admin;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminService implements ISAdmin {
	@Autowired
	AdminRepository adminRe;
	@Override
	public Admin addAdmin(Admin a) {
		
		return adminRe.save(a);
	}

	@Override
	public boolean saveAdmin(Admin admin) {
		if (adminRe.save(admin)!=null)
			return true;
		else
		return false;
	}

	@Override
	public List<Admin> getadmin() {
		
		return adminRe.findAll();
	}

	@Override
	public Admin chercherAdmin(int cin) {
		Optional<Admin> admin=adminRe.findById(cin);
		if (admin.isPresent())
			return admin.get();
		else
				return null;
	}

	@Override
	public boolean deleteAdmin(int cin) {
		adminRe.deleteById(cin);
		
		return !adminRe.existsById(cin);
	}

	@Override
	public Admin updateAdmin(Admin admin, int cin) {
        admin.setCin(cin);
		return adminRe.save(admin);
	}

	
	

}
