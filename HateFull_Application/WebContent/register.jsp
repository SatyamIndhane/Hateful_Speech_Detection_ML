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
         
          <li ><a href="index.jsp">Login</a></li>
          <li class="active"><a href="register.jsp">Register</a></li>
         
        </ul>
        <div class="clr"></div>
      </div>
      <div class="hbg"><img src="images/header_images.jpg" width="923" height="291" alt="" /></div>
    </div>
    <div >
      <div >
        <div >
          <div align="center">
            <h2><span>Register</span></h2>
            
            <form role="form" action="dbRegister" method="post">
			<div class="form-group">
			<table style="font-size: 20px;">
	       <tr>
			<td class="col-md-2"><label for="txt_Uname">User Name:</label>&nbsp;</td>
		    <td class="col-md-6"><input type="text" class="form-control" name="txt_Uname" id="txt_Uname" placeholder="Enter Name" required></td>
		    </tr>
		    <tr>
			<td>&nbsp;</td>
			</tr>
		    <tr>
		    <td class="col-md-2"><label for="txt_Address">Address:</label>&nbsp;</td>
		    <td class="col-md-6"><input type="text" class="form-control" name="txt_Address" id="txt_Address" placeholder="Enter Name" required></td>
		    </tr>
		    <tr>
			<td>&nbsp;</td>
			</tr>
		    <tr>
		    <td class="col-md-2"><label for="txt_Email">Email Id:</label>&nbsp;</td>
		    <td class="col-md-6"><input type="text" class="form-control" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" name="txt_Email" id="txt_Email" placeholder="Enter Name"required></td>
		    </tr>
		    <tr>
			<td>&nbsp;</td>
			</tr>
		    <tr>
		    <td class="col-md-2"><label for="txt_Number">Mobile No:</label>&nbsp;</td>
		    <td class="col-md-6"><input type="text" class="form-control" maxlength="10" pattern="[7-9]{1}[0-9]{9}" name="txt_Number" id="txt_Number" placeholder="Enter Mobile No" required></td>
		    </tr>
		<tr>
			<td>&nbsp;</td>
			</tr>
		    <tr>
			<td class="col-md-2"><label for="txt_Password">Password:</label>&nbsp;</td>
			<td class="col-md-6"><input type="password" class="form-control" name="txt_Password" id="txt_Password" pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{6,}$" placeholder="Enter Set Password"  required></td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			</tr>
			<tr>
			<td class="col-md-6" colspan="2" align="center" >
			<input type="submit" class="btn-primary" name="btn_Register" id="btn_Register" Value="Register">
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

</html>