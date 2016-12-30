package com.dj.people.peoplebase.controller;
import com.dj.people.peoplebase.entity.DjPeopleBaseEntity;
import com.dj.people.peoplebase.service.DjPeopleBaseServiceI;
import com.dj.renthouse.renthouseinfo.entity.DjHouseInfoEntity;

import java.util.List;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.context.annotation.Scope;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
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



/**   
 * @Title: Controller
 * @Description: 人员基表
 * @author onlineGenerator
 * @date 2015-12-11 15:36:46
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djPeopleBaseController")
public class DjPeopleBaseController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjPeopleBaseController.class);

	@Autowired
	private DjPeopleBaseServiceI djPeopleBaseService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 人员基表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djPeopleBase")
	public ModelAndView djPeopleBase(HttpServletRequest request) {
		return new ModelAndView("com/dj/people/peoplebase/djPeopleBaseList");
	}
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "findPerson")
	@ResponseBody
	public List<DjPeopleBaseEntity> findPeople(DjPeopleBaseEntity djPeopleBase, HttpServletRequest request) {
		
		Criteria criteria =  this.djPeopleBaseService.getSession().createCriteria(DjPeopleBaseEntity.class);
		   	
		if(StringUtil.isNotEmpty(djPeopleBase.getIdType())){
			criteria.add(Restrictions.eq("idType", djPeopleBase.getIdType()));
		}
		if(StringUtil.isNotEmpty(djPeopleBase.getIdNo())){
			criteria.add(Restrictions.eq("idNo", djPeopleBase.getIdNo()));
		}
		if(StringUtil.isNotEmpty(djPeopleBase.getBirthdate())){
			criteria.add(Restrictions.eq("birthdate", djPeopleBase.getBirthdate()));
		}
		if(StringUtil.isNotEmpty(djPeopleBase.getSex())){
			criteria.add(Restrictions.eq("sex", djPeopleBase.getSex()));
		}
		if(StringUtil.isNotEmpty(djPeopleBase.getBirthPlace())){
			criteria.add(Restrictions.eq("birthPlace", djPeopleBase.getBirthPlace()));
		}
		if(StringUtil.isNotEmpty(djPeopleBase.getPeoType())){
			criteria.add(Restrictions.eq("peoType", djPeopleBase.getPeoType()));
		}
		
		
		List<DjPeopleBaseEntity> djHouseInfoEntities = criteria.list();
		
		return djHouseInfoEntities;
	}
	
	

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(DjPeopleBaseEntity djPeopleBase,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjPeopleBaseEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djPeopleBase, request.getParameterMap());
		try{
		//自定义追加查询条件
		String query_birthdate_begin = request.getParameter("birthdate_begin");
		String query_birthdate_end = request.getParameter("birthdate_end");
		if(StringUtil.isNotEmpty(query_birthdate_begin)){
			cq.ge("birthdate", new SimpleDateFormat("yyyy-MM-dd").parse(query_birthdate_begin));
		}
		if(StringUtil.isNotEmpty(query_birthdate_end)){
			cq.le("birthdate", new SimpleDateFormat("yyyy-MM-dd").parse(query_birthdate_end));
		}
		String query_entryTime_begin = request.getParameter("entryTime_begin");
		String query_entryTime_end = request.getParameter("entryTime_end");
		if(StringUtil.isNotEmpty(query_entryTime_begin)){
			cq.ge("entryTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_entryTime_begin));
		}
		if(StringUtil.isNotEmpty(query_entryTime_end)){
			cq.le("entryTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_entryTime_end));
		}
		String query_dueTime_begin = request.getParameter("dueTime_begin");
		String query_dueTime_end = request.getParameter("dueTime_end");
		if(StringUtil.isNotEmpty(query_dueTime_begin)){
			cq.ge("dueTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_dueTime_begin));
		}
		if(StringUtil.isNotEmpty(query_dueTime_end)){
			cq.le("dueTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_dueTime_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djPeopleBaseService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除人员基表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjPeopleBaseEntity djPeopleBase, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djPeopleBase = systemService.getEntity(DjPeopleBaseEntity.class, djPeopleBase.getId());
		message = "人员基表删除成功";
		try{
			djPeopleBaseService.delete(djPeopleBase);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "人员基表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除人员基表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "人员基表删除成功";
		try{
			for(String id:ids.split(",")){
				DjPeopleBaseEntity djPeopleBase = systemService.getEntity(DjPeopleBaseEntity.class, 
				Integer.parseInt(id)
				);
				djPeopleBaseService.delete(djPeopleBase);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "人员基表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加人员基表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjPeopleBaseEntity djPeopleBase, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "人员基表添加成功";
		try{
			djPeopleBaseService.save(djPeopleBase);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "人员基表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新人员基表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjPeopleBaseEntity djPeopleBase, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "人员基表更新成功";
		DjPeopleBaseEntity t = djPeopleBaseService.get(DjPeopleBaseEntity.class, djPeopleBase.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djPeopleBase, t);
			djPeopleBaseService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "人员基表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 人员基表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjPeopleBaseEntity djPeopleBase, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djPeopleBase.getId())) {
			djPeopleBase = djPeopleBaseService.getEntity(DjPeopleBaseEntity.class, djPeopleBase.getId());
			req.setAttribute("djPeopleBasePage", djPeopleBase);
		}
		return new ModelAndView("com/dj/people/peoplebase/djPeopleBase-add");
	}
	/**
	 * 人员基表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjPeopleBaseEntity djPeopleBase, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djPeopleBase.getId())) {
			djPeopleBase = djPeopleBaseService.getEntity(DjPeopleBaseEntity.class, djPeopleBase.getId());
			req.setAttribute("djPeopleBasePage", djPeopleBase);
		}
		return new ModelAndView("com/dj/people/peoplebase/djPeopleBase-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djPeopleBaseController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjPeopleBaseEntity djPeopleBase,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjPeopleBaseEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djPeopleBase, request.getParameterMap());
		List<DjPeopleBaseEntity> djPeopleBases = this.djPeopleBaseService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"人员基表");
		modelMap.put(NormalExcelConstants.CLASS,DjPeopleBaseEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("人员基表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djPeopleBases);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjPeopleBaseEntity djPeopleBase,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "人员基表");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjPeopleBaseEntity.class);
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
				List<DjPeopleBaseEntity> listDjPeopleBaseEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjPeopleBaseEntity.class,params);
				for (DjPeopleBaseEntity djPeopleBase : listDjPeopleBaseEntitys) {
					djPeopleBaseService.save(djPeopleBase);
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
