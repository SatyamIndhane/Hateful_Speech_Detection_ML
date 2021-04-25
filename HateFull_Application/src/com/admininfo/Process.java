package com.admininfo;

import java.io.*;
import java.sql.*;
import java.util.*;
import libsvm.LibSVM;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algo.NB;
import com.algo.NBold;
import com.algo.document_distance;
import com.connection.Dbconn;

/**
 * Servlet implementation class Process
 */
@WebServlet("/Process")
public class Process extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static double th =0.40;
   
    public Process() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ArrayList<String> GetTrainList()
    {
    	 ArrayList TrainList = new ArrayList();
         try {
            Dbconn db = new Dbconn();
             Connection con = db.conn();
             Statement st = con.createStatement();
             st.executeQuery("select * from nlptrain");
             ResultSet rs1 = st.getResultSet();
             while (rs1.next()) {
                 String Datapart1 = rs1.getString("stemmer");
                 String Datapart2 = rs1.getString("ClassLabel");
                 TrainList.add(Datapart1 + "#" + Datapart2);
             }
         } catch (Exception ex) {
         }
         return TrainList;
    } 
    public ArrayList GetTestList() {
        ArrayList TestList = new ArrayList();

        try {
            Dbconn db = new Dbconn();
            Connection con = null;
            con = Dbconn.conn();
            Statement stat = (Statement) con.createStatement();
            stat.executeQuery("select * from nlptest");
            ResultSet rs = stat.getResultSet();
            while (rs.next()) {
                String Datapart1 = rs.getString("id");
                String Datapart2 = rs.getString("stemmer");
                String Datapart3 = rs.getString("ClassifyLabel");
                TestList.add(Datapart1 + "#" + Datapart2+ "#" + Datapart3);
            }
        } catch (Exception ex) {
        	System.out.println(ex);
        }
        return TestList;
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ArrayList<String> TrainingSet =new ArrayList<>();
		 ArrayList<String> TestingSet = new ArrayList<>();
		
	       TrainingSet = GetTrainList();
	       TestingSet = GetTestList();
	       try{
	             String lable=null;
	            Connection con=Dbconn.conn();
	            Statement st = con.createStatement();
	            Statement st1 = con.createStatement();
	            Statement st2 = con.createStatement();
	            st.executeQuery("select * from nlptest");
	            ResultSet rs1 = st.getResultSet();
	            ResultSet rs2;
	            long nbstarttime=System.currentTimeMillis();
	             while (rs1.next()) {
	                 String Comment_ID=rs1.getString("id");
	                 int id=rs1.getInt("id");
	                 //String Currentsuer=rs1.getString("username");
	               String Datapart1= rs1.getString("stemmer");
	               String Tpost = rs1.getString("twittedpost");
	               NB objNB = new NB();
                   double weightHate = objNB.findHateful(Datapart1, TrainingSet);
                   double weightOff = objNB.FindOffensive(Datapart1, TrainingSet);
                   System.out.println("Post" + Tpost);
                   System.out.println("Hate" + weightHate);
                   System.out.println("Off" + weightOff);
                   int flag = 0;
                   double th = 0.040;
                   if (weightHate >= th) {
                       flag = 1;
                   } else if (weightOff > th) {
                       flag = 2;
                   } else {
                       flag = 3;
                   }
                   
                   if (flag == 1) {
                       String DesiredClass = "Hateful";
                       System.out.println("Current Tweet is" + Tpost + "and Class is \t" + DesiredClass);
                       Statement st11 = con.createStatement();
                       st11.executeUpdate("update nlptest set nbclass='" + DesiredClass + "',Score_NB='"+weightHate+"' where id ='" + Comment_ID + "'");
                   }
                   if (flag == 2) {
                       String DesiredClass = "Offensive";
                       System.out.println("Current Tweet is" + Tpost + "and Class is \t" + DesiredClass);
                       Statement st12 = con.createStatement();
                       st12.executeUpdate("update nlptest set nbclass='" + DesiredClass + "',Score_NB='"+weightOff+"' where id ='" + Comment_ID + "'");
                   }
                   if (flag == 3) {
                	   
                       String DesiredClass = "Clear";
                       System.out.println("Current Tweet is" + Tpost + "and Class is \t" + DesiredClass);
                       Statement st13 = con.createStatement();
                       st13.executeUpdate("update nlptest set nbclass='" + DesiredClass + "',Score_NB='0.0' where id ='" + Comment_ID + "'");
                   }
	                  
	               
	               
	            }//while loop
	             long nbendtime=System.currentTimeMillis();
	             long nbtotaltime=nbendtime-nbstarttime;
	             
	             
	             long dtstarttime=System.currentTimeMillis();
	           //DT
	               for(int startpoint =0; startpoint < TestingSet.size(); startpoint++)
	                {
	                    String[] parts1 = TestingSet.get(startpoint).toString().split("#");
	                    System.out.println(TestingSet);
	                    for(int midpint=0; midpint < TrainingSet.size(); midpint++)
	                    {
	                        String[] parts2 = TrainingSet.get(midpint).toString().split("#");
	                        double weight =document_distance.CalculateDistance(parts1[1], parts2[0]);
	                        System.out.println(weight);
	                        if(weight >= th)
	                        {
	                            try {
	                                System.out.println(parts2[1]);
	                                Statement st14 = con.createStatement();
	                                st14.executeUpdate("update nlptest set dtclass='" + parts2[1] + "',Score_DT='"+weight+"' where id ='" + parts1[0] + "'");
	                                break;
	                            } catch (SQLException ex) 
	                            {
	                            	System.out.println(ex);
	                                  }
	                        }
	                    }
	                }
	               long dtendtime=System.currentTimeMillis();
		             long dttotaltime=dtendtime-dtstarttime;
		             
		             long svmstarttime=System.currentTimeMillis();
	               //svm
	               for(int startpoint =0; startpoint < TestingSet.size(); startpoint++)
	                {
	                    String[] parts1 = TestingSet.get(startpoint).toString().split("#");
	                    
	                    for(int midpint=0; midpint < TrainingSet.size(); midpint++)
	                    {
	                        String[] parts2 = TrainingSet.get(midpint).toString().split("#");
	                        //LibSVM svm=new LibSVM();
	                        LibSVM svm=new LibSVM();
	                        svm.buildClassifier(TrainingSet);
	                        svm.crossValidation(10);
	                        double distance= svm.classifyInstance(parts1[1], TrainingSet);
	                        //System.out.println(weight);
	                        if(distance >= th)
	                        {
	                            try {
	                                System.out.println(parts2[1]);
	                                Statement st15 = con.createStatement();
	                                st15.executeUpdate("update nlptest set svmclass='" + parts1[2] + "',Score_SVM='"+distance+"' where id ='" + parts1[0] + "'");
	                                break;
	                            } catch (SQLException ex) {
	                                 }
	                        }
	                    }
	                } 
	               long svmendtime=System.currentTimeMillis();
		             long svmtotaltime=svmendtime-svmstarttime;
	             
	             Statement st01=con.createStatement();
	             st01.executeUpdate("update tbltime set NB_Time='"+nbtotaltime+"',DT_Time='"+dttotaltime+"',SVM_Time='"+svmtotaltime+"'");
	             
	        } 
	catch(Exception ex)
	{        
	    System.out.println(ex);
	}      
//	        JOptionPane.showMessageDialog(rootPane, "NB Execution Completed");
	       PrintWriter out=response.getWriter();
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Classification Successfully');");  
			out.println("</script>");
	       RequestDispatcher rd = request.getRequestDispatcher("/Classification.jsp");
			rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
