package com.dj.rawdata.people01.controller;
import com.dj.people.localpeoplel01.entity.DjPeopleBaseL01Entity;
import com.dj.people.localpeoplel01.service.DjPeopleBaseL01ServiceI;
import com.dj.people.localpeoplel02.entity.DjPeopleBaseL02Entity;
import com.dj.people.localpeoplel02.service.DjPeopleBaseL02ServiceI;
import com.dj.people.nolocalpeople.entity.DjPeopleBaseNLEntity;
import com.dj.people.nolocalpeople.service.DjPeopleBaseNLServiceI;
import com.dj.rawdata.people01.entity.DjRawDataFilePeopleEntity;
import com.dj.rawdata.people01.service.DjRawDataFilePeopleServiceI;
import com.dj.rawdata.people02.entity.DjRawDataHuzhuFileEntity;
import com.dj.rawdata.people02.service.DjRawDataHuzhuFileServiceI;
import com.dj.renthouse.house.entity.DjHouseEntity;
import com.dj.renthouse.house.service.DjHouseServiceI;
import com.dj.renthouse.renthouseinfo.entity.DjHouseInfoEntity;
import com.dj.renthouse.renthouseinfo.entity.HouseInfo;
import com.dj.renthouse.renthouseinfo.service.DjHouseInfoServiceI;
import com.dj.util.ConstantUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.text.ParseException;
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
import org.h2.command.ddl.CreateAggregate;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
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

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;

import org.jeecgframework.core.util.ExceptionUtil;



/**   
 * @Title: Controller
 * @Description: 外来人口原始数据
 * @author onlineGenerator
 * @date 2015-12-15 19:46:15
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/djRawDataFilePeopleController")
public class DjRawDataFilePeopleController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DjRawDataFilePeopleController.class);

	@Autowired
	private DjRawDataFilePeopleServiceI djRawDataFilePeopleService;
	
	@Autowired
	private DjRawDataHuzhuFileServiceI djRawDataHuzhuFileService;
	
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private DjHouseServiceI djHouseService;
	@Autowired
	private DjHouseInfoServiceI djHouseInfoService;
	
	@Autowired
	private DjPeopleBaseL02ServiceI djPeopleBaseL02Service;
	
	@Autowired
	private DjPeopleBaseNLServiceI djPeopleBaseNLService;
	

	@Autowired
	private DjPeopleBaseL01ServiceI djPeopleBaseL01Service;
	
	/**
	 * 添加外来人口原始数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DjRawDataFilePeopleEntity djRawDataFilePeople, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		
		
	/*	message = "外来人口原始数据添加成功";
		Criteria criteriaQuery_nolocal= this.djRawDataFilePeopleService.getSession().createCriteria(DjRawDataFilePeopleEntity.class);
		criteriaQuery_nolocal.addOrder(Order.asc("id"));
		List<DjRawDataFilePeopleEntity> djRawDataFilePeopleEntities=criteriaQuery_nolocal.list();
		
		for (DjRawDataFilePeopleEntity djRawDataFilePeopleEntity : djRawDataFilePeopleEntities) {
			DjPeopleBaseNLEntity baseNLEntity = new DjPeopleBaseNLEntity();
			
			baseNLEntityTransform(djRawDataFilePeopleEntity,baseNLEntity);
			
			
		}
	 
		Criteria criteriaQuery_house= this.djRawDataHuzhuFileService.getSession().createCriteria(DjRawDataHuzhuFileEntity.class);
		criteriaQuery_house.addOrder(Order.asc("permanentAddress"));
		
		List<DjRawDataHuzhuFileEntity> dataHuzhuFileEntities = criteriaQuery_house.list();
		
		//按照门牌号码 将人员信息 存入一个map中
		Map<String ,List<DjRawDataHuzhuFileEntity>> map = new HashMap<String, List<DjRawDataHuzhuFileEntity>>();
		
		for (DjRawDataHuzhuFileEntity djRawDataHuzhuFileEntity : dataHuzhuFileEntities) {
			
			String key=djRawDataHuzhuFileEntity.getPermanentAddress();
			
			List<DjRawDataHuzhuFileEntity> dataHuzhuFileEntities2 = map.get(key);
			
			if(dataHuzhuFileEntities2==null){
				dataHuzhuFileEntities2 = new ArrayList<DjRawDataHuzhuFileEntity>();
				map.put(key, dataHuzhuFileEntities2);
			}
			dataHuzhuFileEntities2.add(djRawDataHuzhuFileEntity);
		}
		
		Set<String>  keys = map.keySet();
		
		for (String string : keys) {
			
			List<DjRawDataHuzhuFileEntity> list_peoples_in_one_house = map.get(string);
			
			//系统自动选择户主  首先选择家庭中 第一个出现的男性 若没有 男性 那就选择 第一个女性
			//默认户主
			DjRawDataHuzhuFileEntity dataHuzhuFileEntity_01 = list_peoples_in_one_house.get(0);
			 
			DjHouseEntity djHouseEntity = new DjHouseEntity();
			djHouseEntity.setName(dataHuzhuFileEntity_01.getName());
			djHouseEntity.setIdType("01");//身份证 01
			djHouseEntity.setIdNo(dataHuzhuFileEntity_01.getIdNo());
			
			djHouseEntity.setDistrict("上海市宝山区");
			djHouseEntity.setTown("月浦镇段泾村");
			*//**
			 * 月浦镇段泾村段泾桥宅66号
			 * 月浦镇段泾村支家楼宅16号
			 * 月浦镇段泾村西北宅32号
			 * 月浦镇段泾村泗塘宅17号
			 * 月浦镇段泾村陆家宅40号
			 *//*
			int i0 = string.indexOf("宅");
			djHouseEntity.setVillage(string.substring(6,i0+1));
			djHouseEntity.setRidgeNo(string.substring(i0+1));
			//户主尽量选定男性
			for(DjRawDataHuzhuFileEntity people:list_peoples_in_one_house){
				if(people.getSex().equals("男性")){
					djHouseEntity.setIdNo(people.getIdNo());
					djHouseEntity.setName(people.getName());
					break;
				}
			}
			//保存 房屋信息
			this.djHouseService.save(djHouseEntity);
			
			*//**
			 * 设置房屋 常住人口房间 101
			 *//*
			DjHouseInfoEntity HouseInfo = new DjHouseInfoEntity();
			HouseInfo.setName(djHouseEntity.getName());
			HouseInfo.setIdType(djHouseEntity.getIdType());
			HouseInfo.setIdNum(djHouseEntity.getIdNo());
			HouseInfo.setDistrict(djHouseEntity.getDistrict());
			HouseInfo.setTown(djHouseEntity.getTown());
			HouseInfo.setVillage(djHouseEntity.getVillage());
			HouseInfo.setRidgeNo(djHouseEntity.getRidgeNo());
			HouseInfo.setFloorNo("1");
			HouseInfo.setRoomNo("101");
			HouseInfo.setIsNull(ConstantUtil.IsYN.YES);
		
			 this.djHouseInfoService.save(HouseInfo);
			
			for(DjRawDataHuzhuFileEntity people:list_peoples_in_one_house){
				
				if(StringUtils.hasText(people.getCurrentAddress())){
					//户在人不在
					DjPeopleBaseL02Entity baseL02Entity = new DjPeopleBaseL02Entity();
					baseL02EntityTransform(people,baseL02Entity,HouseInfo);
					this.djPeopleBaseL02Service.save(baseL02Entity);
					
				}else{
					//户籍人口
					DjPeopleBaseL01Entity baseL01Entity = new DjPeopleBaseL01Entity();
					baseL01EntityTransform(people,baseL01Entity,HouseInfo);
					this.djPeopleBaseL01Service.save(baseL01Entity);
				}
			}
		}*/
		
		j.setMsg(message);
		return j;
	}
	
	
	
	/**
	 * 添加外来人口原始数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson dodel(DjRawDataFilePeopleEntity djRawDataFilePeople, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
	/*	
		
		message = "外来人口原始数据添加成功";
		Criteria criteriaQuery_nolocal= this.djRawDataFilePeopleService.getSession().createCriteria(DjRawDataFilePeopleEntity.class);
		criteriaQuery_nolocal.addOrder(Order.asc("id"));
		List<DjRawDataFilePeopleEntity> djRawDataFilePeopleEntities=criteriaQuery_nolocal.list();
		
		//按照房间 将人员信息 存入一个map中
		Map<String ,List<DjRawDataFilePeopleEntity>> map = new HashMap<String, List<DjRawDataFilePeopleEntity>>();
		
		for (DjRawDataFilePeopleEntity djRawDataFilePeopleEntity : djRawDataFilePeopleEntities) {
			
			String key=djRawDataFilePeopleEntity.getCurrentAddress();
			
			List<DjRawDataFilePeopleEntity> dataFilePeopleEntities = map.get(key);
			
			if(dataFilePeopleEntities==null){
				dataFilePeopleEntities = new ArrayList<DjRawDataFilePeopleEntity>();
				map.put(key, dataFilePeopleEntities);
			}
			dataFilePeopleEntities.add(djRawDataFilePeopleEntity);
		}
		
		//遍历房间keys 补充完整房间 和 缺失的 房子
		Set<String> sets = map.keySet();
		for(String str0:sets){
			
			int i0 = str0.indexOf("宅");
			int i1 = str0.indexOf("号");
			int i2 = str0.indexOf("室");

			String village = str0.substring(6,i0+1);
			String ridgeNo = str0.substring(i0+1,i1+1);
			String roomNo ="";
			if(i2>0){
				roomNo = str0.substring(i1+1,i2);
			}
			
			
			
			Criteria criteria_get = djHouseInfoService.getSession().createCriteria(DjHouseEntity.class);
			criteria_get.add(Restrictions.eq("district", "上海市宝山区"));
			criteria_get.add(Restrictions.eq("town", "月浦镇段泾村"));
			criteria_get.add(Restrictions.eq("village", village));
			criteria_get.add(Restrictions.eq("ridgeNo", ridgeNo));
			List<DjHouseEntity> djHouseEntities =  criteria_get.list();
			
			if(djHouseEntities.size()==0){
				DjHouseEntity djHouseEntity = new DjHouseEntity();
				djHouseEntity.setName("");
				djHouseEntity.setIdType("");//身份证 01
				djHouseEntity.setIdNo("");
				djHouseEntity.setDistrict("上海市宝山区");
				djHouseEntity.setTown("月浦镇段泾村");
				djHouseEntity.setVillage(village);
				djHouseEntity.setRidgeNo(ridgeNo);
				
				//保存 房屋信息
				this.djHouseService.save(djHouseEntity);
				*//**
				 * 设置房屋 常住人口房间 101 
				 * *//*
				DjHouseInfoEntity HouseInfo = new DjHouseInfoEntity();
				HouseInfo.setName(djHouseEntity.getName());
				HouseInfo.setIdType(djHouseEntity.getIdType());
				HouseInfo.setIdNum(djHouseEntity.getIdNo());
				HouseInfo.setDistrict(djHouseEntity.getDistrict());
				HouseInfo.setTown(djHouseEntity.getTown());
				HouseInfo.setVillage(djHouseEntity.getVillage());
				HouseInfo.setRidgeNo(djHouseEntity.getRidgeNo());
				HouseInfo.setFloorNo("1");
				HouseInfo.setRoomNo("101");
				HouseInfo.setIsNull(ConstantUtil.IsYN.YES);
				this.djHouseInfoService.save(HouseInfo);
			}
			
			if(djHouseEntities.size()>0){
				
				DjHouseEntity djHouseEntity = djHouseEntities.get(0);
				
				DjHouseInfoEntity HouseInfo = new DjHouseInfoEntity();
				HouseInfo.setName(djHouseEntity.getName());
				HouseInfo.setIdType(djHouseEntity.getIdType());
				HouseInfo.setIdNum(djHouseEntity.getIdNo());
				HouseInfo.setDistrict(djHouseEntity.getDistrict());
				HouseInfo.setTown(djHouseEntity.getTown());
				HouseInfo.setVillage(djHouseEntity.getVillage());
				HouseInfo.setRidgeNo(djHouseEntity.getRidgeNo());
				
				if(StringUtils.hasText(roomNo)){
				HouseInfo.setFloorNo(roomNo.substring(0, 1));
			   }
				
				
				if(roomNo.equals("101")){
				   HouseInfo.setRoomNo(roomNo+"_1");
				}else{
				   HouseInfo.setRoomNo(roomNo);
				}
				
				
				HouseInfo.setIsNull(ConstantUtil.IsYN.NO);
				if(StringUtils.hasText(roomNo)){
					this.djHouseInfoService.save(HouseInfo);
				}
			}else{
              //  DjHouseEntity djHouseEntity = djHouseEntities.get(0);
				DjHouseInfoEntity HouseInfo = new DjHouseInfoEntity();
				HouseInfo.setName("");
				HouseInfo.setIdType("");
				HouseInfo.setIdNum("");
				HouseInfo.setDistrict("上海市宝山区");
				HouseInfo.setTown("月浦镇段泾村");
				HouseInfo.setVillage(village);
				HouseInfo.setRidgeNo(ridgeNo);
				if(StringUtils.hasText(roomNo)){
					HouseInfo.setFloorNo(roomNo.substring(0, 1));
				}
					
				if(roomNo.equals("101")){
					   HouseInfo.setRoomNo(roomNo+"_1");
					}else{
					   HouseInfo.setRoomNo(roomNo);
					}
				HouseInfo.setIsNull(ConstantUtil.IsYN.NO);
				if(StringUtils.hasText(roomNo)){
					this.djHouseInfoService.save(HouseInfo);
				}
			}
			
			//保存
			
			List<DjRawDataFilePeopleEntity> dataFilePeopleEntities = map.get(str0);
			
			for (DjRawDataFilePeopleEntity djRawDataFilePeopleEntity : dataFilePeopleEntities) {
				DjPeopleBaseNLEntity baseNLEntity = new DjPeopleBaseNLEntity();
				
				baseNLEntityTransform(djRawDataFilePeopleEntity, baseNLEntity);
				baseNLEntity.setDistrictCurrent("上海市宝山区");
				baseNLEntity.setTownCurrent("月浦镇段泾村");
				baseNLEntity.setVillageCurrent(village);
				baseNLEntity.setRidgeNoCurrent(ridgeNo);
				
				//baseNLEntity.setFloorNoCurrent(roomNo.substring(0, 1));
				if(StringUtils.hasText(roomNo)){
					
					
					baseNLEntity.setFloorNoCurrent(roomNo.substring(0, 1));
				}
				
				if(roomNo.equals("101")){
					baseNLEntity.setRoomNoCurrent(roomNo+"_1");
					}else{
						baseNLEntity.setRoomNoCurrent(roomNo);
					}
				
				this.djPeopleBaseNLService.save(baseNLEntity);
				
			}
			
		}*/
		
		j.setMsg(message);
		return j;
	}
	
	private void baseNLEntityTransform(
			DjRawDataFilePeopleEntity djRawDataFilePeopleEntity,
			DjPeopleBaseNLEntity baseNLEntity) {
		baseNLEntity.setName(djRawDataFilePeopleEntity.getName());
		try {
			baseNLEntity.setBirthdate(dateFormat.parse(djRawDataFilePeopleEntity.getBirthdate()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			
			logger.error("时间解析异常:"+djRawDataFilePeopleEntity.getBirthdate());
			e.printStackTrace();
		}
		baseNLEntity.setIdType("01");
		baseNLEntity.setIdNo(djRawDataFilePeopleEntity.getIdNo());
		baseNLEntity.setSex(djRawDataFilePeopleEntity.getSex().equals("男性")?"0":"1");
		baseNLEntity.setBirthPlace(djRawDataFilePeopleEntity.getBirthPlace());
		baseNLEntity.setPeoType("n");
		baseNLEntity.setUsedName(djRawDataFilePeopleEntity.getUsedName());
		baseNLEntity.setSign(" ");
		baseNLEntity.setNation(djRawDataFilePeopleEntity.getNation());
		baseNLEntity.setHeight(djRawDataFilePeopleEntity.getHeight());
		/**
		 * 血型判断
		 */
		
		 if(djRawDataFilePeopleEntity.getBloodType().equals("A型")){
			 baseNLEntity.setBloodType("A");
		 }else if(djRawDataFilePeopleEntity.getBloodType().equals("B型")){
			 baseNLEntity.setBloodType("B");
		 }else if(djRawDataFilePeopleEntity.getBloodType().equals("AB型")){
			 baseNLEntity.setBloodType("AB");
		 }else if(djRawDataFilePeopleEntity.getBloodType().equals("O型")){
			 baseNLEntity.setBloodType("O");
		 }else{
			 baseNLEntity.setBloodType("ot");//其他
		 }
		
		 //学历
		 if(djRawDataFilePeopleEntity.getDegree().contains("小学")){
			 baseNLEntity.setDegree("p");
		 }else if(djRawDataFilePeopleEntity.getDegree().contains("初中")){
			 baseNLEntity.setDegree("j");
		 }else if(djRawDataFilePeopleEntity.getDegree().contains("高中")){
			 baseNLEntity.setDegree("s");
		 }else if(djRawDataFilePeopleEntity.getDegree().contains("中专")
				 ||djRawDataFilePeopleEntity.getDegree().contains("中等专业")
				    ||djRawDataFilePeopleEntity.getDegree().contains("职校")
				      ||djRawDataFilePeopleEntity.getDegree().contains("大学专科")
				         ||djRawDataFilePeopleEntity.getDegree().contains("技工学校")){
			 baseNLEntity.setDegree("z");//其他
		 }else if(djRawDataFilePeopleEntity.getDegree().contains("大学")){
			 baseNLEntity.setDegree("b");
		 }else{
			 baseNLEntity.setDegree("u");//其他
		 }
		 
		 if(djRawDataFilePeopleEntity.getMaritalStatus().equals("已婚")){
			 baseNLEntity.setMaritalStatus("m");
		 }else if(djRawDataFilePeopleEntity.getMaritalStatus().equals("离婚")){
			 baseNLEntity.setMaritalStatus("d");
		 }else if(djRawDataFilePeopleEntity.getMaritalStatus().equals("丧偶")){
			 baseNLEntity.setMaritalStatus("l");
		 }else if(djRawDataFilePeopleEntity.getMaritalStatus().equals("未婚")){
			 baseNLEntity.setMaritalStatus("s");
		 }else{
			 baseNLEntity.setMaritalStatus("u");//其他
		 }
		
	
		 baseNLEntity.setSpouseName(djRawDataFilePeopleEntity.getSpouseName());
		 //baseNLEntity.setPHouse();
		 baseNLEntity.setTel(" ");
		 baseNLEntity.setPhone(" ");
		 baseNLEntity.setJob(" ");
		 baseNLEntity.setWorkAddress(djRawDataFilePeopleEntity.getWorkAddress());
		
	
		baseNLEntity.setIsArmy(" ");
	
		baseNLEntity.setArmyRemark(" ");
		baseNLEntity.setPermanentDistrict(djRawDataFilePeopleEntity.getPermanentDistrict());
		baseNLEntity.setPermanentAddress(djRawDataFilePeopleEntity.getPermanentAddress());
		
	}

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
	
	private void baseL01EntityTransform(DjRawDataHuzhuFileEntity people,
			DjPeopleBaseL01Entity baseL01Entity, DjHouseInfoEntity houseInfo) {
		// TODO Auto-generated method stub
		baseL01Entity.setName(people.getName());
		try {
			baseL01Entity.setBirthdate(dateFormat.parse(people.getBirthdate()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			
			logger.error("时间解析异常:"+people.getBirthdate());
			e.printStackTrace();
		}
		baseL01Entity.setIdType("01");
		baseL01Entity.setIdNo(people.getIdNo());
		baseL01Entity.setSex(people.getSex().equals("男性")?"0":"1");
		baseL01Entity.setBirthPlace(people.getBirthPlace());
		baseL01Entity.setPeoType("l");
		baseL01Entity.setUsedName(people.getUsedName());
		baseL01Entity.setSign(" ");
		baseL01Entity.setNation(people.getNation());
		baseL01Entity.setHeight(people.getHeight());
		/**
		 * 血型判断
		 */
		
		 if(people.getBloodType().equals("A型")){
			 baseL01Entity.setBloodType("A");
		 }else if(people.getBloodType().equals("B型")){
			 baseL01Entity.setBloodType("B");
		 }else if(people.getBloodType().equals("AB型")){
			 baseL01Entity.setBloodType("AB");
		 }else if(people.getBloodType().equals("O型")){
			 baseL01Entity.setBloodType("O");
		 }else{
			 baseL01Entity.setBloodType("ot");//其他
		 }
		
		 //学历
		 if(people.getDegree().contains("小学")){
			 baseL01Entity.setDegree("p");
		 }else if(people.getDegree().contains("初中")){
			 baseL01Entity.setDegree("j");
		 }else if(people.getDegree().contains("高中")){
			 baseL01Entity.setDegree("s");
		 }else if(people.getDegree().contains("中专")
				 ||people.getDegree().contains("中等专业")
				    ||people.getDegree().contains("职校")
				      ||people.getDegree().contains("大学专科")
				         ||people.getDegree().contains("技工学校")){
			 baseL01Entity.setDegree("z");//其他
		 }else if(people.getDegree().contains("大学")){
			 baseL01Entity.setDegree("b");
		 }else{
			 baseL01Entity.setDegree("u");//其他
		 }
		 
		 if(people.getMaritalStatus().equals("已婚")){
			 baseL01Entity.setMaritalStatus("m");
		 }else if(people.getMaritalStatus().equals("离婚")){
			 baseL01Entity.setMaritalStatus("d");
		 }else if(people.getMaritalStatus().equals("丧偶")){
			 baseL01Entity.setMaritalStatus("l");
		 }else if(people.getMaritalStatus().equals("未婚")){
			 baseL01Entity.setMaritalStatus("s");
		 }else{
			 baseL01Entity.setMaritalStatus("u");//其他
		 }
		
	
		baseL01Entity.setSpouseName(people.getSpouseName());
		baseL01Entity.setPHouse("01");
		baseL01Entity.setTel(" ");
		baseL01Entity.setPhone(" ");
		baseL01Entity.setJob(" ");
		baseL01Entity.setWorkAddress(people.getWorkAddress());
		
		if(people.getIsArmy().equals("未服兵役")){
			baseL01Entity.setIsArmy("no");
		}else if(people.getIsArmy().equals("退出现役")){
			baseL01Entity.setIsArmy("ye");
		}else if(people.getIsArmy().equals("士兵预备役")){
			baseL01Entity.setIsArmy("cu");
		}else{
			baseL01Entity.setIsArmy("no");
		}
		baseL01Entity.setArmyRemark(" ");
		baseL01Entity.setDistrictPerm(houseInfo.getDistrict());
		baseL01Entity.setTownPerm(houseInfo.getTown());
		baseL01Entity.setVillagePerm(houseInfo.getVillage());
		baseL01Entity.setRoomNoPerm(houseInfo.getRidgeNo());
		baseL01Entity.setDistrictCurrent(houseInfo.getDistrict());
		baseL01Entity.setTownCurrent(houseInfo.getTown());
		baseL01Entity.setVillageCurrent(houseInfo.getVillage());
		baseL01Entity.setRidgeNoCurrent(houseInfo.getRidgeNo());
		baseL01Entity.setFloorNoCurrent(houseInfo.getFloorNo());
		baseL01Entity.setRoomNoCurrent(houseInfo.getRoomNo());
		
	}

	private void baseL02EntityTransform(DjRawDataHuzhuFileEntity people,
			DjPeopleBaseL02Entity baseL02Entity, DjHouseInfoEntity houseInfo) {
		       baseL02Entity.setName(people.getName());
				try {
					baseL02Entity.setBirthdate(dateFormat.parse(people.getBirthdate()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					
					logger.error("时间解析异常:"+people.getBirthdate());
					e.printStackTrace();
				}
				baseL02Entity.setIdType("01");
				baseL02Entity.setIdNo(people.getIdNo());
				baseL02Entity.setSex(people.getSex().equals("男性")?"0":"1");
				baseL02Entity.setBirthPlace(people.getBirthPlace());
				baseL02Entity.setPeoType("l");
				baseL02Entity.setUsedName(people.getUsedName());
				baseL02Entity.setSign(" ");
				baseL02Entity.setNation(people.getNation());
				baseL02Entity.setHeight(people.getHeight());
				/**
				 * 血型判断
				 */
				
				 if(people.getBloodType().equals("A型")){
					 baseL02Entity.setBloodType("A");
				 }else if(people.getBloodType().equals("B型")){
					 baseL02Entity.setBloodType("B");
				 }else if(people.getBloodType().equals("AB型")){
					 baseL02Entity.setBloodType("AB");
				 }else if(people.getBloodType().equals("O型")){
					 baseL02Entity.setBloodType("O");
				 }else{
					 baseL02Entity.setBloodType("ot");//其他
				 }
				
				 //学历
				 if(people.getDegree().contains("小学")){
					 baseL02Entity.setDegree("p");
				 }else if(people.getDegree().contains("初中")){
					 baseL02Entity.setDegree("j");
				 }else if(people.getDegree().contains("高中")){
					 baseL02Entity.setDegree("s");
				 }else if(people.getDegree().contains("中专")
						 ||people.getDegree().contains("中等专业")
						    ||people.getDegree().contains("职校")
						      ||people.getDegree().contains("大学专科")
						         ||people.getDegree().contains("技工学校")){
					 baseL02Entity.setDegree("z");//其他
				 }else if(people.getDegree().contains("大学")){
					 baseL02Entity.setDegree("b");
				 }else{
					 baseL02Entity.setDegree("u");//其他
				 }
				 
				 if(people.getMaritalStatus().equals("已婚")){
					 baseL02Entity.setMaritalStatus("m");
				 }else if(people.getMaritalStatus().equals("离婚")){
					 baseL02Entity.setMaritalStatus("d");
				 }else if(people.getMaritalStatus().equals("丧偶")){
					 baseL02Entity.setMaritalStatus("l");
				 }else if(people.getMaritalStatus().equals("未婚")){
					 baseL02Entity.setMaritalStatus("s");
				 }else{
					 baseL02Entity.setMaritalStatus("u");//其他
				 }
				
			
				 baseL02Entity.setSpouseName(people.getSpouseName());
				 baseL02Entity.setPHouse("02");
				 baseL02Entity.setTel(" ");
				 baseL02Entity.setPhone(" ");
				 baseL02Entity.setJob(" ");
				 baseL02Entity.setWorkAddress(people.getWorkAddress());
				
				if(people.getIsArmy().equals("未服兵役")){
					baseL02Entity.setIsArmy("no");
				}else if(people.getIsArmy().equals("退出现役")){
					baseL02Entity.setIsArmy("ye");
				}else if(people.getIsArmy().equals("士兵预备役")){
					baseL02Entity.setIsArmy("cu");
				}else{
					baseL02Entity.setIsArmy("no");
				}
				baseL02Entity.setArmyRemark(" ");
				baseL02Entity.setDistrictPerm(houseInfo.getDistrict());
				baseL02Entity.setTownPerm(houseInfo.getTown());
				baseL02Entity.setVillagePerm(houseInfo.getVillage());
				baseL02Entity.setRoomNoPerm(houseInfo.getRidgeNo());
/*				baseL02Entity.setDistrictCurrent(houseInfo.getDistrict());
				baseL02Entity.setTownCurrent(houseInfo.getTown());
				baseL02Entity.setVillageCurrent(houseInfo.getVillage());
				baseL02Entity.setRidgeNoCurrent(houseInfo.getRoomNo());
				baseL02Entity.setFloorNoCurrent(houseInfo.getFloorNo());
				baseL02Entity.setRoomNoCurrent(houseInfo.getRoomNo());*/
				baseL02Entity.setCurrentDistrict(people.getCurrentDistrict());
				baseL02Entity.setCurrentAddress(people.getCurrentAddress());
		
	}









	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 外来人口原始数据列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "djRawDataFilePeople")
	public ModelAndView djRawDataFilePeople(HttpServletRequest request) {
		return new ModelAndView("com/dj/rawdata/people01/djRawDataFilePeopleList");
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
	public void datagrid(DjRawDataFilePeopleEntity djRawDataFilePeople,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DjRawDataFilePeopleEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djRawDataFilePeople, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.djRawDataFilePeopleService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除外来人口原始数据
	 * 
	 * @return
	 */
	/*@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DjRawDataFilePeopleEntity djRawDataFilePeople, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		djRawDataFilePeople = systemService.getEntity(DjRawDataFilePeopleEntity.class, djRawDataFilePeople.getId());
		message = "外来人口原始数据删除成功";
		try{
			djRawDataFilePeopleService.delete(djRawDataFilePeople);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "外来人口原始数据删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	*/
	/**
	 * 批量删除外来人口原始数据
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "外来人口原始数据删除成功";
		try{
			for(String id:ids.split(",")){
				DjRawDataFilePeopleEntity djRawDataFilePeople = systemService.getEntity(DjRawDataFilePeopleEntity.class, 
				Integer.parseInt(id)
				);
				djRawDataFilePeopleService.delete(djRawDataFilePeople);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "外来人口原始数据删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	
	
	/**
	 * 更新外来人口原始数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DjRawDataFilePeopleEntity djRawDataFilePeople, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "外来人口原始数据更新成功";
		DjRawDataFilePeopleEntity t = djRawDataFilePeopleService.get(DjRawDataFilePeopleEntity.class, djRawDataFilePeople.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(djRawDataFilePeople, t);
			djRawDataFilePeopleService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "外来人口原始数据更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 外来人口原始数据新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DjRawDataFilePeopleEntity djRawDataFilePeople, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djRawDataFilePeople.getId())) {
			djRawDataFilePeople = djRawDataFilePeopleService.getEntity(DjRawDataFilePeopleEntity.class, djRawDataFilePeople.getId());
			req.setAttribute("djRawDataFilePeoplePage", djRawDataFilePeople);
		}
		return new ModelAndView("com/dj/rawdata/people01/djRawDataFilePeople-add");
	}
	/**
	 * 外来人口原始数据编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DjRawDataFilePeopleEntity djRawDataFilePeople, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(djRawDataFilePeople.getId())) {
			djRawDataFilePeople = djRawDataFilePeopleService.getEntity(DjRawDataFilePeopleEntity.class, djRawDataFilePeople.getId());
			req.setAttribute("djRawDataFilePeoplePage", djRawDataFilePeople);
		}
		return new ModelAndView("com/dj/rawdata/people01/djRawDataFilePeople-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","djRawDataFilePeopleController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DjRawDataFilePeopleEntity djRawDataFilePeople,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DjRawDataFilePeopleEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, djRawDataFilePeople, request.getParameterMap());
		List<DjRawDataFilePeopleEntity> djRawDataFilePeoples = this.djRawDataFilePeopleService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"外来人口原始数据");
		modelMap.put(NormalExcelConstants.CLASS,DjRawDataFilePeopleEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("外来人口原始数据列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,djRawDataFilePeoples);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DjRawDataFilePeopleEntity djRawDataFilePeople,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "外来人口原始数据");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,DjRawDataFilePeopleEntity.class);
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
				List<DjRawDataFilePeopleEntity> listDjRawDataFilePeopleEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DjRawDataFilePeopleEntity.class,params);
				for (DjRawDataFilePeopleEntity djRawDataFilePeople : listDjRawDataFilePeopleEntitys) {
					djRawDataFilePeopleService.save(djRawDataFilePeople);
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
