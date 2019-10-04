package controller;

import java.util.List;
import javax.persistence.*;
import model.CheckoutDetails;
import model.ListItem;

public class CheckoutDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Library");
	
	public void insertNewListDetails(CheckoutDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	public List<CheckoutDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<CheckoutDetails> allDetails = em.createQuery("SELECT d FROM CheckoutDetails d").getResultList();
		return allDetails;
	}
	
	public CheckoutDetails searchForListById(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CheckoutDetails found = em.find(CheckoutDetails.class, id);
		em.close();
		return found;
	}
	
	public void deleteList(CheckoutDetails toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CheckoutDetails> typedQuery = em.createQuery("select li from CheckoutDetails li where li.id = :selectedID", CheckoutDetails.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedID", toDelete.getId());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		CheckoutDetails result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
}