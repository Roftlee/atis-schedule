/**
 * BusLastPositionDataEntity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.yd.atis.model;

public class BusLastPositionDataEntity  implements java.io.Serializable {
    private String busID;

    private String cardID;

    private String busSelfID;

    private String productID;

    private int routeID;

    private String routeName;

    private int subRouteID;

    private String subRouteName;

    private String actDatetime;

    private String recDatetime;

    private double longitude;

    private double latitude;

    private double gpsSpeed;

    public BusLastPositionDataEntity() {
    }

    public BusLastPositionDataEntity(
           String busID,
           String cardID,
           String busSelfID,
           String productID,
           int routeID,
           String routeName,
           int subRouteID,
           String subRouteName,
           String actDatetime,
           String recDatetime,
           double longitude,
           double latitude,
           double gpsSpeed) {
           this.busID = busID;
           this.cardID = cardID;
           this.busSelfID = busSelfID;
           this.productID = productID;
           this.routeID = routeID;
           this.routeName = routeName;
           this.subRouteID = subRouteID;
           this.subRouteName = subRouteName;
           this.actDatetime = actDatetime;
           this.recDatetime = recDatetime;
           this.longitude = longitude;
           this.latitude = latitude;
           this.gpsSpeed = gpsSpeed;
    }


    /**
     * Gets the busID value for this BusLastPositionDataEntity.
     * 
     * @return busID
     */
    public String getBusID() {
        return busID;
    }


    /**
     * Sets the busID value for this BusLastPositionDataEntity.
     * 
     * @param busID
     */
    public void setBusID(String busID) {
        this.busID = busID;
    }


    /**
     * Gets the cardID value for this BusLastPositionDataEntity.
     * 
     * @return cardID
     */
    public String getCardID() {
        return cardID;
    }


    /**
     * Sets the cardID value for this BusLastPositionDataEntity.
     * 
     * @param cardID
     */
    public void setCardID(String cardID) {
        this.cardID = cardID;
    }


    /**
     * Gets the busSelfID value for this BusLastPositionDataEntity.
     * 
     * @return busSelfID
     */
    public String getBusSelfID() {
        return busSelfID;
    }


    /**
     * Sets the busSelfID value for this BusLastPositionDataEntity.
     * 
     * @param busSelfID
     */
    public void setBusSelfID(String busSelfID) {
        this.busSelfID = busSelfID;
    }


    /**
     * Gets the productID value for this BusLastPositionDataEntity.
     * 
     * @return productID
     */
    public String getProductID() {
        return productID;
    }


    /**
     * Sets the productID value for this BusLastPositionDataEntity.
     * 
     * @param productID
     */
    public void setProductID(String productID) {
        this.productID = productID;
    }


    /**
     * Gets the routeID value for this BusLastPositionDataEntity.
     * 
     * @return routeID
     */
    public int getRouteID() {
        return routeID;
    }


    /**
     * Sets the routeID value for this BusLastPositionDataEntity.
     * 
     * @param routeID
     */
    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }


    /**
     * Gets the routeName value for this BusLastPositionDataEntity.
     * 
     * @return routeName
     */
    public String getRouteName() {
        return routeName;
    }


    /**
     * Sets the routeName value for this BusLastPositionDataEntity.
     * 
     * @param routeName
     */
    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }


    /**
     * Gets the subRouteID value for this BusLastPositionDataEntity.
     * 
     * @return subRouteID
     */
    public int getSubRouteID() {
        return subRouteID;
    }


    /**
     * Sets the subRouteID value for this BusLastPositionDataEntity.
     * 
     * @param subRouteID
     */
    public void setSubRouteID(int subRouteID) {
        this.subRouteID = subRouteID;
    }


    /**
     * Gets the subRouteName value for this BusLastPositionDataEntity.
     * 
     * @return subRouteName
     */
    public String getSubRouteName() {
        return subRouteName;
    }


    /**
     * Sets the subRouteName value for this BusLastPositionDataEntity.
     * 
     * @param subRouteName
     */
    public void setSubRouteName(String subRouteName) {
        this.subRouteName = subRouteName;
    }


    /**
     * Gets the actDatetime value for this BusLastPositionDataEntity.
     * 
     * @return actDatetime
     */
    public String getActDatetime() {
        return actDatetime;
    }


    /**
     * Sets the actDatetime value for this BusLastPositionDataEntity.
     * 
     * @param actDatetime
     */
    public void setActDatetime(String actDatetime) {
        this.actDatetime = actDatetime;
    }


    /**
     * Gets the recDatetime value for this BusLastPositionDataEntity.
     * 
     * @return recDatetime
     */
    public String getRecDatetime() {
        return recDatetime;
    }


    /**
     * Sets the recDatetime value for this BusLastPositionDataEntity.
     * 
     * @param recDatetime
     */
    public void setRecDatetime(String recDatetime) {
        this.recDatetime = recDatetime;
    }


    /**
     * Gets the longitude value for this BusLastPositionDataEntity.
     * 
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }


    /**
     * Sets the longitude value for this BusLastPositionDataEntity.
     * 
     * @param longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    /**
     * Gets the latitude value for this BusLastPositionDataEntity.
     * 
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }


    /**
     * Sets the latitude value for this BusLastPositionDataEntity.
     * 
     * @param latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }


    /**
     * Gets the gpsSpeed value for this BusLastPositionDataEntity.
     * 
     * @return gpsSpeed
     */
    public double getGpsSpeed() {
        return gpsSpeed;
    }


    /**
     * Sets the gpsSpeed value for this BusLastPositionDataEntity.
     * 
     * @param gpsSpeed
     */
    public void setGpsSpeed(double gpsSpeed) {
        this.gpsSpeed = gpsSpeed;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof BusLastPositionDataEntity)) return false;
        BusLastPositionDataEntity other = (BusLastPositionDataEntity) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.busID==null && other.getBusID()==null) || 
             (this.busID!=null &&
              this.busID.equals(other.getBusID()))) &&
            ((this.cardID==null && other.getCardID()==null) || 
             (this.cardID!=null &&
              this.cardID.equals(other.getCardID()))) &&
            ((this.busSelfID==null && other.getBusSelfID()==null) || 
             (this.busSelfID!=null &&
              this.busSelfID.equals(other.getBusSelfID()))) &&
            ((this.productID==null && other.getProductID()==null) || 
             (this.productID!=null &&
              this.productID.equals(other.getProductID()))) &&
            this.routeID == other.getRouteID() &&
            ((this.routeName==null && other.getRouteName()==null) || 
             (this.routeName!=null &&
              this.routeName.equals(other.getRouteName()))) &&
            this.subRouteID == other.getSubRouteID() &&
            ((this.subRouteName==null && other.getSubRouteName()==null) || 
             (this.subRouteName!=null &&
              this.subRouteName.equals(other.getSubRouteName()))) &&
            ((this.actDatetime==null && other.getActDatetime()==null) || 
             (this.actDatetime!=null &&
              this.actDatetime.equals(other.getActDatetime()))) &&
            ((this.recDatetime==null && other.getRecDatetime()==null) || 
             (this.recDatetime!=null &&
              this.recDatetime.equals(other.getRecDatetime()))) &&
            this.longitude == other.getLongitude() &&
            this.latitude == other.getLatitude() &&
            this.gpsSpeed == other.getGpsSpeed();
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
        if (getBusID() != null) {
            _hashCode += getBusID().hashCode();
        }
        if (getCardID() != null) {
            _hashCode += getCardID().hashCode();
        }
        if (getBusSelfID() != null) {
            _hashCode += getBusSelfID().hashCode();
        }
        if (getProductID() != null) {
            _hashCode += getProductID().hashCode();
        }
        _hashCode += getRouteID();
        if (getRouteName() != null) {
            _hashCode += getRouteName().hashCode();
        }
        _hashCode += getSubRouteID();
        if (getSubRouteName() != null) {
            _hashCode += getSubRouteName().hashCode();
        }
        if (getActDatetime() != null) {
            _hashCode += getActDatetime().hashCode();
        }
        if (getRecDatetime() != null) {
            _hashCode += getRecDatetime().hashCode();
        }
        _hashCode += new Double(getLongitude()).hashCode();
        _hashCode += new Double(getLatitude()).hashCode();
        _hashCode += new Double(getGpsSpeed()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BusLastPositionDataEntity.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.atis.hisense.com/", "busLastPositionDataEntity"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("busID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "busID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cardID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("busSelfID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "busSelfID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("routeID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "routeID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("routeName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "routeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subRouteID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subRouteID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subRouteName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subRouteName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actDatetime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "actDatetime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recDatetime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recDatetime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("longitude");
        elemField.setXmlName(new javax.xml.namespace.QName("", "longitude"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("latitude");
        elemField.setXmlName(new javax.xml.namespace.QName("", "latitude"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gpsSpeed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gpsSpeed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
