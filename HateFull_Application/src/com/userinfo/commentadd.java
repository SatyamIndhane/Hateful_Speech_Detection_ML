package com.userinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.Dbconn;

/**
 * Servlet implementation class commentadd
 */
@WebServlet("/commentadd")
public class commentadd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public commentadd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<String> listdata=new ArrayList<>();
			HttpSession session = request.getSession(false);
			String id = (String) session.getAttribute("user_id");
			String emailid=(String)session.getAttribute("emailid");
			String commentdata = request.getParameter("comment1");
			String commentdata1 = request.getParameter("comment2");
			String commentdata2 = request.getParameter("comment3");
			String commentdata3 = request.getParameter("comment4");
			String commentdata4 = request.getParameter("comment5");
			
			if(commentdata.isEmpty()||commentdata.equals("")||commentdata.equals("null"))
			{
				System.out.println("1"+commentdata);
			}
			else
			{
				listdata.add(commentdata);
			}
			if(commentdata1.isEmpty()||commentdata1.equals("")||commentdata1.equals("null"))
			{
				System.out.println("2"+commentdata);
			}
			else
			{
				listdata.add(commentdata1);
			}
			if(commentdata2.isEmpty()||commentdata2.equals("")||commentdata2.equals("null"))
			{
				System.out.println("3"+commentdata);
			}
			else
			{
				listdata.add(commentdata2);
			}
			if(commentdata3.isEmpty()||commentdata3.equals("")||commentdata3.equals("null"))
			{
				System.out.println("4"+commentdata);
			}
			else
			{
				listdata.add(commentdata3);
			}
			
			if(commentdata4.isEmpty()||commentdata4.equals("")||commentdata4.equals("null"))
			{
				System.out.println("5"+commentdata);
			}
			else
			{
				listdata.add(commentdata4);
			}
			
			
			Connection conn = Dbconn.conn();
			Statement st = conn.createStatement();
			for(int i=0;i<listdata.size();i++)
			{
			st.executeUpdate("insert into testingdata(username,tweet_comment,User_ID) values('"
					+ emailid + "','" + listdata.get(i) + "','" + id + "')");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Add Comment successfully');");
		out.println("</script>");
		RequestDispatcher rd = request.getRequestDispatcher("/MyprofilePage.jsp");
		rd.include(request, response);
	}

}
