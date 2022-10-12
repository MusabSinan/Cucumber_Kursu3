package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _07_Soru {
    public static void main(String[] args) {

        /*
      Bir önceki soruda kullanıcıdan bu sefer sütun numarası
      isteyiniz ve o sütundaki bütün bilgileri yazdırınız 05 classdaki
      */


        System.out.print("İstenen Sütun = ");
        Scanner oku = new Scanner(System.in);

        int sütun = oku.nextInt();

        String dönenSonuc = bul(sütun);
        System.out.println(dönenSonuc);

    }


    public static String bul(int sütun) {

        String dönecek = "";

        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";
        Workbook workbook = null;

        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

            if (sheet.getRow(i).getPhysicalNumberOfCells() > sütun)
                dönecek += sheet.getRow(i).getCell(sütun) + "\n";

        }

        return dönecek;
    }


}
