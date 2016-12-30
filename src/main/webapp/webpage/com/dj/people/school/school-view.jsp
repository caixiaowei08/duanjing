<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>子女就学</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="schoolController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${schoolPage.id }">
					<input id="createName" name="createName" type="hidden" value="${schoolPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${schoolPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${schoolPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${schoolPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${schoolPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${schoolPage.updateDate }">
					<input id="guardianId" name="guardianId" type="hidden" value="${schoolPage.guardianId }">
					
					
					<hr width=80% size=3 color=#84C1FF style="FILTER: alpha(opacity=100,finishopacity=0,style=1)"> 		
				    <div align="center"><label  class="Validform_label">子女基本信息详情</label></div>
				    <hr width=80% size=3 color=#84C1FF style="FILTER: alpha(opacity=100,finishopacity=0,style=1)"> 
		     
		     
		          <table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
		          
		          <tr>
						<td align="right">
							<label class="Validform_label">
								姓名:
							</label>
						</td>
						<td class="value">
						 <input id="idNo" name="idNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${schoolPage.name}'>
									<%-- <t:dictSelect field="name" type="list"
										typeGroupCode="" defaultVal="${schoolPage.name}" hasLabel="false"  title="姓名"></t:dictSelect>  --%> 
										
										   
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								人口来源:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="peoType" type="list"
										typeGroupCode="peo_type" defaultVal="${schoolPage.peoType}" hasLabel="false"  title="人口来源"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">人口来源</label>
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
										typeGroupCode="id_type" defaultVal="${schoolPage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
									               
										       value='${schoolPage.idNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">证件号码</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								生日:
							</label>
						</td>
						<td class="value">
						     	 <input id="birthdate" name="birthdate" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${schoolPage.birthdate}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">生日</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								性别:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="sex" type="radio"
										typeGroupCode="sex" defaultVal="${schoolPage.sex}" hasLabel="false"  title="性别"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">性别</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								出生地:
							</label>
						</td>
						<td class="value">
						     	 <input id="birthPlace" name="birthPlace" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${schoolPage.birthPlace}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">出生地</label>
						</td>
						<td align="right">
							<!-- <label class="Validform_label">
								搜索人:
							</label> -->
						</td>
						<td class="value">
						     	<%--  <input id="searchPeople" name="searchPeople" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${schoolPage.searchPeople}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">搜索人</label> --%>
						</td> 
					</tr>
					
					</table>
					
					<hr width=80% size=3 color=#84C1FF style="FILTER: alpha(opacity=100,finishopacity=0,style=1)"> 		
				    <div align="center"><label  class="Validform_label">子女就学基本信息</label></div>
				    <hr width=80% size=3 color=#84C1FF style="FILTER: alpha(opacity=100,finishopacity=0,style=1)"> 	
					<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								监护人:
							</label>
						</td>
						<td class="value">
						 <input id="guardianIdNo" name="guardianIdNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${schoolPage.guardianName}'>
									<%-- <t:dictSelect field="guardianName" type="list"
										typeGroupCode="" defaultVal="${schoolPage.guardianName}" hasLabel="false"  title="监护人"></t:dictSelect>   --%> 
								  
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">监护人</label>
						</td>
						<td align="right">
						<!-- 	<label class="Validform_label">
								搜索监护人:
							</label> -->
						</td>
						<td class="value">
						 <%--     	 <input id="searchGuardian" name="searchGuardian" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${schoolPage.searchGuardian}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">搜索监护人</label> --%>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								监护人证件类型:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="guardianIdType" type="list"
										typeGroupCode="id_type" defaultVal="${schoolPage.guardianIdType}" hasLabel="false"  title="监护人证件类型"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">监护人证件类型</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								监护人证件号码:
							</label>
						</td>
						<td class="value">
						     	 <input id="guardianIdNo" name="guardianIdNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${schoolPage.guardianIdNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">监护人证件号码</label>
						</td>
					</tr>
					
					<tr>
						<td align="right">
							<label class="Validform_label">
								与监护人关系:
							</label>
						</td>
						<td class="value">
						     	 <input id="guardianRelationship" name="guardianRelationship" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${schoolPage.guardianRelationship}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">与监护人关系</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								入学时间:
							</label>
						</td>
						<td class="value">
									  <input id="entranceTime" name="entranceTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									               datatype="*" 
						      						 value='<fmt:formatDate value='${schoolPage.entranceTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">入学时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								学校名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="schoolName" name="schoolName" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${schoolPage.schoolName}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学校名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								学校类型:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="schoolType" type="list"
										typeGroupCode="scho_type" defaultVal="${schoolPage.schoolType}" hasLabel="false"  title="学校类型"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学校类型</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								学校地址:
							</label>
						</td>
						<td class="value">
						     	 <input id="schoolAddress" name="schoolAddress" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${schoolPage.schoolAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学校地址</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								学校电话:
							</label>
						</td>
						<td class="value">
						     	 <input id="schoolTel" name="schoolTel" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${schoolPage.schoolTel}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学校电话</label>
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
									               
										       value='${schoolPage.remark}'>
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
  <script src = "webpage/com/dj/people/school/school.js"></script>		