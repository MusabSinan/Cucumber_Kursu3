package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class _04_ApachePOIGetAllData {
    public static void main(String[] args) throws IOException {

        //dosyanın yolu alındı
        String path = "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

        FileInputStream inputStream = new FileInputStream(path);


        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet = workbook.getSheet("Sheet1");

        ArrayList<String> veriler=new ArrayList<>();
        int rowCount = sheet.getPhysicalNumberOfRows();//toplsm satır sayısını aldık  "row" satır demek

        for (int i = 0; i < rowCount; i++) {//burada satır sayısı kadar dönecek yani row sayısı kadar

            Row row = sheet.getRow(i);//i. satırı alındı

            int cellCount = row.getPhysicalNumberOfCells();//bu satırdaki cell yani hücre sayısını aldık

            for (int j = 0; j < cellCount; j++) {//i satırındaki hücre sayısı kadar dönecek

                Cell cell=row.getCell(j);//bu satırdaki sıradaki hücreyi aldım

                System.out.print(cell+" ");

                veriler.add(cell.toString());
            }

            System.out.println();
        }
        System.out.println(veriler);


    }
}
