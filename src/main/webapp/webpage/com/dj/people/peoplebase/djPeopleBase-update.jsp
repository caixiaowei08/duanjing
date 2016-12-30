<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>人员基表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djPeopleBaseController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djPeopleBasePage.id }">
					<input id="createName" name="createName" type="hidden" value="${djPeopleBasePage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djPeopleBasePage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djPeopleBasePage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djPeopleBasePage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djPeopleBasePage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djPeopleBasePage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<%-- <tr>
						<td align="right">
							<label class="Validform_label">
								英文姓:
							</label>
						</td>
						<td class="value">
						     	 <input id="lastAme" name="lastAme" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPeopleBasePage.lastAme}'>
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
									               
										       value='${djPeopleBasePage.firstName}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">英文名</label>
						</td>
					</tr> --%>
					<tr>
						<td align="right">
							<label class="Validform_label">
								中文姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPeopleBasePage.name}'>
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
									                
						      						 value='<fmt:formatDate value='${djPeopleBasePage.birthdate}' type="date" pattern="yyyy-MM-dd"/>'>    
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
										typeGroupCode="id_type" defaultVal="${djPeopleBasePage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
									               
										       value='${djPeopleBasePage.idNo}'>
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
										typeGroupCode="sex" defaultVal="${djPeopleBasePage.sex}" hasLabel="false"  title="性别"></t:dictSelect>     
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
									               
										       value='${djPeopleBasePage.birthPlace}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">籍贯</label>
						</td>
					</tr>
				<%-- 	<tr>
						<td align="right">
							<label class="Validform_label">
								入境时间:
							</label>
						</td>
						<td class="value">
									  <input id="entryTime" name="entryTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${djPeopleBasePage.entryTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">入境时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								到期时间:
							</label>
						</td>
						<td class="value">
									  <input id="dueTime" name="dueTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${djPeopleBasePage.dueTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">到期时间</label>
						</td>
					</tr> --%>
					<tr>
						<td align="right">
							<label class="Validform_label">
								人口来源:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="peoType" type="list"
										typeGroupCode="peo_type" defaultVal="${djPeopleBasePage.peoType}" hasLabel="false"  title="人口来源"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">人口来源</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								国籍:
							</label>
						</td>
						<td class="value">
						     	 <input id="nationality" name="nationality" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPeopleBasePage.nationality}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">国籍</label>
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
									               
										       value='${djPeopleBasePage.usedName}'>
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
									               
										       value='${djPeopleBasePage.sign}'>
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
									               
										       value='${djPeopleBasePage.nation}'>
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
									               
										       value='${djPeopleBasePage.height}'>
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
										typeGroupCode="blood_type" defaultVal="${djPeopleBasePage.bloodType}" hasLabel="false"  title="血型"></t:dictSelect>     
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
										typeGroupCode="degree" defaultVal="${djPeopleBasePage.degree}" hasLabel="false"  title="学历"></t:dictSelect>     
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
										typeGroupCode="m_status" defaultVal="${djPeopleBasePage.maritalStatus}" hasLabel="false"  title="婚姻状况"></t:dictSelect>     
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
									               
										       value='${djPeopleBasePage.spouseName}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">配偶姓名</label>
						</td>
					</tr>
					<tr>
						 <td align="right">
							<!-- <label class="Validform_label">
								人户分离:
							</label> -->
						</td>
						<td class="value">
									<%-- <t:dictSelect field="pHouse" type="list"
										typeGroupCode="p_house" defaultVal="${djPeopleBasePage.pHouse}" hasLabel="false"  title="人户分离"></t:dictSelect>  --%>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">人户分离</label>
						</td> 
						<td align="right">
							<label class="Validform_label">
								座机:
							</label>
						</td>
						<td class="value">
						     	 <input id="tel" name="tel" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPeopleBasePage.tel}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">座机</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								手机:
							</label>
						</td>
						<td class="value">
						     	 <input id="phone" name="phone" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPeopleBasePage.phone}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">手机</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								职业:
							</label>
						</td>
						<td class="value">
						     	 <input id="job" name="job" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPeopleBasePage.job}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">职业</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								工作地点:
							</label>
						</td>
						<td class="value">
						     	 <input id="workAddress" name="workAddress" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPeopleBasePage.workAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">工作地点</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								兵役状况:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="isArmy" type="list"
										typeGroupCode="is_army" defaultVal="${djPeopleBasePage.isArmy}" hasLabel="false"  title="兵役状况"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">兵役状况</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								兵役详情:
							</label>
						</td>
						<td class="value">
						     	 <input id="armyRemark" name="armyRemark" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPeopleBasePage.armyRemark}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">兵役详情</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								户籍地区:
							</label>
						</td>
						<td class="value">
						     	 <input id="permanentDistrict" name="permanentDistrict" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPeopleBasePage.permanentDistrict}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户籍地区</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								户籍地址:
							</label>
						</td>
						<td class="value">
						     	 <input id="permanentAddress" name="permanentAddress" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPeopleBasePage.permanentAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户籍地址</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								户籍地区:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="districtPerm" type="list"
										typeGroupCode="dist_type" defaultVal="${djPeopleBasePage.districtPerm}" hasLabel="false"  title="户籍地区"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户籍地区</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								户籍所在村:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="townPerm" type="list"
										typeGroupCode="town_type" defaultVal="${djPeopleBasePage.townPerm}" hasLabel="false"  title="户籍所在村"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户籍所在村</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								户籍所属宅:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="villagePerm" type="list"
										typeGroupCode="vill_type" defaultVal="${djPeopleBasePage.villagePerm}" hasLabel="false"  title="户籍所属宅"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户籍所属宅</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								户籍门牌号:
							</label>
						</td>
						<td class="value">
									<%-- <t:dictSelect field="roomNoPerm" type="list"
										typeGroupCode="" defaultVal="${djPeopleBasePage.roomNoPerm}" hasLabel="false"  title="户籍门牌号"></t:dictSelect>  --%>  
							 <input id="roomNoPerm" name="roomNoPerm" type="text" style="width: 150px" class="inputxt"  
										       value='${djPeopleBasePage.roomNoPerm}'>			  
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户籍门牌号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								现居住地区:
							</label>
						</td>
						<td class="value">
						     	 <input id="currentDistrict" name="currentDistrict" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPeopleBasePage.currentDistrict}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居住地区</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								现居住地址:
							</label>
						</td>
						<td class="value">
						     	 <input id="currentAddress" name="currentAddress" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPeopleBasePage.currentAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居住地址</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								现居住地区:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="districtCurrent" type="list"
										typeGroupCode="dist_type" defaultVal="${djPeopleBasePage.districtCurrent}" hasLabel="false"  title="现居住地区"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居住地区</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								现居住村:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="townCurrent" type="list"
										typeGroupCode="town_type" defaultVal="${djPeopleBasePage.townCurrent}" hasLabel="false"  title="现居住村"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居住村</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								现居所属宅:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="villageCurrent" type="list"
										typeGroupCode="vill_type" defaultVal="${djPeopleBasePage.villageCurrent}" hasLabel="false"  title="现居所属宅"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居所属宅</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								现居门牌号:
							</label>
						</td>
						<td class="value">
							<%-- 		<t:dictSelect field="ridgeNoCurrent" type="list"
										typeGroupCode="" defaultVal="${djPeopleBasePage.ridgeNoCurrent}" hasLabel="false"  title="现居门牌号"></t:dictSelect>  --%>
							<input id="ridgeNoCurrent" name="ridgeNoCurrent" type="text" style="width: 150px" class="inputxt"  
										       value='${djPeopleBasePage.ridgeNoCurrent}'>				    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居门牌号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								现居楼层:
							</label>
						</td>
						<td class="value">
									<%-- <t:dictSelect field="floorNoCurrent" type="list"
										typeGroupCode="" defaultVal="${djPeopleBasePage.floorNoCurrent}" hasLabel="false"  title="现居楼层"></t:dictSelect>    --%>
										
								<input id="floorNoCurrent" name="floorNoCurrent" type="text" style="width: 150px" class="inputxt"  
										       value='${djPeopleBasePage.floorNoCurrent}'>			  
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居楼层</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								现居房间号:
							</label>
						</td>
						<td class="value">
									<%-- <t:dictSelect field="roomNoCurrent" type="list"
										typeGroupCode="" defaultVal="${djPeopleBasePage.roomNoCurrent}" hasLabel="false"  title="现居房间号"></t:dictSelect>   --%> 
							<input id="roomNoCurrent" name="roomNoCurrent" type="text" style="width: 150px" class="inputxt"  
										       value='${djPeopleBasePage.roomNoCurrent}'>				  
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居房间号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="remark" name="remark" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPeopleBasePage.remark}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/people/peoplebase/djPeopleBase.js"></script>		