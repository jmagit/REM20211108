package com.example.application.resources;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.domains.entities.dtos.ActorDTO;

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
}
