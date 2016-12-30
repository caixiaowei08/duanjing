package com.dj.member.local.service.impl;
import com.dj.member.local.service.LocalMemberServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.member.local.entity.LocalMemberEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("localMemberService")
@Transactional
public class LocalMemberServiceImpl extends CommonServiceImpl implements LocalMemberServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((LocalMemberEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((LocalMemberEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((LocalMemberEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(LocalMemberEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(LocalMemberEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(LocalMemberEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,LocalMemberEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{pid}",String.valueOf(t.getPid()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{id_type}",String.valueOf(t.getIdType()));
 		sql  = sql.replace("#{id_no}",String.valueOf(t.getIdNo()));
 		sql  = sql.replace("#{permanent_address}",String.valueOf(t.getPermanentAddress()));
 		sql  = sql.replace("#{current_address}",String.valueOf(t.getCurrentAddress()));
 		sql  = sql.replace("#{degree}",String.valueOf(t.getDegree()));
 		sql  = sql.replace("#{work_address}",String.valueOf(t.getWorkAddress()));
 		sql  = sql.replace("#{job}",String.valueOf(t.getJob()));
 		sql  = sql.replace("#{marital_status}",String.valueOf(t.getMaritalStatus()));
 		sql  = sql.replace("#{member_type}",String.valueOf(t.getMemberType()));
 		sql  = sql.replace("#{member_join_partyt_ime}",String.valueOf(t.getMemberJoinPartytIme()));
 		sql  = sql.replace("#{member_dues}",String.valueOf(t.getMemberDues()));
 		sql  = sql.replace("#{member_tel}",String.valueOf(t.getMemberTel()));
 		sql  = sql.replace("#{member_application_date}",String.valueOf(t.getMemberApplicationDate()));
 		sql  = sql.replace("#{member_introducer}",String.valueOf(t.getMemberIntroducer()));
 		sql  = sql.replace("#{member_approver}",String.valueOf(t.getMemberApprover()));
 		sql  = sql.replace("#{member_approve_time}",String.valueOf(t.getMemberApproveTime()));
 		sql  = sql.replace("#{member_preparation}",String.valueOf(t.getMemberPreparation()));
 		sql  = sql.replace("#{member_train}",String.valueOf(t.getMemberTrain()));
 		sql  = sql.replace("#{member_remark}",String.valueOf(t.getMemberRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}