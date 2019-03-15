package com.study.excel.poi;

import org.apache.poi.ooxml.util.SAXHelper;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;

/**
 * @author liangyuquan
 * @version $Id: XssfEventModel.java, v 0.1 2019-03-15 11:19 liangyuquan Exp $$
 */
public class XssfEventModel {

    public void processOneSheet(String filename) {
        try {
            OPCPackage pkg = OPCPackage.open(filename);
            XSSFReader xssfReader = new XSSFReader(pkg);
            SharedStringsTable sst = xssfReader.getSharedStringsTable();
            XMLReader parser = fetchSheetParser(sst);

            // To look up the Sheet Name / Sheet Order / rID,
            // you need to process the core Workbook stream.
            // Normally it's of the form rId# or rSheet#
            InputStream sheet = xssfReader.getSheet("rId2");
            InputSource sheetSource = new InputSource(sheet);
            parser.parse(sheetSource);
            sheet.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public XMLReader fetchSheetParser(SharedStringsTable sst) throws SAXException, ParserConfigurationException {
        XMLReader parser = SAXHelper.newXMLReader();
        ContentHandler handler = new SheetHandler(sst);
        parser.setContentHandler(handler);
        return parser;
    }

    private static class SheetHandler extends DefaultHandler {
        private SharedStringsTable sst;
        private String lastContents;
        private boolean nextIsString;

        private SheetHandler(SharedStringsTable sst) {
            this.sst = sst;
        }

        @Override
        public void startElement(String uri, String localName, String name, Attributes attributes) {
            if ("c".equals(name)) {
                System.out.print(attributes.getValue("r") + " - ");
                String cellType = attributes.getValue("t");
                if (cellType != null && "s".equals(cellType)) {
                    nextIsString = true;
                } else {
                    nextIsString = false;
                }
            }
            lastContents = "";
        }

        @Override
        public void endElement(String uri, String localName, String name) {
            if (nextIsString) {
                int idx = Integer.parseInt(lastContents);
                lastContents = sst.getItemAt(idx).getString();
                nextIsString = false;
            }

            if (name.equals("v")) {
                System.out.println(lastContents);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            lastContents += new String(ch, start, length);
        }
    }

    public static void main(String[] args) {
        final String excelPath = "E:/test.xlsx";
        XssfEventModel model = new XssfEventModel();
        model.processOneSheet(excelPath);
    }

}
