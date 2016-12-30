package com.dj.health.treat.entity;

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
 * @Description: 就诊记录
 * @author onlineGenerator
 * @date 2015-12-06 23:04:31
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_treat_detail", schema = "")
@SuppressWarnings("serial")
public class DjTreatDetailEntity implements java.io.Serializable {
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
	/**就诊时间*/
	@Excel(name="就诊时间")
	private java.util.Date treatTime;
	/**姓名*/
	@Excel(name="姓名")
	private java.lang.String name;
	/**性别*/
	@Excel(name="性别")
	private java.lang.String sex;
	/**住址*/
	@Excel(name="住址")
	private java.lang.String currentAddress;
	/**联系电话*/
	@Excel(name="联系电话")
	private java.lang.String phone;
	/**诊断情况*/
	@Excel(name="诊断情况")
	private java.lang.String treatDetail;
	/**诊断医师*/
	@Excel(name="诊断医师")
	private java.lang.String treatDoctor;
	/**发药情况*/
	@Excel(name="发药情况")
	private java.lang.String treatMedicine;
	/**是否医保*/
	@Excel(name="是否医保")
	private java.lang.String treatIsInsurance;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String treatRemark;
	
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  就诊时间
	 */
	@Column(name ="TREAT_TIME",nullable=false,length=32)
	public java.util.Date getTreatTime(){
		return this.treatTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  就诊时间
	 */
	public void setTreatTime(java.util.Date treatTime){
		this.treatTime = treatTime;
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
	 *@return: java.lang.String  住址
	 */
	@Column(name ="CURRENT_ADDRESS",nullable=true,length=32)
	public java.lang.String getCurrentAddress(){
		return this.currentAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  住址
	 */
	public void setCurrentAddress(java.lang.String currentAddress){
		this.currentAddress = currentAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */
	@Column(name ="PHONE",nullable=true,length=32)
	public java.lang.String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  诊断情况
	 */
	@Column(name ="TREAT_DETAIL",nullable=false,length=32)
	public java.lang.String getTreatDetail(){
		return this.treatDetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  诊断情况
	 */
	public void setTreatDetail(java.lang.String treatDetail){
		this.treatDetail = treatDetail;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  诊断医师
	 */
	@Column(name ="TREAT_DOCTOR",nullable=false,length=32)
	public java.lang.String getTreatDoctor(){
		return this.treatDoctor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  诊断医师
	 */
	public void setTreatDoctor(java.lang.String treatDoctor){
		this.treatDoctor = treatDoctor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发药情况
	 */
	@Column(name ="TREAT_MEDICINE",nullable=true,length=32)
	public java.lang.String getTreatMedicine(){
		return this.treatMedicine;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发药情况
	 */
	public void setTreatMedicine(java.lang.String treatMedicine){
		this.treatMedicine = treatMedicine;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否医保
	 */
	@Column(name ="TREAT_IS_INSURANCE",nullable=false,length=32)
	public java.lang.String getTreatIsInsurance(){
		return this.treatIsInsurance;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否医保
	 */
	public void setTreatIsInsurance(java.lang.String treatIsInsurance){
		this.treatIsInsurance = treatIsInsurance;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="TREAT_REMARK",nullable=true,length=32)
	public java.lang.String getTreatRemark(){
		return this.treatRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setTreatRemark(java.lang.String treatRemark){
		this.treatRemark = treatRemark;
	}
}
