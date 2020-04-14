package me.cho.demobulkexcelupload;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
        MultipartFile excelFile =request.getFile("excelFile");
        System.out.println("엑셀 파일 업로드 컨트롤러");
        System.out.println(excelFile);
////        if(excelFile==null || excelFile.isEmpty()){
////            throw new RuntimeException("엑셀파일을 선택 해 주세요.");
////        }
////
////        File destFile = new File("D:\\"+excelFile.getOriginalFilename());
////        try{
////            excelFile.transferTo(destFile);
////        }catch(IllegalStateException | IOException e){
////            throw new RuntimeException(e.getMessage(),e);
////        }
////
////        userService.excelUpload(destFile);
////
////        //FileUtils.delete(destFile.getAbsolutePath());
////
////        ModelAndView view = new ModelAndView();
////        view.setViewName("");
////        return view;
        return null;
    }


}
