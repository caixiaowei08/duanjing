<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="djOldPeopleList" checkbox="true" fitColumns="false" title="老人管理" actionUrl="djOldPeopleController.do?datagrid" idField="id" fit="true" queryMode="group">
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
   <t:dgCol title="文化程度"  field="degree"    queryMode="single" dictionary="degree" width="120"></t:dgCol>
   <t:dgCol title="户籍地址"  field="permanentAddress"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="现居住地址"  field="currentAddress"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="退休时间"  field="retirementTime" formatter="yyyy-MM-dd"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="退休单位"  field="retirementCompany"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="目前状况"  field="retirementStatus"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="经济来源"  field="retirementSrcFina"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="retirementRemark"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="djOldPeopleController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="djOldPeopleController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="djOldPeopleController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="djOldPeopleController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="djOldPeopleController.do?goUpdate" funname="detail"></t:dgToolBar>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/dj/civil/older/djOldPeopleList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#djOldPeopleListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djOldPeopleListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djOldPeopleListtb").find("input[name='retirementTime']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'djOldPeopleController.do?upload', "djOldPeopleList");
}

//导出
function ExportXls() {
	JeecgExcelExport("djOldPeopleController.do?exportXls","djOldPeopleList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("djOldPeopleController.do?exportXlsByT","djOldPeopleList");
}
 </script>