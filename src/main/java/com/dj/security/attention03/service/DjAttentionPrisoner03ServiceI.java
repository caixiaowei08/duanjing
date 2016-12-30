package com.dj.security.attention03.service;
import com.dj.security.attention03.entity.DjAttentionPrisoner03Entity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface DjAttentionPrisoner03ServiceI extends CommonService{
	
 	public <T> void delete(T entity);
 	
 	public <T> Serializable save(T entity);
 	
 	public <T> void saveOrUpdate(T entity);
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjAttentionPrisoner03Entity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjAttentionPrisoner03Entity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjAttentionPrisoner03Entity t);
}
