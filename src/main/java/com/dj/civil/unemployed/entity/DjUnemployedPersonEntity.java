package com.dj.civil.unemployed.entity;

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
 * @Description: 失业人员
 * @author onlineGenerator
 * @date 2015-12-05 17:41:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_unemployed_person", schema = "")
@SuppressWarnings("serial")
public class DjUnemployedPersonEntity implements java.io.Serializable {
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
	/**原工作单位*/
	@Excel(name="原工作单位")
	private java.lang.String unemplOldCom;
	/**失业日期*/
	@Excel(name="失业日期")
	private java.util.Date unemplTime;
	/**失业原因*/
	@Excel(name="失业原因")
	private java.lang.String unemplReason;
	/**是否再就业*/
	@Excel(name="是否再就业")
	private java.lang.String unemplIsReEmpl;
	/**是否低保*/
	@Excel(name="是否低保")
	private java.lang.String unemplIsLow;
	/**求职意向*/
	@Excel(name="求职意向")
	private java.lang.String unemplJobIntension;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String unemplRemark;
	
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
	 *@return: java.lang.String  原工作单位
	 */
	@Column(name ="UNEMPL_OLD_COM",nullable=true,length=32)
	public java.lang.String getUnemplOldCom(){
		return this.unemplOldCom;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原工作单位
	 */
	public void setUnemplOldCom(java.lang.String unemplOldCom){
		this.unemplOldCom = unemplOldCom;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  失业日期
	 */
	@Column(name ="UNEMPL_TIME",nullable=false,length=32)
	public java.util.Date getUnemplTime(){
		return this.unemplTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  失业日期
	 */
	public void setUnemplTime(java.util.Date unemplTime){
		this.unemplTime = unemplTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  失业原因
	 */
	@Column(name ="UNEMPL_REASON",nullable=false,length=32)
	public java.lang.String getUnemplReason(){
		return this.unemplReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  失业原因
	 */
	public void setUnemplReason(java.lang.String unemplReason){
		this.unemplReason = unemplReason;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否再就业
	 */
	@Column(name ="UNEMPL_IS_RE_EMPL",nullable=false,length=32)
	public java.lang.String getUnemplIsReEmpl(){
		return this.unemplIsReEmpl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否再就业
	 */
	public void setUnemplIsReEmpl(java.lang.String unemplIsReEmpl){
		this.unemplIsReEmpl = unemplIsReEmpl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否低保
	 */
	@Column(name ="UNEMPL_IS_LOW",nullable=false,length=32)
	public java.lang.String getUnemplIsLow(){
		return this.unemplIsLow;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否低保
	 */
	public void setUnemplIsLow(java.lang.String unemplIsLow){
		this.unemplIsLow = unemplIsLow;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  求职意向
	 */
	@Column(name ="UNEMPL_JOB_INTENSION",nullable=true,length=32)
	public java.lang.String getUnemplJobIntension(){
		return this.unemplJobIntension;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  求职意向
	 */
	public void setUnemplJobIntension(java.lang.String unemplJobIntension){
		this.unemplJobIntension = unemplJobIntension;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="UNEMPL_REMARK",nullable=true,length=32)
	public java.lang.String getUnemplRemark(){
		return this.unemplRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setUnemplRemark(java.lang.String unemplRemark){
		this.unemplRemark = unemplRemark;
	}
}
