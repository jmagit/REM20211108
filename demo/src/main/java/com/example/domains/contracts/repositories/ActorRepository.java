package com.example.domains.contracts.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.domains.entities.Actor;
import com.example.domains.entities.dtos.ActorDTO;
import com.example.domains.entities.dtos.ActorShort;


public interface ActorRepository extends JpaRepository<Actor, Integer> {
	List<Actor> findByFirstNameStartingWithOrderByLastNameDesc(String prefijo);
	List<ActorShort> findByFirstNameStartingWith(String prefijo);
	
	<T> List<T> findByActorIdIsNotNull(Class<T> type);
	<T> Page<T> findByActorIdIsNotNull(Pageable pageable, Class<T> type);
	<T> Iterable<T> findByActorIdIsNotNull(Sort sort, Class<T> type);
	
	@Query("SELECT a FROM Actor a WHERE a.actorId < ?1")
	List<Actor> MiConsulta(int limite);
	@Query("SELECT a FROM Actor a WHERE a.actorId < ?1")
	List<Actor> MiConsulta(int limite, Pageable pageable);
}
