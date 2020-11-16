package com.chedly.emlpoye.entities;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.domain.Page;

@Entity

public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmploye;
	private String nomEmploye;
	private String prenomEmploye;
	private Date dateNaissance;
	@ManyToOne
	private Departement departement;
	
	public Employe(String nomEmploye, String prenomEmploye, Date dateNaissance) {
	super();
	this.setNomEmploye(nomEmploye);
	this.setPrenomEmploye(prenomEmploye);
	this.setDateNaissance(dateNaissance);
	}
	public Long getIdEmploye() {
		return this.idEmploye;
	}
	public String getPrenomEmploye() {
		return prenomEmploye;
	}
	public void setPrenomEmploye(String prenomEmploye) {
		this.prenomEmploye = prenomEmploye;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getNomEmploye() {
		return nomEmploye;
	}
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	@Override
	public String toString() {
		return "Employe [idEmploye=" + idEmploye + ", nomEmploye=" + nomEmploye + ", prenomEmploye=" + prenomEmploye
				+ ", dateNaissance=" + dateNaissance + "]";
	}
	public Page<Employe> getAllEmployesParPage(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
