package com.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.example.domains.contracts.repositories.ContactoRepository;
import com.example.domains.entities.Contacto;

import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@EnableEurekaClient
@SpringBootApplication
public class ContactosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ContactosApplication.class, args);
	}

	@Autowired
	ContactoRepository dao;

	@Bean
	public ValidatingMongoEventListener validatingMongoEventListener(LocalValidatorFactoryBean factory) {
		return new ValidatingMongoEventListener(factory);
	}

	@Override
	public void run(String... args) throws Exception {
//		Contacto contacto;
//		int id = 1;
//		Optional<Contacto> encontrado = dao.findAll(PageRequest.of(0, 1, Sort.by(Direction.DESC, "id"))).stream()
//				.findFirst();
//		if (encontrado.isPresent())
//			id = encontrado.get().getId() + 1;
//		contacto = new Contacto(id, "Sr.", "Pepito", "Grillo", "555666777", "pepito@grillo", "M",
//				LocalDate.now().minus(20, ChronoUnit.YEARS),
//				"https://upload.wikimedia.org/wikipedia/commons/b/b5/Jiminy_Cricket.png", true);
//		dao.save(contacto);
//		System.out.println("Creado");
//		encontrado = dao.findById(id);
//		if (encontrado.isPresent()) {
//			System.out.println(encontrado.get());
//		} else
//			System.out.println("No encontrado");
//		if (encontrado.isPresent()) {
//			encontrado.get().setNombre(encontrado.get().getNombre().toUpperCase());
//			encontrado.get().setApellidos(encontrado.get().getApellidos().toUpperCase());
//			dao.save(encontrado.get());
//			System.out.println("Modificado");
//		}
//		encontrado = dao.findById(id);
//		if (encontrado.isPresent()) {
//			System.out.println(encontrado.get());
//		} else
//			System.out.println("No encontrado");
//		dao.deleteById(id);
//		System.out.println("Borrado");
//		encontrado = dao.findById(id);
//		System.out.println(encontrado.isPresent() ? encontrado.get() : "No encontrado");
	}

}
