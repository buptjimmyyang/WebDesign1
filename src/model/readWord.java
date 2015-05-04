package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.model.PicturesTable;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Section;

public class readWord {
	private File userup;//读取文件
	private String userupFileName;//获得文件名
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
	public String execute() throws FileNotFoundException, IOException{
		
		//hwpfDocument是专门处理word的， 在poi中还有处理其他office文档的类
	    HWPFDocument doc = new HWPFDocument(new FileInputStream(userup));
	  
        Range r=doc.getRange();
        for(int x=0;x<r.numSections();x++){
            Section s=r.getSection(x);
            for(int y=0;y<s.numParagraphs();y++){
                Paragraph p=s.getParagraph(y);
                for(int z=0;z<p.numCharacterRuns();z++){
                    CharacterRun run=p.getCharacterRun(z);
                    String text=run.text();
                    System.out.print(text);
                }
            }
        }

	   
	    
	 
	   
		return "success";
	}
}
