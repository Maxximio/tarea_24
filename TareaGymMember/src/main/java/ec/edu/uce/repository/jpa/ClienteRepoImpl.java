package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Cliente;

@Repository
@Transactional
public class ClienteRepoImpl implements IClienteRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void InsertarCliente(Cliente clie) {
		this.entityManager.persist(clie);
	}

	@Override
	public void ActualizarCliente(Cliente clie) {
		this.entityManager.merge(clie);
	}

	@Override
	public Cliente BuscarPorCedula(String cedula) {
		Query miQuery= this.entityManager.createNativeQuery("select * from cliente c where c.cli_cedula=:valor",Cliente.class);
		miQuery.setParameter("valor", cedula);
		return (Cliente) miQuery.getSingleResult();
	}

	@Override
	public void BorrarCliente(String cedula) {
		Cliente borrado=this.BuscarPorCedula(cedula);
		this.entityManager.remove(borrado);
	}

}
