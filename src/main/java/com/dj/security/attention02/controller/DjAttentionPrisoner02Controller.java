package com.dj.security.attention02.controller;
import com.dj.security.attention02.entity.DjAttentionPrisoner02Entity;
import com.dj.security.attention02.service.DjAttentionPrisoner02ServiceI;
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
 * @Description: 监外服刑
 * @author onlineGenerator
 * @date 2015-12-05 21:32:07
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djAttentionPrisoner02Controller")
public class DjAttentionPrisoner02Controller extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjAttentionPrisoner02Controller.class);

	@Autowired
	private DjAttentionPrisoner02ServiceI djAttentionPrisoner02Service;
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
	 * 监外服刑列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djAttentionPrisoner02")
	public ModelAndView djAttentionPrisoner02(HttpServletRequest request) {
		return new ModelAndView("com/dj/security/attention02/djAttentionPrisoner02List");
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
	public void datagrid(DjAttentionPrisoner02Entity djAttentionPrisoner02,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjAttentionPrisoner02Entity.class, dataGrid);
		djAttentionPrisoner02.setAttentionType(ConstantUtil.Attention_Type.Attention_Type_02);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djAttentionPrisoner02, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djAttentionPrisoner02Service.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除监外服刑
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjAttentionPrisoner02Entity djAttentionPrisoner02, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djAttentionPrisoner02 = systemService.getEntity(DjAttentionPrisoner02Entity.class, djAttentionPrisoner02.getId());
		message = "监外服刑删除成功";
		try{
			djAttentionPrisoner02Service.delete(djAttentionPrisoner02);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "监外服刑删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除监外服刑
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "监外服刑删除成功";
		try{
			for(String id:ids.split(",")){
				DjAttentionPrisoner02Entity djAttentionPrisoner02 = systemService.getEntity(DjAttentionPrisoner02Entity.class, 
				Integer.parseInt(id)
				);
				djAttentionPrisoner02Service.delete(djAttentionPrisoner02);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "监外服刑删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加监外服刑
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjAttentionPrisoner02Entity djAttentionPrisoner02, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "监外服刑添加成功";
		try{
			djAttentionPrisoner02.setAttentionType(ConstantUtil.Attention_Type.Attention_Type_02);
			djAttentionPrisoner02Service.save(djAttentionPrisoner02);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "监外服刑添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新监外服刑
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjAttentionPrisoner02Entity djAttentionPrisoner02, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "监外服刑更新成功";
		DjAttentionPrisoner02Entity t = djAttentionPrisoner02Service.get(DjAttentionPrisoner02Entity.class, djAttentionPrisoner02.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djAttentionPrisoner02, t);
			djAttentionPrisoner02Service.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "监外服刑更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 监外服刑新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjAttentionPrisoner02Entity djAttentionPrisoner02, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djAttentionPrisoner02.getId())) {
			djAttentionPrisoner02 = djAttentionPrisoner02Service.getEntity(DjAttentionPrisoner02Entity.class, djAttentionPrisoner02.getId());
			req.setAttribute("djAttentionPrisoner02Page", djAttentionPrisoner02);
		}
		return new ModelAndView("com/dj/security/attention02/djAttentionPrisoner02-add");
	}
	/**
	 * 监外服刑编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjAttentionPrisoner02Entity djAttentionPrisoner02, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djAttentionPrisoner02.getId())) {
			djAttentionPrisoner02 = djAttentionPrisoner02Service.getEntity(DjAttentionPrisoner02Entity.class, djAttentionPrisoner02.getId());
			req.setAttribute("djAttentionPrisoner02Page", djAttentionPrisoner02);
		}
		return new ModelAndView("com/dj/security/attention02/djAttentionPrisoner02-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djAttentionPrisoner02Controller");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjAttentionPrisoner02Entity djAttentionPrisoner02,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjAttentionPrisoner02Entity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djAttentionPrisoner02, request.getParameterMap());
		List<DjAttentionPrisoner02Entity> djAttentionPrisoner02s = this.djAttentionPrisoner02Service.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"监外服刑");
		modelMap.put(NormalExcelConstants.CLASS,DjAttentionPrisoner02Entity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("监外服刑列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djAttentionPrisoner02s);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjAttentionPrisoner02Entity djAttentionPrisoner02,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "监外服刑");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjAttentionPrisoner02Entity.class);
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
				List<DjAttentionPrisoner02Entity> listDjAttentionPrisoner02Entitys = ExcelImportUtil.importExcel(file.getInputStream(),DjAttentionPrisoner02Entity.class,params);
				for (DjAttentionPrisoner02Entity djAttentionPrisoner02 : listDjAttentionPrisoner02Entitys) {
					djAttentionPrisoner02Service.save(djAttentionPrisoner02);
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
