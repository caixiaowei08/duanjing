<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>现服役人员</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djMilitaryActiveController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djMilitaryActivePage.id }">
					<input id="createName" name="createName" type="hidden" value="${djMilitaryActivePage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djMilitaryActivePage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djMilitaryActivePage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djMilitaryActivePage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djMilitaryActivePage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djMilitaryActivePage.updateDate }">
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
										       value='${djMilitaryActivePage.name}'>
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
										typeGroupCode="sex" defaultVal="${djMilitaryActivePage.sex}" hasLabel="false"  title="性别"></t:dictSelect>     
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
										typeGroupCode="id_type" defaultVal="${djMilitaryActivePage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
										       value='${djMilitaryActivePage.idNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">证件号码</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								学历:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="degree" type="list"
										typeGroupCode="degree" defaultVal="${djMilitaryActivePage.degree}" hasLabel="false"  title="学历"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学历</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								户籍地址:
							</label>
						</td>
						<td class="value">
						     	 <input id="permanentAddress" name="permanentAddress" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djMilitaryActivePage.permanentAddress}'>
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
									               
										       value='${djMilitaryActivePage.currentAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居住地址</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								征兵时间:
							</label>
						</td>
						<td class="value">
									  <input id="draftTime" name="draftTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${djMilitaryActivePage.draftTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">征兵时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								体检时间:
							</label>
						</td>
						<td class="value">
									  <input id="healthExamTime" name="healthExamTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${djMilitaryActivePage.healthExamTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">体检时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								政审时间:
							</label>
						</td>
						<td class="value">
									  <input id="politicsTime" name="politicsTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${djMilitaryActivePage.politicsTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">政审时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								入伍时间:
							</label>
						</td>
						<td class="value">
									  <input id="militaryTime" name="militaryTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									               datatype="*" 
						      						 value='<fmt:formatDate value='${djMilitaryActivePage.militaryTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">入伍时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								兵役年限:
							</label>
						</td>
						<td class="value">
						     	 <input id="militaryAgeLimit" name="militaryAgeLimit" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djMilitaryActivePage.militaryAgeLimit}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">兵役年限</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								兵种类型:
							</label>
						</td>
						<td class="value">
						     	 <input id="soldierType" name="soldierType" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djMilitaryActivePage.soldierType}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">兵种类型</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								部队类型:
							</label>
						</td>
						<td class="value">
						     	 <input id="militaryType" name="militaryType" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djMilitaryActivePage.militaryType}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">部队类型</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								部队地址:
							</label>
						</td>
						<td class="value">
						     	 <input id="militaryAddress" name="militaryAddress" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djMilitaryActivePage.militaryAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">部队地址</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="remark" name="remark" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djMilitaryActivePage.remark}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/military/militaryActive/djMilitaryActive.js"></script>		