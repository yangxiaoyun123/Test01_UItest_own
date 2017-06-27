package com.xiaoyun.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {

	private static final String EXCEL_XLS = "xls";   //2003
	private static final String EXCEL_XLSX = "xlsx";   //2007
	
	private static SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void checkExcelVaild(File file) throws Exception{
		if (!file.exists()){
			throw new Exception("文件不存在");
		}
		if(!(file.isFile()&&(file.getName().endsWith(EXCEL_XLS)||file.getName().endsWith(EXCEL_XLSX))))
			throw new Exception("文件不是Excel");
	}
	
	
	//判断文件是2003/2007，分不同的方法读取
	public static Workbook getWorkbook(File file) throws IOException{
		Workbook wb = null;
		FileInputStream in = new FileInputStream(file);
		if(file.getName().endsWith(EXCEL_XLS)){
			wb = new HSSFWorkbook(in);
		}
		else if(file.getName().endsWith(EXCEL_XLSX)){
			wb = new XSSFWorkbook(in);
		}
		return wb;
	}
	
	
	public static  List<TestCase> getUITestData(String filepath){
		List<TestCase> testCases = new ArrayList<TestCase>();
		try{
	    String excelPath = System.getProperty("user.dir")+"/testcasedata/"+filepath;
		File excelFile = new File(excelPath); //创建文件对象
		checkExcelVaild(excelFile);  //判断文件是否存在
		Workbook workbook = getWorkbook(excelFile); //选取处理文件类型的方法
		Sheet sheet = workbook.getSheetAt(0);
		Row firstRow =sheet.getRow(0);
		int count = 0;
		for(Row row : sheet){
			if(count == 0){//跳过首行
				count++;
				continue;
			}
			if(row.getCell(0).toString().equals("")||row.getCell(1).toString().equals("notRun")){ //跳过空的cese或notRun的case
				continue;
			}
			String caseName = convertCellValveToString(row.getCell(0));
			String isCheck = convertCellValveToString(row.getCell(2));
			String expectedReault = convertCellValveToString(row.getCell(3));
			Map<String ,String> testData = new HashMap<String,String>();
			int skipNum = 0;  
			for(Cell cell:row){
				if(skipNum<4){ //跳过用例必需字段标识，键值对能对应的下标
					skipNum++;
					continue;
				}
				if(cell.toString() == null){
					continue;
				}
				testData.put(convertCellValveToString(firstRow.getCell(skipNum++)),convertCellValveToString(cell)); //首行的键和非空单元格的值，做键值对匹配
			}
			testCases.add(new TestCase(caseName,isCheck,expectedReault,testData));
		  }
		}catch(Exception e){
			e.printStackTrace();
		}
		return testCases;
		
	}
	
	public static String convertCellValveToString(Cell cell){
		int cellType = cell.getCellType();
		String cellValue = "";
		switch(cellType){
		case Cell.CELL_TYPE_BOOLEAN://布尔类型
			cellValue = cell.getBooleanCellValue()? "TRUE":"fALIE";
		case Cell.CELL_TYPE_FORMULA: //公式
			cellValue = cell.getCellFormula();
		case Cell.CELL_TYPE_NUMERIC: //数字
			cell.setCellType(Cell.CELL_TYPE_STRING);
			cellValue = cell.getStringCellValue();
		case Cell.CELL_TYPE_STRING: //字符串型
			cellValue = cell.getStringCellValue();
		}
		return cellValue;
	}
	
}
