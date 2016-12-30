package com.dj.renthouse.renthouseinfo.entity;

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
 * @Description: 出租房信息
 * @author onlineGenerator
 * @date 2015-12-08 15:22:36
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_house_info", schema = "")
@SuppressWarnings("serial")
public class DjHouseInfoEntity implements java.io.Serializable {
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
	/**户主姓名*/
	@Excel(name="户主姓名")
	private java.lang.String name;
	/**证件类型*/
	@Excel(name="证件类型")
	private java.lang.String idType;
	/**证件号码*/
	@Excel(name="证件号码")
	private java.lang.String idNum;
	/**房屋所在区*/
	@Excel(name="房屋所在区")
	private java.lang.String district;
	/**房屋所在村*/
	@Excel(name="房屋所在村")
	private java.lang.String town;
	/**房屋所属宅*/
	@Excel(name="房屋所属宅")
	private java.lang.String village;
	/**门牌号*/
	@Excel(name="门牌号")
	private java.lang.String ridgeNo;
	/**房间号*/
	@Excel(name="房间号")
	private java.lang.String roomNo;
	/**楼层*/
	private java.lang.String floorNo;
	/**是否空房*/
	private java.lang.String isNull;
	
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
	 *@return: java.lang.String  户主姓名
	 */
	@Column(name ="NAME",nullable=true,length=32)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户主姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
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
	@Column(name ="ID_NUM",nullable=true,length=32)
	public java.lang.String getIdNum(){
		return this.idNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件号码
	 */
	public void setIdNum(java.lang.String idNum){
		this.idNum = idNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房屋所在区
	 */
	@Column(name ="DISTRICT",nullable=false,length=32)
	public java.lang.String getDistrict(){
		return this.district;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房屋所在区
	 */
	public void setDistrict(java.lang.String district){
		this.district = district;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房屋所在村
	 */
	@Column(name ="TOWN",nullable=false,length=32)
	public java.lang.String getTown(){
		return this.town;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房屋所在村
	 */
	public void setTown(java.lang.String town){
		this.town = town;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房屋所属宅
	 */
	@Column(name ="VILLAGE",nullable=false,length=32)
	public java.lang.String getVillage(){
		return this.village;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房屋所属宅
	 */
	public void setVillage(java.lang.String village){
		this.village = village;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  门牌号
	 */
	@Column(name ="RIDGE_NO",nullable=false,length=32)
	public java.lang.String getRidgeNo(){
		return this.ridgeNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  门牌号
	 */
	public void setRidgeNo(java.lang.String ridgeNo){
		this.ridgeNo = ridgeNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间号
	 */
	@Column(name ="ROOM_NO",nullable=false,length=32)
	public java.lang.String getRoomNo(){
		return this.roomNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间号
	 */
	public void setRoomNo(java.lang.String roomNo){
		this.roomNo = roomNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼层
	 */
	@Column(name ="FLOOR_NO",nullable=false,length=32)
	public java.lang.String getFloorNo(){
		return this.floorNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼层
	 */
	public void setFloorNo(java.lang.String floorNo){
		this.floorNo = floorNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否空房
	 */
	@Column(name ="IS_NULL",nullable=false,length=32)
	public java.lang.String getIsNull(){
		return this.isNull;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否空房
	 */
	public void setIsNull(java.lang.String isNull){
		this.isNull = isNull;
	}
}
