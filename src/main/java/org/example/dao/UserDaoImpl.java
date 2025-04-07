package org.example.dao;

import org.example.exception.DataProcessingException;
import org.example.users.User;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Optional;

public class UserDaoImpl implements UserDao{

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public User addUser(User user) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DataProcessingException("Can't add user: \n" +user.toString(), e);
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public User updateUser(User user) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DataProcessingException("Can't update user: \n" +user.toString(), e);
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public Optional<User> getUser(int id) {
        Session session = null;
        User user = null;

        try {
            session = sessionFactory.openSession();
            user = session.get(User.class, id);
        } catch (Exception e) {
            throw new DataProcessingException("Can't get user: \n" +id, e);
        } finally {
            session.close();
        }
        return Optional.of(user);
    }

    @Override
    public Optional<User> deleteUser(int id) {
        Session session = null;
        Transaction transaction = null;
        User user = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            user = session.get(User.class, id);
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DataProcessingException("Can't delete user: \n" +id, e);
        } finally {
            session.close();
        }
        return Optional.of(user);
    }

}
