package com.study.excel.poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * -XX:+PrintGC
 * -XX:+PrintGCDateStamps
 * -XX:+PrintGCDetails
 * -XX:+PrintGCTimeStamps
 * -Xms2048m
 * -Xmx2048m
 * -Xmn1536m
 * </pre>
 *
 * @author liangyuquan
 * @version $Id: ExcelReader.java, v 0.1 2019-03-15 10:27 liangyuquan Exp $$
 */
public class ExcelReader {

    private static final String excelPath = "E:/test.xlsx";

    public static void main(String[] args) {

    }

    private static List<Integer> readByXssf() {
        try {
            final int dataSize = 1024 * 1024;
            XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
            Sheet sheet = workbook.getSheetAt(0);
            List<Integer> dataList = new ArrayList<>(dataSize);
            for (int i = sheet.getFirstRowNum(), len = sheet.getLastRowNum(); i < len; i++) {
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(0);
                dataList.add((int) cell.getNumericCellValue());
            }
            return dataList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private static List<Integer> readByEvent() {
        try {
            // TODO
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
