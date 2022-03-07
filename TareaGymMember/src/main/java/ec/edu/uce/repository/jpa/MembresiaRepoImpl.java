package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Membresia;

@Repository
@Transactional
public class MembresiaRepoImpl implements IMembresiaRepo{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void InsertarMembresia(Membresia mem) {
		this.entityManager.persist(mem);
	}

	@Override
	public void ActualizarMembresia(Membresia mem){
		this.entityManager.merge(mem);
	}

	@Override
	public Membresia BuscarPorCodigo(String codigo) {
		Query miQuery= this.entityManager.createNativeQuery("select * from membresia m where m.mem_codigo=:valor",Membresia.class);
		miQuery.setParameter("valor", codigo);
		return (Membresia) miQuery.getSingleResult();
	}

	@Override
	public void BorrarMembresia(String codigo) {
		Membresia borrado=this.BuscarPorCodigo(codigo);	
		this.entityManager.remove(borrado);
	}

}
