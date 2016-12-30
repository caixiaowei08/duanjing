<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="djDocumentManagementList" checkbox="true" fitColumns="false" title="文件管理" actionUrl="djDocumentManagementController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="文件名称"  field="documentName"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发文单位"  field="documentDept"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发文时间"  field="documentTime" formatter="yyyy-MM-dd"  query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="文号"  field="documentNo"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="责任人"  field="documentPerson"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="内容摘要"  field="documentDetail"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="保管人"  field="documentKeeper"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="documentRemark"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="djDocumentManagementController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="djDocumentManagementController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="djDocumentManagementController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="djDocumentManagementController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="djDocumentManagementController.do?goUpdate" funname="detail"></t:dgToolBar>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/dj/village/document/djDocumentManagementList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#djDocumentManagementListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djDocumentManagementListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djDocumentManagementListtb").find("input[name='documentTime']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'djDocumentManagementController.do?upload', "djDocumentManagementList");
}

//导出
function ExportXls() {
	JeecgExcelExport("djDocumentManagementController.do?exportXls","djDocumentManagementList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("djDocumentManagementController.do?exportXlsByT","djDocumentManagementList");
}
 </script>