package com.dj.people.foreigerpeople.service.impl;
import com.dj.people.foreigerpeople.service.DjPeopleBaseFServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.people.foreigerpeople.entity.DjPeopleBaseFEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djPeopleBaseFService")
@Transactional
public class DjPeopleBaseFServiceImpl extends CommonServiceImpl implements DjPeopleBaseFServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjPeopleBaseFEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjPeopleBaseFEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjPeopleBaseFEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjPeopleBaseFEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjPeopleBaseFEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjPeopleBaseFEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjPeopleBaseFEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{last_ame}",String.valueOf(t.getLastAme()));
 		sql  = sql.replace("#{first_name}",String.valueOf(t.getFirstName()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{birthdate}",String.valueOf(t.getBirthdate()));
 		sql  = sql.replace("#{id_type}",String.valueOf(t.getIdType()));
 		sql  = sql.replace("#{id_no}",String.valueOf(t.getIdNo()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{birth_place}",String.valueOf(t.getBirthPlace()));
 		sql  = sql.replace("#{entry_time}",String.valueOf(t.getEntryTime()));
 		sql  = sql.replace("#{due_time}",String.valueOf(t.getDueTime()));
 		sql  = sql.replace("#{peo_type}",String.valueOf(t.getPeoType()));
 		sql  = sql.replace("#{nationality}",String.valueOf(t.getNationality()));
 		sql  = sql.replace("#{used_name}",String.valueOf(t.getUsedName()));
 		sql  = sql.replace("#{sign}",String.valueOf(t.getSign()));
 		sql  = sql.replace("#{nation}",String.valueOf(t.getNation()));
 		sql  = sql.replace("#{height}",String.valueOf(t.getHeight()));
 		sql  = sql.replace("#{blood_type}",String.valueOf(t.getBloodType()));
 		sql  = sql.replace("#{degree}",String.valueOf(t.getDegree()));
 		sql  = sql.replace("#{marital_status}",String.valueOf(t.getMaritalStatus()));
 		sql  = sql.replace("#{spouse_name}",String.valueOf(t.getSpouseName()));
 		sql  = sql.replace("#{p_house}",String.valueOf(t.getPHouse()));
 		sql  = sql.replace("#{tel}",String.valueOf(t.getTel()));
 		sql  = sql.replace("#{phone}",String.valueOf(t.getPhone()));
 		sql  = sql.replace("#{job}",String.valueOf(t.getJob()));
 		sql  = sql.replace("#{work_address}",String.valueOf(t.getWorkAddress()));
 		sql  = sql.replace("#{is_army}",String.valueOf(t.getIsArmy()));
 		sql  = sql.replace("#{army_remark}",String.valueOf(t.getArmyRemark()));
 		sql  = sql.replace("#{permanent_district}",String.valueOf(t.getPermanentDistrict()));
 		sql  = sql.replace("#{permanent_address}",String.valueOf(t.getPermanentAddress()));
 		sql  = sql.replace("#{district_perm}",String.valueOf(t.getDistrictPerm()));
 		sql  = sql.replace("#{town_perm}",String.valueOf(t.getTownPerm()));
 		sql  = sql.replace("#{village_perm}",String.valueOf(t.getVillagePerm()));
 		sql  = sql.replace("#{room_no_perm}",String.valueOf(t.getRoomNoPerm()));
 		sql  = sql.replace("#{current_district}",String.valueOf(t.getCurrentDistrict()));
 		sql  = sql.replace("#{current_address}",String.valueOf(t.getCurrentAddress()));
 		sql  = sql.replace("#{district_current}",String.valueOf(t.getDistrictCurrent()));
 		sql  = sql.replace("#{town_current}",String.valueOf(t.getTownCurrent()));
 		sql  = sql.replace("#{village_current}",String.valueOf(t.getVillageCurrent()));
 		sql  = sql.replace("#{ridge_no_current}",String.valueOf(t.getRidgeNoCurrent()));
 		sql  = sql.replace("#{floor_no_current}",String.valueOf(t.getFloorNoCurrent()));
 		sql  = sql.replace("#{room_no_current}",String.valueOf(t.getRoomNoCurrent()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}