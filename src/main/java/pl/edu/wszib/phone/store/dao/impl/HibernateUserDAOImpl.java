package pl.edu.wszib.phone.store.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.phone.store.dao.IUserDAO;
import pl.edu.wszib.phone.store.model.User;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;

public class HibernateUserDAOImpl implements IUserDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User getUserByLogin(String login) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM pl.edu.wszib.phone.store.model.User WHERE login = :login");
        query.setParameter("login", login);
        User result = null;
        try {
            result = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.printf("No users found!!!");
        }
        session.close();
        return result;
    }

    @Override
    public boolean persistUser(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
           session.save(user);
           tx.commit();
           return true;
        } catch(Exception e) {
            if (tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return false;
    }
}
