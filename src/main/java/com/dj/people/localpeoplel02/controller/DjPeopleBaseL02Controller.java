package com.dj.people.localpeoplel02.controller;
import com.dj.people.localpeoplel02.entity.DjPeopleBaseL02Entity;
import com.dj.people.localpeoplel02.service.DjPeopleBaseL02ServiceI;
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
 * @Description: 户在人不在
 * @author onlineGenerator
 * @date 2015-12-11 15:12:05
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djPeopleBaseL02Controller")
public class DjPeopleBaseL02Controller extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjPeopleBaseL02Controller.class);

	@Autowired
	private DjPeopleBaseL02ServiceI djPeopleBaseL02Service;
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
	 * 户在人不在列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djPeopleBaseL02")
	public ModelAndView djPeopleBaseL02(HttpServletRequest request) {
		return new ModelAndView("com/dj/people/localpeoplel02/djPeopleBaseL02List");
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
	public void datagrid(DjPeopleBaseL02Entity djPeopleBaseL02,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		/**
		 * 设置常驻人口中的 常驻标识 和 户在人不在  标识
		 */
		djPeopleBaseL02.setPeoType(ConstantUtil.PeoType.LOCAL_PEOPLE);
		djPeopleBaseL02.setPHouse(ConstantUtil.PHouse.P_HOUSE_02);
		
		
		CriteriaQuery cq = new CriteriaQuery(DjPeopleBaseL02Entity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djPeopleBaseL02, request.getParameterMap());
		try{
		//自定义追加查询条件
		String query_birthdate_begin = request.getParameter("birthdate_begin");
		String query_birthdate_end = request.getParameter("birthdate_end");
		if(StringUtil.isNotEmpty(query_birthdate_begin)){
			cq.ge("birthdate", new SimpleDateFormat("yyyy-MM-dd").parse(query_birthdate_begin));
		}
		if(StringUtil.isNotEmpty(query_birthdate_end)){
			cq.le("birthdate", new SimpleDateFormat("yyyy-MM-dd").parse(query_birthdate_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djPeopleBaseL02Service.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除户在人不在
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjPeopleBaseL02Entity djPeopleBaseL02, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djPeopleBaseL02 = systemService.getEntity(DjPeopleBaseL02Entity.class, djPeopleBaseL02.getId());
		message = "户在人不在删除成功";
		try{
			djPeopleBaseL02Service.delete(djPeopleBaseL02);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "户在人不在删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除户在人不在
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "户在人不在删除成功";
		try{
			for(String id:ids.split(",")){
				DjPeopleBaseL02Entity djPeopleBaseL02 = systemService.getEntity(DjPeopleBaseL02Entity.class, 
				Integer.parseInt(id)
				);
				djPeopleBaseL02Service.delete(djPeopleBaseL02);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "户在人不在删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加户在人不在
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjPeopleBaseL02Entity djPeopleBaseL02, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		/**
		 * 设置常驻人口中的 常驻标识 和 户在人不在  标识
		 */
		djPeopleBaseL02.setPeoType(ConstantUtil.PeoType.LOCAL_PEOPLE);
		djPeopleBaseL02.setPHouse(ConstantUtil.PHouse.P_HOUSE_02);
		
		
		message = "户在人不在添加成功";
		try{
			djPeopleBaseL02Service.save(djPeopleBaseL02);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "户在人不在添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新户在人不在
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjPeopleBaseL02Entity djPeopleBaseL02, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "户在人不在更新成功";
		DjPeopleBaseL02Entity t = djPeopleBaseL02Service.get(DjPeopleBaseL02Entity.class, djPeopleBaseL02.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djPeopleBaseL02, t);
			djPeopleBaseL02Service.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "户在人不在更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 户在人不在新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjPeopleBaseL02Entity djPeopleBaseL02, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djPeopleBaseL02.getId())) {
			djPeopleBaseL02 = djPeopleBaseL02Service.getEntity(DjPeopleBaseL02Entity.class, djPeopleBaseL02.getId());
			req.setAttribute("djPeopleBaseL02Page", djPeopleBaseL02);
		}
		return new ModelAndView("com/dj/people/localpeoplel02/djPeopleBaseL02-add");
	}
	/**
	 * 户在人不在编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjPeopleBaseL02Entity djPeopleBaseL02, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djPeopleBaseL02.getId())) {
			djPeopleBaseL02 = djPeopleBaseL02Service.getEntity(DjPeopleBaseL02Entity.class, djPeopleBaseL02.getId());
			req.setAttribute("djPeopleBaseL02Page", djPeopleBaseL02);
		}
		return new ModelAndView("com/dj/people/localpeoplel02/djPeopleBaseL02-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djPeopleBaseL02Controller");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjPeopleBaseL02Entity djPeopleBaseL02,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjPeopleBaseL02Entity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djPeopleBaseL02, request.getParameterMap());
		List<DjPeopleBaseL02Entity> djPeopleBaseL02s = this.djPeopleBaseL02Service.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"户在人不在");
		modelMap.put(NormalExcelConstants.CLASS,DjPeopleBaseL02Entity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("户在人不在列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djPeopleBaseL02s);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjPeopleBaseL02Entity djPeopleBaseL02,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "户在人不在");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjPeopleBaseL02Entity.class);
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
				List<DjPeopleBaseL02Entity> listDjPeopleBaseL02Entitys = ExcelImportUtil.importExcel(file.getInputStream(),DjPeopleBaseL02Entity.class,params);
				for (DjPeopleBaseL02Entity djPeopleBaseL02 : listDjPeopleBaseL02Entitys) {
					djPeopleBaseL02Service.save(djPeopleBaseL02);
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
