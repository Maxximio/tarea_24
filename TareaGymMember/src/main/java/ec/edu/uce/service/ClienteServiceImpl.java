package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Cliente;
import ec.edu.uce.repository.jpa.IClienteRepo;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteRepo cliRepo;

	@Override
	public void InsertarClienteService(Cliente cli) {
		this.cliRepo.InsertarCliente(cli);
	}

	@Override
	public void ActualizarClienteService(Cliente cli) {
		this.cliRepo.ActualizarCliente(cli);
	}

	@Override
	public Cliente BuscarPorCedulaService(String cedula) {
		return this.cliRepo.BuscarPorCedula(cedula);
	}

	@Override
	public void BorrarClienteService(String cedula) {
		this.cliRepo.BorrarCliente(cedula);
	}
	
	

}
