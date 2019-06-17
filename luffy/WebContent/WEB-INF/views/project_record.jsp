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
    <script src="./assets/js/jquery.min.js"></script>
    <script src="./assets/js/ie-emulation-modes-warning.js"></script>
    <script type="text/javascript" src="./assets/js/daterangepicker.js"></script>   
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
              <tbody>
              	<c:forEach items="${biosVos}" varStatus="idStatus" var="biosVo" >              		
                	
                	<tr id="tr${idStatus.index+0 }">               		
            			<td>${biosVo.chassis }</td> 
            			<td>${biosVo.platform }</td>
            			<td>${biosVo.test_type }</td>
            			<td>${biosVo.schedule }</td>
            			<td>${biosVo.bios_version }</td>
            			<td>${biosVo.image_build_id }</td>
            			<td>${biosVo.test_plan }</td>
            			<td>${biosVo.tester }</td>            			          			
            			<td>
            				<a class="label label-default  edit" title="${biosVo.bios_id }" id="${idStatus.index+0 }">edit</a>
            				<a class="label label-default  delete" title="${biosVo.bios_id }" id="${idStatus.index+0 }">delete</a>
            			</td>  
        			</tr>  
        			
        		</c:forEach> 
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
    
    
	
   
    <!-- Placed at the end of the document so the pages load faster -->   
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="./assets/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="./assets/js/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./assets/js/ie10-viewport-bug-workaround.js"></script>
    
    
    <!-- Bios -->
    <script type="text/javascript">
    
    	window.onload = function(){

/*----------------- init Chassis by Ajax-----------------------*/
		    	//define a global common_chassises variable for all Tr_Chassis
		    	var common_chassises = '';
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
	 		 		 common_chassises = json_chassises.chassises;
	 		 		 //Create option
	 		 		 //var option_chassises = "<option value=''>-chassises-</option>";
	 		 		var option_chassises = '<option value="">-chassises-</option>';
	 		 		 //Add option based on the length of the array
	 		 		 $.each(common_chassises,function(i,n){ 		 			 		 			
	 		 			//option_chassises +="<option value=\""+n.chassis+"\">" + n.chassis + "</option>"; 
	 		 			option_chassises +='<option value=\"'+n.chassis+'\">' + n.chassis + '</option>'; 
	 		 		 });
	 		 		 //Add the created options to the target Select
	 		 		 console.log(option_chassises);
	 		 		 //$('#chassis0').append(option_chassises);
	 		 		 
	 		 		 
	 	 			}
	 	 	   
	 	 	   		});
		    	
/* ---------CreateRow----------------------- */
		    	 //parameter common_chassises0 is data of chassises
		    
/* ---------Edit----------------------- */
 			$(".edit").click(function(){
 				//get the ID of this data in the Table
 				var editId = this.id;
 				var trId = "tr"+this.id;
 				//get the ID of this data in the database
 				var dataId = this.title;
 				//gets the JS object of the current row
 				var current_Tr = $("#"+trId)[0];
 				//gets all Tds of the current row
 				var current_Tds = current_Tr.cells; 				
 				//gets all content of the current row but except  Operate_Td
 				var origin_chassis = current_Tds[0].innerText;
 				var origin_platform = current_Tds[1].innerText;
 				var origin_test_type = current_Tds[2].innerText;
 				var origin_schedule = current_Tds[3].innerText;
 				var origin_bios_version = current_Tds[4].innerText;
 				var origin_image_build_id = current_Tds[5].innerText;
 				var origin_test_plan = current_Tds[6].innerText;
 				var origin_tester = current_Tds[7].innerText;
 				////console.log(origin_chassis+"--;"+origin_platform+"--;"+origin_test_type+"--;"+origin_test_type+"--;"+origin_schedule+"--;"+origin_bios_version+"--;"+origin_image_build_id+"--;"+origin_test_plan+"--;"+origin_tester);
 				
 				// chassis
	    		var new_chassis_Td = '<td><div class="form-group">'; 
	    		new_chassis_Td +='<select class="form-control" id="chassis'+editId+'" name="chassis"></select>';
	    		new_chassis_Td +='</div></td>';
 				$(current_Tds[0]).html(new_chassis_Td);
 				
 				 //platform
	    		 var new_platform_Td ='<td><div class="form-group">';
	    		 new_platform_Td +='<select class="form-control" id="platform'+editId+'" name="platform"></select>';
	    		 new_platform_Td +='</div></td>';
	    		 $(current_Tds[1]).html(new_platform_Td);
	    		 
	    		//test_type
	    		 var new_test_type = '<td><div class="form-group">';	    		
	    		 new_test_type +='<select class="form-control" id="test_type'+editId+'" name="test_type">';
	    		 new_test_type +='<option value="BIOS pre-test">BIOS pre-test</option>';
	    		 new_test_type +='<option value="Weekly Test">Weekly Test</option>';
	    		 new_test_type +='<option value="BC Test">BC Test</option>';
	    		 new_test_type +='<option value="BIOS Softpaq">BIOS Softpaq</option>';
	    		 new_test_type +='<option value="BIOS Full">BIOS Full</option>';
	    		 new_test_type +='</select></div></td>';
	    		 $(current_Tds[2]).html(new_test_type);
	    		 
	    		 //schedule
	    		 var new_schedule ='<td><div class="form-group">';
	    		 new_schedule +='<input class="form-control" id="schedule'+editId+'" name="schedule"></input>';
	    		 new_schedule +='</div></td>';
	    		 $(current_Tds[3]).html(new_schedule);
	    		 $("#schedule"+editId).val(origin_schedule);
	    		 
	    		 
	    		//bios_version
	    		 var new_bios_version ='<td><div class="form-group">';
	    		 new_bios_version +='<input class="form-control" id="bios_version'+editId+'" name="bios_version"></input>';
	    		 new_bios_version +='</div></td>';
	    		 $(current_Tds[4]).html(new_bios_version);
	    		 $("#bios_version"+editId).val(origin_bios_version);
	    		 
	    		//image_build_id
	    		 var new_image_build_id ='<td><div class="form-group">';
	    		 new_image_build_id +='<input class="form-control" id="image_build_id'+editId+'" name="image_build_id"></input>';
	    		 new_image_build_id +='</div></td>';
	    		 $(current_Tds[5]).html(new_image_build_id);
	    		 $("#image_build_id"+editId).val(origin_image_build_id);
	    		 
	    		//test_plan
	    		 var new_test_plan ='<td><div class="form-group">';
	    		 new_test_plan +='<input class="form-control" id="test_plan'+editId+'" name="test_plan"></input>';
	    		 new_test_plan +='</div></td>';
	    		 $(current_Tds[6]).html(new_test_plan);
	    		 $("#test_plan"+editId).val(origin_test_plan);
	    		 
	    		//tester
	    		 var new_tester ='<td><div class="form-group">';
	    		 new_tester +='<input class="form-control" id="tester'+editId+'" name="tester"></input>';
	    		 new_tester +='</div></td>';
	    		 $(current_Tds[7]).html(new_tester);
	    		 $("#tester"+editId).val(origin_tester);
	    		 //var textvalue = $("#tester"+editId)[0];
	    		 //textvalue.innerText=origin_tester;
	    		 
	    		//operate    btn btn-success
	    		 //var new_operate = '<a class="label label-default  operate"  id="operate'+dataId+'">ok</a>';
	    		 var new_operate = '<a class="btn btn-success  operate" title="'+dataId+'" id="'+editId+'">ok</a>';
	    		 $(current_Tds[8]).html(new_operate);
	    		 $("#"+editId).click(function(){
	    			 var data_Id = this.title;
	    			 console.log(data_Id);
	    			 //------------Modify database data through Ajax
	    			 
	    			 
	    			 //Revert to table mode after successful update
	    			
	    			
	  				var current_Tr2 =  $("#tr"+this.id)[0];	  				
	  				var current_Tds2 = current_Tr2.cells; 
	  				var origin_chassis2 = current_Tds2[0].innerText;
	  				var origin_platform2 = current_Tds2[1].innerText;
	  				var origin_test_type2 = current_Tds2[2].innerText;
	  				var origin_schedule2 = current_Tds2[3].innerText;
	  				var origin_bios_version2 = current_Tds2[4].innerText;
	  				var origin_image_build_id2 = current_Tds2[5].innerText;
	  				var origin_test_plan2 = current_Tds2[6].innerText;
	  				var origin_tester2 = current_Tds2[7].innerText;
	  				console.log(origin_chassis2+"--;"+origin_platform2+"--;"+origin_test_type2+"--;"+origin_test_type2+"--;"+origin_schedule2+"--;"+origin_bios_version2+"--;"+origin_image_build_id2+"--;"+origin_test_plan2+"--;"+origin_tester2); 
	  				
	    		 });
	    		 
	    		 
 			});
 			
    	}
    </script>
    
    
    
    
   
     
    
    
    
  </body>
</html>
