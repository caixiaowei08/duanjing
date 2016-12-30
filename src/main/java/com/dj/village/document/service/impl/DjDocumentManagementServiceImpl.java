package com.dj.village.document.service.impl;
import com.dj.village.document.service.DjDocumentManagementServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.village.document.entity.DjDocumentManagementEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djDocumentManagementService")
@Transactional
public class DjDocumentManagementServiceImpl extends CommonServiceImpl implements DjDocumentManagementServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjDocumentManagementEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjDocumentManagementEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjDocumentManagementEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjDocumentManagementEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjDocumentManagementEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjDocumentManagementEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjDocumentManagementEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{document_name}",String.valueOf(t.getDocumentName()));
 		sql  = sql.replace("#{document_dept}",String.valueOf(t.getDocumentDept()));
 		sql  = sql.replace("#{document_time}",String.valueOf(t.getDocumentTime()));
 		sql  = sql.replace("#{document_no}",String.valueOf(t.getDocumentNo()));
 		sql  = sql.replace("#{document_person}",String.valueOf(t.getDocumentPerson()));
 		sql  = sql.replace("#{document_detail}",String.valueOf(t.getDocumentDetail()));
 		sql  = sql.replace("#{document_keeper}",String.valueOf(t.getDocumentKeeper()));
 		sql  = sql.replace("#{document_remark}",String.valueOf(t.getDocumentRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}