<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>社保管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djSocialInsuranceController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djSocialInsurancePage.id }">
					<input id="createName" name="createName" type="hidden" value="${djSocialInsurancePage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djSocialInsurancePage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djSocialInsurancePage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djSocialInsurancePage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djSocialInsurancePage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djSocialInsurancePage.updateDate }">
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
										       value='${djSocialInsurancePage.name}'>
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
										typeGroupCode="sex" defaultVal="${djSocialInsurancePage.sex}" hasLabel="false"  title="性别"></t:dictSelect>     
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
										typeGroupCode="id_type" defaultVal="${djSocialInsurancePage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
										       value='${djSocialInsurancePage.idNo}'>
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
										typeGroupCode="degree" defaultVal="${djSocialInsurancePage.degree}" hasLabel="false"  title="文化程度"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">文化程度</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								户籍地址:
							</label>
						</td>
						<td class="value">
						     	 <input id="permanentAddress" name="permanentAddress" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djSocialInsurancePage.permanentAddress}'>
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
									               
										       value='${djSocialInsurancePage.currentAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居住地址</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								社保类型:
							</label>
						</td>
						<td class="value">
						     	 <input id="socialType" name="socialType" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djSocialInsurancePage.socialType}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">社保类型</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								入保时间:
							</label>
						</td>
						<td class="value">
									  <input id="socialEnterTime" name="socialEnterTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                datatype="*" 
						      						value='<fmt:formatDate value='${djSocialInsurancePage.socialEnterTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">入保时间</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="socialRemark" name="socialRemark" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djSocialInsurancePage.socialRemark}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/civil/insurance/djSocialInsurance.js"></script>		