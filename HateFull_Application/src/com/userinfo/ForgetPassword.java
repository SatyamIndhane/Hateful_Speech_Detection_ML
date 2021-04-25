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

import mail.SendMail;

import com.connection.Dbconn;

/**
 * Servlet implementation class ForgetPassword
 */
@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPassword() {
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
								+ uname + "'");
				if (rs.next()) {
					
					
					password=rs.getString("password");
					SendMail.Sendforgetpassword(uname,password);
						pw.println("<script> alert('Send Password Successfuly');</script>");

						RequestDispatcher rd = request
								.getRequestDispatcher("/index.jsp");
						rd.include(request, response);
					
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
