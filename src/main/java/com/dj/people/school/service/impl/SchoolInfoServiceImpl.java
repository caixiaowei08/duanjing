package com.dj.people.school.service.impl;
import com.dj.people.school.service.SchoolInfoServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.people.school.entity.SchoolInfoEntity;
import com.dj.people.school.entity.SchoolingChildrenEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import java.util.ArrayList;
import java.util.UUID;
import java.io.Serializable;


@Service("schoolInfoService")
@Transactional
public class SchoolInfoServiceImpl extends CommonServiceImpl implements SchoolInfoServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((SchoolInfoEntity)entity);
 	}
	
	public void addMain(SchoolInfoEntity schoolInfo,
	        List<SchoolingChildrenEntity> schoolingChildrenList){
			//保存主信息
			//this.save(schoolInfo);
		
			/**保存-子女就学*/
			for(SchoolingChildrenEntity schoolingChildren:schoolingChildrenList){
				//外键设置
				//schoolingChildren.setPid(schoolInfo.getId());
				//外键设置
				//schoolingChildren.setGuardianId(schoolInfo.getId());
				this.save(schoolingChildren);
			}
			//执行新增操作配置的sql增强
 			//this.doAddSql(schoolInfo);
	}

	
	public void updateMain(SchoolInfoEntity schoolInfo,
	        List<SchoolingChildrenEntity> schoolingChildrenList) {
		
		this.saveOrUpdate(schoolingChildrenList.get(0));
		//保存主表信息
		//this.saveOrUpdate(schoolInfo);
		//===================================================================================
		//获取参数
		//Object id0 = schoolingChildrenList.get(0).getId();
		//Object id0 = schoolingChildrenList.;
		//===================================================================================
		//1.查询出数据库的明细数据-子女就学
	    //String hql0 = "from SchoolingChildrenEntity where 1 = 1 AND ID = ? ";
	    //List<SchoolingChildrenEntity> schoolingChildrenOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-子女就学
		/*for(SchoolingChildrenEntity oldE:schoolingChildrenOldList){
			//boolean isUpdate = false;
				for(SchoolingChildrenEntity sendE:schoolingChildrenList){
					//需要更新的明细数据-子女就学
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-子女就学
		    		super.delete(oldE);
	    		}
	    		
			}*/
			//3.持久化新增的数据-子女就学
			/*for(SchoolingChildrenEntity schoolingChildren:schoolingChildrenList){
				if(oConvertUtils.isEmpty(schoolingChildren.getId())){
					//外键设置
					schoolingChildren.setPid(schoolInfo.getId());
					schoolingChildren.setGuardianId(schoolInfo.getId());
					this.save(schoolingChildren);
				}
			}*/
		//执行更新操作配置的sql增强
 		/*this.doUpdateSql(schoolInfo);*/
	}

	
	public void delMain(SchoolInfoEntity schoolInfo) {
		//删除主表信息
		//this.delete(schoolInfo);
		//===================================================================================
		//获取参数
		Object id0 = schoolInfo.getId();
		//Object id0 = schoolInfo.getId();
		//===================================================================================
		//删除-子女就学
	    String hql0 = "from SchoolingChildrenEntity where 1 = 1 AND ID = ? ";
	    List<SchoolingChildrenEntity> schoolingChildrenOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(schoolingChildrenOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(SchoolInfoEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(SchoolInfoEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(SchoolInfoEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,SchoolInfoEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{birthdate}",String.valueOf(t.getBirthdate()));
 		sql  = sql.replace("#{peo_type}",String.valueOf(t.getPeoType()));
 		sql  = sql.replace("#{birth_place}",String.valueOf(t.getBirthPlace()));
 		sql  = sql.replace("#{id_type}",String.valueOf(t.getIdType()));
 		sql  = sql.replace("#{id_no}",String.valueOf(t.getIdNo()));
 		sql  = sql.replace("#{used_name}",String.valueOf(t.getUsedName()));
 		sql  = sql.replace("#{nationality}",String.valueOf(t.getNationality()));
 		sql  = sql.replace("#{nation}",String.valueOf(t.getNation()));
 		sql  = sql.replace("#{height}",String.valueOf(t.getHeight()));
 		sql  = sql.replace("#{blood_type}",String.valueOf(t.getBloodType()));
 		sql  = sql.replace("#{degree}",String.valueOf(t.getDegree()));
 		sql  = sql.replace("#{marital_status}",String.valueOf(t.getMaritalStatus()));
 		sql  = sql.replace("#{spouse_name}",String.valueOf(t.getSpouseName()));
 		sql  = sql.replace("#{tel}",String.valueOf(t.getTel()));
 		sql  = sql.replace("#{phone}",String.valueOf(t.getPhone()));
 		sql  = sql.replace("#{work_address}",String.valueOf(t.getWorkAddress()));
 		sql  = sql.replace("#{is_army}",String.valueOf(t.getIsArmy()));
 		sql  = sql.replace("#{army_remark}",String.valueOf(t.getArmyRemark()));
 		sql  = sql.replace("#{permanent_district}",String.valueOf(t.getPermanentDistrict()));
 		sql  = sql.replace("#{permanent_address}",String.valueOf(t.getPermanentAddress()));
 		sql  = sql.replace("#{current_district}",String.valueOf(t.getCurrentDistrict()));
 		sql  = sql.replace("#{current_address}",String.valueOf(t.getCurrentAddress()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}