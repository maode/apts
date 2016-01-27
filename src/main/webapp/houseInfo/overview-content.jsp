<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s"  uri="/struts-tags" %>


<!-- 迭代楼层S -->
<s:set name="fNum" value="1"/><!-- 楼层变量 -->
<s:if test="houseList!=null&&houseList.size()>0">
	<!-- 首次生成面板上半部分S -->
		<div class="row">
			<div class="col-sm-12">
				<h3 class="header blue lighter smaller">
					<i class="icon-reorder smaller-90"></i>
					第<s:property value="#fNum"/>层
				</h3>
				<p>
	
	<!-- 首次生成面板上半部分E -->
	<!-- 生成主体房屋S -->
	<s:iterator value="houseList">
	<s:if test="#fNum==floorNum"><!-- 判断是否是新的一层 -->
		<s:if test="status==0">
			<!-- 未出租 -->
			<span class="btn btn-success btn-sm tooltip-success" data-rel="tooltip" data-placement="bottom" data-hid="${id }" >
			<s:property value="houseNum"/>
			</span>
		</s:if>
		<s:else>
			<!-- 已出租 -->
			<span class="btn btn-danger btn-sm tooltip-error" data-rel="tooltip" 
			data-placement="bottom" data-hid="${id }" data-hisid="${hisId }" title="~<s:date name='endTime' format='yyy-MM-dd' />">
			<s:property value="houseNum"/>
			</span>
		</s:else>
	</s:if>
	<s:else><!-- 新的一层，更新楼层变量 -->
		<s:set name="fNum" value="floorNum"/>
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<h3 class="header blue lighter smaller">
					<i class="icon-reorder smaller-90"></i>
					第<s:property value="#fNum"/>层
				</h3>
				<p>
			<s:if test="status==0">
				<!-- 未出租 -->
				<span class="btn btn-success btn-sm tooltip-success" data-rel="tooltip" data-placement="bottom" data-hid="${id }" >
				<s:property value="houseNum"/>
				</span>
			</s:if>
			<s:else>
				<!-- 已出租 -->
				<span class="btn btn-danger btn-sm tooltip-error" data-rel="tooltip" 
				data-placement="bottom" data-hid="${id }" data-hisid="${hisId }" title="~<s:date name='endTime' format='yyy-MM-dd' />">
				<s:property value="houseNum"/>
				</span>
			</s:else>
	</s:else>
	<!-- 生成主体房屋E -->
	</s:iterator>
	<!-- 最后一层面板下半部分S-->
			</p>
		</div>
	</div>
	<!-- 最后一层面板下半部分E-->
</s:if>
<!-- 迭代楼层E -->

<script type="text/javascript">
//房间浮层
$('[data-rel=tooltip]').tooltip();
</script>
<%-- 天数提醒 
<span class="badge badge-primary ">5</span>
--%>
<%-- 楼层迭代完整结构
<div class="row">
	<div class="col-sm-12">
		<h3 class="header blue lighter smaller">
			<i class="icon-reorder smaller-90"></i>
			第1层
		</h3>
		<p>
			<span class="btn btn-success btn-sm tooltip-success" data-rel="tooltip" data-placement="bottom" title="Right Success">
			未出租
			</span>
			<span class="btn btn-danger btn-sm tooltip-error" data-rel="tooltip" data-placement="bottom" title="Top Danger">
			已出租
			</span>
		</p>
	</div>
</div>
--%>