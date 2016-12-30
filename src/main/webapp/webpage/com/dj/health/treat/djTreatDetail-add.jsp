<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>就诊记录</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djTreatDetailController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djTreatDetailPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djTreatDetailPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djTreatDetailPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djTreatDetailPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djTreatDetailPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djTreatDetailPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djTreatDetailPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							就诊时间:
						</label>
					</td>
					<td class="value">
							   <input id="treatTime" name="treatTime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
								               datatype="*" 
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">就诊时间</label>
						</td>
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
					</tr>
				<tr>
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
				<tr>
					<td align="right">
						<label class="Validform_label">
							住址:
						</label>
					</td>
					<td class="value">
					     	 <input id="currentAddress" name="currentAddress" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">住址</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							联系电话:
						</label>
					</td>
					<td class="value">
					     	 <input id="phone" name="phone" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">联系电话</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							诊断情况:
						</label>
					</td>
					<td class="value">
					     	 <input id="treatDetail" name="treatDetail" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">诊断情况</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							诊断医师:
						</label>
					</td>
					<td class="value">
					     	 <input id="treatDoctor" name="treatDoctor" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">诊断医师</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							发药情况:
						</label>
					</td>
					<td class="value">
					     	 <input id="treatMedicine" name="treatMedicine" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发药情况</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否医保:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="treatIsInsurance" type="radio"
									typeGroupCode="sf_yn" defaultVal="${djTreatDetailPage.treatIsInsurance}" hasLabel="false"  title="是否医保"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否医保</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="treatRemark" name="treatRemark" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/health/treat/djTreatDetail.js"></script>		