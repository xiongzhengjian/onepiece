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

    <title>Softpaq record</title>
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
            <li><a href="./record/commodity.action">Commodity</a></li>
            <li><a href="./record/softpaq2.action">Softpaq</a></li>
            <li><a href="./record/wat.action">WAT</a></li>
            <li><a href="./record/softrollrespin.action">Image softroll&respin</a></li>
          </ul>
           <ul class="nav nav-sidebar">
            <!-- <li><a href="./record/import.action">Import</a></li> -->
            <li><a href="./record/export.action">Export</a></li>            
          </ul>
          <form method="POST" enctype="multipart/form-data" id="form1" action="./record/import.action"">  
             <!-- <label>Import </label> -->
            <input id="upfile" type="file" name="upfile"><br>     
            <input type=hidden value="softpaq" name="category">
            <input type="submit" value="Import"  onclick="return checkData()">
    	  </form>
        
          
          
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <!-- <h4 class="page-header">Softpaq tasks record</h4>  -->         
  		 <span class="sub-header">
         	<!-- <a type="button" class="btn  btn-success btn-sm  glyphicon glyphicon-plus" href="./record/addsoftpaqdata.action"> new</a> -->
         	<a type="button" class="btn  btn-success btn-sm  glyphicon glyphicon-plus"> new</a>
		 </span>
          <div class="table-responsive">
           <form id="paging" method="post" action="./record/softpaq2pageshow.action">
            <table class="table table-condensed table-bordered">
            <caption>Softpaq Record</caption>
              <thead>
                <tr>
                  <th>Schedule</th>                  
                  <th>SP Number</th>
                  <th>SoftPAQ Title</th>
                  <th>Version</th>
                  <th>Platform</th>
                  <th>SPTest tool</th>                  
                  <th>Installation</th>
                  <th>Function</th>
                  <th>Products Sequence</th>
                  <th>Mark</th>  
                  <th>Operate</th>  
                </tr>
              </thead>
<!-- -------------------------paging------------------------------------------- -->
               <tfoot>
              	
              	<tr>
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
              			
              			<c:if test="${pagebean.totalPage>1 && pagebean.currentPage == 1}">
							<ul class="pagination">
								<c:forEach begin="${pagebean.pageRangeStart}" end="${pagebean.pageRangeEnd}" step="1" var="i">    
									<li><a href="./record/softpaq2paging.action?currentPage=${i }">${i }</a></li>
								 </c:forEach>
								 
								<li><a href="./record/softpaq2paging.action?currentPage=${pagebean.currentPage+1 }">&raquo;</a></li>
								<li><a href="./record/softpaq2paging.action?currentPage=${pagebean.totalPage }">End</a></li>
							</ul>
						 </c:if> 
						 
              			<c:if test="${pagebean.totalPage>1 && pagebean.currentPage == pagebean.totalPage}">
              				<ul class="pagination">
								<li><a href="./record/softpaq2paging.action?currentPage=1">Start</a></li>
						    	<li><a href="./record/softpaq2paging.action?currentPage=${pagebean.currentPage-1 }">&laquo;</a></li>
						    	
								<c:forEach begin="${pagebean.pageRangeStart}" end="${pagebean.pageRangeEnd}" step="1" var="i">    
								 	<li><a href="./record/softpaq2paging.action?currentPage=${i }">${i }</a></li>
	               				</c:forEach>
							</ul>
              			</c:if>
              			
              			<c:if test="${pagebean.currentPage>1 && pagebean.currentPage < pagebean.totalPage}">
              			<%-- <c:if test="${pagebean.currentPage < pagebean.totalPage}"> --%>
              				<ul class="pagination">
	              				<!-- <ul class="pager"> -->
							    <li><a href="./record/softpaq2paging.action?currentPage=1">Start</a></li>
							    <li><a href="./record/softpaq2paging.action?currentPage=${pagebean.currentPage-1 }">&laquo;</a></li>
							    
								<c:forEach begin="${pagebean.pageRangeStart}" end="${pagebean.pageRangeEnd}" step="1" var="i">    
								 	<li><a href="./record/softpaq2paging.action?currentPage=${i }">${i }</a></li>
	               				 </c:forEach>
	               				 
	               				<li><a href="./record/softpaq2paging.action?currentPage=${pagebean.currentPage+1 }">&raquo;</a></li>
							    <li><a href="./record/softpaq2paging.action?currentPage=${pagebean.totalPage }">End</a></li>
							</ul>
              			</c:if>
						
              		</td>
              		
              		<!-- show message of  Current Page and Items-->
              		<td style="text-align:center;vertical-align:middle;" colspan="1">Current Page:<a>${pagebean.currentPage}</a> &nbsp Items:<a>${pagebean.totalRows}</a></td>
      			</tr>
              </tfoot>
              <tbody>
              	<c:forEach items="${vos}" varStatus="idStatus" var="vo" > 
                	<tr id="tr${idStatus.index+0 }">               		
            			<td>${vo.schedule }</td>
            			<td>${vo.sp_number }</td>
            			<td>${vo.softpaq_title }</td>
            			<td>${vo.version }</td>
            			<td>${vo.platform }</td>
            			<td>${vo.sptest_tool_status }</td>
            			<td>${vo.installation_status }</td>
            			<td>${vo.function_status }</td>
            			<td>${vo.products_sequence }</td>
            			<td>${vo.mark }</td>            			          			
            			<td>
            				<a class="label label-default  edit" title="${vo.softpaq_id }" id="${idStatus.index+0 }">edit</a>
            				<a class="label label-default  delete" title="${vo.softpaq_id }" id="${idStatus.index+0 }">delete</a>
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
    
    
    <!-- Bios -->
    <script type="text/javascript">
    
    	window.onload = function(){
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
 				
 				var origin_schedule = current_Tds[0].innerText;
 				var origin_sp_number = current_Tds[1].innerText; 
 				var origin_softpaq_title = current_Tds[2].innerText;
 				var origin_version = current_Tds[3].innerText;
 				var origin_platform = current_Tds[4].innerText;
 				var origin_sptest_tool_status = current_Tds[5].innerText; 				
 				var origin_installation_status = current_Tds[6].innerText;
 				var origin_function_status = current_Tds[7].innerText;
 				var origin_products_sequence = current_Tds[8].innerText;
 				var origin_mark = current_Tds[9].innerText;
 				
 				////console.log(origin_chassis+"--;"+origin_platform+"--;"+origin_test_type+"--;"+origin_test_type+"--;"+origin_schedule+"--;"+origin_bios_version+"--;"+origin_image_build_id+"--;"+origin_test_plan+"--;"+origin_tester);
 				
 				/* schedule */
	    		var new_schedule_Td = '<td><div class="form-group">'; 
	    		new_schedule_Td +='<input class="form-control" id="schedule'+editId+'" name="schedule"></input>';
	    		new_schedule_Td +='</div></td>';
	    		$(current_Tds[0]).html(new_schedule_Td); 
	    		$("#schedule"+editId).val(origin_schedule);
 				
 				 /* sp_number */
	    		 var new_sp_number_Td ='<td><div class="form-group">';
	    		 new_sp_number_Td +='<input class="form-control" id="sp_number'+editId+'" name="sp_number"></input>';
	    		 new_sp_number_Td +='</div></td>';
	    		 $(current_Tds[1]).html(new_sp_number_Td);   
	    		 $("#sp_number"+editId).val(origin_sp_number);
	    		 
	    		 
	    		/*softpaq_title */	    	
	    		 var new_softpaq_title_Td ='<td><div class="form-group">';
	    		 new_softpaq_title_Td +='<input class="form-control" id="softpaq_title'+editId+'" name="softpaq_title"></input>';
	    		 new_softpaq_title_Td +='</div></td>';
	    		 $(current_Tds[2]).html(new_softpaq_title_Td);
	    		 $("#softpaq_title"+editId).val(origin_softpaq_title);
	    		 
	    		 /*version*/
	    		 var new_version_Td ='<td><div class="form-group">';
	    		 new_version_Td +='<input class="form-control" id="version'+editId+'" name="version"></input>';
	    		 new_version_Td +='</div></td>';
	    		 $(current_Tds[3]).html(new_version_Td);
	    		 $("#version"+editId).val(origin_version);
	    		 
	    		 
	    		 /* platform */
	    		 var new_platform_Td ='<td><div class="form-group">';
	    		 new_platform_Td +='<input class="form-control" id="platform'+editId+'" name="platform"></input>';
	    		 new_platform_Td +='</div></td>';
	    		 $(current_Tds[4]).html(new_platform_Td);
	    		 $("#platform"+editId).val(origin_platform);
	    		 
	    		 
	    		 
	    		 /* sptest_tool_status */
	    		 var new_sptest_tool_status_Td ='<td><div class="form-group">';
	    		 new_sptest_tool_status_Td +='<input class="form-control" id="sptest_tool_status'+editId+'" name="sptest_tool_status"></input>';
	    		 new_sptest_tool_status_Td +='</div></td>';
	    		 $(current_Tds[5]).html(new_sptest_tool_status_Td);
	    		 $("#sptest_tool_status"+editId).val(origin_sptest_tool_status);
	    		 
	    		 
	    		/* installation_status */
	    		 var new_installation_status_Td ='<td><div class="form-group">';
	    		 new_installation_status_Td +='<input class="form-control" id="installation_status'+editId+'" name="installation_status"></input>';
	    		 new_installation_status_Td +='</div></td>';
	    		 $(current_Tds[6]).html(new_installation_status_Td);
	    		 $("#installation_status"+editId).val(origin_installation_status);
	    		 
	    		/* function_status */
	    		 var new_function_status_Td ='<td><div class="form-group">';
	    		 new_function_status_Td +='<input class="form-control" id="function_status'+editId+'" name="function_status"></input>';
	    		 new_function_status_Td +='</div></td>';
	    		 $(current_Tds[7]).html(new_function_status_Td);
	    		 $("#function_status"+editId).val(origin_function_status);
	    		 
	    		/* products_sequence */
	    		 var new_products_sequence_Td ='<td><div class="form-group">';
	    		 new_products_sequence_Td +='<input class="form-control" id="products_sequence'+editId+'" name="products_sequence"></input>';
	    		 new_products_sequence_Td +='</div></td>';
	    		 $(current_Tds[8]).html(new_products_sequence_Td);
	    		 $("#products_sequence"+editId).val(origin_products_sequence);
	    		 
	    		/* mark */
	    		 var new_mark_Td ='<td><div class="form-group">';
	    		 new_mark_Td +='<input class="form-control" id="mark'+editId+'" name="mark"></input>';
	    		 new_mark_Td +='</div></td>';
	    		 $(current_Tds[9]).html(new_mark_Td);
	    		 $("#mark"+editId).val(origin_mark);
	    		
	    		 
	    		/* operate */    
	    		 //var new_operate = '<a class="label label-default  operate"  id="ok'+dataId+'">ok</a>';
	    		 var new_operate = '<a class="btn btn-success  operate" title="'+dataId+'" id="'+editId+'">ok</a>';
	    		 $(current_Tds[10]).html(new_operate);
	    		 //
	    		 $("#"+editId).click(function(){
	    			 
	    			 var data_Id = this.title;
	    			 
	  				 var altered_schedule2 = $("#schedule"+this.id).val();
	  				 var altered_sp_number2 = $("#sp_number"+this.id).val();
	  				 var altered_softpaq_title2 = $("#softpaq_title"+this.id).val();
	  				 var altered_version2 = $("#version"+this.id).val();	  				 
	  				 var altered_platform2 = $("#platform"+this.id).val();
	  				 
	    			 var altered_sptest_tool_status2 = $("#sptest_tool_status"+this.id).val();
	  				 var altered_installation_status2 = $("#installation_status"+this.id).val();	  				 
	  				 var altered_function_status2 = $("#function_status"+this.id).val();	
	  				 var altered_products_sequence2 = $("#products_sequence"+this.id).val();	
	  				 var altered_mark2 = $("#mark"+this.id).val();	  				
	  				 
	  				 ////console.log(altered_chassis2+"--;"+altered_platform2+"--;"+altered_test_type2+"--;"+altered_schedule2+"--;"+altered_bios_version2+"--;"+altered_image_build_id2+"--;"+altered_test_plan2+"--;"+altered_tester2); 
	    			 
	  				 //------------Modify database data through Ajax
	  				 var param = { softpaq_id:data_Id,schedule:altered_schedule2,sp_number:altered_sp_number2,
	  						softpaq_title:altered_softpaq_title2,version:altered_version2,
	  						platform:altered_platform2,sptest_tool_status:altered_sptest_tool_status2,
	  						installation_status:altered_installation_status2,
	  						function_status:altered_function_status2,products_sequence:altered_products_sequence2,
	  						mark:altered_mark2};	
	    			 $.ajax({
			 		 		url:  './record/editsoftpaq2.action', 
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
		    		 var altered_schedule_Td ='<td>'+altered_schedule2+'</td>'; 
		    		 var altered_sp_number_Td ='<td>'+altered_sp_number2+'</td>';
		    		 var altered_softpaq_title_Td ='<td>'+altered_softpaq_title2+'</td>';
		    		 var altered_version_Td ='<td>'+altered_version2+'</td>';	
		    		 var altered_platform_Td ='<td>'+altered_platform2+'</td>';
		    		 
		    		 
		    		 var altered_sptest_tool_status_Td ='<td>'+altered_sptest_tool_status2+'</td>';
		    		 var altered_installation_status_Td ='<td>'+altered_installation_status2+'</td>';
		    		 var altered_function_status_Td ='<td>'+altered_function_status2+'</td>';
		    		 var altered_products_sequence_Td ='<td>'+altered_products_sequence2+'</td>';
		    		 var altered_mark_Td ='<td>'+altered_mark2+'</td>';		    		
		    		 
		    		 var altered_operate_Td ='<td><a class="label label-default  edit" title="'+this.title+'" id="'+this.id+'">edit</a> <a class="label label-default  delete" title="'+this.title+'" id="'+this.id+'">delete</a></td>';		    		 
		    		 
		    		 
		    		 altered_Tds = altered_schedule_Td+
		    		 altered_sp_number_Td+		    		 
		    		 altered_softpaq_title_Td+
		    		 altered_version_Td+
		    		 altered_platform_Td+
		    		 
		    		 altered_sptest_tool_status_Td+
		    		 altered_installation_status_Td+
		    		 altered_function_status_Td+
		    		 altered_products_sequence_Td+
		    		 altered_mark_Td+
		    		 altered_operate_Td;
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
