<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="djMarriageFuneralBanquetList" checkbox="true" fitColumns="false" title="婚丧宴席申报" actionUrl="djMarriageFuneralBanquetController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="申报人"  field="name"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="宴席类别"  field="banquetType"   query="true" queryMode="single" dictionary="banq_type" width="120"></t:dgCol>
   <t:dgCol title="证件类型"  field="idType"   query="true" queryMode="single" dictionary="id_type" width="120"></t:dgCol>
   <t:dgCol title="证件号码"  field="idNo"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="联系电话"  field="banquetTel"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="住址"  field="banquetHomeAddress"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="申报时间"  field="banquetTime" formatter="yyyy-MM-dd"  query="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="申报项目"  field="banquetItem"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="人数"  field="banquetPeopleNum"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="桌数"  field="banquetTableNum"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="申办地名称"  field="banquetAddress"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="banquetRemark"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="djMarriageFuneralBanquetController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="djMarriageFuneralBanquetController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="djMarriageFuneralBanquetController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="djMarriageFuneralBanquetController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="djMarriageFuneralBanquetController.do?goUpdate" funname="detail"></t:dgToolBar>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/dj/health/banquet/djMarriageFuneralBanquetList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#djMarriageFuneralBanquetListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djMarriageFuneralBanquetListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djMarriageFuneralBanquetListtb").find("input[name='banquetTime_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djMarriageFuneralBanquetListtb").find("input[name='banquetTime_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'djMarriageFuneralBanquetController.do?upload', "djMarriageFuneralBanquetList");
}

//导出
function ExportXls() {
	JeecgExcelExport("djMarriageFuneralBanquetController.do?exportXls","djMarriageFuneralBanquetList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("djMarriageFuneralBanquetController.do?exportXlsByT","djMarriageFuneralBanquetList");
}
 </script>