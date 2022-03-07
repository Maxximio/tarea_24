package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.Cliente;

public interface IClienteRepo {

	void InsertarCliente(Cliente clie);
	
	void ActualizarCliente(Cliente clie);
	
	Cliente BuscarPorCedula(String cedula);

	void BorrarCliente(String cedula);
	
}
