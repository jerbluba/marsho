package viewer;

import java.util.HashMap;

public class script {
	
	public static String script(String page,HashMap<String,HashMap<Integer,String>> pages){
		String version=pages.get("version").get(0);
		String[] list={
				"https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js?v="+version,		
				"js/jquery.nivo.slider.js?v="+version,	
				"js/jquery-asPieProgress.js?v="+version,	
				"js/abgne.js?v="+version,
				"js/screen.js?v="+version,
				"js/"+page+".js?v="+version,
		};
		
		
		String[] content={
				"(function(d, s, id) {var js, fjs = d.getElementsByTagName(s)[0];if (d.getElementById(id)) return;js = d.createElement(s); js.id = id;js.src = '//connect.facebook.net/zh_HK/sdk.js#xfbml=1&version=v2.3';fjs.parentNode.insertBefore(js, fjs);}(document, 'script', 'facebook-jssdk'));",
				"  $(window).load(function() {        $('#slider').nivoSlider();    });"
						};
		String answer="";
		
		
		
		
		for(String s:list){
			answer+=basic.script("",s);			
		}		
		for(String s:content){
			answer+=basic.script(s,"");			
		}
		
		
		
		return answer;
	}
	
	public static String script(String version,String scriptType){
		String[] list={
				"https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js?v="+version,
				"js/jquery-asPieProgress.js?v="+version,
				"js/screen.js?v="+version,
				"js/abgne.js?v="+version,
				"js/"+scriptType+".js"+"?v="+version,
				
		};
		
		String[] content={
				 "https://www.google.com/recaptcha/api.js"

				
		};
		String answer="";
		
		for(String s:list){
			answer+=basic.script("",s);			
		}		
		for(String s:content){
			answer+=basic.script(s,"");			
		}
		
		return answer;
	}
	
}
