package com.userinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.connection.Dbconn;

/**
 * Servlet implementation class doLogin
 */
@WebServlet("/doLogin")
public class doLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public doLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.invalidate();
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("alert('You are successfully logged out!');");
		out.println("</script>");
		request.getRequestDispatcher("index.jsp").include(request, response);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession(false);
		String uname = request.getParameter("txt_Uname");
		String password = request.getParameter("txt_Password");
		
		System.out.println("EmailId=>"+uname+"\t Password=>"+password);
	
			try {
				Connection con = (Connection) Dbconn.conn();
				Statement st = (Statement) con.createStatement();
				ResultSet rs = (ResultSet) st
						.executeQuery("select * from userdetail where userid='"
								+ uname + "' and password='" + password + "'");
				if (rs.next()) {
					if (rs.getString("status_msg").equalsIgnoreCase("Block")) {
						pw.println("<script> alert('Your Email ID Block');</script>");

					} else {
						session.setAttribute("emailid", uname);
						session.setAttribute("user_id", rs.getString("ID"));
						pw.println("<script> alert('Login Successfuly');</script>");

						RequestDispatcher rd = request
								.getRequestDispatcher("/MyprofilePage.jsp");
						rd.include(request, response);
					}
				} else {
					pw.println("<script> alert('Enter Email_Id or password correctly');</script>");
					RequestDispatcher rd = request
							.getRequestDispatcher("/index.jsp");
					rd.include(request, response);
				}

			} catch (Exception e) {
				System.out.println(e);
			}
		
	}

}
