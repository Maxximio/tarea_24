package ec.edu.uce.modelo.jpa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="membresia")
public class Membresia {

	@Id
	@Column(name="mem_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_mem")
	@SequenceGenerator(name="seq_cuba",sequenceName = "seq_mem",allocationSize = 1)
	private Integer id;
	
	@Column(name="mem_codigo")
	private String codigo;
	
	@Column(name="mem_nombre")
	private String nombre;
	
	@Column(name="mem_vslor")
	private BigDecimal valor;
	
	@Column(name="mem_vigencia")
	private LocalDate vigencia;
	
	@Column(name="mem_cantidad")
	private Integer cantidad;
	
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getVigencia() {
		return vigencia;
	}

	public void setVigencia(LocalDate vigencia) {
		this.vigencia = vigencia;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
