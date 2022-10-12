package Utilities;

import org.testng.annotations.BeforeTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {


    private static Connection connection; //sadece bu classın içinden ulaşılır veri gizliliği sağlandı username,şifre ve pssword
    protected static Statement statement; //extend yaptık protected subclassdan ulaşılabilir


    protected static void DBConnectionOpen() {
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


    protected static void DBConnectionClose() {
        //kapama işlemleri


        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {  // MAİN BURDA KONTROL AMAÇLI VAR VERİLER GELDİ Mİ DİYE


        ArrayList<ArrayList<String>> tablo = getListData("select * from actor");

        for (ArrayList<String> satir : tablo) {

            System.out.println("satir = " + satir);
        }
    }

    public static ArrayList<ArrayList<String>> getListData(String query) {

        ArrayList<ArrayList<String>> tablo = new ArrayList<>();

        DBConnectionOpen();

        try {

            ResultSet resultSet = statement.executeQuery(query);

            int columnSayisi=resultSet.getMetaData().getColumnCount();


           while (resultSet.next()){

               ArrayList<String> satir=new ArrayList<>();

               for (int i = 1; i <=columnSayisi ; i++) { //burada 1 den başladı çünkü ilk satır boş

                   satir.add(resultSet.getString(i));

               }
               tablo.add(satir);

           }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        DBConnectionClose();


        return tablo;
    }
}
