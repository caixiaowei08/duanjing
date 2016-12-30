<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="djBusinessManagementList" checkbox="true" fitColumns="false" title="事务管理" actionUrl="djBusinessManagementController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="事务名称"  field="businessName"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="主管部门"  field="businessDept"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="时间"  field="businessTime" formatter="yyyy-MM-dd"  query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="经办人"  field="businessOperator"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="主持人"  field="businessHost"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="参加对象"  field="businessJoiners"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="内容摘要"  field="businessDetail"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="businessRemark"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="djBusinessManagementController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="djBusinessManagementController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="djBusinessManagementController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="djBusinessManagementController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="djBusinessManagementController.do?goUpdate" funname="detail"></t:dgToolBar>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/dj/village/business/djBusinessManagementList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#djBusinessManagementListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djBusinessManagementListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djBusinessManagementListtb").find("input[name='businessTime']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'djBusinessManagementController.do?upload', "djBusinessManagementList");
}

//导出
function ExportXls() {
	JeecgExcelExport("djBusinessManagementController.do?exportXls","djBusinessManagementList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("djBusinessManagementController.do?exportXlsByT","djBusinessManagementList");
}
 </script>