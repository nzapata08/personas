package com.personas.altapersonas.service.impl;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personas.altapersonas.dto.AltaPersonaDto;
import com.personas.altapersonas.dto.RespuestaAltaPersonaDto;
import com.personas.altapersonas.service.AltaPersonaService;
import com.personas.persistencia.dao.PaisDao;
import com.personas.persistencia.dao.PersonaDao;
import com.personas.persistencia.dao.SexoDao;
import com.personas.persistencia.dao.TipoDocumentoDao;
import com.personas.persistencia.entidad.Persona;


@Service
@Transactional
public class AltaPersonasServiceImpl implements AltaPersonaService {

	@Autowired
	private PersonaDao personaDao;

	@Autowired
	private PaisDao paisDao;

	@Autowired
	private SexoDao sexoDao;

	@Autowired
	private TipoDocumentoDao tipoDocumentoDao;

	public RespuestaAltaPersonaDto altaPersona(AltaPersonaDto altaPersonaDto) {
		System.out.println(altaPersonaDto.toString());
		if(!existePersona(altaPersonaDto)) {
			personaDao.save(mapAltaPersonaDto(altaPersonaDto));
		} else {
			return new RespuestaAltaPersonaDto("Ya existe persona");
		}
		return new RespuestaAltaPersonaDto("Successfully");
	}

	private boolean existePersona(AltaPersonaDto altaPersonaDto) { 
		Persona persona = personaDao.find(altaPersonaDto.getCodTipoDocumento(), altaPersonaDto.getNumeroDocumento(), altaPersonaDto.getCodPaisNacionalidad(), altaPersonaDto.getCodSexo());
		return persona != null;
	}

	private boolean datosDeEntradaValidos(AltaPersonaDto altaPersonaDto, RespuestaAltaPersonaDto respuestaAltaPersonaDto) {
		validarInput(altaPersonaDto.getApellido(), "El apellido es obligatorio ", respuestaAltaPersonaDto);
		validarInput(altaPersonaDto.getApellido(), "El nombre es obligatorio ", respuestaAltaPersonaDto);
		validarInput(altaPersonaDto.getApellido(), "El codigo del tipo de documento es obligatorio ", respuestaAltaPersonaDto);
		validarInput(altaPersonaDto.getApellido(), "El codigo de pais es obligatorio ", respuestaAltaPersonaDto);
		validarInput(altaPersonaDto.getApellido(), "El apellido es obligatorio ", respuestaAltaPersonaDto);

	}

	private Persona mapAltaPersonaDto(AltaPersonaDto altaPersonaDto) {
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

	private void validarInput(String input, String mensaje, RespuestaAltaPersonaDto respuesta) {
		if(StringUtils.isBlank(input)) {
			respuesta.setMensajeRespuesta(respuesta.getMensajeRespuesta() + mensaje);
		} 
	}
}
