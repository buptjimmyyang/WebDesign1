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
public class excelAction {//��ȡexcel�ļ�
	private File userup;//��ȡ�ļ�
	private String userupFileName;//����ļ���
	private ExcelWorkSheet<user> excelWorkSheet;//����excelÿһҳ����Ϣ
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
System.out.print(userupFileName);
       Workbook book = createWorkBook(new FileInputStream(userup)); 
		Sheet sheet=book.getSheetAt(0);//��õ�һҳ
		excelWorkSheet=new ExcelWorkSheet<user>();//���������Ϣ ��Ҫ��Ϊ���������ݺ����ʾ
		Row firstRow=sheet.getRow(0);//��õ�һ�� ������
		Iterator<Cell> iterator = firstRow.iterator(); 
	
		 List<String> cellNames = new ArrayList<String>();  
	        while (iterator.hasNext()) {  
	            cellNames.add(iterator.next().getStringCellValue());  
	        }  
	    	
	        excelWorkSheet.setColumns(cellNames); 
	        Session session=HibernateSessionFactory.getSession();//����ݿ�׼�������������
	        Transaction tx=null;
	        for (int i = 1; i <= sheet.getLastRowNum(); i++) { 
	        	 if(userupFileName.toLowerCase().endsWith("xls")){//��Ϊxls��ʽ
	        		 Row ros = sheet.getRow(i); 
	        		 HSSFCell cell0 = (HSSFCell) ros.getCell(0);   
	        		 HSSFCell cell2 = (HSSFCell) ros.getCell(2);  
	 	            cell0.setCellType(Cell.CELL_TYPE_STRING); //�Ѹõ�Ԫ�����ó�String����  
	 	            cell2.setCellType(Cell.CELL_TYPE_STRING); //�Ѹõ�Ԫ�����ó�String����
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
		        		System.out.print("导入失败");
		        		tx.rollback();}
	        	 }
	        	 else
	        	 {
	        		 Row ros = sheet.getRow(i); 
	 	            XSSFCell cell0 = (XSSFCell) ros.getCell(0);   
	 	            XSSFCell cell2 = (XSSFCell) ros.getCell(2);  
	 	            cell0.setCellType(Cell.CELL_TYPE_STRING); //�Ѹõ�Ԫ�����ó�String����  ������������Ϊ����Ĭ��Ϊnumber����
	 	            cell2.setCellType(Cell.CELL_TYPE_STRING); //�Ѹõ�Ԫ�����ó�String����
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
			        		System.out.print("导入失败");
			        		tx.rollback();}
	        	 }
	       }//for
	        session.close();
	     
		return "success";
	}
}
