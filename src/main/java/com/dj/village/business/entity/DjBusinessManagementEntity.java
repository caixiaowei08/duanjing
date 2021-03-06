package com.dj.village.business.entity;

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
 * @Description: 事务管理
 * @author onlineGenerator
 * @date 2015-12-05 13:01:23
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_business_management", schema = "")
@SuppressWarnings("serial")
public class DjBusinessManagementEntity implements java.io.Serializable {
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
	/**事务名称*/
	@Excel(name="事务名称")
	private java.lang.String businessName;
	/**主管部门*/
	@Excel(name="主管部门")
	private java.lang.String businessDept;
	/**时间*/
	@Excel(name="时间")
	private java.util.Date businessTime;
	/**经办人*/
	@Excel(name="经办人")
	private java.lang.String businessOperator;
	/**主持人*/
	@Excel(name="主持人")
	private java.lang.String businessHost;
	/**参加对象*/
	@Excel(name="参加对象")
	private java.lang.String businessJoiners;
	/**内容摘要*/
	@Excel(name="内容摘要")
	private java.lang.String businessDetail;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String businessRemark;
	
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
	 *@return: java.lang.String  事务名称
	 */
	@Column(name ="BUSINESS_NAME",nullable=false,length=32)
	public java.lang.String getBusinessName(){
		return this.businessName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  事务名称
	 */
	public void setBusinessName(java.lang.String businessName){
		this.businessName = businessName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主管部门
	 */
	@Column(name ="BUSINESS_DEPT",nullable=true,length=32)
	public java.lang.String getBusinessDept(){
		return this.businessDept;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主管部门
	 */
	public void setBusinessDept(java.lang.String businessDept){
		this.businessDept = businessDept;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  时间
	 */
	@Column(name ="BUSINESS_TIME",nullable=false,length=32)
	public java.util.Date getBusinessTime(){
		return this.businessTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  时间
	 */
	public void setBusinessTime(java.util.Date businessTime){
		this.businessTime = businessTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  经办人
	 */
	@Column(name ="BUSINESS_OPERATOR",nullable=false,length=32)
	public java.lang.String getBusinessOperator(){
		return this.businessOperator;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  经办人
	 */
	public void setBusinessOperator(java.lang.String businessOperator){
		this.businessOperator = businessOperator;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主持人
	 */
	@Column(name ="BUSINESS_HOST",nullable=true,length=32)
	public java.lang.String getBusinessHost(){
		return this.businessHost;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主持人
	 */
	public void setBusinessHost(java.lang.String businessHost){
		this.businessHost = businessHost;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参加对象
	 */
	@Column(name ="BUSINESS_JOINERS",nullable=true,length=32)
	public java.lang.String getBusinessJoiners(){
		return this.businessJoiners;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参加对象
	 */
	public void setBusinessJoiners(java.lang.String businessJoiners){
		this.businessJoiners = businessJoiners;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内容摘要
	 */
	@Column(name ="BUSINESS_DETAIL",nullable=true,length=32)
	public java.lang.String getBusinessDetail(){
		return this.businessDetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内容摘要
	 */
	public void setBusinessDetail(java.lang.String businessDetail){
		this.businessDetail = businessDetail;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="BUSINESS_REMARK",nullable=true,length=32)
	public java.lang.String getBusinessRemark(){
		return this.businessRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setBusinessRemark(java.lang.String businessRemark){
		this.businessRemark = businessRemark;
	}
}
