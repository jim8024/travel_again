package com.acorn.work.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "TB_JJIM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JjimEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 32)
    private String jjimId;

    @Column(length = 32)
    private String memberId;

    @Column(length = 10)
    private String recommend_tourlistno;

    @Column(length = 10)
    private String add_tourlistno;
}