package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.User;

public class FindAllUser {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-jpa");
		EntityManager em = emf.createEntityManager();

		String jpql = "SELECT u FROM User u";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setMaxResults(5);
		
		List<User> users = query.getResultList();
		
		for(User user : users) {
			System.out.print("Id: " + user.getId() + "Email: " + user.getEmail());
		}
		
		em.close();
		emf.close();

	}

}
