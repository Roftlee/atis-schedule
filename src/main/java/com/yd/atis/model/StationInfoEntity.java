/**
 * StationInfoEntity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.yd.atis.model;

public class StationInfoEntity  implements java.io.Serializable {
    private String stationid;

    private String stationno;

    private String stationname;

    private String aliasname;

    private Double longitude;

    private Double latitude;

    private String segmentid;

    private String segmentname;

    private Double sngserialid;

    private String stationtype;

    private Double dualserialid;

    private Double distance;

    private String routeid;

    private String routename;

    private String currentstationname;

    private String nextStationID;

    private String nextstano;

    private String nextstationname;

    private Double sendspeed;

    private int speedTime;

    private int nextSpeedTime;

    public StationInfoEntity() {
    }

    public StationInfoEntity(
           String stationid,
           String stationno,
           String stationname,
           String aliasname,
           Double longitude,
           Double latitude,
           String segmentid,
           String segmentname,
           Double sngserialid,
           String stationtype,
           Double dualserialid,
           Double distance,
           String routeid,
           String routename,
           String currentstationname,
           String nextStationID,
           String nextstano,
           String nextstationname,
           Double sendspeed,
           int speedTime,
           int nextSpeedTime) {
           this.stationid = stationid;
           this.stationno = stationno;
           this.stationname = stationname;
           this.aliasname = aliasname;
           this.longitude = longitude;
           this.latitude = latitude;
           this.segmentid = segmentid;
           this.segmentname = segmentname;
           this.sngserialid = sngserialid;
           this.stationtype = stationtype;
           this.dualserialid = dualserialid;
           this.distance = distance;
           this.routeid = routeid;
           this.routename = routename;
           this.currentstationname = currentstationname;
           this.nextStationID = nextStationID;
           this.nextstano = nextstano;
           this.nextstationname = nextstationname;
           this.sendspeed = sendspeed;
           this.speedTime = speedTime;
           this.nextSpeedTime = nextSpeedTime;
    }


    /**
     * Gets the stationid value for this StationInfoEntity.
     *
     * @return stationid
     */
    public String getStationid() {
        return stationid;
    }


    /**
     * Sets the stationid value for this StationInfoEntity.
     *
     * @param stationid
     */
    public void setStationid(String stationid) {
        this.stationid = stationid;
    }


    /**
     * Gets the stationno value for this StationInfoEntity.
     *
     * @return stationno
     */
    public String getStationno() {
        return stationno;
    }


    /**
     * Sets the stationno value for this StationInfoEntity.
     *
     * @param stationno
     */
    public void setStationno(String stationno) {
        this.stationno = stationno;
    }


    /**
     * Gets the stationname value for this StationInfoEntity.
     *
     * @return stationname
     */
    public String getStationname() {
        return stationname;
    }


    /**
     * Sets the stationname value for this StationInfoEntity.
     *
     * @param stationname
     */
    public void setStationname(String stationname) {
        this.stationname = stationname;
    }


    /**
     * Gets the aliasname value for this StationInfoEntity.
     *
     * @return aliasname
     */
    public String getAliasname() {
        return aliasname;
    }


    /**
     * Sets the aliasname value for this StationInfoEntity.
     *
     * @param aliasname
     */
    public void setAliasname(String aliasname) {
        this.aliasname = aliasname;
    }


    /**
     * Gets the longitude value for this StationInfoEntity.
     *
     * @return longitude
     */
    public Double getLongitude() {
        return longitude;
    }


    /**
     * Sets the longitude value for this StationInfoEntity.
     *
     * @param longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }


    /**
     * Gets the latitude value for this StationInfoEntity.
     *
     * @return latitude
     */
    public Double getLatitude() {
        return latitude;
    }


    /**
     * Sets the latitude value for this StationInfoEntity.
     *
     * @param latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }


    /**
     * Gets the segmentid value for this StationInfoEntity.
     *
     * @return segmentid
     */
    public String getSegmentid() {
        return segmentid;
    }


    /**
     * Sets the segmentid value for this StationInfoEntity.
     *
     * @param segmentid
     */
    public void setSegmentid(String segmentid) {
        this.segmentid = segmentid;
    }


    /**
     * Gets the segmentname value for this StationInfoEntity.
     *
     * @return segmentname
     */
    public String getSegmentname() {
        return segmentname;
    }


    /**
     * Sets the segmentname value for this StationInfoEntity.
     *
     * @param segmentname
     */
    public void setSegmentname(String segmentname) {
        this.segmentname = segmentname;
    }


    /**
     * Gets the sngserialid value for this StationInfoEntity.
     *
     * @return sngserialid
     */
    public Double getSngserialid() {
        return sngserialid;
    }


    /**
     * Sets the sngserialid value for this StationInfoEntity.
     *
     * @param sngserialid
     */
    public void setSngserialid(Double sngserialid) {
        this.sngserialid = sngserialid;
    }


    /**
     * Gets the stationtype value for this StationInfoEntity.
     *
     * @return stationtype
     */
    public String getStationtype() {
        return stationtype;
    }


    /**
     * Sets the stationtype value for this StationInfoEntity.
     *
     * @param stationtype
     */
    public void setStationtype(String stationtype) {
        this.stationtype = stationtype;
    }


    /**
     * Gets the dualserialid value for this StationInfoEntity.
     *
     * @return dualserialid
     */
    public Double getDualserialid() {
        return dualserialid;
    }


    /**
     * Sets the dualserialid value for this StationInfoEntity.
     *
     * @param dualserialid
     */
    public void setDualserialid(Double dualserialid) {
        this.dualserialid = dualserialid;
    }


    /**
     * Gets the distance value for this StationInfoEntity.
     *
     * @return distance
     */
    public Double getDistance() {
        return distance;
    }


    /**
     * Sets the distance value for this StationInfoEntity.
     *
     * @param distance
     */
    public void setDistance(Double distance) {
        this.distance = distance;
    }


    /**
     * Gets the routeid value for this StationInfoEntity.
     *
     * @return routeid
     */
    public String getRouteid() {
        return routeid;
    }


    /**
     * Sets the routeid value for this StationInfoEntity.
     *
     * @param routeid
     */
    public void setRouteid(String routeid) {
        this.routeid = routeid;
    }


    /**
     * Gets the routename value for this StationInfoEntity.
     *
     * @return routename
     */
    public String getRoutename() {
        return routename;
    }


    /**
     * Sets the routename value for this StationInfoEntity.
     *
     * @param routename
     */
    public void setRoutename(String routename) {
        this.routename = routename;
    }


    /**
     * Gets the currentstationname value for this StationInfoEntity.
     *
     * @return currentstationname
     */
    public String getCurrentstationname() {
        return currentstationname;
    }


    /**
     * Sets the currentstationname value for this StationInfoEntity.
     *
     * @param currentstationname
     */
    public void setCurrentstationname(String currentstationname) {
        this.currentstationname = currentstationname;
    }


    /**
     * Gets the nextStationID value for this StationInfoEntity.
     *
     * @return nextStationID
     */
    public String getNextStationID() {
        return nextStationID;
    }


    /**
     * Sets the nextStationID value for this StationInfoEntity.
     *
     * @param nextStationID
     */
    public void setNextStationID(String nextStationID) {
        this.nextStationID = nextStationID;
    }


    /**
     * Gets the nextstano value for this StationInfoEntity.
     *
     * @return nextstano
     */
    public String getNextstano() {
        return nextstano;
    }


    /**
     * Sets the nextstano value for this StationInfoEntity.
     *
     * @param nextstano
     */
    public void setNextstano(String nextstano) {
        this.nextstano = nextstano;
    }


    /**
     * Gets the nextstationname value for this StationInfoEntity.
     *
     * @return nextstationname
     */
    public String getNextstationname() {
        return nextstationname;
    }


    /**
     * Sets the nextstationname value for this StationInfoEntity.
     *
     * @param nextstationname
     */
    public void setNextstationname(String nextstationname) {
        this.nextstationname = nextstationname;
    }


    /**
     * Gets the sendspeed value for this StationInfoEntity.
     *
     * @return sendspeed
     */
    public Double getSendspeed() {
        return sendspeed;
    }


    /**
     * Sets the sendspeed value for this StationInfoEntity.
     *
     * @param sendspeed
     */
    public void setSendspeed(Double sendspeed) {
        this.sendspeed = sendspeed;
    }


    /**
     * Gets the speedTime value for this StationInfoEntity.
     *
     * @return speedTime
     */
    public int getSpeedTime() {
        return speedTime;
    }


    /**
     * Sets the speedTime value for this StationInfoEntity.
     *
     * @param speedTime
     */
    public void setSpeedTime(int speedTime) {
        this.speedTime = speedTime;
    }


    /**
     * Gets the nextSpeedTime value for this StationInfoEntity.
     *
     * @return nextSpeedTime
     */
    public int getNextSpeedTime() {
        return nextSpeedTime;
    }


    /**
     * Sets the nextSpeedTime value for this StationInfoEntity.
     *
     * @param nextSpeedTime
     */
    public void setNextSpeedTime(int nextSpeedTime) {
        this.nextSpeedTime = nextSpeedTime;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof StationInfoEntity)) return false;
        StationInfoEntity other = (StationInfoEntity) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.stationid==null && other.getStationid()==null) ||
             (this.stationid!=null &&
              this.stationid.equals(other.getStationid()))) &&
            ((this.stationno==null && other.getStationno()==null) ||
             (this.stationno!=null &&
              this.stationno.equals(other.getStationno()))) &&
            ((this.stationname==null && other.getStationname()==null) ||
             (this.stationname!=null &&
              this.stationname.equals(other.getStationname()))) &&
            ((this.aliasname==null && other.getAliasname()==null) ||
             (this.aliasname!=null &&
              this.aliasname.equals(other.getAliasname()))) &&
            ((this.longitude==null && other.getLongitude()==null) ||
             (this.longitude!=null &&
              this.longitude.equals(other.getLongitude()))) &&
            ((this.latitude==null && other.getLatitude()==null) ||
             (this.latitude!=null &&
              this.latitude.equals(other.getLatitude()))) &&
            ((this.segmentid==null && other.getSegmentid()==null) ||
             (this.segmentid!=null &&
              this.segmentid.equals(other.getSegmentid()))) &&
            ((this.segmentname==null && other.getSegmentname()==null) ||
             (this.segmentname!=null &&
              this.segmentname.equals(other.getSegmentname()))) &&
            ((this.sngserialid==null && other.getSngserialid()==null) ||
             (this.sngserialid!=null &&
              this.sngserialid.equals(other.getSngserialid()))) &&
            ((this.stationtype==null && other.getStationtype()==null) ||
             (this.stationtype!=null &&
              this.stationtype.equals(other.getStationtype()))) &&
            ((this.dualserialid==null && other.getDualserialid()==null) ||
             (this.dualserialid!=null &&
              this.dualserialid.equals(other.getDualserialid()))) &&
            ((this.distance==null && other.getDistance()==null) ||
             (this.distance!=null &&
              this.distance.equals(other.getDistance()))) &&
            ((this.routeid==null && other.getRouteid()==null) ||
             (this.routeid!=null &&
              this.routeid.equals(other.getRouteid()))) &&
            ((this.routename==null && other.getRoutename()==null) ||
             (this.routename!=null &&
              this.routename.equals(other.getRoutename()))) &&
            ((this.currentstationname==null && other.getCurrentstationname()==null) ||
             (this.currentstationname!=null &&
              this.currentstationname.equals(other.getCurrentstationname()))) &&
            ((this.nextStationID==null && other.getNextStationID()==null) ||
             (this.nextStationID!=null &&
              this.nextStationID.equals(other.getNextStationID()))) &&
            ((this.nextstano==null && other.getNextstano()==null) ||
             (this.nextstano!=null &&
              this.nextstano.equals(other.getNextstano()))) &&
            ((this.nextstationname==null && other.getNextstationname()==null) ||
             (this.nextstationname!=null &&
              this.nextstationname.equals(other.getNextstationname()))) &&
            ((this.sendspeed==null && other.getSendspeed()==null) ||
             (this.sendspeed!=null &&
              this.sendspeed.equals(other.getSendspeed()))) &&
            this.speedTime == other.getSpeedTime() &&
            this.nextSpeedTime == other.getNextSpeedTime();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getStationid() != null) {
            _hashCode += getStationid().hashCode();
        }
        if (getStationno() != null) {
            _hashCode += getStationno().hashCode();
        }
        if (getStationname() != null) {
            _hashCode += getStationname().hashCode();
        }
        if (getAliasname() != null) {
            _hashCode += getAliasname().hashCode();
        }
        if (getLongitude() != null) {
            _hashCode += getLongitude().hashCode();
        }
        if (getLatitude() != null) {
            _hashCode += getLatitude().hashCode();
        }
        if (getSegmentid() != null) {
            _hashCode += getSegmentid().hashCode();
        }
        if (getSegmentname() != null) {
            _hashCode += getSegmentname().hashCode();
        }
        if (getSngserialid() != null) {
            _hashCode += getSngserialid().hashCode();
        }
        if (getStationtype() != null) {
            _hashCode += getStationtype().hashCode();
        }
        if (getDualserialid() != null) {
            _hashCode += getDualserialid().hashCode();
        }
        if (getDistance() != null) {
            _hashCode += getDistance().hashCode();
        }
        if (getRouteid() != null) {
            _hashCode += getRouteid().hashCode();
        }
        if (getRoutename() != null) {
            _hashCode += getRoutename().hashCode();
        }
        if (getCurrentstationname() != null) {
            _hashCode += getCurrentstationname().hashCode();
        }
        if (getNextStationID() != null) {
            _hashCode += getNextStationID().hashCode();
        }
        if (getNextstano() != null) {
            _hashCode += getNextstano().hashCode();
        }
        if (getNextstationname() != null) {
            _hashCode += getNextstationname().hashCode();
        }
        if (getSendspeed() != null) {
            _hashCode += getSendspeed().hashCode();
        }
        _hashCode += getSpeedTime();
        _hashCode += getNextSpeedTime();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(StationInfoEntity.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.atis.hisense.com/", "stationInfoEntity"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stationid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stationid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stationno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stationno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stationname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stationname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aliasname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "aliasname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("longitude");
        elemField.setXmlName(new javax.xml.namespace.QName("", "longitude"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("latitude");
        elemField.setXmlName(new javax.xml.namespace.QName("", "latitude"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segmentid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segmentid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segmentname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segmentname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sngserialid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sngserialid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stationtype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stationtype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dualserialid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dualserialid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "distance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("routeid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "routeid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("routename");
        elemField.setXmlName(new javax.xml.namespace.QName("", "routename"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currentstationname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "currentstationname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nextStationID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nextStationID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nextstano");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nextstano"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nextstationname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nextstationname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendspeed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sendspeed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("speedTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "speedTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nextSpeedTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nextSpeedTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
