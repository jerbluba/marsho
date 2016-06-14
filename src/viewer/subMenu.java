package viewer;

import java.util.HashMap;

public class subMenu {

	public static String subMenu(String page,HashMap<String,HashMap<Integer,String>> menu){
		
		String answer=top.top();		
		int range=6;		
		
		for(int i=1;i<=range;i++){			
			for(int j=0;j<=range;j++){
				if(j==0){
					if(menu.containsKey("page"+i)){
						HashMap<String,String> linkAttr=new HashMap<String,String>();
						linkAttr.put("href","page"+i+".html?v="+ menu.get("version").get(0));
						
						linkAttr.put("content",menu.get("page"+i).get(0) );
						linkAttr.put("labelName","a" );
						answer+=
								"<h2 id=page"+i+">" 
								+"<div id='small'>"
								+basic.others(linkAttr)
								+"</div></h2>";					
					}	
				}else if(menu.containsKey("page"+i+"_"+j)){
					HashMap<String,String> linkAttr=new HashMap<String,String>();
					linkAttr.put("href","page"+i+"_"+j+".html?v="+ menu.get("version").get(0));
					
					linkAttr.put("content",menu.get("page"+i+"_"+j).get(0) );
					linkAttr.put("labelName","a" );
					answer+="<ul>"
							+"<li id=page"+i+"_"+j+">" 
							+basic.others(linkAttr)
							+"</li>	"
							+"</ul>";
					
				}				
			}
		}
		
		answer=answer.replace("</ul><ul>", "");
		
		
		
		return answer;
	}
	
}
