	  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<link href="<%=request.getContextPath() %>/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/font-awesome.min.css" />
		<!--[if IE 7]>
		  <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
		<!-- page specific plugin styles -->
		<!-- ace styles -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/other/css/jquery.fancybox.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/other/css/validationEngine.jquery.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/ace.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/ace-skins.min.css" />
		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/ace-ie.min.css" />
		<![endif]-->
		<!-- inline styles related to this page -->
		<!-- ace settings handler -->
		<script src="<%=request.getContextPath() %>/assets/js/jquery-2.0.3.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/ace-extra.min.js"></script>
		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="<%=request.getContextPath() %>/assets/js/html5shiv.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/respond.min.js"></script>
		<![endif]-->
		<script src="<%=request.getContextPath() %>/assets/js/bootstrap.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->

		<!--[if lte IE 8]>
		  <script src="<%=request.getContextPath() %>/assets/js/excanvas.min.js"></script>
		<![endif]-->

		<script src="<%=request.getContextPath() %>/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/jquery.slimscroll.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/jquery.easy-pie-chart.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/jquery.sparkline.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/flot/jquery.flot.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/flot/jquery.flot.pie.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/flot/jquery.flot.resize.min.js"></script>

		<!-- ace scripts -->

		<script src="<%=request.getContextPath() %>/assets/js/ace-elements.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/ace.min.js"></script>
			<script src="<%=request.getContextPath() %>/assets/other/jquery.fancybox.js"></script>
				<script src="<%=request.getContextPath() %>/assets/other/jquery.fancybox.pack.js"></script>
				<script src="<%=request.getContextPath() %>/assets/other/jquery.validate.js"></script>
				<script src="<%=request.getContextPath() %>/assets/other/jquery.validationEngine-zh_CN.js"></script>
				<script src="<%=request.getContextPath() %>/assets/other/jquery.validationEngine.js"></script>
							    <link href="<%=request.getContextPath() %>/assets/alert/sweetalert.css" rel="stylesheet" />
    <script src="<%=request.getContextPath() %>/assets/alert/sweetalert.min.js"></script>
						<script src="<%=request.getContextPath() %>/assets/other/jquery.form.js"></script>
		
		<style>
<!--
body,div,table,tr,td{
	padding: 0px;
	margin: 0px;
	font-size: 13px;
	font-family: 微软雅黑
}
-->
</style>				

				<script type="text/javascript">
function  nalert(str){
	swal({   title: "提示消息!",   text: str,    confirmButtonText: "关闭" ,confirmButtonColor: "#3e98df",  });
}

$(document).ready(function(){
	 $("#allcheckbox").change(function(){
		  $("input[name='checkbox']").each(function(){
	        	if($('#allcheckbox').is(':checked')) {
	                this.checked = true;
	            }
	            else {
	                this.checked = false;
	            }
	        });
	 })
	 $("input").keydown(function(){
		 if (event.keyCode == 13){
	            return false;
	        }
	 })
	});


  function openIframe(url,width,height){
	   $.fancybox.open({
			href : url,
			type : 'iframe',
			padding : 1,
			width:width,
			height:height,
			modal:true,
			 openEffect: 'elastic'
		});
  }
  
  
</script>	
