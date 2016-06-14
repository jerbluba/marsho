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
@WebServlet(name="Viewer2", urlPatterns={"/Viewer2"},loadOnStartup=1)
public class table extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public table() {
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
		
		int index=Integer.parseInt(request.getParameter("index"));
		HashMap<String,HashMap<Integer,String>> pages=manager.fileEditor.getMenus();
		
		
		out.println(
				viewer.basic.combineContent(
						manager.tableMaker.goodList(index,pages),manager.tableMaker.getTitle(),"page2",new String[]{"list"},pages
						));
		out.close();
    }
}
