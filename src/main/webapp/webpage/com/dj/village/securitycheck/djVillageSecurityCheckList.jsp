<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="djVillageSecurityCheckList" checkbox="true" fitColumns="false" title="安全or消防检查" actionUrl="djVillageSecurityCheckController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="检查时间"  field="villaTime" formatter="yyyy-MM-dd"  query="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="被检查单位"  field="villaCheckedDept"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="安全or消防"  field="villaType"   query="true" queryMode="single" dictionary="secur_type" width="120"></t:dgCol>
   <t:dgCol title="检查项目"  field="villaItem"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="检查人"  field="villaChecker"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="检查情况"  field="villaStatus"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="villaRemark"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="djVillageSecurityCheckController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="djVillageSecurityCheckController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="djVillageSecurityCheckController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="djVillageSecurityCheckController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="djVillageSecurityCheckController.do?goUpdate" funname="detail"></t:dgToolBar>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/dj/village/securitycheck/djVillageSecurityCheckList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#djVillageSecurityCheckListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djVillageSecurityCheckListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djVillageSecurityCheckListtb").find("input[name='villaTime_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djVillageSecurityCheckListtb").find("input[name='villaTime_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'djVillageSecurityCheckController.do?upload', "djVillageSecurityCheckList");
}

//导出
function ExportXls() {
	JeecgExcelExport("djVillageSecurityCheckController.do?exportXls","djVillageSecurityCheckList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("djVillageSecurityCheckController.do?exportXlsByT","djVillageSecurityCheckList");
}
 </script>