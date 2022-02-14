package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {


        UserDaoHibernateImpl conectBase = new  UserDaoHibernateImpl();
      //  conectBase.createUsersTable();
      //  conectBase.dropUsersTable();

   /*   conectBase.saveUser("Alex","Ivanov", (byte) 18);
        conectBase.saveUser("Charli","Petrov", (byte) 19);
        conectBase.saveUser("Ignat","Plesov", (byte) 20);
        conectBase.saveUser("Robert","Deniro", (byte) 21);
        conectBase.saveUser("Mark","Kirov", (byte) 22);
        conectBase.saveUser("Andi","Brashlovski", (byte) 23);
        conectBase.saveUser("Bod","Marli", (byte) 24);
        conectBase.saveUser("Nik","Volkov", (byte) 25);
        conectBase.saveUser("Sem","Sirious", (byte) 26);
        conectBase.saveUser("Big","Bosse", (byte) 27);
        conectBase.saveUser("Timofey","Sergeev", (byte) 28);
        conectBase.saveUser("Vilaliy","Nalimov", (byte) 29);
*/
      //  conectBase.removeUserById(1L);
     //   conectBase.removeUserById(2L);

   //     List<User> listUser = conectBase.getAllUsers();

      /*  for(int i = 0; i< listUser.size(); i++) {
            System.out.println(listUser.get(i));
        }
*/
    //   conectBase.cleanUsersTable();

    }
}



























                             //JDBC
        /*UserDaoJDBCImpl conectBase = new UserDaoJDBCImpl();
        conectBase.createUsersTable();

        conectBase.saveUser("Alex","Ivanov", (byte) 18);
        conectBase.saveUser("Charli","Petrov", (byte) 19);
        conectBase.saveUser("Ignat","Plesov", (byte) 20);
        conectBase.saveUser("Robert","Deniro", (byte) 21);
        conectBase.saveUser("Mark","Kirov", (byte) 22);
        conectBase.saveUser("Andi","Brashlovski", (byte) 23);
        conectBase.saveUser("Bod","Marli", (byte) 24);
        conectBase.saveUser("Nik","Volkov", (byte) 25);
        conectBase.saveUser("Sem","Sirious", (byte) 26);
        conectBase.saveUser("Big","Bosse", (byte) 27);
        conectBase.saveUser("Timofey","Sergeev", (byte) 28);
        conectBase.saveUser("Vilaliy","Nalimov", (byte) 29);

        conectBase.removeUserById(5L);

        List <User> listUser = conectBase.getAllUsers();
       for(int i = 0; i< listUser.size(); i++) {
           System.out.println(listUser.get(i).getId() + " " + listUser.get(i).getName() + " " + listUser.get(i).getLastName() + " " + listUser.get(i).getAge());
       }

       conectBase.cleanUsersTable();
       conectBase.dropUsersTable();*/