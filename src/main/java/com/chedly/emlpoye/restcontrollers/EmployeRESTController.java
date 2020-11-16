package com.chedly.emlpoye.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chedly.emlpoye.entities.Employe;
import com.chedly.emlpoye.service.EmployeService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmployeRESTController {
@Autowired
EmployeService employeService;
@RequestMapping(method = RequestMethod.GET)
public List<Employe> getAllEmployes() {
return employeService.getAllEmployes();
}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Employe getEmployeById(@PathVariable("id") Long id) {
return employeService.getEmploye(id);
 }
@RequestMapping(method = RequestMethod.POST)
public Employe createProduit(@RequestBody Employe employe) {
return employeService.saveEmploye(employe);
}
@RequestMapping(method = RequestMethod.PUT)
public Employe updateEmlpoye(@RequestBody Employe employe) {
return employeService.updateEmploye(employe);
}
@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deleteEmploye(@PathVariable("id") Long id)
{
employeService.deleteEmployeById(id);
}
@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
public List<Employe> getEmployesByDepId(@PathVariable("idDep") Long idDep) {
return employeService.findByDepartementIdDep(idDep);
}



}