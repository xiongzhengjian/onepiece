<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
          <a class="navbar-brand">oFood</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="./ofood/captain.action?user_id=${session_user.user_id }">Home</a></li>           
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
            <li><a href="#">Analytics</a></li>
            <li><a href="#">Export</a></li>
          </ul>
          <!-- <ul class="nav nav-sidebar">
            <li><a href="">Nav item</a></li>
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
            <li><a href="">More navigation</a></li>
          </ul>-->
          
          <ul class="nav nav-sidebar">
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>            
            <li><a href="">Another nav item</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Order situation</h1>

          <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="./pictures/circle.jpg" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="./pictures/circle.jpg" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="./pictures/circle.jpg" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="./pictures/circle.jpg" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
          </div>

          <h2 class="sub-header" id="current_date">Section title</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>部门代号</th>
                  <th>要吃</th>
                  <th>不吃</th>
                  <th>未决定</th>
                  <th>订餐</th>
                  <th>免订</th>
                  <th>在职</th>
                  <th>订餐</th>
                  <th>订餐率</th>
                   <th>详情</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1,001</td>
                  <td>Lorem</td>
                  <td>ipsum</td>
                  <td>dolor</td>
                  <td>sit</td>
                  <td>Lorem</td>
                  <td>ipsum</td>
                  <td>dolor</td>
                  <td>sit</td>
                  <td>sit</td>
                </tr>
                <tr>
                  <td>1,002</td>
                  <td>amet</td>
                  <td>consectetur</td>
                  <td>adipiscing</td>
                  <td>elit</td>
                  <td>consectetur</td>
                  <td>adipiscing</td>
                  <td>elit</td>
                  <td>elit</td>
                  <td>elit</td>
                </tr>
                <tr>
                  <td>1,003</td>
                  <td>Integer</td>
                  <td>nec</td>
                  <td>odio</td>
                  <td>Praesent</td>
                  <td>Integer</td>
                  <td>nec</td>
                  <td>odio</td>
                  <td>Praesent</td>
                  <td>Praesent</td>
                </tr>
                
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
    
    <!-- login模态框（Modal） -->
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
									    <input type=hidden name="orderlist[0].type" value="2"/>									    
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
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="./assets/js/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./assets/js/ie10-viewport-bug-workaround.js"></script>
    <script src="./assets/js/dateformat.js"></script>
    <!-- set element to show date -->
    <script type="text/javascript">    
    	var date = document.getElementById("current_date");    	
    	//date.innerHTML = (today.getFullYear())+"-"+(today.getMonth()+1)+"-"+today.getDate()+" "+show_day[weekday-1];    	
    	date.innerHTML = DateFormat.getWeek(new Date(),DateFormat.WEEKTYPE.ZH_DAYNAME);
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
    			console.log(clicks);
    			
    		}
    	} 
    	/* window.open ("page.html", "newwindow", "height=100, width=100, top=0, left=0,toolbar=no, menubar=no, scrollbars=no, resizable=no, location=n o, status=no");  */ 
    </script>
  </body>
</html>
