package com.personas.altapersonas.dto;

public class RespuestaAltaPersonaDto {
	
	private String mensajeRespuesta;

	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}

	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}
	
	public RespuestaAltaPersonaDto () {
		
	}

	public RespuestaAltaPersonaDto(String mensajeRespuesta) {
		super();
		this.mensajeRespuesta = mensajeRespuesta;
	}
}
