<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../frame/common.jsp"></jsp:include>
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/assets/css/toolbar.css" />

</head>
<body>
	<div class="widget-box">
		<div class="widget-header">
			<h4>会员信息查看</h4>
			<span class="widget-toolbar"> <a href="#"
				onclick="window.location.reload()"> <i class="icon-refresh"></i>
			</a> <a href="" onclick="parent.$.fancybox.close();"> <i
					class="icon-remove"></i>
			</a>
			</span>
		</div>

		<div class="widget-body">
			<div class="widget-main">
				<form class="form-horizontal" method="post"
					action="edituserdo.action" id="webform"
					>
					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-field-2"> 用户邮箱</label>

						<div class="col-xs-9">
							<s:property  value="userInfo.email"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-field-1"> 用户姓名</label>

						<div class="col-xs-9">
							<s:property  value="userInfo.realname"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-field-1">生日</label>

						<div class="col-xs-9">
						<s:property  value="userInfo.birthday"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-field-1">性别</label>

						<div class="col-xs-9">
							<s:if test="userInfo.gender==1">
							男
							</s:if>
							<s:elseif test="userInfo.gender==2">
							女
							</s:elseif>
							<s:else>
							未填写
							</s:else>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-field-2"> 手机</label>

						<div class="col-xs-9">
							<s:property  value="userInfo.telephone"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-field-2"> 家庭住址 </label>

						<div class="col-xs-9">
							<s:property  value="userInfo.address"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-field-2"> 工作 </label>

						<div class="col-xs-9">
							<s:property  value="userInfo.job"/>
						</div>
					</div>
					

					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-input-readonly"> 学校 </label>
						<div class="col-xs-9">
							<s:property  value="userInfo.school"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-input-readonly"> 身份证照片 </label>
						<div class="col-xs-9">
							<img alt=""  style="width: 400px;height: 400px;"
										src="<%=request.getContextPath() %>/getpic.action?params=${userInfo.idcardPath}">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>