package com.study.excel.poi;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;

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
 *  par new generation   total 1415616K, used 125837K [0x0000000080000000, 0x00000000e0000000, 0x00000000e0000000)
 *   eden space 1258368K,  10% used [0x0000000080000000, 0x0000000087ae34f8, 0x00000000ccce0000)
 *   from space 157248K,   0% used [0x00000000ccce0000, 0x00000000ccce0000, 0x00000000d6670000)
 *   to   space 157248K,   0% used [0x00000000d6670000, 0x00000000d6670000, 0x00000000e0000000)
 *  concurrent mark-sweep generation total 524288K, used 0K [0x00000000e0000000, 0x0000000100000000, 0x0000000100000000)
 *  Metaspace       used 3543K, capacity 4566K, committed 4864K, reserved 1056768K
 *   class space    used 388K, capacity 390K, committed 512K, reserved 1048576K
 *
 * XSSF内存占用
 * 2019-03-15T16:20:41.003+0800: 3.809: [GC (Allocation Failure) 2019-03-15T16:20:41.003+0800: 3.809: [ParNew (promotion failed): 1258368K->1415616K(1415616K), 3.0070406 secs]2019-03-15T16:20:44.010+0800: 6.816: [CMS: 524147K->524285K(524288K), 1.6493492 secs] 1258368K->696277K(1939904K), [Metaspace: 9152K->9152K(1056768K)], 4.6564876 secs] [Times: user=10.80 sys=1.51, real=4.66 secs]
 * 2019-03-15T16:20:45.660+0800: 8.466: [GC (CMS Initial Mark) [1 CMS-initial-mark: 524285K(524288K)] 720437K(1939904K), 0.1049004 secs] [Times: user=0.11 sys=0.00, real=0.11 secs]
 * 2019-03-15T16:20:45.766+0800: 8.571: [CMS-concurrent-mark-start]
 * 2019-03-15T16:20:46.248+0800: 9.054: [CMS-concurrent-mark: 0.483/0.483 secs] [Times: user=1.44 sys=0.02, real=0.48 secs]
 * 2019-03-15T16:20:46.248+0800: 9.054: [CMS-concurrent-preclean-start]
 * 2019-03-15T16:20:46.673+0800: 9.479: [CMS-concurrent-preclean: 0.424/0.424 secs] [Times: user=1.22 sys=0.02, real=0.43 secs]
 * 2019-03-15T16:20:46.673+0800: 9.479: [CMS-concurrent-abortable-preclean-start]
 * 2019-03-15T16:20:46.673+0800: 9.479: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * 2019-03-15T16:20:46.674+0800: 9.479: [GC (CMS Final Remark) [YG occupancy: 595307 K (1415616 K)]2019-03-15T16:20:46.674+0800: 9.479: [Rescan (parallel) , 0.1903348 secs]2019-03-15T16:20:46.864+0800: 9.670: [weak refs processing, 0.0000256 secs]2019-03-15T16:20:46.864+0800: 9.670: [class unloading, 0.0014858 secs]2019-03-15T16:20:46.866+0800: 9.671: [scrub symbol table, 0.0009365 secs]2019-03-15T16:20:46.867+0800: 9.672: [scrub string table, 0.0003302 secs][1 CMS-remark: 524285K(524288K)] 1119592K(1939904K), 0.1935827 secs] [Times: user=1.42 sys=0.00, real=0.19 secs]
 * 2019-03-15T16:20:46.868+0800: 9.673: [CMS-concurrent-sweep-start]
 * 2019-03-15T16:20:47.013+0800: 9.819: [CMS-concurrent-sweep: 0.146/0.146 secs] [Times: user=0.28 sys=0.00, real=0.14 secs]
 * 2019-03-15T16:20:47.013+0800: 9.819: [CMS-concurrent-reset-start]
 * 2019-03-15T16:20:47.014+0800: 9.820: [CMS-concurrent-reset: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * 2019-03-15T16:20:49.015+0800: 11.820: [GC (CMS Initial Mark) [1 CMS-initial-mark: 524285K(524288K)] 1356090K(1939904K), 0.1505205 secs] [Times: user=0.69 sys=0.00, real=0.15 secs]
 * 2019-03-15T16:20:49.165+0800: 11.971: [CMS-concurrent-mark-start]
 * 2019-03-15T16:20:49.746+0800: 12.552: [CMS-concurrent-mark: 0.578/0.581 secs] [Times: user=1.81 sys=0.03, real=0.58 secs]
 * 2019-03-15T16:20:49.746+0800: 12.552: [CMS-concurrent-preclean-start]
 * 2019-03-15T16:20:50.082+0800: 12.888: [CMS-concurrent-preclean: 0.321/0.336 secs] [Times: user=0.66 sys=0.03, real=0.34 secs]
 * 2019-03-15T16:20:50.082+0800: 12.888: [CMS-concurrent-abortable-preclean-start]
 * 2019-03-15T16:20:50.082+0800: 12.888: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * 2019-03-15T16:20:50.082+0800: 12.888: [GC (CMS Final Remark) [YG occupancy: 906488 K (1415616 K)]2019-03-15T16:20:50.082+0800: 12.888: [Rescan (parallel) , 0.2006830 secs]2019-03-15T16:20:50.283+0800: 13.089: [weak refs processing, 0.0000388 secs]2019-03-15T16:20:50.283+0800: 13.089: [class unloading, 0.0016307 secs]2019-03-15T16:20:50.284+0800: 13.090: [scrub symbol table, 0.0014282 secs]2019-03-15T16:20:50.286+0800: 13.092: [scrub string table, 0.0003673 secs][1 CMS-remark: 524285K(524288K)] 1430774K(1939904K), 0.2047216 secs] [Times: user=1.47 sys=0.00, real=0.20 secs]
 * 2019-03-15T16:20:50.287+0800: 13.093: [CMS-concurrent-sweep-start]
 * 2019-03-15T16:20:50.430+0800: 13.236: [CMS-concurrent-sweep: 0.143/0.143 secs] [Times: user=0.28 sys=0.03, real=0.14 secs]
 * 2019-03-15T16:20:50.430+0800: 13.236: [CMS-concurrent-reset-start]
 * 2019-03-15T16:20:50.431+0800: 13.236: [CMS-concurrent-reset: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * Heap
 *  par new generation   total 1415616K, used 914878K [0x0000000080000000, 0x00000000e0000000, 0x00000000e0000000)
 *   eden space 1258368K,  72% used [0x0000000080000000, 0x00000000b7d6f940, 0x00000000ccce0000)
 *   from space 157248K,   0% used [0x00000000d6670000, 0x00000000d6670000, 0x00000000e0000000)
 *   to   space 157248K,   0% used [0x00000000ccce0000, 0x00000000ccce0000, 0x00000000d6670000)
 *  concurrent mark-sweep generation total 524288K, used 524158K [0x00000000e0000000, 0x0000000100000000, 0x0000000100000000)
 *  Metaspace       used 11827K, capacity 11948K, committed 12032K, reserved 1060864K
 *   class space    used 1418K, capacity 1459K, committed 1536K, reserved 1048576K
 *
 * SXSSF内存占用(500 rowsize)
 * Heap
 *  par new generation   total 1415616K, used 679520K [0x0000000080000000, 0x00000000e0000000, 0x00000000e0000000)
 *   eden space 1258368K,  54% used [0x0000000080000000, 0x00000000a97980c0, 0x00000000ccce0000)
 *   from space 157248K,   0% used [0x00000000ccce0000, 0x00000000ccce0000, 0x00000000d6670000)
 *   to   space 157248K,   0% used [0x00000000d6670000, 0x00000000d6670000, 0x00000000e0000000)
 *  concurrent mark-sweep generation total 524288K, used 0K [0x00000000e0000000, 0x0000000100000000, 0x0000000100000000)
 *  Metaspace       used 14485K, capacity 14700K, committed 14848K, reserved 1062912K
 *   class space    used 1712K, capacity 1787K, committed 1792K, reserved 1048576K
 *
 * EasyExcel内存占用(默认500rowsize)
 * Heap
 *  par new generation   total 1415616K, used 780189K [0x0000000080000000, 0x00000000e0000000, 0x00000000e0000000)
 *   eden space 1258368K,  62% used [0x0000000080000000, 0x00000000af9e7608, 0x00000000ccce0000)
 *   from space 157248K,   0% used [0x00000000ccce0000, 0x00000000ccce0000, 0x00000000d6670000)
 *   to   space 157248K,   0% used [0x00000000d6670000, 0x00000000d6670000, 0x00000000e0000000)
 *  concurrent mark-sweep generation total 524288K, used 0K [0x00000000e0000000, 0x0000000100000000, 0x0000000100000000)
 *  Metaspace       used 14794K, capacity 14974K, committed 15232K, reserved 1062912K
 *   class space    used 1760K, capacity 1821K, committed 1920K, reserved 1048576K
 *
 * </pre>
 *
 * @author liangyuquan
 * @version $Id: ExcelGenerator.java, v 0.1 2019-03-15 10:27 liangyuquan Exp $$
 */
public class ExcelGenerator {

    private static final String excelPath = "E:/test.xlsx";

    public static void main(String[] args) {
        final int dataSize = 1024 * 256;
        final int columnSize = 4;
        Random random = new Random();
        List<List<Object>> dataList = new ArrayList<>(dataSize);
        for (int i = 0; i < dataSize; i++) {
            List<Object> rowList = new ArrayList<>(4);
            for (int j = 0; j < columnSize; j++) {
                rowList.add(random.nextInt(Integer.MAX_VALUE));
            }
            dataList.add(rowList);
        }
        generateByXssf(dataList);
//        generateBySxssf(dataList);
//        generateByEasyExcel(dataList);
    }

    private static void generateByXssf(List<List<Object>> dataList) {
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
                List<Object> rowList = dataList.get(i);
                Row row = sheet.createRow(i);
                for (int j = 0; j < 4; j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue((int) rowList.get(j));
                }
            }
            workbook.write(out);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void generateBySxssf(List<List<Object>> dataList) {
        try {
            File excelFile = new File(excelPath);
            if (excelFile.exists()) {
                excelFile.delete();
            }
            excelFile.createNewFile();
            OutputStream out = new FileOutputStream(excelFile);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
            Workbook workbook = new SXSSFWorkbook(xssfWorkbook, 500);
            Sheet sheet = workbook.createSheet("TEST");
            for (int i = 0, len = dataList.size(); i < len; i++) {
                List<Object> rowList = dataList.get(i);
                Row row = sheet.createRow(i);
                for (int j = 0; j < 4; j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue((int) rowList.get(j));
                }
            }
            workbook.write(out);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void generateByEasyExcel(List<List<Object>> dataList) {
        try {
            File excelFile = new File(excelPath);
            if (excelFile.exists()) {
                excelFile.delete();
            }
            excelFile.createNewFile();
            OutputStream out = new FileOutputStream(excelFile);
            ExcelWriter writer = EasyExcelFactory.getWriter(out);
            com.alibaba.excel.metadata.Sheet sheet = new com.alibaba.excel.metadata.Sheet(1, 1);
            sheet.setSheetName("TEST");
            writer.write1(dataList, sheet);
            writer.finish();
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
