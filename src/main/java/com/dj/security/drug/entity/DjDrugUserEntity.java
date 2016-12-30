package com.dj.security.drug.entity;

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
 * @Description: 吸毒人员
 * @author onlineGenerator
 * @date 2015-12-05 21:17:04
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_drug_user", schema = "")
@SuppressWarnings("serial")
public class DjDrugUserEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
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
	/**婚姻状况*/
	@Excel(name="婚姻状况")
	private java.lang.String maritalStatus;
	/**人员id*/
	@Excel(name="人员id")
	private java.lang.String pid;
	/**案别*/
	@Excel(name="案别")
	private java.lang.String drugItem;
	/**吸食毒品类型*/
	@Excel(name="吸食毒品类型")
	private java.lang.String drugDrugItem;
	/**处理时间*/
	@Excel(name="处理时间")
	private java.util.Date drugDealTime;
	/**处理结果*/
	@Excel(name="处理结果")
	private java.lang.String drugResult;
	/**目前状态*/
	@Excel(name="目前状态")
	private java.lang.String drugStatus;
	/**联系电话*/
	@Excel(name="联系电话")
	private java.lang.String drugTel;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String drugRemark;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
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
	 *@return: java.lang.String  婚姻状况
	 */
	@Column(name ="MARITAL_STATUS",nullable=true,length=32)
	public java.lang.String getMaritalStatus(){
		return this.maritalStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  婚姻状况
	 */
	public void setMaritalStatus(java.lang.String maritalStatus){
		this.maritalStatus = maritalStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  人员id
	 */
	@Column(name ="PID",nullable=true,length=32)
	public java.lang.String getPid(){
		return this.pid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人员id
	 */
	public void setPid(java.lang.String pid){
		this.pid = pid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  案别
	 */
	@Column(name ="DRUG_ITEM",nullable=true,length=32)
	public java.lang.String getDrugItem(){
		return this.drugItem;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  案别
	 */
	public void setDrugItem(java.lang.String drugItem){
		this.drugItem = drugItem;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  吸食毒品类型
	 */
	@Column(name ="DRUG_DRUG_ITEM",nullable=false,length=32)
	public java.lang.String getDrugDrugItem(){
		return this.drugDrugItem;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  吸食毒品类型
	 */
	public void setDrugDrugItem(java.lang.String drugDrugItem){
		this.drugDrugItem = drugDrugItem;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  处理时间
	 */
	@Column(name ="DRUG_DEAL_TIME",nullable=false,length=32)
	public java.util.Date getDrugDealTime(){
		return this.drugDealTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  处理时间
	 */
	public void setDrugDealTime(java.util.Date drugDealTime){
		this.drugDealTime = drugDealTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  处理结果
	 */
	@Column(name ="DRUG_RESULT",nullable=true,length=32)
	public java.lang.String getDrugResult(){
		return this.drugResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  处理结果
	 */
	public void setDrugResult(java.lang.String drugResult){
		this.drugResult = drugResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  目前状态
	 */
	@Column(name ="DRUG_STATUS",nullable=true,length=32)
	public java.lang.String getDrugStatus(){
		return this.drugStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  目前状态
	 */
	public void setDrugStatus(java.lang.String drugStatus){
		this.drugStatus = drugStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */
	@Column(name ="DRUG_TEL",nullable=false,length=32)
	public java.lang.String getDrugTel(){
		return this.drugTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setDrugTel(java.lang.String drugTel){
		this.drugTel = drugTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="DRUG_REMARK",nullable=true,length=32)
	public java.lang.String getDrugRemark(){
		return this.drugRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setDrugRemark(java.lang.String drugRemark){
		this.drugRemark = drugRemark;
	}
}
