package ec.edu.uce;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.jpa.Membresia;
import ec.edu.uce.modelo.jpa.Cliente;
import ec.edu.uce.repository.jpa.IClienteRepo;
import ec.edu.uce.service.IMembresiaService;
import ec.edu.uce.service.IClienteService;
import ec.edu.uce.service.IGestorService;
import ec.edu.uce.service.IRegistroService;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	private static final Logger LOG= LogManager.getLogger(Application.class);

	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IMembresiaService membresiaService;
	
	@Autowired
	private IGestorService gestorService; 
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		LocalDateTime nac=LocalDateTime.of(2000, Month.JANUARY, 04, 4, 16); 
		//gestorService.IngresarCliente("124123", "Carlos", "Montalvo",nac , "N");
		
		//gestorService.IngresarCliente("124436", "Fernanda", "Garcia",nac.plusMonths(3) , "N");
		
		Membresia mem=new Membresia();
		mem.setCodigo("asd124142");
		mem.setNombre("Gym member platinum");
		mem.setValor(new BigDecimal(20.00));
		mem.setVigencia(LocalDate.now().plusMonths(1));
		mem.setCantidad(3);
		//membresiaService.ActualizarMembresiaService(mem);
		membresiaService.InsertarMembresiaService(mem);
		
		//gestorService.PagarMembresia("124123", "asd124142");
		
	}

}
