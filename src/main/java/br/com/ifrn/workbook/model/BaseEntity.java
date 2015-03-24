package br.com.ifrn.workbook.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class BaseEntity<ID> {

	@Column(name = "created_time")
	private Date createdTime;

	@Column(name = "modified_time")
	private Date modifiedTime;

	public Date getCreatedTime() {
		return createdTime;
	}
	
	public Date getModifiedTime() {
		return modifiedTime;
	}

	public abstract ID getId();
	
	@PrePersist
	protected void prePersist() {
		Date now = new Date();
		createdTime  = now;
		modifiedTime = now;
	}
	
	@PreUpdate
	protected void preUpdate() {
		modifiedTime = new Date();
	}

}
