package com.dj.renthouse.house.controller;
import com.dj.renthouse.house.entity.DjHouseEntity;
import com.dj.renthouse.house.service.DjHouseServiceI;
import com.dj.renthouse.renthouseinfo.entity.DjHouseInfoEntity;
import com.dj.renthouse.renthouseinfo.service.DjHouseInfoServiceI;
import com.dj.util.BeanCopyUtil;
import com.dj.util.ConstantUtil;

import java.util.List;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.context.annotation.Scope;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;

import java.io.IOException;
import java.lang.reflect.Field;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;

import org.jeecgframework.core.util.ExceptionUtil;



/**   
 * @Title: Controller
 * @Description: 房屋登记
 * @author onlineGenerator
 * @date 2015-12-12 22:55:41
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djHouseController")
public class DjHouseController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjHouseController.class);

	@Autowired
	private DjHouseServiceI djHouseService;
	@Autowired
	private DjHouseInfoServiceI djHouseInfoService;
	
	
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
	 * 房屋登记列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djHouse")
	public ModelAndView djHouse(HttpServletRequest request) {
		return new ModelAndView("com/dj/renthouse/house/djHouseList");
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
	public void datagrid(DjHouseEntity djHouse,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjHouseEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djHouse, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djHouseService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除房屋登记
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjHouseEntity djHouse, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djHouse = systemService.getEntity(DjHouseEntity.class, djHouse.getId());
		message = "房屋登记删除成功";
		try{
			
			Criteria criteria_delte = djHouseInfoService.getSession().createCriteria(DjHouseInfoEntity.class);
			
			criteria_delte.add(Restrictions.eq("district", djHouse.getDistrict()));
			criteria_delte.add(Restrictions.eq("town", djHouse.getTown()));
			criteria_delte.add(Restrictions.eq("village", djHouse.getVillage()));
			criteria_delte.add(Restrictions.eq("ridgeNo", djHouse.getRidgeNo()));
			
			List<DjHouseInfoEntity> djHouseInfoEntities =  criteria_delte.list();
			
			for (DjHouseInfoEntity djHouseInfoEntity : djHouseInfoEntities) {
				djHouseInfoService.delete(djHouseInfoEntity);
			}

			djHouseService.delete(djHouse);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋登记删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除房屋登记
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "房屋登记删除成功";
		try{
			for(String id:ids.split(",")){
				DjHouseEntity djHouse = systemService.getEntity(DjHouseEntity.class, 
				Integer.parseInt(id)
				);
				
				
				Criteria criteria_delte = djHouseInfoService.getSession().createCriteria(DjHouseInfoEntity.class);
				
				criteria_delte.add(Restrictions.eq("district", djHouse.getDistrict()));
				criteria_delte.add(Restrictions.eq("town", djHouse.getTown()));
				criteria_delte.add(Restrictions.eq("village", djHouse.getVillage()));
				criteria_delte.add(Restrictions.eq("ridgeNo", djHouse.getRidgeNo()));
				
				List<DjHouseInfoEntity> djHouseInfoEntities =  criteria_delte.list();
				
				for (DjHouseInfoEntity djHouseInfoEntity : djHouseInfoEntities) {
					djHouseInfoService.delete(djHouseInfoEntity);
				}
				
				djHouseService.delete(djHouse);
				
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋登记删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	 
	 
	 public static <S> Criteria criteria_delte_function(Criteria criteria_delte,S s){
		 
		 Field[] sfields = s.getClass().getDeclaredFields();
		 
		 
		 
		 
		 return criteria_delte;
	 }


	/**
	 * 添加房屋登记
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjHouseEntity djHouse, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "房屋登记添加成功";
		try{
			
			
			DjHouseInfoEntity entity = new DjHouseInfoEntity();
			/**
			 * 设置房屋 常住人口房间 101
			 */
			entity.setDistrict(djHouse.getDistrict());
			entity.setTown(djHouse.getTown());
			entity.setVillage(djHouse.getVillage());
			entity.setRidgeNo(djHouse.getRidgeNo());
			entity.setFloorNo("1");
			entity.setRoomNo("101");
			//entity.setIsNull(ConstantUtil.IsYN.YES);
			Criteria criteria=djHouseInfoService.getSession().createCriteria(DjHouseInfoEntity.class);
			criteria.add(Restrictions.eq("district", entity.getDistrict()));
			criteria.add(Restrictions.eq("town", entity.getTown()));
			criteria.add(Restrictions.eq("village", entity.getVillage()));
			criteria.add(Restrictions.eq("ridgeNo", entity.getRidgeNo()));
			criteria.add(Restrictions.eq("floorNo", entity.getFloorNo()));
			criteria.add(Restrictions.eq("roomNo", entity.getRoomNo()));
			List<DjHouseInfoEntity>  djHouseInfoEntities = criteria.list();
			
			//DjHouseInfoEntity djHouseInfoEntity = djHouseInfoEntities.get(0);
			//保存房屋房间信息信息
			if(djHouseInfoEntities.size()==0){
				entity.setName(djHouse.getName());
				entity.setIdType(djHouse.getIdType());
				entity.setIdNum(djHouse.getIdNo());
				entity.setIsNull(ConstantUtil.IsYN.YES);
				djHouseInfoService.save(entity);
			}else{
				message = "[房屋地址重复]房屋登记添加失败";
			}
			
			//保存房间信息
			Criteria criteriahouse=djHouseService.getSession().createCriteria(DjHouseEntity.class);
			criteriahouse.add(Restrictions.eq("district", djHouse.getDistrict()));
			criteriahouse.add(Restrictions.eq("town", djHouse.getTown()));
			criteriahouse.add(Restrictions.eq("village", djHouse.getVillage()));
			criteriahouse.add(Restrictions.eq("ridgeNo", djHouse.getRidgeNo()));
			
			List<DjHouseEntity>  djHouseEntities = criteriahouse.list();
			if(djHouseEntities.size()==0){
				djHouseService.save(djHouse);
			}
			
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋登记添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新房屋登记
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjHouseEntity djHouse, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "房屋登记更新成功";
		DjHouseEntity t = djHouseService.get(DjHouseEntity.class, djHouse.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djHouse, t);
			djHouseService.saveOrUpdate(t);
			
			DjHouseInfoEntity entity = new DjHouseInfoEntity();
			entity.setDistrict(djHouse.getDistrict());
			entity.setTown(djHouse.getTown());
			entity.setVillage(djHouse.getVillage());
			entity.setRidgeNo(djHouse.getRidgeNo());
			entity.setFloorNo("1");
			entity.setRoomNo("101");
			
			Criteria criteria=djHouseInfoService.getSession().createCriteria(DjHouseInfoEntity.class);
			criteria.add(Restrictions.eq("district", entity.getDistrict()));
			criteria.add(Restrictions.eq("town", entity.getTown()));
			criteria.add(Restrictions.eq("village", entity.getVillage()));
			criteria.add(Restrictions.eq("ridgeNo", entity.getRidgeNo()));
			criteria.add(Restrictions.eq("floorNo", entity.getFloorNo()));
			List<DjHouseInfoEntity>  djHouseInfoEntities = criteria.list();
			
			DjHouseInfoEntity djHouseInfoEntity =null ;
			
			if(djHouseInfoEntities.size()>0){
				djHouseInfoEntity=djHouseInfoEntities.get(0);
			}
			
			
			if(djHouseInfoEntity==null){
				entity.setName(djHouse.getName());
				entity.setIdType(djHouse.getIdType());
				entity.setIdNum(djHouse.getIdNo());
				entity.setIsNull(ConstantUtil.IsYN.YES);
				djHouseInfoService.save(entity);
				
			}else{
				djHouseInfoEntity.setName(djHouse.getName());
				djHouseInfoEntity.setIdType(djHouse.getIdType());
				djHouseInfoEntity.setIdNum(djHouse.getIdNo());
				djHouseInfoService.saveOrUpdate(djHouseInfoEntity);
			}
			
			
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "房屋登记更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 房屋登记新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjHouseEntity djHouse, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djHouse.getId())) {
			djHouse = djHouseService.getEntity(DjHouseEntity.class, djHouse.getId());
			req.setAttribute("djHousePage", djHouse);
		}
		return new ModelAndView("com/dj/renthouse/house/djHouse-add");
	}
	

	
	/**
	 * 房屋登记编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjHouseEntity djHouse, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djHouse.getId())) {
			djHouse = djHouseService.getEntity(DjHouseEntity.class, djHouse.getId());
			req.setAttribute("djHousePage", djHouse);
		}
		return new ModelAndView("com/dj/renthouse/house/djHouse-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djHouseController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjHouseEntity djHouse,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjHouseEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djHouse, request.getParameterMap());
		List<DjHouseEntity> djHouses = this.djHouseService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"房屋登记");
		modelMap.put(NormalExcelConstants.CLASS,DjHouseEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("房屋登记列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djHouses);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjHouseEntity djHouse,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "房屋登记");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjHouseEntity.class);
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
				List<DjHouseEntity> listDjHouseEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjHouseEntity.class,params);
				for (DjHouseEntity djHouse : listDjHouseEntitys) {
					djHouseService.save(djHouse);
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
