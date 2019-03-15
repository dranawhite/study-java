package com.study.poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
 * <pre>
 * 空运行时内存占用
 * Heap
 *  PSYoungGen      total 1376256K, used 94372K [0x00000000a0000000, 0x0000000100000000, 0x0000000100000000)
 *   eden space 1179648K, 8% used [0x00000000a0000000,0x00000000a5c290f8,0x00000000e8000000)
 *   from space 196608K, 0% used [0x00000000f4000000,0x00000000f4000000,0x0000000100000000)
 *   to   space 196608K, 0% used [0x00000000e8000000,0x00000000e8000000,0x00000000f4000000)
 *  ParOldGen       total 524288K, used 0K [0x0000000080000000, 0x00000000a0000000, 0x00000000a0000000)
 *   object space 524288K, 0% used [0x0000000080000000,0x0000000080000000,0x00000000a0000000)
 *  Metaspace       used 3544K, capacity 4566K, committed 4864K, reserved 1056768K
 *   class space    used 388K, capacity 390K, committed 512K, reserved 1048576K
 *
 * XSSF内存占用
 * 2019-03-15T10:55:42.772+0800: 3.576: [GC (Allocation Failure) [PSYoungGen: 1179648K->196576K(1376256K)] 1179648K->668080K(1900544K), 0.4644923 secs] [Times: user=2.83 sys=0.56, real=0.46 secs]
 * 2019-03-15T10:55:43.237+0800: 4.040: [Full GC (Ergonomics) [PSYoungGen: 196576K->141569K(1376256K)] [ParOldGen: 471504K->523789K(524288K)] 668080K->665358K(1900544K), [Metaspace: 9158K->9158K(1056768K)], 3.9646890 secs] [Times: user=27.00 sys=0.33, real=3.96 secs]
 * 2019-03-15T10:55:50.391+0800: 11.195: [Full GC (Ergonomics) [PSYoungGen: 1292779K->716156K(1376256K)] [ParOldGen: 523789K->524269K(524288K)] 1816568K->1240425K(1900544K), [Metaspace: 9690K->9690K(1058816K)], 1.5205772 secs] [Times: user=11.91 sys=0.00, real=1.52 secs]
 * Heap
 *  PSYoungGen      total 1376256K, used 1075059K [0x00000000a0000000, 0x0000000100000000, 0x0000000100000000)
 *   eden space 1179648K, 91% used [0x00000000a0000000,0x00000000e19dcca8,0x00000000e8000000)
 *   from space 196608K, 0% used [0x00000000e8000000,0x00000000e8000000,0x00000000f4000000)
 *   to   space 196608K, 0% used [0x00000000f4000000,0x00000000f4000000,0x0000000100000000)
 *  ParOldGen       total 524288K, used 524269K [0x0000000080000000, 0x00000000a0000000, 0x00000000a0000000)
 *   object space 524288K, 99% used [0x0000000080000000,0x000000009fffb488,0x00000000a0000000)
 *  Metaspace       used 11829K, capacity 11940K, committed 12032K, reserved 1060864K
 *   class space    used 1418K, capacity 1459K, committed 1536K, reserved 1048576K
 *
 * SXSSF内存占用
 * Heap
 *  PSYoungGen      total 1376256K, used 872941K [0x00000000a0000000, 0x0000000100000000, 0x0000000100000000)
 *   eden space 1179648K, 74% used [0x00000000a0000000,0x00000000d547b4b0,0x00000000e8000000)
 *   from space 196608K, 0% used [0x00000000f4000000,0x00000000f4000000,0x0000000100000000)
 *   to   space 196608K, 0% used [0x00000000e8000000,0x00000000e8000000,0x00000000f4000000)
 *  ParOldGen       total 524288K, used 0K [0x0000000080000000, 0x00000000a0000000, 0x00000000a0000000)
 *   object space 524288K, 0% used [0x0000000080000000,0x0000000080000000,0x00000000a0000000)
 *  Metaspace       used 14456K, capacity 14700K, committed 14848K, reserved 1062912K
 *   class space    used 1712K, capacity 1787K, committed 1792K, reserved 1048576K
 *
 * </pre>
 *
 * @author liangyuquan
 * @version $Id: ExcelGenerator.java, v 0.1 2019-03-15 10:27 liangyuquan Exp $$
 */
public class ExcelGenerator {

    private static final String excelPath = "E:/test.xlsx";

    public static void main(String[] args) {
        final int dataSize = 1024 * 1024;
        Random random = new Random();
        List<Integer> dataList = new ArrayList<>(dataSize);
        for (int i = 0; i < dataSize; i++) {
            dataList.add(random.nextInt(Integer.MAX_VALUE));
        }
//        generateByXssf(dataList);
        generateBySxssf(dataList);
    }

    private static void generateByXssf(List<Integer> dataList) {
        try {
            File excelFile = new File(excelPath);
            if (excelFile.exists()) {
                excelFile.delete();
            }
            excelFile.createNewFile();
            OutputStream out = new FileOutputStream(excelFile);
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("TEST");
            for (int i = 0, len = dataList.size(); i < len; i++) {
                Row row = sheet.createRow(i);
                Cell cell = row.createCell(0);
                cell.setCellValue(dataList.get(i));
            }
            workbook.write(out);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void generateBySxssf(List<Integer> dataList) {
        try {
            File excelFile = new File(excelPath);
            if (excelFile.exists()) {
                excelFile.delete();
            }
            excelFile.createNewFile();
            OutputStream out = new FileOutputStream(excelFile);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
            Workbook workbook = new SXSSFWorkbook(xssfWorkbook, 1000);
            Sheet sheet = workbook.createSheet("TEST");
            for (int i = 0, len = dataList.size(); i < len; i++) {
                Row row = sheet.createRow(i);
                Cell cell = row.createCell(0);
                cell.setCellValue(dataList.get(i));
            }
            workbook.write(out);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
