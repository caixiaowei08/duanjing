<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="djProductionTeamList" checkbox="true" fitColumns="false" title="生产队" actionUrl="djProductionTeamController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="生产队"  field="produTeam"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="队长"  field="produCaptain"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="户籍户数"  field="produLocalHouse"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="户籍人数"  field="produLocalNoP"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="来沪人员人数"  field="produNonlocalNoP"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="出租户数"  field="produRentHouse"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="出租间数"  field="produRentRoom"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="耕地面积"  field="produPloughArea"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="produRemark"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="djProductionTeamController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="djProductionTeamController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="djProductionTeamController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="djProductionTeamController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="djProductionTeamController.do?goUpdate" funname="detail"></t:dgToolBar>
 <%--   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/dj/village/production/djProductionTeamList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#djProductionTeamListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djProductionTeamListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'djProductionTeamController.do?upload', "djProductionTeamList");
}

//导出
function ExportXls() {
	JeecgExcelExport("djProductionTeamController.do?exportXls","djProductionTeamList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("djProductionTeamController.do?exportXlsByT","djProductionTeamList");
}
 </script>