package web.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;


@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager sessionFactory;

    @Override
    public List<User> getUsers() {
        return sessionFactory.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        try {
            return sessionFactory.createQuery("from User where id=:id", User.class).setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void addUser(User newUser) {
        sessionFactory.persist(newUser);
    }

    @Override
    public void editUser(User editUser) {
        sessionFactory.merge(editUser);
    }

    @Override
    public void deleteUserById(int id) {
        sessionFactory.remove(getUserById(id));
    }
}
