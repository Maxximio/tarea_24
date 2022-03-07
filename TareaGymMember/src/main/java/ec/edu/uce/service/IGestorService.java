package ec.edu.uce.service;

import java.time.LocalDateTime;

public interface IGestorService {

	void IngresarCliente(String cedula,String Nombre,String Apellido,LocalDateTime FechaN,String Estado);
	
	void PagarMembresia(String cedula,String codigo);
	
}
