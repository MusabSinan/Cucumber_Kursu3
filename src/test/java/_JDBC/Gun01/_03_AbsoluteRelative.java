package _JDBC.Gun01;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_AbsoluteRelative extends JDBCParent {

    @Test
    private void Test1() throws SQLException {

        //absolute -> baştan başlayıp verilen noktaya gider
        //relative -> bulunduğu yerden verilen miktar kadar gider
        //next -> bir sonrki satıra geçer
        //previous -> bir önceki satıra geçer

        ResultSet resultSet= statement.executeQuery("select * from film");

        resultSet.absolute(10); //10. satıra git dedik
        String title= resultSet.getString("title");
        System.out.println("title = " + title);

        resultSet.absolute(15); //15. satıra git dedik
        title= resultSet.getString("title");
        System.out.println("title = " + title);

        resultSet.absolute(-15); // sondan 15. satıra git dedik
        title= resultSet.getString("title");
        System.out.println("title = " + title);


        resultSet.relative(5); // en son bulunduğu yerrden verilen değer kadar ileri git
        title= resultSet.getString("title");
        System.out.println("title = " + title);

        resultSet.relative(-5); //en son bulunduğu yere gönderdik
        title= resultSet.getString("title");
        System.out.println("title = " + title);

    }



}
