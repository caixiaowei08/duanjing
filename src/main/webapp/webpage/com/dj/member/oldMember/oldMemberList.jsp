<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="oldMemberList" checkbox="true" fitColumns="false" title="老龄党员" actionUrl="oldMemberController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="人员id"  field="pid"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="name"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex"   query="true" queryMode="single" dictionary="sex" width="120"></t:dgCol>
   <t:dgCol title="证件类型"  field="idType"   query="true" queryMode="single" dictionary="id_type" width="120"></t:dgCol>
   <t:dgCol title="证件号码"  field="idNo"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="户籍地址"  field="permanentAddress"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="现居住地址"  field="currentAddress"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="文化程度"  field="degree"    queryMode="single" dictionary="degree" width="120"></t:dgCol>
   <t:dgCol title="工作地点"  field="workAddress"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="职业"  field="job"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="婚姻状况"  field="maritalStatus"    queryMode="single" dictionary="m_status" width="120"></t:dgCol>
   <t:dgCol title="党员类型"  field="memberType"  hidden="true"  queryMode="single" dictionary="mem_type" width="120"></t:dgCol>
   <t:dgCol title="入党时间"  field="memberJoinPartytIme" formatter="yyyy-MM-dd"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="党费缴纳"  field="memberDues"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="联系电话"  field="memberTel"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="申请时间"  field="memberApplicationDate"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="介绍人"  field="memberIntroducer"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="组织批准"  field="memberApprover"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="批准时间"  field="memberApproveTime" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="预备期限"  field="memberPreparation"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="培训情况"  field="memberTrain"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="政治面貌"  field="memberPoliticalStatus"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="变动原因"  field="memberChangeReason"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="变动时间"  field="memberChangeTime" formatter="yyyy-MM-dd" hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="memberRemark"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="oldMemberController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="oldMemberController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="oldMemberController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="oldMemberController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="oldMemberController.do?goUpdate" funname="detail"></t:dgToolBar>
 <%--   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/dj/member/oldMember/oldMemberList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#oldMemberListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#oldMemberListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#oldMemberListtb").find("input[name='memberApproveTime']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#oldMemberListtb").find("input[name='memberChangeTime']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'oldMemberController.do?upload', "oldMemberList");
}

//导出
function ExportXls() {
	JeecgExcelExport("oldMemberController.do?exportXls","oldMemberList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("oldMemberController.do?exportXlsByT","oldMemberList");
}
 </script>