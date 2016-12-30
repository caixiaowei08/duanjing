<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="djMediationPersonList" checkbox="true" fitColumns="false" title="民事调解" actionUrl="djMediationPersonController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="调解时间"  field="mediaTime" formatter="yyyy-MM-dd"  query="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="甲 当事人姓名"  field="mediaFirstName"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="甲 证件类型"  field="mediaFirstIdType"   query="true" queryMode="single" dictionary="id_type" width="120"></t:dgCol>
   <t:dgCol title="甲 证件号码"  field="mediaFirstIdNo"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="甲 联系电话"  field="mediaFirstTel"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="乙 当事人姓名"  field="mediaSecondName"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="乙 证件类型"  field="mediaSecondIdType"   query="true" queryMode="single" dictionary="id_type" width="120"></t:dgCol>
   <t:dgCol title="乙 证件号码"  field="mediaSecondIdNo"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="乙 联系电话"  field="mediaSecondTel"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="矛盾纠纷原因"  field="mediaReason"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="调解结果"  field="mediaResult"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="摘要"  field="mediaDetail"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="问题化解及对策"  field="mediaMethod"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="矛盾纠纷类别"  field="mediaContradictionType"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="问题症结"  field="mediaImportant"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="目前采取措施"  field="mediaMeasure"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="取得成效"  field="mediaEffect"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否上报"  field="mediaIsReport"   query="true" queryMode="single" dictionary="sf_yn" width="120"></t:dgCol>
   <t:dgCol title="备注"  field="mediaRemark"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="djMediationPersonController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="djMediationPersonController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="djMediationPersonController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="djMediationPersonController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="djMediationPersonController.do?goUpdate" funname="detail"></t:dgToolBar>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/dj/police/mediation/djMediationPersonList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#djMediationPersonListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djMediationPersonListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djMediationPersonListtb").find("input[name='mediaTime_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djMediationPersonListtb").find("input[name='mediaTime_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'djMediationPersonController.do?upload', "djMediationPersonList");
}

//导出
function ExportXls() {
	JeecgExcelExport("djMediationPersonController.do?exportXls","djMediationPersonList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("djMediationPersonController.do?exportXlsByT","djMediationPersonList");
}
 </script>