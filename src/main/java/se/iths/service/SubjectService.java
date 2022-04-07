package se.iths.service;

import se.iths.entity.Subject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;

    public void createSubject(Subject subject) {
        entityManager.persist(subject);
    }

    public List<Subject> getAllSubjects() {
        String query = "SELECT s FROM Subject s";
        return entityManager.createQuery(query, Subject.class).getResultList();
    }

    public Subject getSubjectById(Long id) {
        return entityManager.find(Subject.class, id);
    }

    public void updateSubject(Subject subject) {
        entityManager.merge(subject);
    }

    public List<Subject> getSubjectByTeacherId(Long id) {
        String query = "SELECT s FROM Subject s WHERE s.teacher.id = :id";
        return entityManager.createQuery(query, Subject.class).setParameter("id", id).getResultList();
    }

}
