package ec.edu.uce.modelo.jpa;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@Column(name="cli_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cli")
	@SequenceGenerator(name="seq_cli",sequenceName = "seq_cli",allocationSize = 1)
	private Integer id;
		
	@Column(name="cli_cedula")
	private String cedula;
	
	@Column(name="cli_nombre")
	private String nombre;
	
	@Column(name="cli_apellido")
	private String apellido;
	
	@Column(name="cli_fecha")
	private LocalDateTime fechaNacimiento;
	
	@Column(name="cli_estado")
	private String estado;
	
	@OneToMany(mappedBy = "cliente",cascade=CascadeType.ALL)///////////////////////
	private List<Registro> registro;
	
	@OneToMany(mappedBy = "cliente",cascade=CascadeType.ALL)
	private List<Membresia> membresia;

	//set y get
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Registro> getRegistro() {
		return registro;
	}

	public void setRegistro(List<Registro> registro) {
		this.registro = registro;
	}

	public List<Membresia> getMembresia() {
		return membresia;
	}

	public void setMembresia(List<Membresia> membresia) {
		this.membresia = membresia;
	}

	
	
	
}
