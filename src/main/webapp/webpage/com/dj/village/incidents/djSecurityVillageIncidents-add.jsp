<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>安全事故</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djSecurityVillageIncidentsController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djSecurityVillageIncidentsPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djSecurityVillageIncidentsPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djSecurityVillageIncidentsPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djSecurityVillageIncidentsPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djSecurityVillageIncidentsPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djSecurityVillageIncidentsPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djSecurityVillageIncidentsPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							事故时间:
						</label>
					</td>
					<td class="value">
							   <input id="incideTime" name="incideTime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
								               datatype="*" 
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">事故时间</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							事故单位:
						</label>
					</td>
					<td class="value">
					     	 <input id="incideDept" name="incideDept" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">事故单位</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							伤亡情况:
						</label>
					</td>
					<td class="value">
					     	 <input id="incideCasualtyNum" name="incideCasualtyNum" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">伤亡情况</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							责任人:
						</label>
					</td>
					<td class="value">
					     	 <input id="incideOfficer" name="incideOfficer" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">责任人</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							责任原因:
						</label>
					</td>
					<td class="value">
					     	 <input id="incideReason" name="incideReason" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">责任原因</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							查出结果:
						</label>
					</td>
					<td class="value">
					     	 <input id="incideCheckResult" name="incideCheckResult" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">查出结果</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="incideRemark" name="incideRemark" type="text" style="width: 150px" class="inputxt"
								               
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
  <script src = "webpage/com/dj/village/incidents/djSecurityVillageIncidents.js"></script>		