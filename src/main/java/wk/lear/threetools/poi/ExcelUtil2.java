/*
 * cf
 * FileName: ExcelUtil2.java
 * Author:   BM
 * Date:     2019-03-12 10:35:03
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-12 10:35:03> <version> <desc> <source>
 *
 *//*


package wk.lear.threetools.poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import wk.utils.DateUtils;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class ExcelUtil2 {

    private final static String excel2003L = ".xls";    //2003- 版本的excel
    private final static String excel2007U = ".xlsx";   //2007+ 版本的excel

    */
/**
     * 描述：获取IO流中的数据，组装成List<List<Object>>对象
     *
     * @param in,fileName
     * @return
     * @throws IOException
     *//*

    public static List<List<Object>> readExcel(InputStream in, String fileName) throws Exception {
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
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }

            //遍历当前sheet中的所有行
            for (int j = sheet.getFirstRowNum(); j < sheet.getPhysicalNumberOfRows(); j++) {
                row = sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }

                //遍历所有的列
                List<Object> link = new LinkedList<Object>();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    link.add(getCellValue(cell));
                }
                list.add(link);
            }
        }
        return list;
    }

    */
/**
     * 描述：根据文件后缀，自适应上传文件的版本
     *
     * @param inStr,fileName
     * @return
     * @throws Exception
     *//*

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

    */
/**
     * 描述：对表格中数值进行格式化
     *
     * @param cell
     * @return
     *//*

    public static Object getCellValue(Cell cell) {
        Object value = null;
        DecimalFormat df = new DecimalFormat("0");  //格式化number String字符
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");  //日期格式化
        DecimalFormat df2 = new DecimalFormat("0.00");  //格式化数字

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                value = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                    value = df.format(cell.getNumericCellValue());
                } else if ("m/d/yy".equals(cell.getCellStyle().getDataFormatString())) {
                    value = sdf.format(cell.getDateCellValue());
                } else {
                    value = df2.format(cell.getNumericCellValue());
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

    */
/**
     * @param titles     标题
     * @param sortFiles  属性排序
     * @param sourceList 源数据
     *//*

    public static void writeExcel(String[] titles, String[] sortFiles, List<T> sourceList, ServletOutputStream out) {
        try {
            // 第一步，创建一个workbook，对应一个Excel文件
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet hssfSheet = workbook.createSheet("sheet1");
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
            HSSFRow hssfRow = hssfSheet.createRow(0);
            // 第四步，创建单元格，并设置值表头 设置表头居中
            HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
            //居中样式
            hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

            HSSFCell hssfCell = null;
            for (int i = 0; i < titles.length; i++) {
                hssfCell = hssfRow.createCell(i);//列索引从0开始
                hssfCell.setCellValue(titles[i]);//列名1
                hssfCell.setCellStyle(hssfCellStyle);//列居中显示
            }

            // 第五步，写入实体数据
            if (CollectionUtils.isNotEmpty(sourceList)) {
                for (int i = 0; i < sourceList.size(); i++) {
                    hssfRow = hssfSheet.createRow(i + 1);
                    Object t = sourceList.get(i);
                    // 第六步，创建单元格，并设置值
                    for (int j = 0; j < sortFiles.length; j++) {
                        createCell(t, sortFiles[j], hssfRow, j);
                    }
                }
            }

            // 第七步，将文件输出到客户端浏览器
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

    */
/**
     * 反射，通过属性名称获取属性值
     *//*

    public static void createCell(Object obj, String fielName, HSSFRow hssfRow, int j) {
        try {
            Class clazz = obj.getClass();
            Field field = clazz.getDeclaredField(fielName);
            field.setAccessible(true);
            String type = field.getGenericType().toString();

            if (type.equals("class java.lang.String")) {
                hssfRow.createCell(j).setCellValue(field.get(obj) + "");
            } else if (type.equals("class java.lang.Boolean")) {
                hssfRow.createCell(j).setCellValue(field.getBoolean(obj));
            } else if (type.equals("class java.lang.Integer")) {
                hssfRow.createCell(j).setCellValue(field.getInt(obj));
            } else if (type.equals("class java.lang.Long")) {

            } else if (type.equals("class java.util.Date")) {
                Date date = (Date) field.get(obj);
                String dateStr = "";
                if (null != date) {
                    dateStr = DateUtils.format(date, "yyyy-MM-dd HH:mm:ss");
                }
                hssfRow.createCell(j).setCellValue(dateStr);
            } else {
                hssfRow.createCell(j).setCellValue(field.get(obj) + "");
            }
        } catch (Exception e) {


        }
    }

}
*/
