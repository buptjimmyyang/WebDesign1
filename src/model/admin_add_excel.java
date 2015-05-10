package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import modelFactory.ExcelWorkSheet;
import net.sf.json.JSONObject;

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

import com.opensymphony.xwork2.ActionContext;

import bean.HibernateSessionFactory;
import bean.course;
import bean.s_course;
import bean.student;
import bean.teacher;
import bean.user;

public class admin_add_excel {
private String table;
private File userup;
private String userupFileName;
private HttpServletResponse response;//写回响应
private PrintWriter out;
public String getTable() {
	return table;
}
public void setTable(String table) {
	this.table = table;
}
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
	//System.out.println(table+"filename="+userupFileName);
	if(table.equals("student"))
		student_excel();
	else if(table.equals("s_course")) 
		s_course_excel();
	else if(table.equals("teacher"))
		teacher_excel();
	else if(table.equals("course"))
		course_excel();
	return null;
}
//table==student 相应的处理函数为
public void student_excel() throws FileNotFoundException, IOException
{Workbook book = createWorkBook(new FileInputStream(userup)); 
Sheet sheet=book.getSheetAt(0);//得到第一页excel文件
	List<student> l=new ArrayList<student>();
for (int i = 1; i <= sheet.getLastRowNum(); i++) { 
	 if(userupFileName.toLowerCase().endsWith("xls")){//xls格式的excel处理方法
		 Row ros = sheet.getRow(i); 
		 HSSFCell cell0 = (HSSFCell) ros.getCell(0);//获得每行4列的值
		 HSSFCell cell1 = (HSSFCell) ros.getCell(1);
		 HSSFCell cell2 = (HSSFCell) ros.getCell(2);
		 HSSFCell cell3 = (HSSFCell) ros.getCell(3);
		 cell0.setCellType(Cell.CELL_TYPE_STRING); //将带数字的方格转换为String
       student stu=new student();
       stu.setId(Integer.parseInt(cell0.getStringCellValue()));
       stu.setName(cell1.getStringCellValue());
       stu.setType(cell2.getStringCellValue());
       stu.setGrade(cell3.getStringCellValue());
     l.add(stu);
  
	 }
	 else
	 {Row ros = sheet.getRow(i); 
        XSSFCell cell0 = (XSSFCell) ros.getCell(0);  
       XSSFCell cell1 = (XSSFCell) ros.getCell(1); 
        XSSFCell cell2 = (XSSFCell) ros.getCell(2); 
       XSSFCell cell3 = (XSSFCell) ros.getCell(3); 
 	 cell0.setCellType(Cell.CELL_TYPE_STRING); //将带数字的方格转换为String
      student stu=new student();
      stu.setId(Integer.parseInt(cell0.getStringCellValue()));
      stu.setName(cell1.getStringCellValue());
      stu.setType(cell2.getStringCellValue());
      stu.setGrade(cell3.getStringCellValue());
     l.add(stu);}
}//for


JSONObject object =new JSONObject();
object.put("total",l.size());
object.put("rows", l);
//System.out.println(object.toString());
//写回响应
response=ServletActionContext.getResponse();//设置响应数据
response.setContentType("text/xml;charset=utf-8");
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Pargma","no-cache");
response.setDateHeader("Expires",0);
out = null;
out = response.getWriter();
out.write("success");
out.close();
ActionContext.getContext().getSession().put("response", object.toString());
	}
//table=teacher处理函数
public void teacher_excel() throws FileNotFoundException, IOException{
	Workbook book = createWorkBook(new FileInputStream(userup)); 
	Sheet sheet=book.getSheetAt(0);//得到第一页excel文件
		List<teacher> l=new ArrayList<teacher>();
	for (int i = 1; i <= sheet.getLastRowNum(); i++) { 
		 if(userupFileName.toLowerCase().endsWith("xls")){//xls格式的excel处理方法
			 Row ros = sheet.getRow(i); 
			 HSSFCell cell0 = (HSSFCell) ros.getCell(0);//获得每行4列的值
			 HSSFCell cell1 = (HSSFCell) ros.getCell(1);
			 HSSFCell cell2 = (HSSFCell) ros.getCell(2);
			 HSSFCell cell3 = (HSSFCell) ros.getCell(3);
			 cell0.setCellType(Cell.CELL_TYPE_STRING); //将带数字的方格转换为String
			 teacher tea=new teacher();
			 tea.setId(Integer.parseInt(cell0.getStringCellValue()));
			 tea.setName(cell1.getStringCellValue());
			 tea.setType(cell2.getStringCellValue());
			 tea.setInstitute(cell3.getStringCellValue());
	         l.add(tea);
	  
		 }
		 else
		 {Row ros = sheet.getRow(i); 
	       XSSFCell cell0 = (XSSFCell) ros.getCell(0);  
	       XSSFCell cell1 = (XSSFCell) ros.getCell(1); 
	       XSSFCell cell2 = (XSSFCell) ros.getCell(2); 
	       XSSFCell cell3 = (XSSFCell) ros.getCell(3); 
	 	 cell0.setCellType(Cell.CELL_TYPE_STRING); //将带数字的方格转换为String
	 	 teacher tea=new teacher();
		 tea.setId(Integer.parseInt(cell0.getStringCellValue()));
		 tea.setName(cell1.getStringCellValue());
		 tea.setType(cell2.getStringCellValue());
		 tea.setInstitute(cell3.getStringCellValue());
         l.add(tea);}
	}//for


	JSONObject object =new JSONObject();
	object.put("total",l.size());
	object.put("rows", l);
	//写回响应
	response=ServletActionContext.getResponse();//设置响应数据
	response.setContentType("text/xml;charset=utf-8");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pargma","no-cache");
	response.setDateHeader("Expires",0);
	out = null;
	out = response.getWriter();
	out.write("success");
	out.close();
	ActionContext.getContext().getSession().put("response", object.toString());
}
//table==course
public void course_excel() throws FileNotFoundException, IOException{
	Workbook book = createWorkBook(new FileInputStream(userup)); 
	Sheet sheet=book.getSheetAt(0);//得到第一页excel文件
		List<course> l=new ArrayList<course>();
	for (int i = 1; i <= sheet.getLastRowNum(); i++) { 
		 if(userupFileName.toLowerCase().endsWith("xls")){//xls格式的excel处理方法
			 Row ros = sheet.getRow(i); 
			 HSSFCell cell0 = (HSSFCell) ros.getCell(0);//获得每行4列的值
			 HSSFCell cell1 = (HSSFCell) ros.getCell(1);
			 HSSFCell cell2 = (HSSFCell) ros.getCell(2);
			 
			 cell0.setCellType(Cell.CELL_TYPE_STRING); //将带数字的方格转换为String
			 cell1.setCellType(Cell.CELL_TYPE_STRING); //将带数字的方格转换为String
			 course cou=new course();
			 cou.setC_id(Integer.parseInt(cell0.getStringCellValue()));
			 cou.setT_id(Integer.parseInt(cell1.getStringCellValue()));
			 cou.setC_name(cell2.getStringCellValue());
			 l.add(cou);
	  
		 }
		 else
		 {Row ros = sheet.getRow(i); 
	       XSSFCell cell0 = (XSSFCell) ros.getCell(0);  
	       XSSFCell cell1 = (XSSFCell) ros.getCell(1); 
	       XSSFCell cell2 = (XSSFCell) ros.getCell(2); 
	      
	       cell0.setCellType(Cell.CELL_TYPE_STRING); //将带数字的方格转换为String
			 cell1.setCellType(Cell.CELL_TYPE_STRING); //将带数字的方格转换为String
			 course cou=new course();
			 cou.setC_id(Integer.parseInt(cell0.getStringCellValue()));
			 cou.setT_id(Integer.parseInt(cell1.getStringCellValue()));
			 cou.setC_name(cell2.getStringCellValue());
			 l.add(cou);}
	}//for


	JSONObject object =new JSONObject();
	object.put("total",l.size());
	object.put("rows", l);
	//写回响应
	response=ServletActionContext.getResponse();//设置响应数据
	response.setContentType("text/xml;charset=utf-8");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pargma","no-cache");
	response.setDateHeader("Expires",0);
	out = null;
	out = response.getWriter();
	out.write("success");
	out.close();
	ActionContext.getContext().getSession().put("response", object.toString());
}
//table==s_course
public void s_course_excel() throws FileNotFoundException, IOException{
	Workbook book = createWorkBook(new FileInputStream(userup)); 
	Sheet sheet=book.getSheetAt(0);//得到第一页excel文件
		List<s_course> l=new ArrayList<s_course>();
	for (int i = 1; i <= sheet.getLastRowNum(); i++) { 
		 if(userupFileName.toLowerCase().endsWith("xls")){//xls格式的excel处理方法
			 Row ros = sheet.getRow(i); 
			 HSSFCell cell0 = (HSSFCell) ros.getCell(0);//获得每行4列的值
			 HSSFCell cell1 = (HSSFCell) ros.getCell(1);
			 cell0.setCellType(Cell.CELL_TYPE_STRING); //将带数字的方格转换为String
			 cell1.setCellType(Cell.CELL_TYPE_STRING); //将带数字的方格转换为String
			 s_course scou=new s_course();
			 scou.setS_id(Integer.parseInt(cell0.getStringCellValue()));
			 scou.setC_id(Integer.parseInt(cell1.getStringCellValue()));
			l.add(scou);
	  
		 }
		 else
		 {Row ros = sheet.getRow(i); 
	       XSSFCell cell0 = (XSSFCell) ros.getCell(0);  
	       XSSFCell cell1 = (XSSFCell) ros.getCell(1); 
	       cell0.setCellType(Cell.CELL_TYPE_STRING); //将带数字的方格转换为String
			 cell1.setCellType(Cell.CELL_TYPE_STRING); //将带数字的方格转换为String
			 s_course scou=new s_course();
			 scou.setS_id(Integer.parseInt(cell0.getStringCellValue()));
			 scou.setC_id(Integer.parseInt(cell1.getStringCellValue()));
			l.add(scou);}
	}//for


	JSONObject object =new JSONObject();
	object.put("total",l.size());
	object.put("rows", l);
	//写回响应
	response=ServletActionContext.getResponse();//设置响应数据
	response.setContentType("text/xml;charset=utf-8");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pargma","no-cache");
	response.setDateHeader("Expires",0);
	out = null;
	out = response.getWriter();
	out.write("success");
	out.close();
	ActionContext.getContext().getSession().put("response", object.toString());
	
}
}
