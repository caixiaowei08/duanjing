package com.dj.people.localpeoplel02.service;
import com.dj.people.localpeoplel02.entity.DjPeopleBaseL02Entity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface DjPeopleBaseL02ServiceI extends CommonService{
	
 	public <T> void delete(T entity);
 	
 	public <T> Serializable save(T entity);
 	
 	public <T> void saveOrUpdate(T entity);
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjPeopleBaseL02Entity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjPeopleBaseL02Entity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjPeopleBaseL02Entity t);
}
