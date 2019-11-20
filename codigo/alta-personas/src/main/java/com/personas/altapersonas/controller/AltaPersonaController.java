package com.personas.altapersonas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.personas.altapersonas.dto.AltaPersonaDto;
import com.personas.altapersonas.dto.RespuestaAltaPersonaDto;
import com.personas.altapersonas.service.AltaPersonaService;

@RestController
@RequestMapping("personas")
public class AltaPersonaController {

	@Autowired
	private AltaPersonaService altaPersonaService;

	@RequestMapping(path = "/altaPersona", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE) 
	public RespuestaAltaPersonaDto altaPersona(@RequestBody AltaPersonaDto altaPersonaDto) { 
		return altaPersonaService.altaPersona(altaPersonaDto);
	}
}
