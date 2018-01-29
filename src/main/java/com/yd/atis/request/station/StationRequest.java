package com.yd.atis.request.station;

import lombok.*;

import java.io.Serializable;

/**
 * @author AsiQue
 * @since :2018.01.15 17:11
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class StationRequest implements Serializable {

    /**
     * 站点ID
     */
    private String stationId;

    /**
     * 站点编号
     */
    private String stationNo;

    /**
     * 本站站点名
     */
    private String stationName;

    /**
     * 线路编号
     */
    private String routeId;

    /**
     * 线路单程编号
     */
    private String segmentId;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;

    /**
     * 经度偏移量
     */
    private Double lonRange;

    /**
     * 纬度偏移量
     */
    private Double latRange;
}
