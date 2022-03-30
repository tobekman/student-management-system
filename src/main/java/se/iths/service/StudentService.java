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
        return entityManager.createQuery("select s from Student s", Student.class).getResultList();
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

}
