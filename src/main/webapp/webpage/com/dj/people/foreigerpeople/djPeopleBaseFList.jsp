<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="djPeopleBaseFList" checkbox="true" fitColumns="false" title="境外人员" actionUrl="djPeopleBaseFController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="英文姓"  field="lastAme"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="英文名"  field="firstName"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="中文姓名"  field="name"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="生日"  field="birthdate" formatter="yyyy-MM-dd"  query="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="证件类型"  field="idType"   query="true" queryMode="single" dictionary="id_type" width="100"></t:dgCol>
   <t:dgCol title="证件号码"  field="idNo"   query="true" queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="性别"  field="sex"   query="true" queryMode="single" dictionary="sex" width="120"></t:dgCol>
   <t:dgCol title="出生地"  field="birthPlace"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入境时间"  field="entryTime" formatter="yyyy-MM-dd"  query="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="到期时间"  field="dueTime" formatter="yyyy-MM-dd"  query="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="人口来源"  field="peoType"  hidden="true"  queryMode="single" dictionary="peo_type" width="120"></t:dgCol>
   <t:dgCol title="国籍"  field="nationality"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="曾用名"  field="usedName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="体征"  field="sign"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="名族"  field="nation"  hidden="true"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="身高"  field="height"    queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="血型"  field="bloodType"    queryMode="single" dictionary="blood_type" width="80"></t:dgCol>
   <t:dgCol title="学历"  field="degree"  hidden="true"  queryMode="single" dictionary="degree" width="80"></t:dgCol>
   <t:dgCol title="婚姻状况"  field="maritalStatus"  hidden="true"  queryMode="single" dictionary="m_status" width="100"></t:dgCol>
   <t:dgCol title="配偶姓名"  field="spouseName"  hidden="true"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="人户分离"  field="pHouse"  hidden="true"  queryMode="single" dictionary="p_house" width="120"></t:dgCol>
   <t:dgCol title="座机"  field="tel"  hidden="true"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="手机"  field="phone"    queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="职业"  field="job"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="工作地点"  field="workAddress"  hidden="true"  queryMode="single"  width="140"></t:dgCol>
   <t:dgCol title="兵役状况"  field="isArmy"  hidden="true"  queryMode="single" dictionary="is_army" width="100"></t:dgCol>
   <t:dgCol title="兵役详情"  field="armyRemark"  hidden="true"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="户籍地区"  field="permanentDistrict"  hidden="true"  queryMode="single"  width="140"></t:dgCol>
   <t:dgCol title="户籍地址"  field="permanentAddress"  hidden="true"  queryMode="single"  width="140"></t:dgCol>
   <t:dgCol title="户籍地区"  field="districtPerm"  hidden="true"  queryMode="single" dictionary="dist_type" width="120"></t:dgCol>
   <t:dgCol title="户籍所在村"  field="townPerm"  hidden="true"  queryMode="single" dictionary="town_type" width="140"></t:dgCol>
   <t:dgCol title="户籍所属宅"  field="villagePerm"  hidden="true"  queryMode="single" dictionary="vill_type" width="140"></t:dgCol>
   <t:dgCol title="户籍门牌号"  field="roomNoPerm"  hidden="true"  queryMode="single"  width="140"></t:dgCol>
   <t:dgCol title="现居住地区"  field="currentDistrict"  hidden="true"  queryMode="single"  width="140"></t:dgCol>
   <t:dgCol title="现居住地址"  field="currentAddress"  hidden="true"  queryMode="single"  width="140"></t:dgCol>
   <t:dgCol title="现居住地区"  field="districtCurrent"    queryMode="single" dictionary="dist_type" width="140"></t:dgCol>
   <t:dgCol title="现居住村"  field="townCurrent"    queryMode="single" dictionary="town_type" width="140"></t:dgCol>
   <t:dgCol title="现居所属宅"  field="villageCurrent"    queryMode="single" dictionary="vill_type" width="160"></t:dgCol>
   <t:dgCol title="现居门牌号"  field="ridgeNoCurrent"    queryMode="single"  width="160"></t:dgCol>
   <t:dgCol title="现居楼层"  field="floorNoCurrent"    queryMode="single"  width="160"></t:dgCol>
   <t:dgCol title="现居房间号"  field="roomNoCurrent"    queryMode="single"  width="160"></t:dgCol>
   <t:dgCol title="备注"  field="remark"    queryMode="single"  width="140"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="djPeopleBaseFController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="djPeopleBaseFController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="djPeopleBaseFController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="djPeopleBaseFController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="djPeopleBaseFController.do?goUpdate" funname="detail"></t:dgToolBar>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/dj/people/foreigerpeople/djPeopleBaseFList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#djPeopleBaseFListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djPeopleBaseFListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djPeopleBaseFListtb").find("input[name='birthdate_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djPeopleBaseFListtb").find("input[name='birthdate_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djPeopleBaseFListtb").find("input[name='entryTime_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djPeopleBaseFListtb").find("input[name='entryTime_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djPeopleBaseFListtb").find("input[name='dueTime_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#djPeopleBaseFListtb").find("input[name='dueTime_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'djPeopleBaseFController.do?upload', "djPeopleBaseFList");
}

//导出
function ExportXls() {
	JeecgExcelExport("djPeopleBaseFController.do?exportXls","djPeopleBaseFList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("djPeopleBaseFController.do?exportXlsByT","djPeopleBaseFList");
}
 </script>