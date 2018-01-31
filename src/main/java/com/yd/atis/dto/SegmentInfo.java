package com.yd.atis.dto;

import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SegmentInfo {
    private Integer id;

    private String segmentId;

    private String routeId;

    private String segmentName;

    private String subRouteId;

    private String subRouteName;

    private Integer runDirection;

    private String fstSendTime;

    private String lstSendTime;

    private Double sngMile;

    private Double sngTime;

    private String fstStationId;

    private String lstStationId;

    private Integer stationNum;

    private String fstStationName;

    private String lstStationName;

    private Date createdTime;

    private Date updatedTime;
}