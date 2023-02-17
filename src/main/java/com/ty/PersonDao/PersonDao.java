package com.ty.PersonDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.PersonDto.Person;

public class PersonDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();

	}

	public void savePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.persist(person);
		entityTransaction.commit();
	}

	public void updatePerson(String email, Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person newPerson = entityManager.find(Person.class, email);
		if (newPerson != null) {

			person.setEmail(email);
			entityTransaction.begin();

			entityManager.merge(person);

			entityTransaction.commit();
		} else {
			System.out.println("Person not found");
		}
	}
	public String LoginPerson(String email)
	{
		EntityManager entityManager=getEntityManager();
		String jpql="SELECT p FROM Person p where p.email=?1";
		
		Query query= entityManager.createQuery(jpql);
		
		query.setParameter(1, email);
		Person person=(Person)query.getSingleResult();
		
		return person.getPassword();
		
		
	}
}
