package viewer;

import java.util.HashMap;

public class footer {
	public static String footer(HashMap<String,HashMap<Integer,String>> menus,String version){
		
		HashMap<String,String> utubeAttr=new HashMap<String,String>();
		utubeAttr.put("href",menus.get("utube").get(0) );
		utubeAttr.put("target","_new" );
		utubeAttr.put("content","<div id='utube'></div>" );
		utubeAttr.put("labelName","a" );
		
		String faceBook="<table id='facebook_table' class='leftTable'>" 
				+basic.others("tr",basic.others("td",menus.get("facebook").get(0)))
				+basic.others("tr",basic.others("td",basic.others(utubeAttr)))
				+"</table>";
		
		HashMap<String,String> mailAttr=new HashMap<String,String>();
		mailAttr.put("href","mailto:"+menus.get("mail").get(0) );
		mailAttr.put("target","_blank" );
		mailAttr.put("content","<div id='mail'>E-mail:<br>"+menus.get("mail").get(0)+"</div>" );
		mailAttr.put("labelName","a" );
		
		String contact="<table id='contant-table' class='leftTable'>"
				+basic.others("tr",basic.others("td","<div id='footTitle' class='foot'>"+menus.get("foot").get(0)+"</div>"))
				+basic.others("tr",basic.others("td","<div id='tel' class='foot'>"+menus.get("tel").get(0)+"</div>"))
				+basic.others("tr",basic.others("td",basic.others(mailAttr)))
				+"</table>";
		
		String map="<table id='map-table'>" 
				+basic.others("tr",basic.others("td","<div id='footTitle' class='traffic'>"+menus.get("traffic").get(0)+"</div>"))				
				+basic.others("tr",basic.others("td",menus.get("googlemap").get(0)))
				+basic.others("tr",basic.others("td","<div id='attr' class='traffic'>"+menus.get("addr").get(0)+"</div>"))
				
				+"</table>";
		return faceBook
				+contact
				+map
				;

		
	}
}
