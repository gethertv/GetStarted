package dev.gether.GetStarted;

import dev.gether.GetStarted.dao.StudentDAO;
import dev.gether.GetStarted.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*

@SpringBootApplication
		(scanBasePackages = {"dev.gether.GetStarted"})

 */
@SpringBootApplication
public class GetStartedApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetStartedApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {

			//createStudent(studentDAO);

			//createMultipleSutudents(studentDAO);

			readStudent(studentDAO);

		};
	}

	private void readStudent(StudentDAO studentDAO) {

		// creeate
		System.out.println("Creating new studnet");
		Student student = new Student("Mariusz", "Poniatowski", "m.poniat@gmail.com");

		// save
		System.out.println("Saving the student");
		studentDAO.save(student);

		// display
		int idStudent = student.getId();
		System.out.println("ID: " + idStudent);

		// find in database
		Student myStudent = studentDAO.findById(idStudent);

		// display
		System.out.println("Found the student "+myStudent);

	}

	private void createMultipleSutudents(StudentDAO studentDAO) {
		// create
		System.out.println("Creating 3 students");
		Student student1 = new Student("Damian", "W_W", "gethertv@gmail.com");
		Student student2 = new Student("Tomasz", "Kowalski", "tomaszkow@gmail.com");
		Student student3 = new Student("Andrzej", "Kononowicz", "konandrzej@gmail.com");

		System.out.println("Saving the students");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

	}

	private void createStudent(StudentDAO studentDAO) {

		// create
		System.out.println("Creating new student");
		Student student = new Student("Damian", "W_W", "gethertv@gmail.com");

		// save
		System.out.println("Saving the student");
		studentDAO.save(student);

		// display
		System.out.println("Id: " + student.getId());

	}

}
