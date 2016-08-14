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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * A collection of correlated issues (either static or dynamic).  The collection will contain all of the same type.
 * 
 * <p>Java class for SecurityIssueDetailsCorrelatedIssues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SecurityIssueDetailsCorrelatedIssues">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="correlated-static-issue" type="{http://www.ibm.com/Rational/AppScanEnterprise}CorrelatedStaticIssue" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="correlated-dynamic-issue" type="{http://www.ibm.com/Rational/AppScanEnterprise}CorrelatedDynamicIssue" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SecurityIssueDetailsCorrelatedIssues", propOrder = {
    "correlatedStaticIssueAndCorrelatedDynamicIssue"
})
public class SecurityIssueDetailsCorrelatedIssues {

    @XmlElements({
        @XmlElement(name = "correlated-static-issue", type = CorrelatedStaticIssue.class),
        @XmlElement(name = "correlated-dynamic-issue", type = CorrelatedDynamicIssue.class)
    })
    protected List<BaseIssue> correlatedStaticIssueAndCorrelatedDynamicIssue;

    /**
     * Gets the value of the correlatedStaticIssueAndCorrelatedDynamicIssue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the correlatedStaticIssueAndCorrelatedDynamicIssue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCorrelatedStaticIssueAndCorrelatedDynamicIssue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CorrelatedStaticIssue }
     * {@link CorrelatedDynamicIssue }
     * 
     * 
     */
    public List<BaseIssue> getCorrelatedStaticIssueAndCorrelatedDynamicIssue() {
        if (correlatedStaticIssueAndCorrelatedDynamicIssue == null) {
            correlatedStaticIssueAndCorrelatedDynamicIssue = new ArrayList<BaseIssue>();
        }
        return this.correlatedStaticIssueAndCorrelatedDynamicIssue;
    }

}
