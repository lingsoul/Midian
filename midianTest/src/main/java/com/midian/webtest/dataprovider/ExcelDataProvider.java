package com.midian.webtest.dataprovider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * excel数据提供
 */
public class ExcelDataProvider {

    /**
     * 通过相关信息获取数据
     * @param filePath
     * @param fileName
     * @param sheetName excel的sheet名
     * @param beginRowNum 从第几行开始读 (,对应实际表格的第几行，从1开始数，默认为1）
     * @param endRowNum 读到第几行(默认为1）
     * @param beginColumnNum 从第几列开始读(默认为1）
     * @param endColumnNum 读到第几列(默认为1）
     * @return
     */
    public static Object[][] getData(String filePath, String fileName, String sheetName, int beginRowNum,
            int endRowNum, int beginColumnNum, int endColumnNum) {

        // 判断传入的值是否合法 待续....
        Object[][] array = null;
        // 文件路径
        try {
            String fullFilePath = filePath + fileName;
            InputStream is = new FileInputStream(fullFilePath);
            Workbook wb = Workbook.getWorkbook(is);
            Sheet rs = wb.getSheet(sheetName);
            // 获取表格总行数
            int rsRows = rs.getRows();
            // 获取表格总列数
            int rsColumns = rs.getColumns();
            // 判断参数是否超过行列 待续......
            if (rs == null) {
                return null;// 报错
            }
            array = new Object[endRowNum - beginRowNum + 1][endColumnNum - beginColumnNum + 1];
            int arrayRowNum = 0;
            for (int i = beginRowNum - 1; i <= endRowNum - 1; i++) {// i 表示行
                int arrayColNum = 0;
                for (int j = beginColumnNum - 1; j <= endColumnNum - 1; j++) {// j表示列
                    Cell cell = rs.getCell(j, i);// getCell(j,i)表示取i行j列的元素
                    array[arrayRowNum][arrayColNum] = cell.getContents();
                    arrayColNum++;
                }
                arrayRowNum++;
            }
            wb.close();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

}