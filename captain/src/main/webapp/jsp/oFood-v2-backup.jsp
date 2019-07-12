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
          <a class="navbar-brand">oFood</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="./home.action">Home</a></li>           
            <li><a >Hi! ${session_user.name }</a></li>
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
            <li class="active"><a>Overview <span class="sr-only">(current)</span></a></li>
            <li><a  href="#" data-toggle="modal" data-target="#myModal">Order meal</a></li>
            <li><a href="./ofood/personal.action">Personal</a></li>
            <li><a>Export</a></li>
          </ul>
          
          
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Order Situation</h1>

          <div class="row placeholders">
            <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
   			 <div id="main" style="width: 1200px;height:400px;"></div>           
          </div>
          <table class="table table-condensed table-hover">
            <caption>总览</caption>
              <thead>
                <tr>
                  <th>部门</th>
                  <th>报餐率</th>
                </tr>
              </thead>
              <tbody>
              	 <tr>
                  <td>1STC00</td>
                  <td>50%</td>
                </tr>
                <tr>
                  <td>1STQ00</td>
                  <td>30%</td>
                </tr>
              </tbody>
           </table>
          

         <!--  <div class="table-responsive"> -->
            <table class="table table-condensed table-hover">
            <caption>未报餐详情</caption>
              <thead>
                <tr>
                  <th>No</th>                  
                  <!-- <th>site</th> -->
                  <th>Department</th>
                  <th>Name</th>
                  <th>EmployeeID</th>                  
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${nomealstatusUsers}" varStatus="idStatus" var="vo" >
              		<tr>               		
            			<td>${idStatus.index+0 }</td> 
            			<td>${vo.department }</td>
            			<td>${vo.name }</td>
            			<td>${vo.staffid }</td>
        			</tr>  
              	</c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      <!-- </div> -->
    </div>
    
    <!-- login（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						order a meal
					</h4>
				</div>
				<div class="modal-body">					
				      <form class="form-signin" action="./ofood/ordermeal.action" method="post">				      				      	
				        <table class="table table-striped">
						  <caption>Please make your decision</caption>							
						  	<tbody id="mealTb">
						  		<!-- =============lunch============ -->
							    <tr id="trs0">
							      <td>							    
									<div class="form-group">
									    <label for="name">Weekday</label>
									    <!-- <select class="form-control" name="orderlist[0].weekday"></select>	 -->
									   	<p class="form-control" id="show_weekday_lunch">today</p>
									   	<input type=hidden name="orderlist[0].weekday" id="today_weekday_lunch" value=""/>					    
  									</div>
							      </td>
							      <td>
							      	<div class="form-group">
									    <label for="name">Meal</label>
									    <p class="form-control" id="show_type_lunch">午餐</p>
									    <input type=hidden name="orderlist[0].type" value="1"/>								    
  									</div>
							      </td>
							      <td>
							      	<div class="form-group">
									    <label for="name">Decide</label>									  
										<select class="form-control" name="orderlist[0].decide">
									      <option value="1">要吃</option>
									      <option value="0">不吃</option>									     
									    </select>						    
  									</div>
							      </td>
							    </tr>
							    <!-- =============dinner============ -->
							    <tr id="trs1">
							      <td>							    
									<div class="form-group">									   
									    <!-- <select class="form-control" name="orderlist[0].weekday"></select>	 -->
									   	<p class="form-control" id="show_weekday_dinner">today</p>
									   	<input type=hidden name="orderlist[1].weekday" id="today_weekday_dinner" value=""/>					    
  									</div>
							      </td>
							      <td>
							      	<div class="form-group">									    
									    <p class="form-control" id="show_type_lunch">晚餐</p>
									    <input type=hidden name="orderlist[1].type" value="2"/>									    
  									</div>
							      </td>
							      <td>
							      	<div class="form-group">									   									  
										<select class="form-control" name="orderlist[1].decide">
									      <option value="1">要吃</option>
									      <option value="0">不吃</option>									     
									    </select>						    
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
				        <!-- <div style="float:right;" class="form-group">
				          <button class="btn  btn-default" id ="add">add</button>
				        </div> -->   				
				</div>
				<div class="modal-footer">
					<button type="button"  data-dismiss="modal" id="cancel">cancel
					</button>
					<!-- <button type="button" class="btn btn-primary">
						ok
					</button> -->
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
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
    <!-- set element to show date -->
    <script type="text/javascript">    
    	/* var date = document.getElementById("current_date");    	    	    	
    	date.innerHTML = DateFormat.getWeek(new Date(),DateFormat.WEEKTYPE.ZH_DAYNAME); */
    </script>
    
    <script type="text/javascript">
    	//<a class="btn  btn-default" id ="add">add</a>
    	
    	 window.onload = function(){	    		
    		 
    		/* init today */
    		document.getElementById("show_weekday_lunch").innerHTML= DateFormat.getWeek(new Date(),DateFormat.WEEKTYPE.ZH_DAYNAME);
    		document.getElementById("today_weekday_lunch").value=DateFormat.format(new Date() , 'yyyy-MM-dd hh:mm:ss'); 
    		document.getElementById("show_weekday_dinner").innerHTML= DateFormat.getWeek(new Date(),DateFormat.WEEKTYPE.ZH_DAYNAME);
    		document.getElementById("today_weekday_dinner").value=DateFormat.format(new Date() , 'yyyy-MM-dd hh:mm:ss');
    		/*add meal*/
    		var clicks = 0;
    		//use this varible to recorde index of data:  orderlist[index].weekday
    		var index = 1;    		
    		document.getElementById("add").onclick=function(){
    			clicks +=1;     			
    			if(clicks>=7){
    				window.alert("一次报餐不超过一周");
    				return;
    			}
    			//a single click should create two items which include lunch and dinner
    			for(var y=1;y<=2;y++){
    				index +=1;
    				//create three <td>:WeekdayTD MealTD  DecideTD
        			
        			/*------Weekday--------*/ 			
        			
        			
        			 /* <!-- <select class="form-control" name="orderlist[0].weekday"></select>	 --> */
    				 /* <p class="form-control" id="show_weekday">today</p> */
    				 /*<input type=hidden name="orderlist[1].weekday" id="today_weekday_dinner" value=""/>	*/
        			
        			var WeekdayTd = document.createElement("td"); 
        			//create show_weekday label
        			var show_weekday = document.createElement("p");
        			show_weekday.setAttribute("class","form-control");
        			show_weekday.innerHTML=DateFormat.getWeek(DateFormat.addDay(new Date(), clicks),DateFormat.WEEKTYPE.ZH_DAYNAME);    			
        			var value_weekday = "orderlist["+index+"].weekday";		
        			//create hidden input label:<input type=hidden name="orderlist[0].weekday" value=""/>    			
        			var next_weekday = document.createElement("input");
        			next_weekday.setAttribute("type","hidden");
        			next_weekday.setAttribute("name",value_weekday);
        			next_weekday.value=DateFormat.format(DateFormat.addDay(new Date(), clicks) , 'yyyy-MM-dd hh:mm:ss')
        			
        			//create label:div
        			var div_weekday = document.createElement("div");
        			div_weekday.setAttribute("class","form-group");
        			div_weekday.appendChild(show_weekday);
        			div_weekday.appendChild(next_weekday);
        			WeekdayTd.appendChild(div_weekday);
        			
        			/*------MealTd--------*/
        			//var MealTd = document.createElement("td");
        			//MealTd.innerHTML=('<div class="form-group"><select class="form-control" name="orderlist[clicks].type"><option>午餐</option><option>晚餐</option></select></div>');
        			
        			//create labels: td  select
        			var MealTd = document.createElement("td"); 
        			var value_type = "orderlist["+index+"].type"; 
        			//create show_mealType
        			var show_mealType = document.createElement("p");        			
        			show_mealType.setAttribute("class","form-control");
        			//add if condition to judge
        			if(y==1){
        			show_mealType.innerHTML='午餐';        				
        			}
        			else{
        				show_mealType.innerHTML='晚餐';
        			}
        			//create hidden input label:<input type=hidden name="orderlist[0].type" value=""/>    
        			var next_mealType = document.createElement("input");
        			next_mealType.setAttribute("type","hidden");
        			next_mealType.setAttribute("name",value_type);
        			next_mealType.value=y;        			
        			
        			
        			//create label:div 
        			var div_type = document.createElement("div");
        			div_type.setAttribute("class","form-group");
        			div_type.appendChild(show_mealType);
        			div_type.appendChild(next_mealType);
        			MealTd.appendChild(div_type);
        			
        			
        			/*------DecideTd--------*/
        			//var DecideTd = document.createElement("td");
        			//DecideTd.innerHTML=('<div class="form-group"><select class="form-control" name="orderlist[clicks].decide"><option>要吃</option><option>不吃</option></select>	</div>');
        			
        			//create labels: DecideTd  select_decide
        			var DecideTd = document.createElement("td"); 
        			var value_decide = "orderlist["+index+"].decide";   	
        			var select_decide = document.createElement("Select");
        			select_decide.setAttribute("class","form-control");
        			select_decide.setAttribute("name",value_decide);
        			//create option of decide
        			var opt1_decide = document.createElement("option");
        			opt1_decide.setAttribute("value",'1');
        			opt1_decide.appendChild(document.createTextNode("要吃"));
        			var opt2_decide = document.createElement("option");
        			opt2_decide.setAttribute("value",'0');
        			opt2_decide.appendChild(document.createTextNode("不吃"));
        			
        			//added decide option in select
        			select_decide.appendChild(opt1_decide);
        			select_decide.appendChild(opt2_decide);
        			
        			//create label:div
        			var div_decide = document.createElement("div");
        			div_decide.setAttribute("class","form-group");
        			div_decide.appendChild(select_decide);
        			DecideTd.appendChild(div_decide);
        			
        			
        			
        			/*------create one <tr>--------*/
        			var newTr = document.createElement("tr");
        			//added a attribut for the new tr
        			newTr.setAttribute("id","trs"+index);
        			//add those td into the new tr
        			newTr.appendChild(WeekdayTd);
        			newTr.appendChild(MealTd);
        			newTr.appendChild(DecideTd);
        			//get the table object
        			var mealTb = document.getElementById("mealTb");
        			mealTb.appendChild(newTr);
    			}
    		}
    		/*cancel and delete trs that is for add*/
    		document.getElementById("cancel").onclick=function(){   
    			if(clicks=0){
    				return;
    			}    			
    			var mealTb = document.getElementById("mealTb");
    			//get the number of tr
    			var trs = mealTb.getElementsByTagName('tr').length;
    			var loop_trs_count = trs-1;
    			//note:i>=2 ,because one day include lunch and dinner
    			for(var i=loop_trs_count;i>=2;i--){
    				var tr_id = "trs"+i;    				
    				var tr_to_delete = document.getElementById(tr_id);
    				mealTb.removeChild(tr_to_delete);    
    				//tr_parent=tr_to_delete.parentNode;
    				//tr_parent.removeChild(tr_to_delete);
    			}
    			clicks = 0;
    			index=1;
    			//console.log(clicks);
    			
    		}
    	/* window.open ("page.html", "newwindow", "height=100, width=100, top=0, left=0,toolbar=no, menubar=no, scrollbars=no, resizable=no, location=n o, status=no");  */ 
    		
     		
        	 
    	    
    	 /* // init echarts instance
        	var myChart = echarts.init(document.getElementById('main'));
    	    // 使用刚指定的配置项和数据显示图表。
    	    myChart.setOption(option);   */
    	} 
    	
    	
    </script>
    
   
     <!--  Overview Echart -->
    <script type="text/javascript">
 		$(document).ready(function(){
 			$.ajax({ 
 		 	   url:  './ofood/ordersituation.action',
 		 	   data: "{t:"+new Date().getTime()+"}",
 		 	   type: "POST",
 		 	   dataType: "json",
 		 	   contentType:'application/json',
 		 	   complete: function(data){		 		
 		 		 var situationData = data.responseText;
 		 		 var obj_situationData = JSON.parse(situationData);		 		 
 		 		 var listorderSituation = obj_situationData.listorderSituation;
 		 		 //var nomealstatusUsers = obj_situationData.nomealstatusUsers;
/* ----------Echart config Start */
 		 		 var posList = [
		     	    'left', 'right', 'top', 'bottom',
		     	    'inside',
		     	    'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
		     	    'insideTopLeft', 'insideTopRight', 'insideBottomLeft', 'insideBottomRight'
		     	];

		     	var configParameters = {
		     	    rotate: {
		     	        min: -90,
		     	        max: 90
		     	    },
		     	    align: {
		     	        options: {
		     	            left: 'left',
		     	            center: 'center',
		     	            right: 'right'
		     	        }
		     	    },
		     	    verticalAlign: {
		     	        options: {
		     	            top: 'top',
		     	            middle: 'middle',
		     	            bottom: 'bottom'
		     	        }
		     	    },
		     	    position: {
		     	        options: echarts.util.reduce(posList, function (map, pos) {
		     	            map[pos] = pos;
		     	            return map;
		     	        }, {})
		     	    },
		     	    distance: {
		     	        min: 0,
		     	        max: 100
		     	    }
		     	};
		
		     	var config = {
		     	    rotate: 90,
		     	    align: 'left',
		     	    verticalAlign: 'middle',
		     	    position: 'insideBottom',
		     	    distance: 15,
		     	    onChange: function () {
		     	        var labelOption = {
		     	            normal: {
		     	                rotate: config.rotate,
		     	                align: config.align,
		     	                verticalAlign: config.verticalAlign,
		     	                position: config.position,
		     	                distance: config.distance
		     	            }
		     	        };
		     	        myChart.setOption({
		     	            series: [{
		     	                label: labelOption
		     	            }, {
		     	                label: labelOption
		     	            }, {
		     	                label: labelOption
		     	            }, {
		     	                label: labelOption
		     	            }]
		     	        });
		     	    }
		     	};
		
		
		     	var labelOption = {
		     	    normal: {
		     	        show: true,
		     	        position: config.position,
		     	        distance: config.distance,
		     	        align: config.align,
		     	        verticalAlign: config.verticalAlign,
		     	        rotate: config.rotate,
		     	        formatter: '{c}  {name|{a}}',
		     	        fontSize: 10,
		     	        rich: {
		     	            name: {
		     	                textBorderColor: '#fff'
		     	            }
		     	        }
		     	    }
		     	};
				//ffd966  e5323e  4cabce  003366   ff9900
		     	var option = {
		     	    color: ['#000000', '#00ff00', '#ff0000','#003366'],
		     	    tooltip: {
		     	        trigger: 'axis',
		     	        axisPointer: {
		     	            type: 'shadow'
		     	        }
		     	    },
		     	    legend: {
		     	        data: ['人数', '已报餐', '未报餐', '报餐率'] 
		     	    },
		     	    toolbox: {
		     	        show: true,
		     	        orient: 'vertical',
		     	        left: 'right',
		     	        top: 'center',
		     	        feature: {
		     	            mark: {show: true},
		     	            dataView: {show: true, readOnly: false},
		     	            magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
		     	            restore: {show: true},
		     	            saveAsImage: {show: true}
		     	        }
		     	    },
		     	    calculable: true,
		     	    xAxis: [
		     	        {
		     	            type: 'category',
		     	            axisTick: {show: false},
		     	            data: []
		     	        }
		     	    ],
		     	    yAxis: [
		     	        {
		     	            type: 'value'
		     	        }
		     	    ],
		     	    series: [
		     	        {
		     	            name: '人数',
		     	            type: 'bar',
		     	            barGap: 0,
		     	            label: labelOption,
		     	            data: []
		     	        },
		     	        {
		     	            name: '已报餐',
		     	            type: 'bar',
		     	            label: labelOption,
		     	            data: [] 
		     	        },
		     	        {
		     	            name: '未报餐',
		     	            type: 'bar',
		     	            label: labelOption,
		     	            data: [] 
		     	        },
		     	        {
		     	            name: '报餐率',
		     	            type: 'bar',
		     	            label: labelOption,
		     	            data: []
		     	        }
		     	        
		     	    ]
		     	};
     	
/* ----------Echart config  End */
 	 			//Deal with the Order situation
 	 			console.log(listorderSituation);
 	 			/* console.log(option.xAxis[0].data[1]);
 	 			console.log(option.series[0].data[1]);
 	 			console.log(option.series[1].data[1]);
 	 			console.log(option.series[2].data[1]);
 	 			console.log(option.series[3].data[1]); */
 		 		var data_size = listorderSituation.length;
 	 			option.xAxis[0].data=new Array(data_size); 
 	 			option.series[0].data=new Array(data_size);
 	 			option.series[1].data=new Array(data_size);
 	 			option.series[2].data=new Array(data_size);
 	 			option.series[3].data=new Array(data_size);
 	 			 for(var n=0;n<data_size;n++){
 	 				option.xAxis[0].data[n]=listorderSituation[n].dept;
 	 				option.series[0].data[n] = listorderSituation[n].employeesNum;
 	 				option.series[1].data[n] = listorderSituation[n].orderedNum;
 	 				option.series[2].data[n] = listorderSituation[n].notOrderedNum;
 	 			    option.series[3].data[n] = listorderSituation[n].orderRate;
 	 			    
 	 			    
 	 				
 	 				//console.log(listorderSituation[n].dept+";"+listorderSituation[n].employeesNum+";"+listorderSituation[n].orderedNum+";"+listorderSituation[n].notOrderedNum+";"+listorderSituation[n].orderRate);
 	 				//console.log("==="+option.xAxis[0].data[n]+";"+option.series[0].data[n]+";"+option.series[1].data[n]+";"+option.series[2].data[n]+";"+option.series[3].data[n]);
 	 				
 	 				} 
 	 			 // init echarts instance
 	         	var myChart = echarts.init(document.getElementById('main'));
 	     	    // Display the chart with the configuration items and data you just specified
 	     	    myChart.setOption(option); 
 	 			}//---->End: ajax complete
 	 	   
 	 	   		});
 		});
 		
    	 
	 
    </script>
    
    
  </body>
</html>
