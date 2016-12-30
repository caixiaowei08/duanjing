<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>户在人不在</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
     function getRidgeNoPerm(){
	   var formData = new Object();
	   formData['district']=$("#districtPerm option:selected").val();
	   formData['town']=$("#townPerm option:selected").val();
	   formData['village']=$("#villagePerm option:selected").val();

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
				var friends = $("#roomNoPerm");
				friends.empty();
				var option = $("<option>").text("--请选择--").val(null);
				friends.append(option);
				for(var i=0;i<d.length;i++) {
				    var option = $("<option>").text(d[i]).val(d[i]);
				    friends.append(option);
				}
			}
		});
	}
  
  
  
  
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djPeopleBaseL02Controller.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djPeopleBaseL02Page.id }">
					<input id="createName" name="createName" type="hidden" value="${djPeopleBaseL02Page.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djPeopleBaseL02Page.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djPeopleBaseL02Page.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djPeopleBaseL02Page.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djPeopleBaseL02Page.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djPeopleBaseL02Page.updateDate }">
					<input id="lastAme" name="lastAme" type="hidden" value="${djPeopleBaseL02Page.lastAme }">
					<input id="firstName" name="firstName" type="hidden" value="${djPeopleBaseL02Page.firstName }">
					<input id="entryTime" name="entryTime" type="hidden" value="${djPeopleBaseL02Page.entryTime }">
					<input id="dueTime" name="dueTime" type="hidden" value="${djPeopleBaseL02Page.dueTime }">
					<input id="peoType" name="peoType" type="hidden" value="${djPeopleBaseL02Page.peoType }">
					<input id="nationality" name="nationality" type="hidden" value="${djPeopleBaseL02Page.nationality }">
					<input id="pHouse" name="pHouse" type="hidden" value="${djPeopleBaseL02Page.pHouse }">
					<input id="permanentDistrict" name="permanentDistrict" type="hidden" value="${djPeopleBaseL02Page.permanentDistrict }">
					<input id="permanentAddress" name="permanentAddress" type="hidden" value="${djPeopleBaseL02Page.permanentAddress }">
					<input id="districtCurrent" name="districtCurrent" type="hidden" value="${djPeopleBaseL02Page.districtCurrent }">
					<input id="townCurrent" name="townCurrent" type="hidden" value="${djPeopleBaseL02Page.townCurrent }">
					<input id="villageCurrent" name="villageCurrent" type="hidden" value="${djPeopleBaseL02Page.villageCurrent }">
					<input id="ridgeNoCurrent" name="ridgeNoCurrent" type="hidden" value="${djPeopleBaseL02Page.ridgeNoCurrent }">
					<input id="floorNoCurrent" name="floorNoCurrent" type="hidden" value="${djPeopleBaseL02Page.floorNoCurrent }">
					<input id="roomNoCurrent" name="roomNoCurrent" type="hidden" value="${djPeopleBaseL02Page.roomNoCurrent }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							中文姓名:
						</label>
					</td>
					<td class="value">
					     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">中文姓名</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							生日:
						</label>
					</td>
					<td class="value">
							   <input id="birthdate" name="birthdate" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
								               datatype="*" 
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">生日</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							证件类型:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="idType" type="list"
									typeGroupCode="id_type" defaultVal="${djPeopleBaseL02Page.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">证件类型</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							证件号码:
						</label>
					</td>
					<td class="value">
					     	 <input id="idNo" name="idNo" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">证件号码</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							性别:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="sex" type="radio"
									typeGroupCode="sex" defaultVal="0" hasLabel="false"  title="性别"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">性别</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							籍贯:
						</label>
					</td>
					<td class="value">
					     	 <input id="birthPlace" name="birthPlace" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">籍贯</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							曾用名:
						</label>
					</td>
					<td class="value">
					     	 <input id="usedName" name="usedName" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">曾用名</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							体征:
						</label>
					</td>
					<td class="value">
					     	 <input id="sign" name="sign" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">体征</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							民族:
						</label>
					</td>
					<td class="value">
					     	 <input id="nation" name="nation" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">民族</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							身高:
						</label>
					</td>
					<td class="value">
					     	 <input id="height" name="height" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">身高</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							血型:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="bloodType" type="list"
									typeGroupCode="blood_type" defaultVal="${djPeopleBaseL02Page.bloodType}" hasLabel="false"  title="血型"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">血型</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							学历:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="degree" type="list"
									typeGroupCode="degree" defaultVal="${djPeopleBaseL02Page.degree}" hasLabel="false"  title="学历"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学历</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							婚姻状况:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="maritalStatus" type="list"
									typeGroupCode="m_status" defaultVal="${djPeopleBaseL02Page.maritalStatus}" hasLabel="false"  title="婚姻状况"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">婚姻状况</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							配偶姓名:
						</label>
					</td>
					<td class="value">
					     	 <input id="spouseName" name="spouseName" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">配偶姓名</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							座机:
						</label>
					</td>
					<td class="value">
					     	 <input id="tel" name="tel" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">座机</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							手机:
						</label>
					</td>
					<td class="value">
					     	 <input id="phone" name="phone" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">手机</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							职业:
						</label>
					</td>
					<td class="value">
					     	 <input id="job" name="job" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">职业</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							工作地点:
						</label>
					</td>
					<td class="value">
					     	 <input id="workAddress" name="workAddress" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">工作地点</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							兵役状况:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="isArmy" type="list"
									typeGroupCode="is_army" defaultVal="${djPeopleBaseL02Page.isArmy}" hasLabel="false"  title="兵役状况"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">兵役状况</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							兵役详情:
						</label>
					</td>
					<td class="value">
					     	 <input id="armyRemark" name="armyRemark" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">兵役详情</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							户籍地区:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="districtPerm" type="list" id="districtPerm"
									typeGroupCode="dist_type" defaultVal="${djPeopleBaseL02Page.districtPerm}" hasLabel="false"  title="户籍地区"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户籍地区</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							户籍所在村:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="townPerm" type="list" id="townPerm"
									typeGroupCode="town_type" defaultVal="${djPeopleBaseL02Page.townPerm}" hasLabel="false"  title="户籍所在村"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户籍所在村</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							户籍所属宅:
						</label>
					</td>
					<td class="value">
							  <%-- <t:dictSelect field="villagePerm" type="list"
									typeGroupCode="vill_type" defaultVal="${djPeopleBaseL02Page.villagePerm}" hasLabel="false"  title="户籍所属宅"></t:dictSelect>      --%>
							<select name="villagePerm" id="villagePerm" onchange="getRidgeNoPerm()"> 
							    <%--联动获取 该宅下面的所有的 门牌号 --%>
							    <option value selected="selected" >--请选择--</option>
								<option value="段泾桥宅">段泾桥宅</option>
								<option value="泗塘宅" >泗塘宅</option>
								<option value="陆家宅" >陆家宅</option>
								<option value="支家楼宅" >支家楼宅</option>
								<option value="西北宅" >西北宅</option>
							</select>	
							
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户籍所属宅</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							户籍门牌号:
						</label>
					</td>
					<td class="value">
							  <%-- <t:dictSelect field="roomNoPerm" type="list"
									typeGroupCode="" defaultVal="${djPeopleBaseL02Page.roomNoPerm}" hasLabel="false"  title="户籍门牌号"></t:dictSelect>      --%>
							<select name="roomNoPerm" id="roomNoPerm"> 
							    <option value selected="selected" >--请选择--</option>
							</select>	
							
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户籍门牌号</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							现居住地区:
						</label>
					</td>
					<td class="value">
					     	 <input id="currentDistrict" name="currentDistrict" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居住地区</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							现居住地址:
						</label>
					</td>
					<td class="value">
					     	 <input id="currentAddress" name="currentAddress" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居住地址</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="remark" name="remark" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
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
  <script src = "webpage/com/dj/people/localpeoplel02/djPeopleBaseL02.js"></script>		