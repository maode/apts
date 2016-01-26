<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s"  uri="/struts-tags" %>
<html>
<head>
<title>管理员首页</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/jquery.gritter.css" /><!-- 为了使ace.min.css中的样式覆盖该文件中的部分样式所以该文件位置提前 -->
<jsp:include page="../frame/common.jsp"></jsp:include>
<script type="text/javascript" src="<%=request.getContextPath() %>/assets/js/bootbox.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/assets/js/jquery.gritter.min.js"></script>
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
							控制台 <small> <i class="icon-double-angle-right"></i> 房屋管理
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
		//委派楼座单击-数据刷新
		$("#aptsTab").on('click','li',function(){
			var home=$(this).find("a").attr("rel");
			refreshAptData(home);
		});
		//委派房屋单击-房屋操作
		$("div.tab-pane").on('click','span.btn',function(){
			var houseId=$(this).attr("data-hid");//房屋id
			if($(this).hasClass("btn-success")){
				//未出租-弹出出租页面
				openIframe('toAddHouseHis.action?houseInfo.id='+houseId,600,600);
			}else{
				//已出租
				var hisId=$(this).attr("data-hisid");//最后一次租房信息的id
				var dialog=bootbox.dialog({
					message: '该房屋目前为在租状态，房屋到期请点击“置空”，房客续租请点击“续租”',
					buttons: 			
					{
						"empty" :
						 {
							"label" : "置空",
							"className" : "btn-sm btn-success",
							"callback": function() {
								//Example.show("great success");
								$.post('emptyHouse.action',{'id':houseId},function(data){
									if(data&&data.code=="success"){
										$.gritter.add({
											title: '房屋已腾空  O(∩_∩)O~',
											class_name: 'gritter-info gritter-center',
											time: 1000
										});
										dialog.modal('hide');//关闭当前弹窗
										refreshAptData();
									}else{
										$.gritter.add({
											title: '房屋没能腾空  O(∩_∩)O~',
											class_name: 'gritter-info gritter-center',
											time: 2000
										});
									}									
								},'json');
							}
						},
						"renewal" :
						{
							"label" : "续租",
							"className" : "btn-sm btn-danger",
							"callback": function() {
								openIframe('toAddHouseHis.action?id='+hisId,600,600);
							}
						}
					}
				});				
			}
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
