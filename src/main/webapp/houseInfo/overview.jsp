<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s"  uri="/struts-tags" %>
<html>
<head>
<title>管理员首页</title>
<jsp:include page="../frame/common.jsp"></jsp:include>
<script type="text/javascript">

</script>
<style type="text/css">
.btn{
	margin-bottom:2px;
}
</style>
</head>
<body>

<jsp:include page="../frame/top.jsp"></jsp:include>
<div class="main-container" id="main-container">
			<jsp:include page="../frame/leftmenu.jsp"></jsp:include>
			<div class="main-content">
				<div class="page-content">
					<!-- head S -->
					<div class="page-header">
						<h1>
							控制台 <small> <i class="icon-double-angle-right"></i> 房源管理列表
							</small>
						</h1>
					</div>
					<!-- head E -->
					<!-- content S -->
					<div class="row">
						<div class="col-sm-12">
						<div class="tabbable">
							<ul class="nav nav-tabs" id="aptsTab">
								<li class="active">
									<a data-toggle="tab" href="#home1" rel="home1">
										<i class="green icon-home bigger-110"></i>
										1号楼
									</a>
								</li>

								<li>
									<a data-toggle="tab" href="#home2" rel="home2">
										<i class="green icon-home bigger-110"></i>
										2号楼
									</a>
								</li>
								<li>
									<a data-toggle="tab" href="#home3" rel="home3">
										<i class="green icon-home bigger-110"></i>
										3号楼
									</a>
								</li>
							</ul>

							<div class="tab-content">
								<div id="home1" class="tab-pane in active">
									<p>loading…….</p>
								</div>

								<div id="home2" class="tab-pane">
									<p>loading…….</p>
								</div>

								<div id="home3" class="tab-pane">
									<p>loading…….</p>
								</div>
							</div>
						</div>
						</div>				
					</div>
					<!-- content E -->
				</div>
			</div>
</div>
<script type="text/javascript">
	$(function(){
		//左侧导航定位
		$("#houseListUL").addClass("open").addClass("active");
		$("#housesOverviewLI").addClass("active");
		//楼座数据初始化
		refreshAptData();
		//楼座切换数据刷新
		var tab=1;
		$("#aptsTab").on('click','li',function(){
			var home=$(this).find("a").attr("rel");
			refreshAptData(home);
		});
	});
	//刷新房间数据方法
	function refreshAptData(home){
		var urlMap={"home1":"overviewContent.action?aptNum=1",
		            "home2":"overviewContent.action?aptNum=2",
		            "home3":"overviewContent.action?aptNum=3"
		           };
		var cid;
		if(home){
			cid=home;
		}else{
			cid=$(".tab-content>.active").attr("id");
		}
		$.post(urlMap[cid],function(data){
			$("#"+cid).html(data);
		},"html")		
	}
</script>
</body>
</html>
