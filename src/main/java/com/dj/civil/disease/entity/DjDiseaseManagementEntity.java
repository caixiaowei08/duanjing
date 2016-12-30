package com.dj.civil.disease.entity;

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
 * @Description: 重大疾病管理
 * @author onlineGenerator
 * @date 2015-12-05 17:42:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_disease_management", schema = "")
@SuppressWarnings("serial")
public class DjDiseaseManagementEntity implements java.io.Serializable {
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
	/**文化程度*/
	@Excel(name="文化程度")
	private java.lang.String degree;
	/**户籍地址*/
	@Excel(name="户籍地址")
	private java.lang.String permanentAddress;
	/**现居住地址*/
	@Excel(name="现居住地址")
	private java.lang.String currentAddress;
	/**疾病类型*/
	@Excel(name="疾病类型")
	private java.lang.String diseaseType;
	/**疾病名称*/
	@Excel(name="疾病名称")
	private java.lang.String diseaseName;
	/**患病时间*/
	@Excel(name="患病时间")
	private java.util.Date diseaseTime;
	/**是否传染*/
	@Excel(name="是否传染")
	private java.lang.String diseaseIsInfect;
	/**是否隔离*/
	@Excel(name="是否隔离")
	private java.lang.String diseaseIsIsolation;
	/**治疗状况*/
	@Excel(name="治疗状况")
	private java.lang.String diseaseStatus;
	/**是否医保*/
	@Excel(name="是否医保")
	private java.lang.String diseaseIsNsurance;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String diseaseRemark;
	
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
	 *@return: java.lang.String  性别
	 */
	@Column(name ="SEX",nullable=false,length=32)
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
	 *@return: java.lang.String  疾病类型
	 */
	@Column(name ="DISEASE_TYPE",nullable=true,length=32)
	public java.lang.String getDiseaseType(){
		return this.diseaseType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  疾病类型
	 */
	public void setDiseaseType(java.lang.String diseaseType){
		this.diseaseType = diseaseType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  疾病名称
	 */
	@Column(name ="DISEASE_NAME",nullable=false,length=32)
	public java.lang.String getDiseaseName(){
		return this.diseaseName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  疾病名称
	 */
	public void setDiseaseName(java.lang.String diseaseName){
		this.diseaseName = diseaseName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  患病时间
	 */
	@Column(name ="DISEASE_TIME",nullable=false,length=32)
	public java.util.Date getDiseaseTime(){
		return this.diseaseTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  患病时间
	 */
	public void setDiseaseTime(java.util.Date diseaseTime){
		this.diseaseTime = diseaseTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否传染
	 */
	@Column(name ="DISEASE_IS_INFECT",nullable=false,length=32)
	public java.lang.String getDiseaseIsInfect(){
		return this.diseaseIsInfect;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否传染
	 */
	public void setDiseaseIsInfect(java.lang.String diseaseIsInfect){
		this.diseaseIsInfect = diseaseIsInfect;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否隔离
	 */
	@Column(name ="DISEASE_IS_ISOLATION",nullable=false,length=32)
	public java.lang.String getDiseaseIsIsolation(){
		return this.diseaseIsIsolation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否隔离
	 */
	public void setDiseaseIsIsolation(java.lang.String diseaseIsIsolation){
		this.diseaseIsIsolation = diseaseIsIsolation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  治疗状况
	 */
	@Column(name ="DISEASE_STATUS",nullable=true,length=32)
	public java.lang.String getDiseaseStatus(){
		return this.diseaseStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  治疗状况
	 */
	public void setDiseaseStatus(java.lang.String diseaseStatus){
		this.diseaseStatus = diseaseStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否医保
	 */
	@Column(name ="DISEASE_IS_NSURANCE",nullable=false,length=32)
	public java.lang.String getDiseaseIsNsurance(){
		return this.diseaseIsNsurance;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否医保
	 */
	public void setDiseaseIsNsurance(java.lang.String diseaseIsNsurance){
		this.diseaseIsNsurance = diseaseIsNsurance;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="DISEASE_REMARK",nullable=true,length=32)
	public java.lang.String getDiseaseRemark(){
		return this.diseaseRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setDiseaseRemark(java.lang.String diseaseRemark){
		this.diseaseRemark = diseaseRemark;
	}
}
