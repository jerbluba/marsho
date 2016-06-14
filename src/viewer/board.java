package viewer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.Close;
import manager.fileEditor;

/**
 * Servlet implementation class list
 */
@WebServlet(name="/page5.html", urlPatterns={"/page5.html"},loadOnStartup=1)
public class board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public board() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setLocale(Locale.TAIWAN);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		int index=0;//Integer.parseInt(request.getParameter("index"));
		HashMap<String,HashMap<Integer,String>> pages=manager.fileEditor.getMenus();
		
		
		out.println(
				viewer.basic.combineContent(pages, "page5"));
		out.close();
    }
    
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setLocale(Locale.TAIWAN);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String log="";
		int index=0;//Integer.parseInt(request.getParameter("index"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String comment=request.getParameter("comment");
		String tel=request.getParameter("tel");
		String icon=request.getParameter("icon");
		String captcha=request.getParameter("captcha");
		
		HashMap<String,HashMap<Integer,String>> pages=manager.fileEditor.getMenus();
		
		java.sql.Connection con = null;
        java.sql.PreparedStatement ps = null;
        
        if(!captcha.equals("true")){
        	log+=pages.get("wrong").get(0);
        }else{
        	request.setAttribute("captcha", "false");
        	try {
            	String sql = "insert into board(name,email,comment,productid,tel,icon) values(?,?,?,?,?,?)";
            	con = manager.DataSource.getConnection(pages);
                ps = con.prepareStatement(sql);
                
                int idx = 0;
                ps.setString(++idx, manager.StringTool.reFormat(name));
                ps.setString(++idx, manager.StringTool.reFormat(email));
                ps.setString(++idx, manager.StringTool.reFormat(comment));	              
                ps.setString(++idx, manager.StringTool.reFormat("000000000"+(index+1)));
                ps.setString(++idx, manager.StringTool.reFormat(tel));   
                ps.setString(++idx, manager.StringTool.reFormat(icon));  
                ps.executeUpdate();
                log+=pages.get("success").get(0);    

    	        Close.Single(ps);
    	        Close.Single(con);
            } catch (java.sql.SQLException e) {
               
                e.printStackTrace();
                log+=pages.get("fail").get(0); 
            }
        	
        	
        }
        
        
		
		
        out.println(
        		viewer.basic.combineContent(pages, "page5"));
				
		out.close();
		
		
	}

}
