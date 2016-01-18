<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s"  uri="/struts-tags" %>
<html>
<head>
<title>活动管理</title>
<jsp:include page="../frame/common.jsp"></jsp:include>
<script type="text/javascript">
function  edit(id){
	openIframe('<%=request.getContextPath()%>/toEditEvent.action?id='+id,600,500);
}
function  del(id){
	swal({   title: "提示消息",  
		text: "确定执行该操作吗？", 
		  showCancelButton: true, 
		  cancelButtonText: "取消",
		confirmButtonColor: "#3e98df",  
		confirmButtonText: "确定", 
		},
		function(isConfirm){  
			if(isConfirm){
				$.post("<%=request.getContextPath()%>/delEvent.action",{id:id},function(data){
					if(data.code=="success"){
						window.location.replace("<%=request.getContextPath()%>/eventList.action");
					}else if(data.code=="error"){
						nalert(data.msg);
					}else{
						nalert("删除失败，原因未知");
					}
				},"json");
			}
	 });
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
							控制台 <small> <i class="icon-double-angle-right"></i> 活动管理列表
							</small>
						</h1>
					</div>
					
					<div class="row">
					<div  class="col-xs-12"  style="padding-bottom: 20px;">
						<button  class="btn  btn-primary btn-sm"    onclick="openIframe('<%=request.getContextPath()%>/toAddEvent.action',600,600)">
					<i class="fa fa-plus"></i>增加</button>
					</div>
					<div  class="col-xs-12">
						<form class="form-horizontal"  method="get"  action="adminList.action" >
									<div class="form-group">
										<label class="col-xs-1 control-label no-padding-right" for="form-field-1"> 活动名</label>
										<div class="col-xs-2">
											<s:textfield name="name" placeholder="活动名"  cssClass="col-xs-12 "></s:textfield>
										</div>
										<label class="col-xs-1 control-label no-padding-right" for="form-field-1"> 开始时间</label>
										<div class="col-xs-2">
											<s:textfield name="beginTime" placeholder="开始时间"  cssClass="col-xs-12 "></s:textfield>
										</div>
										<label class="col-xs-1 control-label no-padding-right" for="form-field-1"> 结束时间</label>
										<div class="col-xs-2">
											<s:textfield name="endTime" placeholder="结束时间"  cssClass="col-xs-12 "></s:textfield>
										</div>
										<div class="col-xs-2">
										<button class="btn btn-xs btn-info" type="submit"  >
												查询
											</button>
										</div>
									</div>
						</form>
					</div>
					
					<div  class="col-xs-12">
					<div class="table-responsive">
											<table id="sample-table-1" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th>活动名</th>
														<th>开始时间</th>
														<th>结束时间</th>
														<th>地址</th>
														<th>操作</th>
													</tr>
												</thead>

												<tbody>
								<s:iterator value="pager.records">
									<tr>
													<td><s:property  value="name"/></td>
														<td><s:property  value="beginTime"/></td>
														<td><s:property  value="endTime"/></td>
														<td><s:property  value="addr"/></td>
										<td style="width: 200px !important;">
											<div
												class="visible-md visible-lg hidden-sm hidden-xs btn-group">
												<button class="btn btn-xs btn-info"  onclick="edit(${id})">
													<i class="icon-edit bigger-120"></i>修改
												</button>
												<button class="btn btn-xs btn-info"  onclick="del(${id})">
													<i class="icon-edit bigger-120"></i>删除
												</button>
											</div>

											<div class="visible-xs visible-sm hidden-md hidden-lg">
												<div class="inline position-relative">
													<button class="btn btn-minier btn-primary dropdown-toggle"
														data-toggle="dropdown">
														<i class="icon-cog icon-only bigger-110"></i>
													</button>

													<ul
														class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">

														<li><a href="#" class="tooltip-success"  onclick="edit(${id})"
															data-rel="tooltip" title="Edit"> <span class="green">
																	<i class="icon-edit bigger-120"></i>
															</span>
														</a></li>
														<li><a href="#" class="tooltip-success"  onclick="del(${id})"
															data-rel="tooltip" title="Edit"> <span class="green">
																	<i class="icon-edit bigger-120"></i>
															</span>
														</a></li>
													</ul>
												</div>
											</div>
										</td>
									</tr>
								</s:iterator>

							</tbody>
											</table>
										</div><!-- /.table-responsive -->
					</div>
					<jsp:include page="../frame/page.jsp"></jsp:include>
					</div>
					
					<!-- /.page-header -->
				</div>
			</div>
			</div>
			<script type="text/javascript">
		$("#huodongListUL").addClass("open").addClass("active");
		$("#huodongMsgLI").addClass("active");
		</script>
</body>
</html>
