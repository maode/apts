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

<script type="text/javascript">
	$(function(){
		$("#webform").validationEngine();
	})

	function subform(){
		if($("#webform").validationEngine("validate"))
		{
			$("#webform").ajaxSubmit({
				async : true,
				beforeSend:function(){
				 	// 禁用按钮防止重复提交
		        	$("button").attr({ disabled: "disabled"});
				},
				error : function(request) {
					nalert("修改失败:服务器异常");
				},
				dataType:"json",
		        success: function(data) { // data 保存提交后返回的数据，一般为 json 数据
		        	if(data.code=="error"){
						nalert(data.msg);
					}
					else if(data.code=="success"){
						swal({   title: "提示消息!",   text: "修改成功",    showCancelButton: false, confirmButtonText: "确定",confirmButtonColor: "#3e98df"  },
								 function(isConfirm){
							 if(isConfirm){
								parent.location.reload();
							 }
						 }		 
						 );
					}else{
						nalert("修改失败：未知原因");
					}
		        },
		        complete:function(){
					$("button").removeAttr("disabled");
				}
		    });
		}
	}
	
	


	
</script>
</head>
<body>
	<div class="widget-box">
		<div class="widget-header">
			<h4>修改操作员</h4>
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
					action="editAdminDo.action" id="webform"
					enctype="multipart/form-data">
					<s:hidden  name="admin.id"></s:hidden>
						<div  style="width: 100%;height: 30px;"></div>
					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-field-2"> 登陆账号</label>

						<div class="col-xs-9">
							<s:textfield name="admin.username" placeholder="用户账号"
								cssClass="col-xs-10 col-sm-5 validate[required,maxSize[100],custom[onlyLetterNumber]]"></s:textfield>
						</div>
					</div>

					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-field-2"> 操作员姓名 </label>

						<div class="col-xs-9">
							<s:textfield name="admin.realname" placeholder="用户姓名"
								cssClass="col-xs-10 col-sm-5 validate[required,maxSize[30]]"></s:textfield>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-field-2"> 操作员电话 </label>

						<div class="col-xs-9">
							<s:textfield name="admin.tel" placeholder="用户电话"
								cssClass="col-xs-10 col-sm-5 validate[maxSize[50],custom[phone]]"></s:textfield>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-field-2"> 操作员邮箱 </label>

						<div class="col-xs-9">
							<s:textfield name="admin.email" placeholder="用户邮箱"
								cssClass="col-xs-10 col-sm-5 validate[maxSize[200],custom[email]]"></s:textfield>
						</div>
					</div>

					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-input-readonly"> 职责简介 </label>
						<div class="col-xs-9">
							<s:textarea cssClass="col-xs-10 col-sm-5 validate[maxSize[200]]"
								name="admin.memo" placeholder="职责简介"></s:textarea>
						</div>
					</div>

					<div class="space-4"></div>
					<div class="clearfix form-actions">
						<div class="col-xs-offset-3 " style="margin-left: 25%;">
							<button class="btn btn-info" type="button" onclick="subform()">
								<i class="icon-ok bigger-110"></i> 提交
							</button>

							&nbsp; &nbsp; &nbsp;
							<button class="btn" type="reset">
								<i class="icon-undo bigger-110"></i> 重置
							</button>
						</div>
					</div>

				</form>


			</div>

		</div>
	</div>
</body>
</html>