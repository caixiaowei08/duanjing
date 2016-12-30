<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>无证摊位</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djFoodSanitationController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djFoodSanitationPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djFoodSanitationPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djFoodSanitationPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djFoodSanitationPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djFoodSanitationPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djFoodSanitationPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djFoodSanitationPage.updateDate }">
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
										       value='${djFoodSanitationPage.name}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								性别:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="sex" type="radio"
										typeGroupCode="sex" defaultVal="${djFoodSanitationPage.sex}" hasLabel="false"  title="性别"></t:dictSelect>     
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
										typeGroupCode="id_type" defaultVal="${djFoodSanitationPage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
									               datatype="*"
										       value='${djFoodSanitationPage.idNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">证件号码</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								联系电话:
							</label>
						</td>
						<td class="value">
						     	 <input id="foodTel" name="foodTel" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djFoodSanitationPage.foodTel}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">联系电话</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								经营项目:
							</label>
						</td>
						<td class="value">
						     	 <input id="foodItem" name="foodItem" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djFoodSanitationPage.foodItem}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">经营项目</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								经营地点:
							</label>
						</td>
						<td class="value">
						     	 <input id="foodAddress" name="foodAddress" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djFoodSanitationPage.foodAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">经营地点</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								是否有证:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="foodIsCertificate" type="list"
										typeGroupCode="sf_yn" defaultVal="${djFoodSanitationPage.foodIsCertificate}" hasLabel="false"  title="是否有证"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否有证</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								是否取缔:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="foodIsProhibit" type="list"
										typeGroupCode="sf_yn" defaultVal="${djFoodSanitationPage.foodIsProhibit}" hasLabel="false"  title="是否取缔"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否取缔</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="foodRemark" name="foodRemark" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djFoodSanitationPage.foodRemark}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/health/food/djFoodSanitation.js"></script>		