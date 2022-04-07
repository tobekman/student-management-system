package se.iths.util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Startup
public class SampleDataGenerator {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData() {

        Student student1 = new Student("Brad", "Pitt", "bigpitt@hotmail.com", "0785156521");
        Student student2 = new Student("George", "Clooney", "handsomeandcool@hotmail.com", "5166484488");
        Student student3 = new Student("Angelina", "Jolie", "classylady@hotmail.com", "8415154846");
        Student student4 = new Student("Scarlett", "Johansson", "warrior23@hotmail.com", "546168188");
        Student student5 = new Student("Dwayne", "Johnson", "therock@hotmail.com", "5489415618");
        Student student6 = new Student("Emma", "Stone", "thestone@hotmail.com", "0785156521");
        Student student7 = new Student("Benedict", "Cumberbatch", "cumben@hotmail.com", "8718946512");

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);

        Teacher teacher1 = new Teacher("Kate", "Winslet", "teacher1@school.com", "084615540");
        Teacher teacher2 = new Teacher("Leonardo", "DiCaprio", "teacher2@school.com", "0708845123");
        Teacher teacher3 = new Teacher("Denzel", "Washington", "teacher3@school.com", "07070809051");
        Teacher teacher4 = new Teacher("Meryl", "Streep", "teacher4@school.com", "0874605464");

        Subject subject1 = new Subject("Programming", teacher1,students);
        Subject subject2 = new Subject("Biology", teacher2, students);
        Subject subject3 = new Subject("Algebra", teacher3, students);
        Subject subject4 = new Subject("Geometry", teacher3, students);
        Subject subject5 = new Subject("Philosophy", teacher4, students);
        Subject subject6 = new Subject("Political Science", teacher4, students);

        entityManager.persist(subject1);
        entityManager.persist(subject2);
        entityManager.persist(subject3);
        entityManager.persist(subject4);
        entityManager.persist(subject5);
        entityManager.persist(subject6);

    }
}
