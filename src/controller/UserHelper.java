package controller;


import java.util.List;

import javax.persistence.*;

import model.CheckoutDetails;
import model.ListItem;
import model.User;

//package and import statements
public class UserHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Library");
	public void insertUser(User s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<User> showAllUsers() {
		EntityManager em = emfactory.createEntityManager();
		List<User> allUsers = em.createQuery("SELECT s FROM User s").getResultList();
		return allUsers;
	}
	
	public User searchForUserById(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		User found = em.find(User.class, id);
		em.close();
		return found;
	}
	
	public void deleteUser(User toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<User> typedQuery = em.createQuery("select ui from User ui where ui.id = :selectedID", User.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedID", toDelete.getId());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		User result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
}