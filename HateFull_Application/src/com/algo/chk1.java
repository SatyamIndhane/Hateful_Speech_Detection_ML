/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.algo;

import com.connection.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.poi.hssf.record.formula.functions.IsNa;

public class chk1 {


	public static ArrayList<String> nblistacc=new ArrayList<>();
	public static ArrayList<String> nblistpre=new ArrayList<>();
	public static ArrayList<String> nblistrecall=new ArrayList<>();
	public static ArrayList<String> nblistfscore=new ArrayList<>();
	
	public static ArrayList<String> SVMlistacc=new ArrayList<>();
	public static ArrayList<String> SVMlistpre=new ArrayList<>();
	public static ArrayList<String> SVMlistrecall=new ArrayList<>();
	public static ArrayList<String> SVMlistscore=new ArrayList<>();
	
	public static ArrayList<String> DTlistacc=new ArrayList<>();
	public static ArrayList<String> DTlistpre=new ArrayList<>();
	public static ArrayList<String> DTlistrecall=new ArrayList<>();
	public static ArrayList<String> DTlistscore=new ArrayList<>();
	
	public static ArrayList<String> acclist=new ArrayList<>();
	public static ArrayList<String> timelist=new ArrayList<>();
	
	public static void timeinfo()
	{
		
		timelist.clear();
		Connection con;
		try {
			con = Dbconn.conn();
		
        Statement st = con.createStatement();
        ResultSet rs=st.executeQuery("select * from tbltime");
        if(rs.next())
        {
        	timelist.add(rs.getString("NB_Time"));
        	timelist.add(rs.getString("DT_Time"));
        	timelist.add(rs.getString("SVM_Time"));
        	
        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		br();
	}

	// public static int normal=(int) (Math.random() * (20 - 1) + 1);

	public static void br() throws IOException {
		double NBTP = 0.0;
		 double NBFN = 0.0;
		 double NBFP = 0.0;
		 double NBTN = 0.0;
		 double SVMTP = 0.0;
		 double SVMFN = 0.0;
		 double SVMFP = 0.0;
		 double SVMTN = 0.0;
		 int flag=0;
		 double DTTP = 0.0;
		 double DTFN = 0.0;
		double DTFP = 0.0;
		double DTTN = 0.0;

		double TotalA = 0;
		double TotalB = 0;
		double TotalC = 0;
		try {
			acclist.clear();
			nblistacc.clear();
			SVMlistacc.clear();
			DTlistacc.clear();
			Dbconn db = new Dbconn();
			Connection con = db.conn();
			Statement st = con.createStatement();
			st.executeQuery("select * from nlptest");
			ResultSet rs1 = st.getResultSet();
			if(rs1.next())
			{
				st.executeQuery("select * from nlptest");
				ResultSet rs = st.getResultSet();
			while (rs.next()) {
				String Acutal = rs.getString("ClassifyLabel");
				String NB = rs.getString("nbclass").replaceAll("\\s+", "");
				String SVM = rs.getString("svmclass").replaceAll("\\s+", "");
				String DT = rs.getString("dtclass").replaceAll("\\s+", "");
				if (Acutal.equalsIgnoreCase("Hatefull")) {
					TotalA = TotalA + 1;
					if (NB.equalsIgnoreCase("Hatefull")) {
						NBTP = NBTP + 1;
					} else if (NB.equalsIgnoreCase("Offensive")
							|| NB.equalsIgnoreCase("Clear") || NB.isEmpty()) {
						NBFN = NBFN + 1;
					}

					if (SVM.equalsIgnoreCase("Hatefull")) {
						SVMTP = SVMTP + 1;
					} else if (SVM.equalsIgnoreCase("Offensive")
							|| SVM.equalsIgnoreCase("Clear") || SVM.isEmpty()) {
						SVMFN = SVMFN + 1;
					}
					if (DT.equalsIgnoreCase("Hatefull")) {
						DTTP = DTTP + 1;
					} else if (DT.equalsIgnoreCase("Offensive")
							|| DT.equalsIgnoreCase("Clear") || DT.isEmpty()) {
						DTFN = DTFN + 1;
					}
				}

				else if (Acutal.equalsIgnoreCase("Clear")) {
					TotalB = TotalB + 1;

					if (NB.equalsIgnoreCase("Clear")) {
						NBTN++;
					} else if (NB.equalsIgnoreCase("Hatefull")
							|| NB.equalsIgnoreCase("Offensive") || NB.isEmpty()) {
						NBFP++;
					}
					if (SVM.equalsIgnoreCase("Clear")) {
						SVMTN++;
					} else if (SVM.equalsIgnoreCase("Hatefull")
							|| SVM.equalsIgnoreCase("Offensive") || SVM.isEmpty()) {
						SVMFP++;
					}
					if (DT.equalsIgnoreCase("Clear")) {
						DTTN++;
					} else if (DT.equalsIgnoreCase("Hatefull")
							|| DT.equalsIgnoreCase("Offensive") || DT.isEmpty()) {
						DTFP++;
					}
				}

				else if (Acutal.equalsIgnoreCase("Offensive")) {
					TotalC = TotalC + 1;
					if (NB.equalsIgnoreCase("Offensive")) {
						NBTP++;
					} else if (NB.equalsIgnoreCase("Hatefull")
							|| NB.equalsIgnoreCase("Clear") || NB.isEmpty()) {
						NBFN++;
					}

					if (SVM.equalsIgnoreCase("Offensive")) {
						SVMTP++;
					} else if (SVM.equalsIgnoreCase("Hatefull")
							|| SVM.equalsIgnoreCase("Clear") || SVM.isEmpty()) {
						SVMFN++;
					}
					if (DT.equalsIgnoreCase("Offensive")) {
						DTTP++;
					} else if (DT.equalsIgnoreCase("Hatefull")
							|| DT.equalsIgnoreCase("Clear") || DT.isEmpty()) {
						DTFN++;
					}

				}

			}
			flag=1;
			}
			else{
				flag=0;
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
//		System.out.println("***************");
//		System.out.println("Total Hatefull" + TotalA);
//		System.out.println("Total Offensive" + TotalB);
//		System.out.println("Total Clear" + TotalC);
//
//		System.out.println("NB TP \t" + NBTP);
//		System.out.println("NB FN \t" + NBFN);
//		System.out.println("NB TN \t" + NBTN);
//		System.out.println("NB FP \t" + NBFP);
//		System.out.println("***************");
//		System.out.println("SVM TP \t" + SVMTP);
//		System.out.println("SVM FN \t" + SVMFN);
//		System.out.println("SVM TN \t" + SVMTN);
//		System.out.println("SVM FP \t" + SVMFP);
//		System.out.println("***************");
//		System.out.println("DT TP \t" + DTTP);
//		System.out.println("DT FN \t" + DTFN);
//		System.out.println("DT TN\t" + DTTN);
//		System.out.println("DT FP \t" + DTFP);
		System.out.println("***************");
		
		double NBAccuracy= (double)(NBTP+NBTN) /(TotalA+TotalB+TotalC);
		double n=(NBTP + NBFP);
		System.out.println(n);
        double NBPrecision=(double) NBTP / n;
        double NBRecall= (double)NBTP / (NBTP + NBFN);
        double nrpr=(double)2*(NBPrecision*NBRecall);
        double NBFscore= (double)nrpr /NBPrecision+NBRecall;
        System.out.println("NBAccuracy=>"+NBAccuracy);
        //nblistacc.add(String.valueOf(NBAccuracy)+","+String.valueOf(NBPrecision)+","+String.valueOf(NBRecall)+","+String.valueOf(NBFscore));
       
        double SVMAccuracy = (double)(SVMTP+SVMTN) /(TotalA+TotalB+TotalC);
        double SVMPrecision=(double) SVMTP / (SVMTP + SVMFP);
        double SVMRecall= (double)SVMTP / (SVMTP + SVMFN);
        double pr=(double)2*(SVMPrecision*SVMRecall);
        double SVMFscore=(double) pr /(SVMPrecision+SVMRecall);
        System.out.println("SVMAccuracy=>"+SVMAccuracy);
       // SVMlistacc.add(String.valueOf(SVMAccuracy)+","+String.valueOf(SVMPrecision)+","+String.valueOf(SVMRecall)+","+String.valueOf(SVMFscore));
          double DTAccuracy=(double) (DTTP+DTTN) / (TotalA+TotalB+TotalC);
        double DTPrecision=(double) DTTP / (DTTP + DTFP);
        double DTRecall=(double) DTTP / (DTTP + DTFN);
        double dtpr=(double)2*(DTPrecision*DTRecall);
        double DTFscore=(double)dtpr /DTPrecision+DTRecall;
        System.out.println("DTAccuracy=>"+DTAccuracy);
        //DTlistacc.add(String.valueOf(DTAccuracy)+","+String.valueOf(DTPrecision)+","+String.valueOf(DTRecall)+","+String.valueOf(DTFscore));
       
        if(flag==0)
        {
        	acclist.add("0.1"); 
        	acclist.add("0.1"); 
        	acclist.add("0.1"); 
        }
        
        else
        {
        	 acclist.add(String.valueOf(NBAccuracy));
        	 acclist.add(String.valueOf(SVMAccuracy));     
        	 acclist.add(String.valueOf(DTAccuracy)); 
             
        }
        
	}

}
