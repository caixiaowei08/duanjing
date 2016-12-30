package com.dj.police.eventreg.controller;
import com.dj.police.eventreg.entity.DjEventRegisterEntity;
import com.dj.police.eventreg.service.DjEventRegisterServiceI;
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
 * @Description: 事件登记
 * @author onlineGenerator
 * @date 2015-12-07 21:57:16
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djEventRegisterController")
public class DjEventRegisterController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjEventRegisterController.class);

	@Autowired
	private DjEventRegisterServiceI djEventRegisterService;
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
	 * 事件登记列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djEventRegister")
	public ModelAndView djEventRegister(HttpServletRequest request) {
		return new ModelAndView("com/dj/police/eventreg/djEventRegisterList");
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
	public void datagrid(DjEventRegisterEntity djEventRegister,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjEventRegisterEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djEventRegister, request.getParameterMap());
		try{
		//自定义追加查询条件
		String query_eventTirme_begin = request.getParameter("eventTirme_begin");
		String query_eventTirme_end = request.getParameter("eventTirme_end");
		if(StringUtil.isNotEmpty(query_eventTirme_begin)){
			cq.ge("eventTirme", new SimpleDateFormat("yyyy-MM-dd").parse(query_eventTirme_begin));
		}
		if(StringUtil.isNotEmpty(query_eventTirme_end)){
			cq.le("eventTirme", new SimpleDateFormat("yyyy-MM-dd").parse(query_eventTirme_end));
		}
		String query_eventReportTime_begin = request.getParameter("eventReportTime_begin");
		String query_eventReportTime_end = request.getParameter("eventReportTime_end");
		if(StringUtil.isNotEmpty(query_eventReportTime_begin)){
			cq.ge("eventReportTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_eventReportTime_begin));
		}
		if(StringUtil.isNotEmpty(query_eventReportTime_end)){
			cq.le("eventReportTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_eventReportTime_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djEventRegisterService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除事件登记
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjEventRegisterEntity djEventRegister, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djEventRegister = systemService.getEntity(DjEventRegisterEntity.class, djEventRegister.getId());
		message = "事件登记删除成功";
		try{
			djEventRegisterService.delete(djEventRegister);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "事件登记删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除事件登记
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "事件登记删除成功";
		try{
			for(String id:ids.split(",")){
				DjEventRegisterEntity djEventRegister = systemService.getEntity(DjEventRegisterEntity.class, 
				Integer.parseInt(id)
				);
				djEventRegisterService.delete(djEventRegister);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "事件登记删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加事件登记
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjEventRegisterEntity djEventRegister, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "事件登记添加成功";
		try{
			djEventRegisterService.save(djEventRegister);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "事件登记添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新事件登记
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjEventRegisterEntity djEventRegister, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "事件登记更新成功";
		DjEventRegisterEntity t = djEventRegisterService.get(DjEventRegisterEntity.class, djEventRegister.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djEventRegister, t);
			djEventRegisterService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "事件登记更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 事件登记新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjEventRegisterEntity djEventRegister, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djEventRegister.getId())) {
			djEventRegister = djEventRegisterService.getEntity(DjEventRegisterEntity.class, djEventRegister.getId());
			req.setAttribute("djEventRegisterPage", djEventRegister);
		}
		return new ModelAndView("com/dj/police/eventreg/djEventRegister-add");
	}
	/**
	 * 事件登记编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjEventRegisterEntity djEventRegister, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djEventRegister.getId())) {
			djEventRegister = djEventRegisterService.getEntity(DjEventRegisterEntity.class, djEventRegister.getId());
			req.setAttribute("djEventRegisterPage", djEventRegister);
		}
		return new ModelAndView("com/dj/police/eventreg/djEventRegister-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djEventRegisterController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjEventRegisterEntity djEventRegister,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjEventRegisterEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djEventRegister, request.getParameterMap());
		List<DjEventRegisterEntity> djEventRegisters = this.djEventRegisterService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"事件登记");
		modelMap.put(NormalExcelConstants.CLASS,DjEventRegisterEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("事件登记列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djEventRegisters);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjEventRegisterEntity djEventRegister,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "事件登记");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjEventRegisterEntity.class);
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
				List<DjEventRegisterEntity> listDjEventRegisterEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjEventRegisterEntity.class,params);
				for (DjEventRegisterEntity djEventRegister : listDjEventRegisterEntitys) {
					djEventRegisterService.save(djEventRegister);
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
