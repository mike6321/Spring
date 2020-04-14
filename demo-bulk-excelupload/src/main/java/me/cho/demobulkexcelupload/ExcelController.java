package me.cho.demobulkexcelupload;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

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

        System.out.println(fis);


        return null;
    }


}
