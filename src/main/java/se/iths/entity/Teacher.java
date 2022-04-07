package se.iths.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "teacher")
    private List<Subject> subjects;

    public Teacher(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public boolean informationIsMissing() {
        return firstName == null || lastName == null || email == null;
    }

    public boolean phoneNumberIsMissing() {
        return phoneNumber == null;
    }

    @JsonbTransient
    public List<Subject> getSubjects() {
        return subjects;
    }
}
