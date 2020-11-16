package com.chedly.emlpoye;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.chedly.emlpoye.entities.Departement;
import com.chedly.emlpoye.entities.Employe;
import com.chedly.emlpoye.repos.EmployeRepository;


@SpringBootTest
class EmployeApplicationTests {

	@Autowired
	private EmployeRepository employeRepository;
	@Test
	public void testCreateEmploye() {
	Employe emp = new Employe("hammami", "Chedly", null);
	employeRepository.save(emp);
	}
	@Test
	public void testFindEmploye()
	{
	Employe p = employeRepository.findById(1L).get();
	System.out.println(p);
	}
	@Test
	public void testUpdateEmploye()
	{
	Employe e = employeRepository.findById(1L).get();
	e.setNomEmploye("Rasil");
	employeRepository.save(e);
	}
	@Test
	public void testDeleteEmploye(){
		employeRepository.deleteById(1L);;
	}

	@Test
	public void testListerTousEmployes()
	{
	List<Employe> emps = employeRepository.findAll();
	for (Employe e : emps)
	{
	System.out.println(e);
	}
	}
	@Test
	public void testFindByNomEmployeContains()
	{
	Object employeService = null;
	Page<Employe> emps = ((Employe) employeService).getAllEmployesParPage(0,2);
	System.out.println(emps.getSize());
	System.out.println(emps.getTotalElements());
	System.out.println(emps.getTotalPages());
	emps.getContent().forEach(p -> {System.out.println(p.toString());
	 });
	
	}
	
	@Test
	public void testFindByNomEmploye()
	{
	List<Employe> emps = employeRepository.findByNomEmploye("iphone X");
	for (Employe e : emps)
	{
	System.out.println(e);
	}
	}
	@Test
	public void testFindByNomEmployeContains1 ()
	{
	List<Employe> emps = employeRepository.findByNomEmployeContains("iphone X");
	for (Employe e : emps)
	{
	System.out.println(e);
	} }
	@Test
	public void testfindByNomPrenom()
	{
	List<Employe> emps = employeRepository.findByNomPrenom("iphone X", "");
	for (Employe e : emps)
	{
	System.out.println(e);
	}
	}
	
	@Test
	public void testfindByCategorie()
	{
	Departement dep = new Departement();

	List<Employe> emps = employeRepository.findByDepartement(dep);
	for (Employe e : emps)
	{
	System.out.println(e);
	}
	}
	
	@Test
	public void testfindByOrderByNomEmployeAsc()
	{
	List<Employe> emps =
	employeRepository.findByOrderByNomEmployeAsc();
	for (Employe e : emps)
	{
	System.out.println(e);
	}
	}
	
	@Test
	public void testTrierEmployesNomsPrenom()
	{
	List<Employe> emps = employeRepository.trierEmployesNomsPrenom();
	for (Employe e : emps)
	{
	System.out.println(e);
	}
	}




}
