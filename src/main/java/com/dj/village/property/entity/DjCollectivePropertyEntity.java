package com.dj.village.property.entity;

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
 * @Description: 集体财产管理
 * @author onlineGenerator
 * @date 2015-12-05 13:04:30
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_collective_property", schema = "")
@SuppressWarnings("serial")
public class DjCollectivePropertyEntity implements java.io.Serializable {
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
	/**物品名称*/
	@Excel(name="物品名称")
	private java.lang.String propertyName;
	/**数量*/
	@Excel(name="数量")
	private java.lang.String propertyNum;
	/**价值*/
	@Excel(name="价值")
	private java.lang.String propertyWorth;
	/**使用人*/
	@Excel(name="使用人")
	private java.lang.String propertyUser;
	/**管理方式*/
	@Excel(name="管理方式")
	private java.lang.String propertyManagStyle;
	/**存放情况*/
	@Excel(name="存放情况")
	private java.lang.String propertyStorCondi;
	/**是否报废*/
	@Excel(name="是否报废")
	private java.lang.String propertyIsScrap;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String propertyRemark;
	
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
	 *@return: java.lang.String  物品名称
	 */
	@Column(name ="PROPERTY_NAME",nullable=false,length=32)
	public java.lang.String getPropertyName(){
		return this.propertyName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  物品名称
	 */
	public void setPropertyName(java.lang.String propertyName){
		this.propertyName = propertyName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  数量
	 */
	@Column(name ="PROPERTY_NUM",nullable=true,length=32)
	public java.lang.String getPropertyNum(){
		return this.propertyNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  数量
	 */
	public void setPropertyNum(java.lang.String propertyNum){
		this.propertyNum = propertyNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  价值
	 */
	@Column(name ="PROPERTY_WORTH",nullable=true,length=32)
	public java.lang.String getPropertyWorth(){
		return this.propertyWorth;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  价值
	 */
	public void setPropertyWorth(java.lang.String propertyWorth){
		this.propertyWorth = propertyWorth;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  使用人
	 */
	@Column(name ="PROPERTY_USER",nullable=false,length=32)
	public java.lang.String getPropertyUser(){
		return this.propertyUser;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  使用人
	 */
	public void setPropertyUser(java.lang.String propertyUser){
		this.propertyUser = propertyUser;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  管理方式
	 */
	@Column(name ="PROPERTY_MANAG_STYLE",nullable=true,length=32)
	public java.lang.String getPropertyManagStyle(){
		return this.propertyManagStyle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  管理方式
	 */
	public void setPropertyManagStyle(java.lang.String propertyManagStyle){
		this.propertyManagStyle = propertyManagStyle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  存放情况
	 */
	@Column(name ="PROPERTY_STOR_CONDI",nullable=true,length=32)
	public java.lang.String getPropertyStorCondi(){
		return this.propertyStorCondi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  存放情况
	 */
	public void setPropertyStorCondi(java.lang.String propertyStorCondi){
		this.propertyStorCondi = propertyStorCondi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否报废
	 */
	@Column(name ="PROPERTY_IS_SCRAP",nullable=true,length=32)
	public java.lang.String getPropertyIsScrap(){
		return this.propertyIsScrap;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否报废
	 */
	public void setPropertyIsScrap(java.lang.String propertyIsScrap){
		this.propertyIsScrap = propertyIsScrap;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="PROPERTY_REMARK",nullable=true,length=32)
	public java.lang.String getPropertyRemark(){
		return this.propertyRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setPropertyRemark(java.lang.String propertyRemark){
		this.propertyRemark = propertyRemark;
	}
}
