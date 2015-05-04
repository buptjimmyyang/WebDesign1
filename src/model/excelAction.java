package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;




import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelFactory.ExcelWorkSheet;
import bean.HibernateSessionFactory;
import bean.user;
public class excelAction {//读取excel文件
	private File userup;//读取文件
	private String userupFileName;//获得文件名
	private ExcelWorkSheet<user> excelWorkSheet;//设置excel每一页的信息
	public File getUserup() {
		return userup;
	}
	public void setUserup(File userup) {
		this.userup = userup;
	}
	
	public String getUserupFileName() {
		return userupFileName;
	}
	public void setUserupFileName(String userupFileName) {
		this.userupFileName = userupFileName;
	}
	public ExcelWorkSheet<user> getExcelWorkSheet() {
		return excelWorkSheet;
	}
	public void setExcelWorkSheet(ExcelWorkSheet<user> excelWorkSheet) {
		this.excelWorkSheet = excelWorkSheet;
	}
	public Workbook createWorkBook(InputStream is) throws IOException{  
        if(userupFileName.toLowerCase().endsWith("xls")){  
            return new HSSFWorkbook(is);  
        }  
        if(userupFileName.toLowerCase().endsWith("xlsx")){  
            return new XSSFWorkbook(is);  
        }  
        return null;  
    }
	
	public String execute() throws FileNotFoundException, IOException{

       Workbook book = createWorkBook(new FileInputStream(userup)); 
		Sheet sheet=book.getSheetAt(0);//获得第一页
		excelWorkSheet=new ExcelWorkSheet<user>();//设置数据信息 主要是为了添加上数据后的显示
		Row firstRow=sheet.getRow(0);//获得第一行 即列明
		Iterator<Cell> iterator = firstRow.iterator(); 
	
		 List<String> cellNames = new ArrayList<String>();  
	        while (iterator.hasNext()) {  
	            cellNames.add(iterator.next().getStringCellValue());  
	        }  
	    	
	        excelWorkSheet.setColumns(cellNames); 
	        Session session=HibernateSessionFactory.getSession();//打开数据库准备保存读入的数据
	        Transaction tx=null;
	        for (int i = 1; i <= sheet.getLastRowNum(); i++) { 
	        	 if(userupFileName.toLowerCase().endsWith("xls")){//若为xls格式
	        		 Row ros = sheet.getRow(i); 
	        		 HSSFCell cell0 = (HSSFCell) ros.getCell(0);   
	        		 HSSFCell cell2 = (HSSFCell) ros.getCell(2);  
	 	            cell0.setCellType(Cell.CELL_TYPE_STRING); //把该单元格设置成String类型  
	 	            cell2.setCellType(Cell.CELL_TYPE_STRING); //把该单元格设置成String类型
	 	           user user = new user();  
		            user.setId(Integer.parseInt(cell0.getStringCellValue()));  
		            user.setType(ros.getCell(1).getStringCellValue());  
		            user.setPassword(cell2.getStringCellValue());  
		            excelWorkSheet.getData().add(user);  
		            try{
		        		tx=session.beginTransaction();
		        		session.save(user);
		        		tx.commit();
		      }
		        	catch(Exception e){
		        		System.out.print("添加失败！！！");
		        		tx.rollback();}
	        	 }
	        	 else
	        	 {
	        		 Row ros = sheet.getRow(i); 
	 	            XSSFCell cell0 = (XSSFCell) ros.getCell(0);   
	 	            XSSFCell cell2 = (XSSFCell) ros.getCell(2);  
	 	            cell0.setCellType(Cell.CELL_TYPE_STRING); //把该单元格设置成String类型  如果格子里的数据为数字默认为number类型
	 	            cell2.setCellType(Cell.CELL_TYPE_STRING); //把该单元格设置成String类型
	 	           user user = new user();  
		            user.setId(Integer.parseInt(cell0.getStringCellValue()));  
		            user.setType(ros.getCell(1).getStringCellValue());  
		            user.setPassword(cell2.getStringCellValue());  
		             excelWorkSheet.getData().add(user);  
		             try{
			        		tx=session.beginTransaction();
			        		session.save(user);
			        		tx.commit();
			      }
			        	catch(Exception e){
			        		System.out.print("添加失败！！！");
			        		tx.rollback();}
	        	 }
	       }//for
	        session.close();
	     
		return "success";
	}
}
