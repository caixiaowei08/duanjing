<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>任务管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djTaskManagementController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djTaskManagementPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djTaskManagementPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djTaskManagementPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djTaskManagementPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djTaskManagementPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djTaskManagementPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djTaskManagementPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								任务名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="taskName" name="taskName" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djTaskManagementPage.taskName}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">任务名称</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								发布部门:
							</label>
						</td>
						<td class="value">
						     	 <input id="taskDept" name="taskDept" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djTaskManagementPage.taskDept}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发布部门</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								发布时间:
							</label>
						</td>
						<td class="value">
									  <input id="taskReleaseTime" name="taskReleaseTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									               datatype="*" 
						      						 value='<fmt:formatDate value='${djTaskManagementPage.taskReleaseTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发布时间</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								责任人:
							</label>
						</td>
						<td class="value">
						     	 <input id="taskResponsiblePerson" name="taskResponsiblePerson" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djTaskManagementPage.taskResponsiblePerson}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">责任人</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								联系电话:
							</label>
						</td>
						<td class="value">
						     	 <input id="taskTel" name="taskTel" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djTaskManagementPage.taskTel}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">联系电话</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								完成日期:
							</label>
						</td>
						<td class="value">
									  <input id="taskEndTime" name="taskEndTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									               datatype="*" 
						      						 value='<fmt:formatDate value='${djTaskManagementPage.taskEndTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">完成日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								完成情况:
							</label>
						</td>
						<td class="value">
						     	 <input id="taskDetailInfo" name="taskDetailInfo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djTaskManagementPage.taskDetailInfo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">完成情况</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="taskRemark" name="taskRemark" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djTaskManagementPage.taskRemark}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/village/task/djTaskManagement.js"></script>		