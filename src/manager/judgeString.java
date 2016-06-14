package manager;

import java.util.Calendar;
import java.util.Locale;
import java.util.Set;
import java.text.DateFormatSymbols;

// TODO 全都拿到EXCEL
public class judgeString {
	public static boolean isYear(String victim){
		Calendar cal = Calendar.getInstance(); 
		boolean answer=false;
		for(int i=1980;i<=cal.get(Calendar.YEAR)+1;i++){
			if(victim.equals(i+"")){
				answer=true;
			}
		}
		return answer;
	}
	
	public static boolean isNumber(String victim,Integer max,Integer min){
		boolean answer=false;
		int localMax=0;
		int localMin=0;		
		if(max>=min){localMax=max;localMin=min;}else{localMax=min;localMin=max;}
		for(int i=localMin;i<=localMax;i++){
			if(victim.equals(i+"")){
				answer=true;
			}
		}
		return answer;
	}
	
	public static int parseNumber(String victim,Integer max,Integer min){
		int answer=1;
		int localMax=0;
		int localMin=0;		
		if(max>=min){localMax=max;localMin=min;
		}else{
			localMax=min;localMin=max;}
		
		switch(victim){
			case "01": victim="1";break;
			case "02": victim="2";break;
			case "03": victim="3";break;
			case "04": victim="4";break;
			case "05": victim="5";break;
			case "06": victim="6";break;
			case "07": victim="7";break;
			case "08": victim="8";break;
			case "09": victim="9";break;
		}
		
		for(int i=localMin;i<=localMax;i++){
			if(victim.equals(i+"")){
				answer=i;
			}
		}
		
		
		return answer;
	}
	
	public static int smallest(Set<Integer> args){
		if(args.size()==0){
			return 0;
		}else if(args.size()==1){
			return args.iterator().next();
		}else{
			int min=args.iterator().next();
			for(int i=1;i<args.size();i++){
				min=Math.max(min, args.iterator().next());
				
			}		
			return min;
			
		}
	}
	
	//通用文字
	
	public static String month(String month,String language,int min,int max){
		
		DateFormatSymbols mon=new DateFormatSymbols();
		switch(language){
			case "En":
				mon=new DateFormatSymbols(Locale.ENGLISH);
				break;
			default:
				mon=new DateFormatSymbols(Locale.TAIWAN);
				break;
		}
		return mon.getMonths()[parseNumber(month,min,max)-1];
	}
	
	public static String afterPost(String language){
		String answer="";
		switch(language){
			case "En":
				answer+="Thank you for your advices/messages, reply will be sent ASAP." ;
				break;
			default:
				answer+="已收到您的留言，我們將盡快為您服務!" ;
				break;
		}
		return answer;
	}
	
	public static String badPost(String language){
		String answer="";
		switch(language){
			case "En":
				answer+="Data Error:please resubmit." ;
				break;
			default:
				answer+="資料操作錯誤，請重新送出" ;
				break;
		}
		return answer;
	}
	
	public static String wrongPost(String language){
		String answer="";
		switch(language){
			case "En":
				answer+="Recaptcha Error:please refresh." ;
				break;
			default:
				answer+="驗證碼錯誤，請刷新" ;
				break;
		}
		return answer;
	}
	
	public static String[] titles(String language){
		String answer[]=new String[]{};
		switch(language){
			case "En":
				answer=new String[]{
						"Products",
						"Stocks",
						"Advices",
						"Others"
						};
				break;
			default:
				answer=new String[]{
						"產品服務",
						"股務服務",
						"建議事項",
						"其他"
						};
				break;
		}
		return answer;
	}
	
	public static String tablePost(String language){
		String answer="";
		switch(language){
			case "En":
				answer="If you are instrested in our company, you can send your message by the following form. '*' is necessary.";
				break;
			default:
				answer="若有任何指教，可以留言給我們，'*'欄位為必填項目。";
				break;
		}
		return answer;
	}
	
	public static String tablePost_1(String language){
		String answer="";
		switch(language){
			case "En":
				answer="Choose a type:";
				break;
			default:
				answer="意見類別";
				break;
		}
		return answer;
	}
	
	public static String[] bugs(String language){
		String answer[]=new String[]{};
		switch(language){
			case "En":
				answer=new String[]{
						"【Can't submit without select】",
						"【Can't submit without name】",
						"【Can't submit without a phone】",
						"【Incorrect format.】",
						"【Can't submit empty text】",
						"【Can't submit without Recaptcha】" 
						};
				break;
			default:
				answer=new String[]{
						"【請點選意見類別】",
						"【請輸入姓名】",
						"【請留下連絡電話或手機】",
						"【不正確的格式】",
						"【請輸入內容】",
						"【請輸入驗證碼】" 
						};
				break;
		}
		return answer;
	}
	
	public static String[] subTitles(String language){
		String answer[]=new String[]{};
		switch(language){
			case "En":
				answer=new String[]{
						"Name:",
						"Male",
						"Female",
						"Telphone:",
						"Cell phone:",
						"Advices/Messages:",
						"Recaptcha:",
						"Refresh",
						"Larger",
						"Recaptcha:",
						"submit"  
						};
				break;
			default:
				answer=new String[]{
						"姓名:",
						"先生",
						"小姐",
						"聯絡電話:",
						"手機:",
						"意見內容:",
						"辨識碼:",
						"刷新",
						"放大",
						"辨識碼:",
						"發表留言"  
						};
				break;
		}
		return answer;
	}
	

}
