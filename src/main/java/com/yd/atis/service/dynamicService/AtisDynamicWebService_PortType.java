/**
 * AtisDynamicWebService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.yd.atis.service.dynamicService;

import com.yd.atis.model.ArriveStationBusEntity;
import com.yd.atis.model.BusinessException;
import com.yd.atis.model.RealTimeInfo;
import com.yd.atis.model.StationInfoEntity;

public interface AtisDynamicWebService_PortType extends java.rmi.Remote {
    public ArriveStationBusEntity[] queryByStationID2(String routeID, String segmentID, String stationID, int arriveLeaveType, String name, String password) throws java.rmi.RemoteException, BusinessException;
    public RealTimeInfo[] queryDetailByRouteID2(String routeID, String stationID, String segmentID, int arriveLeaveType, String name, String password) throws java.rmi.RemoteException, BusinessException;
    public RealTimeInfo[] queryDetailByRouteID(String routeID, String stationID, String segmentID, String name, String password) throws java.rmi.RemoteException, BusinessException;
    public StationInfoEntity[] requireRouteSpeed(String routeID, String name, String password) throws java.rmi.RemoteException, BusinessException;
    public ArriveStationBusEntity[] requireBusPosition(String routeID, String segmentID, String stationID, String name, String password) throws java.rmi.RemoteException, BusinessException;
    public ArriveStationBusEntity[] queryByStationID(String routeID, String segmentID, String stationID, String name, String password) throws java.rmi.RemoteException, BusinessException;
}
