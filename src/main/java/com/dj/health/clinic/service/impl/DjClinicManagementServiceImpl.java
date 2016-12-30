package com.dj.health.clinic.service.impl;
import com.dj.health.clinic.service.DjClinicManagementServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.health.clinic.entity.DjClinicManagementEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djClinicManagementService")
@Transactional
public class DjClinicManagementServiceImpl extends CommonServiceImpl implements DjClinicManagementServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjClinicManagementEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjClinicManagementEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjClinicManagementEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjClinicManagementEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjClinicManagementEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjClinicManagementEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjClinicManagementEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{clinic_name}",String.valueOf(t.getClinicName()));
 		sql  = sql.replace("#{clinic_officer}",String.valueOf(t.getClinicOfficer()));
 		sql  = sql.replace("#{clinic_dept}",String.valueOf(t.getClinicDept()));
 		sql  = sql.replace("#{clinic_link_man}",String.valueOf(t.getClinicLinkMan()));
 		sql  = sql.replace("#{clinic_link_tel}",String.valueOf(t.getClinicLinkTel()));
 		sql  = sql.replace("#{clinic_remark}",String.valueOf(t.getClinicRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}