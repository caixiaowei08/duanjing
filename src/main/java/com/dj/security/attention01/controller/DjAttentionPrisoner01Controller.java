package com.dj.security.attention01.controller;
import com.dj.security.attention01.entity.DjAttentionPrisoner01Entity;
import com.dj.security.attention01.service.DjAttentionPrisoner01ServiceI;
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
 * @Description: 服刑人员
 * @author onlineGenerator
 * @date 2015-12-05 21:31:33
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djAttentionPrisoner01Controller")
public class DjAttentionPrisoner01Controller extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjAttentionPrisoner01Controller.class);

	@Autowired
	private DjAttentionPrisoner01ServiceI djAttentionPrisoner01Service;
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
	 * 服刑人员列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djAttentionPrisoner01")
	public ModelAndView djAttentionPrisoner01(HttpServletRequest request) {
		return new ModelAndView("com/dj/security/attention01/djAttentionPrisoner01List");
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
	public void datagrid(DjAttentionPrisoner01Entity djAttentionPrisoner01,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		
		
		CriteriaQuery cq = new CriteriaQuery(DjAttentionPrisoner01Entity.class, dataGrid);
		
		djAttentionPrisoner01.setAttentionType(ConstantUtil.Attention_Type.Attention_Type_01);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djAttentionPrisoner01, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djAttentionPrisoner01Service.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除服刑人员
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjAttentionPrisoner01Entity djAttentionPrisoner01, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djAttentionPrisoner01 = systemService.getEntity(DjAttentionPrisoner01Entity.class, djAttentionPrisoner01.getId());
		message = "服刑人员删除成功";
		try{
			djAttentionPrisoner01Service.delete(djAttentionPrisoner01);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "服刑人员删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除服刑人员
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "服刑人员删除成功";
		try{
			for(String id:ids.split(",")){
				DjAttentionPrisoner01Entity djAttentionPrisoner01 = systemService.getEntity(DjAttentionPrisoner01Entity.class, 
				Integer.parseInt(id)
				);
				djAttentionPrisoner01Service.delete(djAttentionPrisoner01);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "服刑人员删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加服刑人员
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjAttentionPrisoner01Entity djAttentionPrisoner01, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "服刑人员添加成功";
		try{
			djAttentionPrisoner01.setAttentionType(ConstantUtil.Attention_Type.Attention_Type_01);
			djAttentionPrisoner01Service.save(djAttentionPrisoner01);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "服刑人员添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新服刑人员
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjAttentionPrisoner01Entity djAttentionPrisoner01, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "服刑人员更新成功";
		DjAttentionPrisoner01Entity t = djAttentionPrisoner01Service.get(DjAttentionPrisoner01Entity.class, djAttentionPrisoner01.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djAttentionPrisoner01, t);
			djAttentionPrisoner01Service.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "服刑人员更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 服刑人员新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjAttentionPrisoner01Entity djAttentionPrisoner01, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djAttentionPrisoner01.getId())) {
			djAttentionPrisoner01 = djAttentionPrisoner01Service.getEntity(DjAttentionPrisoner01Entity.class, djAttentionPrisoner01.getId());
			req.setAttribute("djAttentionPrisoner01Page", djAttentionPrisoner01);
		}
		return new ModelAndView("com/dj/security/attention01/djAttentionPrisoner01-add");
	}
	/**
	 * 服刑人员编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjAttentionPrisoner01Entity djAttentionPrisoner01, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djAttentionPrisoner01.getId())) {
			djAttentionPrisoner01 = djAttentionPrisoner01Service.getEntity(DjAttentionPrisoner01Entity.class, djAttentionPrisoner01.getId());
			req.setAttribute("djAttentionPrisoner01Page", djAttentionPrisoner01);
		}
		return new ModelAndView("com/dj/security/attention01/djAttentionPrisoner01-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djAttentionPrisoner01Controller");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjAttentionPrisoner01Entity djAttentionPrisoner01,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjAttentionPrisoner01Entity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djAttentionPrisoner01, request.getParameterMap());
		List<DjAttentionPrisoner01Entity> djAttentionPrisoner01s = this.djAttentionPrisoner01Service.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"服刑人员");
		modelMap.put(NormalExcelConstants.CLASS,DjAttentionPrisoner01Entity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("服刑人员列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djAttentionPrisoner01s);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjAttentionPrisoner01Entity djAttentionPrisoner01,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "服刑人员");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjAttentionPrisoner01Entity.class);
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
				List<DjAttentionPrisoner01Entity> listDjAttentionPrisoner01Entitys = ExcelImportUtil.importExcel(file.getInputStream(),DjAttentionPrisoner01Entity.class,params);
				for (DjAttentionPrisoner01Entity djAttentionPrisoner01 : listDjAttentionPrisoner01Entitys) {
					djAttentionPrisoner01Service.save(djAttentionPrisoner01);
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
