package com.dj.civil.assistance.controller;
import com.dj.civil.assistance.entity.DjSocialAssistanceEntity;
import com.dj.civil.assistance.service.DjSocialAssistanceServiceI;
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
 * @Description: 社会救助
 * @author onlineGenerator
 * @date 2015-12-05 17:41:17
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djSocialAssistanceController")
public class DjSocialAssistanceController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjSocialAssistanceController.class);

	@Autowired
	private DjSocialAssistanceServiceI djSocialAssistanceService;
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
	 * 社会救助列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djSocialAssistance")
	public ModelAndView djSocialAssistance(HttpServletRequest request) {
		return new ModelAndView("com/dj/civil/assistance/djSocialAssistanceList");
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
	public void datagrid(DjSocialAssistanceEntity djSocialAssistance,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjSocialAssistanceEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djSocialAssistance, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djSocialAssistanceService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除社会救助
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjSocialAssistanceEntity djSocialAssistance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djSocialAssistance = systemService.getEntity(DjSocialAssistanceEntity.class, djSocialAssistance.getId());
		message = "社会救助删除成功";
		try{
			djSocialAssistanceService.delete(djSocialAssistance);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "社会救助删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除社会救助
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "社会救助删除成功";
		try{
			for(String id:ids.split(",")){
				DjSocialAssistanceEntity djSocialAssistance = systemService.getEntity(DjSocialAssistanceEntity.class, 
				Integer.parseInt(id)
				);
				djSocialAssistanceService.delete(djSocialAssistance);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "社会救助删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加社会救助
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjSocialAssistanceEntity djSocialAssistance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "社会救助添加成功";
		try{
			djSocialAssistanceService.save(djSocialAssistance);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "社会救助添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新社会救助
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjSocialAssistanceEntity djSocialAssistance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "社会救助更新成功";
		DjSocialAssistanceEntity t = djSocialAssistanceService.get(DjSocialAssistanceEntity.class, djSocialAssistance.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djSocialAssistance, t);
			djSocialAssistanceService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "社会救助更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 社会救助新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjSocialAssistanceEntity djSocialAssistance, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djSocialAssistance.getId())) {
			djSocialAssistance = djSocialAssistanceService.getEntity(DjSocialAssistanceEntity.class, djSocialAssistance.getId());
			req.setAttribute("djSocialAssistancePage", djSocialAssistance);
		}
		return new ModelAndView("com/dj/civil/assistance/djSocialAssistance-add");
	}
	/**
	 * 社会救助编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjSocialAssistanceEntity djSocialAssistance, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djSocialAssistance.getId())) {
			djSocialAssistance = djSocialAssistanceService.getEntity(DjSocialAssistanceEntity.class, djSocialAssistance.getId());
			req.setAttribute("djSocialAssistancePage", djSocialAssistance);
		}
		return new ModelAndView("com/dj/civil/assistance/djSocialAssistance-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djSocialAssistanceController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjSocialAssistanceEntity djSocialAssistance,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjSocialAssistanceEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djSocialAssistance, request.getParameterMap());
		List<DjSocialAssistanceEntity> djSocialAssistances = this.djSocialAssistanceService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"社会救助");
		modelMap.put(NormalExcelConstants.CLASS,DjSocialAssistanceEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("社会救助列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djSocialAssistances);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjSocialAssistanceEntity djSocialAssistance,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "社会救助");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjSocialAssistanceEntity.class);
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
				List<DjSocialAssistanceEntity> listDjSocialAssistanceEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjSocialAssistanceEntity.class,params);
				for (DjSocialAssistanceEntity djSocialAssistance : listDjSocialAssistanceEntitys) {
					djSocialAssistanceService.save(djSocialAssistance);
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
