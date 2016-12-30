package com.dj.police.interview.service.impl;
import com.dj.police.interview.service.DjInterviewResidentServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.police.interview.entity.DjInterviewResidentEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djInterviewResidentService")
@Transactional
public class DjInterviewResidentServiceImpl extends CommonServiceImpl implements DjInterviewResidentServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjInterviewResidentEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjInterviewResidentEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjInterviewResidentEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjInterviewResidentEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjInterviewResidentEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjInterviewResidentEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjInterviewResidentEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{inter_}",String.valueOf(t.getInter()));
 		sql  = sql.replace("#{inter_room}",String.valueOf(t.getInterRoom()));
 		sql  = sql.replace("#{inter_interviewee}",String.valueOf(t.getInterInterviewee()));
 		sql  = sql.replace("#{id_type}",String.valueOf(t.getIdType()));
 		sql  = sql.replace("#{id_no}",String.valueOf(t.getIdNo()));
 		sql  = sql.replace("#{inter_tel}",String.valueOf(t.getInterTel()));
 		sql  = sql.replace("#{inter_start_time}",String.valueOf(t.getInterStartTime()));
 		sql  = sql.replace("#{inter_end_time}",String.valueOf(t.getInterEndTime()));
 		sql  = sql.replace("#{inter_detail}",String.valueOf(t.getInterDetail()));
 		sql  = sql.replace("#{inter_remark}",String.valueOf(t.getInterRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}