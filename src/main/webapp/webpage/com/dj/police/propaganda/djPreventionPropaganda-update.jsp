<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>防范宣传</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djPreventionPropagandaController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djPreventionPropagandaPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djPreventionPropagandaPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djPreventionPropagandaPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djPreventionPropagandaPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djPreventionPropagandaPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djPreventionPropagandaPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djPreventionPropagandaPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								责任民警:
							</label>
						</td>
						<td class="value">
						     	 <input id="preveResponPolice" name="preveResponPolice" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djPreventionPropagandaPage.preveResponPolice}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">责任民警</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								活动日期:
							</label>
						</td>
						<td class="value">
									  <input id="preveTime" name="preveTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									               datatype="*" 
						      						 value='<fmt:formatDate value='${djPreventionPropagandaPage.preveTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">活动日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								活动地址:
							</label>
						</td>
						<td class="value">
						     	 <input id="preveAddress" name="preveAddress" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djPreventionPropagandaPage.preveAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">活动地址</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								参与人数:
							</label>
						</td>
						<td class="value">
						     	 <input id="preveJoinNum" name="preveJoinNum" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPreventionPropagandaPage.preveJoinNum}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">参与人数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								开始时间:
							</label>
						</td>
						<td class="value">
									  <input id="preveStartTime" name="preveStartTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									               datatype="*" 
						      						 value='<fmt:formatDate value='${djPreventionPropagandaPage.preveStartTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开始时间</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								结束时间:
							</label>
						</td>
						<td class="value">
									  <input id="preveEndTime" name="preveEndTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									               datatype="*" 
						      						 value='<fmt:formatDate value='${djPreventionPropagandaPage.preveEndTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">结束时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								活动内容:
							</label>
						</td>
						<td class="value">
						     	 <input id="preveDetail" name="preveDetail" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djPreventionPropagandaPage.preveDetail}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">活动内容</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								活动形式:
							</label>
						</td>
						<td class="value">
						     	 <input id="preveType" name="preveType" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPreventionPropagandaPage.preveType}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">活动形式</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								发放资料数量:
							</label>
						</td>
						<td class="value">
						     	 <input id="preveDocuNum" name="preveDocuNum" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPreventionPropagandaPage.preveDocuNum}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发放资料数量</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="preveRemark" name="preveRemark" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPreventionPropagandaPage.preveRemark}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/police/propaganda/djPreventionPropaganda.js"></script>		