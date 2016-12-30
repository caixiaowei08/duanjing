<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>失业人员</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djUnemployedPersonController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djUnemployedPersonPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djUnemployedPersonPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djUnemployedPersonPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djUnemployedPersonPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djUnemployedPersonPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djUnemployedPersonPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djUnemployedPersonPage.updateDate }">
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
									typeGroupCode="id_type" defaultVal="${djUnemployedPersonPage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
									typeGroupCode="degree" defaultVal="${djUnemployedPersonPage.degree}" hasLabel="false"  title="文化程度"></t:dictSelect>     
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
							原工作单位:
						</label>
					</td>
					<td class="value">
					     	 <input id="unemplOldCom" name="unemplOldCom" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">原工作单位</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							失业日期:
						</label>
					</td>
					<td class="value">
							   <input id="unemplTime" name="unemplTime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
								               datatype="*" 
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">失业日期</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							失业原因:
						</label>
					</td>
					<td class="value">
					     	 <input id="unemplReason" name="unemplReason" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">失业原因</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否再就业:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="unemplIsReEmpl" type="list"
									typeGroupCode="sf_yn" defaultVal="${djUnemployedPersonPage.unemplIsReEmpl}" hasLabel="false"  title="是否再就业"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否再就业</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							是否低保:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="unemplIsLow" type="list"
									typeGroupCode="sf_yn" defaultVal="${djUnemployedPersonPage.unemplIsLow}" hasLabel="false"  title="是否低保"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否低保</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							求职意向:
						</label>
					</td>
					<td class="value">
					     	 <input id="unemplJobIntension" name="unemplJobIntension" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">求职意向</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="unemplRemark" name="unemplRemark" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/civil/unemployed/djUnemployedPerson.js"></script>		