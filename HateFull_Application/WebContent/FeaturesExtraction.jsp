<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ page import="java.sql.*" %>
    <%@ page import="com.connection.Dbconn" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>SocialNet</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/arial.js"></script>
<script type="text/javascript" src="js/cuf_run.js"></script>
</head>
<body>
<div class="main">
  <div class="main_resize">
    <div class="header">
      <div class="logo">
        <h1><a href="#"><span>Social</span>Net<small>Simple web template</small></a></h1>
      </div>
      <div class="search">
        
        <!--/searchform -->
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
      <div class="menu_nav">
        <ul>
        
          <li><a href="UploadDataset.jsp">Upload DataSet</a></li>
          <li><a href="FeaturesExtraction">Features Extraction</a></li>
         <li><a href="Classification.jsp">Classification</a></li>
           <li><a href="Score">Show Score</a></li>
             <li><a href="AnalysisPage.jsp">Analysis</a></li>
            <li><a href="doLogin">LogOut</a></li>
         
        </ul>
        <div class="clr"></div>
      </div>
      <div class="hbg"><img src="images/header_images.jpg" width="923" height="291" alt="" /></div>
    </div>
     <div >
      <div >
        <div >
          <div>
            <h2 style="text-align:center"><b><span>Features Extraction</span></b></h2>
            
            <form role="form" action="doLogin" method="post">
			<div  >
			

				
                <%

			Connection con = Dbconn.conn();
                Statement stat1 = con.createStatement();
				String qrry1 = "select * from nlptest ";
				ResultSet rs1= stat1.executeQuery(qrry1);
				while (rs1.next())
				 {

                %>
                <hr>
                <p><label style="color: red;">Twitted Post=></label><%=rs1.getString(3) %></p>
                
                <p><label style="color: red;">Stopword=></label> <%= rs1.getString(4) %></p>
                 
                <p><label style="color: red;">Stemmer=></label> <%= rs1.getString(5) %></p>
                </hr>
					<%} %>
			
			</div>
			</form> 
            
            
             </div>
       
        <div class="clr"></div>
      </div>
    </div>
  </div>
  <div class="fbg">
    <div class="fbg_resize">
      
    </div>
  </div>
</div>
<div class="footer">
  
</div>
</body>
   </html>