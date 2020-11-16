package com.chedly.emlpoye.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chedly.emlpoye.entities.Employe;
import com.chedly.emlpoye.service.EmployeService;
import com.sun.el.parser.ParseException;

@Controller
public class EmployeController {
	@Autowired
	EmployeService employeService;
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createProduit";
	}
	@RequestMapping("/saveProduit")
	public String saveEmploye(@ModelAttribute("employe") Employe employe,
	 @RequestParam("date") String date,
	 ModelMap modelMap) throws
	ParseException, java.text.ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = (Date) dateformat.parse(String.valueOf(date));
	 employe.setDateNaissance(dateCreation);

	Employe saveEmploye = employeService.saveEmploye(employe);
	String msg ="Employe enregistré avec Id "+saveEmploye.getIdEmploye();
	modelMap.addAttribute("msg", msg);
	return "createProduit";
	}
	@RequestMapping("/ListeEmployes")
	public String listeEmployes(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	Page<Employe> emps = employeService.getAllEmployesParPage(page, size);
	modelMap.addAttribute("employes", emps);
	 modelMap.addAttribute("pages", new int[emps.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listeEmployes";
	}
	
	@RequestMapping("/supprimerEmploye")
	public String supprimerEmploye(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	employeService.deleteEmployeById(id);
	Page<Employe> emps = employeService.getAllEmployesParPage(page,
	size);
	modelMap.addAttribute("employes", emps);
	modelMap.addAttribute("pages", new int[emps.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeProduits";
	}
	
	@RequestMapping("/modifierEmploye")
	public String editerEmploye(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Employe e= employeService.getEmploye(id);
	modelMap.addAttribute("employe", e);
	return "editerEmploye";
	}
	@RequestMapping("/updateEmploye")
	public String updateEmploye(@ModelAttribute("employe") Employe employe,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException, java.text.ParseException
	{
		//conversion de la date
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateNaissance = (Date) dateformat.parse(String.valueOf(date));
		 employe.setDateNaissance(dateNaissance);

		 employeService.updateEmploye(employe);
		 List<Employe> prods = employeService.getAllEmployes();
		 modelMap.addAttribute("produits", prods);
		return "listeProduits";
		}



}
