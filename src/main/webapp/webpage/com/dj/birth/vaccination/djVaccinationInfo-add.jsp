<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>幼儿预防接种记录</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djVaccinationInfoController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djVaccinationInfoPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djVaccinationInfoPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djVaccinationInfoPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djVaccinationInfoPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djVaccinationInfoPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djVaccinationInfoPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djVaccinationInfoPage.updateDate }">
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
							生日:
						</label>
					</td>
					<td class="value">
							   <input id="birthdate" name="birthdate" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
								               datatype="*" 
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">生日</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							证件类型:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="idType" type="list"
									typeGroupCode="id_type" defaultVal="${djVaccinationInfoPage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">证件号码</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							籍贯:
						</label>
					</td>
					<td class="value">
					     	 <input id="birthPlace" name="birthPlace" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">籍贯</label>
						</td>
					</tr>
				<tr>
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
					<td align="right">
						<label class="Validform_label">
							现居住地区:
						</label>
					</td>
					<td class="value">
					     	 <input id="currentAddress" name="currentAddress" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居住地区</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							父亲姓名:
						</label>
					</td>
					<td class="value">
					     	 <input id="fatherName" name="fatherName" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">父亲姓名</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							母亲姓名:
						</label>
					</td>
					<td class="value">
					     	 <input id="motherName" name="motherName" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">母亲姓名</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							手机:
						</label>
					</td>
					<td class="value">
					     	 <input id="phone" name="phone" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">手机</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							座机:
						</label>
					</td>
					<td class="value">
					     	 <input id="tel" name="tel" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">座机</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否预防接种:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="isVaccination" type="radio"
									typeGroupCode="sf_yn" defaultVal="${djVaccinationInfoPage.isVaccination}" hasLabel="false"  title="是否预防接种"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否预防接种</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							预防接种时间:
						</label>
					</td>
					<td class="value">
							   <input id="vaccination" name="vaccination" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
								                
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">预防接种时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="remark" name="remark" type="text" style="width: 150px" class="inputxt"
								               
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
  <script src = "webpage/com/dj/birth/vaccination/djVaccinationInfo.js"></script>		