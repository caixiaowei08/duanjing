package com.dj.enterprise.enterincidents.service.impl;
import com.dj.enterprise.enterincidents.service.DjSecurityIncidentsServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.enterprise.enterincidents.entity.DjSecurityIncidentsEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djSecurityIncidentsService")
@Transactional
public class DjSecurityIncidentsServiceImpl extends CommonServiceImpl implements DjSecurityIncidentsServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjSecurityIncidentsEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjSecurityIncidentsEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjSecurityIncidentsEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjSecurityIncidentsEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjSecurityIncidentsEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjSecurityIncidentsEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjSecurityIncidentsEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{incide_time}",String.valueOf(t.getIncideTime()));
 		sql  = sql.replace("#{incide_dept}",String.valueOf(t.getIncideDept()));
 		sql  = sql.replace("#{incide_address}",String.valueOf(t.getIncideAddress()));
 		sql  = sql.replace("#{incide_casualty_num}",String.valueOf(t.getIncideCasualtyNum()));
 		sql  = sql.replace("#{incide_reason}",String.valueOf(t.getIncideReason()));
 		sql  = sql.replace("#{incide_officer}",String.valueOf(t.getIncideOfficer()));
 		sql  = sql.replace("#{incide_check_result}",String.valueOf(t.getIncideCheckResult()));
 		sql  = sql.replace("#{incide_remark}",String.valueOf(t.getIncideRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}