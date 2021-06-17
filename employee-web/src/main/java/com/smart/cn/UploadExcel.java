package com.smart.cn;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author MG LV
 * @Date Created in 2021/6/16 17:28
 */
public class UploadExcel {
    public static void main(String[] args) throws IOException {
        // 创建工作簿
        Workbook workbook = new XSSFWorkbook();
        // 创建 sheet 并指定 sheet 的名称
        Sheet title = workbook.createSheet("我是标题");
        Row row = title.createRow(0);
        // 创建行
        Cell cell = row.createCell(1);
        Cell cell1 = row.createCell(2);
        Cell cell2 = row.createCell(3);
        // 给 cell 单元格写 文字
        cell.setCellValue("头条 1");
        cell1.setCellValue("头条 2");
        cell2.setCellValue("头条 3");

        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setColor(Font.COLOR_RED);

        FileOutputStream out = new FileOutputStream("C:\\Users\\MGLV\\Desktop\\Demo.xlsx");
        workbook.write(out);
        out.close();
        workbook.close();

    }
}
