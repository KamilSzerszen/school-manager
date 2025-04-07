package org.example;

import org.example.dao.UserDao;
import org.example.dao.UserDaoImpl;
import org.example.enums.SchoolClass;
import org.example.enums.Sex;
import org.example.enums.Subjects;
import org.example.users.Students;
import org.example.users.Teacher;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        /*/
        - Stworzenie DB dla projektu TRUE
        - Akcje dla DB dodawanie nowych użytkowników
        - stworzenie klasy dla kadr i uczniów i ogólnej Person
         */


        HashMap<Subjects, Double> abc = new HashMap<>();
        abc.put(Subjects.MATHS, 4.5);
        Students bob = new Students("Bob", "Srara", 14, Sex.MALE, SchoolClass.CLASS_1B, abc);
        Students jon = new Students("Jon", "Srara", 14, Sex.MALE, SchoolClass.CLASS_1B, abc);

        Teacher alice = new Teacher("ALice", "Moris", 45, Sex.FEMALE, Subjects.MATHS, 4500);


        UserDao userDao = new UserDaoImpl();

        userDao.addUser(bob);
        userDao.addUser(jon);
        userDao.addUser(alice);

    }
}