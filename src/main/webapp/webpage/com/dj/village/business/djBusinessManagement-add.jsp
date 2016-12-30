<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>事务管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djBusinessManagementController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djBusinessManagementPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djBusinessManagementPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djBusinessManagementPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djBusinessManagementPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djBusinessManagementPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djBusinessManagementPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djBusinessManagementPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							事务名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="businessName" name="businessName" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">事务名称</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							主管部门:
						</label>
					</td>
					<td class="value">
					     	 <input id="businessDept" name="businessDept" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">主管部门</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							时间:
						</label>
					</td>
					<td class="value">
							   <input id="businessTime" name="businessTime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
								               datatype="*" 
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">时间</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							经办人:
						</label>
					</td>
					<td class="value">
					     	 <input id="businessOperator" name="businessOperator" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">经办人</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							主持人:
						</label>
					</td>
					<td class="value">
					     	 <input id="businessHost" name="businessHost" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">主持人</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							参加对象:
						</label>
					</td>
					<td class="value">
					     	 <input id="businessJoiners" name="businessJoiners" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">参加对象</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							内容摘要:
						</label>
					</td>
					<td class="value">
					     	 <input id="businessDetail" name="businessDetail" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">内容摘要</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="businessRemark" name="businessRemark" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/village/business/djBusinessManagement.js"></script>		