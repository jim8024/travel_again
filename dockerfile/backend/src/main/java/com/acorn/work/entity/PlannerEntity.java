package com.acorn.work.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "TB_PLANNER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class PlannerEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String planNrego;

    @Column(length = 32)
    private String memberId;

    @Column(length = 50)
    private String region;

    @Column(length = 20)
    private String date;

    @Column(length = 10)
    private String seq;

}