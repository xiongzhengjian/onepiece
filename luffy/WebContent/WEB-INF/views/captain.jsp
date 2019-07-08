<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="for 1stq00">
	<meta name="author" content="littlebear">
	<title>Captain</title>
	<%
		String path = request.getContextPath(); //path="/luffy"
		//  basePath="http://localhost:8080/luffy/"
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
	<style type="text/css">
		
	</style>
	<base href="<%=basePath%>">
	<link rel="icon" href="./icon/favicon.ico">
	<!-- Bootstrap core CSS -->
    <link href="./assets/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="./assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./assets/css/cover.css" rel="stylesheet">

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
	 <div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <h3 data-toggle="modal" data-target="#editModal" class="masthead-brand">
              	${session_user.enname }
              </h3>
              <%-- <h3 class="masthead-brand">
              	${session_user.enname }
              </h3> --%>
             
              <nav>
                <ul class="nav masthead-nav">
                  <li class="active"><li><a href="./logout.action">Logout</a></li> 
                  <li><a>OT</a></li>
                  <li><a href="ofood/oFood.action">oFood</a></li>                  
                </ul>
              </nav>
            </div>
          </div>

          <div class="inner cover">
            <h1 class="cover-heading">Life</h1>
            <p class="lead">生活就像一盒巧克力，你永远不知道下一颗会是什么味道。</p>
            <p class="lead">You've been at Wistron for <b class="label-default">${DandY.days }</b> days <b class="label-default">${DandY.years }</b> years</p>
            <p class="lead">
              <a href="./grandline.action" class="btn btn-lg btn-default">Let's go</a>
            </p>
          </div>

          <div class="mastfoot">
            <div class="inner">
              <p>Cover template for <a href="#http://getbootstrap.com">Wistron(CQ)</a>, by <a href="#https://twitter.com/mdo">WCQ@1STQ10</a>.</p>
            </div>
          </div>

        </div>

      </div>
    </div>
    <!-- =======================edit======================= -->
   	<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<!-- <h4 style="color: rgb(0, 0, 0);" class="modal-title" id="myModalLabel"> -->
					<h4 class="modal-title" id="myModalLabel">
						修改您的信息
					</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form" action="./edit.action" method="post">
						  <div class="form-group">
						    <label for="username" class="col-sm-2 control-label">姓名</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" id="name" placeholder="请输入您的姓名" name="name">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="username" class="col-sm-2 control-label">英文名</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" id="enname" placeholder="请输入您的英文名" name="enname">
						    </div>
						  </div>					   					
						  <div class="form-group">
						    <label for="username" class="col-sm-2 control-label">原始密码</label>
						    <div class="col-sm-10">
						      <input type="password" class="form-control" id="originpassword" placeholder="请输入您的原始密码" name="originPassword">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="password" class="col-sm-2 control-label">新密码</label>
						    <div class="col-sm-10">
						      <input type="password" class="form-control" id="password" placeholder="请输入您的新密码" name="password">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="password" class="col-sm-2 control-label">邮箱</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" id="email" placeholder="请输入您的邮箱" name="email">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="password" class="col-sm-2 control-label">入职日期</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" id="hireDate" placeholder="2017-10-17" name="hireDate">
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <div class="col-sm-offset-2 col-sm-10">
						      <button type="submit">保存</button>
						    </div>
						  </div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button"  data-dismiss="modal">取消
					</button>
					<!-- <button type="button" class="btn btn-primary">
						ok
					</button> -->
				</div>
			</div>
		</div>
	</div>
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="./assets/js/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="./../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="./assets/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./assets/js/ie10-viewport-bug-workaround.js"></script>
    
    <script type="text/javascript">
    	$(document).ready(function(){
    		 $.ajax({
	 		 		url:  './getUser.action', 
	 		 		data:"{t:"+new Date().getTime()+"}",	
	 		 		type: "POST",
	 		 	   	dataType: "json",
	 		 	    contentType:'application/json',
	 		 	  	complete: function(data){			 		 	  	
	 		 			//console.log(data.responseJSON);
	 		 			var user = data.responseJSON;
	 		 			$("#name").val(user.name);
	 		 			$("#enname").val(user.enname);
	 		 			$("#email").val(user.email);
	 		 			$("#hireDate").val(user.hireDate);
	 		 		}
	 		 	});
    	});
    </script>

</body>
</html>