package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.Membresia;

public interface IMembresiaService {

	void InsertarMembresiaService(Membresia mem);
	
	void ActualizarMembresiaService(Membresia mem);
	
	Membresia BuscarPorCodigoService(String cod);
	
	void BorrarMembresiaService(String cod);
}
