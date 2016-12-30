package com.dj.police.mediation.service.impl;
import com.dj.police.mediation.service.DjMediationPersonServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.police.mediation.entity.DjMediationPersonEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djMediationPersonService")
@Transactional
public class DjMediationPersonServiceImpl extends CommonServiceImpl implements DjMediationPersonServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjMediationPersonEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjMediationPersonEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjMediationPersonEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjMediationPersonEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjMediationPersonEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjMediationPersonEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjMediationPersonEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{media_time}",String.valueOf(t.getMediaTime()));
 		sql  = sql.replace("#{media_first_name}",String.valueOf(t.getMediaFirstName()));
 		sql  = sql.replace("#{media_first_id_type}",String.valueOf(t.getMediaFirstIdType()));
 		sql  = sql.replace("#{media_first_id_no}",String.valueOf(t.getMediaFirstIdNo()));
 		sql  = sql.replace("#{media_first_tel}",String.valueOf(t.getMediaFirstTel()));
 		sql  = sql.replace("#{media_second_name}",String.valueOf(t.getMediaSecondName()));
 		sql  = sql.replace("#{media_second_id_type}",String.valueOf(t.getMediaSecondIdType()));
 		sql  = sql.replace("#{media_second_id_no}",String.valueOf(t.getMediaSecondIdNo()));
 		sql  = sql.replace("#{media_second_tel}",String.valueOf(t.getMediaSecondTel()));
 		sql  = sql.replace("#{media_reason}",String.valueOf(t.getMediaReason()));
 		sql  = sql.replace("#{media_result}",String.valueOf(t.getMediaResult()));
 		sql  = sql.replace("#{media_detail}",String.valueOf(t.getMediaDetail()));
 		sql  = sql.replace("#{media_method}",String.valueOf(t.getMediaMethod()));
 		sql  = sql.replace("#{media_contradiction_type}",String.valueOf(t.getMediaContradictionType()));
 		sql  = sql.replace("#{media_important}",String.valueOf(t.getMediaImportant()));
 		sql  = sql.replace("#{media_measure}",String.valueOf(t.getMediaMeasure()));
 		sql  = sql.replace("#{media_effect}",String.valueOf(t.getMediaEffect()));
 		sql  = sql.replace("#{media_is_report}",String.valueOf(t.getMediaIsReport()));
 		sql  = sql.replace("#{media_remark}",String.valueOf(t.getMediaRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}