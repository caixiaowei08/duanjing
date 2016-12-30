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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djSecurityIncidentsController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djSecurityIncidentsPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djSecurityIncidentsPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djSecurityIncidentsPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djSecurityIncidentsPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djSecurityIncidentsPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djSecurityIncidentsPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djSecurityIncidentsPage.updateDate }">
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
									                
						      						 value='<fmt:formatDate value='${djSecurityIncidentsPage.incideTime}' type="date" pattern="yyyy-MM-dd"/>'>    
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
									               
										       value='${djSecurityIncidentsPage.incideDept}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">事故单位</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								地址:
							</label>
						</td>
						<td class="value">
						     	 <input id="incideAddress" name="incideAddress" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djSecurityIncidentsPage.incideAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">地址</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								伤亡情况:
							</label>
						</td>
						<td class="value">
						     	 <input id="incideCasualtyNum" name="incideCasualtyNum" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djSecurityIncidentsPage.incideCasualtyNum}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">伤亡情况</label>
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
									               
										       value='${djSecurityIncidentsPage.incideReason}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">责任原因</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								责任人:
							</label>
						</td>
						<td class="value">
						     	 <input id="incideOfficer" name="incideOfficer" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djSecurityIncidentsPage.incideOfficer}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">责任人</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								查处结果:
							</label>
						</td>
						<td class="value">
						     	 <input id="incideCheckResult" name="incideCheckResult" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djSecurityIncidentsPage.incideCheckResult}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">查处结果</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="incideRemark" name="incideRemark" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djSecurityIncidentsPage.incideRemark}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/enterprise/enterincidents/djSecurityIncidents.js"></script>		