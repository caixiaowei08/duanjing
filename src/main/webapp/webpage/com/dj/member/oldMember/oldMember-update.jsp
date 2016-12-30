<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>老龄党员</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="oldMemberController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${oldMemberPage.id }">
					<input id="createName" name="createName" type="hidden" value="${oldMemberPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${oldMemberPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${oldMemberPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${oldMemberPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${oldMemberPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${oldMemberPage.updateDate }">
					<input id="pid" name="pid" type="hidden" value="${oldMemberPage.pid }">
					<input id="memberType" name="memberType" type="hidden" value="${oldMemberPage.memberType }">
					<input id="memberApplicationDate" name="memberApplicationDate" type="hidden" value="${oldMemberPage.memberApplicationDate }">
					<input id="memberIntroducer" name="memberIntroducer" type="hidden" value="${oldMemberPage.memberIntroducer }">
					<input id="memberApprover" name="memberApprover" type="hidden" value="${oldMemberPage.memberApprover }">
					<input id="memberApproveTime" name="memberApproveTime" type="hidden" value="${oldMemberPage.memberApproveTime }">
					<input id="memberPreparation" name="memberPreparation" type="hidden" value="${oldMemberPage.memberPreparation }">
					<input id="memberTrain" name="memberTrain" type="hidden" value="${oldMemberPage.memberTrain }">
					<input id="memberPoliticalStatus" name="memberPoliticalStatus" type="hidden" value="${oldMemberPage.memberPoliticalStatus }">
					<input id="memberChangeReason" name="memberChangeReason" type="hidden" value="${oldMemberPage.memberChangeReason }">
					<input id="memberChangeTime" name="memberChangeTime" type="hidden" value="${oldMemberPage.memberChangeTime }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${oldMemberPage.name}'>
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
										typeGroupCode="sex" defaultVal="${oldMemberPage.sex}" hasLabel="false"  title="性别"></t:dictSelect>     
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
										typeGroupCode="id_type" defaultVal="${oldMemberPage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
										       value='${oldMemberPage.idNo}'>
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
									               
										       value='${oldMemberPage.permanentAddress}'>
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
									               
										       value='${oldMemberPage.currentAddress}'>
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
										typeGroupCode="degree" defaultVal="${oldMemberPage.degree}" hasLabel="false"  title="文化程度"></t:dictSelect>     
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
									               
										       value='${oldMemberPage.workAddress}'>
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
									               
										       value='${oldMemberPage.job}'>
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
										typeGroupCode="m_status" defaultVal="${oldMemberPage.maritalStatus}" hasLabel="false"  title="婚姻状况"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">婚姻状况</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								入党时间:
							</label>
						</td>
						<td class="value">
						     	 <input id="memberJoinPartytIme" name="memberJoinPartytIme" type="text" style="width: 150px" class="inputxt"  
									                 class="Wdate" onClick="WdatePicker()"
						      				   value='<fmt:formatDate value='${oldMemberPage.memberJoinPartytIme}' type="date" pattern="yyyy-MM-dd"/>'> 
										       
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">入党时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								党费缴纳:
							</label>
						</td>
						<td class="value">
						     	 <input id="memberDues" name="memberDues" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${oldMemberPage.memberDues}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">党费缴纳</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								联系电话:
							</label>
						</td>
						<td class="value">
						     	 <input id="memberTel" name="memberTel" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${oldMemberPage.memberTel}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">联系电话</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="memberRemark" name="memberRemark" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${oldMemberPage.memberRemark}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/member/oldMember/oldMember.js"></script>		