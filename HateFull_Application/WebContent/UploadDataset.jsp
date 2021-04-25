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
        
          <li class="active"><a href="UploadDataset.jsp">Upload DataSet</a></li>
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
     <div style="height: 100%">
      <div style="height: 100%">
        <div style="height: 100%" >
          <div align="center" style="height: 100%">
          </br>         
            <h2><b><span>Upload Training DataSet</span></b></h2>
                      </br>
            <hr><form enctype="multipart/form-data"   action="uploadtraingdataset" method="post">
			<div class="form-group" >
			<table style="font-size: 20px;height: 100%">
			<tr>
			<div><td width="30%"><label for="txt_Uname">Select File Path:</label></td></div>
		    <br>
		    	<td width="30%" ><input type="file" style="border-color: gray;"  name="txt_search" id="txt_search" /></td>
		    </br>
		  <td   align="left" ><input type="submit"  name="btn_Submit" id="btn_Submit" Value="Submit">
			</td>
			</tr>
			
			</table>
			</br>
			</div>
			</form> 
            </div>
            </br>
            </br>
            </br>
            </br>
             </div>
       
        <div class="clr" style="height: 100%"></div>
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