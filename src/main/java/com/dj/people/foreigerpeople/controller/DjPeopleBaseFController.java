package com.dj.people.foreigerpeople.controller;
import com.dj.people.foreigerpeople.entity.DjPeopleBaseFEntity;
import com.dj.people.foreigerpeople.service.DjPeopleBaseFServiceI;
import com.dj.util.ConstantUtil;

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
 * @Description: 境外人员
 * @author onlineGenerator
 * @date 2015-12-11 15:34:22
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djPeopleBaseFController")
public class DjPeopleBaseFController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjPeopleBaseFController.class);

	@Autowired
	private DjPeopleBaseFServiceI djPeopleBaseFService;
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
	 * 境外人员列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djPeopleBaseF")
	public ModelAndView djPeopleBaseF(HttpServletRequest request) {
		return new ModelAndView("com/dj/people/foreigerpeople/djPeopleBaseFList");
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
	public void datagrid(DjPeopleBaseFEntity djPeopleBaseF,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		
		 /**
	     * 设置  境外人员标识
	     */
		djPeopleBaseF.setPeoType(ConstantUtil.PeoType.FOREIGER_PEOPLE);
		
		CriteriaQuery cq = new CriteriaQuery(DjPeopleBaseFEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djPeopleBaseF, request.getParameterMap());
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
		this.djPeopleBaseFService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除境外人员
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjPeopleBaseFEntity djPeopleBaseF, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djPeopleBaseF = systemService.getEntity(DjPeopleBaseFEntity.class, djPeopleBaseF.getId());
		message = "境外人员删除成功";
		try{
			djPeopleBaseFService.delete(djPeopleBaseF);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "境外人员删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除境外人员
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "境外人员删除成功";
		try{
			for(String id:ids.split(",")){
				DjPeopleBaseFEntity djPeopleBaseF = systemService.getEntity(DjPeopleBaseFEntity.class, 
				Integer.parseInt(id)
				);
				djPeopleBaseFService.delete(djPeopleBaseF);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "境外人员删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加境外人员
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjPeopleBaseFEntity djPeopleBaseF, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		
	    /**
	     * 设置  境外人员标识
	     */
		djPeopleBaseF.setPeoType(ConstantUtil.PeoType.FOREIGER_PEOPLE);
		
		message = "境外人员添加成功";
		try{
			djPeopleBaseFService.save(djPeopleBaseF);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "境外人员添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新境外人员
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjPeopleBaseFEntity djPeopleBaseF, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "境外人员更新成功";
		DjPeopleBaseFEntity t = djPeopleBaseFService.get(DjPeopleBaseFEntity.class, djPeopleBaseF.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djPeopleBaseF, t);
			djPeopleBaseFService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "境外人员更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 境外人员新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjPeopleBaseFEntity djPeopleBaseF, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djPeopleBaseF.getId())) {
			djPeopleBaseF = djPeopleBaseFService.getEntity(DjPeopleBaseFEntity.class, djPeopleBaseF.getId());
			req.setAttribute("djPeopleBaseFPage", djPeopleBaseF);
		}
		return new ModelAndView("com/dj/people/foreigerpeople/djPeopleBaseF-add");
	}
	/**
	 * 境外人员编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjPeopleBaseFEntity djPeopleBaseF, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djPeopleBaseF.getId())) {
			djPeopleBaseF = djPeopleBaseFService.getEntity(DjPeopleBaseFEntity.class, djPeopleBaseF.getId());
			req.setAttribute("djPeopleBaseFPage", djPeopleBaseF);
		}
		return new ModelAndView("com/dj/people/foreigerpeople/djPeopleBaseF-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djPeopleBaseFController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjPeopleBaseFEntity djPeopleBaseF,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjPeopleBaseFEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djPeopleBaseF, request.getParameterMap());
		List<DjPeopleBaseFEntity> djPeopleBaseFs = this.djPeopleBaseFService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"境外人员");
		modelMap.put(NormalExcelConstants.CLASS,DjPeopleBaseFEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("境外人员列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djPeopleBaseFs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjPeopleBaseFEntity djPeopleBaseF,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "境外人员");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjPeopleBaseFEntity.class);
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
				List<DjPeopleBaseFEntity> listDjPeopleBaseFEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjPeopleBaseFEntity.class,params);
				for (DjPeopleBaseFEntity djPeopleBaseF : listDjPeopleBaseFEntitys) {
					djPeopleBaseFService.save(djPeopleBaseF);
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
