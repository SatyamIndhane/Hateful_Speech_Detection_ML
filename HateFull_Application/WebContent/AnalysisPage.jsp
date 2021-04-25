<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.algo.*" %>
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
<script type="text/javascript" src="jsnew/jquery-1.9.1.min.js"></script>
 <script src="jsnew/highcharts.js"></script>
<script>
    <%        
 chk1.br();
    chk1.timeinfo();
 String  arr22=chk1.acclist.toString().replace("[", "").replace("]", "")
    .replace(", ", ",");//y
    /////////
    String[] acc=arr22.split(",");
    System.out.println(arr22);
    
    %>
    
    
    $(function () {
        $('#containergss').highcharts({
            chart: {
                type: 'column'
            },
            title: {
                text: 'Accuracy Graph'
            },
            subtitle: {
               
            },
            xAxis: {
            	 title: {
                     text: 'Calculate Accuracy from NB,SVM and DT '
                 },
            	categories: ['NB','SVM','DT'],
            	labels: {
                    rotation: -45,
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif'
                    }
                }

                
            },
            yAxis: {
            	 title: {
                     text: 'Calculates the Accuracy'
                 },
                              
            },
            legend: {
                enabled: true
            },
            tooltip: {
                pointFormat: '<b>{point.y:1f}%</b>'
            },
            series: [{
            	name: 'NB',
            	color:'red',
                data: [<%=acc[0]%>,0,0],
                },
                {
                	name: 'SVM',
                	color:'yellow',
                    data: [0,<%=acc[1]%>,0],
                    },
                    {
                    	name: 'DT)',
                    	color:'green',
                        data: [0,0,<%=acc[2]%>],
                        }
                ]
        });
    });
    
</script>
<script>
    <%        
 String  arrg22=chk1.timelist.toString().replace("[", "").replace("]", "")
		    .replace(", ", ",");//y
    /////////
    String[] timedata=arrg22.split(",");
    %>
   
    $(function () {
        $('#containergdemo').highcharts({
            chart: {
                type: 'column'
            },
            title: {
                text: 'Time Analysis Graph'
            },
            subtitle: {
               
            },
            xAxis: {
            	 title: {
                     text: 'Calculate Time from NB, DT and SVM'
                 },
            	categories: ['NB','DT','SVM'],
            	labels: {
                    rotation: -45,
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif'
                    }
                }

                
            },
            yAxis: {
            	 title: {
                     text: 'Calculates the Time(ms)'
                 },
                              
            },
            legend: {
                enabled: true
            },
            tooltip: {
                pointFormat: '<b>{point.y:1f}no</b>'
            },
            series: [{
            	name: 'NB',
            	color:'red',
                data: [<%=timedata[0]%>,0,0],
                },
                {
                	name: 'DT',
                	color:'yellow',
                    data: [0,<%=timedata[1]%>,0],
                    },
                    {
                    	name: 'SVM',
                    	color:'green',
                        data: [0,0,<%=timedata[2]%>],
                        }
                ]
        });
    });
</script>

    
</head><!--/head-->

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
             <li class="active"><a href="AnalysisPage.jsp">Analysis</a></li>
            <li><a href="doLogin">LogOut</a></li>
         
        </ul>
        <div class="clr"></div>
      </div>
      <div class="hbg"><img src="images/header_images.jpg" width="923" height="291" alt="" /></div>
    </div>
     <div >
      <div >
        <div >
          <div align="center">
               <h2 align="center">Analysis Information</h2>
               
         		<div >
            
            <form >
			<div >
			<table border="1">
              <tr>
              <td align="left">
             
              <div id="containergss" style="min-width: 450px; height: 400px; max-width: 200px;"></div>
             
              </td>
              <td align="right">
             
              <div id="containergdemo" style="min-width: 450px; height: 400px; max-width: 200px;"></div>
             
              
              </td>
              </tr>
             
            
              </table>
			</div>
			</form> 
            
            
             <form >
			<div class="form-group" >
			<table style="font-size: 20px;">
			
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