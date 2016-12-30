package com.dj.police.returnvisit.controller;
import com.dj.police.returnvisit.entity.DjEventReturnVisitEntity;
import com.dj.police.returnvisit.service.DjEventReturnVisitServiceI;
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
 * @Description: 事件回访
 * @author onlineGenerator
 * @date 2015-12-07 21:57:35
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djEventReturnVisitController")
public class DjEventReturnVisitController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjEventReturnVisitController.class);

	@Autowired
	private DjEventReturnVisitServiceI djEventReturnVisitService;
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
	 * 事件回访列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djEventReturnVisit")
	public ModelAndView djEventReturnVisit(HttpServletRequest request) {
		return new ModelAndView("com/dj/police/returnvisit/djEventReturnVisitList");
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
	public void datagrid(DjEventReturnVisitEntity djEventReturnVisit,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjEventReturnVisitEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djEventReturnVisit, request.getParameterMap());
		try{
		//自定义追加查询条件
		String query_returnTime_begin = request.getParameter("returnTime_begin");
		String query_returnTime_end = request.getParameter("returnTime_end");
		if(StringUtil.isNotEmpty(query_returnTime_begin)){
			cq.ge("returnTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_returnTime_begin));
		}
		if(StringUtil.isNotEmpty(query_returnTime_end)){
			cq.le("returnTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_returnTime_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djEventReturnVisitService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除事件回访
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjEventReturnVisitEntity djEventReturnVisit, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djEventReturnVisit = systemService.getEntity(DjEventReturnVisitEntity.class, djEventReturnVisit.getId());
		message = "事件回访删除成功";
		try{
			djEventReturnVisitService.delete(djEventReturnVisit);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "事件回访删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除事件回访
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "事件回访删除成功";
		try{
			for(String id:ids.split(",")){
				DjEventReturnVisitEntity djEventReturnVisit = systemService.getEntity(DjEventReturnVisitEntity.class, 
				Integer.parseInt(id)
				);
				djEventReturnVisitService.delete(djEventReturnVisit);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "事件回访删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加事件回访
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjEventReturnVisitEntity djEventReturnVisit, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "事件回访添加成功";
		try{
			djEventReturnVisitService.save(djEventReturnVisit);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "事件回访添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新事件回访
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjEventReturnVisitEntity djEventReturnVisit, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "事件回访更新成功";
		DjEventReturnVisitEntity t = djEventReturnVisitService.get(DjEventReturnVisitEntity.class, djEventReturnVisit.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djEventReturnVisit, t);
			djEventReturnVisitService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "事件回访更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 事件回访新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjEventReturnVisitEntity djEventReturnVisit, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djEventReturnVisit.getId())) {
			djEventReturnVisit = djEventReturnVisitService.getEntity(DjEventReturnVisitEntity.class, djEventReturnVisit.getId());
			req.setAttribute("djEventReturnVisitPage", djEventReturnVisit);
		}
		return new ModelAndView("com/dj/police/returnvisit/djEventReturnVisit-add");
	}
	/**
	 * 事件回访编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjEventReturnVisitEntity djEventReturnVisit, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djEventReturnVisit.getId())) {
			djEventReturnVisit = djEventReturnVisitService.getEntity(DjEventReturnVisitEntity.class, djEventReturnVisit.getId());
			req.setAttribute("djEventReturnVisitPage", djEventReturnVisit);
		}
		return new ModelAndView("com/dj/police/returnvisit/djEventReturnVisit-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djEventReturnVisitController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjEventReturnVisitEntity djEventReturnVisit,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjEventReturnVisitEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djEventReturnVisit, request.getParameterMap());
		List<DjEventReturnVisitEntity> djEventReturnVisits = this.djEventReturnVisitService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"事件回访");
		modelMap.put(NormalExcelConstants.CLASS,DjEventReturnVisitEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("事件回访列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djEventReturnVisits);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjEventReturnVisitEntity djEventReturnVisit,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "事件回访");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjEventReturnVisitEntity.class);
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
				List<DjEventReturnVisitEntity> listDjEventReturnVisitEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjEventReturnVisitEntity.class,params);
				for (DjEventReturnVisitEntity djEventReturnVisit : listDjEventReturnVisitEntitys) {
					djEventReturnVisitService.save(djEventReturnVisit);
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
