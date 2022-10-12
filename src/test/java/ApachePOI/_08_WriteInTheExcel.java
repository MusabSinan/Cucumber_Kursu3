package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_WriteInTheExcel {
    public static void main(String[] args) throws IOException {

        //var olan bir excele yazı yazma

        String path="src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet= workbook.getSheet("Sheet1");

        //HAFIZADA OLULUŞTURMA VE YAZMA İŞLEMLERİ
        Row yeniSatir= sheet.createRow(0);//satır oluşturuldu 0.yerde
        Cell yeniHucre= yeniSatir.createCell(0);//yeni satırda ilk hücre oluşturuldu
        yeniHucre.setCellValue("ökkeş");//bilgi yazıldı

        for (int i = 1; i < 10; i++) { //burada 1 den başladık çünkü ilk hücreye yukarıda değer göndeerdik

            yeniSatir.createCell(i).setCellValue(i);

        }

        //sıra kaydetmeye geldi

        inputStream.close();//okuma modunu kapattım çünkü yazma modunda açmam gerekiyor

        //yazma işlemini yazma modunda açıp yapcağız

        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();//hafıza boşaltıldı
        outputStream.close();

        System.out.println("işlem bitti");


    }
}
