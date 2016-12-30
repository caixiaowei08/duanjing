<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>房屋登记</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djHouseController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djHousePage.id }">
					<input id="createName" name="createName" type="hidden" value="${djHousePage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djHousePage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djHousePage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djHousePage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djHousePage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djHousePage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								户主姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djHousePage.name}'>
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
										typeGroupCode="id_type" defaultVal="${djHousePage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
									               datatype="*"
										       value='${djHousePage.idNo}'>
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
										typeGroupCode="dist_type" defaultVal="${djHousePage.district}" hasLabel="false"  title="房屋所在区"></t:dictSelect>     
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
										typeGroupCode="town_type" defaultVal="${djHousePage.town}" hasLabel="false"  title="房屋所在村"></t:dictSelect>     
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
										typeGroupCode="vill_type" defaultVal="${djHousePage.village}" hasLabel="false"  title="房屋所属宅"></t:dictSelect>     
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
										       value='${djHousePage.ridgeNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">门牌号</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								院落门禁:
							</label>
						</td>
						<td class="value">
						     	 <input id="guardNum" name="guardNum" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djHousePage.guardNum}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">院落门禁</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								视频监控:
							</label>
						</td>
						<td class="value">
						     	 <input id="videoNum" name="videoNum" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djHousePage.videoNum}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">视频监控</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								防盗报警装置:
							</label>
						</td>
						<td class="value">
						     	 <input id="alarmNum" name="alarmNum" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djHousePage.alarmNum}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">防盗报警装置</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/renthouse/house/djHouse.js"></script>		