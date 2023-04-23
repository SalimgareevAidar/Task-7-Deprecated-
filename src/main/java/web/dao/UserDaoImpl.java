package web.dao;


import jakarta.persistence.NoResultException;
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

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUsers() {
        Query<User> query = sessionFactory.getCurrentSession().createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User getUserById(int id) {
        try {
            Query<User> query = sessionFactory.getCurrentSession().createQuery("from User where id=:id", User.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void addUser(User newUser) {
        sessionFactory.getCurrentSession().persist(newUser);
    }

    @Override
    public void editUser(User editUser) {
        sessionFactory.getCurrentSession().merge(editUser);
    }

    @Override
    public void deleteUserById(int id) {
        sessionFactory.getCurrentSession().remove(getUserById(id));
    }
}
