<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>外来人口原始数据</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djRawDataFilePeopleController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djRawDataFilePeoplePage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djRawDataFilePeoplePage.name}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								曾用名:
							</label>
						</td>
						<td class="value">
						     	 <input id="usedName" name="usedName" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djRawDataFilePeoplePage.usedName}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">曾用名</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								证件号码:
							</label>
						</td>
						<td class="value">
						     	 <input id="idNo" name="idNo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djRawDataFilePeoplePage.idNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">证件号码</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								性别:
							</label>
						</td>
						<td class="value">
						     	 <input id="sex" name="sex" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djRawDataFilePeoplePage.sex}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">性别</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								出生日期:
							</label>
						</td>
						<td class="value">
						     	 <input id="birthdate" name="birthdate" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djRawDataFilePeoplePage.birthdate}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">出生日期</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								民族:
							</label>
						</td>
						<td class="value">
						     	 <input id="nation" name="nation" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djRawDataFilePeoplePage.nation}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">民族</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								籍贯:
							</label>
						</td>
						<td class="value">
						     	 <input id="birthPlace" name="birthPlace" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djRawDataFilePeoplePage.birthPlace}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">籍贯</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								血型:
							</label>
						</td>
						<td class="value">
						     	 <input id="bloodType" name="bloodType" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djRawDataFilePeoplePage.bloodType}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">血型</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								身高:
							</label>
						</td>
						<td class="value">
						     	 <input id="height" name="height" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djRawDataFilePeoplePage.height}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">身高</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								文化程度:
							</label>
						</td>
						<td class="value">
						     	 <input id="degree" name="degree" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djRawDataFilePeoplePage.degree}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">文化程度</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								婚姻状况:
							</label>
						</td>
						<td class="value">
						     	 <input id="maritalStatus" name="maritalStatus" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djRawDataFilePeoplePage.maritalStatus}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">婚姻状况</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								工作单位:
							</label>
						</td>
						<td class="value">
						     	 <input id="workAddress" name="workAddress" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djRawDataFilePeoplePage.workAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">工作单位</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								所属公安机关:
							</label>
						</td>
						<td class="value">
						     	 <input id="bbb" name="bbb" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djRawDataFilePeoplePage.bbb}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所属公安机关</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								配偶姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="spouseName" name="spouseName" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djRawDataFilePeoplePage.spouseName}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">配偶姓名</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								宗教信仰:
							</label>
						</td>
						<td class="value">
						     	 <input id="aaa" name="aaa" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djRawDataFilePeoplePage.aaa}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">宗教信仰</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								户籍地行政区划:
							</label>
						</td>
						<td class="value">
						     	 <input id="permanentDistrict" name="permanentDistrict" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djRawDataFilePeoplePage.permanentDistrict}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户籍地行政区划</label>
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
									               
										       value='${djRawDataFilePeoplePage.permanentAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户籍地址</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								居住地行政区划:
							</label>
						</td>
						<td class="value">
						     	 <input id="currentDistrict" name="currentDistrict" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djRawDataFilePeoplePage.currentDistrict}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">居住地行政区划</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								居住地址:
							</label>
						</td>
						<td class="value">
						     	 <input id="currentAddress" name="currentAddress" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djRawDataFilePeoplePage.currentAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">居住地址</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								实有人口类别:
							</label>
						</td>
						<td class="value">
						     	 <input id="peoType" name="peoType" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djRawDataFilePeoplePage.peoType}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实有人口类别</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								证件种类:
							</label>
						</td>
						<td class="value">
						     	 <input id="idType" name="idType" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djRawDataFilePeoplePage.idType}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">证件种类</label>
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
  <script src = "webpage/com/dj/rawdata/people01/djRawDataFilePeople.js"></script>		