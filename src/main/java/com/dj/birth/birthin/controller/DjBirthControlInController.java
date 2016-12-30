package com.dj.birth.birthin.controller;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.dj.birth.birthin.entity.DjBirthControlInEntity;
import com.dj.birth.birthin.service.DjBirthControlInServiceI;



/**   
 * @Title: Controller
 * @Description: 计划生育
 * @author onlineGenerator
 * @date 2015-12-05 22:01:02
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djBirthControlInController")
public class DjBirthControlInController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjBirthControlInController.class);

	@Autowired
	private DjBirthControlInServiceI djBirthControlInService;
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
	 * 计划生育列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djBirthControlIn")
	public ModelAndView djBirthControlIn(HttpServletRequest request) {
		return new ModelAndView("com/dj/birth/birthin/djBirthControlInList");
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
	public void datagrid(DjBirthControlInEntity djBirthControlIn,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjBirthControlInEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djBirthControlIn, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djBirthControlInService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除计划生育
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjBirthControlInEntity djBirthControlIn, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djBirthControlIn = systemService.getEntity(DjBirthControlInEntity.class, djBirthControlIn.getId());
		message = "计划生育删除成功";
		try{
			djBirthControlInService.delete(djBirthControlIn);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "计划生育删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除计划生育
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "计划生育删除成功";
		try{
			for(String id:ids.split(",")){
				DjBirthControlInEntity djBirthControlIn = systemService.getEntity(DjBirthControlInEntity.class, 
				Integer.parseInt(id)
				);
				djBirthControlInService.delete(djBirthControlIn);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "计划生育删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加计划生育
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjBirthControlInEntity djBirthControlIn, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "计划生育添加成功";
		try{
			djBirthControlInService.save(djBirthControlIn);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "计划生育添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新计划生育
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjBirthControlInEntity djBirthControlIn, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "计划生育更新成功";
		DjBirthControlInEntity t = djBirthControlInService.get(DjBirthControlInEntity.class, djBirthControlIn.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djBirthControlIn, t);
			djBirthControlInService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "计划生育更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 计划生育新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjBirthControlInEntity djBirthControlIn, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djBirthControlIn.getId())) {
			djBirthControlIn = djBirthControlInService.getEntity(DjBirthControlInEntity.class, djBirthControlIn.getId());
			req.setAttribute("djBirthControlInPage", djBirthControlIn);
		}
		return new ModelAndView("com/dj/birth/birthin/djBirthControlIn-add");
	}
	/**
	 * 计划生育编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjBirthControlInEntity djBirthControlIn, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djBirthControlIn.getId())) {
			djBirthControlIn = djBirthControlInService.getEntity(DjBirthControlInEntity.class, djBirthControlIn.getId());
			req.setAttribute("djBirthControlInPage", djBirthControlIn);
		}
		return new ModelAndView("com/dj/birth/birthin/djBirthControlIn-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djBirthControlInController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjBirthControlInEntity djBirthControlIn,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjBirthControlInEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djBirthControlIn, request.getParameterMap());
		List<DjBirthControlInEntity> djBirthControlIns = this.djBirthControlInService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"计划生育");
		modelMap.put(NormalExcelConstants.CLASS,DjBirthControlInEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("计划生育列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djBirthControlIns);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjBirthControlInEntity djBirthControlIn,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "计划生育");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjBirthControlInEntity.class);
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
				List<DjBirthControlInEntity> listDjBirthControlInEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjBirthControlInEntity.class,params);
				for (DjBirthControlInEntity djBirthControlIn : listDjBirthControlInEntitys) {
					djBirthControlInService.save(djBirthControlIn);
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
