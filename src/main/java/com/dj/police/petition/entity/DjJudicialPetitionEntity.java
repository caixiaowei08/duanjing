package com.dj.police.petition.entity;

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
 * @Description: 司法信访
 * @author onlineGenerator
 * @date 2015-12-07 21:54:30
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_judicial_petition", schema = "")
@SuppressWarnings("serial")
public class DjJudicialPetitionEntity implements java.io.Serializable {
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
	/**信访类别*/
	@Excel(name="信访类别")
	private java.lang.String petitionType;
	/**信访人*/
	@Excel(name="信访人")
	private java.lang.String petitionPerson;
	/**信访时间*/
	@Excel(name="信访时间")
	private java.util.Date petitionTime;
	/**信访内容摘要*/
	@Excel(name="信访内容摘要")
	private java.lang.String petitionDetail;
	/**领导批示*/
	@Excel(name="领导批示")
	private java.lang.String petitionComments;
	/**责任人*/
	@Excel(name="责任人")
	private java.lang.String petitionOfficer;
	/**回访时间*/
	@Excel(name="回访时间")
	private java.util.Date petitionRevisitDays;
	/**回访结果*/
	@Excel(name="回访结果")
	private java.lang.String petitionRevisitResult;
	
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
	 *@return: java.lang.String  信访类别
	 */
	@Column(name ="PETITION_TYPE",nullable=false,length=32)
	public java.lang.String getPetitionType(){
		return this.petitionType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  信访类别
	 */
	public void setPetitionType(java.lang.String petitionType){
		this.petitionType = petitionType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  信访人
	 */
	@Column(name ="PETITION_PERSON",nullable=false,length=32)
	public java.lang.String getPetitionPerson(){
		return this.petitionPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  信访人
	 */
	public void setPetitionPerson(java.lang.String petitionPerson){
		this.petitionPerson = petitionPerson;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  信访时间
	 */
	@Column(name ="PETITION_TIME",nullable=false,length=32)
	public java.util.Date getPetitionTime(){
		return this.petitionTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  信访时间
	 */
	public void setPetitionTime(java.util.Date petitionTime){
		this.petitionTime = petitionTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  信访内容摘要
	 */
	@Column(name ="PETITION_DETAIL",nullable=false,length=32)
	public java.lang.String getPetitionDetail(){
		return this.petitionDetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  信访内容摘要
	 */
	public void setPetitionDetail(java.lang.String petitionDetail){
		this.petitionDetail = petitionDetail;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  领导批示
	 */
	@Column(name ="PETITION_COMMENTS",nullable=true,length=32)
	public java.lang.String getPetitionComments(){
		return this.petitionComments;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  领导批示
	 */
	public void setPetitionComments(java.lang.String petitionComments){
		this.petitionComments = petitionComments;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  责任人
	 */
	@Column(name ="PETITION_OFFICER",nullable=true,length=32)
	public java.lang.String getPetitionOfficer(){
		return this.petitionOfficer;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  责任人
	 */
	public void setPetitionOfficer(java.lang.String petitionOfficer){
		this.petitionOfficer = petitionOfficer;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  回访时间
	 */
	@Column(name ="PETITION_REVISIT_DAYS",nullable=true,length=32)
	public java.util.Date getPetitionRevisitDays(){
		return this.petitionRevisitDays;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  回访时间
	 */
	public void setPetitionRevisitDays(java.util.Date petitionRevisitDays){
		this.petitionRevisitDays = petitionRevisitDays;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  回访结果
	 */
	@Column(name ="PETITION_REVISIT_RESULT",nullable=true,length=32)
	public java.lang.String getPetitionRevisitResult(){
		return this.petitionRevisitResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  回访结果
	 */
	public void setPetitionRevisitResult(java.lang.String petitionRevisitResult){
		this.petitionRevisitResult = petitionRevisitResult;
	}
}
