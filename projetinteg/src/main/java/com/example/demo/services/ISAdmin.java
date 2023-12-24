package com.example.demo.services;

import java.util.List;

import com.example.demo.entites.Admin;

public interface ISAdmin {
	public Admin addAdmin(Admin a);
	public boolean saveAdmin(Admin admin);
	public List<Admin> getadmin();
	public Admin chercherAdmin(int cin);
	public boolean deleteAdmin(int cin);
	public Admin updateAdmin(Admin admin,int cin);

}
