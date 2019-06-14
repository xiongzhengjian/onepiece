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
    <script src="./assets/js/ie-emulation-modes-warning.js"></script>   
	 <script src="./assets/js/jquery.min.js"></script>
     <link rel="stylesheet" type="text/css" media="all" href="./assets/css/daterangepicker.css" />
     <script type="text/javascript" src="./assets/js/moment.min.js"></script>
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
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
       <!--  <div class="col-sm-9 col-sm-offset-1 col-md-10 col-md-offset-1 main"> -->
          <h4 class="page-header">BIOS tasks record</h4>
          <form class="form-signin" action="./record/insertBioses.action" method="post">				      				      	
		        <table class="table table-striped" id="biosTable">
				  <!-- <caption>add  loading records</caption>	 -->						
				  	<tbody id="biosTbody">
				  		
					    <tr id="trs0">
					      <td>							    
							<div class="form-group">
							    <label for="name">Chassis</label>							    
							    <%-- <input type=hidden name="biosVos[0].owner" id="owner0" value="${session_user.enname }"/> --%>
							   	<select class="form-control" id="chassis0" name="biosVos[0].chassis"></select>	
							</div>
					      </td>
					      <td>
					      	<div class="form-group">
							    <label for="name">Platform</label>
							    <select class="form-control" id="platform0" name="biosVos[0].platform"></select>								    
							</div>
					      </td>
					      <td>
					      	<div class="form-group">
							    <label for="name">Test Type</label>									  
								<select class="form-control" name="biosVos[0].test_type">
							      <option value="BIOS pre-test">BIOS pre-test</option>
							      <option value="Weekly Test">Weekly Test</option>	
							      <option value="BC Test">BC Test</option>	
							      <option value="BIOS Softpaq">BIOS Softpaq</option>	
							      <option value="BIOS Full">BIOS Full</option>									     
							    </select>						    
							</div>
					      </td>
					       <td>
					      	<div class="form-group">
							    <label for="name">Schedule</label>
							    <input  id="schedule0" class="form-control" name="biosVos[0].schedule"/>
							    					    
							</div>
					      </td>
					      
					      <td>
					      	<div class="form-group">
							   <label for="name">BIOS Version</label>							 
							   	<input class="form-control" id="show_type_lunch" name="biosVos[0].bios_version"/>							   			    
							</div>
					      </td>
					      <td>
					      	<div class="form-group">
							    <label for="name">Image Build ID</label>
							    <input class="form-control" name="biosVos[0].image_build_id"/>					    
							</div>
					      </td>
					       <td>
					      	<div class="form-group">
							    <label for="name">Test Plan</label>
							    <input class="form-control"  name="biosVos[0].test_plan" value=""/>					    
							</div>
					      </td>
					       <td>
					      	<div class="form-group">
							    <label for="name">Tester</label>									  
								 <input class="form-control" name="biosVos[0].tester" value=""/>					    
							</div>
					      </td>
					    </tr>
				  	</tbody>
				</table>
				
				<div style="float:left;" class="form-group">
		          <a class="btn btn-sm  btn-default glyphicon glyphicon-minus" id ="minusBtn"> minus</a>
		        </div>
		        
		        <div style="float:right;" class="form-group">
		          <a   class="btn btn-sm  btn-default glyphicon glyphicon-plus" id ="addBtn"> add</a>
		        </div>
		        
		        <button class="btn btn-lg btn-default btn-block" type="submit">save</button>
		    </form>
        </div>
     <!--  </div> -->
    </div> 
   
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="./assets/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="./assets/js/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./assets/js/ie10-viewport-bug-workaround.js"></script>
    <script src="./assets/js/dateformat.js"></script>
    
    <!-- config timepicker -->
  
    
    <!-- Bios -->
    <script type="text/javascript">
	    window.onload = function(){	    	
	    	
	    	var options = {};
			   function updateConfig() {
				   options.singleDatePicker = false;
				   options.showDropdowns = true;
				   options.showWeekNumbers = false;
				   options.showISOWeekNumbers = false;
				   options.timePicker = true;
				   options.timePicker24Hour = true;
				   options.timePickerSeconds = true;
				   //(true/false) Hide the apply and cancel buttons, and automatically apply a new date range as soon as two dates are clicked. 
				   options.autoApply = false;
				   options.ranges = {
				              'Today': [moment(), moment()],
				              'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
				              'Last 7 Days': [moment().subtract(6, 'days'), moment()],
				              'Last 30 Days': [moment().subtract(29, 'days'), moment()],
				              'This Month': [moment().startOf('month'), moment().endOf('month')],
				              'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
				            };
				   options.locale = {
				              direction: $('#rtl').is(':checked') ? 'rtl' : 'ltr',
				             /*  format: 'MM/DD/YYYY HH:mm', */
				              format: 'YYYY/MM/DD',
				              separator: ' - ',
				              applyLabel: 'Apply',
				              cancelLabel: 'Cancel',
				              fromLabel: 'From',
				              toLabel: 'To',
				              customRangeLabel: 'Custom',
				              daysOfWeek: ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr','Sa'],
				              monthNames: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
				              firstDay: 1
				            };
				   options.linkedCalendars = false;
				   options.autoUpdateInput = true;
				   options.alwaysShowCalendars = false;
				   
			   }
			   updateConfig();
	    	
	    	
	    	/*----------------- init Chassis -----------------------*/
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
 		 		 var option_chassises = "<option value=''>-chassises-</option>";
 		 		 //Add option based on the length of the array
 		 		 $.each(common_chassises,function(i,n){ 		 			 		 			
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
	    	
	    	 $('#schedule0').daterangepicker(options, function(start, end, label) {
	    		/*  console.log('New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')');  */
	    		 }).click();
	    	
	    	 
	    	 /* ----------Add------------------ */
	    	 //record the amount of add click and minus clicks
	    	 var add_clicks = 0;
	    	 var minus_clicks = 0;
	    	 
	    	 $('#addBtn').click(function(){
	    		 console.log(common_chassises);
	    		 var Tr_length = $("#biosTbody")[0].rows.length;
	    		 console.log(Tr_length);
	    		 var last_Row = $("#biosTable tr:last")[0];
	    		 console.log(last_Row);
	    		 //add a row of data
	    		 createRow();
	    	 });
	    	
	    	 /* ----------createRow------------------ */
	    	 function createRow(){	    		 
	    		 add_clicks +=1;
	    		 //TR
	    		 var row_content = '<tr id="trs"'+ add_clicks + '>';
	    		 //TD: chassis
	    		 row_content += '<td><div class="form-group">';
	    		 row_content +='<select class="form-control" id="chassis'+add_clicks+'" name="biosVos['+add_clicks+'].chassis"></select>';
	    		 row_content +='</div></td>';
	    		
	    		 
	    		 //TD:platform
	    		 row_content +='<td><div class="form-group">';
	    		 row_content +='select class="form-control" id="platform'+add_clicks+'" name="biosVos['+add_clicks+'].platform"></select>';
	    		 row_content +='</div></td>';
	    		
	    		 
	    		 //TD:test_type
	    		 row_content +='<td><div class="form-group">';
	    		 row_content +='<select class="form-control" id="test_type'+add_clicks+'" name="biosVos['+add_clicks+'].test_type">';
	    		 row_content +='<option value="BIOS pre-test">BIOS pre-test</option>';
	    		 row_content +='<option value="Weekly Test">Weekly Test</option>';
	    		 row_content +='<option value="BC Test">BC Test</option>';
	    		 row_content +='<option value="BIOS Softpaq">BIOS Softpaq</option>';
	    		 row_content +='<option value="BIOS Full">BIOS Full</option>';
	    		 row_content +='</select></div></td>';
	    		 
	    		 //TD:schedule
	    		 row_content +='<td><div class="form-group">';
	    		 row_content +='select class="form-control" id="schedule'+add_clicks+'" name="biosVos['+add_clicks+'].schedule"></select>';
	    		 row_content +='</div></td>';
	    		 console.log(row_content);
	    		 
	    		 
	    		 
	    	 }
	    }
    </script>
   
  
    
    
    
   
     
    
    
    
  </body>
</html>
