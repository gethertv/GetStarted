package dev.gether.GetStarted;

import dev.gether.GetStarted.dao.StudentDAO;
import dev.gether.GetStarted.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudnet(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudent(studentDAO);

		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {

		// delete all
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Success deleted row count: "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1;

		studentDAO.delete(studentId);
	}

	private void updateStudnet(StudentDAO studentDAO) {

		// get the student by ID
		Student student = studentDAO.findById(1);

		// change first name
		student.setFirstName("gerber");

		// update
		studentDAO.update(student);

		// display
		System.out.println(student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get list of students
		List<Student> kowalski = studentDAO.findByLastName("Kowalski");

		// display
		for (Student student : kowalski) {
			System.out.println(student);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> students = studentDAO.findAll();


		// display
		for (Student student : students) {
			System.out.println(student);
		}


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

	private void createMultipleStudents(StudentDAO studentDAO) {
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
