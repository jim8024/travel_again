package com.acorn.work.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "TB_PLANNER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PlannerEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 32)
    private String planNo;

    @Column(length = 32)
    private String memberId;

    @Column(length = 50)
    private String region;

    @Column(length = 20)
    private String date;

    @Column(length = 10)
    private String seq;

}