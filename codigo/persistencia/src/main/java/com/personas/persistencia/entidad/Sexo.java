package com.personas.persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "SEXO")
public class Sexo {

	@Column(name = "COD_SEXO")
	private String codSexo;

	@Column(name = "DESC_SEXO")
	private String descSexo;

	public String getCodSexo() {
		return codSexo;
	}

	public void setCodSexo(String codSexo) {
		this.codSexo = codSexo;
	}

	public String getDescSexo() {
		return descSexo;
	}

	public void setDescSexo(String descSexo) {
		this.descSexo = descSexo;
	}


}
