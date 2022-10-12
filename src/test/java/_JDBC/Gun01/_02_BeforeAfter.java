package _JDBC.Gun01;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;
public class _02_BeforeAfter {

    private static Connection connection;
    private static Statement statement;


    @BeforeTest
    public void DBConnectionOpen(){
        //Bağlantı işlemleri


        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";



        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement(); //sorguları çalıştırmak için sayfa açıldı
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    @AfterTest
    public void DBConnectionClose(){
        //kapama işlemleri


        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }



    @Test
    public void Test1() throws SQLException {


        ResultSet resultSet= statement.executeQuery("select * from language");

        resultSet.next();
        String dilAdi=resultSet.getString("name");
        System.out.println("dilAdi = " + dilAdi);

        resultSet.next();
         dilAdi=resultSet.getString("name");
        System.out.println("dilAdi = " + dilAdi);

        resultSet.next();
         dilAdi=resultSet.getString("name");
        System.out.println("dilAdi = " + dilAdi);
    }


    @Test
    public void Test2() throws SQLException {


        ResultSet resultSet= statement.executeQuery("select * from language");

        resultSet.next();
        String dilAdi=resultSet.getString(2);
        System.out.println("dilAdi = " + dilAdi);

        resultSet.next();
        dilAdi=resultSet.getString(2);
        System.out.println("dilAdi = " + dilAdi);

        resultSet.next();
        dilAdi=resultSet.getString(2);
        System.out.println("dilAdi = " + dilAdi);



    }


    @Test
    public void Test3() throws SQLException {


        ResultSet resultSet= statement.executeQuery("select * from language");

        resultSet.next();
        String dilAdi=resultSet.getString(2);
        System.out.println("dilAdi = " + dilAdi);

        resultSet.next();
        dilAdi=resultSet.getString(2);
        System.out.println("dilAdi = " + dilAdi);

        resultSet.previous(); //bir önceki saatıra gidiyor
        dilAdi=resultSet.getString(2);
        System.out.println("dilAdi = " + dilAdi);



    }

}
