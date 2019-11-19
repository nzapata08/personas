package com.personas.persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "PAIS")
public class Pais {
	
	@Id
	@Column(name = "COD_PAIS")
	private String codPais;

	@Column(name = "DESC_PAIS")
	private String descPais;

	public String getCodPais() {
		return codPais;
	}
	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}
	public String getDescPais() {
		return descPais;
	}
	public void setDescPais(String descPais) {
		this.descPais = descPais;
	}



}
