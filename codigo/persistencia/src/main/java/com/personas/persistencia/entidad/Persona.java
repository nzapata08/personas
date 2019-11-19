package com.personas.persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "PERSONA")
public class Persona {

	@Id
	@Column(name = "ID_PERSONA")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "COD_PAIS_NACIONALIDAD")
	private Pais paisNacionalidad;

	@ManyToOne
	@JoinColumn(name = "COD_TIPO_DOCUMENTO")
	private TipoDocumento tipoDocumento ;

	@ManyToOne
	@JoinColumn(name = "COD_SEXO")
	private Sexo sexo;

	@Temporal(TemporalType.DATE)	
	@Column(name = "FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	@Column(name = "NOMBRE", length = 60)
	private String nombre;

	@Column(name = "APELLIDO", length = 25)
	private String apellido;
	
	@Column(name = "NUMERO_DOCUMENTO", length =20)
	private String numeroDocumento;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Pais getPaisNacionalidad() {
		return paisNacionalidad;
	}
	public void setPaisNacionalidad(Pais paisNacionalidad) {
		this.paisNacionalidad = paisNacionalidad;
	}
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
}
