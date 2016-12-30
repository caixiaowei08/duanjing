package com.dj.police.pnotify.entity;

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
 * @Description: 警情通报
 * @author onlineGenerator
 * @date 2015-12-07 21:56:07
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_police_notify", schema = "")
@SuppressWarnings("serial")
public class DjPoliceNotifyEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.Integer id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新日期*/
	private java.util.Date updateDate;
	/**责任民警*/
	@Excel(name="责任民警")
	private java.lang.String notifyResponPolice;
	/**通报日期*/
	@Excel(name="通报日期")
	private java.util.Date notifyTime;
	/**参与人数*/
	@Excel(name="参与人数")
	private java.lang.String notifyPersonNum;
	/**通报地址*/
	@Excel(name="通报地址")
	private java.lang.String notifyAddress;
	/**开始时间*/
	@Excel(name="开始时间")
	private java.util.Date notifyStartTime;
	/**结束时间*/
	@Excel(name="结束时间")
	private java.util.Date notifyEndTime;
	/**内容摘要*/
	@Excel(name="内容摘要")
	private java.lang.String notifyDetail;
	/**防范漏洞*/
	@Excel(name="防范漏洞")
	private java.lang.String notifyPrevent;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String notifyRemark;
	
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
	 *@return: java.lang.String  责任民警
	 */
	@Column(name ="NOTIFY_RESPON_POLICE",nullable=false,length=32)
	public java.lang.String getNotifyResponPolice(){
		return this.notifyResponPolice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  责任民警
	 */
	public void setNotifyResponPolice(java.lang.String notifyResponPolice){
		this.notifyResponPolice = notifyResponPolice;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  通报日期
	 */
	@Column(name ="NOTIFY_TIME",nullable=true,length=32)
	public java.util.Date getNotifyTime(){
		return this.notifyTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  通报日期
	 */
	public void setNotifyTime(java.util.Date notifyTime){
		this.notifyTime = notifyTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参与人数
	 */
	@Column(name ="NOTIFY_PERSON_NUM",nullable=true,length=32)
	public java.lang.String getNotifyPersonNum(){
		return this.notifyPersonNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参与人数
	 */
	public void setNotifyPersonNum(java.lang.String notifyPersonNum){
		this.notifyPersonNum = notifyPersonNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  通报地址
	 */
	@Column(name ="NOTIFY_ADDRESS",nullable=true,length=32)
	public java.lang.String getNotifyAddress(){
		return this.notifyAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  通报地址
	 */
	public void setNotifyAddress(java.lang.String notifyAddress){
		this.notifyAddress = notifyAddress;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开始时间
	 */
	@Column(name ="NOTIFY_START_TIME",nullable=true,length=32)
	public java.util.Date getNotifyStartTime(){
		return this.notifyStartTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开始时间
	 */
	public void setNotifyStartTime(java.util.Date notifyStartTime){
		this.notifyStartTime = notifyStartTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  结束时间
	 */
	@Column(name ="NOTIFY_END_TIME",nullable=true,length=32)
	public java.util.Date getNotifyEndTime(){
		return this.notifyEndTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  结束时间
	 */
	public void setNotifyEndTime(java.util.Date notifyEndTime){
		this.notifyEndTime = notifyEndTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内容摘要
	 */
	@Column(name ="NOTIFY_DETAIL",nullable=false,length=32)
	public java.lang.String getNotifyDetail(){
		return this.notifyDetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内容摘要
	 */
	public void setNotifyDetail(java.lang.String notifyDetail){
		this.notifyDetail = notifyDetail;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  防范漏洞
	 */
	@Column(name ="NOTIFY_PREVENT",nullable=true,length=32)
	public java.lang.String getNotifyPrevent(){
		return this.notifyPrevent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  防范漏洞
	 */
	public void setNotifyPrevent(java.lang.String notifyPrevent){
		this.notifyPrevent = notifyPrevent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="NOTIFY_REMARK",nullable=true,length=32)
	public java.lang.String getNotifyRemark(){
		return this.notifyRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setNotifyRemark(java.lang.String notifyRemark){
		this.notifyRemark = notifyRemark;
	}
}
