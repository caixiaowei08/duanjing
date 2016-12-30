package com.dj.civil.disease.service.impl;
import com.dj.civil.disease.service.DjDiseaseManagementServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.civil.disease.entity.DjDiseaseManagementEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djDiseaseManagementService")
@Transactional
public class DjDiseaseManagementServiceImpl extends CommonServiceImpl implements DjDiseaseManagementServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjDiseaseManagementEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjDiseaseManagementEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjDiseaseManagementEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjDiseaseManagementEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjDiseaseManagementEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjDiseaseManagementEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjDiseaseManagementEntity t){
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
 		sql  = sql.replace("#{disease_type}",String.valueOf(t.getDiseaseType()));
 		sql  = sql.replace("#{disease_name}",String.valueOf(t.getDiseaseName()));
 		sql  = sql.replace("#{disease_time}",String.valueOf(t.getDiseaseTime()));
 		sql  = sql.replace("#{disease_is_infect}",String.valueOf(t.getDiseaseIsInfect()));
 		sql  = sql.replace("#{disease_is_isolation}",String.valueOf(t.getDiseaseIsIsolation()));
 		sql  = sql.replace("#{disease_status}",String.valueOf(t.getDiseaseStatus()));
 		sql  = sql.replace("#{disease_is_nsurance}",String.valueOf(t.getDiseaseIsNsurance()));
 		sql  = sql.replace("#{disease_remark}",String.valueOf(t.getDiseaseRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}