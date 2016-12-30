package com.dj.people.localpeoplel01.controller;
import com.dj.people.localpeoplel01.entity.DjPeopleBaseL01Entity;
import com.dj.people.localpeoplel01.service.DjPeopleBaseL01ServiceI;
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
 * @Description: 户籍人口
 * @author onlineGenerator
 * @date 2015-12-11 15:17:07
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djPeopleBaseL01Controller")
public class DjPeopleBaseL01Controller extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjPeopleBaseL01Controller.class);

	@Autowired
	private DjPeopleBaseL01ServiceI djPeopleBaseL01Service;
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
	 * 户籍人口列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djPeopleBaseL01")
	public ModelAndView djPeopleBaseL01(HttpServletRequest request) {
		return new ModelAndView("com/dj/people/localpeoplel01/djPeopleBaseL01List");
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
	public void datagrid(DjPeopleBaseL01Entity djPeopleBaseL01,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		
		/**
		 * 设置查询条件
		 */
		djPeopleBaseL01.setPeoType(ConstantUtil.PeoType.LOCAL_PEOPLE);
		djPeopleBaseL01.setPHouse(ConstantUtil.PHouse.P_HOUSE_01);
		
		CriteriaQuery cq = new CriteriaQuery(DjPeopleBaseL01Entity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djPeopleBaseL01, request.getParameterMap());
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
		this.djPeopleBaseL01Service.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除户籍人口
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjPeopleBaseL01Entity djPeopleBaseL01, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djPeopleBaseL01 = systemService.getEntity(DjPeopleBaseL01Entity.class, djPeopleBaseL01.getId());
		message = "户籍人口删除成功";
		try{
			djPeopleBaseL01Service.delete(djPeopleBaseL01);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "户籍人口删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除户籍人口
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "户籍人口删除成功";
		try{
			for(String id:ids.split(",")){
				DjPeopleBaseL01Entity djPeopleBaseL01 = systemService.getEntity(DjPeopleBaseL01Entity.class, 
				Integer.parseInt(id)
				);
				djPeopleBaseL01Service.delete(djPeopleBaseL01);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "户籍人口删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加户籍人口
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjPeopleBaseL01Entity djPeopleBaseL01, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "户籍人口添加成功";
		/**
		 * 设置常驻人口中的 常驻标识 和  户籍人口标识
		 */
		djPeopleBaseL01.setPeoType(ConstantUtil.PeoType.LOCAL_PEOPLE);
		djPeopleBaseL01.setPHouse(ConstantUtil.PHouse.P_HOUSE_01);
		
		//设置默认住房 101 1楼
		djPeopleBaseL01.setFloorNoCurrent("1");
		djPeopleBaseL01.setRoomNoCurrent("101");
		
		
		try{
			djPeopleBaseL01Service.save(djPeopleBaseL01);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "户籍人口添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新户籍人口
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjPeopleBaseL01Entity djPeopleBaseL01, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "户籍人口更新成功";
		DjPeopleBaseL01Entity t = djPeopleBaseL01Service.get(DjPeopleBaseL01Entity.class, djPeopleBaseL01.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djPeopleBaseL01, t);
			djPeopleBaseL01Service.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "户籍人口更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 户籍人口新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjPeopleBaseL01Entity djPeopleBaseL01, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djPeopleBaseL01.getId())) {
			djPeopleBaseL01 = djPeopleBaseL01Service.getEntity(DjPeopleBaseL01Entity.class, djPeopleBaseL01.getId());
			req.setAttribute("djPeopleBaseL01Page", djPeopleBaseL01);
		}
		return new ModelAndView("com/dj/people/localpeoplel01/djPeopleBaseL01-add");
	}
	/**
	 * 户籍人口编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjPeopleBaseL01Entity djPeopleBaseL01, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djPeopleBaseL01.getId())) {
			djPeopleBaseL01 = djPeopleBaseL01Service.getEntity(DjPeopleBaseL01Entity.class, djPeopleBaseL01.getId());
			req.setAttribute("djPeopleBaseL01Page", djPeopleBaseL01);
		}
		return new ModelAndView("com/dj/people/localpeoplel01/djPeopleBaseL01-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djPeopleBaseL01Controller");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjPeopleBaseL01Entity djPeopleBaseL01,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjPeopleBaseL01Entity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djPeopleBaseL01, request.getParameterMap());
		List<DjPeopleBaseL01Entity> djPeopleBaseL01s = this.djPeopleBaseL01Service.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"户籍人口");
		modelMap.put(NormalExcelConstants.CLASS,DjPeopleBaseL01Entity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("户籍人口列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djPeopleBaseL01s);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjPeopleBaseL01Entity djPeopleBaseL01,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "户籍人口");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjPeopleBaseL01Entity.class);
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
				List<DjPeopleBaseL01Entity> listDjPeopleBaseL01Entitys = ExcelImportUtil.importExcel(file.getInputStream(),DjPeopleBaseL01Entity.class,params);
				for (DjPeopleBaseL01Entity djPeopleBaseL01 : listDjPeopleBaseL01Entitys) {
					djPeopleBaseL01Service.save(djPeopleBaseL01);
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
