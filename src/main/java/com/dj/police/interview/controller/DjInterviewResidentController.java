package com.dj.police.interview.controller;
import com.dj.police.interview.entity.DjInterviewResidentEntity;
import com.dj.police.interview.service.DjInterviewResidentServiceI;
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
 * @Description: 民警走访
 * @author onlineGenerator
 * @date 2015-12-07 21:56:48
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djInterviewResidentController")
public class DjInterviewResidentController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjInterviewResidentController.class);

	@Autowired
	private DjInterviewResidentServiceI djInterviewResidentService;
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
	 * 民警走访列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djInterviewResident")
	public ModelAndView djInterviewResident(HttpServletRequest request) {
		return new ModelAndView("com/dj/police/interview/djInterviewResidentList");
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
	public void datagrid(DjInterviewResidentEntity djInterviewResident,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjInterviewResidentEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djInterviewResident, request.getParameterMap());
		try{
		//自定义追加查询条件
		String query_interStartTime_begin = request.getParameter("interStartTime_begin");
		String query_interStartTime_end = request.getParameter("interStartTime_end");
		if(StringUtil.isNotEmpty(query_interStartTime_begin)){
			cq.ge("interStartTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_interStartTime_begin));
		}
		if(StringUtil.isNotEmpty(query_interStartTime_end)){
			cq.le("interStartTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_interStartTime_end));
		}
		String query_interEndTime_begin = request.getParameter("interEndTime_begin");
		String query_interEndTime_end = request.getParameter("interEndTime_end");
		if(StringUtil.isNotEmpty(query_interEndTime_begin)){
			cq.ge("interEndTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_interEndTime_begin));
		}
		if(StringUtil.isNotEmpty(query_interEndTime_end)){
			cq.le("interEndTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_interEndTime_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djInterviewResidentService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除民警走访
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjInterviewResidentEntity djInterviewResident, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djInterviewResident = systemService.getEntity(DjInterviewResidentEntity.class, djInterviewResident.getId());
		message = "民警走访删除成功";
		try{
			djInterviewResidentService.delete(djInterviewResident);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "民警走访删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除民警走访
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "民警走访删除成功";
		try{
			for(String id:ids.split(",")){
				DjInterviewResidentEntity djInterviewResident = systemService.getEntity(DjInterviewResidentEntity.class, 
				Integer.parseInt(id)
				);
				djInterviewResidentService.delete(djInterviewResident);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "民警走访删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加民警走访
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjInterviewResidentEntity djInterviewResident, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "民警走访添加成功";
		try{
			djInterviewResidentService.save(djInterviewResident);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "民警走访添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新民警走访
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjInterviewResidentEntity djInterviewResident, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "民警走访更新成功";
		DjInterviewResidentEntity t = djInterviewResidentService.get(DjInterviewResidentEntity.class, djInterviewResident.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djInterviewResident, t);
			djInterviewResidentService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "民警走访更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 民警走访新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjInterviewResidentEntity djInterviewResident, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djInterviewResident.getId())) {
			djInterviewResident = djInterviewResidentService.getEntity(DjInterviewResidentEntity.class, djInterviewResident.getId());
			req.setAttribute("djInterviewResidentPage", djInterviewResident);
		}
		return new ModelAndView("com/dj/police/interview/djInterviewResident-add");
	}
	/**
	 * 民警走访编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjInterviewResidentEntity djInterviewResident, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djInterviewResident.getId())) {
			djInterviewResident = djInterviewResidentService.getEntity(DjInterviewResidentEntity.class, djInterviewResident.getId());
			req.setAttribute("djInterviewResidentPage", djInterviewResident);
		}
		return new ModelAndView("com/dj/police/interview/djInterviewResident-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djInterviewResidentController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjInterviewResidentEntity djInterviewResident,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjInterviewResidentEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djInterviewResident, request.getParameterMap());
		List<DjInterviewResidentEntity> djInterviewResidents = this.djInterviewResidentService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"民警走访");
		modelMap.put(NormalExcelConstants.CLASS,DjInterviewResidentEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("民警走访列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djInterviewResidents);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjInterviewResidentEntity djInterviewResident,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "民警走访");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjInterviewResidentEntity.class);
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
				List<DjInterviewResidentEntity> listDjInterviewResidentEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjInterviewResidentEntity.class,params);
				for (DjInterviewResidentEntity djInterviewResident : listDjInterviewResidentEntitys) {
					djInterviewResidentService.save(djInterviewResident);
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
