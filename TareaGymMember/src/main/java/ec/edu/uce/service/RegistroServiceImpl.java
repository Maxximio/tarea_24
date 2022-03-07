package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Registro;
import ec.edu.uce.repository.jpa.IRegistroRepo;

@Service
public class RegistroServiceImpl implements IRegistroService{

	@Autowired
	private IRegistroRepo histoRepo;

	@Override
	public void InsertarRegistroService(Registro reg) {
		this.histoRepo.InsertarRegistro(reg);
	}

	@Override
	public void ActualizarRegistroService(Registro reg) {
		this.histoRepo.ActualizarRegistro(reg);
	}

	@Override
	public Registro BuscarPorCodigoService(String cod) {
		return this.histoRepo.BuscarPorCodigo(cod);
	}

	@Override
	public void BorrarRegistroService(String cod) {
		this.histoRepo.BorrarRegistro(cod);
	}
	
	
}
