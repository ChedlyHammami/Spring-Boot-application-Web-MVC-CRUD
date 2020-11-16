package com.chedly.emlpoye;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.chedly.emlpoye.entities.Employe;
import com.chedly.emlpoye.service.EmployeService;

@SpringBootApplication
public class EmployeApplication implements CommandLineRunner {
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

public static void main(String[] args) {
SpringApplication.run(EmployeApplication.class, args);
}
@Override
public void run(String... args) throws Exception {
	repositoryRestConfiguration.exposeIdsFor(Employe.class);
}
}