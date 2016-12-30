<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>出租房信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
/*    function getRidgeNo(){
		   var formData = new Object();
		   formData['district']=$("#district option:selected").val();
		   formData['town']=$("#town option:selected").val();
		   formData['village']=$("#village option:selected").val();

			$.ajax({
				async : false,
				cache : false,
				type : 'POST',
				url : 'djHouseInfoController.do?getHouse',// 请求的action路径
				data : formData,
				error : function() {// 请求失败处理函数
					
				},
				success : function(data) {
					var d = $.parseJSON(data);
					var friends = $("#ridgeNo");
					friends.empty();
					var option = $("<option>").text("--请选择--").val(null);
					friends.append(option);
					for(var i=0;i<d.length;i++) {
					    var option = $("<option>").text(d[i]).val(d[i]);
					    friends.append(option);
					}
				}
			});
		} */
 
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djHouseInfoController.do?doAdd" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${djHouseInfoPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djHouseInfoPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djHouseInfoPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djHouseInfoPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djHouseInfoPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djHouseInfoPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djHouseInfoPage.updateDate }">
					<input id="isNull" name="isNull" type="hidden" value="${djHouseInfoPage.isNull }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
		          <tr>  
					<td align="right">
						<label class="Validform_label">
							房屋所在区:
						</label>
					</td>
					<td class="value">
							 <%--  <t:dictSelect field="district" type="list"
									typeGroupCode="dist_type" defaultVal="${djHouseInfoPage.district}" hasLabel="false"  title="房屋所在区"></t:dictSelect>      --%>
							<!-- 	<select id="district" name="district"> 
								<option value="上海市宝山区" selected="selected">上海市宝山区 </option> 
							</select>	 -->
							<input id="district" name="district" type="text" style="width: 150px" class="inputxt" readonly="true"
									               
										       value='${djHouseInfoPage.district}'>
							
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房屋所在区</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							房屋所在村:
						</label>
					</td>
					<td class="value">
							<%--   <t:dictSelect field="town" type="list"
									typeGroupCode="town_type" defaultVal="${djHouseInfoPage.town}" hasLabel="false"  title="房屋所在村"></t:dictSelect>      --%>
							<!-- <select name="town" id="town"> 
								<option value="月浦镇段泾村" selected="selected">月浦镇段泾村 </option> 
							</select>	 -->
							<input id="town" name="town" type="text" style="width: 150px" class="inputxt"  readonly="true" 
									               
										       value='${djHouseInfoPage.town}'>
								 
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房屋所在村</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							房屋所属宅:
						</label>
					</td>
					<td class="value">
							  <%-- <t:dictSelect field="village" type="list"
									typeGroupCode="vill_type" defaultVal="${djHouseInfoPage.village}" hasLabel="false"  title="房屋所属宅"></t:dictSelect>      --%>
							<%-- <select name="village" id="village" onchange="getRidgeNo(this)"> 
							    联动获取 该宅下面的所有的 门牌号
							    <option value selected="selected" >--请选择--</option>
								<option value="段泾桥宅">段泾桥宅</option>
								<option value="泗塘宅" >泗塘宅</option>
								<option value="陆家宅" >陆家宅</option>
								<option value="支家楼" >支家楼</option>
							</select>			               --%> 
							<input id="village" name="village" type="text" style="width: 150px" class="inputxt"  readonly="true"
									               
										       value='${djHouseInfoPage.village}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房屋所属宅</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							门牌号:
						</label>
					</td>
					<td class="value">
					     	<!--  <input id="ridgeNo" name="ridgeNo" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               > -->
							<!-- <select name="ridgeNo" id="ridgeNo"> 
							    <option value selected="selected" >--请选择--</option>
							</select>	 --> 
							<input id="ridgeNo" name="ridgeNo" type="text" style="width: 150px" class="inputxt" readonly="true"
									               
										       value='${djHouseInfoPage.ridgeNo}'>	               
						       <!-- 或者输入门牌号，再选择:<input id="ridgeNo2"  type="text" style="width: 150px" class="inputxt" onmouseout="mouseoutridgeNo()">              -->
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">门牌号</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							房间号:
						</label>
					</td>
					<td class="value">
					     	 <input id="roomNo" name="roomNo" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房间号</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							楼层:
						</label>
					</td>
					<td class="value">
					     	<input id="floorNo" name="floorNo" type="text" style="width: 150px" class="inputxt" readonly="true" 
									               
										       value='${djHouseInfoPage.floorNo}'>	 
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">楼层</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/renthouse/renthouseinfo/djHouseInfo.js"></script>		