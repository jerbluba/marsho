

import java.io.IOException;
import java.util.HashMap;

import manager.tableMaker;

public class editor {
	public static void editor() throws IOException{
	
		HashMap<String,HashMap<Integer,String>> pages=manager.fileEditor.getMenus();	
			
		for(String p:pages.keySet()){
			System.out.println(pages.get(p).get(1).equals("page"));
			if(pages.get(p).get(1).equals("page")){
				if(p.equals("index")){
					
//					manager.fileEditor.makeFile(p, 
//							viewer.basic.combineContent(
//									tableMaker.indexTable(p, pages),
//									pages.get(p).get(0),
//									p,
//									new String[]{"progress","index","abgne"},
//									pages), 
//									"html");	
					
				}else{
					
					manager.fileEditor.makeFile(p, 
							viewer.basic.combineContent(pages, p), 
									"html");	
					
				}
							
			}
		}
		
	}

	public static void main(String[] args) throws IOException{
		editor();
	}
}
