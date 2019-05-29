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
                <tr>
                  <td>1,003</td>
                  <td>libero</td>
                  <td>Sed</td>
                  <td>cursus</td>
                  <td>ante</td>
                  <td>libero</td>
                  <td>Sed</td>
                  <td>cursus</td>
                  <td>ante</td>
                  <td>1,003</td>
                </tr>
                <tr>
                  <td>1,004</td>
                  <td>dapibus</td>
                  <td>diam</td>
                  <td>Sed</td>
                  <td>nisi</td>
                  <td>dapibus</td>
                  <td>diam</td>
                  <td>Sed</td>
                  <td>nisi</td>
                  <td>1,003</td>
                </tr>
                <tr>
                  <td>1,005</td>
                  <td>Nulla</td>
                  <td>quis</td>
                  <td>sem</td>
                  <td>at</td>
                   <td>Nulla</td>
                  <td>quis</td>
                  <td>sem</td>
                  <td>at</td>
                  <td>1,003</td>
                </tr>
                <tr>
                  <td>1,006</td>
                  <td>nibh</td>
                  <td>elementum</td>
                  <td>imperdiet</td>
                  <td>Duis</td>
                   <td>nibh</td>
                  <td>elementum</td>
                  <td>imperdiet</td>
                  <td>Duis</td>
                  <td>1,003</td>
                </tr>
                <tr>
                  <td>1,007</td>
                  <td>sagittis</td>
                  <td>ipsum</td>
                  <td>Praesent</td>
                  <td>mauris</td>
                  <td>sagittis</td>
                  <td>ipsum</td>
                  <td>Praesent</td>
                  <td>mauris</td>
                  <td>1,003</td>
                </tr>
                <tr>
                  <td>1,008</td>
                  <td>Fusce</td>
                  <td>nec</td>
                  <td>tellus</td>
                  <td>sed</td>
                  <td>Fusce</td>
                  <td>nec</td>
                  <td>tellus</td>
                  <td>sed</td>
                  <td>1,003</td>
                </tr>
                <tr>
                  <td>1,009</td>
                  <td>augue</td>
                  <td>semper</td>
                  <td>porta</td>
                  <td>Mauris</td>
                  <td>augue</td>
                  <td>semper</td>
                  <td>porta</td>
                  <td>Mauris</td>
                  <td>1,003</td>
                </tr>
                <tr>
                  <td>1,010</td>
                  <td>massa</td>
                  <td>Vestibulum</td>
                  <td>lacinia</td>
                  <td>arcu</td>
                  <td>massa</td>
                  <td>Vestibulum</td>
                  <td>lacinia</td>
                  <td>arcu</td>
                  <td>1,003</td>
                </tr>
                <tr>
                  <td>1,011</td>
                  <td>eget</td>
                  <td>nulla</td>
                  <td>Class</td>
                  <td>aptent</td>
                  <td>eget</td>
                  <td>nulla</td>
                  <td>Class</td>
                  <td>aptent</td>
                  <td>1,003</td>
                </tr>
                <tr>
                  <td>1,012</td>
                  <td>taciti</td>
                  <td>sociosqu</td>
                  <td>ad</td>
                  <td>litora</td>
                  <td>taciti</td>
                  <td>sociosqu</td>
                  <td>ad</td>
                  <td>litora</td>
                  <td>1,003</td>
                </tr>
                <tr>
                  <td>1,013</td>
                  <td>torquent</td>
                  <td>per</td>
                  <td>conubia</td>
                  <td>nostra</td>
                  <td>torquent</td>
                  <td>per</td>
                  <td>conubia</td>
                  <td>nostra</td>
                  <td>1,003</td>
                </tr>
                <tr>
                  <td>1,014</td>
                  <td>per</td>
                  <td>inceptos</td>
                  <td>himenaeos</td>
                  <td>Curabitur</td>
                  <td>per</td>
                  <td>inceptos</td>
                  <td>himenaeos</td>
                  <td>Curabitur</td>
                  <td>1,003</td>
                </tr>
                <tr>
                  <td>1,015</td>
                  <td>sodales</td>
                  <td>ligula</td>
                  <td>in</td>
                  <td>libero</td>
                  <td>sodales</td>
                  <td>ligula</td>
                  <td>in</td>
                  <td>libero</td>
                  <td>1,003</td>
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
							    <tr id="trs0">
							      <td>							    
									<div class="form-group">
									    <label for="name">Weekday</label>
									    <select class="form-control" name="orderlist[0].weekday">
									      <option value="1">星期一</option>
									      <option value="2">星期二</option>
									      <option value="3">星期三</option>
									      <option value="4">星期四</option>
									      <option value="5">星期五</option>
									      <option value="6">星期六</option>
									      <option value="7">星期日</option>
									    </select>									    
  									</div>
							      </td>
							      <td>
							      	<div class="form-group">
									    <label for="name">Meal</label>
									    <select class="form-control" name="orderlist[0].type">
									      <option value="1">午餐</option>
									      <option value="2">晚餐</option>									     
									    </select>									    
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
    	date.innerHTML = DateFormat.getWeek(new Date(),DateFormat.WEEKTYPE.US_DAYNAME);
    </script>
    
    <script type="text/javascript">
    	//<a class="btn  btn-default" id ="add">add</a>
    	
    	 window.onload = function(){
    		var clicks = 0;
    		document.getElementById("add").onclick=function(){
    			clicks +=1; 
    			if(clicks>=7){
    				window.alert("一次性报餐过多");
    				return;
    			}
    			//create three <td>:WeekdayTD MealTD  DecideTD
    			/*------Wakday--------*/
    			//var WeekdayTd = document.createElement("td");    			
    			//WeekdayTd.innerHTML=('<div class="form-group"><select class="form-control" name="orderlist[clicks].weekday"><option>星期一</option><option>星期二</option><option>星期三</option><option>星期四</option><option>星期五</option><option>星期六</option><option>星期日</option></select></div>');
    			
    			
    			var WeekdayTd = document.createElement("td"); 
    			var value_name = "orderlist["+clicks+"].weekday";    		
    			var select_weekday = document.createElement("Select");
    			select_weekday.setAttribute("class","form-control");
    			select_weekday.setAttribute("name",value_name);
    			
    			//create option of weekday
    			var opt1 = document.createElement("option");
    			opt1.setAttribute("value",'1');
    			opt1.appendChild(document.createTextNode("星期一"));
    			var opt2 = document.createElement("option");
    			opt2.setAttribute("value",'2');
    			opt2.appendChild(document.createTextNode("星期二"));
    			var opt3 = document.createElement("option");
    			opt3.setAttribute("value",'3');
    			opt3.appendChild(document.createTextNode("星期三"));
    			var opt4 = document.createElement("option");
    			opt4.setAttribute("value",'4');
    			opt4.appendChild(document.createTextNode("星期四"));
    			var opt5 = document.createElement("option");
    			opt5.setAttribute("value",'5');
    			opt5.appendChild(document.createTextNode("星期五"));
    			var opt6 = document.createElement("option");
    			opt6.setAttribute("value",'6');
    			opt6.appendChild(document.createTextNode("星期六"));
    			var opt7 = document.createElement("option");
    			opt7.setAttribute("value",'7');
    			opt7.appendChild(document.createTextNode("星期日"));    			
    			
    			//added weekday option in select
    			select_weekday.appendChild(opt1);
    			select_weekday.appendChild(opt2);
    			select_weekday.appendChild(opt3);
    			select_weekday.appendChild(opt4);
    			select_weekday.appendChild(opt5);
    			select_weekday.appendChild(opt6);
    			select_weekday.appendChild(opt7);
    			
    			//create label:div
    			var div_weekday = document.createElement("div");
    			div_weekday.setAttribute("class","form-group");
    			div_weekday.appendChild(select_weekday);
    			WeekdayTd.appendChild(div_weekday);
    			
    			/*------MealTd--------*/
    			//var MealTd = document.createElement("td");
    			//MealTd.innerHTML=('<div class="form-group"><select class="form-control" name="orderlist[clicks].type"><option>午餐</option><option>晚餐</option></select></div>');
    			
    			//create labels: td  select
    			var MealTd = document.createElement("td"); 
    			var value_type = "orderlist["+clicks+"].type";   		
    			var select_type = document.createElement("Select");
    			select_type.setAttribute("class","form-control");
    			select_type.setAttribute("name",value_type);
    			//create option of eat type
    			var opt1_type = document.createElement("option");
    			opt1_type.setAttribute("value",'1');
    			opt1_type.appendChild(document.createTextNode("午餐"));
    			var opt2_type = document.createElement("option");
    			opt2_type.setAttribute("value",'2');
    			opt2_type.appendChild(document.createTextNode("晚餐"));
    			
    			//added type option in select
    			select_type.appendChild(opt1_type);
    			select_type.appendChild(opt2_type);
    			
    			//create label:div
    			var div_type = document.createElement("div");
    			div_type.setAttribute("class","form-group");
    			div_type.appendChild(select_type);
    			MealTd.appendChild(div_type);
    			
    			
    			/*------DecideTd--------*/
    			//var DecideTd = document.createElement("td");
    			//DecideTd.innerHTML=('<div class="form-group"><select class="form-control" name="orderlist[clicks].decide"><option>要吃</option><option>不吃</option></select>	</div>');
    			
    			//create labels: DecideTd  select_decide
    			var DecideTd = document.createElement("td"); 
    			var value_decide = "orderlist["+clicks+"].decide";   	
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
    			newTr.setAttribute("id","trs"+clicks);
    			//add those td into the new tr
    			newTr.appendChild(WeekdayTd);
    			newTr.appendChild(MealTd);
    			newTr.appendChild(DecideTd);
    			//get the table object
    			var mealTb = document.getElementById("mealTb");
    			mealTb.appendChild(newTr);
    		}
    		document.getElementById("cancel").onclick=function(){   
    			if(clicks=0){
    				return;
    			}
    			
    			var mealTb = document.getElementById("mealTb");
    			//get the number of tr
    			var trs = mealTb.getElementsByTagName('tr').length;    			
    			for(var i=1;i<=trs;i++){
    				var tr = document.getElementById("trs"+i);
    				mealTb.removeChild(tr);
    			}
    			clicks = 0;
    			
    		}
    	} 
    	/* window.open ("page.html", "newwindow", "height=100, width=100, top=0, left=0,toolbar=no, menubar=no, scrollbars=no, resizable=no, location=n o, status=no");  */ 
    </script>
  </body>
</html>
