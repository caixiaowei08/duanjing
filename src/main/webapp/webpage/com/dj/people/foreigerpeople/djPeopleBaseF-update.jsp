<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>境外人员</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  
   $(document).ready(function() {
	  var villageCurrentb= $("#villageCurrentb").val();
	  var ridgeNoCurrentb= $("#ridgeNoCurrentb").val();
	  var floorNoCurrentb= $("#floorNoCurrentb").val();
	  var roomNoCurrentb= $("#roomNoCurrentb").val();
	  
      $("#villageCurrent option[value='"+villageCurrentb+"']").attr("selected","selected");
	  
	  getRidgeNoCurrent();
	  
	  $("#ridgeNoCurrent option[value='"+ridgeNoCurrentb+"']").attr("selected","selected");
	  
	  getFloorNo();
	  
	  $("#floorNoCurrent option[value='"+floorNoCurrentb+"']").attr("selected","selected");
	  
	  getFloorRoomNo();
	  
	  $("#roomNoCurrent option[value='"+roomNoCurrentb+"']").attr("selected","selected");
	  
 });
  
  
  //编写自定义JS代码
   function getRidgeNoCurrent(){
		   var formData = new Object();
		   formData['district']=$("#districtCurrent option:selected").val();
		   formData['town']=$("#townCurrent option:selected").val();
		   formData['village']=$("#villageCurrent option:selected").val();

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
					var friends = $("#ridgeNoCurrent");
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
  
    /* *
    根据 district town village 查询该村的 门牌号 ridgeNo
*/
function getFloorNo(){
	var formData = new Object();
	formData['district']=$("#districtCurrent option:selected").val();
	formData['town']=$("#townCurrent option:selected").val();
	formData['village']=$("#villageCurrent option:selected").val();
	formData['ridgeNo']=$("#ridgeNoCurrent option:selected").val();
	
	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		url : 'djHouseInfoController.do?getFloorNo',// 请求的action路径
		data : formData,
		error : function() {// 请求失败处理函数
			
		},
		success : function(data) {
			var d = $.parseJSON(data);
			var friends = $("#floorNoCurrent");
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
    
function getFloorRoomNo(){
	var formData = new Object();
	formData['district']=$("#districtCurrent option:selected").val();
	formData['town']=$("#townCurrent option:selected").val();
	formData['village']=$("#villageCurrent option:selected").val();
	formData['ridgeNo']=$("#ridgeNoCurrent option:selected").val();
	formData['floorNo']=$("#floorNoCurrent option:selected").val();
	
	
	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		url : 'djHouseInfoController.do?getFloorRoom',// 请求的action路径
		data : formData,
		error : function() {// 请求失败处理函数
			
		},
		success : function(data) {
			var d = $.parseJSON(data);
			var friends = $("#roomNoCurrent");
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djPeopleBaseFController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djPeopleBaseFPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djPeopleBaseFPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djPeopleBaseFPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djPeopleBaseFPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djPeopleBaseFPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djPeopleBaseFPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djPeopleBaseFPage.updateDate }">
					<input id="birthPlace" name="birthPlace" type="hidden" value="${djPeopleBaseFPage.birthPlace }">
					<input id="peoType" name="peoType" type="hidden" value="${djPeopleBaseFPage.peoType }">
					<input id="usedName" name="usedName" type="hidden" value="${djPeopleBaseFPage.usedName }">
					<input id="nation" name="nation" type="hidden" value="${djPeopleBaseFPage.nation }">
					<input id="degree" name="degree" type="hidden" value="${djPeopleBaseFPage.degree }">
					<input id="maritalStatus" name="maritalStatus" type="hidden" value="${djPeopleBaseFPage.maritalStatus }">
					<input id="spouseName" name="spouseName" type="hidden" value="${djPeopleBaseFPage.spouseName }">
					<%-- <input id="pHouse" name="pHouse" type="hidden" value="${djPeopleBaseFPage.pHouse }"> --%>
					
					<input id="villageCurrentb"  type="hidden" value="${djPeopleBaseFPage.villageCurrent }">
					<input id="ridgeNoCurrentb"  type="hidden" value="${djPeopleBaseFPage.ridgeNoCurrent }">
					<input id="floorNoCurrentb"  type="hidden" value="${djPeopleBaseFPage.floorNoCurrent }">
					<input id="roomNoCurrentb"  type="hidden" value="${djPeopleBaseFPage.roomNoCurrent }">
					
					<input id="tel" name="tel" type="hidden" value="${djPeopleBaseFPage.tel }">
					<input id="job" name="job" type="hidden" value="${djPeopleBaseFPage.job }">
					<input id="workAddress" name="workAddress" type="hidden" value="${djPeopleBaseFPage.workAddress }">
					<input id="isArmy" name="isArmy" type="hidden" value="${djPeopleBaseFPage.isArmy }">
					<input id="armyRemark" name="armyRemark" type="hidden" value="${djPeopleBaseFPage.armyRemark }">
					<input id="permanentDistrict" name="permanentDistrict" type="hidden" value="${djPeopleBaseFPage.permanentDistrict }">
					<input id="permanentAddress" name="permanentAddress" type="hidden" value="${djPeopleBaseFPage.permanentAddress }">
					<input id="districtPerm" name="districtPerm" type="hidden" value="${djPeopleBaseFPage.districtPerm }">
					<input id="townPerm" name="townPerm" type="hidden" value="${djPeopleBaseFPage.townPerm }">
					<input id="villagePerm" name="villagePerm" type="hidden" value="${djPeopleBaseFPage.villagePerm }">
					<input id="roomNoPerm" name="roomNoPerm" type="hidden" value="${djPeopleBaseFPage.roomNoPerm }">
					<input id="currentDistrict" name="currentDistrict" type="hidden" value="${djPeopleBaseFPage.currentDistrict }">
					<input id="currentAddress" name="currentAddress" type="hidden" value="${djPeopleBaseFPage.currentAddress }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								英文姓:
							</label>
						</td>
						<td class="value">
						     	 <input id="lastAme" name="lastAme" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djPeopleBaseFPage.lastAme}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">英文姓</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								英文名:
							</label>
						</td>
						<td class="value">
						     	 <input id="firstName" name="firstName" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djPeopleBaseFPage.firstName}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">英文名</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								中文姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPeopleBaseFPage.name}'>
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
						      						 value='<fmt:formatDate value='${djPeopleBaseFPage.birthdate}' type="date" pattern="yyyy-MM-dd"/>'>    
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
										typeGroupCode="id_type" defaultVal="${djPeopleBaseFPage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
									               datatype="*"
										       value='${djPeopleBaseFPage.idNo}'>
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
										typeGroupCode="sex" defaultVal="${djPeopleBaseFPage.sex}" hasLabel="false"  title="性别"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">性别</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								入境时间:
							</label>
						</td>
						<td class="value">
									  <input id="entryTime" name="entryTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									               datatype="*" 
						      						 value='<fmt:formatDate value='${djPeopleBaseFPage.entryTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">入境时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								到期时间:
							</label>
						</td>
						<td class="value">
									  <input id="dueTime" name="dueTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									               datatype="*" 
						      						 value='<fmt:formatDate value='${djPeopleBaseFPage.dueTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">到期时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								国籍:
							</label>
						</td>
						<td class="value">
						     	 <input id="nationality" name="nationality" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djPeopleBaseFPage.nationality}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">国籍</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								体征:
							</label>
						</td>
						<td class="value">
						     	 <input id="sign" name="sign" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPeopleBaseFPage.sign}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">体征</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								身高:
							</label>
						</td>
						<td class="value">
						     	 <input id="height" name="height" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPeopleBaseFPage.height}'>
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
										typeGroupCode="blood_type" defaultVal="${djPeopleBaseFPage.bloodType}" hasLabel="false"  title="血型"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">血型</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								手机:
							</label>
						</td>
						<td class="value">
						     	 <input id="phone" name="phone" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPeopleBaseFPage.phone}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">手机</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								现居住地区:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="districtCurrent" type="list" id="districtCurrent"
										typeGroupCode="dist_type" defaultVal="${djPeopleBaseFPage.districtCurrent}" hasLabel="false"  title="现居住地区"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居住地区</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								现居住村:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="townCurrent" type="list" id="townCurrent"
										typeGroupCode="town_type" defaultVal="${djPeopleBaseFPage.townCurrent}" hasLabel="false"  title="现居住村"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居住村</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								现居所属宅:
							</label>
						</td>
						<td class="value">
									<%-- <t:dictSelect field="villageCurrent" type="list"
										typeGroupCode="vill_type" defaultVal="${djPeopleBaseFPage.villageCurrent}" hasLabel="false"  title="现居所属宅"></t:dictSelect>      --%>
							 <select name="villageCurrent" id="villageCurrent" onchange="getRidgeNoCurrent()"> 
							    <%--联动获取 该宅下面的所有的 门牌号 --%>
							    <option value selected="selected" >--请选择--</option>
								<option value="段泾桥宅">段泾桥宅</option>
								<option value="泗塘宅" >泗塘宅</option>
								<option value="陆家宅" >陆家宅</option>
								<option value="支家楼" >支家楼</option>
							</select>	
							
							
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居所属宅</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								现居门牌号:
							</label>
						</td>
						<td class="value">
									<%-- <t:dictSelect field="ridgeNoCurrent" type="list"
										typeGroupCode="" defaultVal="${djPeopleBaseFPage.ridgeNoCurrent}" hasLabel="false"  title="现居门牌号"></t:dictSelect>      --%>
							
							<select name="ridgeNoCurrent" id="ridgeNoCurrent" onchange="getFloorNo()"> 
							    <option value >--请选择--</option>
							</select>
							
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居门牌号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								现居楼层:
							</label>
						</td>
						<td class="value">
									<%-- <t:dictSelect field="floorNoCurrent" type="list"
										typeGroupCode="" defaultVal="${djPeopleBaseFPage.floorNoCurrent}" hasLabel="false"  title="现居楼层"></t:dictSelect>      --%>
							<select name="floorNoCurrent"  id="floorNoCurrent" width="100" style="width: 104px" onchange="getFloorRoomNo()">
			                        <option value="">---请选择---</option>
			                  </select>
							
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居楼层</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								现居房间号:
							</label>
						</td>
						<td class="value">
									<%-- <t:dictSelect field="roomNoCurrent" type="list"
										typeGroupCode="" defaultVal="${djPeopleBaseFPage.roomNoCurrent}" hasLabel="false"  title="现居房间号"></t:dictSelect>      --%>
							 <select name="roomNoCurrent"  id="roomNoCurrent" width="100" style="width: 104px" >
			                        <option value="">---请选择---</option>
			                 </select>		
							
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居房间号</label>
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
									               
										       value='${djPeopleBaseFPage.remark}'>
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
  <script src = "webpage/com/dj/people/foreigerpeople/djPeopleBaseF.js"></script>		