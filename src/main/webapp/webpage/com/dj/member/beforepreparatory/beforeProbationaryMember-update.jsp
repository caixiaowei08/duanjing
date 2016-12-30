<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>拟发展党员</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="beforeProbationaryMemberController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${beforeProbationaryMemberPage.id }">
					<input id="createName" name="createName" type="hidden" value="${beforeProbationaryMemberPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${beforeProbationaryMemberPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${beforeProbationaryMemberPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${beforeProbationaryMemberPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${beforeProbationaryMemberPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${beforeProbationaryMemberPage.updateDate }">
					<input id="pid" name="pid" type="hidden" value="${beforeProbationaryMemberPage.pid }">
					<input id="memberType" name="memberType" type="hidden" value="${beforeProbationaryMemberPage.memberType }">
					<input id="memberJoinPartytIme" name="memberJoinPartytIme" type="hidden" value="${beforeProbationaryMemberPage.memberJoinPartytIme }">
					<input id="memberDues" name="memberDues" type="hidden" value="${beforeProbationaryMemberPage.memberDues }">
					<input id="memberTel" name="memberTel" type="hidden" value="${beforeProbationaryMemberPage.memberTel }">
					<input id="memberPreparation" name="memberPreparation" type="hidden" value="${beforeProbationaryMemberPage.memberPreparation }">
					<input id="memberPoliticalStatus" name="memberPoliticalStatus" type="hidden" value="${beforeProbationaryMemberPage.memberPoliticalStatus }">
					<input id="memberChangeReason" name="memberChangeReason" type="hidden" value="${beforeProbationaryMemberPage.memberChangeReason }">
					<input id="memberChangeTime" name="memberChangeTime" type="hidden" value="${beforeProbationaryMemberPage.memberChangeTime }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${beforeProbationaryMemberPage.name}'>
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
										typeGroupCode="sex" defaultVal="${beforeProbationaryMemberPage.sex}" hasLabel="false"  title="性别"></t:dictSelect>     
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
										typeGroupCode="id_type" defaultVal="${beforeProbationaryMemberPage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
										       value='${beforeProbationaryMemberPage.idNo}'>
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
									               
										       value='${beforeProbationaryMemberPage.permanentAddress}'>
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
									               
										       value='${beforeProbationaryMemberPage.currentAddress}'>
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
										typeGroupCode="degree" defaultVal="${beforeProbationaryMemberPage.degree}" hasLabel="false"  title="文化程度"></t:dictSelect>     
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
									               
										       value='${beforeProbationaryMemberPage.workAddress}'>
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
									               
										       value='${beforeProbationaryMemberPage.job}'>
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
										typeGroupCode="m_status" defaultVal="${beforeProbationaryMemberPage.maritalStatus}" hasLabel="false"  title="婚姻状况"></t:dictSelect>     
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
						      				   value='<fmt:formatDate value='${beforeProbationaryMemberPage.memberApplicationDate}' type="date" pattern="yyyy-MM-dd"/>'>    
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
									               
										       value='${beforeProbationaryMemberPage.memberIntroducer}'>
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
									               
										       value='${beforeProbationaryMemberPage.memberApprover}'>
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
									                
						      						 value='<fmt:formatDate value='${beforeProbationaryMemberPage.memberApproveTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">批准时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								培训情况:
							</label>
						</td>
						<td class="value">
						     	 <input id="memberTrain" name="memberTrain" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${beforeProbationaryMemberPage.memberTrain}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">培训情况</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="memberRemark" name="memberRemark" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${beforeProbationaryMemberPage.memberRemark}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/member/beforepreparatory/beforeProbationaryMember.js"></script>		