package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void removeUser(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
        entityManager.flush();
    }

    @Override
    public void updateUser(Long id, User user) {
        User edit = entityManager.find(User.class, id);
        edit.setName(user.getName());
        edit.setLastName(user.getLastName());
        edit.setAge(user.getAge());
        edit.setAge(user.getAge());

    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }
}
