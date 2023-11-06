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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PanelTabs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PanelTabs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://axelor.com/xml/ns/object-views}AbstractPanel"&gt;
 *       &lt;choice maxOccurs="unbounded"&gt;
 *         &lt;element name="panel" type="{http://axelor.com/xml/ns/object-views}Panel"/&gt;
 *         &lt;element name="panel-related" type="{http://axelor.com/xml/ns/object-views}PanelRelated"/&gt;
 *         &lt;element name="panel-dashlet" type="{http://axelor.com/xml/ns/object-views}PanelDashlet"/&gt;
 *         &lt;element name="panel-include" type="{http://axelor.com/xml/ns/object-views}FormInclude"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="x-row-height" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;anyAttribute processContents='skip'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PanelTabs", propOrder = {
    "panelOrPanelRelatedOrPanelDashlet"
})
public class PanelTabs
    extends AbstractPanel
{

    @XmlElements({
        @XmlElement(name = "panel", type = Panel.class),
        @XmlElement(name = "panel-related", type = PanelRelated.class),
        @XmlElement(name = "panel-dashlet", type = PanelDashlet.class),
        @XmlElement(name = "panel-include", type = FormInclude.class)
    })
    protected List<AbstractWidget> panelOrPanelRelatedOrPanelDashlet;
    @XmlAttribute(name = "x-row-height")
    protected Integer xRowHeight;

    /**
     * Gets the value of the panelOrPanelRelatedOrPanelDashlet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the panelOrPanelRelatedOrPanelDashlet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPanelOrPanelRelatedOrPanelDashlet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Panel }
     * {@link PanelRelated }
     * {@link PanelDashlet }
     * {@link FormInclude }
     * 
     * 
     */
    public List<AbstractWidget> getPanelOrPanelRelatedOrPanelDashlet() {
        if (panelOrPanelRelatedOrPanelDashlet == null) {
            panelOrPanelRelatedOrPanelDashlet = new ArrayList<AbstractWidget>();
        }
        return this.panelOrPanelRelatedOrPanelDashlet;
    }

    /**
     * Gets the value of the xRowHeight property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getXRowHeight() {
        return xRowHeight;
    }

    /**
     * Sets the value of the xRowHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setXRowHeight(Integer value) {
        this.xRowHeight = value;
    }

}