package com.example.domais.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domains.entities.Actor;
import com.example.domais.contracts.repositories.ActorRepository;
import com.example.domais.contracts.services.ActorService;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;

@Service
public class ActorServiceImpl implements ActorService {
	@Autowired
	ActorRepository dao;
	
	@Override
	public List<Actor> getAll() {
		return dao.findAll();
	}

	@Override
	public Optional<Actor> getOne(Integer id) {
		return dao.findById(id);
	}

	@Override
	public Actor add(Actor item) throws InvalidDataException, DuplicateKeyException {
		if(item == null)
			throw new InvalidDataException("Faltan los datos");
		if(item.isInvalid())
			throw new InvalidDataException(item.getErrorsMessages());
		if(getOne(item.getActorId()).isPresent())
			throw new DuplicateKeyException();
		return dao.save(item);
	}

	@Override
	public Actor modify(Actor item) throws InvalidDataException, NotFoundException {
		if(item == null)
			throw new InvalidDataException("Faltan los datos");
		if(item.isInvalid())
			throw new InvalidDataException(item.getErrorsMessages());
		if(getOne(item.getActorId()).isEmpty())
			throw new NotFoundException();
		return dao.save(item);
	}

	@Override
	public void delete(Actor item) throws InvalidDataException {
		if(item == null)
			throw new InvalidDataException("Faltan los datos");
		deleteById(item.getActorId());
	}

	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

}
