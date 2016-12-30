package com.dj.health.treat.controller;
import com.dj.health.treat.entity.DjTreatDetailEntity;
import com.dj.health.treat.service.DjTreatDetailServiceI;
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
 * @Description: 就诊记录
 * @author onlineGenerator
 * @date 2015-12-06 23:04:31
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djTreatDetailController")
public class DjTreatDetailController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjTreatDetailController.class);

	@Autowired
	private DjTreatDetailServiceI djTreatDetailService;
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
	 * 就诊记录列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djTreatDetail")
	public ModelAndView djTreatDetail(HttpServletRequest request) {
		return new ModelAndView("com/dj/health/treat/djTreatDetailList");
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
	public void datagrid(DjTreatDetailEntity djTreatDetail,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjTreatDetailEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djTreatDetail, request.getParameterMap());
		try{
		//自定义追加查询条件
		String query_treatTime_begin = request.getParameter("treatTime_begin");
		String query_treatTime_end = request.getParameter("treatTime_end");
		if(StringUtil.isNotEmpty(query_treatTime_begin)){
			cq.ge("treatTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_treatTime_begin));
		}
		if(StringUtil.isNotEmpty(query_treatTime_end)){
			cq.le("treatTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_treatTime_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djTreatDetailService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除就诊记录
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjTreatDetailEntity djTreatDetail, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djTreatDetail = systemService.getEntity(DjTreatDetailEntity.class, djTreatDetail.getId());
		message = "就诊记录删除成功";
		try{
			djTreatDetailService.delete(djTreatDetail);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "就诊记录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除就诊记录
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "就诊记录删除成功";
		try{
			for(String id:ids.split(",")){
				DjTreatDetailEntity djTreatDetail = systemService.getEntity(DjTreatDetailEntity.class, 
				Integer.parseInt(id)
				);
				djTreatDetailService.delete(djTreatDetail);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "就诊记录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加就诊记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjTreatDetailEntity djTreatDetail, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "就诊记录添加成功";
		try{
			djTreatDetailService.save(djTreatDetail);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "就诊记录添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新就诊记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjTreatDetailEntity djTreatDetail, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "就诊记录更新成功";
		DjTreatDetailEntity t = djTreatDetailService.get(DjTreatDetailEntity.class, djTreatDetail.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djTreatDetail, t);
			djTreatDetailService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "就诊记录更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 就诊记录新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjTreatDetailEntity djTreatDetail, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djTreatDetail.getId())) {
			djTreatDetail = djTreatDetailService.getEntity(DjTreatDetailEntity.class, djTreatDetail.getId());
			req.setAttribute("djTreatDetailPage", djTreatDetail);
		}
		return new ModelAndView("com/dj/health/treat/djTreatDetail-add");
	}
	/**
	 * 就诊记录编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjTreatDetailEntity djTreatDetail, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djTreatDetail.getId())) {
			djTreatDetail = djTreatDetailService.getEntity(DjTreatDetailEntity.class, djTreatDetail.getId());
			req.setAttribute("djTreatDetailPage", djTreatDetail);
		}
		return new ModelAndView("com/dj/health/treat/djTreatDetail-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djTreatDetailController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjTreatDetailEntity djTreatDetail,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjTreatDetailEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djTreatDetail, request.getParameterMap());
		List<DjTreatDetailEntity> djTreatDetails = this.djTreatDetailService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"就诊记录");
		modelMap.put(NormalExcelConstants.CLASS,DjTreatDetailEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("就诊记录列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djTreatDetails);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjTreatDetailEntity djTreatDetail,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "就诊记录");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjTreatDetailEntity.class);
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
				List<DjTreatDetailEntity> listDjTreatDetailEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjTreatDetailEntity.class,params);
				for (DjTreatDetailEntity djTreatDetail : listDjTreatDetailEntitys) {
					djTreatDetailService.save(djTreatDetail);
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
