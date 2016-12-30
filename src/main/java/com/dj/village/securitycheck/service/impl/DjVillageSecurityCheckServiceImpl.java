package com.dj.village.securitycheck.service.impl;
import com.dj.village.securitycheck.service.DjVillageSecurityCheckServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.village.securitycheck.entity.DjVillageSecurityCheckEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djVillageSecurityCheckService")
@Transactional
public class DjVillageSecurityCheckServiceImpl extends CommonServiceImpl implements DjVillageSecurityCheckServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjVillageSecurityCheckEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjVillageSecurityCheckEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjVillageSecurityCheckEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjVillageSecurityCheckEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjVillageSecurityCheckEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjVillageSecurityCheckEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjVillageSecurityCheckEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{villa_time}",String.valueOf(t.getVillaTime()));
 		sql  = sql.replace("#{villa_checked_dept}",String.valueOf(t.getVillaCheckedDept()));
 		sql  = sql.replace("#{villa_type}",String.valueOf(t.getVillaType()));
 		sql  = sql.replace("#{villa_item}",String.valueOf(t.getVillaItem()));
 		sql  = sql.replace("#{villa_checker}",String.valueOf(t.getVillaChecker()));
 		sql  = sql.replace("#{villa_status}",String.valueOf(t.getVillaStatus()));
 		sql  = sql.replace("#{villa_remark}",String.valueOf(t.getVillaRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}