package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _09_NewExcelWrite {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet= workbook.createSheet("sayfa1");

        Row yeniSatir= sheet.createRow(0);//satır oluşturuldu 0.yerde
        Cell yeniHucre= yeniSatir.createCell(0);//yeni satırda ilk hücre oluşturuldu
        yeniHucre.setCellValue("söğürtmelik");//bilgi yazıldı

        for (int i = 1; i < 10; i++) {//burada 0 ıncı satırın 0 ıncı hüccresine yukarıda değerr gönderdik onun için burada 1 den başladı

            yeniSatir.createCell(i).setCellValue(i);

        }

        //burada excel dosyasını oluşturmasını istediğimiz yeri ve adını verdik
        String yeniExcel="src/test/java/ApachePOI/resource/YeniExcel.xlsx";
        FileOutputStream outputStream=new FileOutputStream(yeniExcel);
        workbook.write(outputStream);
        workbook.close();//hafıza boşaltıldı
        outputStream.close();

        System.out.println("işlem bitti");



    }
}
