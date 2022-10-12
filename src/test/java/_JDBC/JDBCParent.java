package _JDBC;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCParent {

    //BEFORE VE AFTER METHODLARINI BURAYA TANIMLADIK ÇÜNKÜ ÇALIŞILACAK PROJEDE BUNLAR SABİT OLACAK
    //EXTENDS YAPARAK İLGİLİ CLASSA OTOMATİK OLARAK BUNLARI KULLANMIŞ OLACAĞIZ GEREKEN YERDE


    private static Connection connection; //sadece bu classın içinden ulaşılır veri gizliliği sağlandı username,şifre ve pssword
    protected static Statement statement; //extend yaptık protected subclassdan ulaşılabilir

    @BeforeTest
    public void DBConnectionOpen(){
        //Bağlantı işlemleri


        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";



        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
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

}
