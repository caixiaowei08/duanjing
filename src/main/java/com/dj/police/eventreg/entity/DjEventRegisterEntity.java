package com.dj.police.eventreg.entity;

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
 * @Description: 事件登记
 * @author onlineGenerator
 * @date 2015-12-07 21:57:16
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_event_register", schema = "")
@SuppressWarnings("serial")
public class DjEventRegisterEntity implements java.io.Serializable {
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
	/**案件名称*/
	@Excel(name="案件名称")
	private java.lang.String eventName;
	/**发生时间*/
	@Excel(name="发生时间")
	private java.util.Date eventTirme;
	/**报案时间*/
	@Excel(name="报案时间")
	private java.util.Date eventReportTime;
	/**报案人*/
	@Excel(name="报案人")
	private java.lang.String name;
	/**证件类型*/
	@Excel(name="证件类型")
	private java.lang.String idType;
	/**证件号码*/
	@Excel(name="证件号码")
	private java.lang.String idNo;
	/**地址*/
	@Excel(name="地址")
	private java.lang.String eventAddress;
	/**电话*/
	@Excel(name="电话")
	private java.lang.String eventTel;
	/**涉案价值*/
	@Excel(name="涉案价值")
	private java.lang.String eventValue;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String eventRemark;
	
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
	 *@return: java.lang.String  案件名称
	 */
	@Column(name ="EVENT_NAME",nullable=true,length=32)
	public java.lang.String getEventName(){
		return this.eventName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  案件名称
	 */
	public void setEventName(java.lang.String eventName){
		this.eventName = eventName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发生时间
	 */
	@Column(name ="EVENT_TIRME",nullable=true,length=32)
	public java.util.Date getEventTirme(){
		return this.eventTirme;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发生时间
	 */
	public void setEventTirme(java.util.Date eventTirme){
		this.eventTirme = eventTirme;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  报案时间
	 */
	@Column(name ="EVENT_REPORT_TIME",nullable=true,length=32)
	public java.util.Date getEventReportTime(){
		return this.eventReportTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  报案时间
	 */
	public void setEventReportTime(java.util.Date eventReportTime){
		this.eventReportTime = eventReportTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  报案人
	 */
	@Column(name ="NAME",nullable=false,length=32)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  报案人
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件类型
	 */
	@Column(name ="ID_TYPE",nullable=true,length=32)
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
	@Column(name ="ID_NO",nullable=true,length=32)
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
	 *@return: java.lang.String  地址
	 */
	@Column(name ="EVENT_ADDRESS",nullable=true,length=32)
	public java.lang.String getEventAddress(){
		return this.eventAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地址
	 */
	public void setEventAddress(java.lang.String eventAddress){
		this.eventAddress = eventAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电话
	 */
	@Column(name ="EVENT_TEL",nullable=true,length=32)
	public java.lang.String getEventTel(){
		return this.eventTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电话
	 */
	public void setEventTel(java.lang.String eventTel){
		this.eventTel = eventTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  涉案价值
	 */
	@Column(name ="EVENT_VALUE",nullable=true,length=32)
	public java.lang.String getEventValue(){
		return this.eventValue;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  涉案价值
	 */
	public void setEventValue(java.lang.String eventValue){
		this.eventValue = eventValue;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="EVENT_REMARK",nullable=true,length=32)
	public java.lang.String getEventRemark(){
		return this.eventRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setEventRemark(java.lang.String eventRemark){
		this.eventRemark = eventRemark;
	}
}
