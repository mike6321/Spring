package me.cho.demobulkexcelupload.controller;

import me.cho.demobulkexcelupload.handler.SheetHandler;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.StylesTable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Project : demo-bulk-excelupload
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/14
 * Time : 9:02 오후
 */
@Controller
public class ExcelController {

    @GetMapping(value = "/excel")
    public String excel() {
        return "excel";
    }

    @RequestMapping(value = "/ExcelController", method = RequestMethod.POST)
    public String excelUpload(MultipartHttpServletRequest request, Model model) {
        System.out.println("???????");



        return "excel";
    }

    @ResponseBody
    @RequestMapping(value = "/excelUploadAjax", method = RequestMethod.POST)
    public String excelUploadAjax(MultipartHttpServletRequest request)  throws Exception{
        System.out.println("I am in Controller");

        final MultipartFile excelFile =request.getFile("excelFile");
        final String fileName = "/Users/junwoochoi/Downloads/"+excelFile.getOriginalFilename();
        final InputStream fis = new FileInputStream(new File(fileName));
        final List<String[]> dataList = new ArrayList<>();


        System.out.println(fis);

        OPCPackage opc = OPCPackage.open(fis);
        XSSFReader xssfReader = new XSSFReader(opc);
        XSSFReader.SheetIterator itr = (XSSFReader.SheetIterator) xssfReader.getSheetsData();



        StylesTable styles = xssfReader.getStylesTable();
        ReadOnlySharedStringsTable strings = new ReadOnlySharedStringsTable(opc);
        SheetHandler sheet2ListHandler = new SheetHandler(dataList, 7);

        while (itr.hasNext()) {

            InputStream sheetStream = itr.next();
            InputSource sheetSource = new InputSource(sheetStream);


            ContentHandler handler = new XSSFSheetXMLHandler(styles, strings, sheet2ListHandler, false);


            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();


            XMLReader sheetParser = ((SAXParser) saxParser).getXMLReader();
            sheetParser.setContentHandler(handler);

            sheetParser.parse(sheetSource);
            sheetStream.close();

        }
        opc.close();


        System.out.println("******************SIZE******************");
        System.out.println(dataList.size());
        System.out.println("******************SIZE******************");



        return null;
    }


}
