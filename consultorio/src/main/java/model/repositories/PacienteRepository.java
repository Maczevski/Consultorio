package model.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.entities.Paciente;

public class PacienteRepository implements BasicCrud {

	private EntityManagerFactory emf;

    public PacienteRepository() {
        this.emf = Persistence.createEntityManagerFactory("BancoConsultorio");
    }
    
	@Override
	public Object create(Object object) {
		EntityManager em = emf.createEntityManager();
        Paciente paciente = (Paciente) object;
		try {
			em.getTransaction().begin();
			em.persist(paciente);
			em.getTransaction().commit();
			return paciente;
		} catch (Exception e) {
			System.err.println("Erro");
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public Object update(Object object) {
		EntityManager em = emf.createEntityManager();
        Paciente paciente = (Paciente) object;
		try {
			em.getTransaction().begin();
			em.merge(paciente);
			em.getTransaction().commit();
			return paciente;
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
        Paciente paciente = (Paciente) object;
        try {
            em.getTransaction().begin();
            paciente = em.find(Paciente.class, paciente.getId());
            if (paciente != null) {
                em.remove(paciente);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
        	System.err.println("Erro");
        } finally {
            em.close();
        }
	}

	@Override
	public Object findById(Object object) {
		EntityManager em = emf.createEntityManager();
		Paciente paciente = (Paciente) object;
        try {
            return em.find(Paciente.class, paciente.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
	}
	
	public Paciente findPacienteByNome(Paciente paciente) {
		EntityManager em = emf.createEntityManager();
		 try {
	            return em.createQuery("SELECT p FROM Paciente p WHERE p.nome = :nome", Paciente.class)
	            		.setParameter("nome", paciente.getNome()).getSingleResult();
	        } finally {
	            em.close();
	        }
	}

	
	public List<Paciente> findAllPacientes() {
		EntityManager em = emf.createEntityManager();
		try {
			return em.createQuery("SELECT p FROM Paciente p", Paciente.class).getResultList();
		} catch (Exception e) {
			System.err.println("Erro");
		} finally {
			em.close();
		}
		return null;
	}
	
	
	 public List<Paciente> buscarPacientesComEnderecos() {
	        EntityManager em = emf.createEntityManager();
	        try {
	            // Consulta JPQL para recuperar os pacientes com seus endereços
	            return em.createQuery("SELECT DISTINCT p FROM Paciente p LEFT JOIN FETCH p.enderecos", Paciente.class)
	                     .getResultList();
	        } finally {
	            em.close();
	        }
	    }
}
