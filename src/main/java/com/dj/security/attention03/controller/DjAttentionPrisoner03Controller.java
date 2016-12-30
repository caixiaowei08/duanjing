package com.dj.security.attention03.controller;
import com.dj.security.attention03.entity.DjAttentionPrisoner03Entity;
import com.dj.security.attention03.service.DjAttentionPrisoner03ServiceI;
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
 * @Description: 刑释解教
 * @author onlineGenerator
 * @date 2015-12-05 21:32:29
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djAttentionPrisoner03Controller")
public class DjAttentionPrisoner03Controller extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjAttentionPrisoner03Controller.class);

	@Autowired
	private DjAttentionPrisoner03ServiceI djAttentionPrisoner03Service;
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
	 * 刑释解教列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djAttentionPrisoner03")
	public ModelAndView djAttentionPrisoner03(HttpServletRequest request) {
		return new ModelAndView("com/dj/security/attention03/djAttentionPrisoner03List");
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
	public void datagrid(DjAttentionPrisoner03Entity djAttentionPrisoner03,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjAttentionPrisoner03Entity.class, dataGrid);
		
		djAttentionPrisoner03.setAttentionType(ConstantUtil.Attention_Type.Attention_Type_03);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djAttentionPrisoner03, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djAttentionPrisoner03Service.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除刑释解教
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjAttentionPrisoner03Entity djAttentionPrisoner03, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djAttentionPrisoner03 = systemService.getEntity(DjAttentionPrisoner03Entity.class, djAttentionPrisoner03.getId());
		message = "刑释解教删除成功";
		try{
			djAttentionPrisoner03Service.delete(djAttentionPrisoner03);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "刑释解教删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除刑释解教
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "刑释解教删除成功";
		try{
			for(String id:ids.split(",")){
				DjAttentionPrisoner03Entity djAttentionPrisoner03 = systemService.getEntity(DjAttentionPrisoner03Entity.class, 
				Integer.parseInt(id)
				);
				djAttentionPrisoner03Service.delete(djAttentionPrisoner03);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "刑释解教删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加刑释解教
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjAttentionPrisoner03Entity djAttentionPrisoner03, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "刑释解教添加成功";
		try{
			
			djAttentionPrisoner03.setAttentionType(ConstantUtil.Attention_Type.Attention_Type_03);
			djAttentionPrisoner03Service.save(djAttentionPrisoner03);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "刑释解教添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新刑释解教
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjAttentionPrisoner03Entity djAttentionPrisoner03, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "刑释解教更新成功";
		DjAttentionPrisoner03Entity t = djAttentionPrisoner03Service.get(DjAttentionPrisoner03Entity.class, djAttentionPrisoner03.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djAttentionPrisoner03, t);
			djAttentionPrisoner03Service.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "刑释解教更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 刑释解教新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjAttentionPrisoner03Entity djAttentionPrisoner03, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djAttentionPrisoner03.getId())) {
			djAttentionPrisoner03 = djAttentionPrisoner03Service.getEntity(DjAttentionPrisoner03Entity.class, djAttentionPrisoner03.getId());
			req.setAttribute("djAttentionPrisoner03Page", djAttentionPrisoner03);
		}
		return new ModelAndView("com/dj/security/attention03/djAttentionPrisoner03-add");
	}
	/**
	 * 刑释解教编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjAttentionPrisoner03Entity djAttentionPrisoner03, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djAttentionPrisoner03.getId())) {
			djAttentionPrisoner03 = djAttentionPrisoner03Service.getEntity(DjAttentionPrisoner03Entity.class, djAttentionPrisoner03.getId());
			req.setAttribute("djAttentionPrisoner03Page", djAttentionPrisoner03);
		}
		return new ModelAndView("com/dj/security/attention03/djAttentionPrisoner03-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djAttentionPrisoner03Controller");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjAttentionPrisoner03Entity djAttentionPrisoner03,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjAttentionPrisoner03Entity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djAttentionPrisoner03, request.getParameterMap());
		List<DjAttentionPrisoner03Entity> djAttentionPrisoner03s = this.djAttentionPrisoner03Service.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"刑释解教");
		modelMap.put(NormalExcelConstants.CLASS,DjAttentionPrisoner03Entity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("刑释解教列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djAttentionPrisoner03s);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjAttentionPrisoner03Entity djAttentionPrisoner03,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "刑释解教");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjAttentionPrisoner03Entity.class);
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
				List<DjAttentionPrisoner03Entity> listDjAttentionPrisoner03Entitys = ExcelImportUtil.importExcel(file.getInputStream(),DjAttentionPrisoner03Entity.class,params);
				for (DjAttentionPrisoner03Entity djAttentionPrisoner03 : listDjAttentionPrisoner03Entitys) {
					djAttentionPrisoner03Service.save(djAttentionPrisoner03);
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
