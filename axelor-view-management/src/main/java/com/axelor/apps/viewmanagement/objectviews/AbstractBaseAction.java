//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.10.31 at 06:37:00 PM ALMT 
//


package com.axelor.apps.viewmanagement.objectviews;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AbstractBaseAction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractBaseAction"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://axelor.com/xml/ns/object-views}AbstractAction"&gt;
 *       &lt;attribute name="model" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractBaseAction")
@XmlSeeAlso({
    ActionValidate.class,
    ActionCondition.class,
    ActionAttrs.class,
    ActionMethod.class,
    ActionView.class,
    ActionScript.class,
    ActionWS.class,
    ActionImport.class,
    ActionExport.class,
    ActionGroup.class,
    ActionReport.class
})
public class AbstractBaseAction
    extends AbstractAction
{

    @XmlAttribute(name = "model")
    protected String model;

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModel(String value) {
        this.model = value;
    }

}
