<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="djRawDataHuzhuFileList" checkbox="true" fitColumns="false" title="常住人口原始数据" actionUrl="djRawDataHuzhuFileController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="name"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="曾用名"  field="usedName"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="证件号码"  field="idNo"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="出生日期"  field="birthdate"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="民族"  field="nation"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="籍贯"  field="birthPlace"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="血型"  field="bloodType"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="身高"  field="height"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="文化程度"  field="degree"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="婚姻状况"  field="maritalStatus"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="工作单位"  field="workAddress"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="配偶姓名"  field="spouseName"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="宗教信仰"  field="aaa"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="居住地派出所"  field="bbb"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="兵役状况"  field="isArmy"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="户籍地行政区划"  field="permanentDistrict"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="户籍地址"  field="permanentAddress"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="居住地行政区划"  field="currentDistrict"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="居住地址"  field="currentAddress"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="证件种类"  field="idType"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="djRawDataHuzhuFileController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="djRawDataHuzhuFileController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="djRawDataHuzhuFileController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="djRawDataHuzhuFileController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="djRawDataHuzhuFileController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/dj/rawdata/people02/djRawDataHuzhuFileList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'djRawDataHuzhuFileController.do?upload', "djRawDataHuzhuFileList");
}

//导出
function ExportXls() {
	JeecgExcelExport("djRawDataHuzhuFileController.do?exportXls","djRawDataHuzhuFileList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("djRawDataHuzhuFileController.do?exportXlsByT","djRawDataHuzhuFileList");
}
 </script>