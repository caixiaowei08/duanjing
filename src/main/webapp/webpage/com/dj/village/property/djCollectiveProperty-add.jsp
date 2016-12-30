<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>集体财产管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djCollectivePropertyController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djCollectivePropertyPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djCollectivePropertyPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djCollectivePropertyPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djCollectivePropertyPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djCollectivePropertyPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djCollectivePropertyPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djCollectivePropertyPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							物品名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="propertyName" name="propertyName" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">物品名称</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							数量:
						</label>
					</td>
					<td class="value">
					     	 <input id="propertyNum" name="propertyNum" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">数量</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							价值:
						</label>
					</td>
					<td class="value">
					     	 <input id="propertyWorth" name="propertyWorth" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">价值</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							使用人:
						</label>
					</td>
					<td class="value">
					     	 <input id="propertyUser" name="propertyUser" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">使用人</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							管理方式:
						</label>
					</td>
					<td class="value">
					     	 <input id="propertyManagStyle" name="propertyManagStyle" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">管理方式</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							存放情况:
						</label>
					</td>
					<td class="value">
					     	 <input id="propertyStorCondi" name="propertyStorCondi" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">存放情况</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否报废:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="propertyIsScrap" type="list"
									typeGroupCode="sf_yn" defaultVal="${djCollectivePropertyPage.propertyIsScrap}" hasLabel="false"  title="是否报废"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否报废</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="propertyRemark" name="propertyRemark" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/village/property/djCollectiveProperty.js"></script>		