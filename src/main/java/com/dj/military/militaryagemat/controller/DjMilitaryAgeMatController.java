package com.dj.military.militaryagemat.controller;
import com.dj.military.militaryagemat.entity.DjMilitaryAgeMatEntity;
import com.dj.military.militaryagemat.service.DjMilitaryAgeMatServiceI;
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
 * @Description: 兵役适龄人员
 * @author onlineGenerator
 * @date 2015-12-14 21:04:48
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djMilitaryAgeMatController")
public class DjMilitaryAgeMatController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjMilitaryAgeMatController.class);

	@Autowired
	private DjMilitaryAgeMatServiceI djMilitaryAgeMatService;
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
	 * 兵役适龄人员列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djMilitaryAgeMat")
	public ModelAndView djMilitaryAgeMat(HttpServletRequest request) {
		return new ModelAndView("com/dj/military/militaryAgeMat/djMilitaryAgeMatList");
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
	public void datagrid(DjMilitaryAgeMatEntity djMilitaryAgeMat,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjMilitaryAgeMatEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djMilitaryAgeMat, request.getParameterMap());
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
		this.djMilitaryAgeMatService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除兵役适龄人员
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjMilitaryAgeMatEntity djMilitaryAgeMat, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djMilitaryAgeMat = systemService.getEntity(DjMilitaryAgeMatEntity.class, djMilitaryAgeMat.getId());
		message = "兵役适龄人员删除成功";
		try{
			djMilitaryAgeMatService.delete(djMilitaryAgeMat);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "兵役适龄人员删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除兵役适龄人员
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "兵役适龄人员删除成功";
		try{
			for(String id:ids.split(",")){
				DjMilitaryAgeMatEntity djMilitaryAgeMat = systemService.getEntity(DjMilitaryAgeMatEntity.class, 
				Integer.parseInt(id)
				);
				djMilitaryAgeMatService.delete(djMilitaryAgeMat);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "兵役适龄人员删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加兵役适龄人员
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjMilitaryAgeMatEntity djMilitaryAgeMat, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "兵役适龄人员添加成功";
		try{
			djMilitaryAgeMatService.save(djMilitaryAgeMat);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "兵役适龄人员添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新兵役适龄人员
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjMilitaryAgeMatEntity djMilitaryAgeMat, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "兵役适龄人员更新成功";
		DjMilitaryAgeMatEntity t = djMilitaryAgeMatService.get(DjMilitaryAgeMatEntity.class, djMilitaryAgeMat.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djMilitaryAgeMat, t);
			djMilitaryAgeMatService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "兵役适龄人员更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 兵役适龄人员新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjMilitaryAgeMatEntity djMilitaryAgeMat, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djMilitaryAgeMat.getId())) {
			djMilitaryAgeMat = djMilitaryAgeMatService.getEntity(DjMilitaryAgeMatEntity.class, djMilitaryAgeMat.getId());
			req.setAttribute("djMilitaryAgeMatPage", djMilitaryAgeMat);
		}
		return new ModelAndView("com/dj/military/militaryAgeMat/djMilitaryAgeMat-add");
	}
	/**
	 * 兵役适龄人员编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjMilitaryAgeMatEntity djMilitaryAgeMat, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djMilitaryAgeMat.getId())) {
			djMilitaryAgeMat = djMilitaryAgeMatService.getEntity(DjMilitaryAgeMatEntity.class, djMilitaryAgeMat.getId());
			req.setAttribute("djMilitaryAgeMatPage", djMilitaryAgeMat);
		}
		return new ModelAndView("com/dj/military/militaryAgeMat/djMilitaryAgeMat-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djMilitaryAgeMatController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjMilitaryAgeMatEntity djMilitaryAgeMat,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjMilitaryAgeMatEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djMilitaryAgeMat, request.getParameterMap());
		List<DjMilitaryAgeMatEntity> djMilitaryAgeMats = this.djMilitaryAgeMatService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"兵役适龄人员");
		modelMap.put(NormalExcelConstants.CLASS,DjMilitaryAgeMatEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("兵役适龄人员列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djMilitaryAgeMats);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjMilitaryAgeMatEntity djMilitaryAgeMat,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "兵役适龄人员");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjMilitaryAgeMatEntity.class);
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
				List<DjMilitaryAgeMatEntity> listDjMilitaryAgeMatEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjMilitaryAgeMatEntity.class,params);
				for (DjMilitaryAgeMatEntity djMilitaryAgeMat : listDjMilitaryAgeMatEntitys) {
					djMilitaryAgeMatService.save(djMilitaryAgeMat);
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
