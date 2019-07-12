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
       
        <div class="col-sm-9 col-sm-offset-1 col-md-10 col-md-offset-1 main">
          <h3 class="page-header">sustaining tasks record</h3>   
          

          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Chassis</th>                  
                  <th>Platform</th>
                  <th>Test Type</th>
                  <th>Start</th>
                  <th>End</th>
                  <th>Bios Version</th>
                  <th>Image Build ID</th>
                  <th>Test Plan</th>
                  <th>Tester</th>  
                  <th>Operate</th>  
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1,001</td>                  
                  <td>ipsum</td>
                  <td>dolor</td>
                  <td>sit</td>
                  <td>Lorem</td>
                  <td>ipsum</td>
                  <td>sit</td>
                  <td>Lorem</td>
                  <td>ipsum</td>  
                  <td>edit</td>                
                </tr>
                <tr>
                  <td>1,002</td>
                  <td>amet</td>
                  <td>consectetur</td>
                  <td>adipiscing</td>
                  <td>elit</td>
                  <td>consectetur</td>   
                  <td>sit</td>
                  <td>Lorem</td>
                  <td>ipsum</td>     
                  <td>edit</td>                          
                </tr>
                <tr>
                  <td>1,003</td>
                  <td>Integer</td>
                  <td>nec</td>
                  <td>odio</td>
                  <td>Praesent</td>
                  <td>Integer</td>    
                  <td>sit</td>
                  <td>Lorem</td>
                  <td>ipsum</td>   
                  <td>edit</td>                         
                </tr>
                
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div> 
    <!-- ============ -->
     <!-- new -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						BIOS pre-release
					</h4>
				</div>
				<div class="modal-body">					
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
									   	<select class="form-control" name="orderlist[0].decide">
									      <option value="1">Nicolas</option>
									      <option value="0">NesslerP</option>									     
									    </select>							    
  									</div>
							      </td>
							      <td>
							      	<div class="form-group">
									    <label for="name">Platform</label>
									    <select class="form-control" name="orderlist[0].decide">
									      <option value="1">LincsB</option>
									      <option value="0">Sunflower</option>									     
									    </select>								    
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
										 <p class="form-control" id="show_type_lunch">start date</p>
									    <input type=hidden name="orderlist[0].type" value="1"/>					    
  									</div>
							      </td>
							      <td>
							      	<div class="form-group">
									    <label for="name">End</label>									  
										 <p class="form-control" id="show_type_lunch">end date</p>
									    <input type=hidden name="orderlist[0].type" value="1"/>							    
  									</div>
							      </td>
							      <td>
							      	<div class="form-group">
									    <label for="name">BIOS Version</label>									  
										 <p class="form-control" id="show_type_lunch">B.47</p>
									    <input type=hidden name="orderlist[0].type" value="1"/>							    
  									</div>
							      </td>
							      <td>
							      	<div class="form-group">
									    <label for="name">Image Build ID</label>									  
										 <p class="form-control" id="show_type_lunch">18WW2SVT6AF</p>
									    <input type=hidden name="orderlist[0].type" value="1"/>					    
  									</div>
							      </td>
							       <td>
							      	<div class="form-group">
									    <label for="name">Test Plan</label>									  
										 <p class="form-control" id="show_type_lunch">CDT-BIOS-Checklist-v4.6-pre-test</p>
									    <input type=hidden name="orderlist[0].type" value="1"/>					    
  									</div>
							      </td>
							       <td>
							      	<div class="form-group">
									    <label for="name">Tester</label>									  
										 <p class="form-control" id="show_type_lunch">LittleBear</p>
									    <input type=hidden name="orderlist[0].type" value="1"/>					    
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
    <!-- Bios -->
    <script type="text/javascript">
    	
    </script>
    
    
    
    
   
     
    
    
    
  </body>
</html>
