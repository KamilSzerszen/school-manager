package org.example.users;

import jakarta.persistence.*;
import org.example.enums.SchoolClass;
import org.example.enums.Sex;
import org.example.enums.Subjects;

import java.util.Map;

@Entity
public class Students extends User{
    private SchoolClass schoolClass;
    @ElementCollection
    @CollectionTable(name = "student_grades", joinColumns = @JoinColumn(name = "student_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @Column(name = "grade")
    private Map<Subjects, Double> grades;


    public Students() {}

    public Students(String firstName, String lastName, int age, Sex sex, SchoolClass schoolClass,
                    Map<Subjects, Double> grades) {
        super(firstName, lastName, age, sex);
        this.schoolClass = schoolClass;
        this.grades = grades;
    }
}
