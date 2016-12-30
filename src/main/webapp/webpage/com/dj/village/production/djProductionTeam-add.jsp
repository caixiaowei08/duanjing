<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>生产队</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djProductionTeamController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djProductionTeamPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djProductionTeamPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djProductionTeamPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djProductionTeamPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djProductionTeamPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djProductionTeamPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djProductionTeamPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							生产队:
						</label>
					</td>
					<td class="value">
					     	 <input id="produTeam" name="produTeam" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">生产队</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							队长:
						</label>
					</td>
					<td class="value">
					     	 <input id="produCaptain" name="produCaptain" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">队长</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							户籍户数:
						</label>
					</td>
					<td class="value">
					     	 <input id="produLocalHouse" name="produLocalHouse" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户籍户数</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							户籍人数:
						</label>
					</td>
					<td class="value">
					     	 <input id="produLocalNoP" name="produLocalNoP" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户籍人数</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							来沪人员人数:
						</label>
					</td>
					<td class="value">
					     	 <input id="produNonlocalNoP" name="produNonlocalNoP" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">来沪人员人数</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出租户数:
						</label>
					</td>
					<td class="value">
					     	 <input id="produRentHouse" name="produRentHouse" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">出租户数</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出租间数:
						</label>
					</td>
					<td class="value">
					     	 <input id="produRentRoom" name="produRentRoom" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">出租间数</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							耕地面积:
						</label>
					</td>
					<td class="value">
					     	 <input id="produPloughArea" name="produPloughArea" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">耕地面积</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="produRemark" name="produRemark" type="text" style="width: 150px" class="inputxt"
								               
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
  <script src = "webpage/com/dj/village/production/djProductionTeam.js"></script>		