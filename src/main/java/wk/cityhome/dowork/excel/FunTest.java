

package wk.cityhome.dowork.excel;

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

public class FunTest {
    public static void main(String args[]) throws Exception{
        String path="E:\\    基础信息表.xlsx";
        Workbook wb= POIExcelUtil.getExcelWorkbook(path);
        System.out.println("Number of Sheets:" + wb.getNumberOfSheets());
        System.out.println("Sheet3's name:" + wb.getSheetName(1));
        System.out.println();

        //2、读取第一个工作表
        Sheet sheet = wb.getSheetAt(1);
        wirteExcelFile(sheet);

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
