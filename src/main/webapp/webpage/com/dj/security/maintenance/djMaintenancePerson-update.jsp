<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>护村队or社保辅警</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djMaintenancePersonController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djMaintenancePersonPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djMaintenancePersonPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djMaintenancePersonPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djMaintenancePersonPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djMaintenancePersonPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djMaintenancePersonPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djMaintenancePersonPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djMaintenancePersonPage.name}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								性别:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="sex" type="radio"
										typeGroupCode="sex" defaultVal="${djMaintenancePersonPage.sex}" hasLabel="false"  title="性别"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">性别</label>
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
										typeGroupCode="id_type" defaultVal="${djMaintenancePersonPage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
										       value='${djMaintenancePersonPage.idNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">证件号码</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								安保人员类型:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="mainteType" type="radio"
										typeGroupCode="mai_type" defaultVal="${djMaintenancePersonPage.mainteType}" hasLabel="false"  title="安保人员类型"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">安保人员类型</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								文化程度:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="degree" type="list"
										typeGroupCode="degree" defaultVal="${djMaintenancePersonPage.degree}" hasLabel="false"  title="文化程度"></t:dictSelect>     
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
									               
										       value='${djMaintenancePersonPage.permanentAddress}'>
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
									               
										       value='${djMaintenancePersonPage.currentAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居住地址</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								参加时间:
							</label>
						</td>
						<td class="value">
									  <input id="mainteTrainTime" name="mainteTrainTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${djMaintenancePersonPage.mainteTrainTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">参加时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								培训记录:
							</label>
						</td>
						<td class="value">
						     	 <input id="mainteTrainInfo" name="mainteTrainInfo" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djMaintenancePersonPage.mainteTrainInfo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">培训记录</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								退出时间:
							</label>
						</td>
						<td class="value">
									  <input id="mainteQuitTime" name="mainteQuitTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${djMaintenancePersonPage.mainteQuitTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">退出时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								退出原因:
							</label>
						</td>
						<td class="value">
						     	 <input id="mainteQuitReasom" name="mainteQuitReasom" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djMaintenancePersonPage.mainteQuitReasom}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">退出原因</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="mainteRemark" name="mainteRemark" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djMaintenancePersonPage.mainteRemark}'>
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
  <script src = "webpage/com/dj/security/maintenance/djMaintenancePerson.js"></script>		