<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">   
    <meta name="description" content="record">
    <meta name="bear" content="">

    <title>Bios record</title>
    <%
		String path = request.getContextPath(); 		
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
	<base href="<%=basePath%>">
    <link rel="icon" href="./icon/favicon.ico">
    <!-- Bootstrap core CSS -->
    <link href="./assets/css/bootstrap.min.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="./assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="./assets/css/dashboard.css" rel="stylesheet">
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="./assets/js/ie-emulation-modes-warning.js"></script>
    <script src="./assets/js/echarts.js"></script>      
  </head>

  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand">Record</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a>Home</a></li>           
            <li><a>${session_user.enname }</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a>Sustaining Test<span class="sr-only">(current)</span></a></li>
            <li><a  href="./record/projectrecord.action">BIOS pre-release</a></li>
            <li><a href="./ofood/personal.action">Commodity</a></li>
            <li><a href="#">Softpaq</a></li>
            <li><a href="#">WAT</a></li>
            <li><a href="#">SWT</a></li>
          </ul>
           <ul class="nav nav-sidebar">
            <li><a>Import</a></li>
            <li><a>Export</a></li>            
          </ul>
          
        
          
          
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h4 class="page-header">BIOS tasks record</h4>          
  		 <span class="sub-header">
         	<a type="button" class="btn  btn-success btn-sm  glyphicon glyphicon-plus" href="./record/addbiosdata.action"> new</a>
		 </span>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Chassis</th>                  
                  <th>Platform</th>
                  <th>Test Type</th>
                  <th>Schedule</th>                  
                  <th>Bios Version</th>
                  <th>Image Build ID</th>
                  <th>Test Plan</th>
                  <th>Tester</th>  
                  <th>Operate</th>  
                </tr>
              </thead>
              <tbody><!-- bios_id,chassis,platform,test_type,schedule,bios_version,image_build_id,test_plan,tester -->
                <c:forEach items="${biosVos}" varStatus="idStatus" var="biosVo" >              		
                	<tr>               		
            			<td>${biosVo.chassis }</td> 
            			<td>${biosVo.platform }</td>
            			<td>${biosVo.test_type }</td>
            			<td>${biosVo.schedule }</td>
            			<td>${biosVo.bios_version }</td>
            			<td>${biosVo.image_build_id }</td>
            			<td>${biosVo.test_plan }</td>
            			<td>${biosVo.tester }</td>            			          			
            			<td>
            				<a class="label label-default  edits" title="${biosVo.bios_id }" id="${idStatus.index+0 }" lang="${biosVo.bios_id }" >edit</a>
            				<a class="label label-default  edits" title="${biosVo.bios_id }" id="${idStatus.index+0 }" lang="${biosVo.bios_id }" >delete</a>
            			</td>  
        			</tr>  
        		</c:forEach>        
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
    
    
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="./assets/js/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="./assets/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="./assets/js/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./assets/js/ie10-viewport-bug-workaround.js"></script>
    <script src="./assets/js/dateformat.js"></script>
    <!-- Bios -->
    <script type="text/javascript">
    	
    </script>
    
    
    
    
   
     
    
    
    
  </body>
</html>
