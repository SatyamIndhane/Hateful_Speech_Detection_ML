package com.admininfo;

import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Preprocess.RemoveStopwords;
import Preprocess.Stemmer;

import com.connection.Dbconn;

/**
 * Servlet implementation class FeaturesExtraction
 */
@WebServlet("/FeaturesExtraction")
public class FeaturesExtraction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeaturesExtraction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            //StringBuilder sb = new StringBuilder();
            //RemoveStopwords rm = new RemoveStopwords();
            double score;
            Connection con = Dbconn.conn();
            String username;
           // int i = 0;
            Statement stat = (Statement) con.createStatement();
            stat.executeQuery("TRUNCATE table nlptest");
            Statement st = con.createStatement();
            st.executeQuery("select * from testingdata");
            ResultSet rs1 = st.getResultSet();
            String  tweentpost = null;
            // ***********************************************************************
            Preprocess.RemoveStopwords r = new RemoveStopwords();
            Stemmer ss = new Stemmer();
            while (rs1.next()) {
                String id= rs1.getString("id");
                username = rs1.getString("username");
                tweentpost = rs1.getString("tweet_comment");
                String Afterremoval = r.RemoveWords(tweentpost);

                /// Stemming process*****************************************************
                String fname = Dbconn.finalpath + "input.txt";
                Writer writer = null;
                writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fname), "utf-8"));
            writer.write(Afterremoval); // After Stopword
            writer.close();
            String afterstemmer = ss.GetData(fname); // After Stemming
            double Strlength;
            String[] NLPData = afterstemmer.split(",");
            System.out.println(NLPData.length);
            if(NLPData.length==1)
            {
            	Strlength = 1;
            }
            else
            {
            	Strlength = NLPData.length-1;
            }
          
           double hatefulLength= RemoveStopwords.hatefultopics(tweentpost);
           double OffensiveLength =RemoveStopwords.Offensivetopics(tweentpost);
             double hateweight=hatefulLength / Strlength;
             double Offensiveweight=OffensiveLength / Strlength;
              String classlabel="";
             // System.out.println("Hatefull="+hateweight+"Offiensive=>"+Offensiveweight);
              //**********************************************
          if(hateweight > Offensiveweight)
          	{
          	classlabel="Hatefull";
          	
          	}
          else if(Offensiveweight > hateweight)
          	{
          	classlabel="Offensive";
          	}
          else
          	{
          	classlabel="Clear";
          	}
          System.out.println("TwitterPost=>\t"+tweentpost);
          System.out.println("Stopword=>\t"+Afterremoval);
          System.out.println("Stemmer=>\t"+afterstemmer);
          
            String sql1 = "insert into nlptest(username,twittedpost,stopword,stemmer,ClassifyLabel,Comment_ID) values (?,?,?,?,?,?)";

            PreparedStatement pdt1 = con.prepareStatement(sql1);
            pdt1.setString(1, username);
            pdt1.setString(2, String.valueOf(tweentpost));
            pdt1.setString(3, String.valueOf(Afterremoval));
            pdt1.setString(4, String.valueOf(afterstemmer));
            pdt1.setString(5, String.valueOf(classlabel));
            pdt1.setString(6, String.valueOf(id));
            int n = pdt1.executeUpdate();
            
            
            

        }// while loop end
         } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println(ex);
        }
		PrintWriter out=response.getWriter();
		out.println("<script type=\"text/javascript\">");  
		out.println("alert('Features Extraction Successfully');");  
		out.println("</script>");
		RequestDispatcher rd = request.getRequestDispatcher("/FeaturesExtraction.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
