package com.dj.enterprise.enterprise.entity;

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
 * @Description: 企事业单位管理
 * @author onlineGenerator
 * @date 2015-12-06 22:46:44
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_enterprise_manager", schema = "")
@SuppressWarnings("serial")
public class DjEnterpriseManagerEntity implements java.io.Serializable {
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
	/**单位名称*/
	@Excel(name="单位名称")
	private java.lang.String enterName;
	/**单位地址*/
	@Excel(name="单位地址")
	private java.lang.String enterAddress;
	/**法人代表*/
	@Excel(name="法人代表")
	private java.lang.String enterLegalPerson;
	/**法人证件类型*/
	@Excel(name="法人证件类型")
	private java.lang.String idType;
	/**法人证件号*/
	@Excel(name="法人证件号")
	private java.lang.String idNo;
	/**法人电话*/
	@Excel(name="法人电话")
	private java.lang.String enterLegalTel;
	/**常务负责人*/
	@Excel(name="常务负责人")
	private java.lang.String enterRoutineName;
	/**负责人联系电话*/
	@Excel(name="负责人联系电话")
	private java.lang.String enterRoutineTel;
	/**是否合制*/
	@Excel(name="是否合制")
	private java.lang.String enterIsCoProd;
	/**经营项目*/
	@Excel(name="经营项目")
	private java.lang.String enterOperItems;
	/**员工人数*/
	@Excel(name="员工人数")
	private java.lang.String enterNumberEmployee;
	/**签约时间*/
	@Excel(name="签约时间")
	private java.util.Date enterTime;
	/**签约期限*/
	@Excel(name="签约期限")
	private java.lang.String enterDeadlline;
	/**签约人*/
	@Excel(name="签约人")
	private java.lang.String enterContract;
	/**是否消防重点单位*/
	@Excel(name="是否消防重点单位")
	private java.lang.String enterIsFire;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位名称
	 */
	@Column(name ="ENTER_NAME",nullable=false,length=32)
	public java.lang.String getEnterName(){
		return this.enterName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位名称
	 */
	public void setEnterName(java.lang.String enterName){
		this.enterName = enterName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位地址
	 */
	@Column(name ="ENTER_ADDRESS",nullable=false,length=32)
	public java.lang.String getEnterAddress(){
		return this.enterAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位地址
	 */
	public void setEnterAddress(java.lang.String enterAddress){
		this.enterAddress = enterAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  法人代表
	 */
	@Column(name ="ENTER_LEGAL_PERSON",nullable=false,length=32)
	public java.lang.String getEnterLegalPerson(){
		return this.enterLegalPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  法人代表
	 */
	public void setEnterLegalPerson(java.lang.String enterLegalPerson){
		this.enterLegalPerson = enterLegalPerson;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  法人证件类型
	 */
	@Column(name ="ID_TYPE",nullable=false,length=32)
	public java.lang.String getIdType(){
		return this.idType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  法人证件类型
	 */
	public void setIdType(java.lang.String idType){
		this.idType = idType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  法人证件号
	 */
	@Column(name ="ID_NO",nullable=false,length=32)
	public java.lang.String getIdNo(){
		return this.idNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  法人证件号
	 */
	public void setIdNo(java.lang.String idNo){
		this.idNo = idNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  法人电话
	 */
	@Column(name ="ENTER_LEGAL_TEL",nullable=false,length=32)
	public java.lang.String getEnterLegalTel(){
		return this.enterLegalTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  法人电话
	 */
	public void setEnterLegalTel(java.lang.String enterLegalTel){
		this.enterLegalTel = enterLegalTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  常务负责人
	 */
	@Column(name ="ENTER_ROUTINE_NAME",nullable=false,length=32)
	public java.lang.String getEnterRoutineName(){
		return this.enterRoutineName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  常务负责人
	 */
	public void setEnterRoutineName(java.lang.String enterRoutineName){
		this.enterRoutineName = enterRoutineName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  负责人联系电话
	 */
	@Column(name ="ENTER_ROUTINE_TEL",nullable=false,length=32)
	public java.lang.String getEnterRoutineTel(){
		return this.enterRoutineTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  负责人联系电话
	 */
	public void setEnterRoutineTel(java.lang.String enterRoutineTel){
		this.enterRoutineTel = enterRoutineTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否合制
	 */
	@Column(name ="ENTER_IS_CO_PROD",nullable=true,length=32)
	public java.lang.String getEnterIsCoProd(){
		return this.enterIsCoProd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否合制
	 */
	public void setEnterIsCoProd(java.lang.String enterIsCoProd){
		this.enterIsCoProd = enterIsCoProd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  经营项目
	 */
	@Column(name ="ENTER_OPER_ITEMS",nullable=true,length=32)
	public java.lang.String getEnterOperItems(){
		return this.enterOperItems;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  经营项目
	 */
	public void setEnterOperItems(java.lang.String enterOperItems){
		this.enterOperItems = enterOperItems;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  员工人数
	 */
	@Column(name ="ENTER_NUMBER_EMPLOYEE",nullable=true,length=32)
	public java.lang.String getEnterNumberEmployee(){
		return this.enterNumberEmployee;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  员工人数
	 */
	public void setEnterNumberEmployee(java.lang.String enterNumberEmployee){
		this.enterNumberEmployee = enterNumberEmployee;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  签约时间
	 */
	@Column(name ="ENTER_TIME",nullable=true,length=32)
	public java.util.Date getEnterTime(){
		return this.enterTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  签约时间
	 */
	public void setEnterTime(java.util.Date enterTime){
		this.enterTime = enterTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  签约期限
	 */
	@Column(name ="ENTER_DEADLLINE",nullable=true,length=32)
	public java.lang.String getEnterDeadlline(){
		return this.enterDeadlline;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  签约期限
	 */
	public void setEnterDeadlline(java.lang.String enterDeadlline){
		this.enterDeadlline = enterDeadlline;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  签约人
	 */
	@Column(name ="ENTER_CONTRACT",nullable=true,length=32)
	public java.lang.String getEnterContract(){
		return this.enterContract;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  签约人
	 */
	public void setEnterContract(java.lang.String enterContract){
		this.enterContract = enterContract;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否消防重点单位
	 */
	@Column(name ="ENTER_IS_FIRE",nullable=true,length=32)
	public java.lang.String getEnterIsFire(){
		return this.enterIsFire;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否消防重点单位
	 */
	public void setEnterIsFire(java.lang.String enterIsFire){
		this.enterIsFire = enterIsFire;
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
