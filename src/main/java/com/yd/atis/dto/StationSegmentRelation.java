package com.yd.atis.dto;

import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class StationSegmentRelation {
    private Integer id;

    private String stationId;

    private String stationNo;

    private String routeId;

    private String segmentId;

    private Double sngSerialId;

    private Double dualSerialId;

    private Double distance;

    private String nextStaNo;

    private Double sendSpeed;

    private Date createdTime;

    private Date updatedTime;
}