package com.dj.security.attention02.service;
import com.dj.security.attention02.entity.DjAttentionPrisoner02Entity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface DjAttentionPrisoner02ServiceI extends CommonService{
	
 	public <T> void delete(T entity);
 	
 	public <T> Serializable save(T entity);
 	
 	public <T> void saveOrUpdate(T entity);
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjAttentionPrisoner02Entity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjAttentionPrisoner02Entity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjAttentionPrisoner02Entity t);
}
