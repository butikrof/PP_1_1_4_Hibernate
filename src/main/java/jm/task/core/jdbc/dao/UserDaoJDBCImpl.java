package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl(){
    }

    Util util = new Util();
    private static String nameTable= "TableOfUser";

    public void createUsersTable() /*throws SQLException*/ {
        try {
            util.conection().createStatement().executeUpdate("CREATE TABLE "+nameTable+" (`id` INT(5) NOT NULL AUTO_INCREMENT, PRIMARY KEY (`id`) , name VARCHAR(20), lastName VARCHAR(20), age INT(2))");
            System.out.println("Создана таблица с полями: #id, #name, #lastName, #age");
        } catch (SQLException e) {
            System.out.println("При создании таблицы произошло исключение.\nPrint exception: " + e);
        }
        try {
            util.conection().close();
        } catch (SQLException e) {
            System.out.println("conection.close - exeption");
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try {
            util.conection().createStatement().executeUpdate("DROP TABLE "+nameTable+";");
            System.out.println("Таблица #TableOfUser - удалена.");
        } catch (SQLException e) {
            System.out.println("При удалении таблицы произошло исключение.\nPrint exception: "+e);
        }
        try {
            util.conection().close();
        } catch (SQLException e) {
            System.out.println("conection.close - exeption");
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            util.conection().createStatement().executeUpdate("insert into "+nameTable+" (id, name, lastName, age) values (id, '"+name+"', '"+lastName+"', '"+age+"')");
            System.out.println("Юзер: "+name+" "+lastName+" "+age+" добавлен");
        } catch (SQLException e) {
            System.out.println("При добавление юзера произошло исключение.\nPrint exception: "+e);
        }
        try {
            util.conection().close();
        } catch (SQLException e) {
            System.out.println("conection.close - exeption");
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try {
            util.conection().createStatement().executeUpdate("delete from "+nameTable+" where id="+id+"");
           System.out.println("Юзер с ID "+id+" удален");
        } catch (SQLException e) {
            System.out.println("При удалении юзера произошло исключение.\nPrint exception: "+e);
        }
        try {
            util.conection().close();
        } catch (SQLException e) {
            System.out.println("conection.close - exeption");
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        ArrayList <User> arrUser = new ArrayList<>();

        try {
            ResultSet resultSet = util.conection().createStatement().executeQuery("SELECT * FROM "+nameTable+"");
            while (resultSet.next()){
                User user = new User();
                user.setId((long) resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge((byte) resultSet.getInt(4));
                arrUser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(" conect error from get user sout ");
        }
        try {
            util.conection().close();
        } catch (SQLException e) {
            System.out.println("conection.close - exeption");
            e.printStackTrace();
        }
        return arrUser;
    }

    public void cleanUsersTable() {
        try {
            util.conection().createStatement().executeUpdate("TRUNCATE TABLE "+nameTable+";");
            System.out.println("Таблица #TableOfUser - очищена.");
        } catch (SQLException e) {
            System.out.println("При выполнении #TRUNCATE TABLE TableOfUser произошло исключене "+e);
        }
        try {
            util.conection().close();
        } catch (SQLException e) {
            System.out.println("conection.close - exeption");
            e.printStackTrace();
        }
    }
}
