package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.User;

public class CreateUserService {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("java-jpa");
		EntityManager em = emf.createEntityManager();
		
		User newUser = new User("Pedro", "pedro@gmail.com");
		em.getTransaction().begin();
		em.persist(newUser);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}