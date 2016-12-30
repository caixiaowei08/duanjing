package com.dj.birth.birthout.service.impl;
import com.dj.birth.birthout.service.DjBirthOutServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.birth.birthout.entity.DjBirthOutEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djBirthOutService")
@Transactional
public class DjBirthOutServiceImpl extends CommonServiceImpl implements DjBirthOutServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjBirthOutEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjBirthOutEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjBirthOutEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjBirthOutEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjBirthOutEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjBirthOutEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjBirthOutEntity t){
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
 		sql  = sql.replace("#{peo_type}",String.valueOf(t.getPeoType()));
 		sql  = sql.replace("#{pid}",String.valueOf(t.getPid()));
 		sql  = sql.replace("#{birthout_is_plan}",String.valueOf(t.getBirthoutIsPlan()));
 		sql  = sql.replace("#{birthout_pregnancy_time}",String.valueOf(t.getBirthoutPregnancyTime()));
 		sql  = sql.replace("#{birthout_hospital_care}",String.valueOf(t.getBirthoutHospitalCare()));
 		sql  = sql.replace("#{birthout_hospital_give}",String.valueOf(t.getBirthoutHospitalGive()));
 		sql  = sql.replace("#{birthout_time}",String.valueOf(t.getBirthoutTime()));
 		sql  = sql.replace("#{birthout_status}",String.valueOf(t.getBirthoutStatus()));
 		sql  = sql.replace("#{birthout_remark}",String.valueOf(t.getBirthoutRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}