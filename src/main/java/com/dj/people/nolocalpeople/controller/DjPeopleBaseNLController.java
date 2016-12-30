package com.dj.people.nolocalpeople.controller;
import com.dj.people.nolocalpeople.entity.DjPeopleBaseNLEntity;
import com.dj.people.nolocalpeople.service.DjPeopleBaseNLServiceI;
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
 * @Description: 来沪人员
 * @author onlineGenerator
 * @date 2015-12-11 15:27:41
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djPeopleBaseNLController")
public class DjPeopleBaseNLController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjPeopleBaseNLController.class);

	@Autowired
	private DjPeopleBaseNLServiceI djPeopleBaseNLService;
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
	 * 来沪人员列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djPeopleBaseNL")
	public ModelAndView djPeopleBaseNL(HttpServletRequest request) {
		return new ModelAndView("com/dj/people/nolocalpeople/djPeopleBaseNLList");
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
	public void datagrid(DjPeopleBaseNLEntity djPeopleBaseNL,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		/**
		 * 来沪人员 标识
		 */
		djPeopleBaseNL.setPeoType(ConstantUtil.PeoType.NONLOCAL_PEOPLE);
		
		CriteriaQuery cq = new CriteriaQuery(DjPeopleBaseNLEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djPeopleBaseNL, request.getParameterMap());
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
		this.djPeopleBaseNLService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除来沪人员
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjPeopleBaseNLEntity djPeopleBaseNL, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djPeopleBaseNL = systemService.getEntity(DjPeopleBaseNLEntity.class, djPeopleBaseNL.getId());
		message = "来沪人员删除成功";
		try{
			djPeopleBaseNLService.delete(djPeopleBaseNL);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "来沪人员删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除来沪人员
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "来沪人员删除成功";
		try{
			for(String id:ids.split(",")){
				DjPeopleBaseNLEntity djPeopleBaseNL = systemService.getEntity(DjPeopleBaseNLEntity.class, 
				Integer.parseInt(id)
				);
				djPeopleBaseNLService.delete(djPeopleBaseNL);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "来沪人员删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加来沪人员
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjPeopleBaseNLEntity djPeopleBaseNL, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "来沪人员添加成功";
		/**
		 * 来沪人员 标识
		 */
		djPeopleBaseNL.setPeoType(ConstantUtil.PeoType.NONLOCAL_PEOPLE);
		
		try{
			djPeopleBaseNLService.save(djPeopleBaseNL);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "来沪人员添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新来沪人员
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjPeopleBaseNLEntity djPeopleBaseNL, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "来沪人员更新成功";
		DjPeopleBaseNLEntity t = djPeopleBaseNLService.get(DjPeopleBaseNLEntity.class, djPeopleBaseNL.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djPeopleBaseNL, t);
			djPeopleBaseNLService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "来沪人员更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 来沪人员新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjPeopleBaseNLEntity djPeopleBaseNL, HttpServletRequest req) {
		
		if (StringUtil.isNotEmpty(djPeopleBaseNL.getId())) {
			djPeopleBaseNL = djPeopleBaseNLService.getEntity(DjPeopleBaseNLEntity.class, djPeopleBaseNL.getId());
			req.setAttribute("djPeopleBaseNLPage", djPeopleBaseNL);
		}
		return new ModelAndView("com/dj/people/nolocalpeople/djPeopleBaseNL-add");
	}
	/**
	 * 来沪人员编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjPeopleBaseNLEntity djPeopleBaseNL, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djPeopleBaseNL.getId())) {
			djPeopleBaseNL = djPeopleBaseNLService.getEntity(DjPeopleBaseNLEntity.class, djPeopleBaseNL.getId());
			req.setAttribute("djPeopleBaseNLPage", djPeopleBaseNL);
		}
		return new ModelAndView("com/dj/people/nolocalpeople/djPeopleBaseNL-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djPeopleBaseNLController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjPeopleBaseNLEntity djPeopleBaseNL,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjPeopleBaseNLEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djPeopleBaseNL, request.getParameterMap());
		List<DjPeopleBaseNLEntity> djPeopleBaseNLs = this.djPeopleBaseNLService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"来沪人员");
		modelMap.put(NormalExcelConstants.CLASS,DjPeopleBaseNLEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("来沪人员列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djPeopleBaseNLs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjPeopleBaseNLEntity djPeopleBaseNL,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "来沪人员");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjPeopleBaseNLEntity.class);
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
				List<DjPeopleBaseNLEntity> listDjPeopleBaseNLEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjPeopleBaseNLEntity.class,params);
				for (DjPeopleBaseNLEntity djPeopleBaseNL : listDjPeopleBaseNLEntitys) {
					djPeopleBaseNLService.save(djPeopleBaseNL);
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
