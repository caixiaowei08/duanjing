package com.dj.member.local.controller;
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

import com.dj.member.local.entity.LocalMemberEntity;
import com.dj.member.local.service.LocalMemberServiceI;
import com.dj.util.ConstantUtil;



/**   
 * @Title: Controller
 * @Description: 户籍党员
 * @author onlineGenerator
 * @date 2015-12-04 17:44:25
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/localMemberController")
public class LocalMemberController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LocalMemberController.class);

	@Autowired
	private LocalMemberServiceI localMemberService;
	
	//@Autowired
	//private DjPeopleBaseServiceI djPeopleBaseService;
	
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
	 * 户籍党员列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "localMember")
	public ModelAndView localMember(HttpServletRequest request) {
		return new ModelAndView("com/dj/member/local/localMemberList");
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
	public void datagrid(LocalMemberEntity localMember,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		
		localMember.setMemberType(ConstantUtil.MemberType.LOCAL_MEMBER);
		
		CriteriaQuery cq = new CriteriaQuery(LocalMemberEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, localMember, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		
		
		this.localMemberService.getDataGridReturn(cq, true);
		
		
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除户籍党员
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(LocalMemberEntity localMember, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		localMember = systemService.getEntity(LocalMemberEntity.class, localMember.getId());
		message = "户籍党员删除成功";
		try{
			localMemberService.delete(localMember);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "户籍党员删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除户籍党员
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "户籍党员删除成功";
		try{
			for(String id:ids.split(",")){
				LocalMemberEntity localMember = systemService.getEntity(LocalMemberEntity.class, 
				Integer.parseInt(id)
				);
				localMemberService.delete(localMember);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "户籍党员删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加户籍党员
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(LocalMemberEntity localMember, HttpServletRequest request) {
		
		AjaxJson j = new AjaxJson();
		
		//DjPeopleBaseEntity djPeopleBaseEntity= djPeopleBaseService.get(DjPeopleBaseEntity.class, localMember.getPid());
		
		//BeanCopyUtil.copyByDPropertys(djPeopleBaseEntity, localMember);
		localMember.setMemberType(ConstantUtil.MemberType.LOCAL_MEMBER);
		message = "户籍党员添加成功";
		try{
			localMemberService.save(localMember);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "户籍党员添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新户籍党员
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(LocalMemberEntity localMember, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "户籍党员更新成功";
		LocalMemberEntity t = localMemberService.get(LocalMemberEntity.class, localMember.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(localMember, t);
			localMemberService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "户籍党员更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 户籍党员新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(LocalMemberEntity localMember, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(localMember.getId())) {
			localMember = localMemberService.getEntity(LocalMemberEntity.class, localMember.getId());
			req.setAttribute("localMemberPage", localMember);
		}
		return new ModelAndView("com/dj/member/local/localMember-add");
	}
	/**
	 * 户籍党员编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(LocalMemberEntity localMember, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(localMember.getId())) {
			localMember = localMemberService.getEntity(LocalMemberEntity.class, localMember.getId());
			req.setAttribute("localMemberPage", localMember);
		}
		return new ModelAndView("com/dj/member/local/localMember-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","localMemberController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(LocalMemberEntity localMember,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(LocalMemberEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, localMember, request.getParameterMap());
		List<LocalMemberEntity> localMembers = this.localMemberService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"户籍党员");
		modelMap.put(NormalExcelConstants.CLASS,LocalMemberEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("户籍党员列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,localMembers);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(LocalMemberEntity localMember,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "户籍党员");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,LocalMemberEntity.class);
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
				List<LocalMemberEntity> listLocalMemberEntitys = ExcelImportUtil.importExcel(file.getInputStream(),LocalMemberEntity.class,params);
				for (LocalMemberEntity localMember : listLocalMemberEntitys) {
					localMemberService.save(localMember);
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
