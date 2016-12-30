package com.dj.village.building.service.impl;
import com.dj.village.building.service.DjBuildingHousesServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.village.building.entity.DjBuildingHousesEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djBuildingHousesService")
@Transactional
public class DjBuildingHousesServiceImpl extends CommonServiceImpl implements DjBuildingHousesServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjBuildingHousesEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjBuildingHousesEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjBuildingHousesEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjBuildingHousesEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjBuildingHousesEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjBuildingHousesEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjBuildingHousesEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{id_type}",String.valueOf(t.getIdType()));
 		sql  = sql.replace("#{id_no}",String.valueOf(t.getIdNo()));
 		sql  = sql.replace("#{degree}",String.valueOf(t.getDegree()));
 		sql  = sql.replace("#{permanent_address}",String.valueOf(t.getPermanentAddress()));
 		sql  = sql.replace("#{current_address}",String.valueOf(t.getCurrentAddress()));
 		sql  = sql.replace("#{build_appli_items}",String.valueOf(t.getBuildAppliItems()));
 		sql  = sql.replace("#{build_appli_time}",String.valueOf(t.getBuildAppliTime()));
 		sql  = sql.replace("#{build_material}",String.valueOf(t.getBuildMaterial()));
 		sql  = sql.replace("#{build_old_struc}",String.valueOf(t.getBuildOldStruc()));
 		sql  = sql.replace("#{build_old_area}",String.valueOf(t.getBuildOldArea()));
 		sql  = sql.replace("#{build_new_struc}",String.valueOf(t.getBuildNewStruc()));
 		sql  = sql.replace("#{build_now_area}",String.valueOf(t.getBuildNowArea()));
 		sql  = sql.replace("#{build_start_time}",String.valueOf(t.getBuildStartTime()));
 		sql  = sql.replace("#{build_finish_time}",String.valueOf(t.getBuildFinishTime()));
 		sql  = sql.replace("#{build_remark}",String.valueOf(t.getBuildRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}