package com.personas.altapersonas.validacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Component;

import com.personas.altapersonas.excepcion.ValidationException;

@Component
public class ValidadorAltaPersona {

	private Validator validator;

	public ValidadorAltaPersona() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	public void validarDto(Object dto, String mensajeErrorValidacion) throws ValidationException {
		List<String> errores = new ArrayList<String>();
		if (dto == null) {errores.add(mensajeErrorValidacion);} 
		Set<ConstraintViolation<Object>> constraints = validator.validate(dto);
		constraints.stream().forEach((o) ->  errores.add(o.getMessage()) );
		if(!errores.isEmpty()) {
			throw new ValidationException(mensajeErrorValidacion, 400, errores);
		}
	}

}