<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>企业安全or消防检查</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djEnterpriseSecurityCheckController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djEnterpriseSecurityCheckPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djEnterpriseSecurityCheckPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djEnterpriseSecurityCheckPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djEnterpriseSecurityCheckPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djEnterpriseSecurityCheckPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djEnterpriseSecurityCheckPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djEnterpriseSecurityCheckPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								检查时间:
							</label>
						</td>
						<td class="value">
									  <input id="enterTime" name="enterTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									               datatype="*" 
						      						 value='<fmt:formatDate value='${djEnterpriseSecurityCheckPage.enterTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">检查时间</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								安全or消防:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="enterType" type="radio"
										typeGroupCode="secur_type" defaultVal="${djEnterpriseSecurityCheckPage.enterType}" hasLabel="false"  title="安全or消防"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">安全or消防</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								检查单位:
							</label>
						</td>
						<td class="value">
						     	 <input id="enterCheckDept" name="enterCheckDept" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djEnterpriseSecurityCheckPage.enterCheckDept}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">检查单位</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								被检查单位:
							</label>
						</td>
						<td class="value">
						     	 <input id="enterCheckedDept" name="enterCheckedDept" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djEnterpriseSecurityCheckPage.enterCheckedDept}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">被检查单位</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								检查人:
							</label>
						</td>
						<td class="value">
						     	 <input id="enterChecker" name="enterChecker" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djEnterpriseSecurityCheckPage.enterChecker}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">检查人</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								检查项目:
							</label>
						</td>
						<td class="value">
						     	 <input id="enterItem" name="enterItem" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djEnterpriseSecurityCheckPage.enterItem}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">检查项目</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								检查情况:
							</label>
						</td>
						<td class="value">
						     	 <input id="enterStatus" name="enterStatus" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djEnterpriseSecurityCheckPage.enterStatus}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">检查情况</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="enterRemark" name="enterRemark" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djEnterpriseSecurityCheckPage.enterRemark}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/enterprise/entersecurity/djEnterpriseSecurityCheck.js"></script>		