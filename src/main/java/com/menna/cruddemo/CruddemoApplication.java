package com.menna.cruddemo;

import com.menna.cruddemo.dao.StudentDAO;
import com.menna.cruddemo.dao.StudentDAOImp;
import com.menna.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class CruddemoApplication {

	private final StudentDAOImp studentDAOImp;
	Scanner scanner = new Scanner(System.in);

	public CruddemoApplication(StudentDAOImp studentDAOImp) {
		this.studentDAOImp = studentDAOImp;
	}

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			welcomeMessage();

			while(true) {
				mainMenu();

				System.out.println("Please enter your choice: ");
				int choice = scanner.nextInt();

				switch (choice) {
					case 1:
						createStudent(studentDAO);
						break;
					case 2:
						updateStudent(studentDAO);
						break;
					case 3:
						deleteStudent(studentDAO);
						break;
					case 4:
						printAllStudents(studentDAO);
						break;
					case 5:
						System.out.println("Exiting, Goodbye:)");
						System.exit(0);
					default:
						System.out.println("Invalid choice");
						break;
				}
			}
		};
	}

	private void welcomeMessage() {
		System.out.println("===== Welcome to Crud Demo Application =====");
		System.out.println("============================================\n");
	}

	private void mainMenu() {
		System.out.println("=== Menu ===");
		System.out.println("1. Create Student");
		System.out.println("2. Update Student");
		System.out.println("3. Delete Student");
		System.out.println("4. Print All Students");
		System.out.println("5. Exit");
	}

	private void createStudent(StudentDAO studentDAO) {

		scanner.nextLine();

		System.out.println("Please enter your first name : ");
		String firstName = scanner.nextLine();

		System.out.println("Please enter your last name : ");
		String lastName = scanner.nextLine();

		System.out.println("Please enter your email : ");
		String email = scanner.nextLine();

		System.out.println("\nCreating new student...");
		Student student = new Student(firstName, lastName, email);

		System.out.println("Saving student...");
		studentDAO.save(student);

		System.out.println("Student " + student.getFirstName() + " " + student.getLastName() + " saved successfully.");
		System.out.println("Student ID: " + student.getId());
		System.out.println("===================================\n");
	}

	private void updateStudent(StudentDAO studentDAO) {
		System.out.println("Enter student ID: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		Student student = studentDAO.findById(id);

		if (student == null) {
			System.out.println("Student not found!");
			return;
		}

		else {
			System.out.println("Student " + student.getFirstName() + " " + student.getLastName());

			System.out.println("Enter new first name: ");
			String firstName = scanner.nextLine();

			System.out.println("Enter new last name: ");
			String lastName = scanner.nextLine();

			System.out.println("Enter new email: ");
			String email = scanner.nextLine();

			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setEmail(email);

			studentDAO.update(student);
			System.out.println("Updating student...");

			System.out.println("==== Student updated successfully ====");
			System.out.println("Student New First name: " + student.getFirstName());
			System.out.println("Student New Last name: " + student.getLastName());
			System.out.println("Student New Email: " + student.getEmail());


			System.out.println("===================================\n");
		}
	}

	private void deleteStudent(StudentDAO studentDAO) {

		System.out.println("Enter student ID: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		Student student = studentDAO.findById(id);
		if (student == null) {
			System.out.println("Student not found!");
			return;
		}

		else {
			studentDAO.delete(student);
			System.out.println("Deleting student...");
			System.out.println("Student " + student.getFirstName() + " " + student.getLastName() + " deleted successfully.");
			System.out.println("===================================\n");
		}
	}

	private void printAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for(Student student : students) {
			System.out.println("=================================");
			System.out.println("ID: " + student.getId());
			System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
			System.out.println("Email: " + student.getEmail());
		}
	}
}
