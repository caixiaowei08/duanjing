package com.dj.civil.preferential.service.impl;
import com.dj.civil.preferential.service.DjPreferentialTreatmentServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.civil.preferential.entity.DjPreferentialTreatmentEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djPreferentialTreatmentService")
@Transactional
public class DjPreferentialTreatmentServiceImpl extends CommonServiceImpl implements DjPreferentialTreatmentServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjPreferentialTreatmentEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjPreferentialTreatmentEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjPreferentialTreatmentEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjPreferentialTreatmentEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjPreferentialTreatmentEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjPreferentialTreatmentEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjPreferentialTreatmentEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{id_type}",String.valueOf(t.getIdType()));
 		sql  = sql.replace("#{id_no}",String.valueOf(t.getIdNo()));
 		sql  = sql.replace("#{degree}",String.valueOf(t.getDegree()));
 		sql  = sql.replace("#{permanent_address}",String.valueOf(t.getPermanentAddress()));
 		sql  = sql.replace("#{current_address}",String.valueOf(t.getCurrentAddress()));
 		sql  = sql.replace("#{prefer_type}",String.valueOf(t.getPreferType()));
 		sql  = sql.replace("#{prefer_time}",String.valueOf(t.getPreferTime()));
 		sql  = sql.replace("#{prefer_money}",String.valueOf(t.getPreferMoney()));
 		sql  = sql.replace("#{prefer_content}",String.valueOf(t.getPreferContent()));
 		sql  = sql.replace("#{prefer_remark}",String.valueOf(t.getPreferRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}