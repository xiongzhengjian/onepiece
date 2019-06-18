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
          <h4 class="page-header">Softpaq tasks record</h4>
          <form class="form-signin" action="./record/insertsoftpaqs.action" method="post">				      				      	
		        <table class="table table-striped" id="thisTable">
				  <!-- <caption>add  loading records</caption>	 -->						
				  	<tbody id="thisTbody">
				  		
					    <tr id="trs0">
					      <td>							    
							<div class="form-group">
							    <label for="name">Chassis</label>
							   	<select class="form-control" id="chassis0" name="SoftpaqVos[0].chassis"></select>	
							</div>
					      </td>
					      <td>
					      	<div class="form-group">
							    <label for="name">Platform</label>
							    <select class="form-control" id="platform0" name="SoftpaqVos[0].platform"></select>								    
							</div>
					      </td>
					      <td>
					      	<div class="form-group">
							    <label for="name">SP Number</label>
							    <input  id="name0" class="form-control" name="SoftpaqVos[0].sp_number"/>
							    					    
							</div>
					      </td>
					      <td>
					      	<div class="form-group">
							    <label for="name">SoftPAQ Title</label>
							    <input  id="name0" class="form-control" name="SoftpaqVos[0].softpaq_title"/>
							    					    
							</div>
					      </td>
					      <td>
					      	<div class="form-group">
							    <label for="name">Version</label>
							    <input  id="pn_sn0" class="form-control" name="SoftpaqVos[0].version"/>
							    					    
							</div>
					      </td>
					       <td>
					      	<div class="form-group">
							    <label for="name">Schedule</label>
							    <input  id="schedule0" class="form-control" name="SoftpaqVos[0].schedule"/>
							    					    
							</div>
					      </td>
					      
					      <td>
					      	<div class="form-group">
							   <label for="name">BIOS Version</label>							 
							   	<input id="bios_version0" class="form-control"  name="SoftpaqVos[0].bios_version"/>							   			    
							</div>
					      </td>
					      <td>
					      	<div class="form-group">
							    <label for="name">Image Build ID</label>
							    <input class="form-control" name="SoftpaqVos[0].image_build_id"/>					    
							</div>
					      </td>
					       <td>
					      	<div class="form-group">
							    <label for="name">Test Plan</label>
							    <input class="form-control"  name="SoftpaqVos[0].test_plan"/>					    
							</div>
					      </td>
					       <td>
					      	<div class="form-group">
							    <label for="name">Tester</label>									  
								 <input class="form-control" name="SoftpaqVos[0].tester"/>					    
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
  
    
    <!-- Commodity -->
    <script type="text/javascript">
	    window.onload = function(){	    	
/* ----------init time picker config------------------ */	    	
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
				             // format: 'MM/DD/YYYY HH:mm'
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
			   //Perform configuration operations
			   updateConfig();
	    	
	    	
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
 		 		var option_chassises = '<option value="">-chassises-</option>';
 		 		 //Add option based on the length of the array
 		 		 $.each(common_chassises,function(i,n){ 		 			 		 			
 		 			option_chassises +='<option value=\"'+n.chassis+'\">' + n.chassis + '</option>'; 
 		 		 });
 		 		 //Add the created options to the select
 		 		 $('#chassis0').append(option_chassises);
 		 		 
 		 		 
 	 			}
 	 	   
 	 	   		});
	    	
/*----------------- init Platform by change event and Ajax--------------*/
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
		 		 			//console.log(data);
		 		 			var responseJSON = data.responseJSON;
		 		 			var platforms = responseJSON.platforms;
		 		 			//console.log(platforms);
		 		 			 //Create platform option
 		 		 			var option_platform = "<option>-platforms-</option>";
 		 		 			//Add option based on the length of the array
 		 					 $.each(platforms,function(i,n){ 		 			 		 			
 		 						option_platform +="<option value=\""+n.platform+"\">" + n.platform + "</option>"; 
 		 					 });
 		 		 			//Add the created options to the select  childNodes
		 		 			//$('#platform0').append(option_platform);(bug) 		 		 			
		 		 			$('#platform0').html(option_platform);
		 		 			
		 		 			
		 		 		}
		 		 	});
		 		 }); 
		 		 
/* ----------add time picker function------------------ */	    	
	    	 $('#schedule0').daterangepicker(options, function(start, end, label) {
	    		/*  console.log('New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')');  */
	    		 }).click();
	    	
	    	 
/* ----------Add & Minus------------------ */
	    	 //record the amount of add click and minus clicks
	    	 var add_clicks = 0;
	    	 
	    	 
 /* ----------Add -------------------------- */	    	 
	    	 $('#addBtn').click(function(){	 
	    		 createRow(common_chassises);
	    	 });
	    	
			 //CreateRow/
	    	 //parameter common_chassises0 is data of chassises
	    	 function createRow(common_chassises0){	
				 //Warning!Please complete the platform information of the previous record
				 var previous_platform_information =  $('#platform'+add_clicks).val();
				 //console.log(previous_platform_information);
				 if(!previous_platform_information){
					 alert('Please select information for the "Platform"');
					 return;
				 }
				 
	    		 add_clicks +=1;
	    		 //TR
	    		 var row_content = '<tr id="trs"'+ add_clicks + '>';
	    		 //TD: chassis
	    		 row_content += '<td><div class="form-group">';
	    		 row_content +='<select class="form-control" id="chassis'+add_clicks+'" name="SoftpaqVos['+add_clicks+'].chassis"></select>';
	    		 row_content +='</div></td>';
	    		
	    		 
	    		 //TD:platform
	    		 row_content +='<td><div class="form-group">';
	    		 row_content +='<select class="form-control" id="platform'+add_clicks+'" name="SoftpaqVos['+add_clicks+'].platform"></select>';
	    		 row_content +='</div></td>';
	    		
	    		 
	    		 //TD:sp_number
	    		 row_content +='<td><div class="form-group">';
	    		 row_content +='<input class="form-control" id="sp_number'+add_clicks+'" name="SoftpaqVos['+add_clicks+'].sp_number"></input>';
	    		 row_content +='</div></td>';
	    		//console.log(row_content);
	    		
	    		
	    		 //TD:softpaq_title
	    		 row_content +='<td><div class="form-group">';
	    		 row_content +='<input class="form-control" id="softpaq_title'+add_clicks+'" name="SoftpaqVos['+add_clicks+'].softpaq_title"></input>';
	    		 row_content +='</div></td>';
	    		 
	    		 
	    		 //TD:version
	    		 row_content +='<td><div class="form-group">';
	    		 row_content +='<input class="form-control" id="version'+add_clicks+'" name="SoftpaqVos['+add_clicks+'].version"></input>';
	    		 row_content +='</div></td>';
	    		 
	    		 
	    		 //TD:schedule
	    		 row_content +='<td><div class="form-group">';
	    		 row_content +='<input class="form-control" id="schedule'+add_clicks+'" name="SoftpaqVos['+add_clicks+'].schedule"></input>';
	    		 row_content +='</div></td>';
	    		
	    		 
	    		 //bios_version
	    		 row_content +='<td><div class="form-group">';
	    		 row_content +='<input class="form-control" id="bios_version'+add_clicks+'" name="SoftpaqVos['+add_clicks+'].bios_version"></input>';
	    		 row_content +='</div></td>';
	    		 
	    		 //image_build_id
	    		 row_content +='<td><div class="form-group">';
	    		 row_content +='<input class="form-control" id="image_build_id'+add_clicks+'" name="SoftpaqVos['+add_clicks+'].image_build_id"></input>';
	    		 row_content +='</div></td>';
	    		 
	    		 //test_plan
	    		 row_content +='<td><div class="form-group">';
	    		 row_content +='<input class="form-control" id="test_plan'+add_clicks+'" name="SoftpaqVos['+add_clicks+'].test_plan"></input>';
	    		 row_content +='</div></td>';
	    		 
	    		 //tester
	    		 row_content +='<td><div class="form-group">';
	    		 row_content +='<input class="form-control" id="tester'+add_clicks+'" name="SoftpaqVos['+add_clicks+'].tester"></input>';
	    		 row_content +='</div></td>';
	    		
	    		 //Tr-End
	    		 row_content +='</tr>';
	    		 //Put the created Tr into the Tbody
	    		 $("#thisTbody").append(row_content);
	    		 
	    		 
	    		 /* load data: 1.option_chassises, 2.option_platform,3.timepicker function */
	    		 
	    		 //3.add time picker function
	    		  $('#schedule'+add_clicks).daterangepicker(options, function(start, end, label) {	    		
	    		 }).click();
	    		 
	    		 
	    		 //1.create option_chassises
	    		 var option_chassises = '<option value="">-chassises-</option>';
 		 		 //Add option based on the length of the array
 		 		 $.each(common_chassises,function(i,n){	
 		 			option_chassises +='<option value=\"'+n.chassis+'\">' + n.chassis + '</option>'; 
 		 		 }); 		 		 
 		 		 $('#chassis'+add_clicks).append(option_chassises);
	    		 
 		 		 //2option_platform
 		 		 
		    	//Add selected events(If binding is dynamic, put the change method into chassis Ajax)
		    	 $('#chassis'+add_clicks).change(function(){
		    		 	//Get the selected chassis
			 		 	var selected_chassis = $('#chassis'+add_clicks).val();
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
			 		 			//console.log(data);
			 		 			var responseJSON = data.responseJSON;
			 		 			var platforms = responseJSON.platforms;
			 		 			//console.log(platforms);
			 		 			 //Create platform option
	 		 		 			var option_platform = "<option>-platforms-</option>";
	 		 		 			//Add option based on the length of the array
	 		 					 $.each(platforms,function(i,n){ 		 			 		 			
	 		 						option_platform +="<option value=\""+n.platform+"\">" + n.platform + "</option>"; 
	 		 					 });
	 		 		 			//Add the created options to the select  childNodes			 		 			
			 		 			$('#platform'+add_clicks).html(option_platform);			 		 			
			 		 			
			 		 		}
			 		 	});
			 		 }); 
	    		 
	    		/*  console.log(row_content); */
	    		 
	    	 }//createRow  End
	    	 
	    	 
/* ----------Minus -------------------------- */
			$('#minusBtn').click(function(){
		    	if(add_clicks==0){
		    		return;
		    	}
		    	add_clicks -=1;				
				var last_Row = $("#thisTable tr:last");				
				//console.log(last_Row[0]);
				//console.log(last_Row);
				last_Row.remove();				
			});
	    		 
	    	 


	    }
    </script>
   
  
  </body>
</html>
