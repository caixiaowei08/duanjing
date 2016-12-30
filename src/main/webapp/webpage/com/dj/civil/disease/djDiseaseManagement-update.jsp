<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>重大疾病管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djDiseaseManagementController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djDiseaseManagementPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djDiseaseManagementPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djDiseaseManagementPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djDiseaseManagementPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djDiseaseManagementPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djDiseaseManagementPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djDiseaseManagementPage.updateDate }">
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
										       value='${djDiseaseManagementPage.name}'>
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
										typeGroupCode="sex" defaultVal="${djDiseaseManagementPage.sex}" hasLabel="false"  title="性别"></t:dictSelect>     
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
										typeGroupCode="id_type" defaultVal="${djDiseaseManagementPage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
										       value='${djDiseaseManagementPage.idNo}'>
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
										typeGroupCode="degree" defaultVal="${djDiseaseManagementPage.degree}" hasLabel="false"  title="文化程度"></t:dictSelect>     
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
									               
										       value='${djDiseaseManagementPage.permanentAddress}'>
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
									               
										       value='${djDiseaseManagementPage.currentAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居住地址</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								疾病类型:
							</label>
						</td>
						<td class="value">
						     	 <input id="diseaseType" name="diseaseType" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djDiseaseManagementPage.diseaseType}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">疾病类型</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								疾病名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="diseaseName" name="diseaseName" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djDiseaseManagementPage.diseaseName}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">疾病名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								患病时间:
							</label>
						</td>
						<td class="value">
						     	 <input id="diseaseTime" name="diseaseTime" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djDiseaseManagementPage.diseaseTime}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">患病时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								是否传染:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="diseaseIsInfect" type="list"
										typeGroupCode="sf_yn" defaultVal="${djDiseaseManagementPage.diseaseIsInfect}" hasLabel="false"  title="是否传染"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否传染</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								是否隔离:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="diseaseIsIsolation" type="list"
										typeGroupCode="sf_yn" defaultVal="${djDiseaseManagementPage.diseaseIsIsolation}" hasLabel="false"  title="是否隔离"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否隔离</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								治疗状况:
							</label>
						</td>
						<td class="value">
						     	 <input id="diseaseStatus" name="diseaseStatus" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djDiseaseManagementPage.diseaseStatus}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">治疗状况</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								是否医保:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="diseaseIsNsurance" type="list"
										typeGroupCode="sf_yn" defaultVal="${djDiseaseManagementPage.diseaseIsNsurance}" hasLabel="false"  title="是否医保"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否医保</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="diseaseRemark" name="diseaseRemark" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djDiseaseManagementPage.diseaseRemark}'>
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
  <script src = "webpage/com/dj/civil/disease/djDiseaseManagement.js"></script>		