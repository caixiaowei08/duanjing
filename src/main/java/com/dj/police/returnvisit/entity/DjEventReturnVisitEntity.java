package com.dj.police.returnvisit.entity;

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
 * @Description: 事件回访
 * @author onlineGenerator
 * @date 2015-12-07 21:57:35
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_event_return_visit", schema = "")
@SuppressWarnings("serial")
public class DjEventReturnVisitEntity implements java.io.Serializable {
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
	private java.lang.String returnResponPolice;
	/**回访时间*/
	@Excel(name="回访时间")
	private java.util.Date returnTime;
	/**被回访人姓名*/
	@Excel(name="被回访人姓名")
	private java.lang.String returnName;
	/**证件类型*/
	@Excel(name="证件类型")
	private java.lang.String idType;
	/**证件号码*/
	@Excel(name="证件号码")
	private java.lang.String idNo;
	/**电话*/
	@Excel(name="电话")
	private java.lang.String returnTel;
	/**回访结果*/
	@Excel(name="回访结果")
	private java.lang.String returnResult;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String returnRemark;
	
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
	@Column(name ="RETURN_RESPON_POLICE",nullable=false,length=32)
	public java.lang.String getReturnResponPolice(){
		return this.returnResponPolice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  责任民警
	 */
	public void setReturnResponPolice(java.lang.String returnResponPolice){
		this.returnResponPolice = returnResponPolice;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  回访时间
	 */
	@Column(name ="RETURN_TIME",nullable=false,length=32)
	public java.util.Date getReturnTime(){
		return this.returnTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  回访时间
	 */
	public void setReturnTime(java.util.Date returnTime){
		this.returnTime = returnTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  被回访人姓名
	 */
	@Column(name ="RETURN_NAME",nullable=false,length=32)
	public java.lang.String getReturnName(){
		return this.returnName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  被回访人姓名
	 */
	public void setReturnName(java.lang.String returnName){
		this.returnName = returnName;
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
	@Column(name ="RETURN_TEL",nullable=true,length=32)
	public java.lang.String getReturnTel(){
		return this.returnTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电话
	 */
	public void setReturnTel(java.lang.String returnTel){
		this.returnTel = returnTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  回访结果
	 */
	@Column(name ="RETURN_RESULT",nullable=true,length=32)
	public java.lang.String getReturnResult(){
		return this.returnResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  回访结果
	 */
	public void setReturnResult(java.lang.String returnResult){
		this.returnResult = returnResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="RETURN_REMARK",nullable=true,length=32)
	public java.lang.String getReturnRemark(){
		return this.returnRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setReturnRemark(java.lang.String returnRemark){
		this.returnRemark = returnRemark;
	}
}
