package com.lab.controlmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lab.controlmat.dto.Credenciales;
import com.lab.controlmat.dto.PersonasDTO;
import com.lab.controlmat.service.UsuarioService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1/usuario")
@RestController
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;

	@PostMapping(path = "/login")
	public int login(@RequestBody Credenciales credenciales) {
		return usuarioService.findExistUsuario(credenciales);
	}
	
	@PostMapping(path = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonasDTO> registro(@RequestBody PersonasDTO personaDto) throws JsonProcessingException {
		return new ResponseEntity<>(usuarioService.addPersona(personaDto), HttpStatus.OK);
	}

}


