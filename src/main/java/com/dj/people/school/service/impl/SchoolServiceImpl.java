package com.dj.people.school.service.impl;
import com.dj.people.school.service.SchoolServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.people.school.entity.SchoolEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("schoolService")
@Transactional
public class SchoolServiceImpl extends CommonServiceImpl implements SchoolServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((SchoolEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((SchoolEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((SchoolEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(SchoolEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(SchoolEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(SchoolEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,SchoolEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{id_type}",String.valueOf(t.getIdType()));
 		sql  = sql.replace("#{id_no}",String.valueOf(t.getIdNo()));
 		sql  = sql.replace("#{birthdate}",String.valueOf(t.getBirthdate()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{birth_place}",String.valueOf(t.getBirthPlace()));
 		sql  = sql.replace("#{peo_type}",String.valueOf(t.getPeoType()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{search_people}",String.valueOf(t.getSearchPeople()));
 		sql  = sql.replace("#{guardian_id}",String.valueOf(t.getGuardianId()));
 		sql  = sql.replace("#{guardian_id_type}",String.valueOf(t.getGuardianIdType()));
 		sql  = sql.replace("#{guardian_id_no}",String.valueOf(t.getGuardianIdNo()));
 		sql  = sql.replace("#{guardian_name}",String.valueOf(t.getGuardianName()));
 		sql  = sql.replace("#{search_guardian}",String.valueOf(t.getSearchGuardian()));
 		sql  = sql.replace("#{guardian_relationship}",String.valueOf(t.getGuardianRelationship()));
 		sql  = sql.replace("#{entrance_time}",String.valueOf(t.getEntranceTime()));
 		sql  = sql.replace("#{school_name}",String.valueOf(t.getSchoolName()));
 		sql  = sql.replace("#{school_type}",String.valueOf(t.getSchoolType()));
 		sql  = sql.replace("#{school_address}",String.valueOf(t.getSchoolAddress()));
 		sql  = sql.replace("#{school_tel}",String.valueOf(t.getSchoolTel()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}