<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="djMaintenancePersonList" checkbox="true" fitColumns="false" title="护村队or社保辅警" actionUrl="djMaintenancePersonController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="name"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex"   query="true" queryMode="single" dictionary="sex" width="120"></t:dgCol>
   <t:dgCol title="证件类型"  field="idType"   query="true" queryMode="single" dictionary="id_type" width="120"></t:dgCol>
   <t:dgCol title="证件号码"  field="idNo"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="安保人员类型"  field="mainteType"   query="true" queryMode="single" dictionary="mai_type" width="120"></t:dgCol>
   <t:dgCol title="文化程度"  field="degree"    queryMode="single" dictionary="degree" width="120"></t:dgCol>
   <t:dgCol title="户籍地址"  field="permanentAddress"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="现居住地址"  field="currentAddress"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="参加时间"  field="mainteTrainTime" formatter="yyyy-MM-dd"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="培训记录"  field="mainteTrainInfo"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="退出时间"  field="mainteQuitTime" formatter="yyyy-MM-dd"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="退出原因"  field="mainteQuitReasom"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="mainteRemark"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="djMaintenancePersonController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="djMaintenancePersonController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="djMaintenancePersonController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="djMaintenancePersonController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="djMaintenancePersonController.do?goUpdate" funname="detail"></t:dgToolBar>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/dj/security/maintenance/djMaintenancePersonList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#djMaintenancePersonListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djMaintenancePersonListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djMaintenancePersonListtb").find("input[name='mainteTrainTime']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djMaintenancePersonListtb").find("input[name='mainteQuitTime']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'djMaintenancePersonController.do?upload', "djMaintenancePersonList");
}

//导出
function ExportXls() {
	JeecgExcelExport("djMaintenancePersonController.do?exportXls","djMaintenancePersonList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("djMaintenancePersonController.do?exportXlsByT","djMaintenancePersonList");
}
 </script>