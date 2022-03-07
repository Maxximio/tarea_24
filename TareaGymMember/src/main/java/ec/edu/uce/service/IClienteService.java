package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.Cliente;

public interface IClienteService {

	void InsertarClienteService(Cliente cli);
	
	void ActualizarClienteService(Cliente cli);
	
	Cliente BuscarPorCedulaService(String cedula);
	
	void BorrarClienteService(String cedula);
}
