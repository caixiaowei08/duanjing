package com.dj.civil.insurance.controller;
import com.dj.civil.insurance.entity.DjSocialInsuranceEntity;
import com.dj.civil.insurance.service.DjSocialInsuranceServiceI;
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
 * @Description: 社保管理
 * @author onlineGenerator
 * @date 2015-12-05 17:41:46
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djSocialInsuranceController")
public class DjSocialInsuranceController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjSocialInsuranceController.class);

	@Autowired
	private DjSocialInsuranceServiceI djSocialInsuranceService;
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
	 * 社保管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djSocialInsurance")
	public ModelAndView djSocialInsurance(HttpServletRequest request) {
		return new ModelAndView("com/dj/civil/insurance/djSocialInsuranceList");
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
	public void datagrid(DjSocialInsuranceEntity djSocialInsurance,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjSocialInsuranceEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djSocialInsurance, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djSocialInsuranceService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除社保管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjSocialInsuranceEntity djSocialInsurance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djSocialInsurance = systemService.getEntity(DjSocialInsuranceEntity.class, djSocialInsurance.getId());
		message = "社保管理删除成功";
		try{
			djSocialInsuranceService.delete(djSocialInsurance);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "社保管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除社保管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "社保管理删除成功";
		try{
			for(String id:ids.split(",")){
				DjSocialInsuranceEntity djSocialInsurance = systemService.getEntity(DjSocialInsuranceEntity.class, 
				Integer.parseInt(id)
				);
				djSocialInsuranceService.delete(djSocialInsurance);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "社保管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加社保管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjSocialInsuranceEntity djSocialInsurance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "社保管理添加成功";
		try{
			djSocialInsuranceService.save(djSocialInsurance);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "社保管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新社保管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjSocialInsuranceEntity djSocialInsurance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "社保管理更新成功";
		DjSocialInsuranceEntity t = djSocialInsuranceService.get(DjSocialInsuranceEntity.class, djSocialInsurance.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djSocialInsurance, t);
			djSocialInsuranceService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "社保管理更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 社保管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjSocialInsuranceEntity djSocialInsurance, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djSocialInsurance.getId())) {
			djSocialInsurance = djSocialInsuranceService.getEntity(DjSocialInsuranceEntity.class, djSocialInsurance.getId());
			req.setAttribute("djSocialInsurancePage", djSocialInsurance);
		}
		return new ModelAndView("com/dj/civil/insurance/djSocialInsurance-add");
	}
	/**
	 * 社保管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjSocialInsuranceEntity djSocialInsurance, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djSocialInsurance.getId())) {
			djSocialInsurance = djSocialInsuranceService.getEntity(DjSocialInsuranceEntity.class, djSocialInsurance.getId());
			req.setAttribute("djSocialInsurancePage", djSocialInsurance);
		}
		return new ModelAndView("com/dj/civil/insurance/djSocialInsurance-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djSocialInsuranceController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjSocialInsuranceEntity djSocialInsurance,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjSocialInsuranceEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djSocialInsurance, request.getParameterMap());
		List<DjSocialInsuranceEntity> djSocialInsurances = this.djSocialInsuranceService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"社保管理");
		modelMap.put(NormalExcelConstants.CLASS,DjSocialInsuranceEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("社保管理列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djSocialInsurances);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjSocialInsuranceEntity djSocialInsurance,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "社保管理");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjSocialInsuranceEntity.class);
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
				List<DjSocialInsuranceEntity> listDjSocialInsuranceEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjSocialInsuranceEntity.class,params);
				for (DjSocialInsuranceEntity djSocialInsurance : listDjSocialInsuranceEntitys) {
					djSocialInsuranceService.save(djSocialInsurance);
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
