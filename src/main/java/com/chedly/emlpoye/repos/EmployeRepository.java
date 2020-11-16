package com.chedly.emlpoye.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.chedly.emlpoye.entities.Departement;
import com.chedly.emlpoye.entities.Employe;


@RepositoryRestResource(path = "rest")
public interface EmployeRepository extends JpaRepository<Employe, Long> {
	
	List<Employe> findByNomEmploye(String nom);
	List<Employe> findByNomEmployeContains(String nom);
	@Query("select e from Employe e where e.nomEmploye like %?1 and e.prenomEmploye like %a")
	List<Employe> findByNomPrenom (String nom, String prenom);
	@Query("select e from Employe e where e.departement = ?1")
	List<Employe> findByDepartement (Departement departement);
	List<Employe> findByOrderByNomEmployeAsc();
	
	@Query("select e from Employe e order by p.nomEmploye ASC, e.prenomEmploye DESC")
	List<Employe> trierEmployesNomsPrenom ();
	List<Employe> findByDepartementIdDep(Long id);



}
