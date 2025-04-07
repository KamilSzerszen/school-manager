package org.example.users;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.example.enums.Sex;
import org.example.enums.Subjects;
import java.util.Objects;
import java.util.Set;

@Entity
public class Teacher extends User {
    @Enumerated(EnumType.STRING)
    private Subjects subjects;
    private int salary;


    public Teacher(String firstName, String lastName, int age, Sex sex, Subjects subjects, int salary) {
        super(firstName, lastName, age, sex);
        this.subjects = subjects;
        this.salary = salary;
    }

    public Teacher() {
    }

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return salary == teacher.salary && Objects.equals(subjects, teacher.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subjects, salary);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "subjects=" + subjects +
                ", salary=" + salary +
                "} " + super.toString();
    }
}
