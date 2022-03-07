package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Factura;
import ec.edu.uce.repository.jpa.IFacturaRepo;

@Service
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	private IFacturaRepo factRepo;
	
	@Override
	public void InsertarFacturaService(Factura fac) {
		this.factRepo.InsertarFactura(fac);
	}

	@Override
	public void ActualizarFacturaService(Factura fac) {
		this.factRepo.ActualizarFactura(fac);
	}

	@Override
	public Factura BuscarPorCedulaService(String cedula) {
		return this.factRepo.BuscarPorCedula(cedula);
	}

	@Override
	public void BorrarFacturaService(String cedula) {
		this.factRepo.BorrarFactura(cedula);
	}

}
