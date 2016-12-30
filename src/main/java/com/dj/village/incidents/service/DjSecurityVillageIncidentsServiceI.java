package com.dj.village.incidents.service;
import com.dj.village.incidents.entity.DjSecurityVillageIncidentsEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface DjSecurityVillageIncidentsServiceI extends CommonService{
	
 	public <T> void delete(T entity);
 	
 	public <T> Serializable save(T entity);
 	
 	public <T> void saveOrUpdate(T entity);
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjSecurityVillageIncidentsEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjSecurityVillageIncidentsEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjSecurityVillageIncidentsEntity t);
}
