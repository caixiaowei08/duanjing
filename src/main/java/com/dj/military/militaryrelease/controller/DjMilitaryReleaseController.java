package com.dj.military.militaryrelease.controller;
import com.dj.military.militaryrelease.entity.DjMilitaryReleaseEntity;
import com.dj.military.militaryrelease.service.DjMilitaryReleaseServiceI;
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
 * @Description: 退役人员
 * @author onlineGenerator
 * @date 2015-12-14 21:05:22
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djMilitaryReleaseController")
public class DjMilitaryReleaseController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjMilitaryReleaseController.class);

	@Autowired
	private DjMilitaryReleaseServiceI djMilitaryReleaseService;
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
	 * 退役人员列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djMilitaryRelease")
	public ModelAndView djMilitaryRelease(HttpServletRequest request) {
		return new ModelAndView("com/dj/military/militaryRelease/djMilitaryReleaseList");
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
	public void datagrid(DjMilitaryReleaseEntity djMilitaryRelease,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjMilitaryReleaseEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djMilitaryRelease, request.getParameterMap());
		try{
		//自定义追加查询条件
		String query_militaryTime_begin = request.getParameter("militaryTime_begin");
		String query_militaryTime_end = request.getParameter("militaryTime_end");
		if(StringUtil.isNotEmpty(query_militaryTime_begin)){
			cq.ge("militaryTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_militaryTime_begin));
		}
		if(StringUtil.isNotEmpty(query_militaryTime_end)){
			cq.le("militaryTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_militaryTime_end));
		}
		String query_militaryReleTime_begin = request.getParameter("militaryReleTime_begin");
		String query_militaryReleTime_end = request.getParameter("militaryReleTime_end");
		if(StringUtil.isNotEmpty(query_militaryReleTime_begin)){
			cq.ge("militaryReleTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_militaryReleTime_begin));
		}
		if(StringUtil.isNotEmpty(query_militaryReleTime_end)){
			cq.le("militaryReleTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_militaryReleTime_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djMilitaryReleaseService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除退役人员
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjMilitaryReleaseEntity djMilitaryRelease, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djMilitaryRelease = systemService.getEntity(DjMilitaryReleaseEntity.class, djMilitaryRelease.getId());
		message = "退役人员删除成功";
		try{
			djMilitaryReleaseService.delete(djMilitaryRelease);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "退役人员删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除退役人员
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "退役人员删除成功";
		try{
			for(String id:ids.split(",")){
				DjMilitaryReleaseEntity djMilitaryRelease = systemService.getEntity(DjMilitaryReleaseEntity.class, 
				Integer.parseInt(id)
				);
				djMilitaryReleaseService.delete(djMilitaryRelease);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "退役人员删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加退役人员
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjMilitaryReleaseEntity djMilitaryRelease, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "退役人员添加成功";
		try{
			djMilitaryReleaseService.save(djMilitaryRelease);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "退役人员添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新退役人员
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjMilitaryReleaseEntity djMilitaryRelease, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "退役人员更新成功";
		DjMilitaryReleaseEntity t = djMilitaryReleaseService.get(DjMilitaryReleaseEntity.class, djMilitaryRelease.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djMilitaryRelease, t);
			djMilitaryReleaseService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "退役人员更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 退役人员新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjMilitaryReleaseEntity djMilitaryRelease, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djMilitaryRelease.getId())) {
			djMilitaryRelease = djMilitaryReleaseService.getEntity(DjMilitaryReleaseEntity.class, djMilitaryRelease.getId());
			req.setAttribute("djMilitaryReleasePage", djMilitaryRelease);
		}
		return new ModelAndView("com/dj/military/militaryRelease/djMilitaryRelease-add");
	}
	/**
	 * 退役人员编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjMilitaryReleaseEntity djMilitaryRelease, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djMilitaryRelease.getId())) {
			djMilitaryRelease = djMilitaryReleaseService.getEntity(DjMilitaryReleaseEntity.class, djMilitaryRelease.getId());
			req.setAttribute("djMilitaryReleasePage", djMilitaryRelease);
		}
		return new ModelAndView("com/dj/military/militaryRelease/djMilitaryRelease-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djMilitaryReleaseController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjMilitaryReleaseEntity djMilitaryRelease,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjMilitaryReleaseEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djMilitaryRelease, request.getParameterMap());
		List<DjMilitaryReleaseEntity> djMilitaryReleases = this.djMilitaryReleaseService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"退役人员");
		modelMap.put(NormalExcelConstants.CLASS,DjMilitaryReleaseEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("退役人员列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djMilitaryReleases);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjMilitaryReleaseEntity djMilitaryRelease,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "退役人员");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjMilitaryReleaseEntity.class);
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
				List<DjMilitaryReleaseEntity> listDjMilitaryReleaseEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjMilitaryReleaseEntity.class,params);
				for (DjMilitaryReleaseEntity djMilitaryRelease : listDjMilitaryReleaseEntitys) {
					djMilitaryReleaseService.save(djMilitaryRelease);
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
