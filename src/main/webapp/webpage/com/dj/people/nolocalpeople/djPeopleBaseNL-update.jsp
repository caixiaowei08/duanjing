<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>来沪人员</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  /* <input id="villageCurrentb"  type="hidden" value="${djPeopleBaseNLPage.villageCurrent }">
	<input id="ridgeNoCurrentb"  type="hidden" value="${djPeopleBaseNLPage.nationality }">
	<input id="floorNoCurrentb"  type="hidden" value="${djPeopleBaseNLPage.floorNoCurrent }">
	<input id="roomNoCurrentb"  type="hidden" value="${djPeopleBaseNLPage.roomNoCurrent }">
   */
   
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djPeopleBaseNLController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djPeopleBaseNLPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djPeopleBaseNLPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djPeopleBaseNLPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djPeopleBaseNLPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djPeopleBaseNLPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djPeopleBaseNLPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djPeopleBaseNLPage.updateDate }">
					<input id="lastAme" name="lastAme" type="hidden" value="${djPeopleBaseNLPage.lastAme }">
					<input id="firstName" name="firstName" type="hidden" value="${djPeopleBaseNLPage.firstName }">
					<input id="entryTime" name="entryTime" type="hidden" value="${djPeopleBaseNLPage.entryTime }">
					<input id="dueTime" name="dueTime" type="hidden" value="${djPeopleBaseNLPage.dueTime }">
					<input id="peoType" name="peoType" type="hidden" value="${djPeopleBaseNLPage.peoType }">
					<input id="nationality" name="nationality" type="hidden" value="${djPeopleBaseNLPage.nationality }">
					<%-- <input id="pHouse" name="pHouse" type="hidden" value="${djPeopleBaseNLPage.pHouse }"> --%>
				   
				   
				    <input id="villageCurrentb"  type="hidden" value="${djPeopleBaseNLPage.villageCurrent }">
					<input id="ridgeNoCurrentb"  type="hidden" value="${djPeopleBaseNLPage.ridgeNoCurrent }">
					<input id="floorNoCurrentb"  type="hidden" value="${djPeopleBaseNLPage.floorNoCurrent }">
					<input id="roomNoCurrentb"  type="hidden" value="${djPeopleBaseNLPage.roomNoCurrent }">
					
					<input id="districtPerm" name="districtPerm" type="hidden" value="${djPeopleBaseNLPage.districtPerm }">
					<input id="townPerm" name="townPerm" type="hidden" value="${djPeopleBaseNLPage.townPerm }">
					<input id="villagePerm" name="villagePerm" type="hidden" value="${djPeopleBaseNLPage.villagePerm }">
					<input id="roomNoPerm" name="roomNoPerm" type="hidden" value="${djPeopleBaseNLPage.roomNoPerm }">
					<input id="currentDistrict" name="currentDistrict" type="hidden" value="${djPeopleBaseNLPage.currentDistrict }">
					<input id="currentAddress" name="currentAddress" type="hidden" value="${djPeopleBaseNLPage.currentAddress }">
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
										       value='${djPeopleBaseNLPage.name}'>
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
						      						 value='<fmt:formatDate value='${djPeopleBaseNLPage.birthdate}' type="date" pattern="yyyy-MM-dd"/>'>    
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
										typeGroupCode="id_type" defaultVal="${djPeopleBaseNLPage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
									               
										       value='${djPeopleBaseNLPage.idNo}'>
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
										typeGroupCode="sex" defaultVal="${djPeopleBaseNLPage.sex}" hasLabel="false"  title="性别"></t:dictSelect>     
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
									               
										       value='${djPeopleBaseNLPage.birthPlace}'>
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
									               
										       value='${djPeopleBaseNLPage.usedName}'>
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
									               
										       value='${djPeopleBaseNLPage.sign}'>
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
									               
										       value='${djPeopleBaseNLPage.nation}'>
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
									               
										       value='${djPeopleBaseNLPage.height}'>
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
										typeGroupCode="blood_type" defaultVal="${djPeopleBaseNLPage.bloodType}" hasLabel="false"  title="血型"></t:dictSelect>     
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
										typeGroupCode="degree" defaultVal="${djPeopleBaseNLPage.degree}" hasLabel="false"  title="学历"></t:dictSelect>     
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
										typeGroupCode="m_status" defaultVal="${djPeopleBaseNLPage.maritalStatus}" hasLabel="false"  title="婚姻状况"></t:dictSelect>     
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
									               
										       value='${djPeopleBaseNLPage.spouseName}'>
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
									               
										       value='${djPeopleBaseNLPage.tel}'>
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
									               
										       value='${djPeopleBaseNLPage.phone}'>
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
									               
										       value='${djPeopleBaseNLPage.job}'>
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
									               
										       value='${djPeopleBaseNLPage.workAddress}'>
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
										typeGroupCode="is_army" defaultVal="${djPeopleBaseNLPage.isArmy}" hasLabel="false"  title="兵役状况"></t:dictSelect>     
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
									               
										       value='${djPeopleBaseNLPage.armyRemark}'>
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
						     	 <input id="permanentDistrict" name="permanentDistrict" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djPeopleBaseNLPage.permanentDistrict}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户籍地区</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								户籍地址:
							</label>
						</td>
						<td class="value">
						     	 <input id="permanentAddress" name="permanentAddress" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djPeopleBaseNLPage.permanentAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户籍地址</label>
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
										typeGroupCode="dist_type" defaultVal="${djPeopleBaseNLPage.districtCurrent}" hasLabel="false"  title="现居住地区"></t:dictSelect>     
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
										typeGroupCode="town_type" defaultVal="${djPeopleBaseNLPage.townCurrent}" hasLabel="false"  title="现居住村"></t:dictSelect>     
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
										typeGroupCode="vill_type" defaultVal="${djPeopleBaseNLPage.villageCurrent}" hasLabel="false"  title="现居所属宅"></t:dictSelect> --%>     
							  <select name="villageCurrent" id="villageCurrent" onchange="getRidgeNoCurrent()"> 
							    <%--联动获取 该宅下面的所有的 门牌号 --%>
							    <option value selected="selected" >--请选择--</option>
								<option value="段泾桥宅">段泾桥宅</option>
								<option value="泗塘宅" >泗塘宅</option>
								<option value="陆家宅" >陆家宅</option>
								<option value="支家楼宅" >支家楼宅</option>
								<option value="西北宅" >西北宅</option>
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
										typeGroupCode="" defaultVal="${djPeopleBaseNLPage.ridgeNoCurrent}" hasLabel="false"  title="现居门牌号"></t:dictSelect>      --%>
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
										typeGroupCode="" defaultVal="${djPeopleBaseNLPage.floorNoCurrent}" hasLabel="false"  title="现居楼层"></t:dictSelect>      --%>
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
										typeGroupCode="" defaultVal="${djPeopleBaseNLPage.roomNoCurrent}" hasLabel="false"  title="现居房间号"></t:dictSelect>  --%>    
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
									               
										       value='${djPeopleBaseNLPage.remark}'>
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
  <script src = "webpage/com/dj/people/nolocalpeople/djPeopleBaseNL.js"></script>		