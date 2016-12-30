<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>文件管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djDocumentManagementController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djDocumentManagementPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djDocumentManagementPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djDocumentManagementPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djDocumentManagementPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djDocumentManagementPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djDocumentManagementPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djDocumentManagementPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								文件名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="documentName" name="documentName" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djDocumentManagementPage.documentName}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">文件名称</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								发文单位:
							</label>
						</td>
						<td class="value">
						     	 <input id="documentDept" name="documentDept" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djDocumentManagementPage.documentDept}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发文单位</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								发文时间:
							</label>
						</td>
						<td class="value">
									  <input id="documentTime" name="documentTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									               datatype="*" 
						      						 value='<fmt:formatDate value='${djDocumentManagementPage.documentTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发文时间</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								文号:
							</label>
						</td>
						<td class="value">
						     	 <input id="documentNo" name="documentNo" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djDocumentManagementPage.documentNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">文号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								责任人:
							</label>
						</td>
						<td class="value">
						     	 <input id="documentPerson" name="documentPerson" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djDocumentManagementPage.documentPerson}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">责任人</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								内容摘要:
							</label>
						</td>
						<td class="value">
						     	 <input id="documentDetail" name="documentDetail" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djDocumentManagementPage.documentDetail}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">内容摘要</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								保管人:
							</label>
						</td>
						<td class="value">
						     	 <input id="documentKeeper" name="documentKeeper" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djDocumentManagementPage.documentKeeper}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">保管人</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="documentRemark" name="documentRemark" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djDocumentManagementPage.documentRemark}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/village/document/djDocumentManagement.js"></script>		