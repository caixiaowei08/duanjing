package com.dj.rawdata.people02.entity;

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
 * @Description: 常住人口原始数据
 * @author onlineGenerator
 * @date 2015-12-15 19:46:31
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_raw_data_huzhu_file", schema = "")
@SuppressWarnings("serial")
public class DjRawDataHuzhuFileEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.Integer id;
	/**姓名*/
	@Excel(name="姓名")
	private java.lang.String name;
	/**曾用名*/
	@Excel(name="曾用名")
	private java.lang.String usedName;
	/**证件号码*/
	@Excel(name="证件号码")
	private java.lang.String idNo;
	/**性别*/
	@Excel(name="性别")
	private java.lang.String sex;
	/**出生日期*/
	@Excel(name="出生日期")
	private java.lang.String birthdate;
	/**民族*/
	@Excel(name="民族")
	private java.lang.String nation;
	/**籍贯*/
	@Excel(name="籍贯")
	private java.lang.String birthPlace;
	/**血型*/
	@Excel(name="血型")
	private java.lang.String bloodType;
	/**身高*/
	@Excel(name="身高")
	private java.lang.String height;
	/**文化程度*/
	@Excel(name="文化程度")
	private java.lang.String degree;
	/**婚姻状况*/
	@Excel(name="婚姻状况")
	private java.lang.String maritalStatus;
	/**工作单位*/
	@Excel(name="工作单位")
	private java.lang.String workAddress;
	/**配偶姓名*/
	@Excel(name="配偶姓名")
	private java.lang.String spouseName;
	/**宗教信仰*/
	@Excel(name="宗教信仰")
	private java.lang.String aaa;
	/**居住地派出所*/
	@Excel(name="居住地派出所")
	private java.lang.String bbb;
	/**兵役状况*/
	@Excel(name="兵役状况")
	private java.lang.String isArmy;
	/**户籍地行政区划*/
	@Excel(name="户籍地行政区划")
	private java.lang.String permanentDistrict;
	/**户籍地址*/
	@Excel(name="户籍地址")
	private java.lang.String permanentAddress;
	/**居住地行政区划*/
	@Excel(name="居住地行政区划")
	private java.lang.String currentDistrict;
	/**居住地址*/
	@Excel(name="居住地址")
	private java.lang.String currentAddress;
	/**证件种类*/
	@Excel(name="证件种类")
	private java.lang.String idType;
	
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
	 *@return: java.lang.String  曾用名
	 */
	@Column(name ="USED_NAME",nullable=true,length=32)
	public java.lang.String getUsedName(){
		return this.usedName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  曾用名
	 */
	public void setUsedName(java.lang.String usedName){
		this.usedName = usedName;
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
	 *@return: java.lang.String  出生日期
	 */
	@Column(name ="BIRTHDATE",nullable=true,length=32)
	public java.lang.String getBirthdate(){
		return this.birthdate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出生日期
	 */
	public void setBirthdate(java.lang.String birthdate){
		this.birthdate = birthdate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  民族
	 */
	@Column(name ="NATION",nullable=true,length=32)
	public java.lang.String getNation(){
		return this.nation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  民族
	 */
	public void setNation(java.lang.String nation){
		this.nation = nation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  籍贯
	 */
	@Column(name ="BIRTH_PLACE",nullable=true,length=32)
	public java.lang.String getBirthPlace(){
		return this.birthPlace;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  籍贯
	 */
	public void setBirthPlace(java.lang.String birthPlace){
		this.birthPlace = birthPlace;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  血型
	 */
	@Column(name ="BLOOD_TYPE",nullable=true,length=32)
	public java.lang.String getBloodType(){
		return this.bloodType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  血型
	 */
	public void setBloodType(java.lang.String bloodType){
		this.bloodType = bloodType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身高
	 */
	@Column(name ="HEIGHT",nullable=true,length=32)
	public java.lang.String getHeight(){
		return this.height;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身高
	 */
	public void setHeight(java.lang.String height){
		this.height = height;
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
	 *@return: java.lang.String  工作单位
	 */
	@Column(name ="WORK_ADDRESS",nullable=true,length=32)
	public java.lang.String getWorkAddress(){
		return this.workAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作单位
	 */
	public void setWorkAddress(java.lang.String workAddress){
		this.workAddress = workAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  配偶姓名
	 */
	@Column(name ="SPOUSE_NAME",nullable=true,length=32)
	public java.lang.String getSpouseName(){
		return this.spouseName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  配偶姓名
	 */
	public void setSpouseName(java.lang.String spouseName){
		this.spouseName = spouseName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  宗教信仰
	 */
	@Column(name ="AAA",nullable=true,length=32)
	public java.lang.String getAaa(){
		return this.aaa;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  宗教信仰
	 */
	public void setAaa(java.lang.String aaa){
		this.aaa = aaa;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  居住地派出所
	 */
	@Column(name ="BBB",nullable=true,length=32)
	public java.lang.String getBbb(){
		return this.bbb;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  居住地派出所
	 */
	public void setBbb(java.lang.String bbb){
		this.bbb = bbb;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  兵役状况
	 */
	@Column(name ="IS_ARMY",nullable=true,length=32)
	public java.lang.String getIsArmy(){
		return this.isArmy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  兵役状况
	 */
	public void setIsArmy(java.lang.String isArmy){
		this.isArmy = isArmy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户籍地行政区划
	 */
	@Column(name ="PERMANENT_DISTRICT",nullable=true,length=32)
	public java.lang.String getPermanentDistrict(){
		return this.permanentDistrict;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户籍地行政区划
	 */
	public void setPermanentDistrict(java.lang.String permanentDistrict){
		this.permanentDistrict = permanentDistrict;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户籍地址
	 */
	@Column(name ="PERMANENT_ADDRESS",nullable=true,length=60)
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
	 *@return: java.lang.String  居住地行政区划
	 */
	@Column(name ="CURRENT_DISTRICT",nullable=true,length=32)
	public java.lang.String getCurrentDistrict(){
		return this.currentDistrict;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  居住地行政区划
	 */
	public void setCurrentDistrict(java.lang.String currentDistrict){
		this.currentDistrict = currentDistrict;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  居住地址
	 */
	@Column(name ="CURRENT_ADDRESS",nullable=true,length=60)
	public java.lang.String getCurrentAddress(){
		return this.currentAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  居住地址
	 */
	public void setCurrentAddress(java.lang.String currentAddress){
		this.currentAddress = currentAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件种类
	 */
	@Column(name ="ID_TYPE",nullable=true,length=32)
	public java.lang.String getIdType(){
		return this.idType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件种类
	 */
	public void setIdType(java.lang.String idType){
		this.idType = idType;
	}
}
