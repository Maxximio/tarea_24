package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Membresia;
import ec.edu.uce.repository.jpa.IMembresiaRepo;

@Service
public class MembresiaServiceImpl implements IMembresiaService{

	@Autowired
	private IMembresiaRepo memRepo;

	@Override
	public void InsertarMembresiaService(Membresia mem) {
		this.memRepo.InsertarMembresia(mem);
	}

	@Override
	public void ActualizarMembresiaService(Membresia mem) {
		this.memRepo.ActualizarMembresia(mem);
	}

	@Override
	public Membresia BuscarPorCodigoService(String cod) {
		return this.memRepo.BuscarPorCodigo(cod);
	}

	@Override
	public void BorrarMembresiaService(String cod) {
		this.memRepo.BorrarMembresia(cod);
	}
	
	

}
