package com.dj.village.task.entity;

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
 * @Description: 任务管理
 * @author onlineGenerator
 * @date 2015-12-05 13:00:17
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dj_task_management", schema = "")
@SuppressWarnings("serial")
public class DjTaskManagementEntity implements java.io.Serializable {
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
	/**任务名称*/
	@Excel(name="任务名称")
	private java.lang.String taskName;
	/**发布部门*/
	@Excel(name="发布部门")
	private java.lang.String taskDept;
	/**发布时间*/
	@Excel(name="发布时间")
	private java.util.Date taskReleaseTime;
	/**责任人*/
	@Excel(name="责任人")
	private java.lang.String taskResponsiblePerson;
	/**联系电话*/
	@Excel(name="联系电话")
	private java.lang.String taskTel;
	/**完成日期*/
	@Excel(name="完成日期")
	private java.util.Date taskEndTime;
	/**完成情况*/
	@Excel(name="完成情况")
	private java.lang.String taskDetailInfo;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String taskRemark;
	
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
	 *@return: java.lang.String  任务名称
	 */
	@Column(name ="TASK_NAME",nullable=false,length=32)
	public java.lang.String getTaskName(){
		return this.taskName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  任务名称
	 */
	public void setTaskName(java.lang.String taskName){
		this.taskName = taskName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发布部门
	 */
	@Column(name ="TASK_DEPT",nullable=false,length=32)
	public java.lang.String getTaskDept(){
		return this.taskDept;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发布部门
	 */
	public void setTaskDept(java.lang.String taskDept){
		this.taskDept = taskDept;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发布时间
	 */
	@Column(name ="TASK_RELEASE_TIME",nullable=false,length=32)
	public java.util.Date getTaskReleaseTime(){
		return this.taskReleaseTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发布时间
	 */
	public void setTaskReleaseTime(java.util.Date taskReleaseTime){
		this.taskReleaseTime = taskReleaseTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  责任人
	 */
	@Column(name ="TASK_RESPONSIBLE_PERSON",nullable=false,length=32)
	public java.lang.String getTaskResponsiblePerson(){
		return this.taskResponsiblePerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  责任人
	 */
	public void setTaskResponsiblePerson(java.lang.String taskResponsiblePerson){
		this.taskResponsiblePerson = taskResponsiblePerson;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */
	@Column(name ="TASK_TEL",nullable=false,length=32)
	public java.lang.String getTaskTel(){
		return this.taskTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setTaskTel(java.lang.String taskTel){
		this.taskTel = taskTel;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  完成日期
	 */
	@Column(name ="TASK_END_TIME",nullable=false,length=32)
	public java.util.Date getTaskEndTime(){
		return this.taskEndTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  完成日期
	 */
	public void setTaskEndTime(java.util.Date taskEndTime){
		this.taskEndTime = taskEndTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  完成情况
	 */
	@Column(name ="TASK_DETAIL_INFO",nullable=true,length=32)
	public java.lang.String getTaskDetailInfo(){
		return this.taskDetailInfo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  完成情况
	 */
	public void setTaskDetailInfo(java.lang.String taskDetailInfo){
		this.taskDetailInfo = taskDetailInfo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="TASK_REMARK",nullable=true,length=32)
	public java.lang.String getTaskRemark(){
		return this.taskRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setTaskRemark(java.lang.String taskRemark){
		this.taskRemark = taskRemark;
	}
}
