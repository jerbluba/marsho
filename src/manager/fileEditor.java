package manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.swing.JOptionPane;
import jxl.*;

public class fileEditor {
	
	
	public static void main(String args[]){
		String filePath = new File(new File(new File("").getAbsolutePath()).getParent()).getParent();
		System.out.println(filePath);
		
	}
	
	//屬性擷取
	
	public static HashMap<String,HashMap<Integer,String>> getMenus(){
		HashMap<String,HashMap<Integer,String>> answer=new HashMap<String,HashMap<Integer,String>>();
//		String filePath = "C:\\apache-tomcat-8.0.5\\webapps\\marsho/META-INF/menu.xls";
		String filePath = "C:\\xampp\\tomcat\\webapps\\marsho/META-INF/menu.xls";
	//	JOptionPane.showMessageDialog(null, filePath, "訊息", JOptionPane.INFORMATION_MESSAGE);	
		try{
			jxl.Workbook workbook = jxl.Workbook.getWorkbook(new FileInputStream(filePath));
			jxl.Sheet st = workbook.getSheet(0);
			   
			int rows=st.getRows();		
			   
		   for(int i=0;i<rows;i++){
			   HashMap<Integer,String> temp=new HashMap<Integer,String>();
			   temp.put(0,st.getCell(1,i).getContents() );
			   temp.put(1,st.getCell(2,i).getContents());
			   temp.put(2,st.getCell(3,i).getContents() );
			   answer.put(st.getCell(0,i).getContents(), temp); 
		   }
		   
		   workbook.close();
		   
		  }catch(Exception e){
			   
		  }
		
		
		return answer;
	}

	//網站建檔
	public static void makeFile(String name,String content,String fileType){
		String filePath = new File(new File(new File("").getAbsolutePath()).getParent()).getParent()+"/"+name+"."+fileType;
		
		System.out.println(filePath);
		File file = new File(filePath);		
	
		    file.getParentFile().mkdirs();
		    try {
		    	
		    	if(file.exists()){
		    		file.delete();
		    	}
		    	
		        file.createNewFile();
		        FileOutputStream fw= new FileOutputStream(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					    fw, "UTF-8"));
				bw.write(content);
				bw.close();
				fw.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	//	}		
	}
	
	//EXCEL 全轉表格
	public static String readExcel(String name,HashMap<String,HashMap<Integer,String>> pages,int title) {
		String answer="";
//		String filePath = "C:\\apache-tomcat-8.0.5\\webapps\\marsho/META-INF/"+name+".xls";

		String filePath = "C:\\xampp\\tomcat\\webapps\\marsho/META-INF/"+name+".xls";
//		JOptionPane.showMessageDialog(null, filePath, "訊息", JOptionPane.INFORMATION_MESSAGE);	
		try
		  {
			jxl.Workbook workbook = jxl.Workbook.getWorkbook(new FileInputStream(filePath));
	
			jxl.Sheet st = workbook.getSheet(0);

		   HashMap<String,HashMap<String,String>> td=new HashMap<String,HashMap<String,String>>();
//		   HashMap<String,String> content=new HashMap<String,String>();
		   
		   int rows=st.getRows();
		   int col=st.getColumns();
		   
		   for(int i=0;i<rows ;i++){			  			       		        
			   for(int j=0;j<col;j++){
				   
				   td.put(i+"plus"+j, new HashMap<String,String>());
				   td.get(i+"plus"+j).put("class", i+"plus"+j);
				   td.get(i+"plus"+j).put("labelName", "td");

				   
				   switch(st.getCell(j,i).getContents()){
				   	case "s":td.get(i+"plus"+j).put("content", "");break;
				   	case "r":
				   		if(td.containsKey(
				   				((i-1)+"plus"+j)
				   				)){
				   			int rowspan=2;
				   			for(int k=i+1;k<rows;k++){
				   				if(st.getCell(j,k).getContents().equals("r")){
				   					rowspan++;
				   				}else{ 
				   					k=rows;
				   				}
				   			}
				   			td.get(((i-1)+"plus"+j)).put("rowspan",rowspan+"");
				   		}
				   		
				   		td.remove(i+"plus"+j);
				   		break;
				   	case "l":
				   		if(td.containsKey((i+"plus"+(j-1)))){				   			
				   			int colspan=2;
				   			for(int k=j+1;k<col;k++){
				   				if(st.getCell(k,i).getContents().equals("l")){
				   					colspan++;
				   				}else{ 
				   					k=col;
				   				}
				   			}
				   			td.get((i+"plus"+(j-1))).put("colspan",colspan+"");
				   		}
				   		
				   		td.remove(i+"plus"+j);
				   		break;
				   	case "r+s":td.remove(i+"plus"+j);break;
				   	default:
			   			String contentTemp=st.getCell(j,i).getContents();
				   		td.get(i+"plus"+j).put("content", contentTemp);
				   		break;
				   }
			   }
		  }
		
		   
		   
		   
		   for(int i=0;i<rows ;i++){			  			       		        
			   answer+="<tr class='"+i+"' " +(i==0?"id='"+(title==0?"textTitle":title==1?"subTitle":"''"):"") +"'>";
			   for(int j=0;j<col;j++){
				  if(td.containsKey(i+"plus"+j)){					  
					  answer+=viewer.basic.others(td.get(i+"plus"+j));
				  }
			   }
			   answer+="</tr>";
		  } 
		   workbook.close();
		}catch (Exception e){
		   e.printStackTrace();
		  }
		
		  return answer;
	}
	
	
	
	
	
}
