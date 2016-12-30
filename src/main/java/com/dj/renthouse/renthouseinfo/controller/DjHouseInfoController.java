package com.dj.renthouse.renthouseinfo.controller;
import com.dj.people.peoplebase.entity.DjPeopleBaseEntity;
import com.dj.people.peoplebase.service.DjPeopleBaseServiceI;
import com.dj.renthouse.house.entity.DjHouseEntity;
import com.dj.renthouse.house.service.DjHouseServiceI;
import com.dj.renthouse.renthouseinfo.entity.DjHouseInfoEntity;
import com.dj.renthouse.renthouseinfo.entity.Floor;
import com.dj.renthouse.renthouseinfo.entity.House;
import com.dj.renthouse.renthouseinfo.entity.HouseDetailInfo;
import com.dj.renthouse.renthouseinfo.entity.HouseInfo;
import com.dj.renthouse.renthouseinfo.entity.Room;
import com.dj.renthouse.renthouseinfo.service.DjHouseInfoServiceI;
import com.dj.util.BeanCopyUtil;

import java.util.ArrayList;
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
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

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
import java.net.URLDecoder;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;

import org.jeecgframework.core.util.ExceptionUtil;



/**   
 * @Title: Controller
 * @Description: 出租房信息
 * @author onlineGenerator
 * @date 2015-12-08 15:22:36
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djHouseInfoController")
public class DjHouseInfoController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjHouseInfoController.class);

	@Autowired
	private DjHouseInfoServiceI djHouseInfoService;
	
	@Autowired
	private DjPeopleBaseServiceI djPeopleBaseService;
	
	@Autowired
	private DjHouseServiceI djHouseService;
	
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
	 * 出租房信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djHouseInfo")
	public ModelAndView djHouseInfo(HttpServletRequest request) {
		return new ModelAndView("com/dj/renthouse/renthouseinfo/djHouseInfoList");
	}
	/**
	 * 出租房关联人员信息信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djHouseCorrelationResidentInfo")
	public ModelAndView djHouseCorrelationResidentInfo(HttpServletRequest request) {
		return new ModelAndView("com/dj/renthouse/renthouseinfo/djHouseCorrelationResidentInfo");
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
	public void datagrid(DjHouseInfoEntity djHouseInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjHouseInfoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djHouseInfo, request.getParameterMap());
		//额外增加一个条件 不能查询 101房间 常住人口居住
		cq.add(Restrictions.ne("roomNo","101"));
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djHouseInfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(params = "getHouse")
	public List<DjHouseInfoEntity> getHouseInfoEntity(DjHouseInfoEntity djHouseInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		List<DjHouseInfoEntity> djHouseInfoEntities = this.djHouseInfoService.findListbySql(
				"select distinct(t.ridge_no) as ridgeNo from dj_house_info t where 1=1 and t.DISTRICT='"+djHouseInfo.getDistrict()+
				"' and t.TOWN='"+djHouseInfo.getTown()+"' and t.Village='"+djHouseInfo.getVillage()+"' order by ridge_no"
				);
		return djHouseInfoEntities;
	}
	
	
	@SuppressWarnings({ "unchecked", "unused" })
	@ResponseBody
	@RequestMapping(params = "getHouseDetailInfo")
	public House getHouseDetailInfo(DjHouseInfoEntity djHouseInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		List<String> floor_nums= this.djHouseInfoService.findListbySql(
				"select distinct(t.floor_no) as floorNo from dj_house_info t where 1=1 and t.DISTRICT='"+djHouseInfo.getDistrict()+
				"' and t.TOWN='"+djHouseInfo.getTown()+"' and t.Village='"+djHouseInfo.getVillage()+
				"' and t.ridge_no='"+djHouseInfo.getRidgeNo()+"' order by floorNo desc" 
				);
		House house = new House();
		
		house.setAddress(djHouseInfo.getDistrict()+djHouseInfo.getTown()+djHouseInfo.getVillage()+djHouseInfo.getRidgeNo());
		
		/**
		 * 查询房屋信息
		 */
		Criteria criteriad_djHouseService = djHouseService.getSession().createCriteria(DjHouseEntity.class);
		criteriad_djHouseService.add(Restrictions.eq("district", djHouseInfo.getDistrict()));
		criteriad_djHouseService.add(Restrictions.eq("town", djHouseInfo.getTown()));
		criteriad_djHouseService.add(Restrictions.eq("village", djHouseInfo.getVillage()));
		criteriad_djHouseService.add(Restrictions.eq("ridgeNo", djHouseInfo.getRidgeNo()));
	
		List<DjHouseEntity> djHouseEntities = criteriad_djHouseService.list();
		if(djHouseEntities.size()>0){
			house.setDjHouseEntity(djHouseEntities.get(0));
		}
				
		/**
		 * 查询楼主信息
		 */
		Criteria criteria=djHouseInfoService.getSession().createCriteria(DjHouseInfoEntity.class);
		criteria.add(Restrictions.eq("district", djHouseInfo.getDistrict()));
		criteria.add(Restrictions.eq("town", djHouseInfo.getTown()));
		criteria.add(Restrictions.eq("village", djHouseInfo.getVillage()));
		criteria.add(Restrictions.eq("ridgeNo", djHouseInfo.getRidgeNo()));
		criteria.add(Restrictions.eq("floorNo", "1"));
		criteria.add(Restrictions.eq("roomNo", "101"));
		List<DjHouseInfoEntity> djHouseInfoEntities = criteria.list();
		
		
		
		
		if(djHouseInfoEntities.size()>0){
		    DjHouseInfoEntity djHouseInfo101 = djHouseInfoEntities.get(0);
		    /**
		     * 查询户主信息
		     * 证件类型 证件号码查询 户主 
	        */
		    criteria = djPeopleBaseService.getSession().createCriteria(DjPeopleBaseEntity.class);
		    criteria.add(Restrictions.eq("idType", djHouseInfo101.getIdType()));
		    criteria.add(Restrictions.eq("idNo", djHouseInfo101.getIdNum()));
		    
		    
		    List<DjPeopleBaseEntity> djPeopleBase101s = criteria.list();
		    
		    if(djPeopleBase101s.size()>0){
		    	DjPeopleBaseEntity djPeopleBaseEntity=djPeopleBase101s.get(0);
		    	
		    	djPeopleBaseEntity.setDistrictCurrent(djHouseInfo.getDistrict());
		    	djPeopleBaseEntity.setTownCurrent(djHouseInfo.getTown());
		    	djPeopleBaseEntity.setVillageCurrent(djHouseInfo.getVillage());
		    	djPeopleBaseEntity.setRidgeNoCurrent(djHouseInfo.getRidgeNo());  
		    	
		    	//能查到户主
		    	house.setDjPeopleBaseEntity(djPeopleBaseEntity);
		    }else{
		    	//不能查询到 只能拿 该 楼主的 101 室 户主姓名 证件类型  证件号码 来设定 户主
		    	DjPeopleBaseEntity djPeopleBaseEntity = new DjPeopleBaseEntity();
		    	djPeopleBaseEntity.setDistrictCurrent( djHouseInfo.getDistrict());
		    	djPeopleBaseEntity.setTownCurrent(djHouseInfo.getTown());
		    	djPeopleBaseEntity.setVillageCurrent(djHouseInfo.getVillage());
		    	djPeopleBaseEntity.setRidgeNoCurrent(djHouseInfo.getRidgeNo()); 
		    	
		    	djPeopleBaseEntity.setName(djHouseInfo101.getName());
		    	djPeopleBaseEntity.setIdType(djHouseInfo101.getIdType());
		    	djPeopleBaseEntity.setIdNo(djHouseInfo101.getIdNum());
		    	
		    	house.setDjPeopleBaseEntity(djPeopleBaseEntity);
		    }
		}
		
		/**
		 * 查询该房屋的所有房间
		 */
		Criteria allHouseCri=djHouseInfoService.getSession().createCriteria(DjHouseInfoEntity.class);
		allHouseCri.add(Restrictions.eq("district", djHouseInfo.getDistrict()));
		allHouseCri.add(Restrictions.eq("town", djHouseInfo.getTown()));
		allHouseCri.add(Restrictions.eq("village", djHouseInfo.getVillage()));
		allHouseCri.add(Restrictions.eq("ridgeNo", djHouseInfo.getRidgeNo()));
		allHouseCri.addOrder(Order.asc("roomNo"));
		List<DjHouseInfoEntity> allDjHouse = allHouseCri.list();
		
		
		List<Room> rooms = new ArrayList<Room>();
        
		/**
		 * 查询每个房间的住户
		 */
		for (DjHouseInfoEntity house_room : allDjHouse) {
			Criteria  room_peoples = djPeopleBaseService.getSession().createCriteria(DjPeopleBaseEntity.class);
			room_peoples.add(Restrictions.eq("districtCurrent", house_room.getDistrict()));
			room_peoples.add(Restrictions.eq("townCurrent", house_room.getTown()));
			room_peoples.add(Restrictions.eq("villageCurrent", house_room.getVillage()));
			room_peoples.add(Restrictions.eq("ridgeNoCurrent", house_room.getRidgeNo()));
			room_peoples.add(Restrictions.eq("floorNoCurrent", house_room.getFloorNo()));
			room_peoples.add(Restrictions.eq("roomNoCurrent", house_room.getRoomNo()));
			List<DjPeopleBaseEntity> room_DjPeopleBaseEntities =room_peoples.list();
			Room room = new Room(house_room, room_DjPeopleBaseEntities);
			rooms.add(room);
		}
		
		/**
		 * 分楼层查询 查询楼层房间
		 */
		List<Floor> floors = new ArrayList<Floor>();
		
		for (String floorNo : floor_nums) {
			Floor floor = new  Floor();
			DjHouseInfoEntity djHouseInfoFloor = new DjHouseInfoEntity();
			BeanCopyUtil.copyByDPropertys(djHouseInfo, djHouseInfoFloor);
			djHouseInfoFloor.setFloorNo(floorNo);
			floor.setDjHouseInfoEntity(djHouseInfoFloor);
			floor.setRooms(new ArrayList<Room>());
			floors.add(floor);
		}
		
		for(Room room:rooms){
			String floor_no =room.getDjHouseInfoEntity().getFloorNo();
			for(Floor floor: floors){
				if(floor_no.equals(floor.getDjHouseInfoEntity().getFloorNo())){
					floor.getRooms().add(room);
					 break;
				}
			}
		}
		
		house.setFloors(floors);
		
		return house;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(params = "getFloorNo")
	public List<DjHouseInfoEntity> getFloorNo(DjHouseInfoEntity djHouseInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		List<DjHouseInfoEntity> djHouseInfoEntities = this.djHouseInfoService.findListbySql(
				"select distinct(t.floor_no) as floorNo from dj_house_info t where 1=1 and t.DISTRICT='"+djHouseInfo.getDistrict()+
				"' and t.TOWN='"+djHouseInfo.getTown()+"' and t.Village='"+djHouseInfo.getVillage()+
				"' and t.ridge_no='"+djHouseInfo.getRidgeNo()+"'"
				);
		
		return djHouseInfoEntities;
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(params = "getFloorRoom")
	public List<DjHouseInfoEntity> getFloorRoom(DjHouseInfoEntity djHouseInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		List<DjHouseInfoEntity> djHouseInfoEntities = this.djHouseInfoService.findListbySql(
				"select distinct(t.room_no) as roomNo from dj_house_info t where 1=1 and t.DISTRICT='"+djHouseInfo.getDistrict()+
				"' and t.TOWN='"+djHouseInfo.getTown()+
				"' and t.Village='"+djHouseInfo.getVillage()+
				"' and t.ridge_no='"+djHouseInfo.getRidgeNo()+
				"' and t.floor_no='"+djHouseInfo.getFloorNo()+
				"' and t.room_no !='101'"
				
				);
		
		return djHouseInfoEntities;
	}

	/**
	 * 删除出租房信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjHouseInfoEntity djHouseInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djHouseInfo = systemService.getEntity(DjHouseInfoEntity.class, djHouseInfo.getId());
		message = "出租房信息删除成功";
		try{
			djHouseInfoService.delete(djHouseInfo);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "出租房信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除出租房信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "出租房信息删除成功";
		try{
			for(String id:ids.split(",")){
				DjHouseInfoEntity djHouseInfo = systemService.getEntity(DjHouseInfoEntity.class, 
				Integer.parseInt(id)
				);
				djHouseInfoService.delete(djHouseInfo);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "出租房信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加出租房信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjHouseInfoEntity djHouseInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();	
		
		Criteria criteria=djHouseInfoService.getSession().createCriteria(DjHouseInfoEntity.class);
		criteria.add(Restrictions.eq("district", djHouseInfo.getDistrict()));
		criteria.add(Restrictions.eq("town", djHouseInfo.getTown()));
		criteria.add(Restrictions.eq("village", djHouseInfo.getVillage()));
		criteria.add(Restrictions.eq("ridgeNo", djHouseInfo.getRidgeNo()));
		criteria.add(Restrictions.eq("floorNo", djHouseInfo.getFloorNo()));
		criteria.add(Restrictions.eq("roomNo", djHouseInfo.getRoomNo()));
		List<DjHouseInfoEntity>  djHouseInfoEntities = criteria.list();
		
		if(djHouseInfoEntities.size()>0){
			j.setMsg("出租房信息已存在");
			return j;
		}
		Criteria criteria2=djHouseInfoService.getSession().createCriteria(DjHouseInfoEntity.class);
		criteria2.add(Restrictions.eq("district", djHouseInfo.getDistrict()));
		criteria2.add(Restrictions.eq("town", djHouseInfo.getTown()));
		criteria2.add(Restrictions.eq("village", djHouseInfo.getVillage()));
		criteria2.add(Restrictions.eq("ridgeNo", djHouseInfo.getRidgeNo()));
		criteria2.add(Restrictions.eq("floorNo", "1"));
		criteria2.add(Restrictions.eq("roomNo", "101"));
		djHouseInfoEntities = criteria2.list();
		
		if(djHouseInfoEntities.size()>0){
		    DjHouseInfoEntity djHouseInfoEntity = djHouseInfoEntities.get(0);
		    djHouseInfo.setName(djHouseInfoEntity.getName());
		    djHouseInfo.setIdType(djHouseInfoEntity.getIdType());
		    djHouseInfo.setIdNum(djHouseInfoEntity.getIdNum());
		}
		
		djHouseInfo.setIsNull("Y");
		message = "出租房信息添加成功";
		try{
			djHouseInfoService.save(djHouseInfo);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "出租房信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新出租房信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjHouseInfoEntity djHouseInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "出租房信息更新成功";
		DjHouseInfoEntity t = djHouseInfoService.get(DjHouseInfoEntity.class, djHouseInfo.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djHouseInfo, t);
			djHouseInfoService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "出租房信息更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 出租房信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjHouseInfoEntity djHouseInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djHouseInfo.getId())) {
			djHouseInfo = djHouseInfoService.getEntity(DjHouseInfoEntity.class, djHouseInfo.getId());
			req.setAttribute("djHouseInfoPage", djHouseInfo);
		}
		return new ModelAndView("com/dj/renthouse/renthouseinfo/djHouseInfo-add");
	}
	 
	/**
	 * 出租房信息新增页面跳转  出租房屋功能使用
	 * 
	 * @return
	 */
	
	@RequestMapping(params = "goAddByfloorNo")
	public ModelAndView goAddByfloor(DjHouseInfoEntity djHouseInfo, HttpServletRequest req) {
		try {
			djHouseInfo.setDistrict(URLDecoder.decode(req.getParameter("district"),"UTF-8"));  	
			djHouseInfo.setTown(URLDecoder.decode(req.getParameter("town"),"UTF-8"));  	
			djHouseInfo.setVillage(URLDecoder.decode(req.getParameter("village"),"UTF-8"));  	
			djHouseInfo.setRidgeNo(URLDecoder.decode(req.getParameter("ridgeNo"),"UTF-8"));  	
			djHouseInfo.setFloorNo(URLDecoder.decode(req.getParameter("floorNo"),"UTF-8"));  	
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
		
		req.setAttribute("djHouseInfoPage", djHouseInfo);
		return new ModelAndView("com/dj/renthouse/renthouseinfo/djHouseInfo-add_by_floor");
	}
	
	
	/**
	 * 添加楼层
	 * 
	 * @return
	 */
	
	@RequestMapping(params = "goAddfloor")
	public ModelAndView goAddfloor(DjHouseInfoEntity djHouseInfo, HttpServletRequest req) {
		try {
			djHouseInfo.setDistrict(URLDecoder.decode(req.getParameter("district"),"UTF-8"));  	
			djHouseInfo.setTown(URLDecoder.decode(req.getParameter("town"),"UTF-8"));  	
			djHouseInfo.setVillage(URLDecoder.decode(req.getParameter("village"),"UTF-8"));  	
			djHouseInfo.setRidgeNo(URLDecoder.decode(req.getParameter("ridgeNo"),"UTF-8"));  	
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
		
		req.setAttribute("djHouseInfoPage", djHouseInfo);
		return new ModelAndView("com/dj/renthouse/renthouseinfo/djHouseInfo-add_floor");
	}
	
	
	
	/**
	 * 出租房信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjHouseInfoEntity djHouseInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djHouseInfo.getId())) {
			djHouseInfo = djHouseInfoService.getEntity(DjHouseInfoEntity.class, djHouseInfo.getId());
			req.setAttribute("djHouseInfoPage", djHouseInfo);
		}
		return new ModelAndView("com/dj/renthouse/renthouseinfo/djHouseInfo-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djHouseInfoController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjHouseInfoEntity djHouseInfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjHouseInfoEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djHouseInfo, request.getParameterMap());
		List<DjHouseInfoEntity> djHouseInfos = this.djHouseInfoService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"出租房信息");
		modelMap.put(NormalExcelConstants.CLASS,DjHouseInfoEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("出租房信息列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djHouseInfos);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjHouseInfoEntity djHouseInfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "出租房信息");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjHouseInfoEntity.class);
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
				List<DjHouseInfoEntity> listDjHouseInfoEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjHouseInfoEntity.class,params);
				for (DjHouseInfoEntity djHouseInfo : listDjHouseInfoEntitys) {
					djHouseInfoService.save(djHouseInfo);
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
