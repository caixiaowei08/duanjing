package com.dj.enterprise.entersecurity.controller;
import com.dj.enterprise.entersecurity.entity.DjEnterpriseSecurityCheckEntity;
import com.dj.enterprise.entersecurity.service.DjEnterpriseSecurityCheckServiceI;
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
 * @Description: 企业安全or消防检查
 * @author onlineGenerator
 * @date 2015-12-06 22:47:39
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djEnterpriseSecurityCheckController")
public class DjEnterpriseSecurityCheckController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjEnterpriseSecurityCheckController.class);

	@Autowired
	private DjEnterpriseSecurityCheckServiceI djEnterpriseSecurityCheckService;
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
	 * 企业安全or消防检查列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djEnterpriseSecurityCheck")
	public ModelAndView djEnterpriseSecurityCheck(HttpServletRequest request) {
		return new ModelAndView("com/dj/enterprise/entersecurity/djEnterpriseSecurityCheckList");
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
	public void datagrid(DjEnterpriseSecurityCheckEntity djEnterpriseSecurityCheck,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjEnterpriseSecurityCheckEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djEnterpriseSecurityCheck, request.getParameterMap());
		try{
		//自定义追加查询条件
		String query_enterTime_begin = request.getParameter("enterTime_begin");
		String query_enterTime_end = request.getParameter("enterTime_end");
		if(StringUtil.isNotEmpty(query_enterTime_begin)){
			cq.ge("enterTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_enterTime_begin));
		}
		if(StringUtil.isNotEmpty(query_enterTime_end)){
			cq.le("enterTime", new SimpleDateFormat("yyyy-MM-dd").parse(query_enterTime_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djEnterpriseSecurityCheckService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除企业安全or消防检查
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjEnterpriseSecurityCheckEntity djEnterpriseSecurityCheck, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djEnterpriseSecurityCheck = systemService.getEntity(DjEnterpriseSecurityCheckEntity.class, djEnterpriseSecurityCheck.getId());
		message = "企业安全or消防检查删除成功";
		try{
			djEnterpriseSecurityCheckService.delete(djEnterpriseSecurityCheck);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "企业安全or消防检查删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除企业安全or消防检查
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "企业安全or消防检查删除成功";
		try{
			for(String id:ids.split(",")){
				DjEnterpriseSecurityCheckEntity djEnterpriseSecurityCheck = systemService.getEntity(DjEnterpriseSecurityCheckEntity.class, 
				Integer.parseInt(id)
				);
				djEnterpriseSecurityCheckService.delete(djEnterpriseSecurityCheck);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "企业安全or消防检查删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加企业安全or消防检查
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjEnterpriseSecurityCheckEntity djEnterpriseSecurityCheck, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "企业安全or消防检查添加成功";
		try{
			djEnterpriseSecurityCheckService.save(djEnterpriseSecurityCheck);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "企业安全or消防检查添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新企业安全or消防检查
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjEnterpriseSecurityCheckEntity djEnterpriseSecurityCheck, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "企业安全or消防检查更新成功";
		DjEnterpriseSecurityCheckEntity t = djEnterpriseSecurityCheckService.get(DjEnterpriseSecurityCheckEntity.class, djEnterpriseSecurityCheck.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djEnterpriseSecurityCheck, t);
			djEnterpriseSecurityCheckService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "企业安全or消防检查更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 企业安全or消防检查新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjEnterpriseSecurityCheckEntity djEnterpriseSecurityCheck, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djEnterpriseSecurityCheck.getId())) {
			djEnterpriseSecurityCheck = djEnterpriseSecurityCheckService.getEntity(DjEnterpriseSecurityCheckEntity.class, djEnterpriseSecurityCheck.getId());
			req.setAttribute("djEnterpriseSecurityCheckPage", djEnterpriseSecurityCheck);
		}
		return new ModelAndView("com/dj/enterprise/entersecurity/djEnterpriseSecurityCheck-add");
	}
	/**
	 * 企业安全or消防检查编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjEnterpriseSecurityCheckEntity djEnterpriseSecurityCheck, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djEnterpriseSecurityCheck.getId())) {
			djEnterpriseSecurityCheck = djEnterpriseSecurityCheckService.getEntity(DjEnterpriseSecurityCheckEntity.class, djEnterpriseSecurityCheck.getId());
			req.setAttribute("djEnterpriseSecurityCheckPage", djEnterpriseSecurityCheck);
		}
		return new ModelAndView("com/dj/enterprise/entersecurity/djEnterpriseSecurityCheck-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djEnterpriseSecurityCheckController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjEnterpriseSecurityCheckEntity djEnterpriseSecurityCheck,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjEnterpriseSecurityCheckEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djEnterpriseSecurityCheck, request.getParameterMap());
		List<DjEnterpriseSecurityCheckEntity> djEnterpriseSecurityChecks = this.djEnterpriseSecurityCheckService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"企业安全or消防检查");
		modelMap.put(NormalExcelConstants.CLASS,DjEnterpriseSecurityCheckEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("企业安全or消防检查列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djEnterpriseSecurityChecks);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjEnterpriseSecurityCheckEntity djEnterpriseSecurityCheck,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "企业安全or消防检查");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjEnterpriseSecurityCheckEntity.class);
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
				List<DjEnterpriseSecurityCheckEntity> listDjEnterpriseSecurityCheckEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjEnterpriseSecurityCheckEntity.class,params);
				for (DjEnterpriseSecurityCheckEntity djEnterpriseSecurityCheck : listDjEnterpriseSecurityCheckEntitys) {
					djEnterpriseSecurityCheckService.save(djEnterpriseSecurityCheck);
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
