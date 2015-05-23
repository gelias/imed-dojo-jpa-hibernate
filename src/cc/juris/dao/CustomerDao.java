package cc.juris.dao;

import javax.persistence.EntityManager;

import cc.juris.model.Customer;

public class CustomerDao {

	
	private EntityManager entityManager;

	public CustomerDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void add(Customer customer){
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(customer);
			entityManager.getTransaction().commit();	
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public Customer findById(Long id){
		return entityManager.find(Customer.class, id);
	}
	
	public boolean delete(Long id){
		Customer customerFound = entityManager.find(Customer.class, id);
		if(customerFound == null)
			return false;
		
		entityManager.remove(customerFound);
		return true;
	}
	
	public Customer update(Customer customer){
		entityManager.merge(customer);
		return customer;
	}
}
