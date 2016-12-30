package com.dj.military.militaryactive.controller;
import com.dj.military.militaryactive.entity.DjMilitaryActiveEntity;
import com.dj.military.militaryactive.service.DjMilitaryActiveServiceI;
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
 * @Description: 现服役人员
 * @author onlineGenerator
 * @date 2015-12-14 21:05:05
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djMilitaryActiveController")
public class DjMilitaryActiveController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjMilitaryActiveController.class);

	@Autowired
	private DjMilitaryActiveServiceI djMilitaryActiveService;
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
	 * 现服役人员列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djMilitaryActive")
	public ModelAndView djMilitaryActive(HttpServletRequest request) {
		return new ModelAndView("com/dj/military/militaryActive/djMilitaryActiveList");
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
	public void datagrid(DjMilitaryActiveEntity djMilitaryActive,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjMilitaryActiveEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djMilitaryActive, request.getParameterMap());
		try{
		//自定义追加查询条件
		String query_draftTime_begin = request.getParameter("draftTime_begin");
		String query_draftTime_end = request.getParameter("draftTime_end");
		if(StringUtil.isNotEmpty(query_draftTime_begin)){
			cq.ge("draftTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_draftTime_begin));
		}
		if(StringUtil.isNotEmpty(query_draftTime_end)){
			cq.le("draftTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_draftTime_end));
		}
		String query_militaryTime_begin = request.getParameter("militaryTime_begin");
		String query_militaryTime_end = request.getParameter("militaryTime_end");
		if(StringUtil.isNotEmpty(query_militaryTime_begin)){
			cq.ge("militaryTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_militaryTime_begin));
		}
		if(StringUtil.isNotEmpty(query_militaryTime_end)){
			cq.le("militaryTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_militaryTime_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djMilitaryActiveService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除现服役人员
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjMilitaryActiveEntity djMilitaryActive, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djMilitaryActive = systemService.getEntity(DjMilitaryActiveEntity.class, djMilitaryActive.getId());
		message = "现服役人员删除成功";
		try{
			djMilitaryActiveService.delete(djMilitaryActive);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "现服役人员删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除现服役人员
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "现服役人员删除成功";
		try{
			for(String id:ids.split(",")){
				DjMilitaryActiveEntity djMilitaryActive = systemService.getEntity(DjMilitaryActiveEntity.class, 
				Integer.parseInt(id)
				);
				djMilitaryActiveService.delete(djMilitaryActive);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "现服役人员删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加现服役人员
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjMilitaryActiveEntity djMilitaryActive, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "现服役人员添加成功";
		try{
			djMilitaryActiveService.save(djMilitaryActive);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "现服役人员添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新现服役人员
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjMilitaryActiveEntity djMilitaryActive, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "现服役人员更新成功";
		DjMilitaryActiveEntity t = djMilitaryActiveService.get(DjMilitaryActiveEntity.class, djMilitaryActive.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djMilitaryActive, t);
			djMilitaryActiveService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "现服役人员更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 现服役人员新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjMilitaryActiveEntity djMilitaryActive, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djMilitaryActive.getId())) {
			djMilitaryActive = djMilitaryActiveService.getEntity(DjMilitaryActiveEntity.class, djMilitaryActive.getId());
			req.setAttribute("djMilitaryActivePage", djMilitaryActive);
		}
		return new ModelAndView("com/dj/military/militaryActive/djMilitaryActive-add");
	}
	/**
	 * 现服役人员编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjMilitaryActiveEntity djMilitaryActive, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djMilitaryActive.getId())) {
			djMilitaryActive = djMilitaryActiveService.getEntity(DjMilitaryActiveEntity.class, djMilitaryActive.getId());
			req.setAttribute("djMilitaryActivePage", djMilitaryActive);
		}
		return new ModelAndView("com/dj/military/militaryActive/djMilitaryActive-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djMilitaryActiveController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjMilitaryActiveEntity djMilitaryActive,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjMilitaryActiveEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djMilitaryActive, request.getParameterMap());
		List<DjMilitaryActiveEntity> djMilitaryActives = this.djMilitaryActiveService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"现服役人员");
		modelMap.put(NormalExcelConstants.CLASS,DjMilitaryActiveEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("现服役人员列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djMilitaryActives);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjMilitaryActiveEntity djMilitaryActive,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "现服役人员");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjMilitaryActiveEntity.class);
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
				List<DjMilitaryActiveEntity> listDjMilitaryActiveEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjMilitaryActiveEntity.class,params);
				for (DjMilitaryActiveEntity djMilitaryActive : listDjMilitaryActiveEntitys) {
					djMilitaryActiveService.save(djMilitaryActive);
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
