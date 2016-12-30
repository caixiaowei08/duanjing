package com.dj.birth.vaccination.controller;
import com.dj.birth.vaccination.entity.DjVaccinationInfoEntity;
import com.dj.birth.vaccination.service.DjVaccinationInfoServiceI;
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
 * @Description: 幼儿预防接种记录
 * @author onlineGenerator
 * @date 2015-12-14 21:25:57
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djVaccinationInfoController")
public class DjVaccinationInfoController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjVaccinationInfoController.class);

	@Autowired
	private DjVaccinationInfoServiceI djVaccinationInfoService;
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
	 * 幼儿预防接种记录列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djVaccinationInfo")
	public ModelAndView djVaccinationInfo(HttpServletRequest request) {
		return new ModelAndView("com/dj/birth/vaccination/djVaccinationInfoList");
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
	public void datagrid(DjVaccinationInfoEntity djVaccinationInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjVaccinationInfoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djVaccinationInfo, request.getParameterMap());
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
		String query_vaccination_begin = request.getParameter("vaccination_begin");
		String query_vaccination_end = request.getParameter("vaccination_end");
		if(StringUtil.isNotEmpty(query_vaccination_begin)){
			cq.ge("vaccination", new SimpleDateFormat("yyyy-MM-dd").parse(query_vaccination_begin));
		}
		if(StringUtil.isNotEmpty(query_vaccination_end)){
			cq.le("vaccination", new SimpleDateFormat("yyyy-MM-dd").parse(query_vaccination_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djVaccinationInfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除幼儿预防接种记录
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjVaccinationInfoEntity djVaccinationInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djVaccinationInfo = systemService.getEntity(DjVaccinationInfoEntity.class, djVaccinationInfo.getId());
		message = "幼儿预防接种记录删除成功";
		try{
			djVaccinationInfoService.delete(djVaccinationInfo);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "幼儿预防接种记录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除幼儿预防接种记录
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "幼儿预防接种记录删除成功";
		try{
			for(String id:ids.split(",")){
				DjVaccinationInfoEntity djVaccinationInfo = systemService.getEntity(DjVaccinationInfoEntity.class, 
				Integer.parseInt(id)
				);
				djVaccinationInfoService.delete(djVaccinationInfo);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "幼儿预防接种记录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加幼儿预防接种记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjVaccinationInfoEntity djVaccinationInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "幼儿预防接种记录添加成功";
		try{
			djVaccinationInfoService.save(djVaccinationInfo);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "幼儿预防接种记录添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新幼儿预防接种记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjVaccinationInfoEntity djVaccinationInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "幼儿预防接种记录更新成功";
		DjVaccinationInfoEntity t = djVaccinationInfoService.get(DjVaccinationInfoEntity.class, djVaccinationInfo.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djVaccinationInfo, t);
			djVaccinationInfoService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "幼儿预防接种记录更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 幼儿预防接种记录新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjVaccinationInfoEntity djVaccinationInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djVaccinationInfo.getId())) {
			djVaccinationInfo = djVaccinationInfoService.getEntity(DjVaccinationInfoEntity.class, djVaccinationInfo.getId());
			req.setAttribute("djVaccinationInfoPage", djVaccinationInfo);
		}
		return new ModelAndView("com/dj/birth/vaccination/djVaccinationInfo-add");
	}
	/**
	 * 幼儿预防接种记录编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjVaccinationInfoEntity djVaccinationInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djVaccinationInfo.getId())) {
			djVaccinationInfo = djVaccinationInfoService.getEntity(DjVaccinationInfoEntity.class, djVaccinationInfo.getId());
			req.setAttribute("djVaccinationInfoPage", djVaccinationInfo);
		}
		return new ModelAndView("com/dj/birth/vaccination/djVaccinationInfo-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djVaccinationInfoController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjVaccinationInfoEntity djVaccinationInfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjVaccinationInfoEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djVaccinationInfo, request.getParameterMap());
		List<DjVaccinationInfoEntity> djVaccinationInfos = this.djVaccinationInfoService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"幼儿预防接种记录");
		modelMap.put(NormalExcelConstants.CLASS,DjVaccinationInfoEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("幼儿预防接种记录列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djVaccinationInfos);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjVaccinationInfoEntity djVaccinationInfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "幼儿预防接种记录");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjVaccinationInfoEntity.class);
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
				List<DjVaccinationInfoEntity> listDjVaccinationInfoEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjVaccinationInfoEntity.class,params);
				for (DjVaccinationInfoEntity djVaccinationInfo : listDjVaccinationInfoEntitys) {
					djVaccinationInfoService.save(djVaccinationInfo);
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
