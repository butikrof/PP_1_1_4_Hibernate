package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import jm.task.core.jdbc.util.Util;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {
    }

    static SessionFactory sessionFactory = Util.getSessionFactory();



    @Override
    public void createUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String sql = "CREATE TABLE IF NOT EXISTS tableHibernate"+"(id INT(6) NOT NULL PRIMARY KEY AUTO_INCREMENT, "+"name VARCHAR(12), last_name VARCHAR(20), age INT(2));";
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
        }

    }

    @Override
    public void dropUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String sql = "DROP TABLE tableHibernate;";
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            User user = new User(name,lastName,age);
            session.save(user);
            transaction.commit();
        }
    }


    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            //session.createSQLQuery("delete from tableHibernate where id ="+id+"").executeUpdate();
           // session.createQuery("delete User where id = :id").setParameter("id", id).executeUpdate();

           User user = session.get(User.class,id);
           session.delete(user);

            transaction.commit();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = Util.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            List<User> users;
            users = session.createSQLQuery("SELECT * FROM tableHibernate").list();
            transaction.commit();

            return users;

        }


    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String sql = "TRUNCATE TABLE tableHibernate;";
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
        }
    }
}
