package com.study.excel.poi;

import com.alibaba.excel.EasyExcelFactory;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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
 * -XX:CMSInitiatingOccupancyFraction=70
 * -XX:+UseCMSInitiatingOccupancyOnly
 * -XX:+UseConcMarkSweepGC
 * -XX:+UseParNewGC
 * </pre>
 *
 * <pre>
 *  XSSF内存占用
 * 2019-03-15T16:16:28.583+0800: 3.796: [GC (Allocation Failure) 2019-03-15T16:16:28.583+0800: 3.796: [ParNew (promotion failed): 1258368K->1415616K(1415616K), 2.6923458 secs]2019-03-15T16:16:31.276+0800: 6.488: [CMS: 524076K->524287K(524288K), 2.0448800 secs] 1258368K->1044131K(1939904K), [Metaspace: 10016K->10016K(1058816K)], 4.7375954 secs] [Times: user=11.23 sys=1.30, real=4.74 secs]
 * 2019-03-15T16:16:33.321+0800: 8.534: [GC (CMS Initial Mark) [1 CMS-initial-mark: 524287K(524288K)] 1068354K(1939904K), 0.3551244 secs] [Times: user=0.34 sys=0.00, real=0.36 secs]
 * 2019-03-15T16:16:33.676+0800: 8.889: [CMS-concurrent-mark-start]
 * 2019-03-15T16:16:34.025+0800: 9.238: [CMS-concurrent-mark: 0.349/0.349 secs] [Times: user=1.36 sys=0.00, real=0.35 secs]
 * 2019-03-15T16:16:34.026+0800: 9.238: [CMS-concurrent-preclean-start]
 * 2019-03-15T16:16:34.400+0800: 9.613: [CMS-concurrent-preclean: 0.375/0.375 secs] [Times: user=1.47 sys=0.02, real=0.37 secs]
 * 2019-03-15T16:16:34.400+0800: 9.613: [CMS-concurrent-abortable-preclean-start]
 * 2019-03-15T16:16:34.400+0800: 9.613: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * 2019-03-15T16:16:34.400+0800: 9.613: [GC (CMS Final Remark) [YG occupancy: 847761 K (1415616 K)]2019-03-15T16:16:34.401+0800: 9.613: [Rescan (parallel) , 0.5285809 secs]2019-03-15T16:16:34.930+0800: 10.142: [weak refs processing, 0.0000252 secs]2019-03-15T16:16:34.930+0800: 10.142: [class unloading, 0.0015663 secs]2019-03-15T16:16:34.931+0800: 10.144: [scrub symbol table, 0.0011157 secs]2019-03-15T16:16:34.932+0800: 10.145: [scrub string table, 0.0003752 secs][1 CMS-remark: 524287K(524288K)] 1372049K(1939904K), 0.5321016 secs] [Times: user=3.66 sys=0.08, real=0.53 secs]
 * 2019-03-15T16:16:34.933+0800: 10.146: [CMS-concurrent-sweep-start]
 * 2019-03-15T16:16:35.110+0800: 10.323: [CMS-concurrent-sweep: 0.177/0.177 secs] [Times: user=0.83 sys=0.03, real=0.18 secs]
 * 2019-03-15T16:16:35.110+0800: 10.323: [CMS-concurrent-reset-start]
 * 2019-03-15T16:16:35.111+0800: 10.324: [CMS-concurrent-reset: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * 2019-03-15T16:16:36.971+0800: 12.184: [GC (Allocation Failure) 2019-03-15T16:16:36.971+0800: 12.184: [ParNew: 1415616K->1415616K(1415616K), 0.0000295 secs]2019-03-15T16:16:36.971+0800: 12.184: [CMS: 524281K->524287K(524288K), 1.7979835 secs] 1939897K->683485K(1939904K), [Metaspace: 10572K->10572K(1058816K)], 1.7981354 secs] [Times: user=1.78 sys=0.02, real=1.80 secs]
 * 2019-03-15T16:16:38.770+0800: 13.982: [GC (CMS Initial Mark) [1 CMS-initial-mark: 524287K(524288K)] 705194K(1939904K), 0.1342478 secs] [Times: user=0.14 sys=0.00, real=0.13 secs]
 * 2019-03-15T16:16:38.904+0800: 14.117: [CMS-concurrent-mark-start]
 * 2019-03-15T16:16:39.213+0800: 14.426: [CMS-concurrent-mark: 0.309/0.309 secs] [Times: user=0.92 sys=0.00, real=0.31 secs]
 * 2019-03-15T16:16:39.213+0800: 14.426: [CMS-concurrent-preclean-start]
 * 2019-03-15T16:16:39.530+0800: 14.744: [CMS-concurrent-preclean: 0.318/0.318 secs] [Times: user=1.25 sys=0.02, real=0.32 secs]
 * 2019-03-15T16:16:39.531+0800: 14.744: [CMS-concurrent-abortable-preclean-start]
 * 2019-03-15T16:16:39.531+0800: 14.744: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * 2019-03-15T16:16:39.531+0800: 14.744: [GC (CMS Final Remark) [YG occupancy: 431337 K (1415616 K)]2019-03-15T16:16:39.531+0800: 14.744: [Rescan (parallel) , 0.1965340 secs]2019-03-15T16:16:39.728+0800: 14.940: [weak refs processing, 0.0000365 secs]2019-03-15T16:16:39.728+0800: 14.941: [class unloading, 0.0015296 secs]2019-03-15T16:16:39.729+0800: 14.942: [scrub symbol table, 0.0009794 secs]2019-03-15T16:16:39.730+0800: 14.943: [scrub string table, 0.0003589 secs][1 CMS-remark: 524287K(524288K)] 955625K(1939904K), 0.1995698 secs] [Times: user=1.50 sys=0.00, real=0.20 secs]
 * 2019-03-15T16:16:39.731+0800: 14.944: [CMS-concurrent-sweep-start]
 * 2019-03-15T16:16:39.824+0800: 15.037: [CMS-concurrent-sweep: 0.093/0.093 secs] [Times: user=0.28 sys=0.00, real=0.09 secs]
 * 2019-03-15T16:16:39.824+0800: 15.037: [CMS-concurrent-reset-start]
 * 2019-03-15T16:16:39.825+0800: 15.038: [CMS-concurrent-reset: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * Heap
 *  par new generation   total 1415616K, used 982437K [0x0000000080000000, 0x00000000e0000000, 0x00000000e0000000)
 *   eden space 1258368K,  78% used [0x0000000080000000, 0x00000000bbf695c0, 0x00000000ccce0000)
 *   from space 157248K,   0% used [0x00000000d6670000, 0x00000000d6670000, 0x00000000e0000000)
 *   to   space 157248K,   0% used [0x00000000ccce0000, 0x00000000ccce0000, 0x00000000d6670000)
 *  concurrent mark-sweep generation total 524288K, used 524062K [0x00000000e0000000, 0x0000000100000000, 0x0000000100000000)
 *  Metaspace       used 10829K, capacity 10910K, committed 11008K, reserved 1058816K
 *   class space    used 1228K, capacity 1269K, committed 1280K, reserved 1048576K
 *
 *
 *  Easy Excel内存占用
 * 2019-03-15T16:10:34.570+0800: 2.826: [GC (Allocation Failure) 2019-03-15T16:10:34.570+0800: 2.826: [ParNew: 1258368K->121995K(1415616K), 0.0623270 secs] 1258368K->121995K(1939904K), 0.0624646 secs] [Times: user=0.20 sys=0.11, real=0.06 secs]
 * 2019-03-15T16:10:35.558+0800: 3.814: [GC (Allocation Failure) 2019-03-15T16:10:35.558+0800: 3.814: [ParNew: 1380363K->32163K(1415616K), 0.1382847 secs] 1380363K->100734K(1939904K), 0.1383403 secs] [Times: user=0.47 sys=0.13, real=0.14 secs]
 * 2019-03-15T16:10:36.499+0800: 4.754: [GC (Allocation Failure) 2019-03-15T16:10:36.499+0800: 4.754: [ParNew: 1290531K->56662K(1415616K), 0.0298127 secs] 1359102K->125233K(1939904K), 0.0298788 secs] [Times: user=0.23 sys=0.00, real=0.03 secs]
 * 2019-03-15T16:10:37.281+0800: 5.536: [GC (Allocation Failure) 2019-03-15T16:10:37.281+0800: 5.536: [ParNew: 1315030K->69759K(1415616K), 0.0344332 secs] 1383601K->138330K(1939904K), 0.0345493 secs] [Times: user=0.23 sys=0.02, real=0.03 secs]
 * Heap
 *  par new generation   total 1415616K, used 877662K [0x0000000080000000, 0x00000000e0000000, 0x00000000e0000000)
 *   eden space 1258368K,  64% used [0x0000000080000000, 0x00000000b14f7f08, 0x00000000ccce0000)
 *   from space 157248K,  44% used [0x00000000ccce0000, 0x00000000d10ffc98, 0x00000000d6670000)
 *   to   space 157248K,   0% used [0x00000000d6670000, 0x00000000d6670000, 0x00000000e0000000)
 *  concurrent mark-sweep generation total 524288K, used 68571K [0x00000000e0000000, 0x0000000100000000, 0x0000000100000000)
 *  Metaspace       used 9640K, capacity 9776K, committed 9856K, reserved 1058816K
 *   class space    used 1063K, capacity 1104K, committed 1152K, reserved 1048576K
 *
 * </pre>
 *
 * @author dranawhite
 * @version $Id: ExcelReader.java, v 0.1 2019-03-15 10:27 dranawhite Exp $$
 */
public class ExcelReader {

    private static final String excelPath = "E:/test.xlsx";

    public static void main(String[] args) {
        List<List<Object>> result = readByXssf();
//        List<List<Object>> result = readByEasyExcel();
        System.out.println(result.get(0));
    }

    private static List<List<Object>> readByXssf() {
        try {
            final int dataSize = 1024 * 256;
            final int rowSize = 4;
            XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
            Sheet sheet = workbook.getSheetAt(0);
            List<List<Object>> dataList = new ArrayList<>(dataSize);
            for (int i = sheet.getFirstRowNum(), len = sheet.getLastRowNum(); i < len; i++) {
                Row row = sheet.getRow(i);
                List<Object> rowList = new ArrayList<>(rowSize);
                for (int j = 0; j < rowSize; j++) {
                    Cell cell = row.getCell(j);
                    rowList.add(cell.getNumericCellValue());
                }
                dataList.add(rowList);
            }
            return dataList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private static List<List<Object>> readByEasyExcel() {
        try {
            InputStream inputStream = new FileInputStream(excelPath);
            ExcelListener excelListener = new ExcelListener();
            EasyExcelFactory.readBySax(inputStream, new com.alibaba.excel.metadata.Sheet(1, 0), excelListener);
            inputStream.close();
            return excelListener.getData();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
