<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>党员变动</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="memberChangerController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${memberChangerPage.id }">
					<input id="createName" name="createName" type="hidden" value="${memberChangerPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${memberChangerPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${memberChangerPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${memberChangerPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${memberChangerPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${memberChangerPage.updateDate }">
					<input id="pid" name="pid" type="hidden" value="${memberChangerPage.pid }">
					<input id="memberType" name="memberType" type="hidden" value="${memberChangerPage.memberType }">
					<input id="memberJoinPartytIme" name="memberJoinPartytIme" type="hidden" value="${memberChangerPage.memberJoinPartytIme }">
					<input id="memberDues" name="memberDues" type="hidden" value="${memberChangerPage.memberDues }">
					<input id="memberTel" name="memberTel" type="hidden" value="${memberChangerPage.memberTel }">
					<input id="memberApplicationDate" name="memberApplicationDate" type="hidden" value="${memberChangerPage.memberApplicationDate }">
					<input id="memberIntroducer" name="memberIntroducer" type="hidden" value="${memberChangerPage.memberIntroducer }">
					<input id="memberApprover" name="memberApprover" type="hidden" value="${memberChangerPage.memberApprover }">
					<input id="memberApproveTime" name="memberApproveTime" type="hidden" value="${memberChangerPage.memberApproveTime }">
					<input id="memberPreparation" name="memberPreparation" type="hidden" value="${memberChangerPage.memberPreparation }">
					<input id="memberTrain" name="memberTrain" type="hidden" value="${memberChangerPage.memberTrain }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${memberChangerPage.name}'>
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
										typeGroupCode="sex" defaultVal="${memberChangerPage.sex}" hasLabel="false"  title="性别"></t:dictSelect>     
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
										typeGroupCode="id_type" defaultVal="${memberChangerPage.idType}" hasLabel="false"  title="证件类型"></t:dictSelect>     
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
										       value='${memberChangerPage.idNo}'>
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
									               
										       value='${memberChangerPage.permanentAddress}'>
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
									               
										       value='${memberChangerPage.currentAddress}'>
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
										typeGroupCode="degree" defaultVal="${memberChangerPage.degree}" hasLabel="false"  title="文化程度"></t:dictSelect>     
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
									               
										       value='${memberChangerPage.workAddress}'>
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
									               
										       value='${memberChangerPage.job}'>
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
										typeGroupCode="m_status" defaultVal="${memberChangerPage.maritalStatus}" hasLabel="false"  title="婚姻状况"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">婚姻状况</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								政治面貌:
							</label>
						</td>
						<td class="value">
						     	 <input id="memberPoliticalStatus" name="memberPoliticalStatus" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${memberChangerPage.memberPoliticalStatus}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">政治面貌</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								变动原因:
							</label>
						</td>
						<td class="value">
						     	 <input id="memberChangeReason" name="memberChangeReason" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${memberChangerPage.memberChangeReason}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">变动原因</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								变动时间:
							</label>
						</td>
						<td class="value">
									  <input id="memberChangeTime" name="memberChangeTime" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${memberChangerPage.memberChangeTime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">变动时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="memberRemark" name="memberRemark" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${memberChangerPage.memberRemark}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/dj/member/memberChange/memberChanger.js"></script>		