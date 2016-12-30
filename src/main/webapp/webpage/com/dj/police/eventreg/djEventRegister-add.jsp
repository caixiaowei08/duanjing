<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>事件登记</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djEventRegisterController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djEventRegisterPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djEventRegisterPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djEventRegisterPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djEventRegisterPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djEventRegisterPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djEventRegisterPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djEventRegisterPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							案件名称:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="eventName" type="list"
									typeGroupCode="case_name" defaultVal="${djEventRegisterPage.eventName}" hasLabel="false"  title="案件名称"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">案件名称</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							发生时间:
						</label>
					</td>
					<td class="value">
							   <input id="eventTirme" name="eventTirme" type="text" style="width: 150px" 
					      						 class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
								                
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发生时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							报案时间:
						</label>
					</td>
					<td class="value">
							   <input id="eventReportTime" name="eventReportTime" type="text" style="width: 150px" 
					      						 class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
								                
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">报案时间</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							报案人:
						</label>
					</td>
					<td class="value">
					     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">报案人</label>
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
									typeGroupCode="id_type" defaultVal="${djEventRegisterPage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">证件类型</label>
						</td>
				<tr>
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
							地址:
						</label>
					</td>
					<td class="value">
					     	 <input id="eventAddress" name="eventAddress" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">地址</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							电话:
						</label>
					</td>
					<td class="value">
					     	 <input id="eventTel" name="eventTel" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">电话</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							涉案价值:
						</label>
					</td>
					<td class="value">
					     	 <input id="eventValue" name="eventValue" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">涉案价值</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="eventRemark" name="eventRemark" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/police/eventreg/djEventRegister.js"></script>		