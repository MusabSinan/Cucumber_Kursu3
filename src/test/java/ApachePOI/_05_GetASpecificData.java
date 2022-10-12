package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class _05_GetASpecificData {
    public static void main(String[] args) {

        /**
         * Verilen Exceldeki password bilgisini bir metoda aracılığı bularak yazdırınız,
         * yani metoda "password" kelimesi gönderilecek, dönen değr password un kendisi olacak.
         * src/test/java/ApachePOI/resources/LoginData.xlsx
         */

        System.out.print("Aranacak kelime =");
        Scanner oku = new Scanner(System.in);

        String arananKelime = oku.nextLine();

        String dönenSonuc = bul(arananKelime);
        System.out.println(dönenSonuc);


    }

    public static String bul(String arananKelime) {

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
        int satirSayisi = sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < satirSayisi; i++) {

            Row row = sheet.getRow(i);

            Cell cell = row.getCell(0); //burada 0 verdik çünkü bizim vereceğimiz kelime bu satırda olacak

            if (arananKelime.equalsIgnoreCase(cell.toString())) {

                int hucresayisi = row.getPhysicalNumberOfCells();

                for (int j = 1; j < hucresayisi; j++) {//ilk hücreyi almasın diye 1 den başladık çünkü ilk hücre aranacak kelime

                    dönecek += row.getCell(j) + " ";

                }

            }

        }

        return dönecek;
    }
}
