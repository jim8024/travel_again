package com.acorn.work.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PlannerDTO {

    private String planNrego;

    private String memberId;

    private String region;

    private String date;

    private String seq;

}
