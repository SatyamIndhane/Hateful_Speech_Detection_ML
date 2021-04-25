package com.admininfo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Preprocess.RemoveStopwords;
import Preprocess.Stemmer;

import com.connection.Dbconn;

/**
 * Servlet implementation class uploadtraingdataset
 */
@WebServlet("/uploadtraingdataset")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class uploadtraingdataset extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public uploadtraingdataset() {
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
		Part filePart = request.getPart("txt_search");
		InputStream inputStream = null;
		try {
			inputStream = filePart.getInputStream();
			Connection con = Dbconn.conn();
			Statement stRegister = con.createStatement();
			
			stRegister.executeUpdate("TRUNCATE table nlptrain");
			String line;
			 Preprocess.RemoveStopwords r = new RemoveStopwords();
	            Stemmer ss = new Stemmer();
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			while ((line = br.readLine()) != null) {
				 String [] NLPData = line.split("####0");
				 String Afterremoval = r.RemoveWords(NLPData[0]);

	                /// Stemming process*****************************************************
	                String fname = Dbconn.finalpath + "input.txt";
	                Writer writer = null;
	                writer = new BufferedWriter(new OutputStreamWriter(
	                    new FileOutputStream(fname), "utf-8"));
	            writer.write(Afterremoval); // After Stopword
	            writer.close();
	            String afterstemmer = ss.GetData(fname); // After Stemming
	           
              
                
                
				
                String sql1 = "insert into nlptrain(twittedpost,stopword,stemmer,ClassLabel) values (?,?,?,?)";
                PreparedStatement pdt1 = con.prepareStatement(sql1);
                pdt1.setString(1, String.valueOf(NLPData[0].toString()));
                pdt1.setString(2, String.valueOf(Afterremoval));
                pdt1.setString(3, String.valueOf(afterstemmer));
                pdt1.setString(4, String.valueOf(NLPData[1]));
                pdt1.executeUpdate();
               System.out.println(NLPData[0]);
				 //st.executeUpdate("insert into trainingdata(Word_Data) values('" + line + "')");

			}// end while loop
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		PrintWriter out=response.getWriter();
		out.println("<script type=\"text/javascript\">");  
		out.println("alert('Upload Data Set Successfully');");  
		out.println("</script>");
		RequestDispatcher rd = request.getRequestDispatcher("/UploadDataset.jsp");
		rd.include(request, response);

	}

}
