<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="schoolList" checkbox="true" fitColumns="false" title="子女就学" actionUrl="schoolController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   
   <t:dgCol title="证件类型"  field="idType"   hidden="true" queryMode="single" dictionary="id_type" width="120"></t:dgCol>
   <t:dgCol title="证件号码"  field="idNo"    hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="name"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="生日"  field="birthdate"  formatter="yyyy-MM-dd" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex"   query="true" queryMode="single" dictionary="sex" width="120"></t:dgCol>
   <t:dgCol title="出生地"  field="birthPlace"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="人口来源"  field="peoType"  query="true" queryMode="single" dictionary="peo_type" width="120"></t:dgCol>
   
 
   <t:dgCol title="搜索人"    field="searchPeople" hidden="true"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="监护人编号"  field="guardianId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="监护人证件类型"  field="guardianIdType" hidden="true"   queryMode="single" dictionary="id_type" width="160"></t:dgCol>
   <t:dgCol title="监护人证件号码"  field="guardianIdNo"   hidden="true" queryMode="single"  width="160"></t:dgCol>
   <t:dgCol title="监护人"  field="guardianName"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="搜索监护人"  field="searchGuardian"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="与监护人关系"  field="guardianRelationship"    queryMode="single"  width="160"></t:dgCol>
   <t:dgCol title="入学时间"  field="entranceTime" query="true"  formatter="yyyy-MM-dd"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="学校名称"  field="schoolName"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="学校类型"  field="schoolType"    queryMode="single" dictionary="scho_type" width="120"></t:dgCol>
   <t:dgCol title="学校地址"  field="schoolAddress"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="学校电话"  field="schoolTel"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="remark"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="schoolController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="schoolController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="schoolController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="schoolController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="schoolController.do?view" funname="detail"></t:dgToolBar>
  <%--  <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/dj/people/school/schoolList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#schoolListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#schoolListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#schoolListtb").find("input[name='entranceTime']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#schoolListtb").find("input[name='birthdate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'schoolController.do?upload', "schoolList");
}

//导出
function ExportXls() {
	JeecgExcelExport("schoolController.do?exportXls","schoolList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("schoolController.do?exportXlsByT","schoolList");
}
 </script>