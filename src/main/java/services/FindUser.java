package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.User;

public class FindUser {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-jpa");;
		EntityManager em = emf.createEntityManager();
		
		User user = em.find(User.class, 4L);
		System.out.println(user.getName());
		
		em.close();
		emf.close();
		

	}

}
