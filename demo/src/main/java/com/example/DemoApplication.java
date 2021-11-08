package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domais.contracts.repositories.ActorRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	ActorRepository dao;
	
	@Override
	public void run(String... args) throws Exception {
		var actor = dao.findById(1);
		if(actor.isPresent()) {
			System.out.println(actor.get());
			actor.get().setFirstName(actor.get().getFirstName().toLowerCase());
			dao.save(actor.get());
		} else {
			System.out.println("No encontrado");
		}
		dao.findAll().forEach(System.out::println);
	}
}
