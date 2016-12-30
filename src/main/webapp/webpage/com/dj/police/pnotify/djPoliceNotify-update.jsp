<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>警情通报</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djPoliceNotifyController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djPoliceNotifyPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djPoliceNotifyPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djPoliceNotifyPage.createBy }">
					<input id="updateName" name="updateName" type="hidden" value="${djPoliceNotifyPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djPoliceNotifyPage.updateBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djPoliceNotifyPage.createDate }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djPoliceNotifyPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								责任民警:
							</label>
						</td>
						<td class="value">
						     	 <input id="notifyResponPolice" name="notifyResponPolice" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djPoliceNotifyPage.notifyResponPolice}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">责任民警</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								通报日期:
							</label>
						</td>
						<td class="value">
									  <input id="notifyTime" name="notifyTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${djPoliceNotifyPage.notifyTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">通报日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								参与人数:
							</label>
						</td>
						<td class="value">
						     	 <input id="notifyPersonNum" name="notifyPersonNum" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPoliceNotifyPage.notifyPersonNum}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">参与人数</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								通报地址:
							</label>
						</td>
						<td class="value">
						     	 <input id="notifyAddress" name="notifyAddress" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPoliceNotifyPage.notifyAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">通报地址</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								开始时间:
							</label>
						</td>
						<td class="value">
									  <input id="notifyStartTime" name="notifyStartTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${djPoliceNotifyPage.notifyStartTime}' type="date" pattern="yyyy-MM-dd"/>'>    
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
									  <input id="notifyEndTime" name="notifyEndTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${djPoliceNotifyPage.notifyEndTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">结束时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								内容摘要:
							</label>
						</td>
						<td class="value">
						     	 <input id="notifyDetail" name="notifyDetail" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djPoliceNotifyPage.notifyDetail}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">内容摘要</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								防范漏洞:
							</label>
						</td>
						<td class="value">
						     	 <input id="notifyPrevent" name="notifyPrevent" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPoliceNotifyPage.notifyPrevent}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">防范漏洞</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="notifyRemark" name="notifyRemark" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djPoliceNotifyPage.notifyRemark}'>
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
  <script src = "webpage/com/dj/police/pnotify/djPoliceNotify.js"></script>		