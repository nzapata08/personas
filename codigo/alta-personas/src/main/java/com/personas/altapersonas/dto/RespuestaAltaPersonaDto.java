package com.personas.altapersonas.dto;

import java.util.ArrayList;
import java.util.List;

public class RespuestaAltaPersonaDto {

	private List<String> listaErrores = new ArrayList<String>();
	private Integer estado;

	public RespuestaAltaPersonaDto() {
		super();
	}

	public RespuestaAltaPersonaDto(Integer estado) {
		super();
		this.estado = estado;
	}
	public List<String> getListaErrores() {
		return listaErrores;
	}
	public void setListaErrores(List<String> listaErrores) {
		this.listaErrores = listaErrores;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public void addError(String error) {
		if(listaErrores == null) {
			listaErrores = new ArrayList<String>();
		}
		listaErrores.add(error);
	}

}
