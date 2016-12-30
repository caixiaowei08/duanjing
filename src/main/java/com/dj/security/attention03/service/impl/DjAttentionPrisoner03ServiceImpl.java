package com.dj.security.attention03.service.impl;
import com.dj.security.attention03.service.DjAttentionPrisoner03ServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.security.attention03.entity.DjAttentionPrisoner03Entity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djAttentionPrisoner03Service")
@Transactional
public class DjAttentionPrisoner03ServiceImpl extends CommonServiceImpl implements DjAttentionPrisoner03ServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjAttentionPrisoner03Entity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjAttentionPrisoner03Entity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjAttentionPrisoner03Entity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjAttentionPrisoner03Entity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjAttentionPrisoner03Entity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjAttentionPrisoner03Entity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjAttentionPrisoner03Entity t){
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
 		sql  = sql.replace("#{marital_status}",String.valueOf(t.getMaritalStatus()));
 		sql  = sql.replace("#{pid}",String.valueOf(t.getPid()));
 		sql  = sql.replace("#{attention_item}",String.valueOf(t.getAttentionItem()));
 		sql  = sql.replace("#{attention_time}",String.valueOf(t.getAttentionTime()));
 		sql  = sql.replace("#{attention_dept}",String.valueOf(t.getAttentionDept()));
 		sql  = sql.replace("#{attention_result}",String.valueOf(t.getAttentionResult()));
 		sql  = sql.replace("#{attention_executed_time}",String.valueOf(t.getAttentionExecutedTime()));
 		sql  = sql.replace("#{attention_address}",String.valueOf(t.getAttentionAddress()));
 		sql  = sql.replace("#{attention_type}",String.valueOf(t.getAttentionType()));
 		sql  = sql.replace("#{attention_imprison_time}",String.valueOf(t.getAttentionImprisonTime()));
 		sql  = sql.replace("#{attention_remark}",String.valueOf(t.getAttentionRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}