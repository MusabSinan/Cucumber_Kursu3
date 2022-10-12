package _JDBC.Gun01;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Soru extends JDBCParent {

    //city tablosundaki tüm kayıtları next ile yazdırınız
    @Test
    public void Test1() throws SQLException {

        ResultSet resultSet = statement.executeQuery("select * from city");

        int count = 0;
        while (resultSet.next()) {

            System.out.println(resultSet.getString(2));
            count++;

        }

        System.out.println(count); //toplam şehir sayısını aldık

    }

    //city tablosundaki tüm kayıtları absolute ile yazdırınız
    @Test
    public void Test2() throws SQLException {

        ResultSet resultSet = statement.executeQuery("select * from city");

        int count = 1;
        while (resultSet.absolute(count)) {

            System.out.println(resultSet.getString(2)); //city name i 2.kolonda ondan dolayı burada onu belirttik
            count++;

        }

        System.out.println(count-1);

    }

    //city tablosundaki tüm kayıtları relative ile yazdırınız

    @Test
    public void Test3() throws SQLException {

        ResultSet resultSet = statement.executeQuery("select * from city");

        int count = 0;
        while (resultSet.relative(1)) {

            System.out.println(resultSet.getString(2));
            count++;

        }

        System.out.println(count);

    }


}
