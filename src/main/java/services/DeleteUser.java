package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.User;

public class DeleteUser {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();;
		
		User user = em.find(User.class, 2L);
		em.remove(user);
		
		em.getTransaction().commit();		
		
		
		em.close();
		emf.close();

	}

}
