

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
import java.util.*;

public class SearchFun {
    public static void main(String args[]) throws Exception {
        String path = "C:\\Users\\Administrator\\Desktop\\order.xlsx";
        Workbook wb = POIExcelUtil.getExcelWorkbook(path);
      System.out.println("Number of Sheets:" + wb.getNumberOfSheets());
      System.out.println("Sheet3's name:" + wb.getSheetName(0));
//        System.out.println();
        //2、读取第一个工作表
        Sheet sheet = wb.getSheetAt(0);
    //    excelPrint(sheet);
        String s="/api/order/rentalcontract/uploadCertificate ";
        System.out.println(s.length());
        s.trim();
        System.out.println(s.length());
    }
    public static  void excelPrint(Sheet sheet){
        Map<String,String>authMap=new HashMap<String, String>();
    for(int i=1;i<=sheet.getLastRowNum();i++) {

            Row row = sheet.getRow(i);
         //   for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                String functionNo = row.getCell(0).getStringCellValue();
                String functionPath=row.getCell(1).getStringCellValue();
                if(functionPath==null|functionPath.length()==0||functionPath.equals("无")||functionNo==""||functionNo==null){
                    continue;
                }
               functionPath = functionPath.trim();
               List<String> pathKeyList=new ArrayList();
               if(functionPath.contains("\n")){
                   String functionPaths[]=functionPath.split("\n");
                   for(int a=0;a<functionPaths.length;a++){
                       pathKeyList.add(functionPaths[a]);
                   }
               }
              else{
                   pathKeyList.add(functionPath);
               }

               for(int b=0;b<pathKeyList.size();b++){
                   String s=authMap.get(pathKeyList.get(b));
                   if(s!=null){
                       //
                       if(!(s.contains("="+functionNo)||s.contains(","+functionNo))){
                           authMap.put(pathKeyList.get(b),s+","+functionNo);
                       }
                   } else {
                       authMap.put(pathKeyList.get(b),pathKeyList.get(b)+"=OPT="+functionNo);
                   }
               }

       //     }

       }

        Iterator iter = authMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(value);

        }
        System.out.println(authMap.size()+"=============");
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
