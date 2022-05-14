package com.idat.ec3_apaico_villena.service;

import java.util.List;

import com.idat.ec3_apaico_villena.dto.ClienteRequestDTO;
import com.idat.ec3_apaico_villena.model.Cliente;

public interface ClienteService {

	public void guardarCliente(ClienteRequestDTO p);

	public void eliminarCliente(Integer id);

	public void editarCliente(Cliente c);

	public List<Cliente> listarClientes();

	public Cliente ClienteById(Integer id);

}
