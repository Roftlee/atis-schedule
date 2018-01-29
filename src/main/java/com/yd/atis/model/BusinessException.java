/**
 * BusinessException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.yd.atis.model;

public class BusinessException  extends org.apache.axis.AxisFault  implements java.io.Serializable {
    private String[] args;

    private String errorId;

    private String message1;

    private String module;

    public BusinessException() {
    }

    public BusinessException(
           String[] args,
           String errorId,
           String message1,
           String module) {
        this.args = args;
        this.errorId = errorId;
        this.message1 = message1;
        this.module = module;
    }


    /**
     * Gets the args value for this BusinessException.
     *
     * @return args
     */
    public String[] getArgs() {
        return args;
    }


    /**
     * Sets the args value for this BusinessException.
     *
     * @param args
     */
    public void setArgs(String[] args) {
        this.args = args;
    }

    public String getArgs(int i) {
        return this.args[i];
    }

    public void setArgs(int i, String _value) {
        this.args[i] = _value;
    }


    /**
     * Gets the errorId value for this BusinessException.
     *
     * @return errorId
     */
    public String getErrorId() {
        return errorId;
    }


    /**
     * Sets the errorId value for this BusinessException.
     *
     * @param errorId
     */
    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }


    /**
     * Gets the message1 value for this BusinessException.
     *
     * @return message1
     */
    public String getMessage1() {
        return message1;
    }


    /**
     * Sets the message1 value for this BusinessException.
     *
     * @param message1
     */
    public void setMessage1(String message1) {
        this.message1 = message1;
    }


    /**
     * Gets the module value for this BusinessException.
     *
     * @return module
     */
    public String getModule() {
        return module;
    }


    /**
     * Sets the module value for this BusinessException.
     *
     * @param module
     */
    public void setModule(String module) {
        this.module = module;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof BusinessException)) return false;
        BusinessException other = (BusinessException) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.args==null && other.getArgs()==null) ||
             (this.args!=null &&
              java.util.Arrays.equals(this.args, other.getArgs()))) &&
            ((this.errorId==null && other.getErrorId()==null) ||
             (this.errorId!=null &&
              this.errorId.equals(other.getErrorId()))) &&
            ((this.message1==null && other.getMessage1()==null) ||
             (this.message1!=null &&
              this.message1.equals(other.getMessage1()))) &&
            ((this.module==null && other.getModule()==null) ||
             (this.module!=null &&
              this.module.equals(other.getModule())));
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
        if (getArgs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArgs());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getArgs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getErrorId() != null) {
            _hashCode += getErrorId().hashCode();
        }
        if (getMessage1() != null) {
            _hashCode += getMessage1().hashCode();
        }
        if (getModule() != null) {
            _hashCode += getModule().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BusinessException.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.atis.hisense.com/", "BusinessException"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("args");
        elemField.setXmlName(new javax.xml.namespace.QName("", "args"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "errorId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("module");
        elemField.setXmlName(new javax.xml.namespace.QName("", "module"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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


    /**
     * Writes the exception data to the faultDetails
     */
    public void writeDetails(javax.xml.namespace.QName qname, org.apache.axis.encoding.SerializationContext context) throws java.io.IOException {
        context.serialize(qname, null, this);
    }
}
