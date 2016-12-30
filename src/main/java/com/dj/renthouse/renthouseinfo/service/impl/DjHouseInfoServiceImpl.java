package com.dj.renthouse.renthouseinfo.service.impl;
import com.dj.renthouse.renthouseinfo.service.DjHouseInfoServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.renthouse.renthouseinfo.entity.DjHouseInfoEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djHouseInfoService")
@Transactional
public class DjHouseInfoServiceImpl extends CommonServiceImpl implements DjHouseInfoServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjHouseInfoEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjHouseInfoEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjHouseInfoEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjHouseInfoEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjHouseInfoEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjHouseInfoEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjHouseInfoEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{id_type}",String.valueOf(t.getIdType()));
 		sql  = sql.replace("#{id_num}",String.valueOf(t.getIdNum()));
 		sql  = sql.replace("#{district}",String.valueOf(t.getDistrict()));
 		sql  = sql.replace("#{town}",String.valueOf(t.getTown()));
 		sql  = sql.replace("#{village}",String.valueOf(t.getVillage()));
 		sql  = sql.replace("#{ridge_no}",String.valueOf(t.getRidgeNo()));
 		sql  = sql.replace("#{room_no}",String.valueOf(t.getRoomNo()));
 		sql  = sql.replace("#{floor_no}",String.valueOf(t.getFloorNo()));
 		sql  = sql.replace("#{is_null}",String.valueOf(t.getIsNull()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}