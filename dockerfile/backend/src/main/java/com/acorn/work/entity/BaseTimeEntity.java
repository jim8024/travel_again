package com.acorn.work.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/*
    이 class클 Entity에서 상속받으면
    생성시간과 수정시간이 자동으로 Table 에 추가된다
*/
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {


    @CreatedDate
    private LocalDateTime localDateTime;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}