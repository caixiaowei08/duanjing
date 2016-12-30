package com.dj.health.food.entity;

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
 * @Description: 无证摊位
 * @author onlineGenerator
 * @date 2015-12-06 23:05:02
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_food_sanitation", schema = "")
@SuppressWarnings("serial")
public class DjFoodSanitationEntity implements java.io.Serializable {
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
	/**姓名*/
	@Excel(name="姓名")
	private java.lang.String name;
	/**性别*/
	@Excel(name="性别")
	private java.lang.String sex;
	/**证件类型*/
	@Excel(name="证件类型")
	private java.lang.String idType;
	/**证件号码*/
	@Excel(name="证件号码")
	private java.lang.String idNo;
	/**联系电话*/
	@Excel(name="联系电话")
	private java.lang.String foodTel;
	/**经营项目*/
	@Excel(name="经营项目")
	private java.lang.String foodItem;
	/**经营地点*/
	@Excel(name="经营地点")
	private java.lang.String foodAddress;
	/**是否有证*/
	@Excel(name="是否有证")
	private java.lang.String foodIsCertificate;
	/**是否取缔*/
	@Excel(name="是否取缔")
	private java.lang.String foodIsProhibit;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String foodRemark;
	
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
	 *@return: java.lang.String  姓名
	 */
	@Column(name ="NAME",nullable=false,length=32)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
	@Column(name ="SEX",nullable=false,length=32)
	public java.lang.String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(java.lang.String sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件类型
	 */
	@Column(name ="ID_TYPE",nullable=false,length=32)
	public java.lang.String getIdType(){
		return this.idType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件类型
	 */
	public void setIdType(java.lang.String idType){
		this.idType = idType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件号码
	 */
	@Column(name ="ID_NO",nullable=false,length=32)
	public java.lang.String getIdNo(){
		return this.idNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件号码
	 */
	public void setIdNo(java.lang.String idNo){
		this.idNo = idNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */
	@Column(name ="FOOD_TEL",nullable=true,length=32)
	public java.lang.String getFoodTel(){
		return this.foodTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setFoodTel(java.lang.String foodTel){
		this.foodTel = foodTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  经营项目
	 */
	@Column(name ="FOOD_ITEM",nullable=true,length=32)
	public java.lang.String getFoodItem(){
		return this.foodItem;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  经营项目
	 */
	public void setFoodItem(java.lang.String foodItem){
		this.foodItem = foodItem;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  经营地点
	 */
	@Column(name ="FOOD_ADDRESS",nullable=true,length=32)
	public java.lang.String getFoodAddress(){
		return this.foodAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  经营地点
	 */
	public void setFoodAddress(java.lang.String foodAddress){
		this.foodAddress = foodAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否有证
	 */
	@Column(name ="FOOD_IS_CERTIFICATE",nullable=true,length=32)
	public java.lang.String getFoodIsCertificate(){
		return this.foodIsCertificate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否有证
	 */
	public void setFoodIsCertificate(java.lang.String foodIsCertificate){
		this.foodIsCertificate = foodIsCertificate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否取缔
	 */
	@Column(name ="FOOD_IS_PROHIBIT",nullable=true,length=32)
	public java.lang.String getFoodIsProhibit(){
		return this.foodIsProhibit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否取缔
	 */
	public void setFoodIsProhibit(java.lang.String foodIsProhibit){
		this.foodIsProhibit = foodIsProhibit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="FOOD_REMARK",nullable=true,length=32)
	public java.lang.String getFoodRemark(){
		return this.foodRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setFoodRemark(java.lang.String foodRemark){
		this.foodRemark = foodRemark;
	}
}
