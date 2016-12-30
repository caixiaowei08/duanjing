<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>司法信访</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djJudicialPetitionController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djJudicialPetitionPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djJudicialPetitionPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djJudicialPetitionPage.createBy }">
					<input id="updateName" name="updateName" type="hidden" value="${djJudicialPetitionPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djJudicialPetitionPage.updateBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djJudicialPetitionPage.createDate }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djJudicialPetitionPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								信访类别:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="petitionType" type="radio"
										typeGroupCode="peti_type" defaultVal="${djJudicialPetitionPage.petitionType}" hasLabel="false"  title="信访类别"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">信访类别</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								信访人:
							</label>
						</td>
						<td class="value">
						     	 <input id="petitionPerson" name="petitionPerson" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djJudicialPetitionPage.petitionPerson}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">信访人</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								信访时间:
							</label>
						</td>
						<td class="value">
									  <input id="petitionTime" name="petitionTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									               datatype="*" 
						      						 value='<fmt:formatDate value='${djJudicialPetitionPage.petitionTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">信访时间</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								信访内容摘要:
							</label>
						</td>
						<td class="value">
						     	 <input id="petitionDetail" name="petitionDetail" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djJudicialPetitionPage.petitionDetail}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">信访内容摘要</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								领导批示:
							</label>
						</td>
						<td class="value">
						     	 <input id="petitionComments" name="petitionComments" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djJudicialPetitionPage.petitionComments}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">领导批示</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								责任人:
							</label>
						</td>
						<td class="value">
						     	 <input id="petitionOfficer" name="petitionOfficer" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djJudicialPetitionPage.petitionOfficer}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">责任人</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								回访时间:
							</label>
						</td>
						<td class="value">
									  <input id="petitionRevisitDays" name="petitionRevisitDays" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${djJudicialPetitionPage.petitionRevisitDays}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">回访时间</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								回访结果:
							</label>
						</td>
						<td class="value">
						     	 <input id="petitionRevisitResult" name="petitionRevisitResult" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djJudicialPetitionPage.petitionRevisitResult}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">回访结果</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/police/petition/djJudicialPetition.js"></script>		