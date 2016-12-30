package com.dj.police.pnotify.controller;
import com.dj.police.pnotify.entity.DjPoliceNotifyEntity;
import com.dj.police.pnotify.service.DjPoliceNotifyServiceI;
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
 * @Description: 警情通报
 * @author onlineGenerator
 * @date 2015-12-07 21:56:07
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djPoliceNotifyController")
public class DjPoliceNotifyController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjPoliceNotifyController.class);

	@Autowired
	private DjPoliceNotifyServiceI djPoliceNotifyService;
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
	 * 警情通报列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djPoliceNotify")
	public ModelAndView djPoliceNotify(HttpServletRequest request) {
		return new ModelAndView("com/dj/police/pnotify/djPoliceNotifyList");
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
	public void datagrid(DjPoliceNotifyEntity djPoliceNotify,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjPoliceNotifyEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djPoliceNotify, request.getParameterMap());
		try{
		//自定义追加查询条件
		String query_notifyTime_begin = request.getParameter("notifyTime_begin");
		String query_notifyTime_end = request.getParameter("notifyTime_end");
		if(StringUtil.isNotEmpty(query_notifyTime_begin)){
			cq.ge("notifyTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_notifyTime_begin));
		}
		if(StringUtil.isNotEmpty(query_notifyTime_end)){
			cq.le("notifyTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_notifyTime_end));
		}
		String query_notifyStartTime_begin = request.getParameter("notifyStartTime_begin");
		String query_notifyStartTime_end = request.getParameter("notifyStartTime_end");
		if(StringUtil.isNotEmpty(query_notifyStartTime_begin)){
			cq.ge("notifyStartTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_notifyStartTime_begin));
		}
		if(StringUtil.isNotEmpty(query_notifyStartTime_end)){
			cq.le("notifyStartTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_notifyStartTime_end));
		}
		String query_notifyEndTime_begin = request.getParameter("notifyEndTime_begin");
		String query_notifyEndTime_end = request.getParameter("notifyEndTime_end");
		if(StringUtil.isNotEmpty(query_notifyEndTime_begin)){
			cq.ge("notifyEndTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_notifyEndTime_begin));
		}
		if(StringUtil.isNotEmpty(query_notifyEndTime_end)){
			cq.le("notifyEndTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_notifyEndTime_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djPoliceNotifyService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除警情通报
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjPoliceNotifyEntity djPoliceNotify, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djPoliceNotify = systemService.getEntity(DjPoliceNotifyEntity.class, djPoliceNotify.getId());
		message = "警情通报删除成功";
		try{
			djPoliceNotifyService.delete(djPoliceNotify);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "警情通报删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除警情通报
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "警情通报删除成功";
		try{
			for(String id:ids.split(",")){
				DjPoliceNotifyEntity djPoliceNotify = systemService.getEntity(DjPoliceNotifyEntity.class, 
				Integer.parseInt(id)
				);
				djPoliceNotifyService.delete(djPoliceNotify);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "警情通报删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加警情通报
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjPoliceNotifyEntity djPoliceNotify, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "警情通报添加成功";
		try{
			djPoliceNotifyService.save(djPoliceNotify);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "警情通报添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新警情通报
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjPoliceNotifyEntity djPoliceNotify, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "警情通报更新成功";
		DjPoliceNotifyEntity t = djPoliceNotifyService.get(DjPoliceNotifyEntity.class, djPoliceNotify.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djPoliceNotify, t);
			djPoliceNotifyService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "警情通报更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 警情通报新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjPoliceNotifyEntity djPoliceNotify, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djPoliceNotify.getId())) {
			djPoliceNotify = djPoliceNotifyService.getEntity(DjPoliceNotifyEntity.class, djPoliceNotify.getId());
			req.setAttribute("djPoliceNotifyPage", djPoliceNotify);
		}
		return new ModelAndView("com/dj/police/pnotify/djPoliceNotify-add");
	}
	/**
	 * 警情通报编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjPoliceNotifyEntity djPoliceNotify, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djPoliceNotify.getId())) {
			djPoliceNotify = djPoliceNotifyService.getEntity(DjPoliceNotifyEntity.class, djPoliceNotify.getId());
			req.setAttribute("djPoliceNotifyPage", djPoliceNotify);
		}
		return new ModelAndView("com/dj/police/pnotify/djPoliceNotify-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djPoliceNotifyController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjPoliceNotifyEntity djPoliceNotify,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjPoliceNotifyEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djPoliceNotify, request.getParameterMap());
		List<DjPoliceNotifyEntity> djPoliceNotifys = this.djPoliceNotifyService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"警情通报");
		modelMap.put(NormalExcelConstants.CLASS,DjPoliceNotifyEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("警情通报列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djPoliceNotifys);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjPoliceNotifyEntity djPoliceNotify,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "警情通报");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjPoliceNotifyEntity.class);
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
				List<DjPoliceNotifyEntity> listDjPoliceNotifyEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjPoliceNotifyEntity.class,params);
				for (DjPoliceNotifyEntity djPoliceNotify : listDjPoliceNotifyEntitys) {
					djPoliceNotifyService.save(djPoliceNotify);
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
