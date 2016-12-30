package com.dj.member.oldMember.controller;
import com.dj.member.oldMember.entity.OldMemberEntity;
import com.dj.member.oldMember.service.OldMemberServiceI;
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
 * @Description: 老龄党员
 * @author onlineGenerator
 * @date 2015-12-04 18:59:43
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/oldMemberController")
public class OldMemberController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OldMemberController.class);

	@Autowired
	private OldMemberServiceI oldMemberService;
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
	 * 老龄党员列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "oldMember")
	public ModelAndView oldMember(HttpServletRequest request) {
		return new ModelAndView("com/dj/member/oldMember/oldMemberList");
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
	public void datagrid(OldMemberEntity oldMember,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		
		oldMember.setMemberType(ConstantUtil.MemberType.OLD_MEMBER);
		
		CriteriaQuery cq = new CriteriaQuery(OldMemberEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, oldMember, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.oldMemberService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除老龄党员
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(OldMemberEntity oldMember, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		oldMember = systemService.getEntity(OldMemberEntity.class, oldMember.getId());
		message = "老龄党员删除成功";
		try{
			oldMemberService.delete(oldMember);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "老龄党员删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除老龄党员
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "老龄党员删除成功";
		try{
			for(String id:ids.split(",")){
				OldMemberEntity oldMember = systemService.getEntity(OldMemberEntity.class, 
				Integer.parseInt(id)
				);
				oldMemberService.delete(oldMember);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "老龄党员删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加老龄党员
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(OldMemberEntity oldMember, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		oldMember.setMemberType(ConstantUtil.MemberType.OLD_MEMBER);
		message = "老龄党员添加成功";
		try{
			oldMemberService.save(oldMember);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "老龄党员添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新老龄党员
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(OldMemberEntity oldMember, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "老龄党员更新成功";
		OldMemberEntity t = oldMemberService.get(OldMemberEntity.class, oldMember.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(oldMember, t);
			oldMemberService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "老龄党员更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 老龄党员新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(OldMemberEntity oldMember, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(oldMember.getId())) {
			oldMember = oldMemberService.getEntity(OldMemberEntity.class, oldMember.getId());
			req.setAttribute("oldMemberPage", oldMember);
		}
		return new ModelAndView("com/dj/member/oldMember/oldMember-add");
	}
	/**
	 * 老龄党员编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(OldMemberEntity oldMember, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(oldMember.getId())) {
			oldMember = oldMemberService.getEntity(OldMemberEntity.class, oldMember.getId());
			req.setAttribute("oldMemberPage", oldMember);
		}
		return new ModelAndView("com/dj/member/oldMember/oldMember-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","oldMemberController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(OldMemberEntity oldMember,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(OldMemberEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, oldMember, request.getParameterMap());
		List<OldMemberEntity> oldMembers = this.oldMemberService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"老龄党员");
		modelMap.put(NormalExcelConstants.CLASS,OldMemberEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("老龄党员列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,oldMembers);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(OldMemberEntity oldMember,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "老龄党员");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,OldMemberEntity.class);
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
				List<OldMemberEntity> listOldMemberEntitys = ExcelImportUtil.importExcel(file.getInputStream(),OldMemberEntity.class,params);
				for (OldMemberEntity oldMember : listOldMemberEntitys) {
					oldMemberService.save(oldMember);
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
