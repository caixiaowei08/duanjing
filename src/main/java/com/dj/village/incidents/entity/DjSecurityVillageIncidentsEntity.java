package com.dj.village.incidents.entity;

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
 * @Description: 安全事故
 * @author onlineGenerator
 * @date 2015-12-07 22:20:15
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_security_village_incidents", schema = "")
@SuppressWarnings("serial")
public class DjSecurityVillageIncidentsEntity implements java.io.Serializable {
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
	/**事故时间*/
	@Excel(name="事故时间")
	private java.util.Date incideTime;
	/**事故单位*/
	@Excel(name="事故单位")
	private java.lang.String incideDept;
	/**伤亡情况*/
	@Excel(name="伤亡情况")
	private java.lang.String incideCasualtyNum;
	/**责任人*/
	@Excel(name="责任人")
	private java.lang.String incideOfficer;
	/**责任原因*/
	@Excel(name="责任原因")
	private java.lang.String incideReason;
	/**查出结果*/
	@Excel(name="查出结果")
	private java.lang.String incideCheckResult;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String incideRemark;
	
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
	 *@return: java.util.Date  事故时间
	 */
	@Column(name ="INCIDE_TIME",nullable=false,length=32)
	public java.util.Date getIncideTime(){
		return this.incideTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  事故时间
	 */
	public void setIncideTime(java.util.Date incideTime){
		this.incideTime = incideTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  事故单位
	 */
	@Column(name ="INCIDE_DEPT",nullable=false,length=32)
	public java.lang.String getIncideDept(){
		return this.incideDept;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  事故单位
	 */
	public void setIncideDept(java.lang.String incideDept){
		this.incideDept = incideDept;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  伤亡情况
	 */
	@Column(name ="INCIDE_CASUALTY_NUM",nullable=true,length=32)
	public java.lang.String getIncideCasualtyNum(){
		return this.incideCasualtyNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  伤亡情况
	 */
	public void setIncideCasualtyNum(java.lang.String incideCasualtyNum){
		this.incideCasualtyNum = incideCasualtyNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  责任人
	 */
	@Column(name ="INCIDE_OFFICER",nullable=false,length=32)
	public java.lang.String getIncideOfficer(){
		return this.incideOfficer;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  责任人
	 */
	public void setIncideOfficer(java.lang.String incideOfficer){
		this.incideOfficer = incideOfficer;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  责任原因
	 */
	@Column(name ="INCIDE_REASON",nullable=true,length=32)
	public java.lang.String getIncideReason(){
		return this.incideReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  责任原因
	 */
	public void setIncideReason(java.lang.String incideReason){
		this.incideReason = incideReason;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  查出结果
	 */
	@Column(name ="INCIDE_CHECK_RESULT",nullable=true,length=32)
	public java.lang.String getIncideCheckResult(){
		return this.incideCheckResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  查出结果
	 */
	public void setIncideCheckResult(java.lang.String incideCheckResult){
		this.incideCheckResult = incideCheckResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="INCIDE_REMARK",nullable=true,length=32)
	public java.lang.String getIncideRemark(){
		return this.incideRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setIncideRemark(java.lang.String incideRemark){
		this.incideRemark = incideRemark;
	}
}
