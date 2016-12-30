<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>残疾人管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djDisabledPeopleController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djDisabledPeoplePage.id }">
					<input id="createName" name="createName" type="hidden" value="${djDisabledPeoplePage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djDisabledPeoplePage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djDisabledPeoplePage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djDisabledPeoplePage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djDisabledPeoplePage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djDisabledPeoplePage.updateDate }">
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
							证件类型:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="idType" type="list"
									typeGroupCode="id_type" defaultVal="${djDisabledPeoplePage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
								               >
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
									typeGroupCode="degree" defaultVal="${djDisabledPeoplePage.degree}" hasLabel="false"  title="文化程度"></t:dictSelect>     
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
								               
								               >
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
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居住地址</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							残疾证号:
						</label>
					</td>
					<td class="value">
					     	 <input id="disabledNo" name="disabledNo" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">残疾证号</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							残疾状况:
						</label>
					</td>
					<td class="value">
					     	 <input id="disabledStatus" name="disabledStatus" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">残疾状况</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							发放机关:
						</label>
					</td>
					<td class="value">
					     	 <input id="disabledDept" name="disabledDept" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发放机关</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							发放时间:
						</label>
					</td>
					<td class="value">
							   <input id="disabledProvideTime" name="disabledProvideTime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
								                
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发放时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							监护人:
						</label>
					</td>
					<td class="value">
					     	 <input id="disabledGuardian" name="disabledGuardian" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">监护人</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							劳动能力:
						</label>
					</td>
					<td class="value">
					     	 <input id="disabledLabor" name="disabledLabor" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">劳动能力</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							技能特长:
						</label>
					</td>
					<td class="value">
					     	 <input id="disabledAbility" name="disabledAbility" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">技能特长</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="disabledRemark" name="disabledRemark" type="text" style="width: 150px" class="inputxt"
								               
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
  <script src = "webpage/com/dj/civil/disabled/djDisabledPeople.js"></script>		