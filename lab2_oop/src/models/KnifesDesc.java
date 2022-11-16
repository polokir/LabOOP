//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.06.22 at 01:31:49 PM EEST
//


package models;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.math.BigInteger;



/**
 * <p>Java class for knifeDesc complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="knifeDesc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="knifeType">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="knife"/>
 *               &lt;enumeration value="dagger"/>
 *               &lt;enumeration value="saber"/>
 *               &lt;enumeration value="sword"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="knifeHandy">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;minInclusive value="1"/>
 *               &lt;maxInclusive value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="knifeOrigin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="knifeVisual">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="knifeBlade">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="length" use="required" type="{}bladeSize" />
 *                           &lt;attribute name="width" use="required" type="{}bladeSize" />
 *                           &lt;attribute name="metal" use="required" type="{}metalType" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="knifeHandle">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;choice>
 *                             &lt;element name="wood">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="type" use="required" type="{}woodType" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="leatherCoated" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                             &lt;element name="plastic" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                           &lt;/choice>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="collection" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "knifeDesc", propOrder = {
        "knifeType",
        "knifeHandy",
        "knifeOrigin",
        "knifeVisual",
        "collection"
})
public class KnifesDesc {

    @XmlElement(required = true)
    protected String knifeType;
    protected int knifeHandy;
    @XmlElement(required = true)
    protected String knifeOrigin;
    @XmlElement(required = true)
    protected KnifesDesc.KnifeVisual knifeVisual;
    protected boolean collection;
    @XmlAttribute(name = "name")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String name;

    /**
     * Gets the value of the knifeType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getKnifeType() {
        return knifeType;
    }

    /**
     * Sets the value of the knifeType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setKnifeType(String value) {
        this.knifeType = value;
    }

    /**
     * Gets the value of the knifeHandy property.
     */
    public int getKnifeHandy() {
        return knifeHandy;
    }

    /**
     * Sets the value of the knifeHandy property.
     */
    public void setKnifeHandy(int value) {
        this.knifeHandy = value;
    }

    /**
     * Gets the value of the knifeOrigin property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getKnifeOrigin() {
        return knifeOrigin;
    }

    /**
     * Sets the value of the knifeOrigin property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setKnifeOrigin(String value) {
        this.knifeOrigin = value;
    }

    /**
     * Gets the value of the knifeVisual property.
     *
     * @return possible object is
     * {@link KnifesDesc.KnifeVisual }
     */
    public KnifesDesc.KnifeVisual getKnifeVisual() {
        return knifeVisual;
    }

    /**
     * Sets the value of the knifeVisual property.
     *
     * @param value allowed object is
     *              {@link KnifesDesc.KnifeVisual }
     */
    public void setKnifeVisual(KnifesDesc.KnifeVisual value) {
        this.knifeVisual = value;
    }

    /**
     * Gets the value of the collection property.
     */
    public boolean isCollection() {
        return collection;
    }

    /**
     * Sets the value of the collection property.
     */
    public void setCollection(boolean value) {
        this.collection = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * <p>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="knifeBlade">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="length" use="required" type="{}bladeSize" />
     *                 &lt;attribute name="width" use="required" type="{}bladeSize" />
     *                 &lt;attribute name="metal" use="required" type="{}metalType" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="knifeHandle">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice>
     *                   &lt;element name="wood">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="type" use="required" type="{}woodType" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="leatherCoated" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *                   &lt;element name="plastic" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "knifeBlade",
            "knifeHandle"
    })
    public static class KnifeVisual {

        @XmlElement(required = true)
        protected KnifesDesc.KnifeVisual.KnifeBlade knifeBlade;
        @XmlElement(required = true)
        protected KnifesDesc.KnifeVisual.KnifeHandle knifeHandle;

        /**
         * Gets the value of the knifeBlade property.
         *
         * @return possible object is
         * {@link KnifesDesc.KnifeVisual.KnifeBlade }
         */
        public KnifesDesc.KnifeVisual.KnifeBlade getKnifeBlade() {
            return knifeBlade;
        }

        /**
         * Sets the value of the knifeBlade property.
         *
         * @param value allowed object is
         *              {@link KnifesDesc.KnifeVisual.KnifeBlade }
         */
        public void setKnifeBlade(KnifesDesc.KnifeVisual.KnifeBlade value) {
            this.knifeBlade = value;
        }

        /**
         * Gets the value of the knifeHandle property.
         *
         * @return possible object is
         * {@link KnifesDesc.KnifeVisual.KnifeHandle }
         */
        public KnifesDesc.KnifeVisual.KnifeHandle getKnifeHandle() {
            return knifeHandle;
        }

        /**
         * Sets the value of the knifeHandle property.
         *
         * @param value allowed object is
         *              {@link KnifesDesc.KnifeVisual.KnifeHandle }
         */
        public void setKnifeHandle(KnifesDesc.KnifeVisual.KnifeHandle value) {
            this.knifeHandle = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * <p>
         * <p>The following schema fragment specifies the expected content contained within this class.
         * <p>
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="length" use="required" type="{}bladeSize" />
         *       &lt;attribute name="width" use="required" type="{}bladeSize" />
         *       &lt;attribute name="metal" use="required" type="{}metalType" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class KnifeBlade {

            @XmlAttribute(name = "length", required = true)
            protected BigInteger length;
            @XmlAttribute(name = "width", required = true)
            protected BigInteger width;
            @XmlAttribute(name = "metal", required = true)
            protected MetalType metal;

            /**
             * Gets the value of the length property.
             *
             * @return possible object is
             * {@link BigInteger }
             */
            public BigInteger getLength() {
                return length;
            }

            /**
             * Sets the value of the length property.
             *
             * @param value allowed object is
             *              {@link BigInteger }
             */
            public void setLength(BigInteger value) {
                this.length = value;
            }

            /**
             * Gets the value of the width property.
             *
             * @return possible object is
             * {@link BigInteger }
             */
            public BigInteger getWidth() {
                return width;
            }

            /**
             * Sets the value of the width property.
             *
             * @param value allowed object is
             *              {@link BigInteger }
             */
            public void setWidth(BigInteger value) {
                this.width = value;
            }

            /**
             * Gets the value of the metal property.
             *
             * @return possible object is
             * {@link MetalType }
             */
            public MetalType getMetal() {
                return metal;
            }

            /**
             * Sets the value of the metal property.
             *
             * @param value allowed object is
             *              {@link MetalType }
             */
            public void setMetal(MetalType value) {
                this.metal = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * <p>
         * <p>The following schema fragment specifies the expected content contained within this class.
         * <p>
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;choice>
         *         &lt;element name="wood">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="type" use="required" type="{}woodType" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="leatherCoated" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
         *         &lt;element name="plastic" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
         *       &lt;/choice>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "wood",
                "leatherCoated",
                "plastic"
        })
        public static class KnifeHandle {

            protected KnifesDesc.KnifeVisual.KnifeHandle.Wood wood;
            protected Object leatherCoated;
            protected Object plastic;

            /**
             * Gets the value of the wood property.
             *
             * @return possible object is
             * {@link KnifesDesc.KnifeVisual.KnifeHandle.Wood }
             */
            public KnifesDesc.KnifeVisual.KnifeHandle.Wood getWood() {
                return wood;
            }

            /**
             * Sets the value of the wood property.
             *
             * @param value allowed object is
             *              {@link KnifesDesc.KnifeVisual.KnifeHandle.Wood }
             */
            public void setWood(KnifesDesc.KnifeVisual.KnifeHandle.Wood value) {
                this.wood = value;
            }

            /**
             * Gets the value of the leatherCoated property.
             *
             * @return possible object is
             * {@link Object }
             */
            public Object getLeatherCoated() {
                return leatherCoated;
            }

            /**
             * Sets the value of the leatherCoated property.
             *
             * @param value allowed object is
             *              {@link Object }
             */
            public void setLeatherCoated(Object value) {
                this.leatherCoated = value;
            }

            /**
             * Gets the value of the plastic property.
             *
             * @return possible object is
             * {@link Object }
             */
            public Object getPlastic() {
                return plastic;
            }

            /**
             * Sets the value of the plastic property.
             *
             * @param value allowed object is
             *              {@link Object }
             */
            public void setPlastic(Object value) {
                this.plastic = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * <p>
             * <p>The following schema fragment specifies the expected content contained within this class.
             * <p>
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="type" use="required" type="{}woodType" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Wood {

                @XmlAttribute(name = "type", required = true)
                protected WoodType type;

                /**
                 * Gets the value of the type property.
                 *
                 * @return possible object is
                 * {@link WoodType }
                 */
                public WoodType getType() {
                    return type;
                }

                /**
                 * Sets the value of the type property.
                 *
                 * @param value allowed object is
                 *              {@link WoodType }
                 */
                public void setType(WoodType value) {
                    this.type = value;
                }

            }

        }

    }

}