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
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>oFood</title>
    <%
		String path = request.getContextPath(); //path="/luffy"
		//  basePath="http://localhost:8080/luffy/"
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
	<base href="<%=basePath%>">
    <link rel="icon" href="./icon/favicon.ico">
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="./assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./assets/css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="./assets/js/ie-emulation-modes-warning.js"></script>

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
          <a class="navbar-brand">Personal</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="./ofood/captain.action">Home</a></li>           
            <%-- <li><a >Hi! ${session_user.name }</a></li> --%>
          </ul>
          <!-- <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form> -->
        </div>
      </div>
    </nav>
		<div class="main">
          <h3 class="page-header">${session_user.enname }</h3>       
          <h4 class="sub-header">The food in the canteen is cost-effective...</h4>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>site</th>
                  <th>weekday</th>
                  <th>date</th>
                  <th>meal</th>
                  <th>decide</th>                 
                  <th>operate</th>
                </tr>
              </thead>
              <tbody>                
                <c:forEach items="${meals}" varStatus="i" var="meal" >              		
                	<tr>               		
            			<td>${meal.site }</td> 
            			<td>星期几</td>
            			<td>${meal.date }</td> 
            			<td>${(meal.type==1)?'午餐':'晚餐' }</td> 
            			<%-- <td>${meal.decide }</td>  --%>
            			<td>
            				<%-- <label class="radio-inline">
            					<c:if test="${meal.decide == 1}">
	        						<input type="radio" name="optionsRadiosinline" id="optionsRadios1" value="1" checked="checked">要吃            					
            					</c:if>	            					
    						</label>
    						<label class="radio-inline">
        						<c:if test="${u.sex == '1'}">
	        						<input type="radio" name="optionsRadiosinline" id="optionsRadios2" value="0" checked="${(meal.decide==1)?checked:unchecked }">要吃            					
            					</c:if>	
    						</label> --%>
    						
    						
    						<label class="radio-inline">
	    						<c:choose>
	    							<c:when test="${meal.decide == '1'}">
	        							<input type="radio" name="optionsRadiosinline" id="optionsRadios1" value="1" checked="checked">要吃       
	    							</c:when>
	   								 <c:otherwise>
	      								  <input type="radio" name="optionsRadiosinline" id="optionsRadios1" value="1">要吃 
	    							</c:otherwise>
								</c:choose>
							</label>
							<label class="radio-inline">
	    						<c:choose>
	    							<c:when test="${meal.decide == '0'}">
	        							<input type="radio" name="optionsRadiosinline" id="optionsRadios" value="0" checked="checked">不吃       
	    							</c:when>
	   								 <c:otherwise>
	      								  <input type="radio" name="optionsRadiosinline" id="optionsRadios" value="0">不吃 
	    							</c:otherwise>
								</c:choose>
							</label>            				
            			</td>
            			<td><a class="label label-default">edit</a></td>  
        			</tr>  
        		</c:forEach>  
               
                
              </tbody>
            </table>
          </div>
        </div>
    
   
    

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="./assets/js/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./assets/js/ie10-viewport-bug-workaround.js"></script>    
    <script src="./assets/js/dateformat.js"></script>
    
    <!-- initial table with meals data-->
    <script type="text/javascript">
    	
    </script>
    
    
    
  </body>
</html>
