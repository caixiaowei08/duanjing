package com.dj.member.nonlocal.service;
import com.dj.member.nonlocal.entity.NonlocalMemberEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface NonlocalMemberServiceI extends CommonService{
	
 	public <T> void delete(T entity);
 	
 	public <T> Serializable save(T entity);
 	
 	public <T> void saveOrUpdate(T entity);
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(NonlocalMemberEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(NonlocalMemberEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(NonlocalMemberEntity t);
}
