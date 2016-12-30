package com.dj.enterprise.enterprise.controller;
import com.dj.enterprise.enterprise.entity.DjEnterpriseManagerEntity;
import com.dj.enterprise.enterprise.service.DjEnterpriseManagerServiceI;
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
 * @Description: 企事业单位管理
 * @author onlineGenerator
 * @date 2015-12-06 22:46:44
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djEnterpriseManagerController")
public class DjEnterpriseManagerController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjEnterpriseManagerController.class);

	@Autowired
	private DjEnterpriseManagerServiceI djEnterpriseManagerService;
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
	 * 企事业单位管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djEnterpriseManager")
	public ModelAndView djEnterpriseManager(HttpServletRequest request) {
		return new ModelAndView("com/dj/enterprise/enterprise/djEnterpriseManagerList");
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
	public void datagrid(DjEnterpriseManagerEntity djEnterpriseManager,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjEnterpriseManagerEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djEnterpriseManager, request.getParameterMap());
		try{
		//自定义追加查询条件
		String query_enterTime_begin = request.getParameter("enterTime_begin");
		String query_enterTime_end = request.getParameter("enterTime_end");
		if(StringUtil.isNotEmpty(query_enterTime_begin)){
			cq.ge("enterTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_enterTime_begin));
		}
		if(StringUtil.isNotEmpty(query_enterTime_end)){
			cq.le("enterTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_enterTime_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djEnterpriseManagerService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除企事业单位管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjEnterpriseManagerEntity djEnterpriseManager, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djEnterpriseManager = systemService.getEntity(DjEnterpriseManagerEntity.class, djEnterpriseManager.getId());
		message = "企事业单位管理删除成功";
		try{
			djEnterpriseManagerService.delete(djEnterpriseManager);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "企事业单位管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除企事业单位管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "企事业单位管理删除成功";
		try{
			for(String id:ids.split(",")){
				DjEnterpriseManagerEntity djEnterpriseManager = systemService.getEntity(DjEnterpriseManagerEntity.class, 
				Integer.parseInt(id)
				);
				djEnterpriseManagerService.delete(djEnterpriseManager);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "企事业单位管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加企事业单位管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjEnterpriseManagerEntity djEnterpriseManager, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "企事业单位管理添加成功";
		try{
			djEnterpriseManagerService.save(djEnterpriseManager);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "企事业单位管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新企事业单位管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjEnterpriseManagerEntity djEnterpriseManager, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "企事业单位管理更新成功";
		DjEnterpriseManagerEntity t = djEnterpriseManagerService.get(DjEnterpriseManagerEntity.class, djEnterpriseManager.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djEnterpriseManager, t);
			djEnterpriseManagerService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "企事业单位管理更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 企事业单位管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjEnterpriseManagerEntity djEnterpriseManager, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djEnterpriseManager.getId())) {
			djEnterpriseManager = djEnterpriseManagerService.getEntity(DjEnterpriseManagerEntity.class, djEnterpriseManager.getId());
			req.setAttribute("djEnterpriseManagerPage", djEnterpriseManager);
		}
		return new ModelAndView("com/dj/enterprise/enterprise/djEnterpriseManager-add");
	}
	/**
	 * 企事业单位管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjEnterpriseManagerEntity djEnterpriseManager, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djEnterpriseManager.getId())) {
			djEnterpriseManager = djEnterpriseManagerService.getEntity(DjEnterpriseManagerEntity.class, djEnterpriseManager.getId());
			req.setAttribute("djEnterpriseManagerPage", djEnterpriseManager);
		}
		return new ModelAndView("com/dj/enterprise/enterprise/djEnterpriseManager-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djEnterpriseManagerController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjEnterpriseManagerEntity djEnterpriseManager,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjEnterpriseManagerEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djEnterpriseManager, request.getParameterMap());
		List<DjEnterpriseManagerEntity> djEnterpriseManagers = this.djEnterpriseManagerService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"企事业单位管理");
		modelMap.put(NormalExcelConstants.CLASS,DjEnterpriseManagerEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("企事业单位管理列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djEnterpriseManagers);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjEnterpriseManagerEntity djEnterpriseManager,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "企事业单位管理");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjEnterpriseManagerEntity.class);
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
				List<DjEnterpriseManagerEntity> listDjEnterpriseManagerEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjEnterpriseManagerEntity.class,params);
				for (DjEnterpriseManagerEntity djEnterpriseManager : listDjEnterpriseManagerEntitys) {
					djEnterpriseManagerService.save(djEnterpriseManager);
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
