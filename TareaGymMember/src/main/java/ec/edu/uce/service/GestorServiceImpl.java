package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Membresia;
import ec.edu.uce.modelo.jpa.Cliente;
import ec.edu.uce.modelo.jpa.Factura;
import ec.edu.uce.modelo.jpa.Registro;

@Service
public class GestorServiceImpl implements IGestorService{

	private static final Logger LOG= LogManager.getLogger(GestorServiceImpl.class);
	
	@Autowired
	private IMembresiaService memServ;
	
	@Autowired
	private IClienteService cliService;
	
	@Autowired
	private IRegistroService regService;
	
	@Autowired
	private IFacturaService factService;

	@Override
	@Transactional
	public void IngresarCliente(String cedula, String Nombre, String Apellido, LocalDateTime FechaN, String Estado) {
		Cliente cliente=new Cliente();
		
		cliente.setNombre(Nombre);
		cliente.setApellido(Apellido);
		cliente.setCedula(cedula);
		cliente.setFechaNacimiento(FechaN);
		cliente.setEstado(Estado);
		
		this.cliService.InsertarClienteService(cliente);
		
	}

	@Transactional(value = TxType.REQUIRES_NEW)
	public void GenerarFactura(String cedula,BigDecimal valor,LocalDateTime fecha) {
		Factura factura=new Factura();
		factura.setCedula(cedula);
		factura.setValorPagado(valor);
		factura.setFechaPago(fecha);
		
		this.factService.InsertarFacturaService(factura);
	}
	
	@Override
	@Transactional
	public void PagarMembresia(String cedula, String codigo) {
		
		Cliente cliente=this.cliService.BuscarPorCedulaService(cedula);
		Membresia membresia=this.memServ.BuscarPorCodigoService(codigo);
		Registro registro=new Registro();
		
		registro.setFechaPago(LocalDateTime.now());
		registro.setValorPagado(membresia.getValor());
		registro.setCliente(cliente);
		registro.setMembresia(membresia);
		
		this.regService.InsertarRegistroService(registro);//A
		
		cliente.setEstado("P");
		this.cliService.ActualizarClienteService(cliente);//B
		
		membresia.setCantidad(membresia.getCantidad()+1);
		membresia.setCliente(cliente);
		this.memServ.ActualizarMembresiaService(membresia);//C
		
		this.GenerarFactura(cliente.getCedula(),registro.getValorPagado(),registro.getFechaPago());
		
	}

}
