package com.personas.altapersonas.excepcion;

import java.util.ArrayList;
import java.util.List;

public class ValidationException extends Exception {

	private static final long serialVersionUID = 1L;

	private Integer codErrorValidacion;
	private List<String> erroresValidacion;

	public ValidationException(String mensaje, Integer codErrorValidacion) {
		super(mensaje);
		this.setCodErrorValidacion(codErrorValidacion);
	}

	public ValidationException(String mensaje, Integer codErrorValidacion, List<String> erroresValidacion) {
		super(mensaje);
		this.setCodErrorValidacion(codErrorValidacion);
		this.erroresValidacion = erroresValidacion;
	}

	public Integer getCodErrorValidacion() {
		return codErrorValidacion;
	}

	public void setCodErrorValidacion(Integer codErrorValidacion) {
		this.codErrorValidacion = codErrorValidacion;
	}

	public void addErrorValidacion(String errorValidacion) {
		if(erroresValidacion == null) {
			erroresValidacion = new ArrayList<>();
		}
		erroresValidacion.add(errorValidacion);
	}

	public List<String> getErroresValidacion() {
		return erroresValidacion;
	}

	public void setErroresValidacion(List<String> erroresValidacion) {
		this.erroresValidacion = erroresValidacion;
	}

}
