package com.dj.police.mediation.entity;

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
 * @Description: 民事调解
 * @author onlineGenerator
 * @date 2015-12-07 21:54:58
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_mediation_person", schema = "")
@SuppressWarnings("serial")
public class DjMediationPersonEntity implements java.io.Serializable {
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
	/**调解时间*/
	@Excel(name="调解时间")
	private java.util.Date mediaTime;
	/**甲 当事人姓名*/
	@Excel(name="甲 当事人姓名")
	private java.lang.String mediaFirstName;
	/**甲 证件类型*/
	@Excel(name="甲 证件类型")
	private java.lang.String mediaFirstIdType;
	/**甲 证件号码*/
	@Excel(name="甲 证件号码")
	private java.lang.String mediaFirstIdNo;
	/**甲 联系电话*/
	@Excel(name="甲 联系电话")
	private java.lang.String mediaFirstTel;
	/**乙 当事人姓名*/
	@Excel(name="乙 当事人姓名")
	private java.lang.String mediaSecondName;
	/**乙 证件类型*/
	@Excel(name="乙 证件类型")
	private java.lang.String mediaSecondIdType;
	/**乙 证件号码*/
	@Excel(name="乙 证件号码")
	private java.lang.String mediaSecondIdNo;
	/**乙 联系电话*/
	@Excel(name="乙 联系电话")
	private java.lang.String mediaSecondTel;
	/**矛盾纠纷原因*/
	@Excel(name="矛盾纠纷原因")
	private java.lang.String mediaReason;
	/**调解结果*/
	@Excel(name="调解结果")
	private java.lang.String mediaResult;
	/**摘要*/
	@Excel(name="摘要")
	private java.lang.String mediaDetail;
	/**问题化解及对策*/
	@Excel(name="问题化解及对策")
	private java.lang.String mediaMethod;
	/**矛盾纠纷类别*/
	@Excel(name="矛盾纠纷类别")
	private java.lang.String mediaContradictionType;
	/**问题症结*/
	@Excel(name="问题症结")
	private java.lang.String mediaImportant;
	/**目前采取措施*/
	@Excel(name="目前采取措施")
	private java.lang.String mediaMeasure;
	/**取得成效*/
	@Excel(name="取得成效")
	private java.lang.String mediaEffect;
	/**是否上报*/
	@Excel(name="是否上报")
	private java.lang.String mediaIsReport;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String mediaRemark;
	
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
	 *@return: java.util.Date  调解时间
	 */
	@Column(name ="MEDIA_TIME",nullable=false,length=32)
	public java.util.Date getMediaTime(){
		return this.mediaTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  调解时间
	 */
	public void setMediaTime(java.util.Date mediaTime){
		this.mediaTime = mediaTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  甲 当事人姓名
	 */
	@Column(name ="MEDIA_FIRST_NAME",nullable=false,length=32)
	public java.lang.String getMediaFirstName(){
		return this.mediaFirstName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  甲 当事人姓名
	 */
	public void setMediaFirstName(java.lang.String mediaFirstName){
		this.mediaFirstName = mediaFirstName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  甲 证件类型
	 */
	@Column(name ="MEDIA_FIRST_ID_TYPE",nullable=false,length=32)
	public java.lang.String getMediaFirstIdType(){
		return this.mediaFirstIdType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  甲 证件类型
	 */
	public void setMediaFirstIdType(java.lang.String mediaFirstIdType){
		this.mediaFirstIdType = mediaFirstIdType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  甲 证件号码
	 */
	@Column(name ="MEDIA_FIRST_ID_NO",nullable=false,length=32)
	public java.lang.String getMediaFirstIdNo(){
		return this.mediaFirstIdNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  甲 证件号码
	 */
	public void setMediaFirstIdNo(java.lang.String mediaFirstIdNo){
		this.mediaFirstIdNo = mediaFirstIdNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  甲 联系电话
	 */
	@Column(name ="MEDIA_FIRST_TEL",nullable=false,length=32)
	public java.lang.String getMediaFirstTel(){
		return this.mediaFirstTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  甲 联系电话
	 */
	public void setMediaFirstTel(java.lang.String mediaFirstTel){
		this.mediaFirstTel = mediaFirstTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  乙 当事人姓名
	 */
	@Column(name ="MEDIA_SECOND_NAME",nullable=false,length=32)
	public java.lang.String getMediaSecondName(){
		return this.mediaSecondName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  乙 当事人姓名
	 */
	public void setMediaSecondName(java.lang.String mediaSecondName){
		this.mediaSecondName = mediaSecondName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  乙 证件类型
	 */
	@Column(name ="MEDIA_SECOND_ID_TYPE",nullable=false,length=32)
	public java.lang.String getMediaSecondIdType(){
		return this.mediaSecondIdType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  乙 证件类型
	 */
	public void setMediaSecondIdType(java.lang.String mediaSecondIdType){
		this.mediaSecondIdType = mediaSecondIdType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  乙 证件号码
	 */
	@Column(name ="MEDIA_SECOND_ID_NO",nullable=false,length=32)
	public java.lang.String getMediaSecondIdNo(){
		return this.mediaSecondIdNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  乙 证件号码
	 */
	public void setMediaSecondIdNo(java.lang.String mediaSecondIdNo){
		this.mediaSecondIdNo = mediaSecondIdNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  乙 联系电话
	 */
	@Column(name ="MEDIA_SECOND_TEL",nullable=false,length=32)
	public java.lang.String getMediaSecondTel(){
		return this.mediaSecondTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  乙 联系电话
	 */
	public void setMediaSecondTel(java.lang.String mediaSecondTel){
		this.mediaSecondTel = mediaSecondTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  矛盾纠纷原因
	 */
	@Column(name ="MEDIA_REASON",nullable=true,length=32)
	public java.lang.String getMediaReason(){
		return this.mediaReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  矛盾纠纷原因
	 */
	public void setMediaReason(java.lang.String mediaReason){
		this.mediaReason = mediaReason;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  调解结果
	 */
	@Column(name ="MEDIA_RESULT",nullable=true,length=32)
	public java.lang.String getMediaResult(){
		return this.mediaResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  调解结果
	 */
	public void setMediaResult(java.lang.String mediaResult){
		this.mediaResult = mediaResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  摘要
	 */
	@Column(name ="MEDIA_DETAIL",nullable=true,length=32)
	public java.lang.String getMediaDetail(){
		return this.mediaDetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  摘要
	 */
	public void setMediaDetail(java.lang.String mediaDetail){
		this.mediaDetail = mediaDetail;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  问题化解及对策
	 */
	@Column(name ="MEDIA_METHOD",nullable=true,length=32)
	public java.lang.String getMediaMethod(){
		return this.mediaMethod;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  问题化解及对策
	 */
	public void setMediaMethod(java.lang.String mediaMethod){
		this.mediaMethod = mediaMethod;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  矛盾纠纷类别
	 */
	@Column(name ="MEDIA_CONTRADICTION_TYPE",nullable=true,length=32)
	public java.lang.String getMediaContradictionType(){
		return this.mediaContradictionType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  矛盾纠纷类别
	 */
	public void setMediaContradictionType(java.lang.String mediaContradictionType){
		this.mediaContradictionType = mediaContradictionType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  问题症结
	 */
	@Column(name ="MEDIA_IMPORTANT",nullable=true,length=32)
	public java.lang.String getMediaImportant(){
		return this.mediaImportant;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  问题症结
	 */
	public void setMediaImportant(java.lang.String mediaImportant){
		this.mediaImportant = mediaImportant;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  目前采取措施
	 */
	@Column(name ="MEDIA_MEASURE",nullable=true,length=32)
	public java.lang.String getMediaMeasure(){
		return this.mediaMeasure;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  目前采取措施
	 */
	public void setMediaMeasure(java.lang.String mediaMeasure){
		this.mediaMeasure = mediaMeasure;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  取得成效
	 */
	@Column(name ="MEDIA_EFFECT",nullable=true,length=32)
	public java.lang.String getMediaEffect(){
		return this.mediaEffect;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  取得成效
	 */
	public void setMediaEffect(java.lang.String mediaEffect){
		this.mediaEffect = mediaEffect;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否上报
	 */
	@Column(name ="MEDIA_IS_REPORT",nullable=true,length=32)
	public java.lang.String getMediaIsReport(){
		return this.mediaIsReport;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否上报
	 */
	public void setMediaIsReport(java.lang.String mediaIsReport){
		this.mediaIsReport = mediaIsReport;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="MEDIA_REMARK",nullable=true,length=32)
	public java.lang.String getMediaRemark(){
		return this.mediaRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setMediaRemark(java.lang.String mediaRemark){
		this.mediaRemark = mediaRemark;
	}
}
