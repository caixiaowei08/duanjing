package com.dj.police.propaganda.controller;
import com.dj.police.propaganda.entity.DjPreventionPropagandaEntity;
import com.dj.police.propaganda.service.DjPreventionPropagandaServiceI;
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
 * @Description: 防范宣传
 * @author onlineGenerator
 * @date 2015-12-07 21:56:27
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djPreventionPropagandaController")
public class DjPreventionPropagandaController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjPreventionPropagandaController.class);

	@Autowired
	private DjPreventionPropagandaServiceI djPreventionPropagandaService;
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
	 * 防范宣传列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djPreventionPropaganda")
	public ModelAndView djPreventionPropaganda(HttpServletRequest request) {
		return new ModelAndView("com/dj/police/propaganda/djPreventionPropagandaList");
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
	public void datagrid(DjPreventionPropagandaEntity djPreventionPropaganda,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjPreventionPropagandaEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djPreventionPropaganda, request.getParameterMap());
		try{
		//自定义追加查询条件
		String query_preveTime_begin = request.getParameter("preveTime_begin");
		String query_preveTime_end = request.getParameter("preveTime_end");
		if(StringUtil.isNotEmpty(query_preveTime_begin)){
			cq.ge("preveTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_preveTime_begin));
		}
		if(StringUtil.isNotEmpty(query_preveTime_end)){
			cq.le("preveTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_preveTime_end));
		}
		String query_preveStartTime_begin = request.getParameter("preveStartTime_begin");
		String query_preveStartTime_end = request.getParameter("preveStartTime_end");
		if(StringUtil.isNotEmpty(query_preveStartTime_begin)){
			cq.ge("preveStartTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_preveStartTime_begin));
		}
		if(StringUtil.isNotEmpty(query_preveStartTime_end)){
			cq.le("preveStartTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_preveStartTime_end));
		}
		String query_preveEndTime_begin = request.getParameter("preveEndTime_begin");
		String query_preveEndTime_end = request.getParameter("preveEndTime_end");
		if(StringUtil.isNotEmpty(query_preveEndTime_begin)){
			cq.ge("preveEndTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_preveEndTime_begin));
		}
		if(StringUtil.isNotEmpty(query_preveEndTime_end)){
			cq.le("preveEndTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_preveEndTime_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djPreventionPropagandaService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除防范宣传
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjPreventionPropagandaEntity djPreventionPropaganda, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djPreventionPropaganda = systemService.getEntity(DjPreventionPropagandaEntity.class, djPreventionPropaganda.getId());
		message = "防范宣传删除成功";
		try{
			djPreventionPropagandaService.delete(djPreventionPropaganda);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "防范宣传删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除防范宣传
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "防范宣传删除成功";
		try{
			for(String id:ids.split(",")){
				DjPreventionPropagandaEntity djPreventionPropaganda = systemService.getEntity(DjPreventionPropagandaEntity.class, 
				Integer.parseInt(id)
				);
				djPreventionPropagandaService.delete(djPreventionPropaganda);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "防范宣传删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加防范宣传
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjPreventionPropagandaEntity djPreventionPropaganda, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "防范宣传添加成功";
		try{
			djPreventionPropagandaService.save(djPreventionPropaganda);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "防范宣传添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新防范宣传
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjPreventionPropagandaEntity djPreventionPropaganda, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "防范宣传更新成功";
		DjPreventionPropagandaEntity t = djPreventionPropagandaService.get(DjPreventionPropagandaEntity.class, djPreventionPropaganda.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djPreventionPropaganda, t);
			djPreventionPropagandaService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "防范宣传更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 防范宣传新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjPreventionPropagandaEntity djPreventionPropaganda, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djPreventionPropaganda.getId())) {
			djPreventionPropaganda = djPreventionPropagandaService.getEntity(DjPreventionPropagandaEntity.class, djPreventionPropaganda.getId());
			req.setAttribute("djPreventionPropagandaPage", djPreventionPropaganda);
		}
		return new ModelAndView("com/dj/police/propaganda/djPreventionPropaganda-add");
	}
	/**
	 * 防范宣传编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjPreventionPropagandaEntity djPreventionPropaganda, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djPreventionPropaganda.getId())) {
			djPreventionPropaganda = djPreventionPropagandaService.getEntity(DjPreventionPropagandaEntity.class, djPreventionPropaganda.getId());
			req.setAttribute("djPreventionPropagandaPage", djPreventionPropaganda);
		}
		return new ModelAndView("com/dj/police/propaganda/djPreventionPropaganda-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djPreventionPropagandaController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjPreventionPropagandaEntity djPreventionPropaganda,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjPreventionPropagandaEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djPreventionPropaganda, request.getParameterMap());
		List<DjPreventionPropagandaEntity> djPreventionPropagandas = this.djPreventionPropagandaService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"防范宣传");
		modelMap.put(NormalExcelConstants.CLASS,DjPreventionPropagandaEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("防范宣传列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djPreventionPropagandas);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjPreventionPropagandaEntity djPreventionPropaganda,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "防范宣传");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjPreventionPropagandaEntity.class);
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
				List<DjPreventionPropagandaEntity> listDjPreventionPropagandaEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjPreventionPropagandaEntity.class,params);
				for (DjPreventionPropagandaEntity djPreventionPropaganda : listDjPreventionPropagandaEntitys) {
					djPreventionPropagandaService.save(djPreventionPropaganda);
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
