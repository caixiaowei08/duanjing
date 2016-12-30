package com.dj.security.attention01.service;
import com.dj.security.attention01.entity.DjAttentionPrisoner01Entity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface DjAttentionPrisoner01ServiceI extends CommonService{
	
 	public <T> void delete(T entity);
 	
 	public <T> Serializable save(T entity);
 	
 	public <T> void saveOrUpdate(T entity);
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjAttentionPrisoner01Entity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjAttentionPrisoner01Entity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjAttentionPrisoner01Entity t);
}
