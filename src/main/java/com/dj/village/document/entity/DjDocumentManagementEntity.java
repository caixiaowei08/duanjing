package com.dj.village.document.entity;

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
 * @Description: 文件管理
 * @author onlineGenerator
 * @date 2015-12-05 13:02:11
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_document_management", schema = "")
@SuppressWarnings("serial")
public class DjDocumentManagementEntity implements java.io.Serializable {
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
	/**文件名称*/
	@Excel(name="文件名称")
	private java.lang.String documentName;
	/**发文单位*/
	@Excel(name="发文单位")
	private java.lang.String documentDept;
	/**发文时间*/
	@Excel(name="发文时间")
	private java.util.Date documentTime;
	/**文号*/
	@Excel(name="文号")
	private java.lang.String documentNo;
	/**责任人*/
	@Excel(name="责任人")
	private java.lang.String documentPerson;
	/**内容摘要*/
	@Excel(name="内容摘要")
	private java.lang.String documentDetail;
	/**保管人*/
	@Excel(name="保管人")
	private java.lang.String documentKeeper;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String documentRemark;
	
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
	 *@return: java.lang.String  文件名称
	 */
	@Column(name ="DOCUMENT_NAME",nullable=false,length=32)
	public java.lang.String getDocumentName(){
		return this.documentName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文件名称
	 */
	public void setDocumentName(java.lang.String documentName){
		this.documentName = documentName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发文单位
	 */
	@Column(name ="DOCUMENT_DEPT",nullable=false,length=32)
	public java.lang.String getDocumentDept(){
		return this.documentDept;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发文单位
	 */
	public void setDocumentDept(java.lang.String documentDept){
		this.documentDept = documentDept;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发文时间
	 */
	@Column(name ="DOCUMENT_TIME",nullable=false,length=32)
	public java.util.Date getDocumentTime(){
		return this.documentTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发文时间
	 */
	public void setDocumentTime(java.util.Date documentTime){
		this.documentTime = documentTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文号
	 */
	@Column(name ="DOCUMENT_NO",nullable=false,length=32)
	public java.lang.String getDocumentNo(){
		return this.documentNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文号
	 */
	public void setDocumentNo(java.lang.String documentNo){
		this.documentNo = documentNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  责任人
	 */
	@Column(name ="DOCUMENT_PERSON",nullable=false,length=32)
	public java.lang.String getDocumentPerson(){
		return this.documentPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  责任人
	 */
	public void setDocumentPerson(java.lang.String documentPerson){
		this.documentPerson = documentPerson;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内容摘要
	 */
	@Column(name ="DOCUMENT_DETAIL",nullable=true,length=32)
	public java.lang.String getDocumentDetail(){
		return this.documentDetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内容摘要
	 */
	public void setDocumentDetail(java.lang.String documentDetail){
		this.documentDetail = documentDetail;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  保管人
	 */
	@Column(name ="DOCUMENT_KEEPER",nullable=false,length=32)
	public java.lang.String getDocumentKeeper(){
		return this.documentKeeper;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  保管人
	 */
	public void setDocumentKeeper(java.lang.String documentKeeper){
		this.documentKeeper = documentKeeper;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="DOCUMENT_REMARK",nullable=true,length=32)
	public java.lang.String getDocumentRemark(){
		return this.documentRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setDocumentRemark(java.lang.String documentRemark){
		this.documentRemark = documentRemark;
	}
}
