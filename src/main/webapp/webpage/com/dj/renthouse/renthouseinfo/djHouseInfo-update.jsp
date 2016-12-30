<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>出租房信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djHouseInfoController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djHouseInfoPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djHouseInfoPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djHouseInfoPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djHouseInfoPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djHouseInfoPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djHouseInfoPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djHouseInfoPage.updateDate }">
					<input id="floorNo" name="floorNo" type="hidden" value="${djHouseInfoPage.floorNo }">
					<input id="isNull" name="isNull" type="hidden" value="${djHouseInfoPage.isNull }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								户主姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djHouseInfoPage.name}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户主姓名</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								证件类型:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="idType" type="list"
										typeGroupCode="id_type" defaultVal="${djHouseInfoPage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
						     	 <input id="idNum" name="idNum" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djHouseInfoPage.idNum}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">证件号码</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								房屋所在区:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="district" type="list"
										typeGroupCode="" defaultVal="${djHouseInfoPage.district}" hasLabel="false"  title="房屋所在区"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房屋所在区</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								房屋所在村:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="town" type="list"
										typeGroupCode="" defaultVal="${djHouseInfoPage.town}" hasLabel="false"  title="房屋所在村"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房屋所在村</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								房屋所属宅:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="village" type="list"
										typeGroupCode="" defaultVal="${djHouseInfoPage.village}" hasLabel="false"  title="房屋所属宅"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房屋所属宅</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								门牌号:
							</label>
						</td>
						<td class="value">
						     	 <input id="ridgeNo" name="ridgeNo" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djHouseInfoPage.ridgeNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">门牌号</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								房间号:
							</label>
						</td>
						<td class="value">
						     	 <input id="roomNo" name="roomNo" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djHouseInfoPage.roomNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房间号</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/renthouse/renthouseinfo/djHouseInfo.js"></script>		