<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>兵役适龄人员</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djMilitaryAgeMatController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djMilitaryAgeMatPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djMilitaryAgeMatPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djMilitaryAgeMatPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djMilitaryAgeMatPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djMilitaryAgeMatPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djMilitaryAgeMatPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djMilitaryAgeMatPage.updateDate }">
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
										       value='${djMilitaryAgeMatPage.name}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								生日:
							</label>
						</td>
						<td class="value">
									  <input id="birthdate" name="birthdate" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									               datatype="*" 
						      						 value='<fmt:formatDate value='${djMilitaryAgeMatPage.birthdate}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">生日</label>
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
										typeGroupCode="id_type" defaultVal="${djMilitaryAgeMatPage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
									               
										       value='${djMilitaryAgeMatPage.idNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">证件号码</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								性别:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="sex" type="radio"
										typeGroupCode="sex" defaultVal="${djMilitaryAgeMatPage.sex}" hasLabel="false"  title="性别"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">性别</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								籍贯:
							</label>
						</td>
						<td class="value">
						     	 <input id="birthPlace" name="birthPlace" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djMilitaryAgeMatPage.birthPlace}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">籍贯</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								曾用名:
							</label>
						</td>
						<td class="value">
						     	 <input id="usedName" name="usedName" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djMilitaryAgeMatPage.usedName}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">曾用名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								体征:
							</label>
						</td>
						<td class="value">
						     	 <input id="sign" name="sign" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djMilitaryAgeMatPage.sign}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">体征</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								民族:
							</label>
						</td>
						<td class="value">
						     	 <input id="nation" name="nation" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djMilitaryAgeMatPage.nation}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">民族</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								身高:
							</label>
						</td>
						<td class="value">
						     	 <input id="height" name="height" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djMilitaryAgeMatPage.height}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">身高</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								血型:
							</label>
						</td>
						<td class="value">
						     	 <input id="bloodType" name="bloodType" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djMilitaryAgeMatPage.bloodType}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">血型</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								学历:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="degree" type="list"
										typeGroupCode="degree" defaultVal="${djMilitaryAgeMatPage.degree}" hasLabel="false"  title="学历"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学历</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								户籍地址:
							</label>
						</td>
						<td class="value">
						     	 <input id="permanentAddress" name="permanentAddress" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djMilitaryAgeMatPage.permanentAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户籍地址</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								现居住地址:
							</label>
						</td>
						<td class="value">
						     	 <input id="currentAddress" name="currentAddress" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djMilitaryAgeMatPage.currentAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居住地址</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								手机:
							</label>
						</td>
						<td class="value">
						     	 <input id="phone" name="phone" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djMilitaryAgeMatPage.phone}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">手机</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								座机:
							</label>
						</td>
						<td class="value">
						     	 <input id="tel" name="tel" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djMilitaryAgeMatPage.tel}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">座机</label>
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
									               
										       value='${djMilitaryAgeMatPage.remark}'>
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
  <script src = "webpage/com/dj/military/militaryAgeMat/djMilitaryAgeMat.js"></script>		