package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
			createStudents(studentDAO);
//			queryStudents(studentDAO);
//			queryStudentsByLastname(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int deletedStudentCount = studentDAO.deleteAll();
		System.out.println("Number of deleted Students " + deletedStudentCount);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.delete(1);
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		student.setFirstName("Janes");
		studentDAO.update(student);
	}

	private void queryStudentsByLastname(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Doe");

		for (Student student: students) {
			System.out.println(student);
		}
	}

	private void queryStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for (Student student: students) {
			System.out.println(student);
		}
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("Jane", "Doe", "jane.doe@gmail.com");

		studentDAO.save(student);

		System.out.println("Saved student:" + student.getId());
	}

	private void createStudents(StudentDAO studentDAO) {
		Student student1 = new Student("Jane", "Doe", "jane.doe@gmail.com");
		Student student2 = new Student("John", "Smith", "john.smith@gmail.com");
		Student student3 = new Student("Dean", "Winchester", "dean.winchester@gmail.com");

		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

}
