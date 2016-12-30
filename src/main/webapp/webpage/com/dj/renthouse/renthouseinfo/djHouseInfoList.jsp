<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="djHouseInfoList" checkbox="true" fitColumns="false" title="出租房信息" actionUrl="djHouseInfoController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="户主姓名"  field="name"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="证件类型"  field="idType"    queryMode="single" dictionary="id_type" width="120"></t:dgCol>
   <t:dgCol title="证件号码"  field="idNum"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房屋所在区"  field="district"   query="true" queryMode="single" dictionary="dist_type" width="120"></t:dgCol>
   <t:dgCol title="房屋所在村"  field="town"   query="true" queryMode="single" dictionary="town_type" width="120"></t:dgCol>
   <t:dgCol title="房屋所属宅"  field="village"   query="true" queryMode="single" dictionary="vill_type" width="120"></t:dgCol>
   <t:dgCol title="门牌号"  field="ridgeNo"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间号"  field="roomNo"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="楼层"  field="floorNo"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否空房"  field="isNull"  query="true" queryMode="single" dictionary="sf_yn" width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="djHouseInfoController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="djHouseInfoController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="djHouseInfoController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="djHouseInfoController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="djHouseInfoController.do?goUpdate" funname="detail"></t:dgToolBar>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/dj/renthouse/renthouseinfo/djHouseInfoList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#djHouseInfoListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djHouseInfoListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'djHouseInfoController.do?upload', "djHouseInfoList");
}

//导出
function ExportXls() {
	JeecgExcelExport("djHouseInfoController.do?exportXls","djHouseInfoList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("djHouseInfoController.do?exportXlsByT","djHouseInfoList");
}
 </script>