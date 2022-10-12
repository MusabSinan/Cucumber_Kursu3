package _JDBC.Gun02;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _02_GetAllRowColumn extends JDBCParent {


    @Test
    public void Test1() throws SQLException {

        ResultSet resultSet = statement.executeQuery("select * from language");

        ResultSetMetaData rsmd = resultSet.getMetaData(); // tablodaki kolon başlıklarını  aldık

        int columnCount = rsmd.getColumnCount(); //kolon sayısı
        System.out.println("columnCount = " + columnCount);

        for (int i = 1; i <= columnCount; i++) {

            String columnName = rsmd.getColumnName(i); //burası satırın adını verdi görünen
            String columnType = rsmd.getColumnTypeName(i); //burası satırın tipinin db üzerindeki türünü verdi

            System.out.println(columnType + " " + columnName);

        }

    }

    @Test
    public void Test2() throws SQLException {

        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi

        ResultSet resultSet = statement.executeQuery("select * from language");

        ResultSetMetaData rsmd = resultSet.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++)
            System.out.print(rsmd.getColumnName(i) + "\t");

        System.out.println();

        while (resultSet.next()) {

            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                System.out.print(resultSet.getString(i) + "\t");


            System.out.println();


        }


    }

    @Test
    public void Test3() throws SQLException {

        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi

        ResultSet resultSet = statement.executeQuery("select * from language");

        ResultSetMetaData rsmd = resultSet.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++)
            System.out.printf("%-20s", rsmd.getColumnName(i)); //%20s sola dayalı  %-20s sağa dayalı eğer rakamsa s yerine d yazılır

        System.out.println();

        while (resultSet.next()) {

            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                System.out.printf("%-20s", resultSet.getString(i));


            System.out.println();


        }


    }

    @Test
    public void Test4() throws SQLException {


        // actor tablosundaki tüm satırları ve tüm sütunları yazdırınız, aynı mysql sonuç ekranında olduğu gibi
        // fakat metod kullanınız, metoda sorguyu gönderiniz ve orada yazdırınız.

        getTable("select * from actor");


    }

    public void getTable(String query) throws SQLException {
        ResultSet resultSet = statement.executeQuery(query);

        ResultSetMetaData rsmd = resultSet.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++)
            System.out.printf("%-20s", rsmd.getColumnName(i)); //%20s sola dayalı  %-20s sağa dayalı eğer rakamsa s yerine d yazılır

        System.out.println();

        while (resultSet.next()) {

            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                System.out.printf("%-20s", resultSet.getString(i));


            System.out.println();


        }


    }

}
