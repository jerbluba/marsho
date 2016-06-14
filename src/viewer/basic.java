package viewer;

import java.io.IOException;
import java.util.HashMap;



public class basic {
	
	
	private static String content(String page,String type,HashMap<String,HashMap<Integer,String>> pages) throws IOException{
		String answer="";
		switch(type){
		case "index":answer+=manager.tableMaker.indexTable(page, pages);break;
		case "multiTable":answer+=manager.tableMaker.multiTable(page,pages);break;	
		case "sales":answer+=manager.tableMaker.saleTable(page,pages);break;	
		case "normal":answer+=manager.tableMaker.mainTable(page,pages);break;	
		case "list":answer+=manager.tableMaker.goodList(page,pages);break;
		case "board":answer+=manager.tableMaker.boardList(0,pages);break;
		default:answer+=manager.tableMaker.generalTable(page,pages);break;
		}
		return answer;
	}
	
	public static String html(String content){
		return "<!DOCTYPE html><html>"+content+"</html>";
	}
	
	public static String body(String content){
		return "<body class='no-header-page wsite-theme-light wsite-page-index'>"+content+"</body>";
	}
	
	public static String head(String content,String title, String keyWords){
		return "<head><meta http-equiv='Content-Type' content='text/html; charset=utf-8'>" 
				+"<meta http-equiv=\"Content-Language\" content=\"zh-tw\" />" 
				
				+"<meta name=\"description\" content=\"" 
				+title
				+"\" /><meta name=\"keywords\" content=\"" 
				+keyWords+
				"\" /><title>"
				+title
				+"</title>"
				+content
				+"</head>";
	}
	public static String head(String content,String title ){
		return "<head><meta http-equiv='Content-Type' content='text/html; charset=utf-8'><title>"
				+title
				+"</title>"
				+content
				+"</head>";
	}
	public static String script(String content,String src){
		return "<script "
				+(src.equals("")?"type='text/javascript'":"src='"+src+"'")
				+">"+content+"</script>";
	}
	public static String css(String src){
		return "<link rel='stylesheet' type='text/css' href='"
				+src+"' />";
	}
	
	
	//複雜版
	public static String others(HashMap<String,String> attr){
		String answer="<"+attr.get("labelName")+" ";
		for(String s:attr.keySet()){
			if(!(s.equals("content")||s.equals("labelName"))){
				answer+=(s+"=\""+attr.get(s)+"\" ");	
			}	
		}
		return answer+">"+attr.get("content")+"</"+attr.get("labelName")+">";
	}
	
	//簡易版
	public static String others(String labelName,String content){
		return "<"+labelName+"> "+content+"</"+labelName+">";
	}

	
	
	public static String div(String content,String id ,String cla,String style){
		return "<div "
				+(!id.equals("")?" id='"+id+"'":"")
				+(!cla.equals("")?" class='"+cla+"'":"")
				+(!style.equals("")?" style='"+style+"'":"")
				+">"+content+"</div>";
	}
	
	
	/*
	 * HTML檔案格式
	 * */
	
	
	
	public static String combineContent(HashMap<String,HashMap<Integer,String>> pages,String page) throws IOException{
		String keyWords="";
		for(String s:pages.keySet()){
			if(pages.get(s).get(1).equals("keyword")){
				keyWords+=(pages.get(s).get(0)+"，");				
			}			
		}
		
		return html(
				head(css.css(pages.get("version").get(0))+script.script(page,pages),""+pages.get(page).get(0),keyWords)
				+body(
						
						div(
							div(div(subMenu.subMenu(page,pages),"subMenu","",""),"","subleft","")	
							
							+div(
									div(top.nivoslider(pages.get("version").get(0)),"header-wrap","","")
									+div(content(page,pages.get(page).get(2),pages),"","paragraph","")
									,"","subright","")
							,
						"","container","")
						
						+div(footer.footer(pages, pages.get("version").get(0)),"","foot-container","")
						//+div("<canvas class='loader'></canvas>","invisibleOne","pie_progress","")


						+"<div id='invisibleOne' > "
						+ "<div id='progressContainer' class=\"pie_progress\" role=\"progressbar\" data-goal=\"100\"> "
						+ "<div class=\"pie_progress__number\">0%</div>  "
						+ "<div class=\"pie_progress__label\">Loading...</div>"
						+ "</div>"
						+ "</div>"
						));
	}
	public static String combineContent(String content,String title,String scriptType,String[] cssList,HashMap<String,HashMap<Integer,String>> pages) throws IOException{
		String version=pages.get("version").get(0);
		
		return html(
					head(
						css.css(version,cssList)
						+script.script(version,scriptType),
						title
					)
					+body(
						div(content,"main-wrap","","")	
					)
				);
	}	
}
