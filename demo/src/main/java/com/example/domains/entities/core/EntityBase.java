package com.example.domains.entities.core;

import java.util.Set;

import javax.persistence.Transient;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public class EntityBase<T> {
	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator(); 
	
	@Transient
	public Set<ConstraintViolation<T>> getErrors() {
		return validator.validate((T) this );
	}

	@Transient
	public String getErrorsMessages() {
		StringBuilder sb = new StringBuilder("ERRORES: ");
		getErrors().forEach(f -> sb.append(f.getPropertyPath() + ": " + f.getMessage() + ". "));
		return sb.toString().trim();
	}

	@Transient
	public boolean isValid() {
		return getErrors().size() == 0;		
	}

	@Transient
	public boolean isInvalid() {
		return !isValid();		
	}

}
