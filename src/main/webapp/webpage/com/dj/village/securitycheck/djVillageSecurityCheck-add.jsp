<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>安全or消防检查</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djVillageSecurityCheckController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djVillageSecurityCheckPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djVillageSecurityCheckPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djVillageSecurityCheckPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djVillageSecurityCheckPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djVillageSecurityCheckPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djVillageSecurityCheckPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djVillageSecurityCheckPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							检查时间:
						</label>
					</td>
					<td class="value">
							   <input id="villaTime" name="villaTime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
								               datatype="*" 
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">检查时间</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							被检查单位:
						</label>
					</td>
					<td class="value">
					     	 <input id="villaCheckedDept" name="villaCheckedDept" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">被检查单位</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							安全or消防:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="villaType" type="radio"
									typeGroupCode="secur_type" defaultVal="${djVillageSecurityCheckPage.villaType}" hasLabel="false"  title="安全or消防"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">安全or消防</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							检查项目:
						</label>
					</td>
					<td class="value">
					     	 <input id="villaItem" name="villaItem" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">检查项目</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							检查人:
						</label>
					</td>
					<td class="value">
					     	 <input id="villaChecker" name="villaChecker" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">检查人</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							检查情况:
						</label>
					</td>
					<td class="value">
					     	 <input id="villaStatus" name="villaStatus" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">检查情况</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="villaRemark" name="villaRemark" type="text" style="width: 150px" class="inputxt"
								               
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
  <script src = "webpage/com/dj/village/securitycheck/djVillageSecurityCheck.js"></script>		