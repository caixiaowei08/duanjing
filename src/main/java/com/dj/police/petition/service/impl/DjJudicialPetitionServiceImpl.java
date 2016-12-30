package com.dj.police.petition.service.impl;
import com.dj.police.petition.service.DjJudicialPetitionServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.police.petition.entity.DjJudicialPetitionEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djJudicialPetitionService")
@Transactional
public class DjJudicialPetitionServiceImpl extends CommonServiceImpl implements DjJudicialPetitionServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjJudicialPetitionEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjJudicialPetitionEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjJudicialPetitionEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjJudicialPetitionEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjJudicialPetitionEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjJudicialPetitionEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjJudicialPetitionEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{petition_type}",String.valueOf(t.getPetitionType()));
 		sql  = sql.replace("#{petition_person}",String.valueOf(t.getPetitionPerson()));
 		sql  = sql.replace("#{petition_time}",String.valueOf(t.getPetitionTime()));
 		sql  = sql.replace("#{petition_detail}",String.valueOf(t.getPetitionDetail()));
 		sql  = sql.replace("#{petition_comments}",String.valueOf(t.getPetitionComments()));
 		sql  = sql.replace("#{petition_officer}",String.valueOf(t.getPetitionOfficer()));
 		sql  = sql.replace("#{petition_revisit_days}",String.valueOf(t.getPetitionRevisitDays()));
 		sql  = sql.replace("#{petition_revisit_result}",String.valueOf(t.getPetitionRevisitResult()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}