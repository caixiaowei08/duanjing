package com.dj.member.memberchange.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 党员变动
 * @author onlineGenerator
 * @date 2015-12-04 18:57:33
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_party_member", schema = "")
@SuppressWarnings("serial")
public class MemberChangerEntity implements java.io.Serializable {
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
	/**人员id*/
	private java.lang.Integer pid;
	/**姓名*/
	@Excel(name="姓名")
	private java.lang.String name;
	/**性别*/
	@Excel(name="性别")
	private java.lang.String sex;
	/**证件类型*/
	@Excel(name="证件类型")
	private java.lang.String idType;
	/**证件号码*/
	@Excel(name="证件号码")
	private java.lang.String idNo;
	/**户籍地址*/
	@Excel(name="户籍地址")
	private java.lang.String permanentAddress;
	/**现居住地址*/
	@Excel(name="现居住地址")
	private java.lang.String currentAddress;
	/**文化程度*/
	@Excel(name="文化程度")
	private java.lang.String degree;
	/**工作地点*/
	@Excel(name="工作地点")
	private java.lang.String workAddress;
	/**职业*/
	@Excel(name="职业")
	private java.lang.String job;
	/**婚姻状况*/
	@Excel(name="婚姻状况")
	private java.lang.String maritalStatus;
	/**党员类型*/
	private java.lang.String memberType;
	/**入党时间*/
	private java.util.Date memberJoinPartytIme;
	/**党费缴纳*/
	private java.lang.String memberDues;
	/**联系电话*/
	private java.lang.String memberTel;
	/**申请时间*/
	private java.util.Date memberApplicationDate;
	/**介绍人*/
	private java.lang.String memberIntroducer;
	/**组织批准*/
	private java.lang.String memberApprover;
	/**批准时间*/
	private java.util.Date memberApproveTime;
	/**预备期限*/
	private java.lang.String memberPreparation;
	/**培训情况*/
	private java.lang.String memberTrain;
	/**政治面貌*/
	@Excel(name="政治面貌")
	private java.lang.String memberPoliticalStatus;
	/**变动原因*/
	@Excel(name="变动原因")
	private java.lang.String memberChangeReason;
	/**变动时间*/
	@Excel(name="变动时间")
	private java.util.Date memberChangeTime;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String memberRemark;
	
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  人员id
	 */
	@Column(name ="PID",nullable=false,length=32)
	public java.lang.Integer getPid(){
		return this.pid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  人员id
	 */
	public void setPid(java.lang.Integer pid){
		this.pid = pid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名
	 */
	@Column(name ="NAME",nullable=true,length=32)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
	@Column(name ="SEX",nullable=true,length=32)
	public java.lang.String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(java.lang.String sex){
		this.sex = sex;
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
	 *@return: java.lang.String  户籍地址
	 */
	@Column(name ="PERMANENT_ADDRESS",nullable=true,length=32)
	public java.lang.String getPermanentAddress(){
		return this.permanentAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户籍地址
	 */
	public void setPermanentAddress(java.lang.String permanentAddress){
		this.permanentAddress = permanentAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现居住地址
	 */
	@Column(name ="CURRENT_ADDRESS",nullable=true,length=32)
	public java.lang.String getCurrentAddress(){
		return this.currentAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现居住地址
	 */
	public void setCurrentAddress(java.lang.String currentAddress){
		this.currentAddress = currentAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文化程度
	 */
	@Column(name ="DEGREE",nullable=true,length=32)
	public java.lang.String getDegree(){
		return this.degree;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文化程度
	 */
	public void setDegree(java.lang.String degree){
		this.degree = degree;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作地点
	 */
	@Column(name ="WORK_ADDRESS",nullable=true,length=32)
	public java.lang.String getWorkAddress(){
		return this.workAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作地点
	 */
	public void setWorkAddress(java.lang.String workAddress){
		this.workAddress = workAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职业
	 */
	@Column(name ="JOB",nullable=true,length=32)
	public java.lang.String getJob(){
		return this.job;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职业
	 */
	public void setJob(java.lang.String job){
		this.job = job;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  婚姻状况
	 */
	@Column(name ="MARITAL_STATUS",nullable=true,length=32)
	public java.lang.String getMaritalStatus(){
		return this.maritalStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  婚姻状况
	 */
	public void setMaritalStatus(java.lang.String maritalStatus){
		this.maritalStatus = maritalStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  党员类型
	 */
	@Column(name ="MEMBER_TYPE",nullable=true,length=32)
	public java.lang.String getMemberType(){
		return this.memberType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  党员类型
	 */
	public void setMemberType(java.lang.String memberType){
		this.memberType = memberType;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  入党时间
	 */
	@Column(name ="MEMBER_JOIN_PARTYT_IME",nullable=true,length=32)
	public java.util.Date getMemberJoinPartytIme(){
		return this.memberJoinPartytIme;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  入党时间
	 */
	public void setMemberJoinPartytIme(java.util.Date memberJoinPartytIme){
		this.memberJoinPartytIme = memberJoinPartytIme;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  党费缴纳
	 */
	@Column(name ="MEMBER_DUES",nullable=true,length=32)
	public java.lang.String getMemberDues(){
		return this.memberDues;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  党费缴纳
	 */
	public void setMemberDues(java.lang.String memberDues){
		this.memberDues = memberDues;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */
	@Column(name ="MEMBER_TEL",nullable=true,length=32)
	public java.lang.String getMemberTel(){
		return this.memberTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setMemberTel(java.lang.String memberTel){
		this.memberTel = memberTel;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  申请时间
	 */
	@Column(name ="MEMBER_APPLICATION_DATE",nullable=true,length=32)
	public java.util.Date getMemberApplicationDate(){
		return this.memberApplicationDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  申请时间
	 */
	public void setMemberApplicationDate(java.util.Date memberApplicationDate){
		this.memberApplicationDate = memberApplicationDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  介绍人
	 */
	@Column(name ="MEMBER_INTRODUCER",nullable=true,length=32)
	public java.lang.String getMemberIntroducer(){
		return this.memberIntroducer;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  介绍人
	 */
	public void setMemberIntroducer(java.lang.String memberIntroducer){
		this.memberIntroducer = memberIntroducer;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  组织批准
	 */
	@Column(name ="MEMBER_APPROVER",nullable=true,length=32)
	public java.lang.String getMemberApprover(){
		return this.memberApprover;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  组织批准
	 */
	public void setMemberApprover(java.lang.String memberApprover){
		this.memberApprover = memberApprover;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  批准时间
	 */
	@Column(name ="MEMBER_APPROVE_TIME",nullable=true,length=32)
	public java.util.Date getMemberApproveTime(){
		return this.memberApproveTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  批准时间
	 */
	public void setMemberApproveTime(java.util.Date memberApproveTime){
		this.memberApproveTime = memberApproveTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  预备期限
	 */
	@Column(name ="MEMBER_PREPARATION",nullable=true,length=32)
	public java.lang.String getMemberPreparation(){
		return this.memberPreparation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  预备期限
	 */
	public void setMemberPreparation(java.lang.String memberPreparation){
		this.memberPreparation = memberPreparation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  培训情况
	 */
	@Column(name ="MEMBER_TRAIN",nullable=true,length=32)
	public java.lang.String getMemberTrain(){
		return this.memberTrain;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  培训情况
	 */
	public void setMemberTrain(java.lang.String memberTrain){
		this.memberTrain = memberTrain;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  政治面貌
	 */
	@Column(name ="MEMBER_POLITICAL_STATUS",nullable=true,length=32)
	public java.lang.String getMemberPoliticalStatus(){
		return this.memberPoliticalStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  政治面貌
	 */
	public void setMemberPoliticalStatus(java.lang.String memberPoliticalStatus){
		this.memberPoliticalStatus = memberPoliticalStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  变动原因
	 */
	@Column(name ="MEMBER_CHANGE_REASON",nullable=true,length=32)
	public java.lang.String getMemberChangeReason(){
		return this.memberChangeReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  变动原因
	 */
	public void setMemberChangeReason(java.lang.String memberChangeReason){
		this.memberChangeReason = memberChangeReason;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  变动时间
	 */
	@Column(name ="MEMBER_CHANGE_TIME",nullable=true,length=32)
	public java.util.Date getMemberChangeTime(){
		return this.memberChangeTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  变动时间
	 */
	public void setMemberChangeTime(java.util.Date memberChangeTime){
		this.memberChangeTime = memberChangeTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="MEMBER_REMARK",nullable=true,length=32)
	public java.lang.String getMemberRemark(){
		return this.memberRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setMemberRemark(java.lang.String memberRemark){
		this.memberRemark = memberRemark;
	}
}
