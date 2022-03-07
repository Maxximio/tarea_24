package ec.edu.uce.modelo.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="factura")
public class Factura {

	@Id
	@Column(name="fact_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fact")
	@SequenceGenerator(name="seq_fact",sequenceName = "seq_fact",allocationSize = 1)
	private Integer id;
	
	@Column(name="fact_valor_pago")
	private BigDecimal valorPagado;
	
	@Column(name="fact_fecha_pago")
	private LocalDateTime fechaPago;
	
	@Column(name="fact_cedula")
	private String cedula;

	
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	
	
}
