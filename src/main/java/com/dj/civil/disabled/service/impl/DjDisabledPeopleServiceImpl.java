package com.dj.civil.disabled.service.impl;
import com.dj.civil.disabled.service.DjDisabledPeopleServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.civil.disabled.entity.DjDisabledPeopleEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djDisabledPeopleService")
@Transactional
public class DjDisabledPeopleServiceImpl extends CommonServiceImpl implements DjDisabledPeopleServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjDisabledPeopleEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjDisabledPeopleEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjDisabledPeopleEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjDisabledPeopleEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjDisabledPeopleEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjDisabledPeopleEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjDisabledPeopleEntity t){
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
 		sql  = sql.replace("#{disabled_no}",String.valueOf(t.getDisabledNo()));
 		sql  = sql.replace("#{disabled_status}",String.valueOf(t.getDisabledStatus()));
 		sql  = sql.replace("#{disabled_dept}",String.valueOf(t.getDisabledDept()));
 		sql  = sql.replace("#{disabled_provide_time}",String.valueOf(t.getDisabledProvideTime()));
 		sql  = sql.replace("#{disabled_guardian}",String.valueOf(t.getDisabledGuardian()));
 		sql  = sql.replace("#{disabled_labor}",String.valueOf(t.getDisabledLabor()));
 		sql  = sql.replace("#{disabled_ability}",String.valueOf(t.getDisabledAbility()));
 		sql  = sql.replace("#{disabled_remark}",String.valueOf(t.getDisabledRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}