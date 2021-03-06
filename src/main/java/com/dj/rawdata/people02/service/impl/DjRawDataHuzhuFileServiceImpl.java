package com.dj.rawdata.people02.service.impl;
import com.dj.rawdata.people02.service.DjRawDataHuzhuFileServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.rawdata.people02.entity.DjRawDataHuzhuFileEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djRawDataHuzhuFileService")
@Transactional
public class DjRawDataHuzhuFileServiceImpl extends CommonServiceImpl implements DjRawDataHuzhuFileServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjRawDataHuzhuFileEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjRawDataHuzhuFileEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjRawDataHuzhuFileEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjRawDataHuzhuFileEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjRawDataHuzhuFileEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjRawDataHuzhuFileEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjRawDataHuzhuFileEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{used_name}",String.valueOf(t.getUsedName()));
 		sql  = sql.replace("#{id_no}",String.valueOf(t.getIdNo()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{birthdate}",String.valueOf(t.getBirthdate()));
 		sql  = sql.replace("#{nation}",String.valueOf(t.getNation()));
 		sql  = sql.replace("#{birth_place}",String.valueOf(t.getBirthPlace()));
 		sql  = sql.replace("#{blood_type}",String.valueOf(t.getBloodType()));
 		sql  = sql.replace("#{height}",String.valueOf(t.getHeight()));
 		sql  = sql.replace("#{degree}",String.valueOf(t.getDegree()));
 		sql  = sql.replace("#{marital_status}",String.valueOf(t.getMaritalStatus()));
 		sql  = sql.replace("#{work_address}",String.valueOf(t.getWorkAddress()));
 		sql  = sql.replace("#{spouse_name}",String.valueOf(t.getSpouseName()));
 		sql  = sql.replace("#{aaa}",String.valueOf(t.getAaa()));
 		sql  = sql.replace("#{bbb}",String.valueOf(t.getBbb()));
 		sql  = sql.replace("#{is_army}",String.valueOf(t.getIsArmy()));
 		sql  = sql.replace("#{permanent_district}",String.valueOf(t.getPermanentDistrict()));
 		sql  = sql.replace("#{permanent_address}",String.valueOf(t.getPermanentAddress()));
 		sql  = sql.replace("#{current_district}",String.valueOf(t.getCurrentDistrict()));
 		sql  = sql.replace("#{current_address}",String.valueOf(t.getCurrentAddress()));
 		sql  = sql.replace("#{id_type}",String.valueOf(t.getIdType()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}