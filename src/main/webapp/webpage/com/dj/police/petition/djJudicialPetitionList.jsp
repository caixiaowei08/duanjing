<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="djJudicialPetitionList" checkbox="true" fitColumns="false" title="司法信访" actionUrl="djJudicialPetitionController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="信访类别"  field="petitionType"   query="true" queryMode="single" dictionary="peti_type" width="120"></t:dgCol>
   <t:dgCol title="信访人"  field="petitionPerson"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="信访时间"  field="petitionTime" formatter="yyyy-MM-dd"  query="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="信访内容摘要"  field="petitionDetail"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="领导批示"  field="petitionComments"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="责任人"  field="petitionOfficer"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="回访时间"  field="petitionRevisitDays" formatter="yyyy-MM-dd"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="回访结果"  field="petitionRevisitResult"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="djJudicialPetitionController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="djJudicialPetitionController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="djJudicialPetitionController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="djJudicialPetitionController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="djJudicialPetitionController.do?goUpdate" funname="detail"></t:dgToolBar>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/dj/police/petition/djJudicialPetitionList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#djJudicialPetitionListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djJudicialPetitionListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djJudicialPetitionListtb").find("input[name='petitionTime_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djJudicialPetitionListtb").find("input[name='petitionTime_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djJudicialPetitionListtb").find("input[name='petitionRevisitDays']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'djJudicialPetitionController.do?upload', "djJudicialPetitionList");
}

//导出
function ExportXls() {
	JeecgExcelExport("djJudicialPetitionController.do?exportXls","djJudicialPetitionList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("djJudicialPetitionController.do?exportXlsByT","djJudicialPetitionList");
}
 </script>