package _JDBC.Gun02;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _01_SqlExample extends JDBCParent {

    @Test
    public void Test1() throws SQLException {

        ResultSet resultSet= statement.executeQuery("select city_id, city, country_id from city");

        resultSet.last(); //sonuncu row a gider

        String id=resultSet.getString(1); //city id son satıra gittiği için oradaki city nin id si
        System.out.println(id);

        int idInt= resultSet.getInt(1);
        System.out.println(idInt);

        String name=resultSet.getString(2);
        System.out.println(name); //son satıra gittiğimiz için burayı yazdırdığımızda tablodaki son şehir adı gelir

        //        int nameInt=rs.getInt(2);
        //        System.out.println("nameInt = " + nameInt);
        // tipi uygun olan dönüşümle , mesala hepsini String olarak alabilirsin.
        // ancak tipi uygun olmayan mesala isimleri , int olarak zaten alınmaz

        //getRow -> bulunulan rowun kaçıncı satır olduğunu verir

        int kacinciSatir= resultSet.getRow();
        //bir sorgunun sonucunda kaç satır geldiğini resultset.last() dedikten sonra resultset.getRow ile alabilirim

        resultSet.first(); // ilk satıra gidiyor

        String ids=resultSet.getString(3); //burad ilk satıra gittiğimiz için orada bulunan country_id yi aldık
        System.out.println(ids);


    }




}
