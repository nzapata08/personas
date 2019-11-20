package com.personas.altapersonas.service.impl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personas.altapersonas.dto.AltaPersonaDto;
import com.personas.altapersonas.dto.RespuestaAltaPersonaDto;
import com.personas.altapersonas.excepcion.ValidationException;
import com.personas.altapersonas.service.AltaPersonaService;
import com.personas.altapersonas.validacion.Validacion;
import com.personas.altapersonas.validacion.ValidadorAltaPersona;
import com.personas.persistencia.dao.PaisDao;
import com.personas.persistencia.dao.PersonaDao;
import com.personas.persistencia.dao.SexoDao;
import com.personas.persistencia.dao.TipoDocumentoDao;
import com.personas.persistencia.entidad.Persona;


@Service
@Transactional(rollbackOn = Exception.class)
public class AltaPersonasServiceImpl implements AltaPersonaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AltaPersonasServiceImpl.class);

	@Autowired
	private PersonaDao personaDao;

	@Autowired
	private PaisDao paisDao;

	@Autowired
	private SexoDao sexoDao;

	@Autowired
	private TipoDocumentoDao tipoDocumentoDao;

	@Autowired
	private ValidadorAltaPersona validadorAltaPersona;


	public RespuestaAltaPersonaDto altaPersona(AltaPersonaDto altaPersonaDto) {
		RespuestaAltaPersonaDto respuesta = new RespuestaAltaPersonaDto(200);
		try { 
			validadorAltaPersona.validarDto(altaPersonaDto, Validacion.SOLICITUD_ALTA_PERSONA);
			if(!existePersona(altaPersonaDto) && esMayorDeEdad(altaPersonaDto)) {
				personaDao.save(mapAltaPersonaDtoAPersona(altaPersonaDto));
				respuesta.setEstado(200);
			}
			return respuesta;
		} catch (ValidationException e ) {
			LOGGER.info("Error de validacion" + e.getMessage());
			respuesta.setListaErrores(e.getErroresValidacion());
			respuesta.setEstado(e.getCodErrorValidacion());

		} catch (Exception e ) {
			LOGGER.error(Validacion.ERROR_AL_PROCESAR_LA_SOLICITUD, e);
			respuesta.addError(Validacion.ERROR_AL_PROCESAR_LA_SOLICITUD);
			respuesta.setEstado(500);
		}
		return respuesta;
	}

	private boolean existePersona(AltaPersonaDto altaPersonaDto) throws ValidationException { 
		Persona persona = personaDao.find(altaPersonaDto.getCodTipoDocumento(), altaPersonaDto.getNumeroDocumento(), altaPersonaDto.getCodPaisNacionalidad(), altaPersonaDto.getCodSexo());
		if(persona != null) {
			ValidationException errorEnValidacion = new ValidationException(Validacion.YA_EXISTE_PERSONA, 400);
			errorEnValidacion.addErrorValidacion(Validacion.YA_EXISTE_PERSONA);
			throw errorEnValidacion;
		}
		return false;
	}

	private Persona mapAltaPersonaDtoAPersona(AltaPersonaDto altaPersonaDto) {
		Persona persona = new Persona();

		persona.setApellido(altaPersonaDto.getApellido());
		persona.setNombre(altaPersonaDto.getNombre());
		persona.setSexo(sexoDao.findById(altaPersonaDto.getCodSexo()).get());
		persona.setTipoDocumento(tipoDocumentoDao.findById(altaPersonaDto.getCodTipoDocumento()).get());
		persona.setPaisNacionalidad(paisDao.findById(altaPersonaDto.getCodPaisNacionalidad()).get());
		persona.setNumeroDocumento(altaPersonaDto.getNumeroDocumento());
		persona.setFechaNacimiento(altaPersonaDto.getFechaNacimiento());

		return persona;
	}

	private boolean esMayorDeEdad(AltaPersonaDto altaPersonaDto) throws ValidationException {
		LocalDate fechaHoy = LocalDate.now();
		int edad = fechaHoy.getYear() - getLocalDateFechaNacimiento(altaPersonaDto.getFechaNacimiento()).getYear();
		if (edad < 18) {
			ValidationException errorEnValidacion = new ValidationException(Validacion.NO_ES_MAYOR_DE_EDAD, 400);
			errorEnValidacion.addErrorValidacion(Validacion.NO_ES_MAYOR_DE_EDAD);
			throw errorEnValidacion;
		}
		return true;
	}

	private LocalDate getLocalDateFechaNacimiento(Date fechaNacimiento) {
		Instant instant = Instant.ofEpochMilli(fechaNacimiento.getTime());
		LocalDate fecha = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
		return fecha;
	}



}
