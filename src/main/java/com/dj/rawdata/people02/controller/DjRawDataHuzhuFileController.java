package com.dj.rawdata.people02.controller;
import com.dj.rawdata.people02.entity.DjRawDataHuzhuFileEntity;
import com.dj.rawdata.people02.service.DjRawDataHuzhuFileServiceI;
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
 * @Description: 常住人口原始数据
 * @author onlineGenerator
 * @date 2015-12-15 19:46:31
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djRawDataHuzhuFileController")
public class DjRawDataHuzhuFileController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjRawDataHuzhuFileController.class);

	@Autowired
	private DjRawDataHuzhuFileServiceI djRawDataHuzhuFileService;
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
	 * 常住人口原始数据列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djRawDataHuzhuFile")
	public ModelAndView djRawDataHuzhuFile(HttpServletRequest request) {
		return new ModelAndView("com/dj/rawdata/people02/djRawDataHuzhuFileList");
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
	public void datagrid(DjRawDataHuzhuFileEntity djRawDataHuzhuFile,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjRawDataHuzhuFileEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djRawDataHuzhuFile, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djRawDataHuzhuFileService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除常住人口原始数据
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjRawDataHuzhuFileEntity djRawDataHuzhuFile, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djRawDataHuzhuFile = systemService.getEntity(DjRawDataHuzhuFileEntity.class, djRawDataHuzhuFile.getId());
		message = "常住人口原始数据删除成功";
		try{
			djRawDataHuzhuFileService.delete(djRawDataHuzhuFile);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "常住人口原始数据删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除常住人口原始数据
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "常住人口原始数据删除成功";
		try{
			for(String id:ids.split(",")){
				DjRawDataHuzhuFileEntity djRawDataHuzhuFile = systemService.getEntity(DjRawDataHuzhuFileEntity.class, 
				Integer.parseInt(id)
				);
				djRawDataHuzhuFileService.delete(djRawDataHuzhuFile);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "常住人口原始数据删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加常住人口原始数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjRawDataHuzhuFileEntity djRawDataHuzhuFile, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "常住人口原始数据添加成功";
		try{
			djRawDataHuzhuFileService.save(djRawDataHuzhuFile);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "常住人口原始数据添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新常住人口原始数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjRawDataHuzhuFileEntity djRawDataHuzhuFile, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "常住人口原始数据更新成功";
		DjRawDataHuzhuFileEntity t = djRawDataHuzhuFileService.get(DjRawDataHuzhuFileEntity.class, djRawDataHuzhuFile.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djRawDataHuzhuFile, t);
			djRawDataHuzhuFileService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "常住人口原始数据更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 常住人口原始数据新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjRawDataHuzhuFileEntity djRawDataHuzhuFile, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djRawDataHuzhuFile.getId())) {
			djRawDataHuzhuFile = djRawDataHuzhuFileService.getEntity(DjRawDataHuzhuFileEntity.class, djRawDataHuzhuFile.getId());
			req.setAttribute("djRawDataHuzhuFilePage", djRawDataHuzhuFile);
		}
		return new ModelAndView("com/dj/rawdata/people02/djRawDataHuzhuFile-add");
	}
	/**
	 * 常住人口原始数据编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjRawDataHuzhuFileEntity djRawDataHuzhuFile, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djRawDataHuzhuFile.getId())) {
			djRawDataHuzhuFile = djRawDataHuzhuFileService.getEntity(DjRawDataHuzhuFileEntity.class, djRawDataHuzhuFile.getId());
			req.setAttribute("djRawDataHuzhuFilePage", djRawDataHuzhuFile);
		}
		return new ModelAndView("com/dj/rawdata/people02/djRawDataHuzhuFile-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djRawDataHuzhuFileController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjRawDataHuzhuFileEntity djRawDataHuzhuFile,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjRawDataHuzhuFileEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djRawDataHuzhuFile, request.getParameterMap());
		List<DjRawDataHuzhuFileEntity> djRawDataHuzhuFiles = this.djRawDataHuzhuFileService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"常住人口原始数据");
		modelMap.put(NormalExcelConstants.CLASS,DjRawDataHuzhuFileEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("常住人口原始数据列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djRawDataHuzhuFiles);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjRawDataHuzhuFileEntity djRawDataHuzhuFile,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "常住人口原始数据");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjRawDataHuzhuFileEntity.class);
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
				List<DjRawDataHuzhuFileEntity> listDjRawDataHuzhuFileEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjRawDataHuzhuFileEntity.class,params);
				for (DjRawDataHuzhuFileEntity djRawDataHuzhuFile : listDjRawDataHuzhuFileEntitys) {
					djRawDataHuzhuFileService.save(djRawDataHuzhuFile);
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