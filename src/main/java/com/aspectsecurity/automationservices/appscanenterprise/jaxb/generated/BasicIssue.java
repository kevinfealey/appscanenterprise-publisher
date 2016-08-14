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
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * Represents a basic issue (i.e. broken link, spelling mistake)
 * 
 * <p>Java class for BasicIssue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BasicIssue">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ibm.com/Rational/AppScanEnterprise}Issue">
 *       &lt;sequence>
 *         &lt;element name="issue-details" type="{http://www.ibm.com/Rational/AppScanEnterprise}BasicIssueDetails"/>
 *         &lt;any processContents='skip' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BasicIssue", propOrder = {
    "issueDetails",
    "any"
})
public class BasicIssue
    extends Issue
{

    @XmlElement(name = "issue-details", required = true)
    protected BasicIssueDetails issueDetails;
    @XmlAnyElement
    protected List<Element> any;

    /**
     * Gets the value of the issueDetails property.
     * 
     * @return
     *     possible object is
     *     {@link BasicIssueDetails }
     *     
     */
    public BasicIssueDetails getIssueDetails() {
        return issueDetails;
    }

    /**
     * Sets the value of the issueDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link BasicIssueDetails }
     *     
     */
    public void setIssueDetails(BasicIssueDetails value) {
        this.issueDetails = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * 
     * 
     */
    public List<Element> getAny() {
        if (any == null) {
            any = new ArrayList<Element>();
        }
        return this.any;
    }

}