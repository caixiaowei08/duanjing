package com.dj.village.production.service.impl;
import com.dj.village.production.service.DjProductionTeamServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.village.production.entity.DjProductionTeamEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djProductionTeamService")
@Transactional
public class DjProductionTeamServiceImpl extends CommonServiceImpl implements DjProductionTeamServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjProductionTeamEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjProductionTeamEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjProductionTeamEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjProductionTeamEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjProductionTeamEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjProductionTeamEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjProductionTeamEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{produ_team}",String.valueOf(t.getProduTeam()));
 		sql  = sql.replace("#{produ_captain}",String.valueOf(t.getProduCaptain()));
 		sql  = sql.replace("#{produ_local_house}",String.valueOf(t.getProduLocalHouse()));
 		sql  = sql.replace("#{produ_local_no_p}",String.valueOf(t.getProduLocalNoP()));
 		sql  = sql.replace("#{produ_nonlocal_no_p}",String.valueOf(t.getProduNonlocalNoP()));
 		sql  = sql.replace("#{produ_rent_house}",String.valueOf(t.getProduRentHouse()));
 		sql  = sql.replace("#{produ_rent_room}",String.valueOf(t.getProduRentRoom()));
 		sql  = sql.replace("#{produ_plough_area}",String.valueOf(t.getProduPloughArea()));
 		sql  = sql.replace("#{produ_remark}",String.valueOf(t.getProduRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}