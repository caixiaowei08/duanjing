package com.dj.member.beforepreparatory.controller;
import com.dj.member.beforepreparatory.entity.BeforeProbationaryMemberEntity;
import com.dj.member.beforepreparatory.service.BeforeProbationaryMemberServiceI;
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
 * @Description: 拟发展党员
 * @author onlineGenerator
 * @date 2015-12-04 18:54:45
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/beforeProbationaryMemberController")
public class BeforeProbationaryMemberController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BeforeProbationaryMemberController.class);

	@Autowired
	private BeforeProbationaryMemberServiceI beforeProbationaryMemberService;
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
	 * 拟发展党员列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "beforeProbationaryMember")
	public ModelAndView beforeProbationaryMember(HttpServletRequest request) {
		return new ModelAndView("com/dj/member/beforepreparatory/beforeProbationaryMemberList");
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
	public void datagrid(BeforeProbationaryMemberEntity beforeProbationaryMember,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		
		beforeProbationaryMember.setMemberType(ConstantUtil.MemberType.BEFOREPRE_MEMBER);
		
		CriteriaQuery cq = new CriteriaQuery(BeforeProbationaryMemberEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, beforeProbationaryMember, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.beforeProbationaryMemberService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除拟发展党员
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BeforeProbationaryMemberEntity beforeProbationaryMember, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		beforeProbationaryMember = systemService.getEntity(BeforeProbationaryMemberEntity.class, beforeProbationaryMember.getId());
		message = "拟发展党员删除成功";
		try{
			beforeProbationaryMemberService.delete(beforeProbationaryMember);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "拟发展党员删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除拟发展党员
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "拟发展党员删除成功";
		try{
			for(String id:ids.split(",")){
				BeforeProbationaryMemberEntity beforeProbationaryMember = systemService.getEntity(BeforeProbationaryMemberEntity.class, 
				Integer.parseInt(id)
				);
				beforeProbationaryMemberService.delete(beforeProbationaryMember);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "拟发展党员删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加拟发展党员
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BeforeProbationaryMemberEntity beforeProbationaryMember, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		beforeProbationaryMember.setMemberType(ConstantUtil.MemberType.BEFOREPRE_MEMBER);
		
		message = "拟发展党员添加成功";
		try{
			beforeProbationaryMemberService.save(beforeProbationaryMember);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "拟发展党员添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新拟发展党员
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BeforeProbationaryMemberEntity beforeProbationaryMember, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "拟发展党员更新成功";
		BeforeProbationaryMemberEntity t = beforeProbationaryMemberService.get(BeforeProbationaryMemberEntity.class, beforeProbationaryMember.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(beforeProbationaryMember, t);
			beforeProbationaryMemberService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "拟发展党员更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 拟发展党员新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BeforeProbationaryMemberEntity beforeProbationaryMember, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(beforeProbationaryMember.getId())) {
			beforeProbationaryMember = beforeProbationaryMemberService.getEntity(BeforeProbationaryMemberEntity.class, beforeProbationaryMember.getId());
			req.setAttribute("beforeProbationaryMemberPage", beforeProbationaryMember);
		}
		return new ModelAndView("com/dj/member/beforepreparatory/beforeProbationaryMember-add");
	}
	/**
	 * 拟发展党员编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BeforeProbationaryMemberEntity beforeProbationaryMember, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(beforeProbationaryMember.getId())) {
			beforeProbationaryMember = beforeProbationaryMemberService.getEntity(BeforeProbationaryMemberEntity.class, beforeProbationaryMember.getId());
			req.setAttribute("beforeProbationaryMemberPage", beforeProbationaryMember);
		}
		return new ModelAndView("com/dj/member/beforepreparatory/beforeProbationaryMember-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","beforeProbationaryMemberController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(BeforeProbationaryMemberEntity beforeProbationaryMember,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(BeforeProbationaryMemberEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, beforeProbationaryMember, request.getParameterMap());
		List<BeforeProbationaryMemberEntity> beforeProbationaryMembers = this.beforeProbationaryMemberService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"拟发展党员");
		modelMap.put(NormalExcelConstants.CLASS,BeforeProbationaryMemberEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("拟发展党员列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,beforeProbationaryMembers);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(BeforeProbationaryMemberEntity beforeProbationaryMember,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "拟发展党员");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,BeforeProbationaryMemberEntity.class);
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
				List<BeforeProbationaryMemberEntity> listBeforeProbationaryMemberEntitys = ExcelImportUtil.importExcel(file.getInputStream(),BeforeProbationaryMemberEntity.class,params);
				for (BeforeProbationaryMemberEntity beforeProbationaryMember : listBeforeProbationaryMemberEntitys) {
					beforeProbationaryMemberService.save(beforeProbationaryMember);
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
