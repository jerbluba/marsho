package viewer;



public class css {
	public static String css(String version){
		String[] list={
				"css/screen.css"+"?v="+version,
				"css/nivo-slider.css"+"?v="+version,
				"css/abgne.css"+"?v="+version,
				"css/progress.css"+"?v="+version,
				
		};
		String answer="";
		
		for(String s:list){
			answer+=basic.css(s);			
		}		
		
		return answer;
	}
	
	
	public static String css(String version,String[] list){

		String answer="";
		
		for(String s:list){
			answer+=basic.css("css/"+s+".css?v="+version);			
		}		
		
		return answer;
	}
	
}
