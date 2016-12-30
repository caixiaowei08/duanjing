package com.dj.police.propaganda.service.impl;
import com.dj.police.propaganda.service.DjPreventionPropagandaServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.police.propaganda.entity.DjPreventionPropagandaEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djPreventionPropagandaService")
@Transactional
public class DjPreventionPropagandaServiceImpl extends CommonServiceImpl implements DjPreventionPropagandaServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjPreventionPropagandaEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjPreventionPropagandaEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjPreventionPropagandaEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjPreventionPropagandaEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjPreventionPropagandaEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjPreventionPropagandaEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjPreventionPropagandaEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{preve_respon_police}",String.valueOf(t.getPreveResponPolice()));
 		sql  = sql.replace("#{preve_time}",String.valueOf(t.getPreveTime()));
 		sql  = sql.replace("#{preve_address}",String.valueOf(t.getPreveAddress()));
 		sql  = sql.replace("#{preve_join_num}",String.valueOf(t.getPreveJoinNum()));
 		sql  = sql.replace("#{preve_start_time}",String.valueOf(t.getPreveStartTime()));
 		sql  = sql.replace("#{preve_end_time}",String.valueOf(t.getPreveEndTime()));
 		sql  = sql.replace("#{preve_detail}",String.valueOf(t.getPreveDetail()));
 		sql  = sql.replace("#{preve_type}",String.valueOf(t.getPreveType()));
 		sql  = sql.replace("#{preve_docu_num}",String.valueOf(t.getPreveDocuNum()));
 		sql  = sql.replace("#{preve_remark}",String.valueOf(t.getPreveRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}