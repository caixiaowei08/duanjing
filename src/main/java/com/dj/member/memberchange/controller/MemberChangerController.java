package com.dj.member.memberchange.controller;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.dj.member.memberchange.entity.MemberChangerEntity;
import com.dj.member.memberchange.service.MemberChangerServiceI;
import com.dj.util.ConstantUtil;



/**   
 * @Title: Controller
 * @Description: 党员变动
 * @author onlineGenerator
 * @date 2015-12-04 18:57:33
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/memberChangerController")
public class MemberChangerController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MemberChangerController.class);

	@Autowired
	private MemberChangerServiceI memberChangerService;
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
	 * 党员变动列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "memberChanger")
	public ModelAndView memberChanger(HttpServletRequest request) {
		return new ModelAndView("com/dj/member/memberChange/memberChangerList");
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
	public void datagrid(MemberChangerEntity memberChanger,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		
		memberChanger.setMemberType(ConstantUtil.MemberType.CHANGE_MEMBER);
		
		CriteriaQuery cq = new CriteriaQuery(MemberChangerEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, memberChanger, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.memberChangerService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除党员变动
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(MemberChangerEntity memberChanger, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		memberChanger = systemService.getEntity(MemberChangerEntity.class, memberChanger.getId());
		message = "党员变动删除成功";
		try{
			memberChangerService.delete(memberChanger);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "党员变动删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除党员变动
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "党员变动删除成功";
		try{
			for(String id:ids.split(",")){
				MemberChangerEntity memberChanger = systemService.getEntity(MemberChangerEntity.class, 
				Integer.parseInt(id)
				);
				memberChangerService.delete(memberChanger);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "党员变动删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加党员变动
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(MemberChangerEntity memberChanger, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		memberChanger.setMemberType(ConstantUtil.MemberType.CHANGE_MEMBER);
		message = "党员变动添加成功";
		try{
			memberChangerService.save(memberChanger);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "党员变动添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新党员变动
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(MemberChangerEntity memberChanger, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "党员变动更新成功";
		MemberChangerEntity t = memberChangerService.get(MemberChangerEntity.class, memberChanger.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(memberChanger, t);
			memberChangerService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "党员变动更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 党员变动新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(MemberChangerEntity memberChanger, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(memberChanger.getId())) {
			memberChanger = memberChangerService.getEntity(MemberChangerEntity.class, memberChanger.getId());
			req.setAttribute("memberChangerPage", memberChanger);
		}
		return new ModelAndView("com/dj/member/memberChange/memberChanger-add");
	}
	/**
	 * 党员变动编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(MemberChangerEntity memberChanger, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(memberChanger.getId())) {
			memberChanger = memberChangerService.getEntity(MemberChangerEntity.class, memberChanger.getId());
			req.setAttribute("memberChangerPage", memberChanger);
		}
		return new ModelAndView("com/dj/member/memberChange/memberChanger-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","memberChangerController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(MemberChangerEntity memberChanger,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(MemberChangerEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, memberChanger, request.getParameterMap());
		List<MemberChangerEntity> memberChangers = this.memberChangerService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"党员变动");
		modelMap.put(NormalExcelConstants.CLASS,MemberChangerEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("党员变动列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,memberChangers);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(MemberChangerEntity memberChanger,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "党员变动");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,MemberChangerEntity.class);
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
				List<MemberChangerEntity> listMemberChangerEntitys = ExcelImportUtil.importExcel(file.getInputStream(),MemberChangerEntity.class,params);
				for (MemberChangerEntity memberChanger : listMemberChangerEntitys) {
					memberChangerService.save(memberChanger);
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
