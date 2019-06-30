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
    <link href="./assets/css/bootstrap.min.css" rel="stylesheet">

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
            <li><a href="./home.action">Home</a></li>            
            <li><a >Hi! ${session_user.name }</a></li>
          </ul>
          <!-- <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form> -->
        </div>
      </div>
    </nav>
		<div class="main">
         <%--  <h3 class="page-header">${session_user.enname }</h3>        --%>
          <%-- <h4 class="sub-header">You have made a reservation decision <span class="badge">${meals.size() div 2}</span> days in advance</h4> --%>
          <div class="table-responsive">
            <table class="table table-striped table-bordered">
              <caption>You have made a reservation decision <span class="badge">${meals.size() div 2}</span> days in advance</caption>
              <thead>
                <tr>
                <!--   <th>site</th> -->
                  <th>weekday</th>
                  <th>date</th>
                  <th>meal</th>
                  <th>decided</th>                 
                  <th>operate</th>
                </tr>
              </thead>
              <tbody>                
                <c:forEach items="${meals}" varStatus="idStatus" var="meal" >              		
                	<tr>               		
            			<%-- <td>${meal.site }</td>  --%>
            			<td class="weekday">星期几</td>
            			<td class="date">${meal.date }</td> 
            			<td>${(meal.type==1)?'午餐':'晚餐' }</td>             			
            			<%-- <td class="decided">${(meal.decide==0)?'No':'Yes' }</td> --%>	
            			<td class="decided" id="${meal.type }">${(meal.decide==0)?'不吃':'要吃' }</td>            			
            			<td><a class="label label-info  edits" title="${meal.decide }" id="${idStatus.index+0 }" lang="${meal.meal_id }" >change</a></td>  
        			</tr>  
        		</c:forEach>  
              </tbody>
            </table>
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
    
    <!-- initial table with meals data-->
    <script type="text/javascript">    
    	window.onload= function(){    		     		   		
    		//Get all the edit tags:edits_tags
    		var edits_tags = document.getElementsByClassName("edits");
    		var edits_amounts = edits_tags.length;    		
    		for (var i=0;i<edits_amounts;i++){
    			var edit_tag =  edits_tags[i];
    			edit_tag.addEventListener('click',function(){	
    				/* Make a change  */
    				//The listening environment does not seem to be able to pass values with the external environment, so you can only add an attribute on the tag itself to pass values
    				var index = this.id;  	    				
    				//Get the value of whether a meal has been ordered:Carry this value with the title attribute
    				var decided = this.title;    	
    				//get meal_id
    				var meal_id = this.lang;
    				
    				//Click change once to switch values between 0 and 1
    				if(decided==0){
    					this.title=1;
    					
    				}else{
    					this.title=0
    				}
    				//Get all decided TD tags:decided_TDs
    				var decided_TDs = document.getElementsByClassName("decided");   
    				//Get the corresponding 'decided' object
    				var decided_TD = decided_TDs[index];    
    				//get meal type
    				var type = decided_TD.id;    				
    				//Change display information
    	    		if(decided==0){
    	    			decided_TD.innerText='要吃';    	    			
    	    		}else{
    	    			decided_TD.innerText='不吃';
    	    			
    	    		}
    				/*  Submit a request */
    				//1.Create a ajax objects
    				if(window.XMLHttpRequest){
    					var oAjax = new XMLHttpRequest();
    				}else{
    					var oAjax = new ActiveXObject("Microsoft.XMLHTTP");
    				}
    				//2.connect to server
    				oAjax.open("GET","./ofood/change.action?meal_id="+meal_id+"&decide="+this.title+"&type="+type+"&t="+new Date().getTime());
    				//3.send request
    				oAjax.send();
    				//4.receive data of returned
    				oAjax.onreadystatechange=function(){
    					if(oAjax.readyState==4){
    						if(oAjax.status==200){
    							alert(oAjax.responseText);
    						}else{
    							alert("fail!");
    						}
    					}
    				}
    			}); 
    			
    				
    			
    		}
    		
    		
    		
    		/*date format weekday and date*/
    		var date_TDs = document.getElementsByClassName("date");
  			var weekday_TDs = document.getElementsByClassName("weekday");
  			var date_TDs_amounts = date_TDs.length;
  			var weekday_TDs_amounts = weekday_TDs.length;
  			//Processing date
   			 for (var index=0;index<date_TDs_amounts;index++){
   				var date_td = date_TDs[index];
   				var weekday_td = weekday_TDs[index];
   				var date_origin = date_td.innerText;
   				var date = DateFormat.format(new Date(date_origin) , 'yyyy-MM-dd');
   				//date_td.innerText=date;
   				weekday_td.innerText=DateFormat.getWeek(new Date(date_origin),DateFormat.WEEKTYPE.ZH_DAYNAME)
  			} 
    	}
    </script>
    
   
    
    
  </body>
</html>
