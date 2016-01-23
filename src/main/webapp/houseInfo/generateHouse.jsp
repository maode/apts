<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../frame/common.jsp"></jsp:include>
<link rel="stylesheet" href="http://cache.amap.com/lbs/static/main.css" />
<script type="text/javascript">

	function subform() {
		var tishi="创建完成";
		if ($("#webform").validationEngine("validate")) {
			$("#webform").ajaxSubmit({
				async : true,
				beforeSend : function() {
					// 禁用按钮防止重复提交
					$("button").attr({
						disabled : "disabled"
					});
				},
				error : function(request) {
					nalert("增加失败:服务器异常");
				},
				dataType : "json",
				success : function(data) { // data 保存提交后返回的数据，一般为 json 数据
					if (data.code == "error") {
						nalert(data.msg);
					} else if (data.code == "success") {
						swal({
							title : "提示消息!",
							text : tishi,
							showCancelButton : false,
							confirmButtonText : "确定",
							confirmButtonColor : "#3e98df"
						}, function(isConfirm) {
							if (isConfirm) {
								//parent.location.reload();
							}
						});
					} else {
						nalert("增加失败：未知原因");
					}
				},
				complete : function() {
					$("button").removeAttr("disabled");
				}
			});
		}
	}
</script>
</head>
<body>
	<jsp:include page="../frame/top.jsp"></jsp:include>
	<div class="main-container" id="main-container">
		<jsp:include page="../frame/leftmenu.jsp"></jsp:include>
		<div class="main-content">
			<div class="page-content">
				<div class="page-header">
					<h1>
						公寓管理 <small> <i class="icon-double-angle-right"></i> 房屋添加
						</small>
					</h1>
				</div>
				<div class="page-body" >
					<form class="form-horizontal" method="post"
						action="generateHouseDo.action" id="webform"
						enctype="multipart/form-data">
						<div class="form-group">
							<label class="col-md-1 control-label no-padding-right"> 楼号</label>
							<div class="col-md-1">
								<s:select list="#{1:'1号楼',2:'2号楼',3:'3号楼' }" name="houseGenerate.aptNum"></s:select>
							</div>
							<label class="col-md-1 control-label no-padding-right"> 楼层数</label>
							<div class="col-md-1">
								<s:textfield name="houseGenerate.floorTotal" value="6"
									cssClass="col-xs-10   validate[required,maxSize[50]]" ></s:textfield>
							</div>
							<label class="col-md-1 control-label no-padding-right"> 每层房间数</label>
							<div class="col-md-1">
								<s:textfield name="houseGenerate.houseTotal" value="30"
									cssClass="col-xs-10   validate[required,maxSize[50]]" ></s:textfield>
							</div>
							<label class="col-md-1 control-label no-padding-right"> 默认规格</label>
							<div class="col-md-1">
								<s:select list="#{1:'大套间',2:'中套间',3:'小套间' }" name="houseGenerate.houseTypeId"></s:select>
							</div>
						</div>
						<div class="clearfix form-actions">
							<div class="col-xs-offset-3 " style="margin-left: 25%;">
								<button class="btn btn-info" type="button" onclick="subform()">
									<i class="icon-ok bigger-110"></i> 创建
								</button>

								<button class="btn" type="reset">
									<i class="icon-undo bigger-110"></i> 重置
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$("#InfoNewsList").addClass("open").addClass("active");
		$("#InfoNewsPubMsg").addClass("active");
	</script>
</body>
</html>