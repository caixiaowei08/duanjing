<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>违章建筑</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djPeccantBuildingController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djPeccantBuildingPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djPeccantBuildingPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djPeccantBuildingPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djPeccantBuildingPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djPeccantBuildingPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djPeccantBuildingPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djPeccantBuildingPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								违章建筑地址:
							</label>
						</td>
						<td class="value">
						     	 <input id="peccantAddress" name="peccantAddress" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPeccantBuildingPage.peccantAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">违章建筑地址</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								所有人姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPeccantBuildingPage.name}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所有人姓名</label>
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
										typeGroupCode="sex" defaultVal="${djPeccantBuildingPage.sex}" hasLabel="false"  title="性别"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">性别</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								证件类型:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="idType" type="list"
										typeGroupCode="id_type" defaultVal="${djPeccantBuildingPage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">证件类型</label>
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
									               
										       value='${djPeccantBuildingPage.idNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">证件号码</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								文化程度:
							</label>
						</td>
						<td class="value">
						     	 <t:dictSelect field="degree" type="list"
									typeGroupCode="degree" defaultVal="${djPeccantBuildingPage.degree}" hasLabel="false"  title="学历"></t:dictSelect>     	               
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">文化程度</label>
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
									               
										       value='${djPeccantBuildingPage.permanentAddress}'>
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
									               
										       value='${djPeccantBuildingPage.currentAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居住地址</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								违章情况:
							</label>
						</td>
						<td class="value">
						     	 <input id="peccantDetail" name="peccantDetail" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPeccantBuildingPage.peccantDetail}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">违章情况</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								是否拆除:
							</label>
						</td>
						<td class="value">
						     	<t:dictSelect field="peccantIsRemove" type="list"
									typeGroupCode="sf_yn" defaultVal="${djPeccantBuildingPage.peccantIsRemove}" hasLabel="false"  title="是否报废"></t:dictSelect> 
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否拆除</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								整改情况:
							</label>
						</td>
						<td class="value">
						     	 <input id="peccantRectifi" name="peccantRectifi" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPeccantBuildingPage.peccantRectifi}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">整改情况</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="peccantRemark" name="peccantRemark" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPeccantBuildingPage.peccantRemark}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/village/peccant/djPeccantBuilding.js"></script>		