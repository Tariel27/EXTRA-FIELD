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
 * <p>Java class for Panel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Panel"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://axelor.com/xml/ns/object-views}AbstractPanel"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="menu" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="item" type="{http://axelor.com/xml/ns/object-views}MenubarMenuItem" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;group ref="{http://axelor.com/xml/ns/object-views}PanelItems" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="canCollapse" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="collapseIf" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="icon" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="icon-background" type="{http://axelor.com/xml/ns/object-views}ColorStyle" /&gt;
 *       &lt;anyAttribute processContents='skip'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Panel", propOrder = {
    "menu",
    "panelItems"
})
public class Panel
    extends AbstractPanel
{

    protected Menu menu;
    @XmlElements({
        @XmlElement(name = "myElement", type = MyElement.class),
        @XmlElement(name = "field", type = PanelField.class),
        @XmlElement(name = "label", type = Label.class),
        @XmlElement(name = "help", type = Help.class),
        @XmlElement(name = "static", type = Static.class),
        @XmlElement(name = "spacer", type = Spacer.class),
        @XmlElement(name = "separator", type = Separator.class),
        @XmlElement(name = "button", type = Button.class),
        @XmlElement(name = "button-group", type = ExtendForm.Replace.ButtonGroup.class),
        @XmlElement(name = "panel", type = ExtendForm.Replace.Panel.class),
        @XmlElement(name = "panel-related", type = PanelRelated.class),
        @XmlElement(name = "panel-dashlet", type = PanelDashlet.class),
        @XmlElement(name = "panel-include", type = FormInclude.class)
    })
    protected List<AbstractWidget> panelItems;
    @XmlAttribute(name = "canCollapse")
    protected Boolean canCollapse;
    @XmlAttribute(name = "collapseIf")
    protected String collapseIf;
    @XmlAttribute(name = "icon")
    protected String icon;
    @XmlAttribute(name = "icon-background")
    protected String iconBackground;

    /**
     * Gets the value of the menu property.
     * 
     * @return
     *     possible object is
     *     {@link Menu }
     *     
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * Sets the value of the menu property.
     * 
     * @param value
     *     allowed object is
     *     {@link Menu }
     *     
     */
    public void setMenu(Menu value) {
        this.menu = value;
    }

    /**
     * Gets the value of the panelItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the panelItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPanelItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PanelField }
     * {@link Label }
     * {@link Help }
     * {@link Static }
     * {@link Spacer }
     * {@link Separator }
     * {@link Button }
     * {@link ExtendForm.Replace.ButtonGroup }
     * {@link ExtendForm.Replace.Panel }
     * {@link PanelRelated }
     * {@link PanelDashlet }
     * {@link FormInclude }
     * 
     * 
     */
    public List<AbstractWidget> getPanelItems() {
        if (panelItems == null) {
            panelItems = new ArrayList<AbstractWidget>();
        }
        return this.panelItems;
    }

    /**
     * Gets the value of the canCollapse property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanCollapse() {
        return canCollapse;
    }

    /**
     * Sets the value of the canCollapse property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanCollapse(Boolean value) {
        this.canCollapse = value;
    }

    /**
     * Gets the value of the collapseIf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollapseIf() {
        return collapseIf;
    }

    /**
     * Sets the value of the collapseIf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollapseIf(String value) {
        this.collapseIf = value;
    }

    /**
     * Gets the value of the icon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Sets the value of the icon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIcon(String value) {
        this.icon = value;
    }

    /**
     * Gets the value of the iconBackground property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIconBackground() {
        return iconBackground;
    }

    /**
     * Sets the value of the iconBackground property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIconBackground(String value) {
        this.iconBackground = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="item" type="{http://axelor.com/xml/ns/object-views}MenubarMenuItem" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "item"
    })
    public static class Menu {

        @XmlElement(required = true)
        protected List<MenubarMenuItem> item;

        /**
         * Gets the value of the item property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the item property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MenubarMenuItem }
         * 
         * 
         */
        public List<MenubarMenuItem> getItem() {
            if (item == null) {
                item = new ArrayList<MenubarMenuItem>();
            }
            return this.item;
        }

    }

}
