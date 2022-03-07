package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.Factura;

public interface IFacturaService {

	void InsertarFacturaService(Factura fac);
	
	void ActualizarFacturaService(Factura fac);
	
	Factura BuscarPorCedulaService(String cedula);

	void BorrarFacturaService(String cedula);
	
}
