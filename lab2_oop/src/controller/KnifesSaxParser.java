package controller;

import models.Knifes;
import models.KnifesDesc;
import models.KnifesDesc.KnifeVisual.KnifeBlade;
import models.KnifesDesc.KnifeVisual.KnifeHandle;
import models.KnifesDesc.KnifeVisual.KnifeHandle.Wood;
import models.MetalType;
import models.WoodType;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.math.BigInteger;
import java.util.List;

class KnifesDocHandler extends DefaultHandler {
    private String currentElem;
    private KnifesDesc currentKnife;
    private List<KnifesDesc> knifes;
    private StringBuffer buffer = new StringBuffer();

    public List<KnifesDesc> getKnifes() {
        return knifes;
    }

    @Override
    public void startDocument() {
        System.out.println("SAX parser start...");
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        String data = null;
        currentElem = qName;
        try {
            switch (currentElem) {
                case "knifes":
                    knifes = new Knifes().getKnife();
                    break;

                case "knife":
                    currentKnife = new KnifesDesc();

                    data = attributes.getValue("name");

                    if (data == null) {
                        throw new SAXException("width");
                    } else {
                        currentKnife.setName(data);
                    }
                    break;

                case "knifeType":
                case "knifeHandy":
                case "knifeOrigin":
                    break;

                case "knifeVisual":
                    currentKnife.setKnifeVisual(new KnifesDesc.KnifeVisual());
                    break;

                case "knifeBlade":
                    KnifeBlade blade = new KnifeBlade();

                    // set blade attributes
                    data = attributes.getValue("length");
                    if (data == null) {
                        throw new SAXException("width");
                    } else {
                        try {
                            blade.setLength(new BigInteger(data));
                        } catch (NumberFormatException e) {
                            throw new SAXException("width");                        }
                    }

                    data = attributes.getValue("width");
                    if (data == null) {
                        throw new SAXException("width");
                    } else {
                        try {
                            blade.setWidth(new BigInteger(data));
                        } catch (NumberFormatException e) {
                            throw new SAXException("width");
                        }
                    }

                    data = attributes.getValue("metal");
                    if (data == null) {
                        throw new SAXException("metal");
                    } else {
                        try {
                            blade.setMetal(MetalType.fromValue(data));
                        } catch (IllegalArgumentException e) {
                            throw new SAXException("metal");
                        }
                    }

                    currentKnife.getKnifeVisual().setKnifeBlade(blade);
                    break;

                case "knifeHandle":
                    currentKnife.getKnifeVisual().setKnifeHandle(new KnifeHandle());
                    break;

                case "wood":
                    Wood wood = new Wood();

                    data = attributes.getValue("type");
                    if (data == null) {
                        throw new SAXException("type");
                    } else {
                        try {
                            wood.setType(WoodType.fromValue(data));
                        } catch (IllegalArgumentException e) {
                            throw new SAXException();
                        }
                    }

                    currentKnife.getKnifeVisual().getKnifeHandle().setWood(wood);
                    break;

                case "leatherCoated":
                    currentKnife.getKnifeVisual().getKnifeHandle().setLeatherCoated(new Object());
                    break;

                case "plastic":
                    currentKnife.getKnifeVisual().getKnifeHandle().setPlastic(new Object());
                    break;

                case "collection":
                    break;

                default:

                    // element not found
                    currentKnife = null;
                    throw new SAXException("Unknown element " + qName);
            }
        } catch (SAXException exception) {

            // required attribute is missing
            throw new SAXException();
        } catch (Exception e) {

            // wrong attribute value
            throw new SAXException();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (currentElem.equals("knifeType") ||
                currentElem.equals("knifeHandy") ||
                currentElem.equals("knifeOrigin") ||
                currentElem.equals("collection")) {

            buffer.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        String data = buffer.toString().trim();

        switch (qName) {

            case "knife":
                knifes.add(currentKnife);
                break;

            case "knifeType":
                currentKnife.setKnifeType(data);
                break;

            case "knifeHandy":
                currentKnife.setKnifeHandy(Integer.parseInt(data));
                break;

            case "knifeOrigin":
                currentKnife.setKnifeOrigin(data);
                break;

            case "collection":
                currentKnife.setCollection(Boolean.parseBoolean(data));
                break;

            default:
                break;
        }

        buffer.setLength(0);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }
}




public class KnifesSaxParser {
    public List<KnifesDesc> parseDocument(String filename) {
        try {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            KnifesDocHandler docHandler = new KnifesDocHandler();

            if (docHandler != null) {
                parser.parse(new File(filename), docHandler);

                return docHandler.getKnifes();
            }
        } catch (Exception e) {
            System.out.println("SAX parser: error while parsing document");
        }

        return null;
    }
}