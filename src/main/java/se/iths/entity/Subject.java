package se.iths.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Teacher teacher;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Student> students;

    public Subject(String name, Teacher teacher, List<Student> students) {
        this.name = name;
        this.teacher = teacher;
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.removeIf(s -> Objects.equals(s.getId(), student.getId()));
    }

    public boolean nameIsMissing() {
        return name == null;
    }
}
