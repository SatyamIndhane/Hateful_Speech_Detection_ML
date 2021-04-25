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


import com.connection.Dbconn;

/**
 * Servlet implementation class dbRegister
 */
@WebServlet("/dbRegister")
public class dbRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public dbRegister() {
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
		PrintWriter pw = response.getWriter();
		String uname = request.getParameter("txt_Uname");
		String address = request.getParameter("txt_Address");
		String email = request.getParameter("txt_Email");
		String mobile = request.getParameter("txt_Number");
		String password = request.getParameter("txt_Password");
		try {
			Connection con = (Connection) Dbconn.conn();
			Statement st1 = (Statement) con.createStatement();
			Statement st2 = (Statement) con.createStatement();
			Statement st3 = (Statement) con.createStatement();
			String sqls = "SELECT * FROM userdetail WHERE userid ='" + email
					+ "'";
			ResultSet rs = st1.executeQuery(sqls);
			if (rs.next()) {

				pw.println("<script> alert('AllReady Email-ID Existing');</script>");
				RequestDispatcher rd = request
						.getRequestDispatcher("/register.jsp");
				rd.include(request, response);
			} else {
				String msg1="0";
				st2.executeUpdate("insert into userdetail(name,address,userid,mobile,password,status_msg) values('" + uname + "','"+address+"','" + email + "','" + mobile + "','" + password + "','"+msg1+"')");
				st3.executeUpdate("insert into tblclassify (Username,Class_Lable_NB,Class_Lable_SVM,Class_Lable_DT,Score_NB,Score_SVM,Score_DT) values('"+email+"','"+msg1+"','"+msg1+"','"+msg1+"','"+msg1+"','"+msg1+"','"+msg1+"')");
	               
				pw.println("<script> alert(' Register Successfuly');</script>");
				RequestDispatcher rd = request
						.getRequestDispatcher("/index.jsp");
				rd.include(request, response);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
