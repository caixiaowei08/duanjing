<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>民事调解</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="djMediationPersonController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${djMediationPersonPage.id }">
					<input id="createName" name="createName" type="hidden" value="${djMediationPersonPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${djMediationPersonPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${djMediationPersonPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${djMediationPersonPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${djMediationPersonPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${djMediationPersonPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							调解时间:
						</label>
					</td>
					<td class="value">
							   <input id="mediaTime" name="mediaTime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
								               datatype="*" 
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">调解时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							甲 当事人姓名:
						</label>
					</td>
					<td class="value">
					     	 <input id="mediaFirstName" name="mediaFirstName" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">甲 当事人姓名</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							甲 证件类型:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="mediaFirstIdType" type="list"
									typeGroupCode="id_type" defaultVal="${djMediationPersonPage.mediaFirstIdType}" hasLabel="false"  title="甲 证件类型"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">甲 证件类型</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							甲 证件号码:
						</label>
					</td>
					<td class="value">
					     	 <input id="mediaFirstIdNo" name="mediaFirstIdNo" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">甲 证件号码</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							甲 联系电话:
						</label>
					</td>
					<td class="value">
					     	 <input id="mediaFirstTel" name="mediaFirstTel" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">甲 联系电话</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							乙 当事人姓名:
						</label>
					</td>
					<td class="value">
					     	 <input id="mediaSecondName" name="mediaSecondName" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">乙 当事人姓名</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							乙 证件类型:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="mediaSecondIdType" type="list"
									typeGroupCode="id_type" defaultVal="${djMediationPersonPage.mediaSecondIdType}" hasLabel="false"  title="乙 证件类型"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">乙 证件类型</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							乙 证件号码:
						</label>
					</td>
					<td class="value">
					     	 <input id="mediaSecondIdNo" name="mediaSecondIdNo" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">乙 证件号码</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							乙 联系电话:
						</label>
					</td>
					<td class="value">
					     	 <input id="mediaSecondTel" name="mediaSecondTel" type="text" style="width: 150px" class="inputxt"
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">乙 联系电话</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							矛盾纠纷原因:
						</label>
					</td>
					<td class="value">
					     	 <input id="mediaReason" name="mediaReason" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">矛盾纠纷原因</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							调解结果:
						</label>
					</td>
					<td class="value">
					     	 <input id="mediaResult" name="mediaResult" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">调解结果</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							摘要:
						</label>
					</td>
					<td class="value">
					     	 <input id="mediaDetail" name="mediaDetail" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">摘要</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							问题化解及对策:
						</label>
					</td>
					<td class="value">
					     	 <input id="mediaMethod" name="mediaMethod" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">问题化解及对策</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							矛盾纠纷类别:
						</label>
					</td>
					<td class="value">
					     	 <input id="mediaContradictionType" name="mediaContradictionType" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">矛盾纠纷类别</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							问题症结:
						</label>
					</td>
					<td class="value">
					     	 <input id="mediaImportant" name="mediaImportant" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">问题症结</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							目前采取措施:
						</label>
					</td>
					<td class="value">
					     	 <input id="mediaMeasure" name="mediaMeasure" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">目前采取措施</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							取得成效:
						</label>
					</td>
					<td class="value">
					     	 <input id="mediaEffect" name="mediaEffect" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">取得成效</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							是否上报:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="mediaIsReport" type="list"
									typeGroupCode="sf_yn" defaultVal="${djMediationPersonPage.mediaIsReport}" hasLabel="false"  title="是否上报"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否上报</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="mediaRemark" name="mediaRemark" type="text" style="width: 150px" class="inputxt"
								               
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
  <script src = "webpage/com/dj/police/mediation/djMediationPerson.js"></script>		