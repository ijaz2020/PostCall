package com.hotel.adhoc;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CreatePlayout {
  public static void main(String[] args) {
    CreatePlayout createPlayout = new CreatePlayout();
    createPlayout.readJson();
  }

  private void readJson() {
    JSONParser parser = new JSONParser();
    try {
      Object obj = parser.parse(new FileReader("/Users/ijaza/code-base/PostCall/src/com/hotel/adhoc/test.json"));

      // A JSON array. JSONObject supports java.util.List interface.
      JSONArray playoutList = (JSONArray) obj;
      Set<String> set = new HashSet<>();

      playoutList.forEach(playout -> {
        JSONObject jsonObject = (JSONObject) playout;
        set.add( (String) jsonObject.get( "frameId"));
      });
      System.out.println(set);
      /*playoutList.forEach(playout -> {
        JSONObject jsonObject = (JSONObject) playout;
        set.add( (String) jsonObject.get( "frameId"));
      });*/
//      createSheet(playoutList);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void createSheet(JSONArray playoutList) throws IOException, ParseException {

    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet("Sheet 1");
    Font headerFont = workbook.createFont();
    headerFont.setBold(true);
    headerFont.setFontHeightInPoints((short) 14);
    headerFont.setColor(IndexedColors.RED.getIndex());

    CellStyle headerCellStyle = workbook.createCellStyle();
    headerCellStyle.setFont(headerFont);

    int rowNo =1;
    Row headerRow = sheet.createRow(rowNo++);
    String[] columns = JCDPlayOutRow.header;
    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i+1);
      cell.setCellValue(columns[i]);
      cell.setCellStyle(headerCellStyle);
    }

    for(int i=0; i<playoutList.size();i++) {
      Row row = sheet.createRow(rowNo++);
      int j=1;
      JSONObject obj = (JSONObject) playoutList.get(i);
      row.createCell(j++).setCellValue("LARGE FORMAT");
      row.createCell(j++).setCellValue("SW - West Hill Tower");
      row.createCell(j++).setCellValue((String)obj.get("frameId"));
      row.createCell(j++).setCellValue("142504886");
      row.createCell(j++).setCellValue("West Hill Tower Primary");
      row.createCell(j++).setCellValue("013201.00204.05.01");
      row.createCell(j++).setCellValue("153029509");
      row.createCell(j++).setCellValue("uk-whi-lx0001-p-led");
      String s = (String)obj.get("scheduledDateTime");
      String d = s.split("T")[0];
      Date date=new SimpleDateFormat("yyyy-MM-dd").parse(d);
      String t = s.split("T")[1].substring(0,2);
      row.createCell(j++).setCellValue(new SimpleDateFormat("dd/MM/yyyy").format(date));
      row.createCell(j++).setCellValue(Integer.parseInt(t));
      row.createCell(j++).setCellValue("200630805");
      row.createCell(j++).setCellValue("SM154879_738 SW - West Hill Tower Barclays Business 2018.02.26 to 2018.03.11");
      row.createCell(j++).setCellValue("SM154879");
      row.createCell(j++).setCellValue("Barclays Bank PLC");
      row.createCell(j++).setCellValue("Barclays Business");
      row.createCell(j++).setCellValue("204701583");
      row.createCell(j++).setCellValue("barclays-data-48s-lfd-primetime-v1.zip");
      row.createCell(j++).setCellValue("85");
      row.createCell(j++).setCellValue((Long)obj.get("slotLength"));
      row.createCell(j).setCellValue("1200");
    }

    // Resize all columns to fit the content size
    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }

    FileOutputStream fileOut = new FileOutputStream("jcd.xlsx");
    workbook.write(fileOut);
    fileOut.close();
  }
}
