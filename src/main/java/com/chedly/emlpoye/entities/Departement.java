package com.chedly.emlpoye.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
	public class Departement {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)private Long idDep;
		private String nomDep;
		private String descriptionDep;
		 @JsonIgnore
		 @OneToMany(mappedBy = "departement")
		 private List<Employe> employes;

		
}
