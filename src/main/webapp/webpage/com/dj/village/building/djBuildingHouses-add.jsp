<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>建房管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djBuildingHousesController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djBuildingHousesPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djBuildingHousesPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djBuildingHousesPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djBuildingHousesPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djBuildingHousesPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djBuildingHousesPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djBuildingHousesPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							姓名:
						</label>
					</td>
					<td class="value">
					     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
						</td>
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
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							证件类型:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="idType" type="list"
									typeGroupCode="id_type" defaultVal="${djBuildingHousesPage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">证件号码</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							文化程度:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="degree" type="list"
									typeGroupCode="degree" defaultVal="${djBuildingHousesPage.degree}" hasLabel="false"  title="文化程度"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">文化程度</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							户籍地址:
						</label>
					</td>
					<td class="value">
					     	 <input id="permanentAddress" name="permanentAddress" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户籍地址</label>
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
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居住地址</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							申请事项:
						</label>
					</td>
					<td class="value">
					     	 <input id="buildAppliItems" name="buildAppliItems" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请事项</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							申请时间:
						</label>
					</td>
					<td class="value">
							   <input id="buildAppliTime" name="buildAppliTime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
								               datatype="*" 
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							材料是否齐全:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="buildMaterial" type="radio"
									typeGroupCode="sf_yn" defaultVal="${djBuildingHousesPage.buildMaterial}" hasLabel="false"  title="材料是否齐全"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">材料是否齐全</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							原房屋结构:
						</label>
					</td>
					<td class="value">
					     	 <input id="buildOldStruc" name="buildOldStruc" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">原房屋结构</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							原房屋建筑面积:
						</label>
					</td>
					<td class="value">
					     	 <input id="buildOldArea" name="buildOldArea" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">原房屋建筑面积</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							现结构:
						</label>
					</td>
					<td class="value">
					     	 <input id="buildNewStruc" name="buildNewStruc" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现结构</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							现批复面积:
						</label>
					</td>
					<td class="value">
					     	 <input id="buildNowArea" name="buildNowArea" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现批复面积</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							建设日期:
						</label>
					</td>
					<td class="value">
							   <input id="buildStartTime" name="buildStartTime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
								               datatype="*" 
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">建设日期</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							竣工日期:
						</label>
					</td>
					<td class="value">
							   <input id="buildFinishTime" name="buildFinishTime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
								               datatype="*" 
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">竣工日期</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="buildRemark" name="buildRemark" type="text" style="width: 150px" class="inputxt"
								               
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
  <script src = "webpage/com/dj/village/building/djBuildingHouses.js"></script>		