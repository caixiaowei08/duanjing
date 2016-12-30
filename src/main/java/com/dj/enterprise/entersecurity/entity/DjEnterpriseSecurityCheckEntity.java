package com.dj.enterprise.entersecurity.entity;

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
 * @Description: 企业安全or消防检查
 * @author onlineGenerator
 * @date 2015-12-06 22:47:39
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_enterprise_security_check", schema = "")
@SuppressWarnings("serial")
public class DjEnterpriseSecurityCheckEntity implements java.io.Serializable {
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
	/**检查时间*/
	@Excel(name="检查时间")
	private java.util.Date enterTime;
	/**安全or消防*/
	@Excel(name="安全or消防")
	private java.lang.String enterType;
	/**检查单位*/
	@Excel(name="检查单位")
	private java.lang.String enterCheckDept;
	/**被检查单位*/
	@Excel(name="被检查单位")
	private java.lang.String enterCheckedDept;
	/**检查人*/
	@Excel(name="检查人")
	private java.lang.String enterChecker;
	/**检查项目*/
	@Excel(name="检查项目")
	private java.lang.String enterItem;
	/**检查情况*/
	@Excel(name="检查情况")
	private java.lang.String enterStatus;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String enterRemark;
	
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
	 *@return: java.util.Date  检查时间
	 */
	@Column(name ="ENTER_TIME",nullable=false,length=32)
	public java.util.Date getEnterTime(){
		return this.enterTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  检查时间
	 */
	public void setEnterTime(java.util.Date enterTime){
		this.enterTime = enterTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  安全or消防
	 */
	@Column(name ="ENTER_TYPE",nullable=false,length=32)
	public java.lang.String getEnterType(){
		return this.enterType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安全or消防
	 */
	public void setEnterType(java.lang.String enterType){
		this.enterType = enterType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  检查单位
	 */
	@Column(name ="ENTER_CHECK_DEPT",nullable=true,length=32)
	public java.lang.String getEnterCheckDept(){
		return this.enterCheckDept;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  检查单位
	 */
	public void setEnterCheckDept(java.lang.String enterCheckDept){
		this.enterCheckDept = enterCheckDept;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  被检查单位
	 */
	@Column(name ="ENTER_CHECKED_DEPT",nullable=false,length=32)
	public java.lang.String getEnterCheckedDept(){
		return this.enterCheckedDept;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  被检查单位
	 */
	public void setEnterCheckedDept(java.lang.String enterCheckedDept){
		this.enterCheckedDept = enterCheckedDept;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  检查人
	 */
	@Column(name ="ENTER_CHECKER",nullable=false,length=32)
	public java.lang.String getEnterChecker(){
		return this.enterChecker;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  检查人
	 */
	public void setEnterChecker(java.lang.String enterChecker){
		this.enterChecker = enterChecker;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  检查项目
	 */
	@Column(name ="ENTER_ITEM",nullable=true,length=32)
	public java.lang.String getEnterItem(){
		return this.enterItem;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  检查项目
	 */
	public void setEnterItem(java.lang.String enterItem){
		this.enterItem = enterItem;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  检查情况
	 */
	@Column(name ="ENTER_STATUS",nullable=true,length=32)
	public java.lang.String getEnterStatus(){
		return this.enterStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  检查情况
	 */
	public void setEnterStatus(java.lang.String enterStatus){
		this.enterStatus = enterStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="ENTER_REMARK",nullable=true,length=32)
	public java.lang.String getEnterRemark(){
		return this.enterRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setEnterRemark(java.lang.String enterRemark){
		this.enterRemark = enterRemark;
	}
}
