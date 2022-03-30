package se.iths.util;

import se.iths.entity.Student;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
        entityManager.persist(student4);
        entityManager.persist(student5);
        entityManager.persist(student6);
        entityManager.persist(student7);
    }
}
