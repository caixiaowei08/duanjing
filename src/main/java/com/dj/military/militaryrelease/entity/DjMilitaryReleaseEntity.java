package com.dj.military.militaryrelease.entity;

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
 * @Description: 退役人员
 * @author onlineGenerator
 * @date 2015-12-14 21:05:22
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_military_release", schema = "")
@SuppressWarnings("serial")
public class DjMilitaryReleaseEntity implements java.io.Serializable {
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
	/**学历*/
	@Excel(name="学历")
	private java.lang.String degree;
	/**户籍地址*/
	@Excel(name="户籍地址")
	private java.lang.String permanentAddress;
	/**现居住地址*/
	@Excel(name="现居住地址")
	private java.lang.String currentAddress;
	/**入伍时间*/
	@Excel(name="入伍时间")
	private java.util.Date militaryTime;
	/**服役年限*/
	@Excel(name="服役年限")
	private java.lang.String militaryAgeLimit;
	/**兵种类型*/
	@Excel(name="兵种类型")
	private java.lang.String soldierType;
	/**部队类型*/
	@Excel(name="部队类型")
	private java.lang.String militaryType;
	/**退役时间*/
	@Excel(name="退役时间")
	private java.util.Date militaryReleTime;
	/**安置情况*/
	@Excel(name="安置情况")
	private java.lang.String resettlement;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String remark;
	
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
	 *@return: java.lang.String  学历
	 */
	@Column(name ="DEGREE",nullable=true,length=32)
	public java.lang.String getDegree(){
		return this.degree;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历
	 */
	public void setDegree(java.lang.String degree){
		this.degree = degree;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户籍地址
	 */
	@Column(name ="PERMANENT_ADDRESS",nullable=true,length=32)
	public java.lang.String getPermanentAddress(){
		return this.permanentAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户籍地址
	 */
	public void setPermanentAddress(java.lang.String permanentAddress){
		this.permanentAddress = permanentAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现居住地址
	 */
	@Column(name ="CURRENT_ADDRESS",nullable=true,length=32)
	public java.lang.String getCurrentAddress(){
		return this.currentAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现居住地址
	 */
	public void setCurrentAddress(java.lang.String currentAddress){
		this.currentAddress = currentAddress;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  入伍时间
	 */
	@Column(name ="MILITARY_TIME",nullable=false,length=32)
	public java.util.Date getMilitaryTime(){
		return this.militaryTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  入伍时间
	 */
	public void setMilitaryTime(java.util.Date militaryTime){
		this.militaryTime = militaryTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服役年限
	 */
	@Column(name ="MILITARY_AGE_LIMIT",nullable=true,length=32)
	public java.lang.String getMilitaryAgeLimit(){
		return this.militaryAgeLimit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服役年限
	 */
	public void setMilitaryAgeLimit(java.lang.String militaryAgeLimit){
		this.militaryAgeLimit = militaryAgeLimit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  兵种类型
	 */
	@Column(name ="SOLDIER_TYPE",nullable=true,length=32)
	public java.lang.String getSoldierType(){
		return this.soldierType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  兵种类型
	 */
	public void setSoldierType(java.lang.String soldierType){
		this.soldierType = soldierType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  部队类型
	 */
	@Column(name ="MILITARY_TYPE",nullable=true,length=32)
	public java.lang.String getMilitaryType(){
		return this.militaryType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  部队类型
	 */
	public void setMilitaryType(java.lang.String militaryType){
		this.militaryType = militaryType;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  退役时间
	 */
	@Column(name ="MILITARY_RELE_TIME",nullable=false,length=32)
	public java.util.Date getMilitaryReleTime(){
		return this.militaryReleTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  退役时间
	 */
	public void setMilitaryReleTime(java.util.Date militaryReleTime){
		this.militaryReleTime = militaryReleTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  安置情况
	 */
	@Column(name ="RESETTLEMENT",nullable=true,length=32)
	public java.lang.String getResettlement(){
		return this.resettlement;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安置情况
	 */
	public void setResettlement(java.lang.String resettlement){
		this.resettlement = resettlement;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,length=32)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
}
