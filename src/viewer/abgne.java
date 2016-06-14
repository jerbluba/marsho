package viewer;

import java.util.HashMap;

public class abgne {
	public static String abgne(HashMap<String,HashMap<Integer,String>> elements,int abgneNumber){
		
		String content="";
		HashMap<String,String> previous= new HashMap<String,String>();
		HashMap<String,String> next= new HashMap<String,String>();
		previous.put("href", "#previous");
		previous.put("class", "controls previous");
		previous.put("rel", "previous");
		previous.put("content", "");
		previous.put("labelName", "a");
		next.put("href", "#next");
		next.put("class", "controls next");
		next.put("rel", "next");
		next.put("content", "");
		next.put("labelName", "a");
		content+=basic.others(previous)+basic.others(next);
		
		String subcontent="";
		
		for(int j=0;j<Integer.parseInt(elements.get("abgne"+abgneNumber).get(0));j++){
			HashMap<String,String> link= new HashMap<String,String>();
			link.put("href", "larger/"+elements.get("abgne"+abgneNumber).get(1)+" ("+(j+1)+").jpg");
			link.put("title", "Slide "+j);
			System.out.println(elements.get("abgne"+abgneNumber).get(1)+j+" "+elements.containsKey(elements.get("abgne"+abgneNumber).get(1)+j));
			link.put("content", "<img src='img/"+elements.get("abgne"+abgneNumber).get(1)+" ("+(j+1)+").jpg' "+(elements.containsKey(elements.get("abgne"+abgneNumber).get(1)+j)?"alt='"+elements.get(elements.get("abgne"+abgneNumber).get(1)+j).get(0)+"'":"")+"/>");
			link.put("labelName", "a");
			link.put("target", "_new");
			subcontent+=basic.others("li", basic.others(link));					
		}

		content+=basic.others("ul",subcontent );
		
		
		return basic.others("tr", basic.others("td", basic.div(content, "abgne-gallery", "", "")))+"<tr><td><div id='alt'></div></td></tr>";
		
		
		
	}
}
