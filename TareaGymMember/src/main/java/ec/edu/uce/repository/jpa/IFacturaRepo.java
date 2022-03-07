package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.Factura;

public interface IFacturaRepo {

	void InsertarFactura(Factura fac);
	
	void ActualizarFactura(Factura fac);
	
	Factura BuscarPorCedula(String cedula);

	void BorrarFactura(String cedula);
	
}
