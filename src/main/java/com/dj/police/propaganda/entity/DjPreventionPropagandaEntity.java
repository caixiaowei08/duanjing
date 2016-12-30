package com.dj.police.propaganda.entity;

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
 * @Description: 防范宣传
 * @author onlineGenerator
 * @date 2015-12-07 21:56:27
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_prevention_propaganda", schema = "")
@SuppressWarnings("serial")
public class DjPreventionPropagandaEntity implements java.io.Serializable {
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
	/**责任民警*/
	@Excel(name="责任民警")
	private java.lang.String preveResponPolice;
	/**活动日期*/
	@Excel(name="活动日期")
	private java.util.Date preveTime;
	/**活动地址*/
	@Excel(name="活动地址")
	private java.lang.String preveAddress;
	/**参与人数*/
	@Excel(name="参与人数")
	private java.lang.String preveJoinNum;
	/**开始时间*/
	@Excel(name="开始时间")
	private java.util.Date preveStartTime;
	/**结束时间*/
	@Excel(name="结束时间")
	private java.util.Date preveEndTime;
	/**活动内容*/
	@Excel(name="活动内容")
	private java.lang.String preveDetail;
	/**活动形式*/
	@Excel(name="活动形式")
	private java.lang.String preveType;
	/**发放资料数量*/
	@Excel(name="发放资料数量")
	private java.lang.String preveDocuNum;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String preveRemark;
	
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
	 *@return: java.lang.String  责任民警
	 */
	@Column(name ="PREVE_RESPON_POLICE",nullable=false,length=32)
	public java.lang.String getPreveResponPolice(){
		return this.preveResponPolice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  责任民警
	 */
	public void setPreveResponPolice(java.lang.String preveResponPolice){
		this.preveResponPolice = preveResponPolice;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  活动日期
	 */
	@Column(name ="PREVE_TIME",nullable=false,length=32)
	public java.util.Date getPreveTime(){
		return this.preveTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  活动日期
	 */
	public void setPreveTime(java.util.Date preveTime){
		this.preveTime = preveTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动地址
	 */
	@Column(name ="PREVE_ADDRESS",nullable=false,length=32)
	public java.lang.String getPreveAddress(){
		return this.preveAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动地址
	 */
	public void setPreveAddress(java.lang.String preveAddress){
		this.preveAddress = preveAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参与人数
	 */
	@Column(name ="PREVE_JOIN_NUM",nullable=true,length=32)
	public java.lang.String getPreveJoinNum(){
		return this.preveJoinNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参与人数
	 */
	public void setPreveJoinNum(java.lang.String preveJoinNum){
		this.preveJoinNum = preveJoinNum;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开始时间
	 */
	@Column(name ="PREVE_START_TIME",nullable=false,length=32)
	public java.util.Date getPreveStartTime(){
		return this.preveStartTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开始时间
	 */
	public void setPreveStartTime(java.util.Date preveStartTime){
		this.preveStartTime = preveStartTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  结束时间
	 */
	@Column(name ="PREVE_END_TIME",nullable=false,length=32)
	public java.util.Date getPreveEndTime(){
		return this.preveEndTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  结束时间
	 */
	public void setPreveEndTime(java.util.Date preveEndTime){
		this.preveEndTime = preveEndTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动内容
	 */
	@Column(name ="PREVE_DETAIL",nullable=false,length=32)
	public java.lang.String getPreveDetail(){
		return this.preveDetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动内容
	 */
	public void setPreveDetail(java.lang.String preveDetail){
		this.preveDetail = preveDetail;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动形式
	 */
	@Column(name ="PREVE_TYPE",nullable=true,length=32)
	public java.lang.String getPreveType(){
		return this.preveType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动形式
	 */
	public void setPreveType(java.lang.String preveType){
		this.preveType = preveType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发放资料数量
	 */
	@Column(name ="PREVE_DOCU_NUM",nullable=true,length=32)
	public java.lang.String getPreveDocuNum(){
		return this.preveDocuNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发放资料数量
	 */
	public void setPreveDocuNum(java.lang.String preveDocuNum){
		this.preveDocuNum = preveDocuNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="PREVE_REMARK",nullable=true,length=32)
	public java.lang.String getPreveRemark(){
		return this.preveRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setPreveRemark(java.lang.String preveRemark){
		this.preveRemark = preveRemark;
	}
}
