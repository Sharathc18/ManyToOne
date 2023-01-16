package many_to_one.dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_one.dto.School;
import many_to_one.dto.Student;


public class Studentdao {
	public EntityManager getEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
		
	}
	public void saveStudent(Student student)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		School school=student.getSchool();
		entityTransaction.begin();
		entityManager.persist(student);
		entityManager.persist(school);
		entityTransaction.commit();
		
		
	}
	public void updateStudent(int id,Student student)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		Student receivedStudents = entityManager.find(Student.class, id);
	
		if (receivedStudents != null) {
			student.setId(id);
			student.setSchool(receivedStudents.getSchool());
			
			entityManager.merge(student);
			entityTransaction.commit();
			
		} else {
			System.out.println("not found");
			
		}
	}

public void deleteStudents(int id)

{
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	Student receivedStudent = entityManager.find(Student.class, id);
	if (receivedStudent != null) {
		
		entityManager.remove(receivedStudent);
		entityTransaction.commit();
	}else {
		System.out.println("not found");
	}
	
}
	public void findById(int id)
	{
		EntityManager entityManager=getEntityManager();
		Student students=entityManager.find(Student.class, id);
		System.out.println(students);
		
		
	}
	public void findAll()
	{
		
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select s from Student s");
		System.out.println(query);
		
	}
	}
