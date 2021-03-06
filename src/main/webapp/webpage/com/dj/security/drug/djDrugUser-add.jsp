<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>吸毒人员</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djDrugUserController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djDrugUserPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djDrugUserPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djDrugUserPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djDrugUserPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djDrugUserPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djDrugUserPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djDrugUserPage.updateDate }">
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
									typeGroupCode="id_type" defaultVal="${djDrugUserPage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
									typeGroupCode="degree" defaultVal="${djDrugUserPage.degree}" hasLabel="false"  title="文化程度"></t:dictSelect>     
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
							婚姻状况:
						</label>
					</td>
					<td class="value">
					     	<!--  <input id="maritalStatus" name="maritalStatus" type="text" style="width: 150px" class="inputxt"
								               
								               > -->
							<t:dictSelect field="maritalStatus" type="list"
										typeGroupCode="m_status" hasLabel="false"  title="婚姻状况"></t:dictSelect>  	               
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">婚姻状况</label>
						</td>
					</tr>
				<tr>
					<!-- <td align="right">
						<label class="Validform_label">
							人员id:
						</label>
					</td>
					<td class="value">
					     	 <input id="pid" name="pid" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">人员id</label>
						</td> -->
					<td align="right">
						<label class="Validform_label">
							案别:
						</label>
					</td>
					<td class="value">
					     	 <input id="drugItem" name="drugItem" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">案别</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							吸食毒品类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="drugDrugItem" name="drugDrugItem" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">吸食毒品类型</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							处理时间:
						</label>
					</td>
					<td class="value">
							   <input id="drugDealTime" name="drugDealTime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
								               datatype="*" 
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">处理时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							处理结果:
						</label>
					</td>
					<td class="value">
					     	 <input id="drugResult" name="drugResult" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">处理结果</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							目前状态:
						</label>
					</td>
					<td class="value">
					     	 <input id="drugStatus" name="drugStatus" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">目前状态</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							联系电话:
						</label>
					</td>
					<td class="value">
					     	 <input id="drugTel" name="drugTel" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">联系电话</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="drugRemark" name="drugRemark" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/security/drug/djDrugUser.js"></script>		