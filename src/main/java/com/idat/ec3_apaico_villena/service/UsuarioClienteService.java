package com.idat.ec3_apaico_villena.service;

import java.util.List;

import com.idat.ec3_apaico_villena.dto.UsuarioClienteRequestDTO;
import com.idat.ec3_apaico_villena.model.UsuarioCliente;

public interface UsuarioClienteService {

	public void guardarUsuarioCliente(UsuarioClienteRequestDTO p);

	public void eliminarUsuarioCliente(Integer id);

	public void editarUsuarioCliente(UsuarioCliente c);

	public List<UsuarioCliente> listarUsuarioCliente();

	public UsuarioCliente UsuarioClienteById(Integer id);

}
