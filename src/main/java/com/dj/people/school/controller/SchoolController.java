package com.dj.people.school.controller;

import com.dj.people.school.entity.SchoolEntity;
import com.dj.people.school.entity.SchoolInfoEntity;
import com.dj.people.school.entity.SchoolingChildrenEntity;
import com.dj.people.school.service.SchoolInfoServiceI;
import com.dj.people.school.service.SchoolServiceI;
import com.dj.util.BeanCopyUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.cglib.beans.BeanCopier;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.context.annotation.Scope;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.hibernate.qbc.HqlQuery;
import org.jeecgframework.core.common.hibernate.qbc.PageList;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;

import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;

import org.jeecgframework.core.util.ExceptionUtil;
import org.junit.Test;



/**   
 * @Title: Controller
 * @Description: 子女就学
 * @author onlineGenerator
 * @date 2015-11-25 20:22:58
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/schoolController")
public class SchoolController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SchoolController.class);

	@Autowired
	private SchoolServiceI schoolService;
	@Autowired
	private SchoolInfoServiceI schoolInfoService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	String hqlString =
			" SELECT                                                            "+
					" s.id AS id,                                               "+
					" s.create_name AS createName,                              "+
					" s.create_by AS createBy,                                  "+
					" s.create_date AS createDate,                              "+
					" s.update_name AS updateName,                              "+
					" s.update_by AS updateBy,                                  "+
					" s.update_date AS updateDate,                              "+
					" p1.id_type AS idType,                                     "+
					" p1.id_no AS idNo,                                         "+
					" p1.`name` AS `name`,                                      "+
					" p1.birthdate AS birthdate,                                "+
					" p1.sex AS sex,                                            "+
					" p1.birth_place AS birthPlace,                             "+
					" p1.peo_type AS peoType,                                   "+
					" '' as searchPeople,                                       "+
					" p2.id AS guardianId,                                      "+
					" p2.id_type AS guardianIdType,                             "+
					" p2.id_no AS guardianIdNo,                                 "+
					" p2.`name` AS guardianName,                                "+
					" '' as searchGuardian,                                     "+
					" s.guardian_relationship AS guardianRelationship,          "+
					" s.entrance_time AS entranceTime,                          "+
					" s.school_name AS schoolName,                              "+
					" s.school_type AS schoolType,                              "+
					" s.school_address AS schoolAddress,                        "+
					" s.school_tel AS schoolTel,                                "+
					" s.remark AS remark                                        "+
					" FROM                                                      "+
					" schooling_children AS s                                   "+
					" LEFT JOIN dj_people_base AS p1 ON s.pid = p1.id           "+
					" LEFT JOIN dj_people_base AS p2 ON s.guardian_id = p2.id   "+
					" where 1=1 and p1.id is not null                            ";	


	/**
	 * 子女就学列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "school")
	public ModelAndView school(HttpServletRequest request) {
		return new ModelAndView("com/dj/people/school/schoolList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@SuppressWarnings("unchecked")
	@RequestMapping(params = "datagrid")
	public void datagrid(SchoolEntity school,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		
		CriteriaQuery cq = new CriteriaQuery(SchoolEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, school, request.getParameterMap());
		
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		
		cq.add();
	
		if(StringUtils.hasText(school.getName())){
			hqlString+=" and p1.name='"+school.getName()+"'";
		}
		
		if(school.getBirthdate()!=null){
			hqlString+=" and p1.birthdate='"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(school.getBirthdate())+"'";
		}
		
		if(StringUtils.hasText(school.getSex())){
			hqlString+=" and p1.sex='"+school.getSex()+"'";
		}
		
		if(StringUtils.hasText(school.getPeoType())){
			hqlString+=" and p1.peo_type='"+school.getPeoType()+"'";
		}
		
		if(school.getEntranceTime()!=null){
			hqlString+=" and s.entrance_time ='"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(school.getEntranceTime())+"'";
		}
		
		
		if(StringUtils.hasText(school.getSchoolName())){
			hqlString+=" and s.school_name='"+school.getSchoolName()+"'";
		}
		
		
		HqlQuery hqlQuery = new HqlQuery(SchoolEntity.class, hqlString, dataGrid);
		
		@SuppressWarnings("unused")
		PageList pageList= this.schoolInfoService.getPageListBySql(hqlQuery, true);
		
		cq.getDataGrid().setResults(pageList.getResultList());
		cq.getDataGrid().setTotal(pageList.getCount());
		
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除子女就学
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(SchoolEntity school, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		//school = systemService.getEntity(SchoolEntity.class, school.getId());
		message = "子女就学删除成功";
		try{
			SchoolInfoEntity schoolInfo = new SchoolInfoEntity();
			schoolInfo.setId(school.getId());
			schoolInfoService.delMain(schoolInfo);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "子女就学删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除子女就学
	 * 
	 * @return
	 */
	@RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "子女就学删除成功";
		try{
			for(String id:ids.split(",")){
				SchoolInfoEntity schoolInfo = new SchoolInfoEntity();
				schoolInfo.setId(Integer.parseInt(id));
				schoolInfoService.delMain(schoolInfo);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "子女就学删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加子女就学
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(SchoolEntity school, HttpServletRequest request) {
		
		List<SchoolingChildrenEntity> schoolingChildrenList =  new ArrayList<SchoolingChildrenEntity>();
		
		SchoolingChildrenEntity childrenEntity = new SchoolingChildrenEntity();
		
		BeanCopyUtil.copyPropertys(school,childrenEntity);
		childrenEntity.setPid( Integer.parseInt(school.getName()));
		childrenEntity.setGuardianId(Integer.parseInt(school.getGuardianName()));
		childrenEntity.setEntranceTime(school.getEntranceTime());
		
		
		schoolingChildrenList.add(childrenEntity);
		
		AjaxJson j = new AjaxJson();
		message = "子女就学添加成功";
		try{
			schoolInfoService.addMain(null, schoolingChildrenList);
			
			//schoolService.save(school);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			
			
		}catch(Exception e){
			e.printStackTrace();
			message = "子女就学添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	
	/**
	 * 更新子女就学
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(SchoolEntity school, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "子女就学更新成功";
		
        List<SchoolingChildrenEntity> schoolingChildrenList =  new ArrayList<SchoolingChildrenEntity>();
		SchoolingChildrenEntity childrenEntity = schoolService.get(SchoolingChildrenEntity.class, school.getId());
		
		BeanCopyUtil.copyByDPropertys(school,childrenEntity);
		schoolingChildrenList.add(childrenEntity);
		try {
			//schoolService.saveOrUpdate(t);
			schoolInfoService.updateMain(null, schoolingChildrenList);
			
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "子女就学更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 子女就学新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(SchoolEntity school, HttpServletRequest req) {
		
		if (StringUtil.isNotEmpty(school.getId())) {
			
			school = schoolService.getEntity(SchoolEntity.class, school.getId());
			req.setAttribute("schoolPage", school);
			
		}
		
		return new ModelAndView("com/dj/people/school/school-add");
	}
	/**
	 * 子女就学编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(SchoolEntity school, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(school.getId())) {
			
			//school = schoolService.getEntity(SchoolEntity.class, school.getId());
			hqlString+=" and s.id='"+school.getId()+"'";
			
			String field="id,createName,createBy,createDate,updateName,updateBy,updateDate,idType,idNo,name,birthdate,sex,birthPlace,peoType,searchPeople,guardianId,guardianIdType,guardianIdNo,guardianName,searchGuardian,guardianRelationship,entranceTime,schoolName,schoolType,schoolAddress,schoolTel,remark";
			
			DataGrid dataGrid = new DataGrid();
			dataGrid.setField(field);
			dataGrid.setRows(1);
			
			HqlQuery hqlQuery = new HqlQuery(SchoolEntity.class, hqlString,dataGrid);
			PageList pageList= this.schoolInfoService.getPageListBySql(hqlQuery, true);
			
			
			req.setAttribute("schoolPage", pageList.getResultList().get(0));
			
		}
		return new ModelAndView("com/dj/people/school/school-update");
	}
	
	
	/**
	 * 子女就学编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "view")
	public ModelAndView goView(SchoolEntity school, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(school.getId())) {
			
			//school = schoolService.getEntity(SchoolEntity.class, school.getId());
			hqlString+=" and s.id='"+school.getId()+"'";
			
			String field="id,createName,createBy,createDate,updateName,updateBy,updateDate,idType,idNo,name,birthdate,sex,birthPlace,peoType,searchPeople,guardianId,guardianIdType,guardianIdNo,guardianName,searchGuardian,guardianRelationship,entranceTime,schoolName,schoolType,schoolAddress,schoolTel,remark";
			
			DataGrid dataGrid = new DataGrid();
			dataGrid.setField(field);
			dataGrid.setRows(1);
			
			HqlQuery hqlQuery = new HqlQuery(SchoolEntity.class, hqlString,dataGrid);
			PageList pageList= this.schoolInfoService.getPageListBySql(hqlQuery, true);
			
			
			req.setAttribute("schoolPage", pageList.getResultList().get(0));
			
		}
		return new ModelAndView("com/dj/people/school/school-view");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","schoolController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(SchoolEntity school,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(SchoolEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, school, request.getParameterMap());
		List<SchoolEntity> schools = this.schoolService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"子女就学");
		modelMap.put(NormalExcelConstants.CLASS,SchoolEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("子女就学列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,schools);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(SchoolEntity school,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "子女就学");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,SchoolEntity.class);
		modelMap.put(TemplateExcelConstants.LIST_DATA,null);
		return TemplateExcelConstants.JEECG_TEMPLATE_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<SchoolEntity> listSchoolEntitys = ExcelImportUtil.importExcel(file.getInputStream(),SchoolEntity.class,params);
				for (SchoolEntity school : listSchoolEntitys) {
					schoolService.save(school);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
}
