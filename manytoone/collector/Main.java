package many_to_one.collector;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import many_to_one.dao.Studentdao;
import many_to_one.dto.School;
import many_to_one.dto.Student;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		School school = new School();
		Studentdao dao = new Studentdao();
		Student student = new Student();
		boolean repeat = true;
		do {
			System.out.println("Enter your choice");
			System.out.println("1.Save Student Details");
			System.out.println("2.Update Student Details");
			System.out.println("3.Delete Student Details");
			System.out.println("4.Fetch Student Details by ID ");
			System.out.println("5.Fetch All Student Details");
			System.out.println("6.Exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				Student s1 = new Student();
				System.out.println("enter the first student details");
				System.out.println("enter the name");
				String name1=sc.next();
				s1.setName(name1);
				System.out.println("enter the address");
				String add1=sc.next();
				s1.setAddress(add1);

				
				Student s2 = new Student();
				System.out.println("enter the second student details");
				System.out.println("enter the name");
				String name2=sc.next();
				s2.setName(name2);
				System.out.println("enter the address");
				String add2=sc.next();
				s2.setAddress(add2);

				
				
				Student s3 = new Student();
				System.out.println("enter the third student details");
				System.out.println("enter the name");
				String name3=sc.next();
				s3.setName(name3);
				System.out.println("enter the address");
				String add3=sc.next();
				s3.setAddress(add3);

				

				s1.setSchool(school);
				s2.setSchool(school);
				s3.setSchool(school);

				EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				EntityTransaction entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				entityManager.persist(s1);
				entityManager.persist(s2);
				entityManager.persist(s3);
				entityManager.persist(school);
				entityTransaction.commit();
			}
				break;

			case 2: {
				System.out.println("enter the id to be updated");
				int id = sc.nextInt();
				student.setId(id);
				System.out.println("enter the name to be updated");
				String name = sc.next();
				student.setName(name);

				dao.updateStudent(id, student);

			}
				break;

			case 3: {
				System.out.println("enter the id to be deleted");
				int id = sc.nextInt();
				student.setId(id);
				dao.deleteStudents(id);
			}
				break;

			case 4: {
				System.out.println("enter the id to display");
				int id = sc.nextInt();
				dao.findById(id);

			}
				break;

			case 5: {
				dao.findAll();

			}
				break;

			case 6: {
				System.out.println("**Thank You**");
				repeat = false;
			}
			}

		} while (repeat);

	}

}