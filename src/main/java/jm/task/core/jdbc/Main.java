package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDaoJDBCImpl conectBase = new UserDaoJDBCImpl();


       //  conectBase.createUsersTable();

       /*conectBase.saveUser("Alex1","Davidov1", (byte) 21);
        conectBase.saveUser("Alex2","Davidov2", (byte) 22);
        conectBase.saveUser("Alex3","Davidov3", (byte) 23);
        conectBase.saveUser("Alex4","Davidov4", (byte) 24);
        conectBase.saveUser("Alex5","Davidov5", (byte) 25);
        conectBase.saveUser("Alex6","Davidov6", (byte) 26);
        conectBase.saveUser("Alex7","Davidov7", (byte) 27);
        conectBase.saveUser("Alex8","Davidov8", (byte) 28);*/

        // conectBase.removeUserById(5L);

        /*List <User> listUser = conectBase.getAllUsers();
       for(int i = 0; i< listUser.size(); i++) {
           System.out.println(listUser.get(i).getId() + " " + listUser.get(i).getName() + " " + listUser.get(i).getLastName() + " " + listUser.get(i).getAge());
       }*/


        //conectBase.cleanUsersTable();
        // conectBase.dropUsersTable();







    }
}
