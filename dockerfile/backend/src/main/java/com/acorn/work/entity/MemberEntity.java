package com.acorn.work.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "TB_MEMBER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MemberEntity {

    @Id
    @Column(length = 32)
    private String memberId;

    @Column(length = 200)
    private String name;

    @Column(length = 100)
    private String pwd;

    private String birth;

    @Column(length = 1)
    private String gender;

    @Column(length = 100)
    private String phone;

    @Column(length = 100)
    private String email;
}
