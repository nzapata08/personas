package com.personas.persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "TIPO_DOCUMENTO")
public class TipoDocumento {

	@Id
	@Column(name = "COD_TIPO_DOCUMENTO")
	private String codTipoDocumento;

	@Column(name = "DESC_TIPO_DOCUMENTO")
	private String descTipoDocumento;

	public String getCodTipoDocumento() {
		return codTipoDocumento;
	}

	public void setCodTipoDocumento(String codTipoDocumento) {
		this.codTipoDocumento = codTipoDocumento;
	}

	public String getDescTipoDocumento() {
		return descTipoDocumento;
	}

	public void setDescTipoDocumento(String descTipoDocumento) {
		this.descTipoDocumento = descTipoDocumento;
	}



}
