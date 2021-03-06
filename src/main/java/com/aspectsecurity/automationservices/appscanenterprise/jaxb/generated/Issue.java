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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.w3c.dom.Element;


/**
 * Issue object.  Not to be instantiated directly.
 * 
 * <p>Java class for Issue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Issue">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ibm.com/Rational/AppScanEnterprise}BaseIssue">
 *       &lt;sequence>
 *         &lt;element name="parent" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="href" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="first-identified" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="last-managed" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="source-jobs" type="{http://www.ibm.com/Rational/AppScanEnterprise}SourceJobs" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Issue", propOrder = {
    "parent",
    "firstIdentified",
    "lastManaged",
    "comment",
    "sourceJobs"
})
@XmlSeeAlso({
    BasicIssue.class,
    SecurityIssue.class
})
public class Issue
    extends BaseIssue
{

    protected Issue.Parent parent;
    @XmlElement(name = "first-identified", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar firstIdentified;
    @XmlElement(name = "last-managed", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastManaged;
    @XmlElement(required = true)
    protected String comment;
    @XmlElement(name = "source-jobs")
    protected SourceJobs sourceJobs;

    /**
     * Gets the value of the parent property.
     * 
     * @return
     *     possible object is
     *     {@link Issue.Parent }
     *     
     */
    public Issue.Parent getParent() {
        return parent;
    }

    /**
     * Sets the value of the parent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Issue.Parent }
     *     
     */
    public void setParent(Issue.Parent value) {
        this.parent = value;
    }

    /**
     * Gets the value of the firstIdentified property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFirstIdentified() {
        return firstIdentified;
    }

    /**
     * Sets the value of the firstIdentified property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFirstIdentified(XMLGregorianCalendar value) {
        this.firstIdentified = value;
    }

    /**
     * Gets the value of the lastManaged property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastManaged() {
        return lastManaged;
    }

    /**
     * Sets the value of the lastManaged property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastManaged(XMLGregorianCalendar value) {
        this.lastManaged = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the sourceJobs property.
     * 
     * @return
     *     possible object is
     *     {@link SourceJobs }
     *     
     */
    public SourceJobs getSourceJobs() {
        return sourceJobs;
    }

    /**
     * Sets the value of the sourceJobs property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceJobs }
     *     
     */
    public void setSourceJobs(SourceJobs value) {
        this.sourceJobs = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="href" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "id",
        "any"
    })
    public static class Parent {

        protected int id;
        @XmlAnyElement(lax = true)
        protected List<Object> any;
        @XmlAttribute(name = "href", required = true)
        protected String href;

        /**
         * Gets the value of the id property.
         * 
         */
        public int getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         */
        public void setId(int value) {
            this.id = value;
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
         * {@link Object }
         * 
         * 
         */
        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
        }

        /**
         * Gets the value of the href property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHref() {
            return href;
        }

        /**
         * Sets the value of the href property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHref(String value) {
            this.href = value;
        }

    }

}
