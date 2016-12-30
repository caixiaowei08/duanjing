package com.dj.people.localpeoplel01.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 户籍人口
 * @author onlineGenerator
 * @date 2015-12-11 15:17:07
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_people_base", schema = "")
@SuppressWarnings("serial")
public class DjPeopleBaseL01Entity implements java.io.Serializable {
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
	/**英文姓*/
	private java.lang.String lastAme;
	/**英文名*/
	private java.lang.String firstName;
	/**中文姓名*/
	@Excel(name="中文姓名")
	private java.lang.String name;
	/**生日*/
	@Excel(name="生日")
	private java.util.Date birthdate;
	/**证件类型*/
	@Excel(name="证件类型")
	private java.lang.String idType;
	/**证件号码*/
	@Excel(name="证件号码")
	private java.lang.String idNo;
	/**性别*/
	@Excel(name="性别")
	private java.lang.String sex;
	/**出生地*/
	@Excel(name="出生地")
	private java.lang.String birthPlace;
	/**入境时间*/
	private java.util.Date entryTime;
	/**到期时间*/
	private java.util.Date dueTime;
	/**人口来源*/
	private java.lang.String peoType;
	/**国籍*/
	private java.lang.String nationality;
	/**曾用名*/
	@Excel(name="曾用名")
	private java.lang.String usedName;
	/**体征*/
	@Excel(name="体征")
	private java.lang.String sign;
	/**名族*/
	@Excel(name="名族")
	private java.lang.String nation;
	/**身高*/
	@Excel(name="身高")
	private java.lang.String height;
	/**血型*/
	@Excel(name="血型")
	private java.lang.String bloodType;
	/**学历*/
	@Excel(name="学历")
	private java.lang.String degree;
	/**婚姻状况*/
	@Excel(name="婚姻状况")
	private java.lang.String maritalStatus;
	/**配偶姓名*/
	@Excel(name="配偶姓名")
	private java.lang.String spouseName;
	/**人户分离*/
	private java.lang.String pHouse;
	/**座机*/
	@Excel(name="座机")
	private java.lang.String tel;
	/**手机*/
	@Excel(name="手机")
	private java.lang.String phone;
	/**职业*/
	@Excel(name="职业")
	private java.lang.String job;
	/**工作地点*/
	@Excel(name="工作地点")
	private java.lang.String workAddress;
	/**兵役状况*/
	@Excel(name="兵役状况")
	private java.lang.String isArmy;
	/**兵役详情*/
	@Excel(name="兵役详情")
	private java.lang.String armyRemark;
	/**户籍地区*/
	private java.lang.String permanentDistrict;
	/**户籍地址*/
	private java.lang.String permanentAddress;
	/**户籍地区*/
	@Excel(name="户籍地区")
	private java.lang.String districtPerm;
	/**户籍所在村*/
	@Excel(name="户籍所在村")
	private java.lang.String townPerm;
	/**户籍所属宅*/
	@Excel(name="户籍所属宅")
	private java.lang.String villagePerm;
	/**户籍门牌号*/
	@Excel(name="户籍门牌号")
	private java.lang.String roomNoPerm;
	/**现居住地区*/
	private java.lang.String currentDistrict;
	/**现居住地址*/
	private java.lang.String currentAddress;
	/**现居住地区*/
	@Excel(name="现居住地区")
	private java.lang.String districtCurrent;
	/**现居住村*/
	@Excel(name="现居住村")
	private java.lang.String townCurrent;
	/**现居所属宅*/
	@Excel(name="现居所属宅")
	private java.lang.String villageCurrent;
	/**现居门牌号*/
	@Excel(name="现居门牌号")
	private java.lang.String ridgeNoCurrent;
	/**现居楼层*/
	private java.lang.String floorNoCurrent;
	/**现居房间号*/
	private java.lang.String roomNoCurrent;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String remark;
	
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
	 *@return: java.lang.String  英文姓
	 */
	@Column(name ="LAST_AME",nullable=true,length=32)
	public java.lang.String getLastAme(){
		return this.lastAme;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  英文姓
	 */
	public void setLastAme(java.lang.String lastAme){
		this.lastAme = lastAme;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  英文名
	 */
	@Column(name ="FIRST_NAME",nullable=true,length=32)
	public java.lang.String getFirstName(){
		return this.firstName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  英文名
	 */
	public void setFirstName(java.lang.String firstName){
		this.firstName = firstName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  中文姓名
	 */
	@Column(name ="NAME",nullable=false,length=32)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  中文姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  生日
	 */
	@Column(name ="BIRTHDATE",nullable=false,length=32)
	public java.util.Date getBirthdate(){
		return this.birthdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  生日
	 */
	public void setBirthdate(java.util.Date birthdate){
		this.birthdate = birthdate;
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
	@Column(name ="ID_NO",nullable=true,length=50)
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
	 *@return: java.lang.String  出生地
	 */
	@Column(name ="BIRTH_PLACE",nullable=true,length=32)
	public java.lang.String getBirthPlace(){
		return this.birthPlace;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出生地
	 */
	public void setBirthPlace(java.lang.String birthPlace){
		this.birthPlace = birthPlace;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  入境时间
	 */
	@Column(name ="ENTRY_TIME",nullable=true,length=32)
	public java.util.Date getEntryTime(){
		return this.entryTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  入境时间
	 */
	public void setEntryTime(java.util.Date entryTime){
		this.entryTime = entryTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  到期时间
	 */
	@Column(name ="DUE_TIME",nullable=true,length=32)
	public java.util.Date getDueTime(){
		return this.dueTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  到期时间
	 */
	public void setDueTime(java.util.Date dueTime){
		this.dueTime = dueTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  人口来源
	 */
	@Column(name ="PEO_TYPE",nullable=false,length=32)
	public java.lang.String getPeoType(){
		return this.peoType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人口来源
	 */
	public void setPeoType(java.lang.String peoType){
		this.peoType = peoType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  国籍
	 */
	@Column(name ="NATIONALITY",nullable=true,length=32)
	public java.lang.String getNationality(){
		return this.nationality;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  国籍
	 */
	public void setNationality(java.lang.String nationality){
		this.nationality = nationality;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  曾用名
	 */
	@Column(name ="USED_NAME",nullable=true,length=50)
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
	 *@return: java.lang.String  体征
	 */
	@Column(name ="SIGN",nullable=true,length=32)
	public java.lang.String getSign(){
		return this.sign;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  体征
	 */
	public void setSign(java.lang.String sign){
		this.sign = sign;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  名族
	 */
	@Column(name ="NATION",nullable=true,length=32)
	public java.lang.String getNation(){
		return this.nation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名族
	 */
	public void setNation(java.lang.String nation){
		this.nation = nation;
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
	 *@return: java.lang.String  学历
	 */
	@Column(name ="DEGREE",nullable=true,length=32)
	public java.lang.String getDegree(){
		return this.degree;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历
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
	 *@return: java.lang.String  人户分离
	 */
	@Column(name ="P_HOUSE",nullable=true,length=32)
	public java.lang.String getPHouse(){
		return this.pHouse;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人户分离
	 */
	public void setPHouse(java.lang.String pHouse){
		this.pHouse = pHouse;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  座机
	 */
	@Column(name ="TEL",nullable=true,length=32)
	public java.lang.String getTel(){
		return this.tel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  座机
	 */
	public void setTel(java.lang.String tel){
		this.tel = tel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机
	 */
	@Column(name ="PHONE",nullable=true,length=32)
	public java.lang.String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
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
	 *@return: java.lang.String  兵役详情
	 */
	@Column(name ="ARMY_REMARK",nullable=true,length=32)
	public java.lang.String getArmyRemark(){
		return this.armyRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  兵役详情
	 */
	public void setArmyRemark(java.lang.String armyRemark){
		this.armyRemark = armyRemark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户籍地区
	 */
	@Column(name ="PERMANENT_DISTRICT",nullable=true,length=32)
	public java.lang.String getPermanentDistrict(){
		return this.permanentDistrict;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户籍地区
	 */
	public void setPermanentDistrict(java.lang.String permanentDistrict){
		this.permanentDistrict = permanentDistrict;
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
	 *@return: java.lang.String  户籍地区
	 */
	@Column(name ="DISTRICT_PERM",nullable=false,length=32)
	public java.lang.String getDistrictPerm(){
		return this.districtPerm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户籍地区
	 */
	public void setDistrictPerm(java.lang.String districtPerm){
		this.districtPerm = districtPerm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户籍所在村
	 */
	@Column(name ="TOWN_PERM",nullable=false,length=32)
	public java.lang.String getTownPerm(){
		return this.townPerm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户籍所在村
	 */
	public void setTownPerm(java.lang.String townPerm){
		this.townPerm = townPerm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户籍所属宅
	 */
	@Column(name ="VILLAGE_PERM",nullable=false,length=32)
	public java.lang.String getVillagePerm(){
		return this.villagePerm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户籍所属宅
	 */
	public void setVillagePerm(java.lang.String villagePerm){
		this.villagePerm = villagePerm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户籍门牌号
	 */
	@Column(name ="ROOM_NO_PERM",nullable=false,length=32)
	public java.lang.String getRoomNoPerm(){
		return this.roomNoPerm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户籍门牌号
	 */
	public void setRoomNoPerm(java.lang.String roomNoPerm){
		this.roomNoPerm = roomNoPerm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现居住地区
	 */
	@Column(name ="CURRENT_DISTRICT",nullable=true,length=32)
	public java.lang.String getCurrentDistrict(){
		return this.currentDistrict;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现居住地区
	 */
	public void setCurrentDistrict(java.lang.String currentDistrict){
		this.currentDistrict = currentDistrict;
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
	 *@return: java.lang.String  现居住地区
	 */
	@Column(name ="DISTRICT_CURRENT",nullable=false,length=32)
	public java.lang.String getDistrictCurrent(){
		return this.districtCurrent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现居住地区
	 */
	public void setDistrictCurrent(java.lang.String districtCurrent){
		this.districtCurrent = districtCurrent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现居住村
	 */
	@Column(name ="TOWN_CURRENT",nullable=false,length=32)
	public java.lang.String getTownCurrent(){
		return this.townCurrent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现居住村
	 */
	public void setTownCurrent(java.lang.String townCurrent){
		this.townCurrent = townCurrent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现居所属宅
	 */
	@Column(name ="VILLAGE_CURRENT",nullable=false,length=32)
	public java.lang.String getVillageCurrent(){
		return this.villageCurrent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现居所属宅
	 */
	public void setVillageCurrent(java.lang.String villageCurrent){
		this.villageCurrent = villageCurrent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现居门牌号
	 */
	@Column(name ="RIDGE_NO_CURRENT",nullable=false,length=32)
	public java.lang.String getRidgeNoCurrent(){
		return this.ridgeNoCurrent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现居门牌号
	 */
	public void setRidgeNoCurrent(java.lang.String ridgeNoCurrent){
		this.ridgeNoCurrent = ridgeNoCurrent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现居楼层
	 */
	@Column(name ="FLOOR_NO_CURRENT",nullable=true,length=32)
	public java.lang.String getFloorNoCurrent(){
		return this.floorNoCurrent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现居楼层
	 */
	public void setFloorNoCurrent(java.lang.String floorNoCurrent){
		this.floorNoCurrent = floorNoCurrent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现居房间号
	 */
	@Column(name ="ROOM_NO_CURRENT",nullable=true,length=32)
	public java.lang.String getRoomNoCurrent(){
		return this.roomNoCurrent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现居房间号
	 */
	public void setRoomNoCurrent(java.lang.String roomNoCurrent){
		this.roomNoCurrent = roomNoCurrent;
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
