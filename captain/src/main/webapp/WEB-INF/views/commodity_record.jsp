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

    <title>Commodity record</title>
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
            <li><a href="./home.action">Home</a></li>             
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
            <li><a href="./record/commodity.action">Commodity</a></li>
            <!-- <li><a href="./record/softpaq.action">Softpaq</a></li> -->
            <li><a href="./record/softpaq2.action">Softpaq</a></li>
            <li><a href="./record/wat.action">WAT</a></li>
            <li><a href="./record/softrollrespin.action">Image softroll&respin</a></li>
          </ul>
          <ul class="nav nav-sidebar">
           <!--  <li><a href="./record/import.action">Import</a></li> -->
            <li><a href="./record/export.action">Export</a></li>            
          </ul>
          
          <form method="POST" enctype="multipart/form-data" id="form1" action="./record/import.action"">  
             <!-- <label>Import </label> -->
            <input id="upfile" type="file" name="upfile"><br>     
            <input type=hidden value="commodity" name="category">
            <input type="submit" value="Import"  onclick="return checkData()">
    	  </form>
        
          
          
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
         <!--  <h4 class="page-header">Commodity tasks record</h4> -->          
  		 <span class="sub-header">
         	<a type="button" class="btn  btn-success btn-sm  glyphicon glyphicon-plus" href="./record/addcommoditydata.action"> new</a>
		 </span>
          <div class="table-responsive">
          <form id="paging" method="post" action="./record/commoditypageshow.action">
            <table class="table table-condensed table-bordered">
            <caption>Commodity Record</caption>
              <thead>
                <tr>
                  <th>Chassis</th>                  
                  <th>Platform</th>
                  <th>Type</th>
                  <th>Name</th>
                  <th>PN/SN</th>
                  <th>Schedule</th>                  
                  <th>Bios Version</th>
                  <th>Image Build ID</th>
                  <th>Test Plan</th>
                  <th>Tester</th>  
                  <th>Operate</th>  
                </tr>
              </thead>
<!-- -------------------------paging------------------------------------------- -->
               <tfoot>
              	
              	<tr class="alert alert-info">
              		<!-- config perPageRows -->
              		<td style="text-align:center;vertical-align:middle;" colspan="1">
              			<select id="perPageRows" class="form-control"  name="perPageRows">
              			  <option value="10">-change-</option>
					      <option value="10">10</option>	
					      <option value="15">15</option>
					      <option value="20">20</option>	
					      <option value="25">25</option>	
					      <option value="30">30</option>									     
					    </select>
					    <!-- <input type=hidden value="1" name="currentPage"> -->
              		</td> 
              		
              		<!-- paging -->
              		<td style="text-align:center;vertical-align:middle;" colspan="9">
              			
              			<%-- <c:if test="${pagebean.totalPage==1 }">
							<ul class="pagination">
								<li><a href="./record/paging.action?currentPage=1">1</a></li>
							</ul>
						 </c:if> --%>
              			
              			<c:if test="${pagebean.totalPage>1 && pagebean.currentPage == 1}">
							<ul class="pagination">
								<c:forEach begin="${pagebean.pageRangeStart}" end="${pagebean.pageRangeEnd}" step="1" var="i">    
									<li><a href="./record/commoditypaging.action?currentPage=${i }">${i }</a></li>
								 </c:forEach>
								 
								<li><a href="./record/commoditypaging.action?currentPage=${pagebean.currentPage+1 }">&raquo;</a></li>
								<li><a href="./record/commoditypaging.action?currentPage=${pagebean.totalPage }">End</a></li>
							</ul>
						 </c:if> 
						 
              			<c:if test="${pagebean.totalPage>1 && pagebean.currentPage == pagebean.totalPage}">
              				<ul class="pagination">
								<li><a href="./record/commoditypaging.action?currentPage=1">Start</a></li>
						    	<li><a href="./record/commoditypaging.action?currentPage=${pagebean.currentPage-1 }">&laquo;</a></li>
						    	
								<c:forEach begin="${pagebean.pageRangeStart}" end="${pagebean.pageRangeEnd}" step="1" var="i">    
								 	<li><a href="./record/commoditypaging.action?currentPage=${i }">${i }</a></li>
	               				</c:forEach>
							</ul>
              			</c:if>
              			
              			<c:if test="${pagebean.currentPage>1 && pagebean.currentPage < pagebean.totalPage}">
              			<%-- <c:if test="${pagebean.currentPage < pagebean.totalPage}"> --%>
              				<ul class="pagination">
	              				<!-- <ul class="pager"> -->
							    <li><a href="./record/commoditypaging.action?currentPage=1">Start</a></li>
							    <li><a href="./record/commoditypaging.action?currentPage=${pagebean.currentPage-1 }">&laquo;</a></li>
							    
								<c:forEach begin="${pagebean.pageRangeStart}" end="${pagebean.pageRangeEnd}" step="1" var="i">    
								 	<li><a href="./record/commoditypaging.action?currentPage=${i }">${i }</a></li>
	               				 </c:forEach>
	               				 
	               				<li><a href="./record/commoditypaging.action?currentPage=${pagebean.currentPage+1 }">&raquo;</a></li>
							    <li><a href="./record/commoditypaging.action?currentPage=${pagebean.totalPage }">End</a></li>
							</ul>
              			</c:if>
						
              		</td>
              		
              		<!-- show message of  Current Page and Items-->
              		<td style="text-align:center;vertical-align:middle;" colspan="1">Current Page:<a>${pagebean.currentPage}</a> &nbsp Amount:<a>${pagebean.totalRows}</a></td>
      			</tr>
              </tfoot>
              <tbody>
              	<c:forEach items="${vos}" varStatus="idStatus" var="commodityVo" >              		
                	
                	<tr id="tr${idStatus.index+0 }">               		
            			<td>${commodityVo.chassis }</td> 
            			<td>${commodityVo.platform }</td>
            			<td>${commodityVo.type }</td>
            			<td>${commodityVo.name }</td>
            			<td>${commodityVo.pn_sn }</td>
            			<td>${commodityVo.schedule }</td>
            			<td>${commodityVo.bios_version }</td>
            			<td>${commodityVo.image_build_id }</td>
            			<td>${commodityVo.test_plan }</td>
            			<td>${commodityVo.tester }</td>            			          			
            			<td>
            				<a class="label label-info  edit" title="${commodityVo.commodity_id }" id="${idStatus.index+0 }">edit</a>
            				<a class="label label-warning  delete" title="${commodityVo.commodity_id }" id="${idStatus.index+0 }">delete</a>
            			</td>  
        			</tr>  
        			
        		</c:forEach> 
              </tbody>
            </table>
            </form>
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
    
    
    <!-- Commodity -->
    <script type="text/javascript">
    
    	window.onload = function(){

/*----------------- init Chassis by Ajax-----------------------*/
		    	//define a global common_chassises variable for all Tr_Chassis
		    	var common_chassises = '';
				var common_type = new Array('HHD','CPU','DIMM','SSD','Graphic Card','WLAN','PSU','PSU FAN');
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
	 		 		 ////console.log(option_chassises);
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
 				var origin_type = current_Tds[2].innerText;
 				var origin_name = current_Tds[3].innerText;
 				var origin_pn_sn = current_Tds[4].innerText;
 				var origin_schedule = current_Tds[5].innerText;
 				var origin_bios_version = current_Tds[6].innerText;
 				var origin_image_build_id = current_Tds[7].innerText;
 				var origin_test_plan = current_Tds[8].innerText;
 				var origin_tester = current_Tds[9].innerText;
 				////console.log(origin_chassis+"--;"+origin_platform+"--;"+origin_test_type+"--;"+origin_test_type+"--;"+origin_schedule+"--;"+origin_bios_version+"--;"+origin_image_build_id+"--;"+origin_test_plan+"--;"+origin_tester);
 				
 				/* chassis */
	    		var new_chassis_Td = '<td><div class="form-group">'; 
	    		new_chassis_Td +='<select class="form-control" id="chassis'+editId+'" name="chassis"></select>';
	    		new_chassis_Td +='</div></td>';
 				$(current_Tds[0]).html(new_chassis_Td);
 				//1.create option_chassises
	    		var option_chassises = '<option value="">-chassises-</option>';
 		 		//Add option based on the length of the array
 		 		$.each(common_chassises,function(i,n){
 		 			if(n.chassis==origin_chassis){
 		 				option_chassises +='<option selected="true" value=\"'+n.chassis+'\">' + n.chassis + '</option>';
 		 			}else{
	 		 			option_chassises +='<option value=\"'+n.chassis+'\">' + n.chassis + '</option>';  		 				
 		 			}
 		 		}); 		 		 
 		 		$("#chassis"+editId).html(option_chassises);
 		 		//2option_platform		 		 
		    	//Add selected events
		    	 $('#chassis'+editId).change(function(){
		    		 	//Get the selected chassis
			 		 	var selected_chassis = $('#chassis'+editId).val();
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
			 		 			////console.log(data);
			 		 			var responseJSON = data.responseJSON;
			 		 			var platforms = responseJSON.platforms;
			 		 			////console.log(platforms);
			 		 			 //Create platform option
	 		 		 			var option_platform = "<option>-platforms-</option>";
	 		 		 			//Add option based on the length of the array
	 		 					 $.each(platforms,function(i,n){ 	 		 						
	 		 							//option_platform +='<option selected="true" value=\"'+n.platform+'\">' + n.platform + '</option>'; 
		 		 						option_platform +='<option value=\"'+n.platform+'\">' + n.platform + '</option>'; 
	 		 					 });
	 		 		 			//Add the created options to the select  childNodes			 		 			
			 		 			$('#platform'+editId).html(option_platform);			 		 			
			 		 			
			 		 		}
			 		 	});
			 		 }); 
 				
 				
 				 /* platform */
	    		 var new_platform_Td ='<td><div class="form-group">';
	    		 new_platform_Td +='<select class="form-control" id="platform'+editId+'" name="platform"><option selected="true" value=\"'+origin_platform+'\">'+origin_platform+'</option></select>';
	    		 new_platform_Td +='</div></td>';
	    		 $(current_Tds[1]).html(new_platform_Td);   
	    		 
	    		/* type */
	    		 var new_type = '<td><div class="form-group">';	    		
	    		 new_type +='<select class="form-control" id="test_type'+editId+'" name="type">'; 
				 $.each(common_type,function(i,n){
					if(n==origin_type){
						new_type +='<option selected="true" value=\"'+n+'\">'+ n + '</option>'; 
					}else{
	 					new_type +='<option value=\"'+n+'\">'+ n + '</option>'; 
					}
				});
	    		
	    		 new_type +='</select></div></td>';
	    		 $(current_Tds[2]).html(new_type);
	    		 ////console.log(common_test_type);
	    		 
	    		 /* name */
	    		 var new_name ='<td><div class="form-group">';
	    		 new_name +='<input class="form-control" id="name'+editId+'" name="name"></input>';
	    		 new_name +='</div></td>';
	    		 $(current_Tds[3]).html(new_name);
	    		 $("#name"+editId).val(origin_name);
	    		 
	    		 
	    		 /* pn_sn */
	    		 var new_pn_sn ='<td><div class="form-group">';
	    		 new_pn_sn +='<input class="form-control" id="pn_sn'+editId+'" name="pn_sn"></input>';
	    		 new_pn_sn +='</div></td>';
	    		 $(current_Tds[4]).html(new_pn_sn);
	    		 $("#pn_sn"+editId).val(origin_pn_sn);
	    		 
	    		 
	    		 /* schedule */
	    		 var new_schedule ='<td><div class="form-group">';
	    		 new_schedule +='<input class="form-control" id="schedule'+editId+'" name="schedule"></input>';
	    		 new_schedule +='</div></td>';
	    		 $(current_Tds[5]).html(new_schedule);
	    		 $("#schedule"+editId).val(origin_schedule);
	    		 
	    		 
	    		/* bios_version */
	    		 var new_bios_version ='<td><div class="form-group">';
	    		 new_bios_version +='<input class="form-control" id="bios_version'+editId+'" name="bios_version"></input>';
	    		 new_bios_version +='</div></td>';
	    		 $(current_Tds[6]).html(new_bios_version);
	    		 $("#bios_version"+editId).val(origin_bios_version);
	    		 
	    		/* image_build_id */
	    		 var new_image_build_id ='<td><div class="form-group">';
	    		 new_image_build_id +='<input class="form-control" id="image_build_id'+editId+'" name="image_build_id"></input>';
	    		 new_image_build_id +='</div></td>';
	    		 $(current_Tds[7]).html(new_image_build_id);
	    		 $("#image_build_id"+editId).val(origin_image_build_id);
	    		 
	    		/* test_plan */
	    		 var new_test_plan ='<td><div class="form-group">';
	    		 new_test_plan +='<input class="form-control" id="test_plan'+editId+'" name="test_plan"></input>';
	    		 new_test_plan +='</div></td>';
	    		 $(current_Tds[8]).html(new_test_plan);
	    		 $("#test_plan"+editId).val(origin_test_plan);
	    		 
	    		/* tester */
	    		 var new_tester ='<td><div class="form-group">';
	    		 //new_tester +='<input class="form-control" id="tester'+editId+'" name="tester"></input>';
	    		 new_tester +='<input class="form-control" id="tester'+editId+'" name="tester"></input>';
	    		 new_tester +='</div></td>';
	    		 $(current_Tds[9]).html(new_tester);
	    		 $("#tester"+editId).val(origin_tester);
	    		
	    		 
	    		/* operate */    
	    		 //var new_operate = '<a class="label label-default  operate"  id="ok'+dataId+'">ok</a>';
	    		 var new_operate = '<a class="btn btn-success  operate" title="'+dataId+'" id="'+editId+'">ok</a>';
	    		 $(current_Tds[10]).html(new_operate);
	    		 //
	    		 $("#"+editId).click(function(){
	    			 var data_Id = this.title;	    			
	    			 var altered_chassis2 = $("#chassis"+this.id).val();
	  				 var altered_platform2 = $("#platform"+this.id).val();
	  				 var altered_type2 = $("#test_type"+this.id).val();
	  				 
	  				 var altered_name2 = $("#name"+this.id).val();
	  				 var altered_pn_sn2 = $("#pn_sn"+this.id).val();
	  				 
	  				 var altered_schedule2 = $("#schedule"+this.id).val();
	  				 var altered_bios_version2 = $("#bios_version"+this.id).val();	
	  				 var altered_image_build_id2 = $("#image_build_id"+this.id).val();	
	  				 var altered_test_plan2 = $("#test_plan"+this.id).val();	  				
	  				 var altered_tester2 = $("#tester"+this.id).val();		  				
	  				 ////console.log(altered_chassis2+"--;"+altered_platform2+"--;"+altered_test_type2+"--;"+altered_schedule2+"--;"+altered_bios_version2+"--;"+altered_image_build_id2+"--;"+altered_test_plan2+"--;"+altered_tester2); 
	    			 
	  				 //------------Modify database data through Ajax
	  				 var param = { commodity_id:data_Id,chassis:altered_chassis2,platform:altered_platform2,type:altered_type2,name:altered_name2,pn_sn:altered_pn_sn2,schedule:altered_schedule2,bios_version:altered_bios_version2,image_build_id:altered_image_build_id2,test_plan:altered_test_plan2,tester:altered_tester2};	
	  				 //var param = '{ "bios_id":"'+data_Id+'","chassis":"'+altered_chassis2+'"}';
	  				 //var param = '{ bios_id:"'+data_Id+'",chassis:"'+altered_chassis2+'"}';
	  				 //var param = '{ bios_id:'+data_Id+',chassis:'+altered_chassis2+'}';
	  				 //var param = {bios_id:data_Id,chassis:altered_chassis2};
	    			 $.ajax({
			 		 		url:  './record/editcommodity.action', 
			 		 		data:JSON.stringify(param),	
			 		 		type: "POST",
			 		 	   	dataType: "json",
			 		 	    contentType:'application/json',
			 		 	  	complete: function(data){			 		 	  	
			 		 			alert(data.responseText);			 		 			
			 		 		}
			 		 	});
	    			 
	    			//Revert to table mode after successful update 
	    			 /* platform */
	    			 var altered_Tds = '';
		    		 var altered_chassis_Td ='<td>'+altered_chassis2+'</td>'; 
		    		 var altered_platform_Td ='<td>'+altered_platform2+'</td>';
		    		 var altered_type_Td ='<td>'+altered_type2+'</td>';		    		 
		    		 var altered_name_Td ='<td>'+altered_name2+'</td>';
		    		 var altered_pn_sn_Td ='<td>'+altered_pn_sn2+'</td>';		    		 
		    		 var altered_schedule_Td ='<td>'+altered_schedule2+'</td>';
		    		 var altered_bios_version_Td ='<td>'+altered_bios_version2+'</td>';
		    		 var altered_image_build_id_Td ='<td>'+altered_image_build_id2+'</td>';
		    		 var altered_test_plan_Td ='<td>'+altered_test_plan2+'</td>';
		    		 var altered_tester_Td ='<td>'+altered_tester2+'</td>';		    		
		    		 var altered_operate_Td ='<td><a class="label label-info  edit" title="'+this.title+'" id="'+this.id+'">edit</a> <a class="label label-warning  delete" title="'+this.title+'" id="'+this.id+'">delete</a></td>';		    		 
		    		 altered_Tds = altered_chassis_Td+altered_platform_Td+altered_type_Td+altered_name_Td+altered_pn_sn_Td+altered_schedule_Td+altered_bios_version_Td+altered_image_build_id_Td+altered_test_plan_Td+altered_tester_Td+altered_operate_Td;
		    		 $("#tr"+editId).html(altered_Tds);
		    		 ////console.log(altered_Tds);
	  				
	    		 });
	    		 
	    		 
 			});
 			
 /*------------------delete-------------------------*/
 			$(".delete").click(function(){
 				alert('Delete function is provided later');
 			});
 			
    	}
    </script>
    
    
    <script type="text/javascript">
	  //Verify that the file meets the requirements  
	    function checkData(){  
	       var fileDir = $("#upfile").val();  
	       var suffix = fileDir.substr(fileDir.lastIndexOf("."));  
	       if("" == fileDir){  
	           alert("Select the Excel file you want to import!");  
	           return false;  
	       }  
	       if(".xlsx" != suffix ){  
	           alert("Select Excel format for file import!");  
	           return false;  
	       }  
	       return true;  
	    }   
		/* change the amount of data displayed per page, and then submit the form */
	  	$("#perPageRows").change(function(){
	  		$("#paging").submit();
	  	});
    </script>
    
   
     
    
    
    
  </body>
</html>
