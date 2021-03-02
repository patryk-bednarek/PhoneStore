package pl.edu.wszib.phone.store.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.phone.store.dao.IPhoneDAO;
import pl.edu.wszib.phone.store.model.Phone;

import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class HibernatePhoneDAOImpl implements IPhoneDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Phone getPhoneById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Phone> query = session.createQuery("FROM pl.edu.wszib.phone.store.model.Phone WHERE id = :id");
        query.setParameter("id", id);
        Phone phone = null;
        try {
            phone = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No phones found!!!");
        }
        session.close();
        return phone;
    }

    @Override
    public void updatePhone(Phone phone) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(phone);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Phone> getAllPhones() {
        Session session = this.sessionFactory.openSession();
        Query<Phone> query = session.createQuery("FROM pl.edu.wszib.phone.store.model.Phone");
        List<Phone> phones = query.getResultList();
        session.close();
        return phones;
    }
}
