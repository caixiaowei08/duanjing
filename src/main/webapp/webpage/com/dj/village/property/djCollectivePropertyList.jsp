<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="djCollectivePropertyList" checkbox="true" fitColumns="false" title="集体财产管理" actionUrl="djCollectivePropertyController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="物品名称"  field="propertyName"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="数量"  field="propertyNum"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="价值"  field="propertyWorth"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="使用人"  field="propertyUser"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="管理方式"  field="propertyManagStyle"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="存放情况"  field="propertyStorCondi"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否报废"  field="propertyIsScrap"   query="true" queryMode="single" dictionary="sf_yn" width="120"></t:dgCol>
   <t:dgCol title="备注"  field="propertyRemark"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="djCollectivePropertyController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="djCollectivePropertyController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="djCollectivePropertyController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="djCollectivePropertyController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="djCollectivePropertyController.do?goUpdate" funname="detail"></t:dgToolBar>
  <%--  <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/dj/village/property/djCollectivePropertyList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#djCollectivePropertyListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djCollectivePropertyListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'djCollectivePropertyController.do?upload', "djCollectivePropertyList");
}

//导出
function ExportXls() {
	JeecgExcelExport("djCollectivePropertyController.do?exportXls","djCollectivePropertyList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("djCollectivePropertyController.do?exportXlsByT","djCollectivePropertyList");
}
 </script>