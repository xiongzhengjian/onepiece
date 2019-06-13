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
            <li><a>Home</a></li>           
            <li><a>${session_user.enname }</a></li>
          </ul>          
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
       <!--  <div class="col-sm-9 col-sm-offset-1 col-md-10 col-md-offset-1 main"> -->
          <h4 class="page-header">BIOS tasks record</h4>
          <form class="form-signin" action="./record/addbiosdata.action" method="post">				      				      	
		        <table class="table table-striped">
				  <!-- <caption>add  loading records</caption>	 -->						
				  	<tbody id="mealTb">
				  		<!-- =============lunch============ -->
					    <tr id="trs0">
					      <td>							    
							<div class="form-group">
							    <label for="name">Chassis</label>
							    <!-- <select class="form-control" name="orderlist[0].weekday"></select>	 -->
							   	<select class="form-control" id="chassis0" name="chassis"></select>	
							</div>
					      </td>
					      <td>
					      	<div class="form-group">
							    <label for="name">Platform</label>
							    <select class="form-control" id="platform0" name="platform"></select>								    
							</div>
					      </td>
					      <td>
					      	<div class="form-group">
							    <label for="name">Test Type</label>									  
								<select class="form-control" name="orderlist[0].decide">
							      <option value="1">BIOS pre-test</option>
							      <option value="0">Weekly Test</option>	
							      <option value="0">BC Test</option>	
							      <option value="0">BIOS Softpaq</option>	
							      <option value="0">BIOS Full</option>									     
							    </select>						    
							</div>
					      </td>
					       <td>
					      	<div class="form-group">
							    <label for="name">Start</label>
							    <input  class="form-control" name="orderlist[0].type"/>					    
							</div>
					      </td>
					      <td>
					      	<div class="form-group">
							    <label for="name">End</label>									  
								<input class="form-control" id="show_type_lunch" name="orderlist[0].type"/>					    
							</div>
					      </td>
					      <td>
					      	<div class="form-group">
							   <label for="name">BIOS Version</label>							 
							   	<input class="form-control" id="show_type_lunch" name="orderlist[0].type"/>							   			    
							</div>
					      </td>
					      <td>
					      	<div class="form-group">
							    <label for="name">Image Build ID</label>
							    <input class="form-control" name="orderlist[0].type"/>					    
							</div>
					      </td>
					       <td>
					      	<div class="form-group">
							    <label for="name">Test Plan</label>
							    <input class="form-control"  name="orderlist[0].type" value="1"/>					    
							</div>
					      </td>
					       <td>
					      	<div class="form-group">
							    <label for="name">Tester</label>									  
								 <input class="form-control" name="orderlist[0].type" value="1"/>					    
							</div>
					      </td>
					    </tr>
				  	</tbody>
				</table>
		        <div style="float:right;" class="form-group">
		          <a  class="btn  btn-default" id ="add">add</a>
		        </div>
		        <button class="btn btn-lg btn-success btn-block" type="submit">submit</button>
		    </form>
        </div>
     <!--  </div> -->
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
	    window.onload = function(){	    	
	    	/* init Chassis */
	    	$.ajax({ 
 		 	   url:  './record/findChassises.action',
 		 	   data: "{t:"+new Date().getTime()+"}",
 		 	   type: "POST",
 		 	   dataType: "json",
 		 	   contentType:'application/json',
 		 	   complete: function(data){		 		
 		 		 var chassises = data.responseText;
 		 		 var json_chassises = JSON.parse(chassises);
 		 		 //Gain array objects chassises 
 		 		 var obj_chassises = json_chassises.chassises;
 		 		 //Create option
 		 		 var option_chassises = "<option value=''>-chassises-</option>";
 		 		 //Add option based on the length of the array
 		 		 $.each(obj_chassises,function(i,n){ 		 			 		 			
 		 			option_chassises +="<option value=\""+n.chassis+"\">" + n.chassis + "</option>"; 
 		 		 });
 		 		 //Add the created options to the select
 		 		 $('#chassis0').append(option_chassises);
 		 		 
 		 		 
 	 			}
 	 	   
 	 	   		});
	    	
	    	//Add selected events(If binding is dynamic, put the change method into chassis Ajax)
	    	 $('#chassis0').change(function(){
	    		 	//Get the selected chassis
		 		 	var selected_chassis = $("#chassis0").val();
	    		 	//Encapsulation parameters
	    		 	var param = {chassis:selected_chassis};		 		 	
		 		 	//The ajax request loads the corresponding platform data
		 		 	$.ajax({
		 		 		url:  './record/findPlatform.action', 
		 		 		data:JSON.stringify(param),	
		 		 		type: "POST",
		 		 	   	dataType: "json",
		 		 	    contentType:'application/json',
		 		 	  	complete: function(data){
		 		 			console.log(data);
		 		 			var responseJSON = data.responseJSON;
		 		 			var platforms = responseJSON.platforms;
		 		 			//console.log(platforms);
		 		 			 //Create platform option
 		 		 			var option_platform = "<option value=''>-platforms-</option>";
 		 		 			//Add option based on the length of the array
 		 					 $.each(platforms,function(i,n){ 		 			 		 			
 		 						option_platform +="<option value=\""+n.platform+"\">" + n.platform + "</option>"; 
 		 					 });
 		 		 			//Add the created options to the select  childNodes
		 		 			$('#platform0').append(option_platform);
 		 		 			//
		 		 			$('#platform0').html(option_platform);
		 		 			
		 		 			
		 		 		}
		 		 	});
		 		 }); 
	    	
	    	
	    }
    </script>
    
    
    
    
   
     
    
    
    
  </body>
</html>
