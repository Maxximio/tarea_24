package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Cliente;
import ec.edu.uce.modelo.jpa.Factura;

@Transactional
@Repository
public class FacturaRepoImpl implements IFacturaRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void InsertarFactura(Factura fac) {
		this.entityManager.persist(fac);
	}

	@Override
	public void ActualizarFactura(Factura fac) {
		this.entityManager.merge(fac);
	}

	@Override
	public Factura BuscarPorCedula(String cedula) {
		Query miQuery= this.entityManager.createNativeQuery("select * from factura f where f.fact_cedula=:valor",Factura.class);
		miQuery.setParameter("valor", cedula);
		return (Factura) miQuery.getSingleResult();
	}

	@Override
	public void BorrarFactura(String cedula) {
		Factura borrado=this.BuscarPorCedula(cedula);
		this.entityManager.remove(borrado);
	}

}
