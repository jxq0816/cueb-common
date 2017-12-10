package com.week7i.share.util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {
    public static List<String> read(String path) throws IOException {
        InputStream inputStream = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
        List<String> result = new ArrayList<>();
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(1);
        //处理当前页，循环读取每一行
        for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
            XSSFRow xssfRow = xssfSheet.getRow(rowNum);
            int maxColIndex = xssfRow.getLastCellNum();
            XSSFCell codeCell = xssfRow.getCell(0);
            String code = codeCell.toString();
            //遍历该行，获取处理每个cell元素
            result.add(code);
        }
        return result;
    }
}

