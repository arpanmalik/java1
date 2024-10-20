package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDao;
import com.luv2code.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner (StudentDao studentDao) {

		return runner -> {
//			createStudent(studentDao);
//			createMultipleStudent(studentDao);

//			readStudent(studentDao);

//			queryFromStudents(studentDao);

//			queryFromStudentsByLastName(studentDao);

//			updateStudent(studentDao);
//			deleteStudent(studentDao);
			deleteAllStudent(studentDao);
		};
	}

	private void deleteAllStudent(StudentDao studentDao) {
		System.out.println("===Deleting All Students=====");
		int numRows = studentDao.deleteAll();
		System.out.println("Deleted Rows :- " + numRows);
	}

	private void deleteStudent(StudentDao studentDao) {

		int id = 3;
		System.out.println("====Deleting=====");
		studentDao.delete(id);
	}

	private void updateStudent(StudentDao studentDao) {
		int theId = 1;
		System.out.println("===Retreiving student from Databse with id=1");

		Student theStudent = studentDao.findById(theId);

		System.out.println("==Updating==");

		theStudent.setFirstName("Scooby");

		studentDao.update(theStudent);

		System.out.print("Updated student:-" + theStudent);
	}

	private void queryFromStudentsByLastName(StudentDao studentDao) {
		List<Student> theStudents = studentDao.findByLastName("Harbour");

		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryFromStudents(StudentDao studentDao) {
		List<Student> theStudents = studentDao.findAll();

		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDao studentDao) {

//
//		Student studentTemp = new Student("Arpan", "Malik", "arpan@malik.com");
//
//		System.out.println("===Saving====");
//		studentDao.save(studentTemp);

		int theId = 5;

		System.out.println("===Retreiving===" + theId);

		Student myStudent = studentDao.findById(theId);

		System.out.println("Found Student : "+ myStudent);
	}

	private void createMultipleStudent(StudentDao studentDao) {
		System.out.println("Creating multiple students");

		Student studentTemp1 = new Student("John", "Harbour", "john@harbour.com");
		Student studentTemp2 = new Student("Radha", "Mohan", "radha@mohan.com");
		Student studentTemp3 = new Student("Akki", "Kumar", "akki@kumar.com");

		System.out.println("====Saving =======");

		studentDao.save(studentTemp1);
		studentDao.save(studentTemp2);
		studentDao.save(studentTemp3);

		System.out.println("=== Students saved ====");
	}

	private void createStudent(StudentDao studentDao) {

		System.out.println("Creating the student object");
		Student studentTemp = new Student("Paul", "Harbour", "paul@harbour.com");

		System.out.println("=============Saving==================");

		studentDao.save(studentTemp);

		System.out.println("Displaying the id of generated student");
		System.out.println(studentTemp.getId());
	}

}
