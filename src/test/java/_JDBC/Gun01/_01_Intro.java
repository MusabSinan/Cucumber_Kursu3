package _JDBC.Gun01;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {

    @Test
    public void Test1() throws SQLException {


        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";  //hostname//port//db adı
        String username = "root";  //username
        String password = "'\"-LhCB'.%k[4S]z";   //password


        Connection connection = DriverManager.getConnection(url, username, password);  //connection oluşturuldu database ile

        Statement statement = connection.createStatement(); //sorguları çalıştırmak için sayfa açıldı

        ResultSet resultSet = statement.executeQuery("select * from actor"); //sorgu sonucu oluştu ama db de bekliyor

        resultSet.next(); //ilk satıra geçti

        String firstName=resultSet.getString("first_name");
        String lastName=resultSet.getString("last_name");
        System.out.println(firstName);
        System.out.println(lastName);

        //***************************************************************************************

        resultSet.next(); //ikiinci satıra geçti


        String firstName1=resultSet.getString("first_name");
        String lastName1=resultSet.getString("last_name");
        System.out.println(firstName1);
        System.out.println(lastName1);


        connection.close(); //db kapatıldı


    }


}


//1- connection : önce bağlantı ayarlarını yaptık
//   username, password, url(port,db,bağlantı yolu)
//
//2- Sorgu çalıştırma yolu : sorgularımı çalıştırmak için bir sayfa(yol) açtım.
//
//3- Sonuçların alınması : sorgunun çalışması sonucu veritabanından gelen bilgiler.

//Hostname: db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com
//        userName : root
//        Password: '"-LhCB'.%k[4S]z