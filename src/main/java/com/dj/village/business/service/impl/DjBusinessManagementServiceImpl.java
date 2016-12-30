package com.dj.village.business.service.impl;
import com.dj.village.business.service.DjBusinessManagementServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.village.business.entity.DjBusinessManagementEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djBusinessManagementService")
@Transactional
public class DjBusinessManagementServiceImpl extends CommonServiceImpl implements DjBusinessManagementServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjBusinessManagementEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjBusinessManagementEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjBusinessManagementEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjBusinessManagementEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjBusinessManagementEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjBusinessManagementEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjBusinessManagementEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{business_name}",String.valueOf(t.getBusinessName()));
 		sql  = sql.replace("#{business_dept}",String.valueOf(t.getBusinessDept()));
 		sql  = sql.replace("#{business_time}",String.valueOf(t.getBusinessTime()));
 		sql  = sql.replace("#{business_operator}",String.valueOf(t.getBusinessOperator()));
 		sql  = sql.replace("#{business_host}",String.valueOf(t.getBusinessHost()));
 		sql  = sql.replace("#{business_joiners}",String.valueOf(t.getBusinessJoiners()));
 		sql  = sql.replace("#{business_detail}",String.valueOf(t.getBusinessDetail()));
 		sql  = sql.replace("#{business_remark}",String.valueOf(t.getBusinessRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}