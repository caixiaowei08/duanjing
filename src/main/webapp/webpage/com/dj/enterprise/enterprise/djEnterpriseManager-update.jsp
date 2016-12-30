<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>企事业单位管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djEnterpriseManagerController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djEnterpriseManagerPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djEnterpriseManagerPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djEnterpriseManagerPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djEnterpriseManagerPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djEnterpriseManagerPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djEnterpriseManagerPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djEnterpriseManagerPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								单位名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="enterName" name="enterName" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djEnterpriseManagerPage.enterName}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单位名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								单位地址:
							</label>
						</td>
						<td class="value">
						     	 <input id="enterAddress" name="enterAddress" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djEnterpriseManagerPage.enterAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单位地址</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								法人代表:
							</label>
						</td>
						<td class="value">
						     	 <input id="enterLegalPerson" name="enterLegalPerson" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djEnterpriseManagerPage.enterLegalPerson}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">法人代表</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								法人证件类型:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="idType" type="list"
										typeGroupCode="id_type" defaultVal="${djEnterpriseManagerPage.idType}" hasLabel="false"  title="法人证件类型"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">法人证件类型</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								法人证件号:
							</label>
						</td>
						<td class="value">
						     	 <input id="idNo" name="idNo" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djEnterpriseManagerPage.idNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">法人证件号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								法人电话:
							</label>
						</td>
						<td class="value">
						     	 <input id="enterLegalTel" name="enterLegalTel" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djEnterpriseManagerPage.enterLegalTel}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">法人电话</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								常务负责人:
							</label>
						</td>
						<td class="value">
						     	 <input id="enterRoutineName" name="enterRoutineName" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djEnterpriseManagerPage.enterRoutineName}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">常务负责人</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								负责人联系电话:
							</label>
						</td>
						<td class="value">
						     	 <input id="enterRoutineTel" name="enterRoutineTel" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djEnterpriseManagerPage.enterRoutineTel}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">负责人联系电话</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								是否合制:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="enterIsCoProd" type="list"
										typeGroupCode="sf_yn" defaultVal="${djEnterpriseManagerPage.enterIsCoProd}" hasLabel="false"  title="是否合制"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否合制</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								经营项目:
							</label>
						</td>
						<td class="value">
						     	 <input id="enterOperItems" name="enterOperItems" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djEnterpriseManagerPage.enterOperItems}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">经营项目</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								员工人数:
							</label>
						</td>
						<td class="value">
						     	 <input id="enterNumberEmployee" name="enterNumberEmployee" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djEnterpriseManagerPage.enterNumberEmployee}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">员工人数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								签约时间:
							</label>
						</td>
						<td class="value">
									  <input id="enterTime" name="enterTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${djEnterpriseManagerPage.enterTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">签约时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								签约期限:
							</label>
						</td>
						<td class="value">
						     	 <input id="enterDeadlline" name="enterDeadlline" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djEnterpriseManagerPage.enterDeadlline}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">签约期限</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								签约人:
							</label>
						</td>
						<td class="value">
						     	 <input id="enterContract" name="enterContract" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djEnterpriseManagerPage.enterContract}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">签约人</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								是否消防重点单位:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="enterIsFire" type="list"
										typeGroupCode="sf_yn" defaultVal="${djEnterpriseManagerPage.enterIsFire}" hasLabel="false"  title="是否消防重点单位"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否消防重点单位</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="enterRemark" name="enterRemark" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djEnterpriseManagerPage.enterRemark}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/enterprise/enterprise/djEnterpriseManager.js"></script>		