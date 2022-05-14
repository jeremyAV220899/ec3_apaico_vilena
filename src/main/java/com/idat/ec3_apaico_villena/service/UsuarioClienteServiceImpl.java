package com.idat.ec3_apaico_villena.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec3_apaico_villena.dto.UsuarioClienteRequestDTO;
import com.idat.ec3_apaico_villena.model.UsuarioCliente;
import com.idat.ec3_apaico_villena.repository.UsuarioClienteRepository;

@Service
public class UsuarioClienteServiceImpl implements UsuarioClienteService{
	
	@Autowired
	private UsuarioClienteRepository repository;
	
	@Override
	public void guardarUsuarioCliente(UsuarioClienteRequestDTO p) {
		UsuarioCliente usuarioCliente = new UsuarioCliente();
		usuarioCliente.setIdUsuario(p.getIdUsuario());
		usuarioCliente.setUsuario(p.getUsuario());
		usuarioCliente.setPassword(p.getPassword());
		usuarioCliente.setRol(p.getRol());
		repository.save(usuarioCliente);
	}
	
	@Override
	public void eliminarUsuarioCliente(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	@Override
	public void editarUsuarioCliente(UsuarioCliente c) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(c);
	}
	
	@Override
	public List<UsuarioCliente> listarUsuarioCliente() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	public UsuarioCliente UsuarioClienteById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
}
