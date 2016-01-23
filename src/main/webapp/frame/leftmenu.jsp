<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="s"  uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar">
					<div class="sidebar-shortcuts" id="sidebar-shortcuts">
						<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
							<button class="btn btn-success">
								<i class="icon-signal"></i>
							</button>

							<button class="btn btn-info">
								<i class="icon-pencil"></i>
							</button>

							<button class="btn btn-warning">
								<i class="icon-group"></i>
							</button>

							<button class="btn btn-danger">
								<i class="icon-cogs"></i>
							</button>
						</div>

						<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
							<span class="btn btn-success"></span>

							<span class="btn btn-info"></span>

							<span class="btn btn-warning"></span>

							<span class="btn btn-danger"></span>
						</div>
					</div><!-- #sidebar-shortcuts -->

					<ul class="nav nav-list">
						<li >
							<a href="<%=request.getContextPath()%>/index.action">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> 主页 </span>
							</a>
						</li>
					
						<li  id="adminListUL">
							<a href="#" class="dropdown-toggle">
								<i class="icon-cogs"></i>
								<span class="menu-text"> 系统设置</span>
								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li  id="adminMsgLI">
									<a href="<%=request.getContextPath() %>/adminList.action">
										<i class="icon-double-angle-right"></i>
										管理员列表
									</a>
								</li>
								
							</ul>
						</li>
						<li  id="userInfoListUL">
							<a href="<%=request.getContextPath() %>/userInfoList.action"><!-- 添加  class="dropdown-toggle" 父级菜单的链接跳转失效 -->
								<i class="icon-cogs"></i>
								<span class="menu-text">用户管理</span>
								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li  id="userInfoMsgLI">
									<a href="<%=request.getContextPath() %>/userInfoList.action">
										<i class="icon-double-angle-right"></i>
										用户管理
									</a>
								</li>
							</ul>
						</li>
						<li  id="houseListUL">
							<a href="#" class="dropdown-toggle">
								<i class="icon-cogs"></i>
								<span class="menu-text"> 公寓管理</span>
								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li  id="housesOverviewLI">
									<a href="<%=request.getContextPath() %>/houseInfo/overview.action">
										<i class="icon-double-angle-right"></i>
										房屋概览
									</a>
								</li>
								<li  id="houseMsgLI">
									<a href="<%=request.getContextPath() %>/houseInfo/houseList.action">
										<i class="icon-double-angle-right"></i>
										房屋列表
									</a>
								</li>
								<li  id="houseMsgLI">
									<a href="<%=request.getContextPath() %>/houseInfo/generateHouse.action">
										<i class="icon-double-angle-right"></i>
										房屋添加
									</a>
								</li>
							</ul>
						</li>
						
						<li  id="huodongListUL">
							<a href="#" class="dropdown-toggle">
								<i class="icon-cogs"></i>
								<span class="menu-text"> 活动管理</span>
								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li  id="huodongMsgLI">
									<a href="<%=request.getContextPath() %>/eventList.action">
										<i class="icon-double-angle-right"></i>
										活动列表
									</a>
								</li>
								<li  id="huodongAppMsgLI">
									<a href="#">
										<i class="icon-double-angle-right"></i>
										活动统计
									</a>
								</li>
								
							</ul>
						</li>
					</ul><!-- /.nav-list -->
						<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>
				</div>
		</div>
				
</body>
</html>