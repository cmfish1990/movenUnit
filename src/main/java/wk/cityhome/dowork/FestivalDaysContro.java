

package wk.cityhome.dowork;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import wk.utils.POIExcelUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FestivalDaysContro {



    public static void main(String[] args) throws Exception{
        String path = "E:\\moveUnitWork\\日历节假日信息.xlsx";
        Workbook wb = POIExcelUtil.getExcelWorkbook(path);
        System.out.println("Number of Sheets:" + wb.getNumberOfSheets());
        Sheet sheet = wb.getSheetAt(0);
        excelPrint(sheet);

    }
    public static  void excelPrint(Sheet sheet){
        String strall="[";
        for(int i=1;i<=sheet.getLastRowNum();i++) {

            Row row = sheet.getRow(i);
            //   for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
            String v1 = row.getCell(0).getStringCellValue();
            String v2=row.getCell(1).getStringCellValue();
            String v3=row.getCell(2).getStringCellValue();
            // {\"day\":\"2019/05/01\",\"festivalName\":\"劳动节\",\"weekdayTag\":\"休\"}
            String str = "{\"day\":\""+v1+"\",\"festivalName\":\""+v2+"\",\"weekdayTag\":\""+v3+"\"}";
            System.out.println(str);
            if(i!=sheet.getLastRowNum()){
                str+=",";
            }
            strall+=str;
        }
        strall+="]";

        System.out.println(strall);

    }





    public static void wirteExcelFile( Sheet outsheet) throws Exception {
        String path="E:\\xinjian.xlsx";
        Workbook wb= POIExcelUtil.getExcelWorkbook(path);
        Sheet insheet = wb.getSheetAt(0);
        Row inrow=insheet.getRow(0);
        System.out.println(wb.getSheetName(0));

        Row row = outsheet.getRow(1);
        for(int i=0;i<row.getPhysicalNumberOfCells();i++ )
        {
            String value=row.getCell(i).getStringCellValue();
            Cell cell = inrow.getCell(i);
            if (cell == null) {
                inrow.createCell(i).setCellValue(value);
            } else {
                cell.setCellValue(value);
            }
            System.out.println(value);
        }
        FileOutputStream out = null;
        out = new FileOutputStream(path);
        wb.write(out);


    }
    public void createExcelFile() {
        HSSFWorkbook wb = new HSSFWorkbook();

        //添加Worksheet（不添加sheet时生成的xls文件打开时会报错）
        @SuppressWarnings("unused")
        Sheet sheet1 = wb.createSheet();
        @SuppressWarnings("unused")
        Sheet sheet2 = wb.createSheet();
        @SuppressWarnings("unused")
        Sheet sheet3 = wb.createSheet("new sheet");
        @SuppressWarnings("unused")
        Sheet sheet4 = wb.createSheet("rensanning");

        //  存为Exce   l文件
        FileOutputStream out = null;

        try {
            out = new FileOutputStream("c:\\text.xls");
            wb.write(out);
        } catch (IOException e) {
            System.out.println(e.toString());
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }

    }

    public static void selectExcelInfo(){
        FileInputStream in = null;
        Workbook wb = null;


//方法二：使用POIFSFileSystem
        try {
            in = new FileInputStream("e:\\    基础信息表.xlsx");
            POIFSFileSystem fs = new POIFSFileSystem(in);
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            System.out.println(e.toString());
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }

        System.out.println("====================Workbook====================");
        System.out.println("Number of Sheets:" + wb.getNumberOfSheets());
        System.out.println("Sheet3's name:" + wb.getSheetName(3));
        System.out.println();
    }
}


