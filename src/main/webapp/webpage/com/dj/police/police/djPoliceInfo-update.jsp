<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>社区民警</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djPoliceInfoController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djPoliceInfoPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djPoliceInfoPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djPoliceInfoPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djPoliceInfoPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djPoliceInfoPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djPoliceInfoPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djPoliceInfoPage.updateDate }">
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
										       value='${djPoliceInfoPage.name}'>
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
										typeGroupCode="sex" defaultVal="${djPoliceInfoPage.sex}" hasLabel="false"  title="性别"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">性别</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								警号:
							</label>
						</td>
						<td class="value">
						     	 <input id="policeNum" name="policeNum" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djPoliceInfoPage.policeNum}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">警号</label>
						</td>
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
						      						 value='<fmt:formatDate value='${djPoliceInfoPage.birthdate}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">生日</label>
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
										typeGroupCode="degree" defaultVal="${djPoliceInfoPage.degree}" hasLabel="false"  title="学历"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学历</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								电话:
							</label>
						</td>
						<td class="value">
						     	 <input id="phone" name="phone" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djPoliceInfoPage.phone}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">电话</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								来村工作时间:
							</label>
						</td>
						<td class="value">
									  <input id="workHour" name="workHour" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									               datatype="*" 
						      						 value='<fmt:formatDate value='${djPoliceInfoPage.workHour}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">来村工作时间</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								职务:
							</label>
						</td>
						<td class="value">
						     	 <input id="job" name="job" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djPoliceInfoPage.job}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">职务</label>
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
									               
										       value='${djPoliceInfoPage.remark}'>
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
  <script src = "webpage/com/dj/police/police/djPoliceInfo.js"></script>		