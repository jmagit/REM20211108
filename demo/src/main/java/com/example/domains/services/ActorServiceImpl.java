package com.example.domains.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.domains.contracts.repositories.ActorRepository;
import com.example.domains.contracts.services.ActorService;
import com.example.domains.entities.Actor;
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
	public Iterable<Actor> getAll(Sort sort) {
		return dao.findAll(sort);
	}

	@Override
	public Page<Actor> getAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public <T> List<T> getByProjection(Class<T> type) {
		return dao.findByActorIdIsNotNull(type);
	}

	@Override
	public <T> Iterable<T> getByProjection(Sort sort, Class<T> type) {
		return dao.findByActorIdIsNotNull(sort, type);
	}

	@Override
	public <T> Page<T> getByProjection(Pageable pageable, Class<T> type) {
		return dao.findByActorIdIsNotNull(pageable, type);
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
