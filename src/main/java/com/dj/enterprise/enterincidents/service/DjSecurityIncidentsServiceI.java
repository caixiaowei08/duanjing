package com.dj.enterprise.enterincidents.service;
import com.dj.enterprise.enterincidents.entity.DjSecurityIncidentsEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface DjSecurityIncidentsServiceI extends CommonService{
	
 	public <T> void delete(T entity);
 	
 	public <T> Serializable save(T entity);
 	
 	public <T> void saveOrUpdate(T entity);
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjSecurityIncidentsEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjSecurityIncidentsEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjSecurityIncidentsEntity t);
}
