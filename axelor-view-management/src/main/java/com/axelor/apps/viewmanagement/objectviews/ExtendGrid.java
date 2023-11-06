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
 * <p>Java class for ExtendGrid complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtendGrid"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded"&gt;
 *         &lt;element name="attribute" type="{http://axelor.com/xml/ns/object-views}ExtendAttribute"/&gt;
 *         &lt;element name="insert"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice maxOccurs="unbounded"&gt;
 *                   &lt;group ref="{http://axelor.com/xml/ns/object-views}ExtendGridItems"/&gt;
 *                 &lt;/choice&gt;
 *                 &lt;attribute name="position" use="required" type="{http://axelor.com/xml/ns/object-views}Position" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="replace"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *                   &lt;group ref="{http://axelor.com/xml/ns/object-views}ExtendGridItems"/&gt;
 *                 &lt;/choice&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="move"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;attribute name="source" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="position" use="required" type="{http://axelor.com/xml/ns/object-views}Position" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="target" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="if-feature" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="if-module" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtendGrid", propOrder = {
    "attributeOrInsertOrReplace"
})
public class ExtendGrid {

    @XmlElements({
        @XmlElement(name = "attribute", type = ExtendAttribute.class),
        @XmlElement(name = "insert", type = Insert.class),
        @XmlElement(name = "replace", type = Replace.class),
        @XmlElement(name = "move", type = Move.class)
    })
    protected List<Object> attributeOrInsertOrReplace;
    @XmlAttribute(name = "target", required = true)
    protected String target;
    @XmlAttribute(name = "if-feature")
    protected String ifFeature;
    @XmlAttribute(name = "if-module")
    protected String ifModule;

    /**
     * Gets the value of the attributeOrInsertOrReplace property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attributeOrInsertOrReplace property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributeOrInsertOrReplace().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtendAttribute }
     * {@link Insert }
     * {@link Replace }
     * {@link Move }
     * 
     * 
     */
    public List<Object> getAttributeOrInsertOrReplace() {
        if (attributeOrInsertOrReplace == null) {
            attributeOrInsertOrReplace = new ArrayList<Object>();
        }
        return this.attributeOrInsertOrReplace;
    }

    /**
     * Gets the value of the target property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTarget(String value) {
        this.target = value;
    }

    /**
     * Gets the value of the ifFeature property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIfFeature() {
        return ifFeature;
    }

    /**
     * Sets the value of the ifFeature property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIfFeature(String value) {
        this.ifFeature = value;
    }

    /**
     * Gets the value of the ifModule property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIfModule() {
        return ifModule;
    }

    /**
     * Sets the value of the ifModule property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIfModule(String value) {
        this.ifModule = value;
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
     *       &lt;choice maxOccurs="unbounded"&gt;
     *         &lt;group ref="{http://axelor.com/xml/ns/object-views}ExtendGridItems"/&gt;
     *       &lt;/choice&gt;
     *       &lt;attribute name="position" use="required" type="{http://axelor.com/xml/ns/object-views}Position" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "fieldOrButtonOrToolbar"
    })
    public static class Insert {

        @XmlElements({
            @XmlElement(name = "field", type = GridField.class),
            @XmlElement(name = "button", type = GridButton.class),
            @XmlElement(name = "toolbar", type = Toolbar.class),
            @XmlElement(name = "menubar", type = Menubar.class),
            @XmlElement(name = "menu", type = MenubarMenu.class),
            @XmlElement(name = "item", type = MenubarMenuItem.class),
            @XmlElement(name = "divider", type = MenubarMenuDivider.class),
            @XmlElement(name = "help", type = Help.class),
            @XmlElement(name = "hilite", type = Hilite.class)
        })
        protected List<Object> fieldOrButtonOrToolbar;
        @XmlAttribute(name = "position", required = true)
        protected Position position;

        /**
         * Gets the value of the fieldOrButtonOrToolbar property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the fieldOrButtonOrToolbar property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFieldOrButtonOrToolbar().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GridField }
         * {@link GridButton }
         * {@link Toolbar }
         * {@link Menubar }
         * {@link MenubarMenu }
         * {@link MenubarMenuItem }
         * {@link MenubarMenuDivider }
         * {@link Help }
         * {@link Hilite }
         * 
         * 
         */
        public List<Object> getFieldOrButtonOrToolbar() {
            if (fieldOrButtonOrToolbar == null) {
                fieldOrButtonOrToolbar = new ArrayList<Object>();
            }
            return this.fieldOrButtonOrToolbar;
        }

        /**
         * Gets the value of the position property.
         * 
         * @return
         *     possible object is
         *     {@link Position }
         *     
         */
        public Position getPosition() {
            return position;
        }

        /**
         * Sets the value of the position property.
         * 
         * @param value
         *     allowed object is
         *     {@link Position }
         *     
         */
        public void setPosition(Position value) {
            this.position = value;
        }

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
     *       &lt;attribute name="source" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="position" use="required" type="{http://axelor.com/xml/ns/object-views}Position" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Move {

        @XmlAttribute(name = "source", required = true)
        protected String source;
        @XmlAttribute(name = "position", required = true)
        protected Position position;

        /**
         * Gets the value of the source property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSource() {
            return source;
        }

        /**
         * Sets the value of the source property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSource(String value) {
            this.source = value;
        }

        /**
         * Gets the value of the position property.
         * 
         * @return
         *     possible object is
         *     {@link Position }
         *     
         */
        public Position getPosition() {
            return position;
        }

        /**
         * Sets the value of the position property.
         * 
         * @param value
         *     allowed object is
         *     {@link Position }
         *     
         */
        public void setPosition(Position value) {
            this.position = value;
        }

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
     *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
     *         &lt;group ref="{http://axelor.com/xml/ns/object-views}ExtendGridItems"/&gt;
     *       &lt;/choice&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "fieldOrButtonOrToolbar"
    })
    public static class Replace {

        @XmlElements({
            @XmlElement(name = "field", type = GridField.class),
            @XmlElement(name = "button", type = GridButton.class),
            @XmlElement(name = "toolbar", type = Toolbar.class),
            @XmlElement(name = "menubar", type = Menubar.class),
            @XmlElement(name = "menu", type = MenubarMenu.class),
            @XmlElement(name = "item", type = MenubarMenuItem.class),
            @XmlElement(name = "divider", type = MenubarMenuDivider.class),
            @XmlElement(name = "help", type = Help.class),
            @XmlElement(name = "hilite", type = Hilite.class)
        })
        protected List<Object> fieldOrButtonOrToolbar;

        /**
         * Gets the value of the fieldOrButtonOrToolbar property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the fieldOrButtonOrToolbar property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFieldOrButtonOrToolbar().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GridField }
         * {@link GridButton }
         * {@link Toolbar }
         * {@link Menubar }
         * {@link MenubarMenu }
         * {@link MenubarMenuItem }
         * {@link MenubarMenuDivider }
         * {@link Help }
         * {@link Hilite }
         * 
         * 
         */
        public List<Object> getFieldOrButtonOrToolbar() {
            if (fieldOrButtonOrToolbar == null) {
                fieldOrButtonOrToolbar = new ArrayList<Object>();
            }
            return this.fieldOrButtonOrToolbar;
        }

    }

}