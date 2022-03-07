package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.Membresia;

public interface IMembresiaRepo {

	void InsertarMembresia(Membresia mem);
	
	void ActualizarMembresia(Membresia mem);
	
	Membresia BuscarPorCodigo(String codigo);

	void BorrarMembresia(String codigo);
	
}
