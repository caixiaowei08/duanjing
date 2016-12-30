<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>预备党员</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="probationaryMemberController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${probationaryMemberPage.id }">
					<input id="createName" name="createName" type="hidden" value="${probationaryMemberPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${probationaryMemberPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${probationaryMemberPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${probationaryMemberPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${probationaryMemberPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${probationaryMemberPage.updateDate }">
					<input id="pid" name="pid" type="hidden" value="${probationaryMemberPage.pid }">
					<input id="memberType" name="memberType" type="hidden" value="${probationaryMemberPage.memberType }">
					<input id="memberJoinPartytIme" name="memberJoinPartytIme" type="hidden" value="${probationaryMemberPage.memberJoinPartytIme }">
					<input id="memberDues" name="memberDues" type="hidden" value="${probationaryMemberPage.memberDues }">
					<input id="memberTel" name="memberTel" type="hidden" value="${probationaryMemberPage.memberTel }">
					<input id="memberPreparation" name="memberPreparation" type="hidden" value="${probationaryMemberPage.memberPreparation }">
					<input id="memberTrain" name="memberTrain" type="hidden" value="${probationaryMemberPage.memberTrain }">
					<input id="memberPoliticalStatus" name="memberPoliticalStatus" type="hidden" value="${probationaryMemberPage.memberPoliticalStatus }">
					<input id="memberChangeReason" name="memberChangeReason" type="hidden" value="${probationaryMemberPage.memberChangeReason }">
					<input id="memberChangeTime" name="memberChangeTime" type="hidden" value="${probationaryMemberPage.memberChangeTime }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							姓名:
						</label>
					</td>
					<td class="value">
					     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"
								               
								               >
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
									typeGroupCode="sex" defaultVal="0" hasLabel="false"  title="性别"></t:dictSelect>     
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
									typeGroupCode="id_type" defaultVal="${probationaryMemberPage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
							户籍地址:
						</label>
					</td>
					<td class="value">
					     	 <input id="permanentAddress" name="permanentAddress" type="text" style="width: 150px" class="inputxt"
								               
								               >
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
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现居住地址</label>
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
									typeGroupCode="degree" defaultVal="${probationaryMemberPage.degree}" hasLabel="false"  title="文化程度"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">文化程度</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							工作地点:
						</label>
					</td>
					<td class="value">
					     	 <input id="workAddress" name="workAddress" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">工作地点</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							职业:
						</label>
					</td>
					<td class="value">
					     	 <input id="job" name="job" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">职业</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							婚姻状况:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="maritalStatus" type="list"
									typeGroupCode="m_status" defaultVal="${probationaryMemberPage.maritalStatus}" hasLabel="false"  title="婚姻状况"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">婚姻状况</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							申请时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="memberApplicationDate" name="memberApplicationDate" type="text" style="width: 150px" class="inputxt"
								               class="Wdate" onClick="WdatePicker()"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							介绍人:
						</label>
					</td>
					<td class="value">
					     	 <input id="memberIntroducer" name="memberIntroducer" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">介绍人</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							组织批准:
						</label>
					</td>
					<td class="value">
					     	 <input id="memberApprover" name="memberApprover" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">组织批准</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							批准时间:
						</label>
					</td>
					<td class="value">
							   <input id="memberApproveTime" name="memberApproveTime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
								                
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">批准时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="memberRemark" name="memberRemark" type="text" style="width: 150px" class="inputxt"
								               
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
  <script src = "webpage/com/dj/member/preparatory/probationaryMember.js"></script>		