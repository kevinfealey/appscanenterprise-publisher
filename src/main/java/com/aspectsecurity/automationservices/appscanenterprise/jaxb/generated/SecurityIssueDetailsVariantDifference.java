//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.01.29 at 05:53:35 PM EST 
//


package com.aspectsecurity.automationservices.appscanenterprise.jaxb.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Describes the differences applied between the original request and the mutated request.
 * 
 * <p>Java class for SecurityIssueDetailsVariantDifference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SecurityIssueDetailsVariantDifference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="request-modifications" type="{http://www.ibm.com/Rational/AppScanEnterprise}SecurityIssueDetailsVariantDifferenceRequestmodifications" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SecurityIssueDetailsVariantDifference", propOrder = {
    "requestModifications"
})
public class SecurityIssueDetailsVariantDifference {

    @XmlElement(name = "request-modifications")
    protected SecurityIssueDetailsVariantDifferenceRequestmodifications requestModifications;

    /**
     * Gets the value of the requestModifications property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityIssueDetailsVariantDifferenceRequestmodifications }
     *     
     */
    public SecurityIssueDetailsVariantDifferenceRequestmodifications getRequestModifications() {
        return requestModifications;
    }

    /**
     * Sets the value of the requestModifications property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityIssueDetailsVariantDifferenceRequestmodifications }
     *     
     */
    public void setRequestModifications(SecurityIssueDetailsVariantDifferenceRequestmodifications value) {
        this.requestModifications = value;
    }

}
