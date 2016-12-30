package com.dj.people.school.service;
import com.dj.people.school.entity.SchoolInfoEntity;
import com.dj.people.school.entity.SchoolingChildrenEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface SchoolInfoServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(SchoolInfoEntity schoolInfo,
	        List<SchoolingChildrenEntity> schoolingChildrenList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(SchoolInfoEntity schoolInfo,
	        List<SchoolingChildrenEntity> schoolingChildrenList);
	public void delMain (SchoolInfoEntity schoolInfo);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(SchoolInfoEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(SchoolInfoEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(SchoolInfoEntity t);
}
