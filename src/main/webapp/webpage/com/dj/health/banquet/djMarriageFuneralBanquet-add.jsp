<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>婚丧宴席申报</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djMarriageFuneralBanquetController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djMarriageFuneralBanquetPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djMarriageFuneralBanquetPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djMarriageFuneralBanquetPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djMarriageFuneralBanquetPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djMarriageFuneralBanquetPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djMarriageFuneralBanquetPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djMarriageFuneralBanquetPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							申报人:
						</label>
					</td>
					<td class="value">
					     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申报人</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							宴席类别:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="banquetType" type="list"
									typeGroupCode="banq_type" defaultVal="${djMarriageFuneralBanquetPage.banquetType}" hasLabel="false"  title="宴席类别"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">宴席类别</label>
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
									typeGroupCode="id_type" defaultVal="${djMarriageFuneralBanquetPage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
							联系电话:
						</label>
					</td>
					<td class="value">
					     	 <input id="banquetTel" name="banquetTel" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">联系电话</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							住址:
						</label>
					</td>
					<td class="value">
					     	 <input id="banquetHomeAddress" name="banquetHomeAddress" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">住址</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							申报时间:
						</label>
					</td>
					<td class="value">
							   <input id="banquetTime" name="banquetTime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
								               datatype="*" 
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申报时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							申报项目:
						</label>
					</td>
					<td class="value">
					     	 <input id="banquetItem" name="banquetItem" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申报项目</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							人数:
						</label>
					</td>
					<td class="value">
					     	 <input id="banquetPeopleNum" name="banquetPeopleNum" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">人数</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							桌数:
						</label>
					</td>
					<td class="value">
					     	 <input id="banquetTableNum" name="banquetTableNum" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">桌数</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							申办地名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="banquetAddress" name="banquetAddress" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申办地名称</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="banquetRemark" name="banquetRemark" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/health/banquet/djMarriageFuneralBanquet.js"></script>		