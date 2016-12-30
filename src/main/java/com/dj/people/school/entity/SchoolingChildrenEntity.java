package com.dj.people.school.entity;

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
 * @Description: 子女就学
 * @author onlineGenerator
 * @date 2015-11-25 16:47:38
 * @version V1.0   
 *
 */
@Entity
@Table(name = "schooling_children", schema = "")
@SuppressWarnings("serial")
public class SchoolingChildrenEntity implements java.io.Serializable {
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
	@Excel(name="人员id")
	private java.lang.Integer pid;
	/**证件类型*/
	@Excel(name="证件类型")
	private java.lang.String idType;
	/**证件号码*/
	@Excel(name="证件号码")
	private java.lang.String idNo;
	/**姓名*/
	@Excel(name="姓名")
	private java.lang.String name;
	/**监护证件类型*/
	@Excel(name="监护证件类型")
	private java.lang.String guardianIdType;
	/**监护证件号码*/
	@Excel(name="监护证件号码")
	private java.lang.String guardianIdNo;
	/**监护人编号*/
	@Excel(name="监护人编号")
	private java.lang.Integer guardianId;
	/**监护人*/
	@Excel(name="监护人")
	private java.lang.String guardianName;
	/**与监护人的关系*/
	@Excel(name="与监护人的关系")
	private java.lang.String guardianRelationship;
	/**入学时间*/
	@Excel(name="入学时间")
	private java.util.Date entranceTime;
	/**学校名称*/
	@Excel(name="学校名称")
	private java.lang.String schoolName;
	/**学校类型*/
	@Excel(name="学校类型")
	private java.lang.String schoolType;
	/**学校地址*/
	@Excel(name="学校地址")
	private java.lang.String schoolAddress;
	/**学校电话*/
	@Excel(name="学校电话")
	private java.lang.String schoolTel;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String remark;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ID",nullable=false,length=20)
	public java.lang.Integer getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
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
	 *@return: java.lang.String  证件类型
	 */
	@Column(name ="ID_TYPE",nullable=true,length=32)
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
	@Column(name ="ID_NO",nullable=true,length=32)
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
	 *@return: java.lang.String  姓名
	 */
	@Column(name ="NAME",nullable=false,length=32)
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
	 *@return: java.lang.String  监护证件类型
	 */
	@Column(name ="GUARDIAN_ID_TYPE",nullable=true,length=32)
	public java.lang.String getGuardianIdType(){
		return this.guardianIdType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  监护证件类型
	 */
	public void setGuardianIdType(java.lang.String guardianIdType){
		this.guardianIdType = guardianIdType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  监护证件号码
	 */
	@Column(name ="GUARDIAN_ID_NO",nullable=true,length=32)
	public java.lang.String getGuardianIdNo(){
		return this.guardianIdNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  监护证件号码
	 */
	public void setGuardianIdNo(java.lang.String guardianIdNo){
		this.guardianIdNo = guardianIdNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  监护人编号
	 */
	@Column(name ="GUARDIAN_ID",nullable=true,length=32)
	public java.lang.Integer getGuardianId(){
		return this.guardianId;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  监护人编号
	 */
	public void setGuardianId(java.lang.Integer guardianId){
		this.guardianId = guardianId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  监护人
	 */
	@Column(name ="GUARDIAN_NAME",nullable=true,length=32)
	public java.lang.String getGuardianName(){
		return this.guardianName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  监护人
	 */
	public void setGuardianName(java.lang.String guardianName){
		this.guardianName = guardianName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  与监护人的关系
	 */
	@Column(name ="GUARDIAN_RELATIONSHIP",nullable=true,length=32)
	public java.lang.String getGuardianRelationship(){
		return this.guardianRelationship;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  与监护人的关系
	 */
	public void setGuardianRelationship(java.lang.String guardianRelationship){
		this.guardianRelationship = guardianRelationship;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入学时间
	 */
	//@Column(name ="ENTRANCE_TIME",nullable=true,length=32)
	@Column(name ="ENTRANCE_TIME",nullable=true,length=20)
	public java.util.Date getEntranceTime(){
		return this.entranceTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入学时间
	 */
	public void setEntranceTime(java.util.Date entranceTime){
		this.entranceTime = entranceTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学校名称
	 */
	@Column(name ="SCHOOL_NAME",nullable=false,length=32)
	public java.lang.String getSchoolName(){
		return this.schoolName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学校名称
	 */
	public void setSchoolName(java.lang.String schoolName){
		this.schoolName = schoolName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学校类型
	 */
	@Column(name ="SCHOOL_TYPE",nullable=true,length=32)
	public java.lang.String getSchoolType(){
		return this.schoolType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学校类型
	 */
	public void setSchoolType(java.lang.String schoolType){
		this.schoolType = schoolType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学校地址
	 */
	@Column(name ="SCHOOL_ADDRESS",nullable=true,length=32)
	public java.lang.String getSchoolAddress(){
		return this.schoolAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学校地址
	 */
	public void setSchoolAddress(java.lang.String schoolAddress){
		this.schoolAddress = schoolAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学校电话
	 */
	@Column(name ="SCHOOL_TEL",nullable=true,length=32)
	public java.lang.String getSchoolTel(){
		return this.schoolTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学校电话
	 */
	public void setSchoolTel(java.lang.String schoolTel){
		this.schoolTel = schoolTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,length=32)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
}
