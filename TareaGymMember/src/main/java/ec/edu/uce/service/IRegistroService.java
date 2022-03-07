package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.Registro;

public interface IRegistroService {

	void InsertarRegistroService(Registro reg);
	
	void ActualizarRegistroService(Registro reg);
	
	Registro BuscarPorCodigoService(String cod);
	
	void BorrarRegistroService(String cod);
}
