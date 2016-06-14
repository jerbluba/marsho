package manager;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import viewer.basic;

public class tableMaker {
	public static String generalTable(String page,HashMap<String,HashMap<Integer,String>> pages){
		String answer="";
		
		HashMap<String,String> table=new HashMap<String,String>();
		
		table.put("labelName", "table");
		table.put("class", "main-table");
		table.put("id", "table0");
		table.put("content", fileEditor.readExcel(page.replace("page", ""), pages, 0)+viewer.abgne.abgne(pages,Integer.parseInt(pages.get(page).get(2))));				
		
		answer+=basic.others(table);
		return answer;
	}
public static String indexTable(String page,HashMap<String,HashMap<Integer,String>> pages) throws IOException{
		
		String answer="";
		answer+="<table class='main-table' id='table0'><tr><td>"
				+ fileEditor.readExcel(page.replace("page", ""), pages, 0)
				+ "</td></tr></table>"
				;
		
		
		return answer;
	}
	public static String multiTable(String page,HashMap<String,HashMap<Integer,String>> pages) throws IOException{
		
		String answer="";
		HashMap<Integer,HashMap<String,String>> table=new HashMap<Integer,HashMap<String,String>>();
		for(int i=0;i<3;i++){
			table.put(i, new HashMap<String,String>());
			table.get(i).put("labelName", "table");
			table.get(i).put("class", "main-table");
			table.get(i).put("id", "table"+i);
			
			
			if(i<4){
				table.get(i).put("content", manager.fileEditor.readExcel(page.replace("page", "")+"_"+i,pages,i==0?0:1));
			}else{
				
//				table.get(i).put("content", 
//						manager.fileEditor.readExcel(
//								page.replace("page", "")+"_"+i
//								,pages
//								,0)
//						+viewer.abgne.abgne(pages,i-4)		
//						);				
			}
			answer+=basic.others(table.get(i));
		}
		
		return answer;
	}
	
public static String saleTable(String page,HashMap<String,HashMap<Integer,String>> pages) throws IOException{
		
		String answer="";
		HashMap<Integer,HashMap<String,String>> table=new HashMap<Integer,HashMap<String,String>>();
		for(int i=0;i<3;i++){
			table.put(i, new HashMap<String,String>());
			table.get(i).put("labelName", "table");
			table.get(i).put("class", "main-table");
			table.get(i).put("id", "table"+i);
			
			
			if(i<1){
				table.get(i).put("content", manager.fileEditor.readExcel(page.replace("page", "")+"_"+i,pages,0));
			}else{
				
				table.get(i).put("content", 
						manager.fileEditor.readExcel(
								page.replace("page", "")+"_"+i
								,pages
								,1)
						+viewer.abgne.abgne(pages,i+2)		
						);				
			}
			answer+=basic.others(table.get(i));
		}
		
		return answer;
	}
	
	
	public static String mainTable(String page,HashMap<String,HashMap<Integer,String>> pages) throws IOException{
		
		String answer=basic.others("table", manager.fileEditor.readExcel(page.replace("page", ""),pages,0));
		
		HashMap<Integer,HashMap<String,String>> table=new HashMap<Integer,HashMap<String,String>>();
		
		for(int i=3;i<7;i++){
			table.put(i, new HashMap<String,String>());
			table.get(i).put("labelName", "table");
			table.get(i).put("class", "main-table");
			table.get(i).put("id", "table"+i);
			table.get(i).put("content", viewer.abgne.abgne(pages,i));				
			
			answer+=basic.others(table.get(i));
		}
		
		return answer;
	}
	public static String goodList(String page,HashMap<String,HashMap<Integer,String>> pages){
		String answer="<table id=list>";
		HashMap<Integer,String> subTable=new HashMap<Integer,String>();
		
		answer+=manager.fileEditor.readExcel(page.replace("page", ""),pages,0);

		java.sql.Connection con = null;
        java.sql.PreparedStatement ps = null;
        String sql = "select * from product";
        try {
			con = manager.DataSource.getConnection(pages);
			ps = con.prepareStatement(sql);
	        ResultSet rs= ps.executeQuery(sql);
	        
	       
	        
	        int temp=0;
	        while(rs.next()){
	        	String value=		"<table>"
	        			+ "<tr><td>"+pages.get("productName").get(0)+"</td><td>"+rs.getString("productName")+"</td></tr>"
	        			+ "<tr><td>"+pages.get("productPrice").get(0)+"</td><td>"+rs.getString("productPrice")+"</td></tr>"
	        			+ "<tr><td>"+pages.get("productKilogram").get(0)+"</td><td>"+rs.getString("productKilogram")+"</td></tr>"
	        			+ "<tr><td>"+pages.get("productValue").get(0)+"</td><td>"+rs.getString("productwidth")+"*"+rs.getString("productdepth")+"*"+rs.getString("productheight")+"</td></tr>"
	        			+ "<tr><td rowspan=2 id='"+rs.getString("productid")+"'>"+pages.get("animation").get(0)+"</td></tr>"
    					+ "</table>";	 
	         	subTable.put(temp, value);
	     	   ++temp;
            }
	        
	        Close.Single(rs);
	        Close.Single(ps);
	        Close.Single(con);
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        for(int i=0;i<subTable.size();i++){
        	
        	if(i%2==0){
        		answer+="<tr><td>";
        		answer+=subTable.get(i);
        		answer+="</td>";
        		if(i==(subTable.size()-1)){
        			answer+="<td></td></tr>";       			
        		}
        	}else{
        		answer+="<td>";
        		answer+=subTable.get(i);
        		answer+="</td></tr>";
        	}
        	
        	
        }
        
        answer+="</table>";
		return answer+"<div id='showGood'></div>";		
	}
	
	
	private static String title="";
	public static String getTitle(){
		return title;
		
	}
	public static String boardList(int index,HashMap<String,HashMap<Integer,String>> pages){
		String answer="";
		
		java.sql.Connection con = null;
        java.sql.PreparedStatement ps = null;
        try {
        	 String sql = "select * from board where productid='000000000"+(index+1)+"'";
            con = manager.DataSource.getConnection(pages);
            ps = con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery(sql);
            
            answer+="<table id='list' class='"+index+"'>";
            
           
            
            answer+=fileEditor.readExcel("5", pages, 1);
            
            answer+="</table><table id='messages'><tr><td colspan='2'><div id='showBoard'>訪客訊息</div></td></tr>";
            ps = con.prepareStatement(sql);
            ResultSet rs2= ps.executeQuery(sql);
            int user=0;
            while(rs2.next()){
           	 answer+=
           			"<tr><td><div id='iconShow' class='iconShow"+rs2.getShort("icon")+"'></div>"
   					+ "</td><td rowspan=2><div id='commentShow' class='user"+user+"'>"+rs2.getString("comment")+"</div></td></tr>"
   					+"<tr><td><div id='nameShow' class='user"+user+"'>"+rs2.getString("name")+"</div></td></tr>"
   					 ;	
           	 ++user;
           }
            
            
            answer+="</table>";
            
            Close.Single(rs);
	        Close.Single(ps);
	        Close.Single(con);
        } catch (java.sql.SQLException e) {
           
            e.printStackTrace();
        }
        
        return answer;
	}
	public static String goodList(int index,HashMap<String,HashMap<Integer,String>> pages){
		String answer="";
		
		java.sql.Connection con = null;
        java.sql.PreparedStatement ps = null;
//        java.sql.PreparedStatement ps2 = null;
        try {
        	 String sql = "select * from product where productid='000000000"+(index+1)+"'";
//        	 String board = "select * from board where productid='000000000"+(index+1)+"'";
            con = manager.DataSource.getConnection(pages);
            ps = con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery(sql);
            
            answer+="<table id='list' class='"+index+"'>";
            
            while(rs.next()){
            	title=rs.getString("productName");
            	 answer+=
            			"<tr>"
            			+ "<td rowspan='3' id='leftProduct'>"
            			+ "<div id='mushroom' class='"+rs.getString("productid")+"'>"
            			+"<img src='larger/mush ("+(index+1)+").jpg' id='mushroomImg'>"
            					+ "</div>"
            					+ "</td><td><div id=textTitle>"+rs.getString("productName")+"</div></td></tr>"
    					
 	        			+ "<tr><td  id='rightProduct'><h5>"+rs.getString("productContent")+"</h5></td></tr>"     			
 	        			;	
            }
            
//            answer+=fileEditor.readExcel("5", pages, 1);
//            
//            answer+="</table><table id='messages'><tr><td colspan='2'><div id='showBoard'>訪客訊息</div></td></tr>";
//            ps2 = con.prepareStatement(board);
//            ResultSet rs2= ps.executeQuery(board);
//            int user=0;
//            while(rs2.next()){
//           	 answer+=
//           			"<tr><td><div id='iconShow' class='iconShow"+rs2.getShort("icon")+"'></div>"
//   					+ "</td><td rowspan=2><div id='commentShow' class='user"+user+"'>"+rs2.getString("comment")+"</div></td></tr>"
//   					+"<tr><td><div id='nameShow' class='user"+user+"'>"+rs2.getString("name")+"</div></td></tr>"
//   					 ;	
//           	 ++user;
//           }
            
            
            answer+="</table>";
            
            Close.Single(rs);
	        Close.Single(ps);
//	        Close.Single(rs2);
//	        Close.Single(ps2);
	        Close.Single(con);
        } catch (java.sql.SQLException e) {
           
            e.printStackTrace();
        }
        
        return answer;
		
	}
	
}
