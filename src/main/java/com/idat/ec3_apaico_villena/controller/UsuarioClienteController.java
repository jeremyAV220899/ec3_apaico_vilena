package com.idat.ec3_apaico_villena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.ec3_apaico_villena.dto.UsuarioClienteRequestDTO;
import com.idat.ec3_apaico_villena.model.UsuarioCliente;
import com.idat.ec3_apaico_villena.service.UsuarioClienteService;

@RestController
@RequestMapping("/UsuarioCliente/v1")
public class UsuarioClienteController {

	@Autowired
	private UsuarioClienteService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public ResponseEntity<List<UsuarioCliente>>listar(){
		
		return new ResponseEntity<List<UsuarioCliente>>(service.listarUsuarioCliente(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody UsuarioClienteRequestDTO usuarioCliente){
		service.guardarUsuarioCliente(usuarioCliente);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar/{id}")
	public @ResponseBody ResponseEntity<UsuarioCliente> clientsById(@PathVariable Integer id){
		UsuarioCliente usuarioCliente = service.UsuarioClienteById(id);
		if(usuarioCliente != null) {
			return new ResponseEntity<UsuarioCliente>(usuarioCliente, HttpStatus.OK);

		}
		return new ResponseEntity<UsuarioCliente>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		UsuarioCliente usuarioCliente = service.UsuarioClienteById(id);
		if(usuarioCliente != null) {
			service.editarUsuarioCliente(usuarioCliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody UsuarioCliente usuarioClientes){
		UsuarioCliente usuarioCliente = service.UsuarioClienteById(usuarioClientes.getIdUsuario());
		if(usuarioCliente != null) {
			service.editarUsuarioCliente(usuarioCliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
