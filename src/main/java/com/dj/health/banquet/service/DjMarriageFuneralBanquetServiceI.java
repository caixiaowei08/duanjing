package com.dj.health.banquet.service;
import com.dj.health.banquet.entity.DjMarriageFuneralBanquetEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface DjMarriageFuneralBanquetServiceI extends CommonService{
	
 	public <T> void delete(T entity);
 	
 	public <T> Serializable save(T entity);
 	
 	public <T> void saveOrUpdate(T entity);
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjMarriageFuneralBanquetEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjMarriageFuneralBanquetEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjMarriageFuneralBanquetEntity t);
}
