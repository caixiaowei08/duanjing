package com.dj.people.localpeoplel01.service;
import com.dj.people.localpeoplel01.entity.DjPeopleBaseL01Entity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface DjPeopleBaseL01ServiceI extends CommonService{
	
 	public <T> void delete(T entity);
 	
 	public <T> Serializable save(T entity);
 	
 	public <T> void saveOrUpdate(T entity);
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjPeopleBaseL01Entity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjPeopleBaseL01Entity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjPeopleBaseL01Entity t);
}
