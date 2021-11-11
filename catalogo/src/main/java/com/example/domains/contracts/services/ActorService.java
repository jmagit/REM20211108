package com.example.domains.contracts.services;

import java.sql.Timestamp;
import java.util.List;

import com.example.domains.contracts.services.core.ProjectionDomainService;
import com.example.domains.entities.Actor;

public interface ActorService extends ProjectionDomainService<Actor, Integer> {
	List<Actor> novedades(Timestamp fecha);
}
