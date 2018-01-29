package com.yd.atis.request.route;

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
public class RouteRequest implements Serializable {

    /**
     * 线路编号
     */
    private String routeId;

    /**
     * 线路名称
     */
    private String routeName;

    /**
     * 站点编号
     */
    private String stationId;
}
