package com.example.thecommerce.global.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BasicEntity implements Serializable {

	@CreatedDate
	@Column(nullable = false, length = 20, updatable = false)
	protected LocalDateTime createdAt;

	@LastModifiedDate
	@Column(length = 20)
	protected LocalDateTime updatedAt;


}
