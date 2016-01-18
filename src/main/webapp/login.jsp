<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib  prefix="s"  uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>登录页面 - 八号公寓管理系统</title>
		<meta name="keywords" content="八号公寓,8号公寓,公寓,租房" />
		<meta name="description" content="八号公寓,8号公寓,公寓,租房" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<jsp:include page="frame/common.jsp"></jsp:include>		
	<script type="text/javascript">
	function subform(){
		var loginId=$("#username").val();
		var password=$("#password").val();
		if(loginId==""||loginId==null){
			nalert("用户名不能为空");
			return false;
		}
		if(password==""||password==null){
			nalert("密码不能为空");
			return false;
		}
		$("#loginForm").submit();
			 $.ajax({
					type : "POST",
					url : "<%=request.getContextPath()%>/loginDo.action",
					data : $('#loginform').serialize(),
					dataType:'text',
					async : true,
					beforeSend:function(){
						 // 禁用按钮防止重复提交
				        $("#subtn").attr({ disabled: "disabled" });
					},
					error : function(request) {
						nalert("登陆失败:服务器异常");
					},
					success : function(data) {
						if(data=="success")
							window.location.href="<%=request.getContextPath()%>/index.action";
							else{
								nalert(data);
							}
					},
					complete:function(){
						 $("#subtn").removeAttr("disabled");
					}
				});
	}
	
	$(function(){
		$("input").keypress(function (e) { //这里给function一个事件参数命名为e，叫event也行，随意的，e就是IE窗口发生的事件。 
	    	var key = e.which; //e.which是按键的值 
	    	if (key == 13) { 
	    		subform();
	    	} 
	    	}); 
		
	})
	</script>
	</head>
	<body class="login-layout">
		<div class="main-container">
		<div  style="width: 100%;height: 150px;"></div>
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="icon-leaf green"></i>
									<span class="red">八号公寓</span>
									<span class="white">管理系统</span>
								</h1>
								<h4 class="blue">&copy; code0</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												请输入用户名和密码进行登陆
											</h4>

											<div class="space-6"></div>

											<form  id="loginform"  method="post"  action="">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
														<s:textfield  id="username"  name="admin.username"  cssClass="form-control  validate[required,custom[onlyLetterNumber],maxSize[30]]"  maxlength="26" placeholder="请输入用户名"></s:textfield>
															<i class="icon-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
														<s:password  id="password"  name="admin.password"  cssClass="form-control validate[required]"  maxlength="26" placeholder="请输入密码"></s:password>
															<i class="icon-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">

														<button  id="subtn" type="button" class="width-35 pull-right btn btn-sm btn-primary"  onclick="subform()">
															<i class="icon-key"></i>
															登陆
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>


										</div><!-- /widget-main -->

									</div><!-- /widget-body -->
								</div><!-- /login-box -->


							</div><!-- /position-relative -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div>
		</div><!-- /.main-container -->
</body>
</html>
