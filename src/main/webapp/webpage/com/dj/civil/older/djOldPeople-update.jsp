<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>老人管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djOldPeopleController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djOldPeoplePage.id }">
					<input id="createName" name="createName" type="hidden" value="${djOldPeoplePage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djOldPeoplePage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djOldPeoplePage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djOldPeoplePage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djOldPeoplePage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djOldPeoplePage.updateDate }">
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
										       value='${djOldPeoplePage.name}'>
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
										typeGroupCode="sex" defaultVal="${djOldPeoplePage.sex}" hasLabel="false"  title="性别"></t:dictSelect>     
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
										typeGroupCode="id_type" defaultVal="${djOldPeoplePage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
										       value='${djOldPeoplePage.idNo}'>
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
										typeGroupCode="degree" defaultVal="${djOldPeoplePage.degree}" hasLabel="false"  title="文化程度"></t:dictSelect>     
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
									               
										       value='${djOldPeoplePage.permanentAddress}'>
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
									               
										       value='${djOldPeoplePage.currentAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居住地址</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								退休时间:
							</label>
						</td>
						<td class="value">
									  <input id="retirementTime" name="retirementTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${djOldPeoplePage.retirementTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">退休时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								退休单位:
							</label>
						</td>
						<td class="value">
						     	 <input id="retirementCompany" name="retirementCompany" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djOldPeoplePage.retirementCompany}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">退休单位</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								目前状况:
							</label>
						</td>
						<td class="value">
						     	 <input id="retirementStatus" name="retirementStatus" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djOldPeoplePage.retirementStatus}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">目前状况</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								经济来源:
							</label>
						</td>
						<td class="value">
						     	 <input id="retirementSrcFina" name="retirementSrcFina" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djOldPeoplePage.retirementSrcFina}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">经济来源</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="retirementRemark" name="retirementRemark" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djOldPeoplePage.retirementRemark}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/civil/older/djOldPeople.js"></script>		