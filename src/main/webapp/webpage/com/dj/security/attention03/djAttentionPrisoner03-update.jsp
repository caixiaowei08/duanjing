<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>刑释解教</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djAttentionPrisoner03Controller.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djAttentionPrisoner03Page.id }">
					<input id="createName" name="createName" type="hidden" value="${djAttentionPrisoner03Page.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djAttentionPrisoner03Page.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djAttentionPrisoner03Page.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djAttentionPrisoner03Page.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djAttentionPrisoner03Page.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djAttentionPrisoner03Page.updateDate }">
					<input id="pid" name="pid" type="hidden" value="${djAttentionPrisoner03Page.pid }">
					<input id="attentionType" name="attentionType" type="hidden" value="${djAttentionPrisoner03Page.attentionType }">
					<input id="attentionImprisonTime" name="attentionImprisonTime" type="hidden" value="${djAttentionPrisoner03Page.attentionImprisonTime }">
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
										       value='${djAttentionPrisoner03Page.name}'>
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
										typeGroupCode="sex" defaultVal="${djAttentionPrisoner03Page.sex}" hasLabel="false"  title="性别"></t:dictSelect> 	
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
								typeGroupCode="id_type" defaultVal="${djAttentionPrisoner03Page.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>  	
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
										       value='${djAttentionPrisoner03Page.idNo}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">证件号码</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								文化程度:
							</label>
						</td>
						<td class="value">
						     	 <t:dictSelect field="degree" type="list"
										typeGroupCode="degree" defaultVal="${djAttentionPrisoner03Page.degree}" hasLabel="false"  title="学历"></t:dictSelect>     	
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">文化程度</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								户籍地址:
							</label>
						</td>
						<td class="value">
						     	 <input id="permanentAddress" name="permanentAddress" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djAttentionPrisoner03Page.permanentAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户籍地址</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								现居住地址:
							</label>
						</td>
						<td class="value">
						     	 <input id="currentAddress" name="currentAddress" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djAttentionPrisoner03Page.currentAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居住地址</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								婚姻状况:
							</label>
						</td>
						<td class="value">
						     	 <t:dictSelect field="maritalStatus" type="list"
										typeGroupCode="m_status" defaultVal="${djAttentionPrisoner03Page.maritalStatus}" hasLabel="false"  title="婚姻状况"></t:dictSelect>   	
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">婚姻状况</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								案别:
							</label>
						</td>
						<td class="value">
						     	 <input id="attentionItem" name="attentionItem" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djAttentionPrisoner03Page.attentionItem}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">案别</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								裁决时间:
							</label>
						</td>
						<td class="value">
						     	<input id="attentionTime" name="attentionTime" type="text" style="width: 150px" 
                                    class="Wdate" onClick="WdatePicker()"
									               datatype="*"
										       value='<fmt:formatDate value='${djAttentionPrisoner03Page.attentionTime}' type="date" pattern="yyyy-MM-dd"/>'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">裁决时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								裁决单位:
							</label>
						</td>
						<td class="value">
						     	 <input id="attentionDept" name="attentionDept" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djAttentionPrisoner03Page.attentionDept}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">裁决单位</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								裁决结果:
							</label>
						</td>
						<td class="value">
						     	 <input id="attentionResult" name="attentionResult" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djAttentionPrisoner03Page.attentionResult}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">裁决结果</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								服刑日期:
							</label>
						</td>
						<td class="value">
						     	 <input id="attentionExecutedTime" name="attentionExecutedTime" type="text" style="width: 150px" class="inputxt" 
						     	             class="Wdate" onClick="WdatePicker()" 
									               datatype="*"
										       value='<fmt:formatDate value='${djAttentionPrisoner03Page.attentionExecutedTime}' type="date" pattern="yyyy-MM-dd"/>'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">服刑日期</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								服刑地点:
							</label>
						</td>
						<td class="value">
						     	 <input id="attentionAddress" name="attentionAddress" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
										       value='${djAttentionPrisoner03Page.attentionAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">服刑地点</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="attentionRemark" name="attentionRemark" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${djAttentionPrisoner03Page.attentionRemark}'>
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
  <script src = "webpage/com/dj/security/attention03/djAttentionPrisoner03.js"></script>		