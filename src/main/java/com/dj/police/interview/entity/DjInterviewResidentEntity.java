package com.dj.police.interview.entity;

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
 * @Description: 民警走访
 * @author onlineGenerator
 * @date 2015-12-07 21:56:48
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_interview_resident", schema = "")
@SuppressWarnings("serial")
public class DjInterviewResidentEntity implements java.io.Serializable {
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
	private java.lang.String inter;
	/**走访门牌号*/
	@Excel(name="走访门牌号")
	private java.lang.String interRoom;
	/**被走访人*/
	@Excel(name="被走访人")
	private java.lang.String interInterviewee;
	/**证件类型*/
	@Excel(name="证件类型")
	private java.lang.String idType;
	/**证件号码*/
	@Excel(name="证件号码")
	private java.lang.String idNo;
	/**电话*/
	@Excel(name="电话")
	private java.lang.String interTel;
	/**开始时间*/
	@Excel(name="开始时间")
	private java.util.Date interStartTime;
	/**结束时间*/
	@Excel(name="结束时间")
	private java.util.Date interEndTime;
	/**内容摘要*/
	@Excel(name="内容摘要")
	private java.lang.String interDetail;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String interRemark;
	
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
	@Column(name ="INTER_",nullable=false,length=32)
	public java.lang.String getInter(){
		return this.inter;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  责任民警
	 */
	public void setInter(java.lang.String inter){
		this.inter = inter;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  走访门牌号
	 */
	@Column(name ="INTER_ROOM",nullable=false,length=32)
	public java.lang.String getInterRoom(){
		return this.interRoom;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  走访门牌号
	 */
	public void setInterRoom(java.lang.String interRoom){
		this.interRoom = interRoom;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  被走访人
	 */
	@Column(name ="INTER_INTERVIEWEE",nullable=false,length=32)
	public java.lang.String getInterInterviewee(){
		return this.interInterviewee;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  被走访人
	 */
	public void setInterInterviewee(java.lang.String interInterviewee){
		this.interInterviewee = interInterviewee;
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
	 *@return: java.lang.String  电话
	 */
	@Column(name ="INTER_TEL",nullable=true,length=32)
	public java.lang.String getInterTel(){
		return this.interTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电话
	 */
	public void setInterTel(java.lang.String interTel){
		this.interTel = interTel;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开始时间
	 */
	@Column(name ="INTER_START_TIME",nullable=true,length=32)
	public java.util.Date getInterStartTime(){
		return this.interStartTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开始时间
	 */
	public void setInterStartTime(java.util.Date interStartTime){
		this.interStartTime = interStartTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  结束时间
	 */
	@Column(name ="INTER_END_TIME",nullable=true,length=32)
	public java.util.Date getInterEndTime(){
		return this.interEndTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  结束时间
	 */
	public void setInterEndTime(java.util.Date interEndTime){
		this.interEndTime = interEndTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内容摘要
	 */
	@Column(name ="INTER_DETAIL",nullable=true,length=32)
	public java.lang.String getInterDetail(){
		return this.interDetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内容摘要
	 */
	public void setInterDetail(java.lang.String interDetail){
		this.interDetail = interDetail;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="INTER_REMARK",nullable=true,length=32)
	public java.lang.String getInterRemark(){
		return this.interRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setInterRemark(java.lang.String interRemark){
		this.interRemark = interRemark;
	}
}
