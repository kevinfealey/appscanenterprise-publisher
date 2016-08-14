//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.01.29 at 05:53:35 PM EST 
//


package com.aspectsecurity.automationservices.appscanenterprise.jaxb.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Represents a collection of issues (basic-issue (non-security), or security-issue)
 * 
 * <p>Java class for Issues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Issues">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="basic-issue" type="{http://www.ibm.com/Rational/AppScanEnterprise}BasicIssue" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="security-issue" type="{http://www.ibm.com/Rational/AppScanEnterprise}SecurityIssue" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Issues", propOrder = {
    "basicIssue",
    "securityIssue"
})
public class Issues {

    @XmlElement(name = "basic-issue")
    protected List<BasicIssue> basicIssue;
    @XmlElement(name = "security-issue")
    protected List<SecurityIssue> securityIssue;

    /**
     * Gets the value of the basicIssue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the basicIssue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBasicIssue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BasicIssue }
     * 
     * 
     */
    public List<BasicIssue> getBasicIssue() {
        if (basicIssue == null) {
            basicIssue = new ArrayList<BasicIssue>();
        }
        return this.basicIssue;
    }

    /**
     * Gets the value of the securityIssue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the securityIssue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSecurityIssue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SecurityIssue }
     * 
     * 
     */
    public List<SecurityIssue> getSecurityIssue() {
        if (securityIssue == null) {
            securityIssue = new ArrayList<SecurityIssue>();
        }
        return this.securityIssue;
    }

}
