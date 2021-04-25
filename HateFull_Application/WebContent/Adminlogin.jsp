<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
          
          <li class="active"><a href="Adminlogin.jsp">Admin Login</a></li>
          <li ><a href="index.jsp">User Login</a></li>
        </ul>
        <div class="clr"></div>
      </div>
      <div class="hbg"><img src="images/header_images.jpg" width="923" height="291" alt="" /></div>
    </div>
    <div >
      <div >
        <div >
          <div align="center">
            <h2><span>Login</span></h2>
            
            <form role="form" action="adminlogin" method="post">
			<div class="form-group" >
			<table style="font-size: 20px;" >
			
			<tr>
			<td></td>
			</tr>
	       <tr>
			<td class="col-md-2"><label for="txt_Uname">Email-ID:</label>&nbsp; &nbsp; &nbsp; &nbsp; </td>
		    <td class="col-md-6"><input type="text" class="form-control" name="txt_Uname" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required id="txt_Uname" placeholder="Enter Email-ID"></td>
		    </tr>
		<tr>
			<td>&nbsp;</td>
			</tr>
		    <tr>
			<td class="col-md-2"><label for="txt_Password">Password:</label></td>
			<td class="col-md-6"><input type="password" class="form-control" name="txt_Password" required id="txt_Password" placeholder="Enter Password"></td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			</tr>
			<tr>
			<td class="col-md-6" colspan="2" align="center" ><input type="submit" class="btn-primary" name="btn_Submit" id="btn_Submit" Value="Login"><br>
			</td>
			</tr>
			</table>
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