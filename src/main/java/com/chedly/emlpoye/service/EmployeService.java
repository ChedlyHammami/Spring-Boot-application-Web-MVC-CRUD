package com.chedly.emlpoye.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.chedly.emlpoye.entities.Departement;
import com.chedly.emlpoye.entities.Employe;
public interface EmployeService {
	Employe saveEmploye(Employe e);
	Employe updateEmploye(Employe e);
	void deleteEmploye(Employe e);
	 void deleteEmployeById(Long id);
	Employe getEmploye(Long id);
	List<Employe> getAllEmployes();
	Page<Employe> getAllEmployesParPage(int page, int size);
	List<Employe> findByNomEmploye(String nom);
	List<Employe> findByNomEmployeContains(String nom);
	List<Employe> findByNomPrenom (String nom, String prenom);
	List<Employe> findByDepartement (Departement departement);
	List<Employe> findByDepartementIdDep(Long id);
	List<Employe> findByOrderByNomEmployeAsc();
	List<Employe> trierEmployesNomsPrenom();


}
