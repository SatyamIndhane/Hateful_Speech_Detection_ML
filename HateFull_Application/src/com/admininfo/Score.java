package com.admininfo;

import java.io.*;
import java.sql.*;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.Dbconn;

/**
 * Servlet implementation class Score
 */
@WebServlet("/Score")
public class Score extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Score() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            Dbconn db= new Dbconn();
            Connection con= db.conn();
            double record=0.0;
           TreeSet<String> list1 = new TreeSet<String>();
            Statement st= con.createStatement();
            Statement st1 = con.createStatement();
            ResultSet rs1=(ResultSet) st.executeQuery("select * from nlptest");
            while(rs1.next())
            {
                list1.add(rs1.getString("username"));
                record++;
            }
            Statement st5= con.createStatement();
                int id=1;
                for (String temp : list1) {
                 double total=0.0;
                 double svmtotal=0.0,dttotal=0.0;
                    System.out.println("Email ID"+temp);
            ResultSet rs=(ResultSet) st5.executeQuery("select * from nlptest where Username='"+temp+"'");
            while(rs.next())
            {
                
                double score=rs.getDouble("Score_NB");
                total=total+score;
                
                double svmscore=rs.getDouble("Score_SVM");
                
                svmtotal=svmtotal+svmscore;
                
                double dtscore=rs.getDouble("Score_DT");
                dttotal=dttotal+dtscore;
                id=rs.getInt("Comment_ID");
                
           
            
           }
            
            double finaltotal=(double)total+svmtotal+dttotal;
            double sum=(double)finaltotal/record;
            System.out.println(sum+"Nb"+total+"SVM"+svmtotal+"DT"+dttotal);
            String lable="";
          if(sum>=0.70)
          {
        	  lable="Block";
        	  
              
              st1.executeUpdate("update  userdetail set status_msg='"+lable+"' where userid='"+temp+"'");
              System.out.println("Score=>"+sum+"\t Lable=>"+lable);
          }
          else
          {
        	  lable="0";
        	  System.out.println("Score=>"+sum+"\t Lable=>"+lable);
          }
                    
                }
            con.close();
        } catch (SQLException ex) {
            
        } catch (ClassNotFoundException ex) {
            
        } catch (Exception ex) {
            
        }
		PrintWriter out=response.getWriter();
		out.println("<script type=\"text/javascript\">");  
		out.println("alert('Block Process Successfully');");  
		out.println("</script>");
		RequestDispatcher rd = request.getRequestDispatcher("/ShowScore.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
