package org.example.users;

import org.example.enums.SchoolClass;
import org.example.enums.Sex;
import org.example.enums.Subjects;

import java.util.Objects;
import java.util.Set;

public class Teacher extends User {
    private Set<Subjects> subjects;
    private int salary;
    private SchoolClass schoolClass;

    public Teacher(String firstName, String lastName, int age, Sex sex, Set<Subjects> subjects, int salary, SchoolClass schoolClass) {
        super(firstName, lastName, age, sex);
        this.subjects = subjects;
        this.salary = salary;
        this.schoolClass = schoolClass;
    }

    public Set<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subjects> subjects) {
        this.subjects = subjects;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
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
