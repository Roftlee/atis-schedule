package com.yd.atis.request.segment;

import lombok.*;

import java.io.Serializable;

/**
 * @author AsiQue
 * @since :2018.01.15 17:15
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class SegmentRequest implements Serializable {

    /**
     * 线路编号
     */
    private String routeId;

    /**
     * 线路单程编号
     */
    private String segmentId;

    /**
     * 单程名称
     */
    private String sementName;

    /**
     * 站点编号
     */
    private String stationId;
}
