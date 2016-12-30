package com.dj.health.banquet.entity;

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
 * @Description: 婚丧宴席申报
 * @author onlineGenerator
 * @date 2015-12-06 23:05:14
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_marriage_funeral_banquet", schema = "")
@SuppressWarnings("serial")
public class DjMarriageFuneralBanquetEntity implements java.io.Serializable {
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
	/**申报人*/
	@Excel(name="申报人")
	private java.lang.String name;
	/**宴席类别*/
	@Excel(name="宴席类别")
	private java.lang.String banquetType;
	/**证件类型*/
	@Excel(name="证件类型")
	private java.lang.String idType;
	/**证件号码*/
	@Excel(name="证件号码")
	private java.lang.String idNo;
	/**联系电话*/
	@Excel(name="联系电话")
	private java.lang.String banquetTel;
	/**住址*/
	@Excel(name="住址")
	private java.lang.String banquetHomeAddress;
	/**申报时间*/
	@Excel(name="申报时间")
	private java.util.Date banquetTime;
	/**申报项目*/
	@Excel(name="申报项目")
	private java.lang.String banquetItem;
	/**人数*/
	@Excel(name="人数")
	private java.lang.String banquetPeopleNum;
	/**桌数*/
	@Excel(name="桌数")
	private java.lang.String banquetTableNum;
	/**申办地名称*/
	@Excel(name="申办地名称")
	private java.lang.String banquetAddress;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String banquetRemark;
	
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
	 *@return: java.lang.String  申报人
	 */
	@Column(name ="NAME",nullable=false,length=32)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申报人
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  宴席类别
	 */
	@Column(name ="BANQUET_TYPE",nullable=false,length=32)
	public java.lang.String getBanquetType(){
		return this.banquetType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  宴席类别
	 */
	public void setBanquetType(java.lang.String banquetType){
		this.banquetType = banquetType;
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
	@Column(name ="BANQUET_TEL",nullable=false,length=32)
	public java.lang.String getBanquetTel(){
		return this.banquetTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setBanquetTel(java.lang.String banquetTel){
		this.banquetTel = banquetTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  住址
	 */
	@Column(name ="BANQUET_HOME_ADDRESS",nullable=true,length=32)
	public java.lang.String getBanquetHomeAddress(){
		return this.banquetHomeAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  住址
	 */
	public void setBanquetHomeAddress(java.lang.String banquetHomeAddress){
		this.banquetHomeAddress = banquetHomeAddress;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  申报时间
	 */
	@Column(name ="BANQUET_TIME",nullable=false,length=32)
	public java.util.Date getBanquetTime(){
		return this.banquetTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  申报时间
	 */
	public void setBanquetTime(java.util.Date banquetTime){
		this.banquetTime = banquetTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申报项目
	 */
	@Column(name ="BANQUET_ITEM",nullable=true,length=32)
	public java.lang.String getBanquetItem(){
		return this.banquetItem;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申报项目
	 */
	public void setBanquetItem(java.lang.String banquetItem){
		this.banquetItem = banquetItem;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  人数
	 */
	@Column(name ="BANQUET_PEOPLE_NUM",nullable=true,length=32)
	public java.lang.String getBanquetPeopleNum(){
		return this.banquetPeopleNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人数
	 */
	public void setBanquetPeopleNum(java.lang.String banquetPeopleNum){
		this.banquetPeopleNum = banquetPeopleNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  桌数
	 */
	@Column(name ="BANQUET_TABLE_NUM",nullable=true,length=32)
	public java.lang.String getBanquetTableNum(){
		return this.banquetTableNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  桌数
	 */
	public void setBanquetTableNum(java.lang.String banquetTableNum){
		this.banquetTableNum = banquetTableNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申办地名称
	 */
	@Column(name ="BANQUET_ADDRESS",nullable=true,length=32)
	public java.lang.String getBanquetAddress(){
		return this.banquetAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申办地名称
	 */
	public void setBanquetAddress(java.lang.String banquetAddress){
		this.banquetAddress = banquetAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="BANQUET_REMARK",nullable=true,length=32)
	public java.lang.String getBanquetRemark(){
		return this.banquetRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setBanquetRemark(java.lang.String banquetRemark){
		this.banquetRemark = banquetRemark;
	}
}
