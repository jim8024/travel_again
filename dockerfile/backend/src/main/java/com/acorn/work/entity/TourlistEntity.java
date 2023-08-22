package com.acorn.work.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "TB_TOURLIST")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TourlistEntity {
    @Id
    @Column(length = 32)
    private String contentid;

    @Column(length = 32)
    private String contenttypeid;


    @Column(length = 100)
    private String title;

    @Column(length = 1000)
    private String addr1;

    @Column(length = 5)
    private String mlevel;

    @Column(length = 5)
    private String areacode;

    @Column(length = 5)
    private String sigungucode;

    @Column(length = 500)
    private String firstimage;

    @Column(length = 65535)
    private String overview;

    @Column(length = 20)
    private String mapx;

    @Column(length = 20)
    private String mapy;
}