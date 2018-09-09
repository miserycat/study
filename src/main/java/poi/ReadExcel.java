package poi;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class ReadExcel {
  public static void main(String[] args) throws IOException {
    HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream("test.xls"));
    HSSFSheet sheet = workbook.getSheetAt(0);
    HSSFRow row = sheet.getRow(0);
    if (row.getCell(0).getCellTypeEnum().equals(CellType.STRING)) {
      System.out.println(row.getCell(0).getStringCellValue());
    }

    if (row.getCell(1).getCellTypeEnum().equals(CellType.NUMERIC)) {
      System.out.println(row.getCell(1).getDateCellValue());
    }

  }
}
