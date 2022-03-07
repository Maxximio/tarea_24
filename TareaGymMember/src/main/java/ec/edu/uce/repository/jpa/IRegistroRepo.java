package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.Registro;

public interface IRegistroRepo {

	void InsertarRegistro(Registro reg);
	
	void ActualizarRegistro(Registro reg);
	
	Registro BuscarPorCodigo(String cod);

	void BorrarRegistro(String cod);
}
