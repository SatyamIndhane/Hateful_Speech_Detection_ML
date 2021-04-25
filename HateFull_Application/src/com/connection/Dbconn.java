/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connection;


import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dbconn {
 
    public static String finalpath = "C:\\Users\\Satyam\\Desktop\\100%Project\\100%Project\\DataSet\\";
    public static String fold15filepath =finalpath+"fold15.txt";
    public static String filewordpath = finalpath + "searchword.txt";
    public static ArrayList<String> negativeword = new ArrayList<>();
    public static String onlinepath = finalpath + "OnlineData.txt";
     public static String file70path = finalpath + "FileData70%.txt";
public static String stopwordspath=finalpath+"stopwords.txt";
public static String hateful=finalpath+"hateful.txt";
public static String Offensive=finalpath+"Offensive.txt";
public static String temp=finalpath+"temp.txt";
public static String neg=finalpath+"neg.txt";
  
public static String user_Name=null;
public static String user_id=null;
    public Dbconn() throws SQLException {
        //initComponents();
        //Connection con;

    }

    public static Connection conn() throws Exception {
        Connection con;

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/pvg_new_hate_ful", "root", "admin");

        return (con);

    }

     
 }
