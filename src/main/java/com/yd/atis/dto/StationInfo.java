package com.yd.atis.dto;

import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class StationInfo {
    private Integer id;

    private String stationId;

    private String stationNo;

    private String stationName;

    private String aliasName;

    private Double longitude;

    private Double latitude;

    private Byte stationType;

    private Date createdTime;

    private Date updatedTime;
}