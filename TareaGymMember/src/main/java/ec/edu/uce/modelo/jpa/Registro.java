package ec.edu.uce.modelo.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="registro")
public class Registro {

	@Id
	@Column(name="regis_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_regis")
	@SequenceGenerator(name="seq_regis",sequenceName = "seq_regis",allocationSize = 1)
	private Integer id;
	
	@Column(name="regis_valor_pago")
	private BigDecimal valorPagado;
	
	@Column(name="regis_fecha_pago")
	private LocalDateTime fechaPago;
	
	@ManyToOne
	@JoinColumn(name="mem_id")
	private Membresia membresia;
	
	@ManyToOne
	@JoinColumn(name="cli_id")
	private Cliente cliente;

	//set y get
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValorPagado() {
		return valorPagado;
	}

	public void setValorPagado(BigDecimal valorPagado) {
		this.valorPagado = valorPagado;
	}

	public LocalDateTime getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDateTime fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Membresia getMembresia() {
		return membresia;
	}

	public void setMembresia(Membresia membresia) {
		this.membresia = membresia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
}

