package com.personas.altapersonas.dto;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.personas.altapersonas.validacion.Validacion;

@Valid
public class AltaPersonaDto {

	@NotBlank(message = Validacion.COD_PAIS_NACIONALIDAD_OBLIGATORIO)
	private String codPaisNacionalidad;

	@NotBlank(message = Validacion.COD_TIPO_DOCUMENTO_OBLIGATORIO)
	private String codTipoDocumento ;

	@NotBlank(message = Validacion.COD_SEXO_OBLIGATORIO)
	private String codSexo;

	@NotNull(message = Validacion.FECHA_NACIMIENTO_OBLIGATORIO)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaNacimiento;

	@NotBlank(message = Validacion.NOMBRE_OBLIGATORIO)
	private String nombre;

	@NotBlank(message = Validacion.APELLIDO_OBLIGATORIO)
	private String apellido;

	@NotBlank(message = Validacion.NUMERDO_DOCUMENTO_OBLIGATORIO)
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
