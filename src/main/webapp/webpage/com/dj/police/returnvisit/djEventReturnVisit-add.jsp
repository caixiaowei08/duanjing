<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>事件回访</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djEventReturnVisitController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djEventReturnVisitPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djEventReturnVisitPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djEventReturnVisitPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djEventReturnVisitPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djEventReturnVisitPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djEventReturnVisitPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djEventReturnVisitPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							责任民警:
						</label>
					</td>
					<td class="value">
					     	 <input id="returnResponPolice" name="returnResponPolice" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">责任民警</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							回访时间:
						</label>
					</td>
					<td class="value">
							   <input id="returnTime" name="returnTime" type="text" style="width: 150px" 
					      						 class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
								               datatype="*" 
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">回访时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							被回访人姓名:
						</label>
					</td>
					<td class="value">
					     	 <input id="returnName" name="returnName" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">被回访人姓名</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							证件类型:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="idType" type="list"
									typeGroupCode="id_type" defaultVal="${djEventReturnVisitPage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">证件类型</label>
						</td>
					</tr>
				<tr>
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
				<tr>
					<td align="right">
						<label class="Validform_label">
							电话:
						</label>
					</td>
					<td class="value">
					     	 <input id="returnTel" name="returnTel" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">电话</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							回访结果:
						</label>
					</td>
					<td class="value">
					     	 <input id="returnResult" name="returnResult" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">回访结果</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="returnRemark" name="returnRemark" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/police/returnvisit/djEventReturnVisit.js"></script>		