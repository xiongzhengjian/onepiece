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
	<title>One Piece</title>
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
              <h3 class="masthead-brand">One Piece</h3>
              <nav>
                <ul class="nav masthead-nav">
                  <li class="active"><a href="#">Home</a></li>
                  <li><a href="#" data-toggle="modal" data-target="#myModal">Plan</a></li>
                  <li><a href="#" data-toggle="modal" data-target="#myModal">oFood</a></li>
                  <li><a  href="#" data-toggle="modal" data-target="#myModal">login</a>
				  </li>
                </ul>
              </nav>
            </div>
          </div>

          <div class="inner cover">
            <h1 class="cover-heading">Life</h1>
            <p class="lead">生活就像一盒巧克力，你永远不知道下一颗会是什么味道。</p>
            <p class="lead">Life is like a box of chocolate,you never kown what you are going to get.</p>
            <p class="lead">
              <a href="#" class="btn btn-lg btn-default" data-toggle="modal" data-target="#myModal">Let's go</a>
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
    <!-- ============================================== -->
    <!-- login模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						login
					</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form" action="./login.action" method="post">						   					
						  <div class="form-group">
						    <label for="username" class="col-sm-2 control-label">用户名</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" id="username" placeholder="请输入您的工号" name="staffid">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="password" class="col-sm-2 control-label">密码</label>
						    <div class="col-sm-10">
						      <input type="password" class="form-control" id="password" placeholder="请输入您的密码" name="password">
						    </div>
						  </div>
						  <div class="form-group">
						    <div class="col-sm-offset-2 col-sm-10">
						      <div class="checkbox">
						        <label>
						          <input type="checkbox" onclick="remember()">请记住我
						        </label>
						      </div>
						    </div>
						  </div>
						  <div class="form-group">
						    <div class="col-sm-offset-2 col-sm-10">
						      <button type="submit">登录</button>
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
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="./assets/js/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="./assets/js/jquery.min.js"><\/script>')</script>
    <script src="./assets/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./assets/js/ie10-viewport-bug-workaround.js"></script>

</body>
</html>