package me.cho.demobulkexcelupload.handler;

import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;

import java.util.List;

/**
 * Project : demo-bulk-excelupload
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/14
 * Time : 10:58 오후
 */
public class SheetHandler implements XSSFSheetXMLHandler.SheetContentsHandler {

    private List<String[]> rows;
    private String[] row;
    private int columnCnt;
    private int currColNum = 0;

    public SheetHandler(List<String[]> rows, int columnCnt) {
        this.rows = rows;
        this.columnCnt = columnCnt;
    }

    @Override
    public void cell(String arg0, String value){
        // TODO Auto-generated method stub
        row[currColNum++] = value == null ? "" : value;
    }

    @Override
    public void endRow(){
        // TODO Auto-generated method stub
        boolean flag = false;
        for (String data : row) {
            if(!"".equals(data))
                flag = true;
        }

        if (flag){
            /*
             * flag가 true 즉 마지막 인덱스를 읽으면
             * 그떄부터 데이터를 담기 시작합니다.
             * 아래 sysout의 주석을 풀면 확인할 수 있습니다.
             * */
//            System.out.println("row :: "+row[0] + " " +row[1]+" "+row[2]);ㅓ


            /*
             * 아래 코드는
             * 데이터를 담는 것과 동시에 마이플랫폼 타입으로 담는것을 시도한 코드입니다.
             * */

            // List로 담기
            rows.add(row);

        }

    }

    @Override
    public void headerFooter(String arg0, boolean arg1, String arg2){
        // TODO Auto-generated method stub

    }

    @Override
    public void startRow(int arg0){
        // TODO Auto-generated method stub
        this.row = new String[columnCnt];
        currColNum = 0;

    }



}
