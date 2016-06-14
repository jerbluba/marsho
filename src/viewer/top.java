package viewer;

import java.util.HashMap;


public class top {
	public static String top(){
		return 
				"<table id='top-table'>	"
				+basic.others("tr",basic.others("td",
//						"<a href='index.html'>"+
						 "<div id='top-link' alt='' >"
//						+ "</div></a>"
						 ))
				+"	</table>	"
			
				;
	}
		public static String nivoslider(String version){
			HashMap<Integer,HashMap<String,String>> animation=new HashMap<Integer,HashMap<String,String>>();
			String content="";
			for(int i=0;i<8;i++){
				animation.put(i, new HashMap<String,String>());
				animation.get(i).put("labelName", "img");
				animation.get(i).put("src", "img/mus ("+(i+1)+").jpg?v="+version);
				animation.get(i).put("data-thumb", "img/mus ("+(i+1)+").jpg");
				animation.get(i).put("height", "20%");
				animation.get(i).put("content", "");
				content+=basic.others(animation.get(i));
			}
			
			
			return	basic.div(content, "slider" , "nivoSlider", "")
					//+top()
				
					;
		}
}
