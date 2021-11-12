package com.example.application.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.domains.entities.dtos.ActorDTO;
import com.example.domains.entities.dtos.FilmShort;

@FeignClient(name = "catalogo-service")
public interface CatalogoProxy {
	@GetMapping
	String getVinculos();
	
	@GetMapping(path = "/peliculas?mode=short")
	List<FilmShort> getPelis();
	
	@GetMapping(path = "/peliculas/{id}?mode=short")
	FilmShort getPeli(@PathVariable int id);
	
	@PostMapping(path = "/actores", consumes = "application/json")
	void addActor(@RequestBody ActorDTO item);
	
}
