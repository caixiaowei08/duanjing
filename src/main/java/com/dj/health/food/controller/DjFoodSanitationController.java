package com.dj.health.food.controller;
import com.dj.health.food.entity.DjFoodSanitationEntity;
import com.dj.health.food.service.DjFoodSanitationServiceI;
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
 * @Description: 无证摊位
 * @author onlineGenerator
 * @date 2015-12-06 23:05:02
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djFoodSanitationController")
public class DjFoodSanitationController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjFoodSanitationController.class);

	@Autowired
	private DjFoodSanitationServiceI djFoodSanitationService;
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
	 * 无证摊位列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djFoodSanitation")
	public ModelAndView djFoodSanitation(HttpServletRequest request) {
		return new ModelAndView("com/dj/health/food/djFoodSanitationList");
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
	public void datagrid(DjFoodSanitationEntity djFoodSanitation,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjFoodSanitationEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djFoodSanitation, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djFoodSanitationService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除无证摊位
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjFoodSanitationEntity djFoodSanitation, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djFoodSanitation = systemService.getEntity(DjFoodSanitationEntity.class, djFoodSanitation.getId());
		message = "无证摊位删除成功";
		try{
			djFoodSanitationService.delete(djFoodSanitation);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "无证摊位删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除无证摊位
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "无证摊位删除成功";
		try{
			for(String id:ids.split(",")){
				DjFoodSanitationEntity djFoodSanitation = systemService.getEntity(DjFoodSanitationEntity.class, 
				Integer.parseInt(id)
				);
				djFoodSanitationService.delete(djFoodSanitation);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "无证摊位删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加无证摊位
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjFoodSanitationEntity djFoodSanitation, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "无证摊位添加成功";
		try{
			djFoodSanitationService.save(djFoodSanitation);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "无证摊位添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新无证摊位
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjFoodSanitationEntity djFoodSanitation, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "无证摊位更新成功";
		DjFoodSanitationEntity t = djFoodSanitationService.get(DjFoodSanitationEntity.class, djFoodSanitation.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djFoodSanitation, t);
			djFoodSanitationService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "无证摊位更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 无证摊位新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjFoodSanitationEntity djFoodSanitation, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djFoodSanitation.getId())) {
			djFoodSanitation = djFoodSanitationService.getEntity(DjFoodSanitationEntity.class, djFoodSanitation.getId());
			req.setAttribute("djFoodSanitationPage", djFoodSanitation);
		}
		return new ModelAndView("com/dj/health/food/djFoodSanitation-add");
	}
	/**
	 * 无证摊位编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjFoodSanitationEntity djFoodSanitation, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djFoodSanitation.getId())) {
			djFoodSanitation = djFoodSanitationService.getEntity(DjFoodSanitationEntity.class, djFoodSanitation.getId());
			req.setAttribute("djFoodSanitationPage", djFoodSanitation);
		}
		return new ModelAndView("com/dj/health/food/djFoodSanitation-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djFoodSanitationController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjFoodSanitationEntity djFoodSanitation,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjFoodSanitationEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djFoodSanitation, request.getParameterMap());
		List<DjFoodSanitationEntity> djFoodSanitations = this.djFoodSanitationService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"无证摊位");
		modelMap.put(NormalExcelConstants.CLASS,DjFoodSanitationEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("无证摊位列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djFoodSanitations);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjFoodSanitationEntity djFoodSanitation,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "无证摊位");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjFoodSanitationEntity.class);
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
				List<DjFoodSanitationEntity> listDjFoodSanitationEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjFoodSanitationEntity.class,params);
				for (DjFoodSanitationEntity djFoodSanitation : listDjFoodSanitationEntitys) {
					djFoodSanitationService.save(djFoodSanitation);
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
