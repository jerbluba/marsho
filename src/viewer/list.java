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

import manager.fileEditor;

/**
 * Servlet implementation class list
 */
@WebServlet(name="Viewer1", urlPatterns={"/Viewer1"},loadOnStartup=1)
public class list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public list() {
        super();
        // TODO Auto-generated constructor stub
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
		
		String x=request.getParameter("x");
		String y=request.getParameter("y");
		String z=request.getParameter("z");
		String type=request.getParameter("type");
		
		String answer="";
		HashMap<String,HashMap<Integer,String>> menu=manager.fileEditor.getMenus();
		
		java.sql.Connection con = null;
        java.sql.PreparedStatement ps = null;
        try {
        	String sql = "select name, picName,comment from henry where x='"+x+"' and y='"+y+"' and z='"+z+"' and type='"+type+"'";
            con = manager.DataSource.getConnection(menu);
            ps = con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery(sql);
            
            answer+="<table id=list>";
            while(rs.next()){
// 
            	 answer+="<tr><td>"+rs.getString("name")+"</td><td>"+rs.getString("picName")+"</td><td>"+rs.getString("comment")+"</td></tr>";
             	
            }
            answer+="</table>";
           
        } catch (java.sql.SQLException e) {
           
            e.printStackTrace();
        }
		
		
		out.println(
				viewer.basic.combineContent(
						
						fileEditor.getMenus(),""
						));
		out.close();
		
		
	}

}
