package com.dj.people.school.controller;
import com.dj.people.school.entity.SchoolInfoEntity;
import com.dj.people.school.service.SchoolInfoServiceI;
import com.dj.people.school.page.SchoolInfoPage;
import com.dj.people.school.entity.SchoolingChildrenEntity;

import java.util.List;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.hibernate.qbc.HqlQuery;
import org.jeecgframework.core.common.hibernate.qbc.PageList;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;


/**   
 * @Title: Controller
 * @Description: 子女就学
 * @author onlineGenerator
 * @date 2015-11-25 16:47:39
 * @version V1.0   
 *
 */
@Scope("prototype") 
@Controller
@RequestMapping("/schoolInfoController")
public class SchoolInfoController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SchoolInfoController.class);

	@Autowired
	private SchoolInfoServiceI schoolInfoService;
	@Autowired
	private SystemService systemService;


	/**
	 * 子女就学列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "schoolInfo")
	public ModelAndView schoolInfo(HttpServletRequest request) {
		return new ModelAndView("com/dj/people/school/schoolInfoList");
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
	public void datagrid(SchoolInfoEntity schoolInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(SchoolInfoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, schoolInfo);
		
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		
		
		String sql =
				"SELECT                                           " +
				"dj_people_base.sex,                              " +
				"dj_people_base.birthdate,                        " +
				"dj_people_base.peo_type,                         " +
				"dj_people_base.birth_place,                      " +
				"schooling_children.id,                           " +
				"schooling_children.create_name,                  " +
				"schooling_children.create_by,                    " +
				"schooling_children.create_date,                  " +
				"schooling_children.update_name,                  " +
				"schooling_children.update_by,                    " +
				"schooling_children.update_date,                  " +
				"schooling_children.pid,                          " +
				"schooling_children.id_type,                      " +
				"schooling_children.id_no,                        " +
				"schooling_children.name,                       " +
				"schooling_children.guardian_id_type,             " +
				"schooling_children.guardian_id_no,               " +
				"schooling_children.guardian_id,                  " +
				"schooling_children.guardian_name,                " +
				"schooling_children.guardian_relationship,        " +
				"schooling_children.entrance_time,                " +
				"schooling_children.school_name,                  " +
				"schooling_children.school_type,                  " +
				"schooling_children.school_address,               " +
				"schooling_children.school_tel,                   " +
				"schooling_children.remark                        " +
				"FROM schooling_children left join                " +
				"dj_people_base   on  schooling_children.pid= dj_people_base.id                            " ;
		

		
		
		
				
		//this.schoolInfoService.getDataGridReturn(cq, true);
		HqlQuery hqlQuery = new HqlQuery(sql ,null, null);
		
		@SuppressWarnings("unused")
		PageList pageList= this.schoolInfoService.getPageListBySql(hqlQuery, true);
		
		
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除子女就学
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(SchoolInfoEntity schoolInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		schoolInfo = systemService.getEntity(SchoolInfoEntity.class, schoolInfo.getId());
		String message = "子女就学删除成功";
		try{
			schoolInfoService.delMain(schoolInfo);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "子女就学删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除子女就学
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "子女就学删除成功";
		try{
			for(String id:ids.split(",")){
				SchoolInfoEntity schoolInfo = systemService.getEntity(SchoolInfoEntity.class,
				Integer.parseInt(id)
				);
				schoolInfoService.delMain(schoolInfo);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "子女就学删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加子女就学
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(SchoolInfoEntity schoolInfo,SchoolInfoPage schoolInfoPage, HttpServletRequest request) {
		List<SchoolingChildrenEntity> schoolingChildrenList =  schoolInfoPage.getSchoolingChildrenList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			schoolInfoService.addMain(schoolInfo, schoolingChildrenList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "子女就学添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新子女就学
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(SchoolInfoEntity schoolInfo,SchoolInfoPage schoolInfoPage, HttpServletRequest request) {
		List<SchoolingChildrenEntity> schoolingChildrenList =  schoolInfoPage.getSchoolingChildrenList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			schoolInfoService.updateMain(schoolInfo, schoolingChildrenList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新子女就学失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 子女就学新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(SchoolInfoEntity schoolInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(schoolInfo.getId())) {
			schoolInfo = schoolInfoService.getEntity(SchoolInfoEntity.class, schoolInfo.getId());
			req.setAttribute("schoolInfoPage", schoolInfo);
		}
		return new ModelAndView("com/dj/people/school/schoolInfo-add");
	}
	
	/**
	 * 子女就学编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(SchoolInfoEntity schoolInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(schoolInfo.getId())) {
			schoolInfo = schoolInfoService.getEntity(SchoolInfoEntity.class, schoolInfo.getId());
			req.setAttribute("schoolInfoPage", schoolInfo);
		}
		return new ModelAndView("com/dj/people/school/schoolInfo-update");
	}
	
	
	/**
	 * 加载明细列表[子女就学]
	 * 
	 * @return
	 */
	@RequestMapping(params = "schoolingChildrenList")
	public ModelAndView schoolingChildrenList(SchoolInfoEntity schoolInfo, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = schoolInfo.getId();
		//===================================================================================
		//查询-子女就学
	    String hql0 = "from SchoolingChildrenEntity where 1 = 1 AND pID = ?  AND gUARDIAN_ID = ? ";
	    try{
	    	List<SchoolingChildrenEntity> schoolingChildrenEntityList = systemService.findHql(hql0,id0,id0);
			req.setAttribute("schoolingChildrenList", schoolingChildrenEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/dj/people/school/schoolingChildrenList");
	}
	
}
