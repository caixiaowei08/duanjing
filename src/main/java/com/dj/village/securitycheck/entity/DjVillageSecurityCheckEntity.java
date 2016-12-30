package com.dj.village.securitycheck.entity;

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
 * @Description: 安全or消防检查
 * @author onlineGenerator
 * @date 2015-12-07 22:20:00
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_village_security_check", schema = "")
@SuppressWarnings("serial")
public class DjVillageSecurityCheckEntity implements java.io.Serializable {
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
	private java.util.Date villaTime;
	/**被检查单位*/
	@Excel(name="被检查单位")
	private java.lang.String villaCheckedDept;
	/**安全or消防*/
	@Excel(name="安全or消防")
	private java.lang.String villaType;
	/**检查项目*/
	@Excel(name="检查项目")
	private java.lang.String villaItem;
	/**检查人*/
	@Excel(name="检查人")
	private java.lang.String villaChecker;
	/**检查情况*/
	@Excel(name="检查情况")
	private java.lang.String villaStatus;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String villaRemark;
	
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
	@Column(name ="VILLA_TIME",nullable=false,length=32)
	public java.util.Date getVillaTime(){
		return this.villaTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  检查时间
	 */
	public void setVillaTime(java.util.Date villaTime){
		this.villaTime = villaTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  被检查单位
	 */
	@Column(name ="VILLA_CHECKED_DEPT",nullable=false,length=32)
	public java.lang.String getVillaCheckedDept(){
		return this.villaCheckedDept;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  被检查单位
	 */
	public void setVillaCheckedDept(java.lang.String villaCheckedDept){
		this.villaCheckedDept = villaCheckedDept;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  安全or消防
	 */
	@Column(name ="VILLA_TYPE",nullable=false,length=32)
	public java.lang.String getVillaType(){
		return this.villaType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安全or消防
	 */
	public void setVillaType(java.lang.String villaType){
		this.villaType = villaType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  检查项目
	 */
	@Column(name ="VILLA_ITEM",nullable=false,length=32)
	public java.lang.String getVillaItem(){
		return this.villaItem;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  检查项目
	 */
	public void setVillaItem(java.lang.String villaItem){
		this.villaItem = villaItem;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  检查人
	 */
	@Column(name ="VILLA_CHECKER",nullable=false,length=32)
	public java.lang.String getVillaChecker(){
		return this.villaChecker;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  检查人
	 */
	public void setVillaChecker(java.lang.String villaChecker){
		this.villaChecker = villaChecker;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  检查情况
	 */
	@Column(name ="VILLA_STATUS",nullable=true,length=32)
	public java.lang.String getVillaStatus(){
		return this.villaStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  检查情况
	 */
	public void setVillaStatus(java.lang.String villaStatus){
		this.villaStatus = villaStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="VILLA_REMARK",nullable=true,length=32)
	public java.lang.String getVillaRemark(){
		return this.villaRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setVillaRemark(java.lang.String villaRemark){
		this.villaRemark = villaRemark;
	}
}
