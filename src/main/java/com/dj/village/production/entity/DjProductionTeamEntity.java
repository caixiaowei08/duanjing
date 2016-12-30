package com.dj.village.production.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 生产队
 * @author onlineGenerator
 * @date 2015-12-05 13:03:58
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_production_team", schema = "")
@SuppressWarnings("serial")
public class DjProductionTeamEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.Integer id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**生产队*/
	@Excel(name="生产队")
	private java.lang.String produTeam;
	/**队长*/
	@Excel(name="队长")
	private java.lang.String produCaptain;
	/**户籍户数*/
	@Excel(name="户籍户数")
	private java.lang.String produLocalHouse;
	/**户籍人数*/
	@Excel(name="户籍人数")
	private java.lang.String produLocalNoP;
	/**来沪人员人数*/
	@Excel(name="来沪人员人数")
	private java.lang.String produNonlocalNoP;
	/**出租户数*/
	@Excel(name="出租户数")
	private java.lang.String produRentHouse;
	/**出租间数*/
	@Excel(name="出租间数")
	private java.lang.String produRentRoom;
	/**耕地面积*/
	@Excel(name="耕地面积")
	private java.lang.String produPloughArea;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String produRemark;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ID",nullable=false,length=20)
	public java.lang.Integer getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  主键
	 */
	public void setId(java.lang.Integer id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */
	@Column(name ="CREATE_BY",nullable=true,length=50)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */
	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */
	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生产队
	 */
	@Column(name ="PRODU_TEAM",nullable=false,length=32)
	public java.lang.String getProduTeam(){
		return this.produTeam;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  生产队
	 */
	public void setProduTeam(java.lang.String produTeam){
		this.produTeam = produTeam;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  队长
	 */
	@Column(name ="PRODU_CAPTAIN",nullable=false,length=32)
	public java.lang.String getProduCaptain(){
		return this.produCaptain;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  队长
	 */
	public void setProduCaptain(java.lang.String produCaptain){
		this.produCaptain = produCaptain;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户籍户数
	 */
	@Column(name ="PRODU_LOCAL_HOUSE",nullable=true,length=32)
	public java.lang.String getProduLocalHouse(){
		return this.produLocalHouse;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户籍户数
	 */
	public void setProduLocalHouse(java.lang.String produLocalHouse){
		this.produLocalHouse = produLocalHouse;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户籍人数
	 */
	@Column(name ="PRODU_LOCAL_NO_P",nullable=true,length=32)
	public java.lang.String getProduLocalNoP(){
		return this.produLocalNoP;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户籍人数
	 */
	public void setProduLocalNoP(java.lang.String produLocalNoP){
		this.produLocalNoP = produLocalNoP;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  来沪人员人数
	 */
	@Column(name ="PRODU_NONLOCAL_NO_P",nullable=true,length=32)
	public java.lang.String getProduNonlocalNoP(){
		return this.produNonlocalNoP;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  来沪人员人数
	 */
	public void setProduNonlocalNoP(java.lang.String produNonlocalNoP){
		this.produNonlocalNoP = produNonlocalNoP;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出租户数
	 */
	@Column(name ="PRODU_RENT_HOUSE",nullable=true,length=32)
	public java.lang.String getProduRentHouse(){
		return this.produRentHouse;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出租户数
	 */
	public void setProduRentHouse(java.lang.String produRentHouse){
		this.produRentHouse = produRentHouse;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出租间数
	 */
	@Column(name ="PRODU_RENT_ROOM",nullable=true,length=32)
	public java.lang.String getProduRentRoom(){
		return this.produRentRoom;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出租间数
	 */
	public void setProduRentRoom(java.lang.String produRentRoom){
		this.produRentRoom = produRentRoom;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  耕地面积
	 */
	@Column(name ="PRODU_PLOUGH_AREA",nullable=true,length=32)
	public java.lang.String getProduPloughArea(){
		return this.produPloughArea;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  耕地面积
	 */
	public void setProduPloughArea(java.lang.String produPloughArea){
		this.produPloughArea = produPloughArea;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="PRODU_REMARK",nullable=true,length=32)
	public java.lang.String getProduRemark(){
		return this.produRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setProduRemark(java.lang.String produRemark){
		this.produRemark = produRemark;
	}
}
