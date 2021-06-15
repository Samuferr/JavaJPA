package dto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ProductDTO<E> {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("java-jpa");
		} catch (Exception e) {

		}
	}

	public ProductDTO() {
		this(null);
	}

	public ProductDTO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}

	public ProductDTO<E> openTransaction() {
		em.getTransaction().begin();
		return this;
	}

	public ProductDTO<E> closeTransaction() {
		em.getTransaction().commit();
		return this;
	}

	public ProductDTO<E> openCloseCreate(E entity) {
		return this.openTransaction().openCloseCreate(entity).closeTransaction();
	}
	
	public ProductDTO<E> create(E entity) {
		em.persist(entity);
		return this;

	}

	public List<E> findALL(){
		return this.findAll(10, 0);
	}
	
	public List<E> findAll(int limit, int offSet) {
		if (classe != null) {
			throw new UnsupportedOperationException("Classe nula.");
		}
		String jpql = "SELECT e FROM " + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(limit);
		query.setFirstResult(offSet);
		return query.getResultList();
	}
	
	
	public void close() {
		em.close();
	}
}
