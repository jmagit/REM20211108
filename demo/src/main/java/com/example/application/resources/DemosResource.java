package com.example.application.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.application.proxies.CatalogoProxy;
import com.example.domains.entities.dtos.ActorDTO;
import com.example.domains.entities.dtos.FilmShort;

@RestController
public class DemosResource {
	@GetMapping("/params/{id}")
	public String cotilla(
	        @PathVariable String id,
	        @RequestParam String nom,
	        @RequestHeader("Accept-Language") String language, 
	        @CookieValue(name = "JSESSIONID", required = false, defaultValue = "Sin sesion") String cookie) { 
	    StringBuilder sb = new StringBuilder();
	    sb.append("id: " + id + "\n");
	    sb.append("nom: " + nom + "\n");
	    sb.append("language: " + language + "\n");
	    sb.append("cookie: " + cookie + "\n");
	    return sb.toString();
	}
	
	@GetMapping(path = "/params/{id}", produces = {"application/xml"})
	public String cotillaXML(
	        @PathVariable String id,
	        @RequestParam String nom,
	        @RequestHeader("Accept-Language") String language, 
	        @CookieValue(name = "JSESSIONID", required = false, defaultValue = "Sin sesion") String cookie) { 
	    StringBuilder sb = new StringBuilder();
	    sb.append("<raiz><id>" + id + "</id>\n");
	    sb.append("<nom>" + nom + "</nom>\n");
	    sb.append("<language>" + language + "</language>\n");
	    sb.append("<cookie>" + cookie + "</cookie></raiz>\n");
	    return sb.toString();
	}

	@GetMapping("/serializa")
	public ActorDTO serializa() {
		return new ActorDTO(0, "Pepito", "Grillo");
	}
	
	@Autowired 
	@Qualifier("Sin balanceo")
	RestTemplate srvRest;
	
	@Autowired 
	@Qualifier("Con balanceo")
	RestTemplate srvRestLB;

	@Autowired
	CatalogoProxy proxy;

	@GetMapping("/pelis/{id}")
	public FilmShort pidePelis(int id) {
		return proxy.getPeli(id);
//		return srvRestLB.getForObject( "http://host.docker.internal:8010/peliculas/{id}?mode=short", FilmShort.class, 1);
	}
	@GetMapping("/pelis")
	public List<FilmShort> pidePelis() {
//		ResponseEntity<List<FilmShort>> response = srvRest.exchange(
//				"http://host.docker.internal:8010/peliculas?mode=short", 
//				HttpMethod.GET,
//				HttpEntity.EMPTY, 
//				new ParameterizedTypeReference<List<FilmShort>>() {	});
//		return response.getBody();
		return proxy.getPelis();
	}
	@GetMapping("/vinculos")
	public String pideVinculos() {
		return proxy.getVinculos();
//		return srvRestLB.getForObject( "lb://catalogo-service/", String.class, 1);
	}

}
