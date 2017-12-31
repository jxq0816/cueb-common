package com.week7i.share.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadExcel {
    public static List<Map> read(String path) throws IOException {
        InputStream inputStream = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
        List<Map> result = new ArrayList<>();
        HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
        //处理当前页，循环读取每一行
        for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
            HSSFRow hssfRow = hssfSheet.getRow(rowNum);
            int maxColIndex = hssfRow.getLastCellNum();
            Map map=new HashMap<>();
            HSSFCell codeCell = hssfRow.getCell(0);
            String code = codeCell.toString();
            //遍历该行，获取处理每个cell元素
            map.put("code",code);
            result.add(map);
        }
        return result;
    }
}

