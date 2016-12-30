package com.dj.health.banquet.service.impl;
import com.dj.health.banquet.service.DjMarriageFuneralBanquetServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.dj.health.banquet.entity.DjMarriageFuneralBanquetEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("djMarriageFuneralBanquetService")
@Transactional
public class DjMarriageFuneralBanquetServiceImpl extends CommonServiceImpl implements DjMarriageFuneralBanquetServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DjMarriageFuneralBanquetEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DjMarriageFuneralBanquetEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DjMarriageFuneralBanquetEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DjMarriageFuneralBanquetEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DjMarriageFuneralBanquetEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DjMarriageFuneralBanquetEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DjMarriageFuneralBanquetEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{banquet_type}",String.valueOf(t.getBanquetType()));
 		sql  = sql.replace("#{id_type}",String.valueOf(t.getIdType()));
 		sql  = sql.replace("#{id_no}",String.valueOf(t.getIdNo()));
 		sql  = sql.replace("#{banquet_tel}",String.valueOf(t.getBanquetTel()));
 		sql  = sql.replace("#{banquet_home_address}",String.valueOf(t.getBanquetHomeAddress()));
 		sql  = sql.replace("#{banquet_time}",String.valueOf(t.getBanquetTime()));
 		sql  = sql.replace("#{banquet_item}",String.valueOf(t.getBanquetItem()));
 		sql  = sql.replace("#{banquet_people_num}",String.valueOf(t.getBanquetPeopleNum()));
 		sql  = sql.replace("#{banquet_table_num}",String.valueOf(t.getBanquetTableNum()));
 		sql  = sql.replace("#{banquet_address}",String.valueOf(t.getBanquetAddress()));
 		sql  = sql.replace("#{banquet_remark}",String.valueOf(t.getBanquetRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}