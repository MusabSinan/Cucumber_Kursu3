package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _03_ApachePOIStart {
    public static void main(String[] args) throws IOException {


        //var olan excel üzerinden veri okuma

        //dosyanın yolu alındı
        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

        FileInputStream dosyaOkumaBaglantisi=new FileInputStream(path); //bağlantı oluşturuldu


        Workbook calismaKitabi= WorkbookFactory.create(dosyaOkumaBaglantisi);// dosya okuma bağlantsından bir workbook oluşturuldu

        Sheet calismaSayfasi=calismaKitabi.getSheet("Sheet1");//oluşturulan workbooktan içinde bulunan sheet adı ile sheeti çağırdık

        Row satir=calismaSayfasi.getRow(0); //burada istediğimiz satırı indexi ile çağırdık sheet içerisindeki

        Cell hucre=satir.getCell(0); // 0 ncı satırdaki istediğimiz hücreyi aldık indexi ile

        System.out.println(hucre);




    }
}
