package se.iths.service;

import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;

    public void createTeacher(Teacher teacher) {
        entityManager.persist(teacher);
    }

    public List<Teacher> getAllTeachers() {
        String query = "SELECT t FROM Teacher t";
        return entityManager.createQuery(query, Teacher.class).getResultList();
    }

    public Teacher getTeacherById(Long id) {
        return entityManager.find(Teacher.class, id);
    }

    public List<Teacher> getTeacherByEmail(String email) {
        String query = "SELECT t FROM Teacher t WHERE t.email = :email";
        return entityManager.createQuery(query, Teacher.class)
                .setParameter("email", email)
                .getResultList();
    }

    public void deleteTeacher(Long id) {
        Teacher teacher = entityManager.find(Teacher.class, id);
        entityManager.remove(teacher);
    }

    public void updateTeacher(Teacher teacher) {
        entityManager.merge(teacher);
    }


}
