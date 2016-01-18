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
<script type="text/javascript"
	src="http://webapi.amap.com/maps?v=1.3&key=d89fa9543aeb67dbc017db4933ff0bc3"></script>
<script type="text/javascript">
	$(function() {
		$("#webform").validationEngine();
		$('.ace_file')
				.ace_file_input(
						{
							style : 'well',
							btn_choose : '拖动图片或点击选择',
							btn_change : null,
							no_icon : null,
							droppable : true,
							thumbnail : 'small'//large | fit
						}).on('change', function() {

							});
				})

	function subform() {
		$("#status").val(status);
		var tishi="提交成功";
		if(status==1){
			tishi="保存成功";
		}
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
								parent.location.reload();
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
						控制台 <small> <i class="icon-double-angle-right"></i> 发布房源
						</small>
					</h1>
				</div>
				<div class="page-body" >
					<form class="form-horizontal" method="post"
						action="addHouseDo.action" id="webform"
						enctype="multipart/form-data">
						<div class="form-group">
							<label class="col-md-2 control-label no-padding-right"
								for="form-field-2"> 房源标题</label>
							<div class="col-md-10">
								<s:textfield name="houseInfo.title" placeholder="房源标题"
									cssClass="col-xs-10   validate[required,maxSize[50]]"></s:textfield>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label no-padding-right"
								for="form-field-1"> 房源图片</label>
							<div class="col-md-10">
								<s:file name="files" />
								<s:file name="files" />
								<s:file name="files" />
								<s:file name="files" />
								<s:file name="files" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label no-padding-right"
								for="form-input-readonly"> 所属省份</label>
							<div class="col-md-10">
								<s:select list="#{1:'山东',2:'上海' }" name="houseInfo.province.id"></s:select>
							</div>
						</div>

						<div class="space-4"></div>
						<div class="form-group">
							<label class="col-md-2 control-label no-padding-right"
								for="form-field-2"> 所属城市 </label>

							<div class="col-md-10">
								<s:select list="#{1:'青岛',2:'烟台' }" name="houseInfo.city.id"></s:select>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label no-padding-right"
								for="form-field-2"> 价格 </label>

							<div class="col-md-10">
								<s:textfield name="houseInfo.price" placeholder="价格"
									cssClass="col-xs-10   validate[required,maxSize[50]]"></s:textfield>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label no-padding-right"
								for="form-field-2"> 环境描述 </label>

							<div class="col-md-10">
								<s:textarea name="houseInfo.surroundings" placeholder="环境描述"
									cssClass="col-xs-10   validate[required,maxSize[255]]"></s:textarea>
							</div>
						</div>

						<div class="form-group">
							<div id="accordion" class="accordion-style1 panel-group">

								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a class="accordion-toggle" data-toggle="collapse"
												data-parent="#accordion" href="#collapseOneOther"> <i
												class="icon-angle-right bigger-110"
												data-icon-hide="icon-angle-down"
												data-icon-show="icon-angle-right"></i> 地图上拾取获取经纬度坐标
											</a>
										</h4>
										<div class="form-group">
											<label class="col-md-2 control-label no-padding-right"
												for="form-field-2"> 经度</label>
											<div class="col-md-10">
												<s:textfield id="lngX" name="houseInfo.longitude"></s:textfield>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-2 control-label no-padding-right"
												for="form-field-2"> 纬度</label>
											<div class="col-md-10">
												<s:textfield id="latY" name="houseInfo.latitude"></s:textfield>
											</div>
										</div>
									</div>

									<div class="panel-collapse collapse " id="collapseOneOther">
										<div class="panel-body">
											<div id="mapContainer"
												style="width: 800px; height: 500px; position: relative;"></div>
										</div>
									</div>
								</div>
								<script type="text/javascript">
									var map;
									//初始化地图对象，加载地图
									map = new AMap.Map("mapContainer", {
										resizeEnable : true
									});

									//为地图注册click事件获取鼠标点击出的经纬度坐标
									var clickEventListener = map
											.on(
													'click',
													function(e) {
														document
																.getElementById("lngX").value = e.lnglat
																.getLng();
														document
																.getElementById("latY").value = e.lnglat
																.getLat();
													});
								</script>

								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a class="accordion-toggle collapsed" data-toggle="collapse"
												data-parent="#accordion" href="#collapseOne"> <i
												class="icon-angle-right bigger-110"
												data-icon-hide="icon-angle-down"
												data-icon-show="icon-angle-right"></i> 描述
											</a>
										</h4>
									</div>

									<div class="panel-collapse collapse " id="collapseOne">
										<div class="panel-body">

											<div class="form-group">
												<label class="col-md-2 control-label no-padding-right"
													for="form-field-2">房源独特之处 </label>

												<div class="col-md-10">
													<s:textarea name="houseInfo.houseSpecialMemo"
														placeholder="房源独特之处"
														cssClass="col-xs-10   validate[required,maxSize[255]]"></s:textarea>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-2 control-label no-padding-right"
													for="form-field-2"> 访客使用权限 </label>

												<div class="col-md-10">
													<s:textarea name="houseInfo.houseAuthMemo"
														placeholder="访客使用权限 "
														cssClass="col-xs-10   validate[required,maxSize[255]]"></s:textarea>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-2 control-label no-padding-right"
													for="form-field-2"> 与访客互动 </label>

												<div class="col-md-10">
													<s:textarea name="houseInfo.chartToCustomMemo"
														placeholder="与访客互动 "
														cssClass="col-xs-10   validate[required,maxSize[255]]"></s:textarea>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-2 control-label no-padding-right"
													for="form-field-2"> 概述 </label>

												<div class="col-md-10">
													<s:textarea name="houseInfo.memo" placeholder="概述"
														cssClass="col-xs-10   validate[required,maxSize[255]]"></s:textarea>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-2 control-label no-padding-right"
													for="form-field-2"> 摘要 </label>

												<div class="col-md-10">
													<s:textarea name="houseInfo.info" placeholder="摘要"
														cssClass="col-xs-10   validate[required,maxSize[255]]"></s:textarea>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-2 control-label no-padding-right"
													for="form-field-2"> 地址 </label>

												<div class="col-md-10">
													<s:textarea name="houseInfo.addr" placeholder="地址"
														cssClass="col-xs-10   validate[required,maxSize[255]]"></s:textarea>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-2 control-label no-padding-right"
													for="form-field-2"> 公共交通描述</label>

												<div class="col-md-10">
													<s:textarea name="houseInfo.trafficMemo"
														placeholder="公共交通描述"
														cssClass="col-xs-10   validate[required,maxSize[255]]"></s:textarea>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-2 control-label no-padding-right"
													for="form-field-2"> 访客注意事项</label>

												<div class="col-md-10">
													<s:textarea name="houseInfo.customNoticeMemo"
														placeholder="访客注意事项"
														cssClass="col-xs-10   validate[required,maxSize[255]]"></s:textarea>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-2 control-label no-padding-right"
													for="form-field-2"> 对访客举止要求</label>
												<div class="col-md-10">
													<s:textarea name="houseInfo.customAgreeMemo"
														placeholder="对访客举止要求"
														cssClass="col-xs-10   validate[required,maxSize[255]]"></s:textarea>
												</div>
											</div>
										</div>
									</div>
								</div>

								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a class="accordion-toggle collapsed" data-toggle="collapse"
												data-parent="#accordion" href="#collapseTwo"> <i
												class="icon-angle-right bigger-110"
												data-icon-hide="icon-angle-down"
												data-icon-show="icon-angle-right"></i> 便利设施
											</a>
										</h4>
									</div>

									<div class="panel-collapse collapse" id="collapseTwo">
										<div class="panel-body">
											<div class="radio">
												<label> <span class="lbl">有无wifi</span> <s:select
														list="#{1:'无',2:'有'}" name="houseInfo.wifiFlag"
														cssClass="ace"></s:select>
												</label>
												<label> <span class="lbl">有无探测器</span> <s:select
														list="#{1:'无',2:'有'}" name="houseInfo.smokFlag"
														cssClass="ace"></s:select>
												</label>												
												<label> <span class="lbl">是否即时预定</span> <s:select
														list="#{1:'否',2:'是'}" name="houseInfo.orderFlag"
														cssClass="ace"></s:select>
												</label>												
												<label> <span class="lbl">有无厨房</span> <s:select
														list="#{1:'无',2:'有'}" name="houseInfo.kitchenFlag"
														cssClass="ace"></s:select>
												</label>												
												<label> <span class="lbl">有无泳池</span> <s:select
														list="#{1:'无',2:'有'}" name="houseInfo.swimmingFlag"
														cssClass="ace"></s:select>
												</label>												
												<label> <span class="lbl">有无空调</span> <s:select
														list="#{1:'无',2:'有'}" name="houseInfo.airConditioningFlag"
														cssClass="ace"></s:select>
												</label>												
												<label> <span class="lbl">有无电视</span> <s:select
														list="#{1:'无',2:'有'}" name="houseInfo.tvFlag"
														cssClass="ace"></s:select>
												</label>												
												<label> <span class="lbl">有无有线电视</span> <s:select
														list="#{1:'无',2:'有'}" name="houseInfo.wiredTvFlag"
														cssClass="ace"></s:select>
												</label>												
												<label> <span class="lbl">有无网络</span> <s:select
														list="#{1:'无',2:'有'}" name="houseInfo.netFlag"
														cssClass="ace"></s:select>
												</label>												
												<label> <span class="lbl">有无障碍物</span> <s:select
														list="#{1:'无',2:'有'}" name="houseInfo.accessibleFlag"
														cssClass="ace"></s:select>
												</label>												
												<label> <span class="lbl">有无停车场</span> <s:select
														list="#{1:'无',2:'有'}" name="houseInfo.carFlag"
														cssClass="ace"></s:select>
												</label>												
												<label> <span class="lbl">有无吸烟场所</span> <s:select
														list="#{1:'无',2:'有'}" name="houseInfo.smokeFlag"
														cssClass="ace"></s:select>
												</label>												
												<label> <span class="lbl">有无携带宠物</span> <s:select
														list="#{1:'无',2:'有'}" name="houseInfo.dogFlag"
														cssClass="ace"></s:select>
												</label>												
												<label> <span class="lbl">有无门卫</span> <s:select
														list="#{1:'无',2:'有'}" name="houseInfo.doorFlag"
														cssClass="ace"></s:select>
												</label>												
												<label> <span class="lbl">有无健身房</span> <s:select
														list="#{1:'无',2:'有'}" name="houseInfo.gymFlag"
														cssClass="ace"></s:select>
												</label>												
												<label> <span class="lbl">是否提供早餐</span> <s:select
														list="#{1:'否',2:'是'}" name="houseInfo.breakfastFlag"
														cssClass="ace"></s:select>
												</label>												
												<label> <span class="lbl">有无电梯</span> <s:select
														list="#{1:'无',2:'有'}" name="houseInfo.elevatorFlag"
														cssClass="ace"></s:select>
												</label>												
												<label> <span class="lbl">有无浴缸</span> <s:select
														list="#{1:'无',2:'有'}" name="houseInfo.crockflag"
														cssClass="ace"></s:select>
												</label>												
												<label> <span class="lbl">有无壁炉</span> <s:select
														list="#{1:'无',2:'有'}" name="houseInfo.fireplaceFlag"
														cssClass="ace"></s:select>
												</label>												
												<label> <span class="lbl">有无对讲机</span> <s:select
														list="#{1:'无',2:'有'}" name="houseInfo.intercomFlag"
														cssClass="ace"></s:select>
												</label>												
												<label> <span class="lbl">有无暖气</span> <s:select
														list="#{1:'无',2:'有'}" name="houseInfo.heatingFlag"
														cssClass="ace"></s:select>
												</label>												
												<label> <span class="lbl">是否适合家庭入住</span> <s:select
														list="#{1:'否',2:'是'}" name="houseInfo.familyFlag"
														cssClass="ace"></s:select>
												</label>												
											</div>



										</div>
									</div>
								</div>

								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a class="accordion-toggle collapsed" data-toggle="collapse"
												data-parent="#accordion" href="#collapseThree"> <i
												class="icon-angle-right bigger-110"
												data-icon-hide="icon-angle-down"
												data-icon-show="icon-angle-right"></i> 房间和床位
											</a>
										</h4>
									</div>

									<div class="panel-collapse collapse" id="collapseThree">
										<div class="panel-body">

											<div class="form-group">
												<label class="col-md-2 control-label no-padding-right"
													for="form-field-2"> 房客数量 </label>

												<div class="col-md-10">
													<s:textfield name="houseInfo.peopleNum" placeholder="房客数量"
														cssClass="col-xs-10   validate[required,maxSize[255]]"></s:textfield>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-2 control-label no-padding-right"
													for="form-field-2"> 房间个数 </label>

												<div class="col-md-10">
													<s:textfield name="houseInfo.houseNum" placeholder="房间个数"
														cssClass="col-xs-10   validate[required,maxSize[255]]"></s:textfield>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-2 control-label no-padding-right"
													for="form-field-2"> 卧室个数 </label>

												<div class="col-md-10">
													<s:textfield name="houseInfo.roomNum" placeholder="卧室个数"
														cssClass="col-xs-10   validate[required,maxSize[255]]"></s:textfield>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-2 control-label no-padding-right"
													for="form-field-2"> 床位个数 </label>

												<div class="col-md-10">
													<s:textfield name="houseInfo.bedNum" placeholder="床位个数"
														cssClass="col-xs-10   validate[required,maxSize[255]]"></s:textfield>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-2 control-label no-padding-right"
													for="form-field-2"> 卫生间个数</label>

												<div class="col-md-10">
													<s:textfield name="houseInfo.toiletNum" placeholder="卫生间个数"
														cssClass="col-xs-10   validate[required,maxSize[255]]"></s:textfield>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-2 control-label no-padding-right"
													for="form-field-2"> 房源类型 </label>
												<div class="col-md-10">
													<s:select list="#{1:'独立房间',2:'合住房子',3:'整套房子' }" name="houseInfo.houseType"></s:select>
												</div>
											</div>																															
											<div class="form-group">
												<label class="col-md-2 control-label no-padding-right"
													for="form-field-2"> 房间类型 </label>
												<div class="col-md-10">
													<!-- 要改为后台加载 -->
													<s:select list="#{1:'小木屋',2:'单间',3:'个性小屋' }" name="houseInfo.houseProperty.id"></s:select>
												</div>
											</div>																															


										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="clearfix form-actions">
							<div class="col-xs-offset-3 " style="margin-left: 25%;">
								<button class="btn btn-info" type="button" onclick="subform()">
									<i class="icon-ok bigger-110"></i> 提交
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