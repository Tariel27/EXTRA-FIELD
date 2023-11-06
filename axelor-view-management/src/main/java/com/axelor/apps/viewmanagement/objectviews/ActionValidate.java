//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.10.31 at 06:37:00 PM ALMT 
//


package com.axelor.apps.viewmanagement.objectviews;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActionValidate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActionValidate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://axelor.com/xml/ns/object-views}AbstractBaseAction"&gt;
 *       &lt;choice maxOccurs="unbounded"&gt;
 *         &lt;element name="error" type="{http://axelor.com/xml/ns/object-views}ActError"/&gt;
 *         &lt;element name="alert" type="{http://axelor.com/xml/ns/object-views}ActMessage"/&gt;
 *         &lt;element name="info" type="{http://axelor.com/xml/ns/object-views}ActInfo"/&gt;
 *         &lt;element name="notify" type="{http://axelor.com/xml/ns/object-views}ActNotify"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActionValidate", propOrder = {
    "errorOrAlertOrInfo"
})
public class ActionValidate
    extends AbstractBaseAction
{

    @XmlElements({
        @XmlElement(name = "error", type = ActError.class),
        @XmlElement(name = "alert"),
        @XmlElement(name = "info", type = ActInfo.class),
        @XmlElement(name = "notify", type = ActNotify.class)
    })
    protected List<ActMessage> errorOrAlertOrInfo;

    /**
     * Gets the value of the errorOrAlertOrInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the errorOrAlertOrInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErrorOrAlertOrInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActError }
     * {@link ActMessage }
     * {@link ActInfo }
     * {@link ActNotify }
     * 
     * 
     */
    public List<ActMessage> getErrorOrAlertOrInfo() {
        if (errorOrAlertOrInfo == null) {
            errorOrAlertOrInfo = new ArrayList<ActMessage>();
        }
        return this.errorOrAlertOrInfo;
    }

}