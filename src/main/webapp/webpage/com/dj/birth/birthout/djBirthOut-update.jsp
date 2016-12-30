<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>计划外生育</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djBirthOutController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djBirthOutPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djBirthOutPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djBirthOutPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djBirthOutPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djBirthOutPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djBirthOutPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djBirthOutPage.updateDate }">
					<input id="pid" name="pid" type="hidden" value="${djBirthOutPage.pid }">
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
										       value='${djBirthOutPage.name}'>
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
										typeGroupCode="sex" defaultVal="${djBirthOutPage.sex}" hasLabel="false"  title="性别"></t:dictSelect>     
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
										typeGroupCode="id_type" defaultVal="${djBirthOutPage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
										       value='${djBirthOutPage.idNo}'>
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
									typeGroupCode="degree" defaultVal="${djBirthOutPage.degree}" hasLabel="false"  title="文化程度"></t:dictSelect> 	       
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
									               
										       value='${djBirthOutPage.permanentAddress}'>
										       
										       
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
									               
										       value='${djBirthOutPage.currentAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居住地址</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								婚姻状况:
							</label>
						</td>
						<td class="value">
						     	<%--  <input id="maritalStatus" name="maritalStatus" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djBirthOutPage.maritalStatus}'> --%>
									<t:dictSelect field="maritalStatus" type="list"
									typeGroupCode="m_status" hasLabel="false" defaultVal='${djBirthOutPage.maritalStatus}' title="婚姻状况"></t:dictSelect> 		       
										       
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">婚姻状况</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								人口来源:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="peoType" type="list"
										typeGroupCode="peo_type" defaultVal="${djBirthOutPage.peoType}" hasLabel="false"  title="人口来源"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">人口来源</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								是否计划:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="birthoutIsPlan" type="list"
										typeGroupCode="sf_yn" defaultVal="${djBirthOutPage.birthoutIsPlan}" hasLabel="false"  title="是否计划"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否计划</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								怀孕时间:
							</label>
						</td>
						<td class="value">
									  <input id="birthoutPregnancyTime" name="birthoutPregnancyTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${djBirthOutPage.birthoutPregnancyTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">怀孕时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								产检医院:
							</label>
						</td>
						<td class="value">
						     	 <input id="birthoutHospitalCare" name="birthoutHospitalCare" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djBirthOutPage.birthoutHospitalCare}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">产检医院</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								生产医院:
							</label>
						</td>
						<td class="value">
						     	 <input id="birthoutHospitalGive" name="birthoutHospitalGive" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djBirthOutPage.birthoutHospitalGive}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">生产医院</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								生育时间:
							</label>
						</td>
						<td class="value">
									  <input id="birthoutTime" name="birthoutTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${djBirthOutPage.birthoutTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">生育时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								生育情况:
							</label>
						</td>
						<td class="value">
						     	 <input id="birthoutStatus" name="birthoutStatus" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djBirthOutPage.birthoutStatus}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">生育情况</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="birthoutRemark" name="birthoutRemark" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djBirthOutPage.birthoutRemark}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/birth/birthout/djBirthOut.js"></script>		