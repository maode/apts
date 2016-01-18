<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../frame/common.jsp"></jsp:include>
<jsp:include page="../frame/dateTime.jsp"></jsp:include>
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
					nalert("增加失败:服务器异常");
				},
				dataType:"json",
		        success: function(data) { // data 保存提交后返回的数据，一般为 json 数据
		        	if(data.code=="error"){
						nalert(data.msg);
					}
					else if(data.code=="success"){
						swal({   title: "提示消息!",   text: "增加成功",    showCancelButton: false, confirmButtonText: "确定",confirmButtonColor: "#3e98df"  },
								 function(isConfirm){
							 if(isConfirm){
								parent.location.reload();
							 }
						 }		 
						 );
					}else{
						nalert("增加失败：未知原因");
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
			<h4>添加活动</h4>
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
					action="addEvent.action" id="webform"
					enctype="multipart/form-data">
						<div  style="width: 100%;height: 30px;"></div>
					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-field-2"> 活动名称</label>

						<div class="col-xs-9">
							<s:textfield name="name" placeholder="活动名称"
								cssClass="col-xs-10 col-sm-5 validate[required,maxSize[100]]"></s:textfield>
						</div>
					</div>

					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-field-2"> 活动地址 </label>

						<div class="col-xs-9">
							<s:textfield name="addr" placeholder="活动地址"
								cssClass="col-xs-10 col-sm-5 validate[required,maxSize[100]]"></s:textfield>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-field-2"> 开始时间 </label>

						<div class="col-xs-9">
							<s:textfield name="beginTime" placeholder="活动开始时间"
								cssClass="col-xs-10 col-sm-5 validate[required]" id="beginTime"></s:textfield>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-field-2"> 结束时间 </label>

						<div class="col-xs-9">
							<s:textfield name="endTime" placeholder="活动结束时间"
								cssClass="col-xs-10 col-sm-5 validate[required]" id="endTime"></s:textfield>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-field-2"> 活动类型 </label>

						<div class="col-xs-9">
							<s:radio list="#{1:'普通活动',2:'导游报名' }" name="type" 
								label="活动类型" placeholder="活动类型" value="1" ></s:radio>	
						</div>
					</div>

					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-input-readonly"> 活动内容 </label>
						<div class="col-xs-9">
							<s:textarea cssClass="col-xs-10 col-sm-5 validate[maxSize[2000]]"
								name="consideration" placeholder="活动内容，注意事项等信息"></s:textarea>
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
<script type="text/javascript">
$('#beginTime').datetimepicker({
	language:  'zh-CN',
    format: 'yyyy-mm-dd hh:ii',
    autoclose: 1,
    weekStart: 1,
    todayBtn:  1
});
$('#endTime').datetimepicker({
	language:  'zh-CN',
    format: 'yyyy-mm-dd hh:ii',
    autoclose: 1,
    weekStart: 1,
    todayBtn:  1
});
</script>	
</body>
</html>