package com.dj.village.building.entity;

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
 * @Description: 建房管理
 * @author onlineGenerator
 * @date 2015-12-05 13:22:16
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_building_houses", schema = "")
@SuppressWarnings("serial")
public class DjBuildingHousesEntity implements java.io.Serializable {
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
	/**申请事项*/
	@Excel(name="申请事项")
	private java.lang.String buildAppliItems;
	/**申请时间*/
	@Excel(name="申请时间")
	private java.util.Date buildAppliTime;
	/**材料是否齐全*/
	@Excel(name="材料是否齐全")
	private java.lang.String buildMaterial;
	/**原房屋结构*/
	@Excel(name="原房屋结构")
	private java.lang.String buildOldStruc;
	/**原房屋建筑面积*/
	@Excel(name="原房屋建筑面积")
	private java.lang.String buildOldArea;
	/**现结构*/
	@Excel(name="现结构")
	private java.lang.String buildNewStruc;
	/**现批复面积*/
	@Excel(name="现批复面积")
	private java.lang.String buildNowArea;
	/**建设日期*/
	@Excel(name="建设日期")
	private java.util.Date buildStartTime;
	/**竣工日期*/
	@Excel(name="竣工日期")
	private java.util.Date buildFinishTime;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String buildRemark;
	
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
	 *@return: java.lang.String  申请事项
	 */
	@Column(name ="BUILD_APPLI_ITEMS",nullable=false,length=32)
	public java.lang.String getBuildAppliItems(){
		return this.buildAppliItems;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请事项
	 */
	public void setBuildAppliItems(java.lang.String buildAppliItems){
		this.buildAppliItems = buildAppliItems;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  申请时间
	 */
	@Column(name ="BUILD_APPLI_TIME",nullable=false,length=32)
	public java.util.Date getBuildAppliTime(){
		return this.buildAppliTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  申请时间
	 */
	public void setBuildAppliTime(java.util.Date buildAppliTime){
		this.buildAppliTime = buildAppliTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  材料是否齐全
	 */
	@Column(name ="BUILD_MATERIAL",nullable=false,length=32)
	public java.lang.String getBuildMaterial(){
		return this.buildMaterial;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  材料是否齐全
	 */
	public void setBuildMaterial(java.lang.String buildMaterial){
		this.buildMaterial = buildMaterial;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原房屋结构
	 */
	@Column(name ="BUILD_OLD_STRUC",nullable=true,length=32)
	public java.lang.String getBuildOldStruc(){
		return this.buildOldStruc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原房屋结构
	 */
	public void setBuildOldStruc(java.lang.String buildOldStruc){
		this.buildOldStruc = buildOldStruc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原房屋建筑面积
	 */
	@Column(name ="BUILD_OLD_AREA",nullable=true,length=32)
	public java.lang.String getBuildOldArea(){
		return this.buildOldArea;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原房屋建筑面积
	 */
	public void setBuildOldArea(java.lang.String buildOldArea){
		this.buildOldArea = buildOldArea;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现结构
	 */
	@Column(name ="BUILD_NEW_STRUC",nullable=true,length=32)
	public java.lang.String getBuildNewStruc(){
		return this.buildNewStruc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现结构
	 */
	public void setBuildNewStruc(java.lang.String buildNewStruc){
		this.buildNewStruc = buildNewStruc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现批复面积
	 */
	@Column(name ="BUILD_NOW_AREA",nullable=true,length=32)
	public java.lang.String getBuildNowArea(){
		return this.buildNowArea;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现批复面积
	 */
	public void setBuildNowArea(java.lang.String buildNowArea){
		this.buildNowArea = buildNowArea;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  建设日期
	 */
	@Column(name ="BUILD_START_TIME",nullable=false,length=32)
	public java.util.Date getBuildStartTime(){
		return this.buildStartTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  建设日期
	 */
	public void setBuildStartTime(java.util.Date buildStartTime){
		this.buildStartTime = buildStartTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  竣工日期
	 */
	@Column(name ="BUILD_FINISH_TIME",nullable=false,length=32)
	public java.util.Date getBuildFinishTime(){
		return this.buildFinishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  竣工日期
	 */
	public void setBuildFinishTime(java.util.Date buildFinishTime){
		this.buildFinishTime = buildFinishTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="BUILD_REMARK",nullable=true,length=32)
	public java.lang.String getBuildRemark(){
		return this.buildRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setBuildRemark(java.lang.String buildRemark){
		this.buildRemark = buildRemark;
	}
}
