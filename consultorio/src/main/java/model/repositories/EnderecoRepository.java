package model.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.entities.Endereco;

public class EnderecoRepository implements BasicCrud {

	private EntityManagerFactory emf;

	public EnderecoRepository() {
		this.emf = Persistence.createEntityManagerFactory("BancoConsultorio");
	}

	@Override
	public Object create(Object object) {
		EntityManager em = emf.createEntityManager();
		Endereco endereco = (Endereco) object;
		try {
			em.getTransaction().begin();
			em.persist(endereco);
			em.getTransaction().commit();
			return endereco;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public Object update(Object object) {
		EntityManager em = emf.createEntityManager();
		Endereco endereco = (Endereco) object;
		try {
			em.getTransaction().begin();
			em.merge(endereco);
			em.getTransaction().commit();
			return endereco;
		} catch (Exception e) {
			System.err.println("Erro");
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public void delete(Object object) {
		EntityManager em = emf.createEntityManager();
		Endereco endereco = (Endereco) object;
		try {
			em.getTransaction().begin();
			endereco = em.find(Endereco.class, endereco.getId());
			if (endereco != null) {
				em.remove(endereco);
			}
		} catch (Exception e) {
			System.err.println("Erro");
		} finally {
			em.close();
		}
	}

	@Override
	public Object findById(Object object) {
		EntityManager em = emf.createEntityManager();
		Endereco endereco = (Endereco) object;
		try {
			return em.find(Endereco.class, endereco.getClass());
		} catch (Exception e) {
			System.err.println("Erro");
		} finally {
			em.close();
		}

		return null;
	}
	
	public List<Endereco> findEnderecosByPacienteId(Long pacienteId) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT e FROM Endereco e WHERE e.paciente.id = :pacienteId", Endereco.class)
                     .setParameter("pacienteId", pacienteId)
                     .getResultList();
        } finally {
            em.close();
        }
    }
	
	public List<Endereco> findAllEnderecos(){
		EntityManager em = emf.createEntityManager();
		try {
			return em.createQuery("SELECT e FROM Endereco", Endereco.class).getResultList();
		} catch (Exception e) {
			System.err.println("Erro");
		}finally {
			em.close();
		}
		return null;
	}

}
