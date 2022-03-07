package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Registro;

@Repository
@Transactional
public class RegistroRepoImpl implements IRegistroRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void InsertarRegistro(Registro reg) {
		this.entityManager.persist(reg);
	}

	@Override
	public void ActualizarRegistro(Registro reg) {
		this.entityManager.merge(reg);
	}

	@Override
	public Registro BuscarPorCodigo(String cod) {
		Query miQuery= this.entityManager.createNativeQuery("select r from registro r, membresia m where r.mem_id=m.mem_id and m.mem_codigo=:valor",Registro.class);
		miQuery.setParameter("valor", cod);
		return (Registro) miQuery.getSingleResult();
	}

	@Override
	public void BorrarRegistro(String cod) {
		Registro borrado=this.BuscarPorCodigo(cod);
		this.entityManager.remove(borrado);
	}

}
