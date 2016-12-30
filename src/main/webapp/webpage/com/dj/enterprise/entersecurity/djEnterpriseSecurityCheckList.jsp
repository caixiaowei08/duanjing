<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="djEnterpriseSecurityCheckList" checkbox="true" fitColumns="false" title="企业安全or消防检查" actionUrl="djEnterpriseSecurityCheckController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="检查时间"  field="enterTime" formatter="yyyy-MM-dd"  query="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="安全or消防"  field="enterType"   query="true" queryMode="single" dictionary="secur_type" width="120"></t:dgCol>
   <t:dgCol title="检查单位"  field="enterCheckDept"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="被检查单位"  field="enterCheckedDept"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="检查人"  field="enterChecker"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="检查项目"  field="enterItem"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="检查情况"  field="enterStatus"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="enterRemark"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="djEnterpriseSecurityCheckController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="djEnterpriseSecurityCheckController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="djEnterpriseSecurityCheckController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="djEnterpriseSecurityCheckController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="djEnterpriseSecurityCheckController.do?goUpdate" funname="detail"></t:dgToolBar>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/dj/enterprise/entersecurity/djEnterpriseSecurityCheckList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#djEnterpriseSecurityCheckListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djEnterpriseSecurityCheckListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djEnterpriseSecurityCheckListtb").find("input[name='enterTime_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djEnterpriseSecurityCheckListtb").find("input[name='enterTime_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'djEnterpriseSecurityCheckController.do?upload', "djEnterpriseSecurityCheckList");
}

//导出
function ExportXls() {
	JeecgExcelExport("djEnterpriseSecurityCheckController.do?exportXls","djEnterpriseSecurityCheckList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("djEnterpriseSecurityCheckController.do?exportXlsByT","djEnterpriseSecurityCheckList");
}
 </script>