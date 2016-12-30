package com.dj.police.pnotify.service.impl;
import com.dj.police.pnotify.service.DjPoliceNotifyServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.police.pnotify.entity.DjPoliceNotifyEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djPoliceNotifyService")
@Transactional
public class DjPoliceNotifyServiceImpl extends CommonServiceImpl implements DjPoliceNotifyServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjPoliceNotifyEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjPoliceNotifyEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjPoliceNotifyEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjPoliceNotifyEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjPoliceNotifyEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjPoliceNotifyEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjPoliceNotifyEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{notify_respon_police}",String.valueOf(t.getNotifyResponPolice()));
 		sql  = sql.replace("#{notify_time}",String.valueOf(t.getNotifyTime()));
 		sql  = sql.replace("#{notify_person_num}",String.valueOf(t.getNotifyPersonNum()));
 		sql  = sql.replace("#{notify_address}",String.valueOf(t.getNotifyAddress()));
 		sql  = sql.replace("#{notify_start_time}",String.valueOf(t.getNotifyStartTime()));
 		sql  = sql.replace("#{notify_end_time}",String.valueOf(t.getNotifyEndTime()));
 		sql  = sql.replace("#{notify_detail}",String.valueOf(t.getNotifyDetail()));
 		sql  = sql.replace("#{notify_prevent}",String.valueOf(t.getNotifyPrevent()));
 		sql  = sql.replace("#{notify_remark}",String.valueOf(t.getNotifyRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}