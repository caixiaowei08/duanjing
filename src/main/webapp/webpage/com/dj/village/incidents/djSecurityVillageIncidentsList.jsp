<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="djSecurityVillageIncidentsList" checkbox="true" fitColumns="false" title="安全事故" actionUrl="djSecurityVillageIncidentsController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="事故时间"  field="incideTime" formatter="yyyy-MM-dd"  query="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="事故单位"  field="incideDept"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="伤亡情况"  field="incideCasualtyNum"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="责任人"  field="incideOfficer"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="责任原因"  field="incideReason"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="查出结果"  field="incideCheckResult"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="incideRemark"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="djSecurityVillageIncidentsController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="djSecurityVillageIncidentsController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="djSecurityVillageIncidentsController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="djSecurityVillageIncidentsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="djSecurityVillageIncidentsController.do?goUpdate" funname="detail"></t:dgToolBar>
 <%--   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/dj/village/incidents/djSecurityVillageIncidentsList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#djSecurityVillageIncidentsListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djSecurityVillageIncidentsListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djSecurityVillageIncidentsListtb").find("input[name='incideTime_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djSecurityVillageIncidentsListtb").find("input[name='incideTime_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'djSecurityVillageIncidentsController.do?upload', "djSecurityVillageIncidentsList");
}

//导出
function ExportXls() {
	JeecgExcelExport("djSecurityVillageIncidentsController.do?exportXls","djSecurityVillageIncidentsList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("djSecurityVillageIncidentsController.do?exportXlsByT","djSecurityVillageIncidentsList");
}
 </script>