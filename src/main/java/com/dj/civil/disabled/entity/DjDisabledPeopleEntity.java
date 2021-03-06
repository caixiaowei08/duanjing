package com.dj.civil.disabled.entity;

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
 * @Description: 残疾人管理
 * @author onlineGenerator
 * @date 2015-12-05 17:42:03
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_disabled_people", schema = "")
@SuppressWarnings("serial")
public class DjDisabledPeopleEntity implements java.io.Serializable {
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
	/**文化程度*/
	@Excel(name="文化程度")
	private java.lang.String degree;
	/**户籍地址*/
	@Excel(name="户籍地址")
	private java.lang.String permanentAddress;
	/**现居住地址*/
	@Excel(name="现居住地址")
	private java.lang.String currentAddress;
	/**残疾证号*/
	@Excel(name="残疾证号")
	private java.lang.String disabledNo;
	/**残疾状况*/
	@Excel(name="残疾状况")
	private java.lang.String disabledStatus;
	/**发放机关*/
	@Excel(name="发放机关")
	private java.lang.String disabledDept;
	/**发放时间*/
	@Excel(name="发放时间")
	private java.util.Date disabledProvideTime;
	/**监护人*/
	@Excel(name="监护人")
	private java.lang.String disabledGuardian;
	/**劳动能力*/
	@Excel(name="劳动能力")
	private java.lang.String disabledLabor;
	/**技能特长*/
	@Excel(name="技能特长")
	private java.lang.String disabledAbility;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String disabledRemark;
	
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
	 *@return: java.lang.String  文化程度
	 */
	@Column(name ="DEGREE",nullable=true,length=32)
	public java.lang.String getDegree(){
		return this.degree;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文化程度
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  残疾证号
	 */
	@Column(name ="DISABLED_NO",nullable=true,length=32)
	public java.lang.String getDisabledNo(){
		return this.disabledNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  残疾证号
	 */
	public void setDisabledNo(java.lang.String disabledNo){
		this.disabledNo = disabledNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  残疾状况
	 */
	@Column(name ="DISABLED_STATUS",nullable=true,length=32)
	public java.lang.String getDisabledStatus(){
		return this.disabledStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  残疾状况
	 */
	public void setDisabledStatus(java.lang.String disabledStatus){
		this.disabledStatus = disabledStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发放机关
	 */
	@Column(name ="DISABLED_DEPT",nullable=true,length=32)
	public java.lang.String getDisabledDept(){
		return this.disabledDept;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发放机关
	 */
	public void setDisabledDept(java.lang.String disabledDept){
		this.disabledDept = disabledDept;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发放时间
	 */
	@Column(name ="DISABLED_PROVIDE_TIME",nullable=true,length=32)
	public java.util.Date getDisabledProvideTime(){
		return this.disabledProvideTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发放时间
	 */
	public void setDisabledProvideTime(java.util.Date disabledProvideTime){
		this.disabledProvideTime = disabledProvideTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  监护人
	 */
	@Column(name ="DISABLED_GUARDIAN",nullable=true,length=32)
	public java.lang.String getDisabledGuardian(){
		return this.disabledGuardian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  监护人
	 */
	public void setDisabledGuardian(java.lang.String disabledGuardian){
		this.disabledGuardian = disabledGuardian;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  劳动能力
	 */
	@Column(name ="DISABLED_LABOR",nullable=true,length=32)
	public java.lang.String getDisabledLabor(){
		return this.disabledLabor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  劳动能力
	 */
	public void setDisabledLabor(java.lang.String disabledLabor){
		this.disabledLabor = disabledLabor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  技能特长
	 */
	@Column(name ="DISABLED_ABILITY",nullable=true,length=32)
	public java.lang.String getDisabledAbility(){
		return this.disabledAbility;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  技能特长
	 */
	public void setDisabledAbility(java.lang.String disabledAbility){
		this.disabledAbility = disabledAbility;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="DISABLED_REMARK",nullable=true,length=32)
	public java.lang.String getDisabledRemark(){
		return this.disabledRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setDisabledRemark(java.lang.String disabledRemark){
		this.disabledRemark = disabledRemark;
	}
}
