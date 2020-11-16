package com.chedly.emlpoye.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.chedly.emlpoye.entities.Departement;
import com.chedly.emlpoye.entities.Employe;
import com.chedly.emlpoye.repos.EmployeRepository;

	@Service
	public class EmployeServicelmpl  implements EmployeService{
		@Autowired
		EmployeRepository employeRepository;
		@Override
		public Employe saveEmploye(Employe e) {
		return employeRepository.save(e);
		}
		@Override
		public Employe updateEmploye(Employe e) {
		return employeRepository.save(e);
		}
		@Override
		public void deleteEmploye(Employe e) {
		employeRepository.delete(e);
		}
		@Override
		public void deleteEmployeById(Long id) {
		employeRepository.deleteById(id);
		}
		@Override
		public Employe getEmploye(Long id) {
		return employeRepository.findById(id).get();
		}
		@Override
		public List<Employe> getAllEmployes() {
		return employeRepository.findAll();
		}
		@Override
		public Page<Employe> getAllEmployesParPage(int page, int size) {
		return employeRepository.findAll(PageRequest.of(page, size));
		}
		
		@Override
		public List<Employe> findByNomEmploye(String nom) {
		return employeRepository.findByNomEmploye(nom);
		}
		@Override
		public List<Employe> findByNomEmployeContains(String nom) {
		return employeRepository.findByNomEmployeContains(nom);
		}
		@Override
		public List<Employe> findByNomPrenom(String nom, String prenom) {
			return employeRepository.findByNomPrenom(nom, prenom);
		}
		@Override
		public List<Employe> findByDepartement(Departement departement) {
		return employeRepository.findByDepartement(departement);
		}
		@Override
		public List<Employe> findByDepartementIdDep(Long id) {
		return employeRepository.findByDepartementIdDep(id);
		}
		@Override
		public List<Employe> findByOrderByNomEmployeAsc() {
		return employeRepository.findByOrderByNomEmployeAsc();
		}
		@Override
		public List<Employe> trierEmployesNomsPrenom() {
		return employeRepository.trierEmployesNomsPrenom();
		}
		}


