<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s"  uri="/struts-tags" %>
<html>
<head>
<title>管理员首页</title>
<jsp:include page="../frame/common.jsp"></jsp:include>
<script type="text/javascript">
function  approve(id){
	window.location.href="<%=request.getContextPath()%>/approve.action?id="+id;
}
function  view(id){
	openIframe('<%=request.getContextPath()%>/view.action?id='+id,600,500);
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
							控制台 <small> <i class="icon-double-angle-right"></i> 用户审核列表
							</small>
						</h1>
					</div>
					<div class="row">
					<div  class="col-xs-12">
						<form class="form-horizontal"  method="get"  action="userInfoAppList.action" >
									<div class="form-group">
										<label class="col-xs-1 control-label no-padding-right" for="form-field-1"> 邮箱</label>
										<div class="col-xs-2">
											<s:textfield name="userInfo.email" placeholder="邮箱"  cssClass="col-xs-12 "></s:textfield>
										</div>
										<label class="col-xs-1 control-label no-padding-right" for="form-field-1"> 手机号</label>
										<div class="col-xs-2">
											<s:textfield name="userInfo.telephone" placeholder="手机号"  cssClass="col-xs-12 "></s:textfield>
										</div>
										<label class="col-xs-1 control-label no-padding-right" for="form-field-1"> 姓名</label>
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
														<th>身份证图片</th>
														<th>邮箱</th>
														<th>电话</th>
														<th>姓名</th>
														<th>生日</th>
														<th>创建日期</th>
														<th>状态</th>
														<th>操作</th>
													</tr>
												</thead>

												<tbody>
								<s:iterator value="#list">
									<tr>
									<td  style="width: 200px;">
									<img style="height: 100px;width: 150px;" alt="" src="<%=request.getContextPath() %>/getpic.action?params=${idcardPath}">
									</td>
														<td><s:property  value="email"/></td>
														<td><s:property  value="telephone"/></td>
														<td><s:property  value="realanme"/></td>
														<td><s:property  value="birthday"/></td>
														<td><s:property  value="createTime"/></td>
														<td >
														<s:if test="status==1">
														待审核
														</s:if>
														</td>
										<td style="width: 150px !important;">
										<div  style="width: 100%;height: 40px;"></div>
											<div
												class="visible-md visible-lg hidden-sm hidden-xs btn-group">
												<button class="btn btn-xs btn-info"  onclick="approve(${id})">
													<i class="icon-edit bigger-120"></i>审核
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

														<li><a href="#" class="tooltip-success"  onclick="approve(${id})"
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
		$("#userInfoListUL").addClass("open").addClass("active");
		$("#userInfoApproveMsgLI").addClass("active");
		</script>
</body>
</html>
