package com.example;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;

import com.example.domains.entities.Actor;
import com.example.domains.entities.dtos.ActorDTO;
import com.example.domains.entities.dtos.ActorShort;
import com.example.domais.contracts.repositories.ActorRepository;
import com.example.domais.contracts.services.ActorService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	ActorRepository dao;
	
	@Autowired
	ActorService srv;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
//		var actor = dao.findById(1);
//		if(actor.isPresent()) {
//			System.out.println(actor.get());
////			actor.get().setFirstName(actor.get().getFirstName().toLowerCase());
////			dao.save(actor.get());
//			actor.get().getFilmActors().forEach(f -> System.out.println(f.getFilm()));
//		} else {
//			System.out.println("No encontrado");
//		}
////		dao.getById(1).getFilmActors().forEach(f -> System.out.println(f.getFilm()));
		
//		dao.findAll().forEach(System.out::println);
//		Actor actor = new Actor(0, "Pepito", "Grilloooooo");
//		actor = dao.save(actor);
//		var id = actor.getActorId();
//		actor = dao.getById(id);
//		System.out.println(actor);
//		actor.setFirstName(actor.getFirstName().toUpperCase());
//		dao.save(actor);
//		actor = dao.getById(id);
//		System.out.println(actor);
//		dao.deleteById(id);
//		dao.findAll().forEach(System.out::println);

//		dao.findByFirstNameStartingWithOrderByLastNameDesc("p").forEach(System.out::println);
//		dao.MiConsulta(10).forEach(System.out::println);
//		dao.MiConsulta(100, PageRequest.of(1, 10)).forEach(p -> System.out.println(p) );
//		dao.findAll(PageRequest.of(1, 10)).forEach(p -> System.out.println(p) );

//		Actor actor = new Actor(0, "12345678z", null);
//		if(actor.isInvalid())
////			actor.getErrors().forEach(System.out::println);
//			System.err.println(actor.getErrorsMessages());
//		else {
//			System.out.println("Es valido");
//		}
//		dao.save(actor);
//		dao.findAll().forEach(f -> System.out.println(ActorDTO.from(f)));
//		dao.findByFirstNameStartingWith("A").forEach(System.out::println);
//		dao.findByFirstNameStartingWith("A").forEach(f -> System.out.println(f.getNombre()));
//		dao.findByActorIdIsNotNull(ActorDTO.class).forEach(System.out::println);
//		dao.findByActorIdIsNotNull(ActorShort.class).forEach(f -> System.out.println(f.getNombre()));
//		srv.getAll().forEach(System.out::println);
	}
}
