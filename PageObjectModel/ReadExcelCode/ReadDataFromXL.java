package readXLFile;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromXL {

	public static String[][] getdata(String fileName) throws IOException {
		
		//To Get into File Location
		XSSFWorkbook book = new XSSFWorkbook("./Test-Datas/"+fileName+".xlsx");
		
		// To Get into Sheet
		XSSFSheet sheet = book.getSheetAt(0);
		
		//To find Number of Rows
		int rows = sheet.getLastRowNum();
		System.out.println("Number of Rows : "+rows);
		
		//To find Number of Columns
		XSSFRow first_row = sheet.getRow(0);
		int column = first_row.getLastCellNum();
		System.out.println("Number of Columns : "+column);
		
		//Creating 2D Array to Store data
		String[][] datas = new String[rows][column];
		
		//Iterate Each Rows
		for(int i=1; i<=rows; i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0; j<column; j++)
			{
				XSSFCell cell = row.getCell(j);
				String value = cell.getStringCellValue();
				datas[i-1][j] = value;
				System.out.print(value+"     ");
			}
			System.out.println();
		}
		book.close();
		return datas;

	}

}
