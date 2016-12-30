package com.dj.village.property.service.impl;
import com.dj.village.property.service.DjCollectivePropertyServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.village.property.entity.DjCollectivePropertyEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djCollectivePropertyService")
@Transactional
public class DjCollectivePropertyServiceImpl extends CommonServiceImpl implements DjCollectivePropertyServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjCollectivePropertyEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjCollectivePropertyEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjCollectivePropertyEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjCollectivePropertyEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjCollectivePropertyEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjCollectivePropertyEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjCollectivePropertyEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{property_name}",String.valueOf(t.getPropertyName()));
 		sql  = sql.replace("#{property_num}",String.valueOf(t.getPropertyNum()));
 		sql  = sql.replace("#{property_worth}",String.valueOf(t.getPropertyWorth()));
 		sql  = sql.replace("#{property_user}",String.valueOf(t.getPropertyUser()));
 		sql  = sql.replace("#{property_manag_style}",String.valueOf(t.getPropertyManagStyle()));
 		sql  = sql.replace("#{property_stor_condi}",String.valueOf(t.getPropertyStorCondi()));
 		sql  = sql.replace("#{property_is_scrap}",String.valueOf(t.getPropertyIsScrap()));
 		sql  = sql.replace("#{property_remark}",String.valueOf(t.getPropertyRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}