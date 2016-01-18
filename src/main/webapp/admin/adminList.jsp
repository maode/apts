<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s"  uri="/struts-tags" %>
<html>
<head>
<title>管理员首页</title>
<jsp:include page="../frame/common.jsp"></jsp:include>
<script type="text/javascript">
function  edit(id){
	openIframe('<%=request.getContextPath()%>/editAdmin.action?id='+id,600,500);
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
				$.post("<%=request.getContextPath()%>/delAdmin.action",{id:id},function(data){
					if(data.code=="success"){
						window.location.replace("<%=request.getContextPath()%>/adminList.action");
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
							控制台 <small> <i class="icon-double-angle-right"></i> 操作员管理列表
							</small>
						</h1>
					</div>
					
					<div class="row">
					<div  class="col-xs-12"  style="padding-bottom: 20px;">
						<button  class="btn  btn-primary btn-sm"    onclick="openIframe('<%=request.getContextPath()%>/addAdmin.action',600,600)">
					<i class="fa fa-plus"></i>增加</button>
					</div>
					<div  class="col-xs-12">
						<form class="form-horizontal"  method="get"  action="adminList.action" >
									<div class="form-group">
										<label class="col-xs-1 control-label no-padding-right" for="form-field-1"> 登录名</label>
										<div class="col-xs-2">
											<s:textfield name="admin.username" placeholder="登录名"  cssClass="col-xs-12 "></s:textfield>
										</div>
										<label class="col-xs-1 control-label no-padding-right" for="form-field-1"> 手机号</label>
										<div class="col-xs-2">
											<s:textfield name="admin.tel" placeholder="手机号"  cssClass="col-xs-12 "></s:textfield>
										</div>
										<label class="col-xs-1 control-label no-padding-right" for="form-field-1"> 姓名</label>
										<div class="col-xs-2">
											<s:textfield name="admin.realname" placeholder="姓名"  cssClass="col-xs-12 "></s:textfield>
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
														<th>登录名</th>
														<th>电话</th>
														<th>姓名</th>
														<th>创建日期</th>
														<th>操作</th>
													</tr>
												</thead>

												<tbody>
								<s:iterator value="pager.records">
									<tr>
													<td><s:property  value="username"/></td>
														<td><s:property  value="tel"/></td>
														<td><s:property  value="realname"/></td>
														<td><s:property  value="createTime"/></td>
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
		$("#adminListUL").addClass("open").addClass("active");
		$("#adminMsgLI").addClass("active");
		</script>
</body>
</html>
