package com.dj.enterprise.entersecurity.service.impl;
import com.dj.enterprise.entersecurity.service.DjEnterpriseSecurityCheckServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.enterprise.entersecurity.entity.DjEnterpriseSecurityCheckEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djEnterpriseSecurityCheckService")
@Transactional
public class DjEnterpriseSecurityCheckServiceImpl extends CommonServiceImpl implements DjEnterpriseSecurityCheckServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjEnterpriseSecurityCheckEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjEnterpriseSecurityCheckEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjEnterpriseSecurityCheckEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjEnterpriseSecurityCheckEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjEnterpriseSecurityCheckEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjEnterpriseSecurityCheckEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjEnterpriseSecurityCheckEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{enter_time}",String.valueOf(t.getEnterTime()));
 		sql  = sql.replace("#{enter_type}",String.valueOf(t.getEnterType()));
 		sql  = sql.replace("#{enter_check_dept}",String.valueOf(t.getEnterCheckDept()));
 		sql  = sql.replace("#{enter_checked_dept}",String.valueOf(t.getEnterCheckedDept()));
 		sql  = sql.replace("#{enter_checker}",String.valueOf(t.getEnterChecker()));
 		sql  = sql.replace("#{enter_item}",String.valueOf(t.getEnterItem()));
 		sql  = sql.replace("#{enter_status}",String.valueOf(t.getEnterStatus()));
 		sql  = sql.replace("#{enter_remark}",String.valueOf(t.getEnterRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}