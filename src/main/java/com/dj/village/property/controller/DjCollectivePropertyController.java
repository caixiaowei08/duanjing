package com.dj.village.property.controller;
import com.dj.village.property.entity.DjCollectivePropertyEntity;
import com.dj.village.property.service.DjCollectivePropertyServiceI;
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
 * @Description: 集体财产管理
 * @author onlineGenerator
 * @date 2015-12-05 13:04:30
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djCollectivePropertyController")
public class DjCollectivePropertyController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjCollectivePropertyController.class);

	@Autowired
	private DjCollectivePropertyServiceI djCollectivePropertyService;
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
	 * 集体财产管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djCollectiveProperty")
	public ModelAndView djCollectiveProperty(HttpServletRequest request) {
		return new ModelAndView("com/dj/village/property/djCollectivePropertyList");
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
	public void datagrid(DjCollectivePropertyEntity djCollectiveProperty,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjCollectivePropertyEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djCollectiveProperty, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djCollectivePropertyService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除集体财产管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjCollectivePropertyEntity djCollectiveProperty, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djCollectiveProperty = systemService.getEntity(DjCollectivePropertyEntity.class, djCollectiveProperty.getId());
		message = "集体财产管理删除成功";
		try{
			djCollectivePropertyService.delete(djCollectiveProperty);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "集体财产管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除集体财产管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "集体财产管理删除成功";
		try{
			for(String id:ids.split(",")){
				DjCollectivePropertyEntity djCollectiveProperty = systemService.getEntity(DjCollectivePropertyEntity.class, 
				Integer.parseInt(id)
				);
				djCollectivePropertyService.delete(djCollectiveProperty);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "集体财产管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加集体财产管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjCollectivePropertyEntity djCollectiveProperty, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "集体财产管理添加成功";
		try{
			djCollectivePropertyService.save(djCollectiveProperty);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "集体财产管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新集体财产管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjCollectivePropertyEntity djCollectiveProperty, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "集体财产管理更新成功";
		DjCollectivePropertyEntity t = djCollectivePropertyService.get(DjCollectivePropertyEntity.class, djCollectiveProperty.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djCollectiveProperty, t);
			djCollectivePropertyService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "集体财产管理更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 集体财产管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjCollectivePropertyEntity djCollectiveProperty, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djCollectiveProperty.getId())) {
			djCollectiveProperty = djCollectivePropertyService.getEntity(DjCollectivePropertyEntity.class, djCollectiveProperty.getId());
			req.setAttribute("djCollectivePropertyPage", djCollectiveProperty);
		}
		return new ModelAndView("com/dj/village/property/djCollectiveProperty-add");
	}
	/**
	 * 集体财产管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjCollectivePropertyEntity djCollectiveProperty, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djCollectiveProperty.getId())) {
			djCollectiveProperty = djCollectivePropertyService.getEntity(DjCollectivePropertyEntity.class, djCollectiveProperty.getId());
			req.setAttribute("djCollectivePropertyPage", djCollectiveProperty);
		}
		return new ModelAndView("com/dj/village/property/djCollectiveProperty-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djCollectivePropertyController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjCollectivePropertyEntity djCollectiveProperty,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjCollectivePropertyEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djCollectiveProperty, request.getParameterMap());
		List<DjCollectivePropertyEntity> djCollectivePropertys = this.djCollectivePropertyService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"集体财产管理");
		modelMap.put(NormalExcelConstants.CLASS,DjCollectivePropertyEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("集体财产管理列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djCollectivePropertys);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjCollectivePropertyEntity djCollectiveProperty,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "集体财产管理");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjCollectivePropertyEntity.class);
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
				List<DjCollectivePropertyEntity> listDjCollectivePropertyEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjCollectivePropertyEntity.class,params);
				for (DjCollectivePropertyEntity djCollectiveProperty : listDjCollectivePropertyEntitys) {
					djCollectivePropertyService.save(djCollectiveProperty);
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
