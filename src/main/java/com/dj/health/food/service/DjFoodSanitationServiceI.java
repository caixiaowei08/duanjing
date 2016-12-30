package com.dj.health.food.service;
import com.dj.health.food.entity.DjFoodSanitationEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface DjFoodSanitationServiceI extends CommonService{
	
 	public <T> void delete(T entity);
 	
 	public <T> Serializable save(T entity);
 	
 	public <T> void saveOrUpdate(T entity);
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjFoodSanitationEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjFoodSanitationEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjFoodSanitationEntity t);
}
