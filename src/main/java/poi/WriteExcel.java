package poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;

public class WriteExcel {

  public static void main(String[] args) throws IOException {
    HSSFWorkbook workbook = new HSSFWorkbook();
    HSSFSheet sheet = workbook.createSheet("FirstExcelSheet");

    HSSFRow row = sheet.createRow(0);
    HSSFCell cell1 = row.createCell(0);
    cell1.setCellValue("cellValue1");

    HSSFCell cell2 = row.createCell(1);
    HSSFDataFormat dataFormat = workbook.createDataFormat();
    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setDataFormat(dataFormat.getFormat("yyyy-MM-dd"));
    cell2.setCellStyle(cellStyle);
    cell2.setCellValue(new Date());
    sheet.autoSizeColumn(1); //param column position will slow down when excel is has large data
    workbook.write(new FileOutputStream("test.xls"));
    workbook.close();
  }
}
