package com.laptrinhjava.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)//thêm listenner của auditing (thêm các trường createdate createdby... tự động)
public abstract class BaseEntity {

//	trường @Id sẽ định nghĩa trường id (dòng tiếp theo) thành PRIMARY KEY và set thành not null trong database table
//	trường @GeneratedValue(strategy = GenerationType.IDENTITY) sẽ tự tăng giá trị cho id tương đương auto_increment trong SQL
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Column(name = "createdate") tương đương với tên table trong Database
	@Column(name = "createdate")
	@CreatedDate //annotation của Auditing để xác định và thêm tự động trường CreatedDate
	private Date createdDate;
	
	@Column(name = "modifieddate")
	@LastModifiedDate //annotation của Auditing để xác định và thêm tự động trường modifiedDate
	private Date modifiedDate;
	
	@Column(name = "createdby")
	@CreatedBy //annotation của Auditing để xác định và thêm tự động trường createdBy
	private String createdBy;
	
	@Column(name = "modifiedby")
	@LastModifiedBy //annotation của Auditing để xác định và thêm tự động trường modifiedBy
	private String modifiedBy;
	
	public Long getId() {
		return id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
}
