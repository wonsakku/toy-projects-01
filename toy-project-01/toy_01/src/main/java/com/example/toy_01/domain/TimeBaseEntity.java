package com.example.toy_01.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public class TimeBaseEntity {

    @CreatedDate
    @Column(name = "created_date_time",updatable = false)
    private LocalDateTime createdDateTime;

    @LastModifiedDate
    @Column(name = "modified_date_time")
    private LocalDateTime modifiedDateTime;



}
