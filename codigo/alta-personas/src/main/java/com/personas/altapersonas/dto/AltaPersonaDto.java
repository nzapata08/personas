package com.personas.altapersonas.dto;

import java.util.Date;

public class AltaPersonaDto {

	private String codPaisNacionalidad;

	private String codTipoDocumento ;

	private String codSexo;

	private Date fechaNacimiento;

	private String nombre;

	private String apellido;
	
	private String numeroDocumento;

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getCodPaisNacionalidad() {
		return codPaisNacionalidad;
	}
	public void setCodPaisNacionalidad(String codPaisNacionalidad) {
		this.codPaisNacionalidad = codPaisNacionalidad;
	}
	public String getCodTipoDocumento() {
		return codTipoDocumento;
	}
	public void setCodTipoDocumento(String codTipoDocumento) {
		this.codTipoDocumento = codTipoDocumento;
	}
	public String getCodSexo() {
		return codSexo;
	}
	public void setCodSexo(String codSexo) {
		this.codSexo = codSexo;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	@Override
	public String toString() {
		return "AltaPersonaDto [codPaisNacionalidad=" + codPaisNacionalidad + ", codTipoDocumento=" + codTipoDocumento
				+ ", codSexo=" + codSexo + ", fechaNacimiento=" + fechaNacimiento + ", nombre=" + nombre + ", apellido="
				+ apellido + ", numeroDocumento=" + numeroDocumento + "]";
	}

}
