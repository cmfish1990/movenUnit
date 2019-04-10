/*
 * cf
 * FileName: ExcelService.java
 * Author:   BM
 * Date:     2019-04-03 13:44:37
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-04-03 13:44:37> <version> <desc> <source>
 *
 */

package wk.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;


public class ExcelService {

    private final static String excel2003L = ".xls";    //2003- 版本的excel
    private final static String excel2007U = ".xlsx";   //2007+ 版本的excel

    /**
     * 描述：获取IO流中的数据，组装成List<List<Object>>对象
     *
     * @param in
     * @param fileName
     * @param sheetIndex 下标，从零开始
     * @param startRow
     * @return
     * @throws Exception
     */
    public static List<List<Object>> readExcel(InputStream in, String fileName, int sheetIndex, int startRow, int endRow) throws Exception {
        List<List<Object>> list = null;

        //创建Excel工作薄
        Workbook work = getWorkbook(in, fileName);
        if (null == work) {
            throw new Exception("Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        list = new LinkedList<List<Object>>();
        //遍历Excel中所有的sheet
        sheet = work.getSheetAt(sheetIndex);
        if (sheet == null) {
            throw new Exception("sheet不存在！");
        }
        //遍历当前sheet中的所有行
       int linCount= sheet.getLastRowNum();
        if(endRow>=linCount){
            endRow=linCount;
        }
        for (int j = startRow; j <= endRow; j++) {
            row = sheet.getRow(j);
            if (row == null || row.getFirstCellNum() == j) {
                continue;
            }
            //遍历所有的列
            List<Object> columns = new LinkedList<Object>();
            if (startRow < 0) {
                startRow = 1;
            }
            columns.add(j);
            for (int y = 0; y < row.getLastCellNum(); y++) {
                cell = row.getCell(y);
                columns.add(getCellValue(cell));
            }
            list.add(columns);
        }
        return list;
    }

    /**
     * 描述：根据文件后缀，自适应上传文件的版本
     *
     * @param inStr,fileName
     * @return
     * @throws Exception
     */
    public static Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (excel2003L.equals(fileType)) {
            wb = new HSSFWorkbook(inStr);  //2003-
        } else if (excel2007U.equals(fileType)) {
            wb = new XSSFWorkbook(inStr);  //2007+
        } else {
            throw new Exception("解析的文件格式有误！");
        }
        return wb;
    }

    /**
     * 描述：获取IO流中的数据，组装成List<List<Object>>对象
     *
     * @param inputStream inputStream
     * @return 文件内容
     * @throws Exception
     */
    public static List<List<Object>> readExcel4TargetDispatch(InputStream inputStream) throws IOException, Exception {
        List<List<Object>> list = null;

        // 创建Excel工作薄
        Workbook work = new HSSFWorkbook(inputStream);
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        // 遍历Excel中所有的sheet
        sheet = work.getSheetAt(0);
        if (sheet == null) {
            throw new Exception("sheet不存在！");
        }

        // sheet总行数
        int linCount= sheet.getLastRowNum();

        list = new LinkedList<List<Object>>();
        for (int j = 1; j <= linCount; j++) {
            row = sheet.getRow(j);
            if (row == null || row.getFirstCellNum() == j) {
                continue;
            }
            // 遍历所有的列
            List<Object> columns = new LinkedList<Object>();
            columns.add(j);
            for (int y = 0; y < row.getLastCellNum(); y++) {
                cell = row.getCell(y);
                columns.add(getCellValue(cell));
            }
            list.add(columns);
        }
        return list;
    }

    /**
     * 描述：对表格中数值进行格式化
     *
     * @param cell
     * @return
     */
    public static Object getCellValue(Cell cell) {
        Object value = null;
        DecimalFormat df = new DecimalFormat("0");  //格式化number String字符
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                value = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                    value = df.format(cell.getNumericCellValue());
                } else if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    value = cell.getDateCellValue();
                } else {
                    value = cell.getNumericCellValue();
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            default:
                break;
        }
        return value;
    }

    /**
     * 数据写入excel
     *  @param sourceList
     * @param titles
     * @param values
     * @param out
     */
//    this.writeExcel("投放结果", targetDispatchDownViewList, titles, values, out);
    public  void writeExcel(String sheetName, List sourceList, String[] titles, String[] values, OutputStream out) {
        try {
            // 第一步，创建一个workbook，对应一个Excel文件
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet hssfSheet = workbook.createSheet(sheetName);
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
            HSSFRow hssfRow = hssfSheet.createRow(0);
            // 第四步，创建单元格，并设置值表头 设置表头居中
            HSSFCellStyle hssfCellStyle = workbook.createCellStyle();

            //第五步 写入实体，创建单元格
           writeDateInCell(sourceList, hssfSheet, titles, values);
            try {
                workbook.write(out);
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入实体
     */
    public  void writeDateInCell(List sourceList, HSSFSheet hssfSheet, String[] titles, String[] values) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

    }
}
