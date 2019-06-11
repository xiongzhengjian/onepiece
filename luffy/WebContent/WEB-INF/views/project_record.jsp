<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">   
    <meta name="description" content="record">
    <meta name="bear" content="">

    <title>record</title>
    <%
		String path = request.getContextPath(); //path="/luffy"
		//  basePath="http://localhost:8080/luffy/"
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

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
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
            <li><a>Import</a></li>           
            <li><a >Export</a></li>
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
            <li class="active"><a>Sustaining test record<span class="sr-only">(current)</span></a></li>
            <li><a  href="#" data-toggle="modal" data-target="#myModal">BIOS pre-release</a></li>
            <li><a href="./ofood/personal.action">Commodity</a></li>
            <li><a href="#">Softpaq</a></li>
            <li><a href="#">WAT</a></li>
            <li><a href="#">SWT</a></li>
          </ul>
          
          
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">AstroDTProjects</h1>

         <!--  <div class="row placeholders">            
   			 <div id="main" style="width: 1200px;height:400px;"></div>           
          </div> -->
          
          

          <h6 class="sub-header" id="current_date">sustaining test record</h6>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>no</th>                  
                  <th>site</th>
                  <th>department</th>
                  <th>name</th>
                  <th>employeeID</th>
                  <th>email</th>
                  
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1,001</td>                  
                  <td>ipsum</td>
                  <td>dolor</td>
                  <td>sit</td>
                  <td>Lorem</td>
                  <td>ipsum</td>                 
                </tr>
                <tr>
                  <td>1,002</td>
                  <td>amet</td>
                  <td>consectetur</td>
                  <td>adipiscing</td>
                  <td>elit</td>
                  <td>consectetur</td>                               
                </tr>
                <tr>
                  <td>1,003</td>
                  <td>Integer</td>
                  <td>nec</td>
                  <td>odio</td>
                  <td>Praesent</td>
                  <td>Integer</td>                             
                </tr>
                
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
    
    <!-- login（Modal） -->
	
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
    <!-- set element to show date -->
    
    
    
    
   
     
    
    
    
  </body>
</html>
