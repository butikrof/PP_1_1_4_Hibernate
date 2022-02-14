package jm.task.core.jdbc.util;


///=======================================
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
///=======================================



import java.util.Properties;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import jm.task.core.jdbc.model.User;


public class Util {


    ///=======================================
    public Connection conection(){
        /*final String URL = "jdbc:mysql://localhost:3306/schematest?serverTimezone=Europe/Moscow&useSSL=false";
        final String USER = "root";
        final String PASS = "qwerty123Ffd";
        final String DRIVER = "com.mysql.cj.jdbc.Driver";

        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // обработка ошибки  Class.forName
            System.out.println("JDBC драйвер не найден");
        } catch (SQLException e) {
            e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
            System.out.println("Ошибка SQL !");
        }
        System.out.println("Соединение не выполнено");
        return conn;*/
        return null;
    }
/////=======================================*/


    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");

                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/schematest?useSSL=false");
                //settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_db?useSSL=false");
                //settings.put(Environment.URL, "jdbc:mysql://localhost:3306/schematest?serverTimezone=Europe/Moscow&useSSL=false");

                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "qwerty123Ffd");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "validate"); //значения: validate | update | create | create-drop

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}



