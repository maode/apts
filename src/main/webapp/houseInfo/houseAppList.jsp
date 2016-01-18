<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s"  uri="/struts-tags" %>
<html>
<head>
<title>管理员首页</title>
<jsp:include page="../frame/common.jsp"></jsp:include>
<script type="text/javascript">
function  resetpass(id){
	swal({   title: "提示消息",  
		text: "确定执行该操作吗？", 
		  showCancelButton: true, 
		  cancelButtonText: "取消",
		confirmButtonColor: "#3e98df",  
		confirmButtonText: "确定", 
		},
		function(isConfirm){  
			if(isConfirm){
				$.post("<%=request.getContextPath()%>/resetPassword.action",{id:id},function(data){
						alert(data.msg);
				},"json");
			}
	 });
}
function  view(id){
	openIframe('<%=request.getContextPath()%>/view.action?id='+id,600,500);
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
				$.post("<%=request.getContextPath()%>/delUserInfo.action",{id:id,status:status},function(data){
					if(data.code=="success"){
						window.location.replace("<%=request.getContextPath()%>/userInfoAppList.action");
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
<style type="text/css">
table tr td{
height:100px;
	line-height: 100px !important;
}
</style>
</head>
<body>

<jsp:include page="../frame/top.jsp"></jsp:include>
<div class="main-container" id="main-container">
				<jsp:include page="../frame/leftmenu.jsp"></jsp:include>
			<div class="main-content">
				<div class="page-content">
					<div class="page-header">
						<h1>
							控制台 <small> <i class="icon-double-angle-right"></i> 房源管理列表
							</small>
						</h1>
					</div>
					<div class="row">
					<div  class="col-xs-12"  style="padding-bottom: 20px;">
						<a  class="btn  btn-primary btn-sm"    href="<%=request.getContextPath()%>/addHouse.action">
					<i class="fa fa-plus"></i>增加</a>
					</div>
					<div  class="col-xs-12">
						<form class="form-horizontal"  method="get"  action="userInfoList.action" >
									<div class="form-group">
										<label class="col-xs-1 control-label no-padding-right" for="form-field-1"> 标题</label>
										<div class="col-xs-2">
											<s:textfield name="userInfo.email" placeholder="邮箱"  cssClass="col-xs-12 "></s:textfield>
										</div>
										<label class="col-xs-1 control-label no-padding-right" for="form-field-1"> 省份</label>
										<div class="col-xs-2">
											<s:textfield name="userInfo.telephone" placeholder="手机号"  cssClass="col-xs-12 "></s:textfield>
										</div>
										<label class="col-xs-1 control-label no-padding-right" for="form-field-1"> 城市</label>
										<div class="col-xs-2">
											<s:textfield name="userInfo.realname" placeholder="姓名"  cssClass="col-xs-12 "></s:textfield>
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
														<th>标题</th>
														<th>发布时间</th>
														<th>地点</th>
														<th>价格</th>
														<th>房源类型</th>
														<th>房源属性</th>
														<th>发布人</th>
														<th>操作</th>
													</tr>
												</thead>

												<tbody>
								<s:iterator value="pager.records">
									<tr>
														<td><s:property  value="title"/></td>
														<td><s:property  value="createTime"/></td>
														<td><s:property  value="provice.pkey"/> <s:property  value="city.cname"/></td>
														<td><s:property  value="price"/></td>
														<td>
														<s:if test="1">
														独立房间
														</s:if>
														<s:elseif test="2">
														合住房间
														</s:elseif>
														<s:elseif test="3">
															合住房间
														</s:elseif>
														<s:else>
														未填写
														</s:else>
														</td>
														<td >
														<s:if test="status==1">
														待审核
														</s:if>
														</td>
														<td><s:property  value="houseProperty.typeName"/></td>
														<td>
														<s:if test="userInfo!=null">
														<s:property  value="userInfo.realname"/>
														</s:if>
														<s:if test="admin!=null">
														<s:property  value="admin.username"/>
														</s:if>
														</td>
														
										<td style="width: 200px !important;">
										<div  style="width: 100%;height: 40px;"></div>
											<div
												class="visible-md visible-lg hidden-sm hidden-xs btn-group">
												<button class="btn btn-xs btn-info"  onclick="edit(${id})">
													<i class="icon-edit bigger-120"></i>编辑
												</button>
												<button class="btn btn-xs btn-info"  onclick="del(${id})">
													<i class="icon-edit bigger-120"></i>删除
												</button>
												<button class="btn btn-xs btn-info"  onclick="view(${id})">
													<i class="icon-trash bigger-120"></i>查看
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
														<li><a href="#" class="tooltip-success"  onclick="view(${id})"
															data-rel="tooltip" title="Delete"> <span class="green">
																	<i class="icon-trash bigger-120"></i>
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
		$("#houseListUL").addClass("open").addClass("active");
		$("#housesappMsgLI").addClass("active");
		</script>
</body>
</html>
