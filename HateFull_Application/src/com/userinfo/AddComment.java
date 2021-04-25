package com.userinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.Dbconn;

/**
 * Servlet implementation class AddComment
 */
@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			  String id=(String)session.getAttribute("user_id");
			           String username=request.getParameter("txt_Uname");
			           String commentdata=request.getParameter("comment");
			              Connection conn = Dbconn.conn();
			              Statement st= conn.createStatement();
			               st.executeUpdate("insert into testingdata(username,tweet_comment,User_ID) values('"+username+"','"+commentdata+"','"+id+"')");
			            
			        } catch (Exception ex) {
			            System.out.println(ex);
			        }
		PrintWriter out=response.getWriter();
		out.println("<script type=\"text/javascript\">");  
		out.println("alert('Add Comment successfully');");  
		out.println("</script>");
		RequestDispatcher rd = request.getRequestDispatcher("/AddComment.jsp");
		rd.include(request, response);
	}

}
