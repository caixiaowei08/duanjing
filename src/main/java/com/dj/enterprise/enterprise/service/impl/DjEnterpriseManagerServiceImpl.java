package com.dj.enterprise.enterprise.service.impl;
import com.dj.enterprise.enterprise.service.DjEnterpriseManagerServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.enterprise.enterprise.entity.DjEnterpriseManagerEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djEnterpriseManagerService")
@Transactional
public class DjEnterpriseManagerServiceImpl extends CommonServiceImpl implements DjEnterpriseManagerServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjEnterpriseManagerEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjEnterpriseManagerEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjEnterpriseManagerEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjEnterpriseManagerEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjEnterpriseManagerEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjEnterpriseManagerEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjEnterpriseManagerEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{enter_name}",String.valueOf(t.getEnterName()));
 		sql  = sql.replace("#{enter_address}",String.valueOf(t.getEnterAddress()));
 		sql  = sql.replace("#{enter_legal_person}",String.valueOf(t.getEnterLegalPerson()));
 		sql  = sql.replace("#{id_type}",String.valueOf(t.getIdType()));
 		sql  = sql.replace("#{id_no}",String.valueOf(t.getIdNo()));
 		sql  = sql.replace("#{enter_legal_tel}",String.valueOf(t.getEnterLegalTel()));
 		sql  = sql.replace("#{enter_routine_name}",String.valueOf(t.getEnterRoutineName()));
 		sql  = sql.replace("#{enter_routine_tel}",String.valueOf(t.getEnterRoutineTel()));
 		sql  = sql.replace("#{enter_is_co_prod}",String.valueOf(t.getEnterIsCoProd()));
 		sql  = sql.replace("#{enter_oper_items}",String.valueOf(t.getEnterOperItems()));
 		sql  = sql.replace("#{enter_number_employee}",String.valueOf(t.getEnterNumberEmployee()));
 		sql  = sql.replace("#{enter_time}",String.valueOf(t.getEnterTime()));
 		sql  = sql.replace("#{enter_deadlline}",String.valueOf(t.getEnterDeadlline()));
 		sql  = sql.replace("#{enter_contract}",String.valueOf(t.getEnterContract()));
 		sql  = sql.replace("#{enter_is_fire}",String.valueOf(t.getEnterIsFire()));
 		sql  = sql.replace("#{enter_remark}",String.valueOf(t.getEnterRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}