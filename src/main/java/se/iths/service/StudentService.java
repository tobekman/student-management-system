package se.iths.service;

import se.iths.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public void createStudent(Student student) {
        entityManager.persist(student);
    }

    public List<Student> getAllStudents() {
        String query = "select s from Student s";
        return entityManager.createQuery(query, Student.class).getResultList();
    }

    public Student getStudentWithId(Long id) {
        return entityManager.find(Student.class, id);
    }

    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    public void deleteStudent(Long id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    public List<Student> getStudentWithLastName(String lastName) {
        String query = "SELECT s FROM Student s WHERE s.lastName = :lastName";
        return entityManager.createQuery(query, Student.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

}
