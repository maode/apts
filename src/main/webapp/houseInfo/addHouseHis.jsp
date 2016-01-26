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
<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/toolbar.css" />

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
					nalert("操作失败:服务器异常");
				},
				dataType:"json",
		        success: function(data) { // data 保存提交后返回的数据，一般为 json 数据
		        	if(data.code=="error"){
						nalert(data.msg);
					}
					else if(data.code=="success"){
						swal({   title: "操作成功!",    showCancelButton: false, confirmButtonText: "确定",confirmButtonColor: "#3e98df"  },
								 function(isConfirm){
							 if(isConfirm){
								parent.refreshAptData();
								parent.$.fancybox.close();
							 }
						 }		 
						 );
					}else{
						nalert("操作失败：未知原因");
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
			<h4>房屋出租</h4>
			<span class="widget-toolbar"> 
			<a href="#" onclick="window.location.reload()"> 
				<i class="icon-refresh"></i>
			</a> 
			<a href="" onclick="parent.$.fancybox.close();"> 
				<i class="icon-remove"></i>
			</a>
			</span>
		</div>
	
		<div class="widget-body">
			<div class="widget-main">
				<s:form cssClass="form-horizontal" theme="simple" method="post"
					action="addHouseHis.action" id="webform">
					<s:hidden name="houseInfo.id" />
					<div  style="width: 100%;height: 30px;"></div>
					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-field-2"> 租客姓名</label>

						<div class="col-xs-9">
							<s:textfield name="renterName"  placeholder="如：张三 *必填"
								cssClass="col-xs-10 col-sm-5 validate[required,maxSize[30]]"></s:textfield>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-field-2"> 租客电话 </label>

						<div class="col-xs-9">
							<s:textfield name="telephone" placeholder="租房人的手机号 *必填"
								cssClass="col-xs-10 col-sm-5 validate[maxSize[50],custom[phone]]"></s:textfield>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-field-2"> 入住时间 </label>

						<div class="col-xs-9">
							<s:textfield readonly="readonly" id="beginTime" name="beginTime" placeholder="入住时间 *必填"
								cssClass="col-xs-10 col-sm-5 validate[required]">
								<s:param name="value"><s:date name="beginTime" format="yyyy-MM-dd"/></s:param>
							</s:textfield>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-field-2"> 搬离时间 </label>

						<div class="col-xs-9">
							<s:textfield readonly="readonly" id="endTime" name="endTime" placeholder="搬离时间 *必填"
								cssClass="col-xs-10 col-sm-5 validate[required]">
								<s:param name="value"><s:date name="endTime" format="yyyy-MM-dd"/></s:param>
							</s:textfield>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-field-2"> 付款方式 </label>

						<div class="col-xs-9">
							<s:textfield name="payment" placeholder="如：押一付一 *必填"
								cssClass="col-xs-10 col-sm-5 validate[required]"></s:textfield>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label no-padding-right"
							for="form-input-readonly"> 备注事项 </label>
						<div class="col-xs-9">
							<s:textarea cssClass="col-xs-10 col-sm-5 validate[maxSize[200]]"
								name="memo" placeholder="其它需要额外说明的事情，请写在这里。*可以不填"></s:textarea>
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

				</s:form>


			</div>

		</div>
	</div>
<script type="text/javascript">
$('#beginTime').datetimepicker({
	language:  'zh-CN',
	minView: "month",
    format: 'yyyy-mm-dd',
    autoclose: 1,
    weekStart: 1,
    todayBtn:  1
});
$('#endTime').datetimepicker({
	language:  'zh-CN',
	minView: "month",
    format: 'yyyy-mm-dd',
    autoclose: 1,
    weekStart: 1,
    todayBtn:  1
});
</script>
</body>
</html>